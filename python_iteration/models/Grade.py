class Grade:
    def __init__(self, course=None, grade=None):
        self.course = course
        self.grade = grade

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def get_grade(self):
        return self.grade

    def set_grade(self, grade):
        self.grade = grade