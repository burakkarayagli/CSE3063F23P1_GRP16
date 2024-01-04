from Student import Student
from Transcript import Transcript
from Course import Course

class Grade:
    def __init__(self, course=None, grade=None):
        self._course = course
        self._grade = grade

    @property
    def course(self):
        return self._course

    @course.setter
    def course(self, course):
        if isinstance(course, Course):
            self._course = course
        else:
            raise ValueError("Invalid course object. Must be an instance of Course class.")

    @property
    def grade(self):
        return self._grade

    @grade.setter
    def grade(self, grade):
        self._grade = grade
