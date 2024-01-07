from typing import List
from TimeInterval import TimeInterval

from Course import Course
from Lecturer import Lecturer


class CourseSection(Course):
    def __init__(
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
            full_name=course.full_name,
            description=course.description,
            semester=course.semester,
            credit=course.credit,
            prerequisite=course.get_prerequisites().split(","),
        )
        self.__dates = dates
        self.__section_name = section_name
        self.__lecturer = lecturer
        self.__quota = quota
        self.__number_of_student = number_of_student
        self.__required_credit = required_credit
        self.__type = type

    # shoul be remove // can be use check_overlap etc. methods
    @property
    def dates(self) -> List[TimeInterval]:
        return self.__dates

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

    def get_full_name(self) -> str:
        return self.short_name + " " + self.__section_name

    def get_lecturer_full_name(self) -> str:
        return self.__lecturer.getFullName()

    def to_json(self):
        return {
            "shortName": self.short_name,
            "fullName": self.full_name,
            "description": self.description,
            "semester": self.semester,
            "credit": self.credit,
            "prerequisite": list(self._Course__prerequisite),
            "dates": [d.to_json() for d in self.__dates],
            "sectionName": self.__section_name,
            "lecturer": self.__lecturer.password,
            "quota": self.__quota,
            "numberOfStudent": self.__number_of_student,
            "requiredCredit": self.__required_credit,
            "type": self.__type,
        }

    def __eq__(self, other):
        if (
            self._Course__short_name == other._Course__short_name
            and self.__section_name == other.section_name
        ):
            return True

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
            f"Lecturer Name: {self.__lecturer.getFullName()}\n"
            f"Dates: {', '.join([d.__str__() for d in self.__dates])}\n"
        )

    def __eq__(self, other):
        if not isinstance(other, CourseSection):
            return False
        return (
            self.short_name == other.short_name
            and self.__section_name == other.__section_name
        )
