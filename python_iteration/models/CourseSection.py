from types import List
from TimeInterval import TimeInterval

from Course import Course
from Lecturer import Lecturer


class CourseSection(Course):
    def __int__(
        self,
        course: Course,
        dates: List[TimeInterval],
        section_name: str,
        lecturer: Lecturer,
        quota: int,
        number_of_student: int,
        required_credit: int,
        type: str,
    ):
        super().__init__(
            short_name=course.short_name,
            full_name=course.full_names,
            description=course.description,
            semester=course.semester,
            credit=course.credit,
            prerequisite=List[str](course.prerequisite.split(",")),
        )
        self.__dates = dates
        self.__section_name = section_name
        self.__lecturer = lecturer
        self.__quota = quota
        self.__number_of_student = number_of_student
        self.__required_credit = required_credit
        self.__type = type

    @property
    def section_name(self) -> str:
        return self.__section_name

    @section_name.setter
    def section_name(self, section_name: str):
        self.__section_name = section_name

    @property
    def quota(self) -> int:
        return self.__quota

    @quota.setter
    def quota(self, quota: int):
        self.__quota = quota

    @property
    def number_of_student(self) -> int:
        return self.__number_of_student

    @number_of_student.setter
    def number_of_student(self, number_of_student: int):
        if number_of_student > self.__quota:
            raise ValueError("Number of student cannot be greater than quota")
        self.__number_of_student = number_of_student

    @property
    def required_credit(self) -> int:
        return self.__required_credit

    @required_credit.setter
    def required_credit(self, required_credit: int):
        if required_credit < 0 or required_credit > 200:
            raise ValueError("Required credit must be between 0 and 200")
        self.__required_credit = required_credit

    def set_lecturer(self, lecturer: Lecturer):
        self.__lecturer = lecturer

    def add_dates(self, date: TimeInterval) -> bool:
        # check already have, if have return false
        for d in self.__dates:
            if d == date:
                return False
        self.__dates.append(date)
        return True

    def remove_dates(self, date: TimeInterval) -> bool:
        # find the if date exist, if exist remove it
        for d in self.__dates:
            if d == date:
                self.__dates.remove(date)
                return True
        return False

    def get_lecturer_username(self) -> str:
        return self.__lecturer.username

    def is_time_overlap(self, date: TimeInterval) -> bool:
        for d in self.__dates:
            if d == date:
                return True
        return False

    def check_overlap(self, course_section) -> bool:
        for d in self.__dates:
            if course_section.is_time_overlap(d):
                return True
        return False

    def __str__(self):
        return (
            f"---------\n"
            f"Course Information\n"
            f"Course Code: {self.short_name}\n"
            f"Course Name: {self.full_name}\n"
            f"Description: {self.description}\n"
            f"Prerequisite: {self.get_prerequisites()}\n"
            f"Semester: {self.semester}\n"
            f"Credit: {self.credit}\n"
            f"Section Name: {self.__section_name}\n"
            f"Quota: {self.__quota}\n"
            f"Number of Student: {self.__number_of_student}\n"
            f"Required Credit: {self.__required_credit}\n"
            f"Type: {self.__type}\n"
            f"Lecturer Name: {self.__lecturer.full_name}\n"
            f"Dates: {','.join([d.__str__() for d in self.__dates])}\n"
            f"---------"
        )
