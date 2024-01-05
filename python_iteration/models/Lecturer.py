from Staff import Staff
from DataInitializer import DataUtils

class Lecturer(Staff):
    def __init__(
        self,
        person_name,
        person_surname,
        username,
        password,
        reputation,
        office_hours,
        salary,
        employment_status,
        courses,
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
        self.__courses = [] if courses is None else courses

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
        json = DataUtils.get_instance()
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
        json = DataUtils.get_instance()
        students = json.read_students()
        enrolled_students = []
        for student in students:
            for selected_course in student.get_selected_courses():
                if (
                    selected_course.get_short_name() == course.get_short_name()
                    and isinstance(selected_course, type(course))
                    and selected_course.get_lecturer().username == self.username
                ):
                    enrolled_students.append(student)
        return enrolled_students

    def add_course(self, course):
        self.__courses.append(course)

    def get_courses(self):
        for course in self.__courses:
            print(course)

    def getInformationMenu(self):
        pass

    def getMenu():
        pass

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
