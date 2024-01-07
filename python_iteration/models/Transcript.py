from typing import List
from Grade import Grade
from Course import Course


class Transcript:
    GRADE_MAPPING = {
        "AA": 4.0,
        "BA": 3.5,
        "BB": 3.0,
        "CB": 2.5,
        "CC": 2.0,
        "DC": 1.5,
        "DD": 1.0,
        "FD": 0.5,
        "FF": 0.0,
    }

    def __init__(self, initial_grades: List[Grade] = None):
        self.__list_grades = [] if initial_grades is None else initial_grades

    def add_grade(self, grade: Grade) -> bool:
        self.__list_grades.append(grade)
        return True if grade is not None else False

    def delete_grade(self, grade: Grade) -> bool:
        try:
            self.__list_grades.remove(grade)
            return True
        except ValueError:
            return False

    def calculate_cumulative_gpa(self) -> float:
        total_sum = 0
        total_count = 0
        total_credit = 0
        for grade in self.__list_grades:
            credit = grade.course.credit
            numerical_grade = self.GRADE_MAPPING.get(grade.grade, 0.0)
            total_sum += numerical_grade * credit
            total_count += 1
            total_credit += credit
        if total_count == 0 or total_credit == 0:
            return 0.0
        return total_sum / total_credit

    def calculate_semester_gpa(self, semester: str) -> float:
        total_sum = 0
        total_count = 0
        total_credit = 0
        for grade in self.__list_grades:
            if grade.course.semester == semester:
                credit = grade.course.credit
                numerical_grade = self.GRADE_MAPPING.get(grade.grade, 0.0)
                total_sum += numerical_grade * credit
                total_count += 1
                total_credit += credit
        if total_count == 0 or total_credit == 0:
            return 0.0
        return total_sum / total_credit

    def is_course_passed(self, courseSection) -> bool:
        for grade in self.__list_grades:
            if (
                grade.get_course_short_name() == courseSection.short_name
                and grade.grade != "FF"
            ):
                return True
        return False

    def get_passed_course_short_names(self) -> List[str]:
        passes_course = []
        for grade in self.__list_grades:
            if grade.grade != "FF":
                passes_course.append(grade.get_course_short_name())
        return passes_course

    def get_passed_total_course_credit(self) -> int:
        total_credit = 0
        for grade in self.__list_grades:
            if grade.grade != "FF":
                total_credit += grade.get_credit()
        return total_credit

    def to_json(self):
        transcript = []
        for grade in self.__list_grades:
            transcript.append(
                {"shortName": grade.get_course_short_name(), "grade": grade.grade}
            )
        return transcript

    def __str__(self) -> str:
        result = ""
        for grade in self.__list_grades:
            result += f"Course name: {grade.get_course_full_name()} | Student Grade: {grade.grade}\n"
        return result
