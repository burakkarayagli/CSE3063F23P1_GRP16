from typing import List

from Student import Student
from Staff import Staff
from TimeInterval import TimeInterval


class Advisor(Staff):
    def __init__(
        self,
        person_name: str,
        person_surname: str,
        username: str,
        password: str,
        reputation: str,
        office_hours: List[TimeInterval],
        salary: int,
        employment_status: str,
        students: List[Student],
    ):
        super().__init__(

            person_name,
            person_surname,
            username,
            password,
            reputation,
            office_hours,
            salary,
            employment_status,
        )
        self.__students = [] if students is None else students

    @property
    def students(self):
        return self.students

    @students.setter
    def students(self, students):
        self.students = students

    def __addStudent(self, student):
        return self.students.append(student)

    def __deleteStudent(self, student):
        return self.students.remove(student)

    def __studentCourseOrganization(self):
        num = 0
        for i, student in enumerate(self.students):
            print("Eligible Students")
            print("Please select one of them")
            print(f"{i + 1} {student.get_full_name()}")

        num = int(input())
        student = self.students[num - 1]
        combined_course_list = self.get_combined_courses(student)

        for i, course in enumerate(combined_course_list):
            print(f"{i + 1} {course.get_full_name()}")

        selection = int(input())
        chosen_course = combined_course_list[selection - 1]

        if chosen_course in student.get_selected_courses():
            print("Course chosen by the student has been dropped.")
            student.drop_course(chosen_course)
        else:
            print("Course has been added to the list of the student.")
            student.add_course(chosen_course)

    def __getCombinedCourses(self, student):
        combined_courses = (
            student.get_selected_courses() + student.get_available_courses()
        )
        return combined_courses

    def __rejectStudent(self, student, selections):
        try:
            if selections == "*":
                student.set_status("Rejected")
                student.get_selected_courses().clear()
                return True
            else:
                rejected_courses = [
                    student.get_selected_courses()[int(selection) - 1]
                    for selection in selections.split(",")
                ]

                for rejected_course in rejected_courses:
                    student.drop_course(rejected_course)

            student.set_status("Rejected")
            # save the advisors
            data_utils = DataUtils.get_instance()
            advisors = data_utils.get_advisors()
            for i, advisor in enumerate(advisors):
                if advisor.get_username() == self.get_username():
                    advisors[i] = self
            data_utils.write_advisors(advisors)

            students = data_utils.get_students()
            for i, s in enumerate(students):
                if s.get_username() == student.get_username():
                    students[i] = student
            data_utils.write_students(students)

            return True
        except Exception as e:
            raise Exception("Input must only include numbers. Please try again.") from e

    def __approveStudent(self, student, selections):
        try:
            if selections[0] == 0 and len(selections) == 1:
                student.set_status("Approved")
                # save the advisors
                data_utils = DataUtils.get_instance()
                advisors = data_utils.get_advisors()
                for i, advisor in enumerate(advisors):
                    if advisor.get_username() == self.get_username():
                        advisors[i] = self
                data_utils.write_advisors(advisors)

                students = data_utils.get_students()
                for i, s in enumerate(students):
                    if s.get_username() == student.get_username():
                        students[i] = student
                data_utils.write_students(students)

                return True
            else:
                status = False
                exists = False

                for i in range(len(student.get_selected_courses()), 0, -1):
                    exists = False

                    for j in range(len(selections), 0, -1):
                        if selections[j - 1] == i:
                            exists = True
                            break

                    if not exists:
                        student.drop_course(student.get_selected_courses()[i - 1])
                        status = True

                student.set_status("Rejected" if status else "Approved")

            # save the advisors
            data_utils = DataUtils.get_instance()
            advisors = data_utils.get_advisors()
            for i, advisor in enumerate(advisors):
                if advisor.get_username() == self.get_username():
                    advisors[i] = self
            data_utils.write_advisors(advisors)

            students = data_utils.get_students()
            for i, s in enumerate(students):
                if s.get_username() == student.get_username():
                    students[i] = student
            data_utils.write_students(students)

            return True
        except Exception as e:
            print(f"Error in Advisor.py approve_student: {e}")
            return False

    def getMenu(self):
        student_selection = 0

        while student_selection < 1 or student_selection > len(
            self.advisorController.get_students()
        ):
            print("Which student do you want to go on?\nType -1 for exit")

            for j, student in enumerate(self.advisorController.get_students()):
                print(f"{j + 1}- {student.getFullName()}", end="")

                if student.status == "Rejected":
                    print(" (Rejected)")
                elif student.status == "Approved":
                    print(" (Approved)")
                elif student.status == "Waiting":
                    print(" (Waiting)")
                else:
                    print()

            try:
                student_selection = int(input())
            except ValueError:
                print("Invalid choice. Please try again.")

            if student_selection == -1:
                menu = self.getMenu()
                return

        student = self.advisorController.get_students()[student_selection - 1]

        print(f"List of courses for student {student.get_full_name()}")

        courses_of_student = student.get_selected_courses()

        if student.get_status() in ["Rejected", "Approved"]:
            print("Approve/Reject process is already done for this student.\n")
        else:
            for i, course in enumerate(courses_of_student):
                print(f"{i + 1} -> {course.get_full_name()} {course.get_short_name()}")

            print(
                "Please enter the courses you want to approve for the student \n"
                "Type * to approve all courses\n"
                "The non-chosen ones will automatically be rejected\n"
                "Type -1 for exit\n"
                "Selection/s: "
            )

            selections = input()
            if selections == "-1":
                self.getMenu()
                return

            sorted_selections = []
            while True:
                if selections == "*":
                    sorted_selections.append(0)
                    self.__approveStudent(student, sorted_selections)
                    break
                else:
                    if not self.is_valid_format(selections):
                        print(
                            "Invalid format. Please enter a valid comma-separated list of numbers.\n"
                        )
                    else:
                        sorted_selections = self.sort_numbers(selections)

                        if sorted_selections[0] <= 0:
                            print("Invalid input. Please stay in bounds.\n")
                        else:
                            self.__approveStudent(student, sorted_selections)
                            break

                    print("Enter a comma-separated list of numbers: ")
                    selections = input()

    def is_valid_format(self, selections):
        selections = selections.replace(",", "").replace(" ", "")
        try:
            int_value = int(selections)
            return True
        except ValueError:
            print(f"Exception: {ValueError}\n")
            return False

    def sort_numbers(self, input_str):
        number_strings = input_str.split(",")
        numbers = [int(number_str) for number_str in number_strings]
        numbers.sort()

        return numbers

    def getStudent(self):
        return self.__students

    def add_student(self, student):
        self.__students.append(student)

    def getInformation():
        pass

    def getMenu():
        pass

    def toJson(self):
        return {
            "personName": self._Person__personName,
            "personSurname": self._Person__personSurname,
            "username": self._Person__username,
            "password": self._Person__password,
            "reputation": self._Staff__reputation,
            "officeHours": [
                timeInterval.to_json() for timeInterval in self._Staff__office_hours
            ],
            "salary": self._Staff__salary,
            "employmentStatus": self._Staff__employment_status,
            "students": [student.password for student in self.__students],
        }
