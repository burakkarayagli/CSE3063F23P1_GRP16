from typing import List
from Grade import Grade
from Course import Course

class Transcript:
    GRADE_MAPPING = {
        'AA': 4.0,
        'BA': 3.5,
        'BB': 3.0,
        'CB': 2.5,
        'CC': 2.0,
        'DC': 1.5,
        'DD': 1.0,
        'FD': 0.5,
        'FF': 0.0
    }

    def __init__(self, initial_grades: List[Grade] = None):
        self.__list_grades = [] if initial_grades is None else initial_grades

    @property
    def grades(self) -> str:
        result = ""
        for grade in self.__list_grades:
            result += f"Course name: {grade.course.full_name} | Student Grade: {grade.grade}\n"
        return result

    @property
    def grade_list(self) -> List[Grade]:
        return self.__list_grades

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

    def get_passed_courses(self) -> List[Course]:
        passed_courses = [grade.course for grade in self.__list_grades if self.GRADE_MAPPING.get(grade.grade, 0.0) >= 2.0]
        return passed_courses

    def get_taken_courses(self) -> List[Course]:
        taken_courses = [grade.course for grade in self.__list_grades]
        return taken_courses

    def __str__(self) -> str:
        result = "Transcript: \n"
        result += "Grades: \n"
        for grade in self.__list_grades:
            result += f"Course name: {grade.course.full_name} | Student Grade: {grade.grade}\n"
        return result