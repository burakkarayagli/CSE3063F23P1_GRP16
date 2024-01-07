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

    def __addStudent(self, student):
        return self.students.append(student)

    def __deleteStudent(self, student):
        return self.students.remove(student)

    def __studentCourseOrganization(self):
        num = 0
        for i, student in enumerate(self.students):
            print("Eligible Students")
            print("Please select one of them")
            print(f"{i + 1} {student.getFullName()}") #'ll change

        num = int(input())
        student = self.students[num - 1]
        combined_course_list = self.__getCombinedCourses(student) 

        for i, course in enumerate(combined_course_list):
            print(f"{i + 1} {course.__full_name} {course.__short_name}")

        selection = int(input())
        chosen_course = combined_course_list[selection - 1]

        if chosen_course in student.__waitingCourses:  #'ll change
            print("Course chosen by the student has been dropped.")
            student.dropCourse(chosen_course)
        else:
            print("Course has been added to the list of the student.")
            student.add_course(chosen_course)

    def __getCombinedCourses(self, student):
        combined_courses = (
            student.__waitingCourses + student.getAvailableCourses() #'ll change
        )
        return combined_courses

    def __rejectStudent(self, student, selections):
        try:
            if selections == "*":
                student.status("Rejected")
                student.__waitingCourses.clear() #'ll change
                return True
            else:
                rejected_courses = [
                    student.__waitingCourses[int(selection) - 1] #'ll change
                    for selection in selections.split(",")
                ]

                for rejected_course in rejected_courses:
                    student.dropCourse(rejected_course)

            student.status("Rejected")
            # save the advisors
            data_utils = DataInitializer()
            advisors = data_utils.advisors
            for i, advisor in enumerate(advisors):
                if advisor.get_username == self.get_username(): #'ll change
                    advisors[i] = self
            data_utils.write_advisor(advisors)

            students = data_utils.students
            for i, s in enumerate(students):
                if s.get_username() == student.get_username(): #'ll change
                    students[i] = student
            data_utils.write_student(students)

            return True
        except Exception as e:
            raise Exception("Input must only include numbers. Please try again.") from e

    def __approveStudent(self, student, selections):
        try:
            if selections[0] == 0 and len(selections) == 1:
                student.status("Approved")
                # save the advisors
                data_utils = DataInitializer()
                advisors = data_utils.advisors 
                for i, advisor in enumerate(advisors):
                    if advisor.username == self.username: #'ll change
                        advisors[i] = self
                data_utils.write_advisor(advisors) #'ll change

                students = data_utils.students
                for i, s in enumerate(students):
                    if s.username == student.username: #'ll change
                        students[i] = student
                data_utils.write_student(students)

                return True
            else:
                status = False
                exists = False

                for i in range(len(student.__waitingCourses), 0, -1): #'ll change
                    exists = False

                    for j in range(len(selections), 0, -1):
                        if selections[j - 1] == i:
                            exists = True
                            break

                    if not exists:
                        student.dropCourse(student.__waitingCourses[i - 1]) #'ll change
                        status = True

                student.status("Rejected" if status else "Approved")

            # save the advisors
            data_utils = DataInitializer()
            advisors = data_utils.advisors
            for i, advisor in enumerate(advisors):
                if advisor.username == self.username:
                    advisors[i] = self
            data_utils.write_advisor(advisors) #'ll change

            students = data_utils.students
            for i, s in enumerate(students):
                if s.username == student.username:
                    students[i] = student
            data_utils.write_student(students)

            return True
        except Exception as e:
            print(f"Error in Advisor.py approve_student: {e}")
            return False

    # def getMenu(self):
    #     student_selection = 0

    #     while student_selection < 1 or student_selection > len(
    #         self.advisorController.get_students()
    #     ):
    #         print("Which student do you want to go on?\nType -1 for exit")

    #         for j, student in enumerate(self.__students):
    #             print(f"{j + 1}- {student.getFullName()}", end="")
    #             # TODO: change acording to status
    #             if student.status == "Rejected":
    #                 print(" (Rejected)")
    #             elif student.status == "Approved":
    #                 print(" (Approved)")
    #             elif student.status == "Waiting":
    #                 print(" (Waiting)")
    #             else:
    #                 print()

    #         try:
    #             student_selection = int(input())
    #         except ValueError:
    #             print("Invalid choice. Please try again.")

    #         if student_selection == -1:
    #             # Controller is the not class so run directly from the file
    #             import Controller

    #     student = self.advisorController.get_students()[student_selection - 1]

    #     print(f"List of courses for student {student.get_full_name()}")

    #     courses_of_student = student.get_selected_courses()

    #     if student.get_status() in ["Rejected", "Approved"]:
    #         print("Approve/Reject process is already done for this student.\n")
    #     else:
    #         for i, course in enumerate(courses_of_student):
    #             print(f"{i + 1} -> {course.get_full_name()} {course.get_short_name()}")

    #         print(
    #             "Please enter the courses you want to approve for the student \n"
    #             "Type * to approve all courses\n"
    #             "The non-chosen ones will automatically be rejected\n"
    #             "Type -1 for exit\n"
    #             "Selection/s: "
    #         )

    #         selections = input()
    #         if selections == "-1":
    #             self.getMenu()
    #             return

    #         sorted_selections = []
    #         while True:
    #             if selections == "*":
    #                 sorted_selections.append(0)
    #                 self.__approveStudent(student, sorted_selections)
    #                 break
    #             else:
    #                 if not self.is_valid_format(selections):
    #                     print(
    #                         "Invalid format. Please enter a valid comma-separated list of numbers.\n"
    #                     )
    #                 else:
    #                     sorted_selections = self.sort_numbers(selections)

    #                     if sorted_selections[0] <= 0:
    #                         print("Invalid input. Please stay in bounds.\n")
    #                     else:
    #                         self.__approveStudent(student, sorted_selections)
    #                         break

    #                 print("Enter a comma-separated list of numbers: ")
    #                 selections = input()

    def __approveRejectStudent(self):
        student_selection = 0


        while student_selection < 1 or student_selection > len(self.__students):

            print("Which student do you want to go on?\nType -1 to back")

            for j, student in enumerate(self.__students):
                print(f"{j + 1}- {student.getFullName()}", end="")
                # TODO: change acording to status
                print(f"({student.status})")

            try:
                student_selection = int(input())
            except ValueError:
                print("Invalid choice. Please try again.")

            if student_selection == -1:
                self.getMenu()

        student = self.__students[student_selection - 1]

        print(f"List of courses for student {student.getFullName()}")

        while True:
            print("--------------------")
            student.printwaitingCourses()
            print("select only one, type -1 to exit")
            try:
                selection = int(input())
                if selection == -1:

                    break
                print("1- Approve")
                print("2- Reject")
                selection2 = int(input())
                if selection2 == 1:
                    student.approveCourseWithIndex(selection - 1)
                elif selection2 == 2:
                    student.rejectCourseWithIndex(selection - 1)
                else:
                    print("Invalid choice. Please try again.")
                    continue
            except:
                print("Invalid choice. Please try again.")
                continue

    def getMenu(self):
        # this is actually getMenu
        print(f"Welcome {self.getFullName()}")
        print("1- Manage Student Courses(Approve/Reject)")
        print("2- Information")
        print("3- Logout")

        try:
            selection = int(input())
        except ValueError:
            print("Invalid choice. Please try again.")
            self.getMenu()
            return

        if selection == 1:
            self.getManipulationMenu()
            self.getMenu()
        elif selection == 2:
            self.getInformationMenu()
            self.getMenu()
        elif selection == 3:
            import Controller

    def getInformationMenu(self):
        print("Personal Information")
        print(f"Name: {self.getFullName()}")
        print(f"Reputation: {self.reputation}")
        print(f"Student Count: {len(self.__students)}")
        print("Student Statuses: ")
        for student in self.__students:
            print(
                f"{student.getFullName()} - {'No Started' if student.status == '' else student.status}"
            )

    def getManipulationMenu(self):
        student_selection = 0

        while student_selection < 1 or student_selection > len(self.__students):
            print("Which student do you want to go on?\nType -1 to back")

            for j, student in enumerate(self.__students):
                print(f"{j + 1}- {student.getFullName()}", end="")
                print(f"({student.getWaitingCoursesLength()} Pending)")

            try:
                student_selection = int(input())
            except ValueError:
                print("Invalid choice. Please try again.")

            if student_selection == -1:
                self.getMenu()

        student = self.__students[student_selection - 1]

        print(f"List of courses for student {student.getFullName()}")
        print(student.getWarnings())
        while True:
            print("--------------------")
            student.printwaitingCourses()
            print("select only one, type -1 to exit")
            try:
                selection = int(input())
                if selection == -1:
                    break
                print("1- Approve")
                print("2- Reject")
                selection2 = int(input())
                if selection2 == 1:
                    student.approveCourseWithIndex(selection - 1)
                elif selection2 == 2:
                    student.rejectCourseWithIndex(selection - 1)
                else:
                    print("Invalid choice. Please try again.")
                    continue
            except:
                print("Invalid choice. Please try again.")
                continue
        # write student here
        student.write()
        self.getMenu()

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

    def add_student(self, student):
        self.__students.append(student)

    def toJson(self):
        return {
            "personName": self.__personName,
            "personSurname": self.__personSurname,
            "username": self.__username,
            "password": self.__password,
            "reputation": self.__reputation,
            "officeHours": [
                timeInterval.to_json() for timeInterval in self.__office_hours
            ],
            "salary": self.__salary, #'ll change
            "employmentStatus": self.__employment_status, #'ll change
            "students": [student.password for student in self.__students],
        }
