from typing import List

from Staff import Staff
from Course import Course
from TimeInterval import TimeInterval


import logging

logging.basicConfig(
    filename="logs.log",
    level=logging.INFO,
    format="%(asctime)s:%(levelname)s:%(message)s",
)


class Lecturer(Staff):
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
        students=None,
        courses: List[Course] = None,
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
        self.__students = students if students is not None else []
        self.__courses = courses if courses is not None else []

    def init_courses(self):
        json = DataUtils.get_instance()
        all_courses = (
            json.read_mandatory_courses()
            + json.read_technical_elective_course()
            + json.read_non_technical_elective_courses()
        )
        new_courses = []
        for course in all_courses:
            if (
                isinstance(course, SectionInterface)
                and course.get_lecturer().username == self.username
            ):
                if not any(
                    c.get_short_name() == course.get_short_name()
                    and c.get_section_name() == course.get_section_name()
                    for c in self.__courses
                ):
                    new_courses.append(course)
        if not self.__courses:
            self.__courses = new_courses
        else:
            self.__courses.extend(new_courses)

    @property
    def lectured_courses(self):
        self.init_courses()
        return self.__courses

    def add_lectured_course(self, course):
        course.set_lecturer(self)
        json = DataUtils.get_instance()
        if isinstance(course, MandatoryCourse):
            courses = json.read_mandatory_courses()
            courses.append(course)
            json.write_mandatory_courses(courses)
        elif isinstance(course, TechnicalElectiveCourse):
            courses = json.read_technical_elective_course()
            courses.append(course)
            json.write_technical_elective_course(courses)
        elif isinstance(course, NonTechnicalElectiveCourse):
            courses = json.read_non_technical_elective_courses()
            courses.append(course)
            json.write_non_technical_elective_courses(courses)
        self.init_courses()
        return True

    def delete_lectured_course(self, course):
        data_utils = DataInitializer()
        courses = data_utils.courses
        all_courses = (
            json.read_mandatory_courses()
            + json.read_technical_elective_course()
            + json.read_non_technical_elective_courses()
        )
        for c in all_courses:
            if c.get_short_name() == course.get_short_name() and isinstance(
                course, type(c)
            ):
                all_courses.remove(c)
                break
        # Update the respective course lists
        json.write_mandatory_courses(
            [c for c in all_courses if isinstance(c, MandatoryCourse)]
        )
        json.write_technical_elective_course(
            [c for c in all_courses if isinstance(c, TechnicalElectiveCourse)]
        )
        json.write_non_technical_elective_courses(
            [c for c in all_courses if isinstance(c, NonTechnicalElectiveCourse)]
        )
        self.init_courses()
        return True

    def view_enrolled_students(self, course):
        data_utils = DataInitializer()
        students = data_utils.read_students()
        enrolled_students = []

        for student in students:
            selected_courses = student.get_selected_courses()
            for selected_course in selected_courses:
                if selected_course.get_short_name() == course.get_short_name():
                    if isinstance(
                        selected_course,
                        (
                            MandatoryCourse,
                            TechnicalElectiveCourse,
                            NonTechnicalElectiveCourse,
                        ),
                    ):
                        if (
                            selected_course.get_lecturer().get_username()
                            == self.get_username()
                        ):
                            enrolled_students.append(student)

        return enrolled_students

    # Abstract shoul be implement in menu

    def getInformationMenu(self):
        print("Personal Information")
        print(f"Name: {self.get_full_name()}")
        print(f"Reputation: {self.reputation}")
        print(f"Student Count: {len(self.__students)}")
        print("Courses given:")
        for course in self.__courses:
            print(course)

    def getMenu(self):
        print(f"Welcome {self.getFullName()}")
        print("1- Add Courses")
        print("2- Information")
        print("3- Logout")

        while True:
            try:
                selection = int(input())
            except:
                print("Invalid choice. Please try again.")
                continue

            if selection == 1:
                self.getManipulationMenu()
                self.getMenu()
            elif selection == 2:
                self.getInformationMenu()
                self.getMenu()
            elif selection == 3:
                import Controller
            else:
                print("Invalid choice. Please try again.")

    def add_course(self, course):
        self.__courses.append(course)

    def getManipulationMenu():
        print("Enter the course code (eg: CSE1001, -1 to exit):")
        course_code = input()
        if course_code == "-1":
            return

        course_name = input(
            "Enter the course name (eg: Introduction to Computer Science):\n"
        )
        course_description = input(
            "Enter the course description (eg: This course is an introduction to computer science):\n"
        )
        course_prerequisites = input(
            "Enter the course prerequisites (eg: CSE101,CSE102):\n"
        ).split(",")

        course_semester = int(input("Enter the course semester (eg: 1):\n"))
        course_credit = int(input("Enter the course credit (eg: 3):\n"))
        course_class_hours = int(input("Enter the class hours (eg: 3):\n"))

        print(
            "Enter the course type:\n\t 1. Mandatory\n\t 2. Technical Elective\n\t 3. NonTechnical Elective"
        )
        course_type = int(input())

        section_name = input("Enter the course section name (eg: 1.1):\n")
        quota = int(input("Enter the course quota (eg: 30):\n"))
        location = input("Enter the course location (eg: M1Z11):\n")

        dates = []
        while True:
            day = input("Enter the course day (eg: Monday, -1 to exit):\n")
            if day == "-1":
                break

            start_time = input("Enter the course start time (eg: 09:30):\n")
            end_time = self.get_end_time(start_time)

            if end_time == "":
                print("Invalid time")
                continue

            dates.append(TimeInterval(day, start_time, end_time))

        if course_type == 1:
            lab_hours = int(
                input(
                    "Enter the course lab hours (eg: 3, 0 if there are no lab hours):\n"
                )
            )
            course = MandatoryCourse(
                course_code,
                course_name,
                course_description,
                course_prerequisites,
                course_semester,
                course_credit,
                course_class_hours,
                dates,
                section_name,
                quota,
                location,
                lab_hours,
            )
        elif course_type == 2:
            required_credit = int(input("Enter the course required credit (eg: 60):\n"))
            course = TechnicalElectiveCourse(
                course_code,
                course_name,
                course_description,
                course_prerequisites,
                course_semester,
                course_credit,
                course_class_hours,
                dates,
                section_name,
                quota,
                location,
                required_credit,
            )
        elif course_type == 3:
            is_remote = (
                input("Enter if the course is remote (true or false):\n").lower()
                == "true"
            )
            course = NonTechnicalElectiveCourse(
                course_code,
                course_name,
                course_description,
                course_prerequisites,
                course_semester,
                course_credit,
                course_class_hours,
                dates,
                section_name,
                quota,
                location,
                is_remote,
            )
        else:
            print("Invalid course type")
            return

        self.add_lectured_course(course)

    def get_end_time(self, start_time):
        end_times = {
            "09:30": "10:20",
            "10:30": "11:20",
            "11:30": "12:20",
            "13:00": "13:50",
            "14:00": "14:50",
            "15:00": "15:50",
            "16:00": "16:50",
        }
        return end_times.get(start_time, "")

    def to_json(self):
        return {
            "personName": self.personName,
            "personSurname": self.personSurname,
            "username": self.username,
            "password": self.password,
            "reputation": self.reputation,
            "officeHours": [d.to_json() for d in self.office_hours],
            "salary": self.salary,
            "employmentStatus": self.employment_status,
            "courses": [
                {"shortName": course.short_name, "sectionName": course.section_name}
                for course in self.__courses
            ],
        }
