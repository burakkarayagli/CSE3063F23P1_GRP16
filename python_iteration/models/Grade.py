from Course import Course


class Grade:
    def __init__(self, course=None, grade=None):
        self.__course = course
        self.__grade = grade

    @property
    def course(self):
        return self.__course

    @course.setter
    def course(self, course):
        if isinstance(course, Course):
            self.__course = course
        else:
            raise ValueError(
                "Invalid course object. Must be an instance of Course class."
            )

    @property
    def grade(self):
        return self.__grade

    @grade.setter
    def grade(self, grade):
        self.__grade = grade

    def get_course_short_name(self):
        return self.__course.short_name

    def __eq__(self, other):
        return self.get_course_short_name() == other.get_course_short_name()
