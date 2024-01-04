class Course:
    def __init__(self, course_name=None, instructor=None):
        self.course_name = course_name
        self.instructor = instructor

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

class Transcript:
    def __init__(self):
        self.__passed_courses = []
        self.__taken_courses = []

    def add_passed_course(self, course):
        self.__passed_courses.append(course)

    def add_taken_course(self, course):
        self.__taken_courses.append(course)

    def get_passed_courses(self):
        return self.__passed_courses

    def get_taken_courses(self):
        return self.__taken_courses

class Student:
    def __init__(self, transcript):
        self.__transcript = transcript

    def get_passed_courses(self):
        return self.__transcript.get_passed_courses()

    def get_taken_courses(self):
        return self.__transcript.get_taken_courses()