
from types import List
from Staff import Staff
from TimeInterval import TimeInterval
from Student import Student

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
        students: List[Student]
    ):
        super().__init__(
            person_name, 
            person_surname, 
            username, 
            password
            )
        self.__reputation = reputation
        self.__office_hours = office_hours
        self.__salary = salary
        self.__employment_status = employment_status
        self.__students = students
        
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
        combined_courses = student.get_selected_courses() + student.get_available_courses()
        return combined_courses

    def __rejectStudent(self, student, selections):
        try:
            if selections == "*":
                student.set_status("Rejected")
                student.get_selected_courses().clear()
                return True
            else:
                rejected_courses = [student.get_selected_courses()[int(selection) - 1] for selection in selections.split(",")]

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
