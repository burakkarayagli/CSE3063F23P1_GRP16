class Transcript:
    def __init__(self, initial_grades=None, notes=None):
        self.list_grades = [] if initial_grades is None else initial_grades
        self.notes = "" if notes is None else notes

    def get_grades(self):
        result = ""
        for grade in self.list_grades:
            result += f"Course name: {grade.course.full_name} | Student Grade: {grade.grade}\n"
        return result

    def get_grade_list(self):
        return self.list_grades

    def add_grade(self, grade):
        self.list_grades.append(grade)
        return True if grade is None else False

    def delete_grade(self, grade):
        try:
            self.list_grades.remove(grade)
            return True
        except ValueError:
            return False

    def calculate_cumulative_gpa(self):
        total_sum = 0
        total_count = 0
        total_credit = 0
        for grade in self.list_grades:
            credit = grade.course.credit
            total_sum += float(grade.grade) * credit
            total_count += 1
            total_credit += credit
        if total_count == 0 or total_credit == 0:
            return 0.0
        return total_sum / (total_count * total_credit)

    def calculate_semester_gpa(self, semester):
        total_sum = 0
        total_count = 0
        total_credit = 0
        for grade in self.list_grades:
            if grade.course.semester == semester:
                credit = grade.course.credit
                total_sum += float(grade.grade) * credit
                total_count += 1
                total_credit += credit
        if total_count == 0 or total_credit == 0:
            return 0.0
        return total_sum / (total_count * total_credit)

    def __str__(self):
        result = "Transcript: \n"
        result += "Grades: \n"
        for grade in self.list_grades:
            result += f"Course name: {grade.course.full_name} | Student Grade: {grade.grade}\n"
        result += f"Notes: {self.notes}\n"
        return result