from typing import List

class Grade:
    def __init__(self, course, grade):
        self.course = course
        self.grade = grade

    def __eq__(self, other):
        if not isinstance(other, Grade):
            return False
        return self.course == other.course and self.grade == other.grade

class Course:
    def __init__(self, full_name, semester, credit):
        self.full_name = full_name
        self.semester = semester
        self.credit = credit

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

    def __init__(self, initial_grades: List[Grade] = None, notes: str = None):
        self._list_grades = [] if initial_grades is None else initial_grades
        self._notes = "" if notes is None else notes

    @property
    def grades(self) -> str:
        result = ""
        for grade in self._list_grades:
            result += f"Course name: {grade.course.full_name} | Student Grade: {grade.grade}\n"
        return result

    @property
    def grade_list(self) -> List[Grade]:
        return self._list_grades

    @property
    def notes(self) -> str:
        return self._notes

    @notes.setter
    def notes(self, value: str) -> None:
        self._notes = value

    def add_grade(self, grade: Grade) -> bool:
        self._list_grades.append(grade)
        return True if grade is None else False

    def delete_grade(self, grade: Grade) -> bool:
        try:
            self._list_grades.remove(grade)
            return True
        except ValueError:
            return False

    def calculate_cumulative_gpa(self) -> float:
        total_sum = 0
        total_count = 0
        total_credit = 0
        for grade in self._list_grades:
            credit = grade.course.credit
            numerical_grade = self.GRADE_MAPPING.get(grade.grade, 0.0)
            total_sum += numerical_grade * credit
            total_count += 1
            total_credit += credit
        if total_count == 0 or total_credit == 0:
            return 0.0
        return total_sum / (total_count * total_credit)

    def calculate_semester_gpa(self, semester: str) -> float:
        total_sum = 0
        total_count = 0
        total_credit = 0
        for grade in self._list_grades:
            if grade.course.semester == semester:
                credit = grade.course.credit
                numerical_grade = self.GRADE_MAPPING.get(grade.grade, 0.0)
                total_sum += numerical_grade * credit
                total_count += 1
                total_credit += credit
        if total_count == 0 or total_credit == 0:
            return 0.0
        return total_sum / (total_count * total_credit)

    def get_passed_courses(self) -> List[Course]:
        passed_courses = [grade.course for grade in self._list_grades if self.GRADE_MAPPING.get(grade.grade, 0.0) >= 2.0]
        return passed_courses

    def get_taken_courses(self) -> List[Course]:
        taken_courses = [grade.course for grade in self._list_grades]
        return taken_courses

    def __str__(self) -> str:
        result = "Transcript: \n"
        result += "Grades: \n"
        for grade in self._list_grades:
            result += f"Course name: {grade.course.full_name} | Student Grade: {grade.grade}\n"
        result += f"Notes: {self._notes}\n"
        return result