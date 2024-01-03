from types import List

from Person import Person
from Course import Course
from Transcript import Transcript

# Not: Course can be CourseSection


class Student(Person):
    def __init__(
        self,
        firstName: str,
        lastName: str,
        username: str,
        password: str,
        semester: int,
        enteranceYear: int,
        status: str,
        selectedCourse: List[Course],
        approvedCourse: List[Course],
        transcript: Transcript,
    ):
        super().__init__(firstName, lastName, username, password)
        self.__semester__ = semester
        self.__enteranceYear__ = enteranceYear
        self.__status__ = status
        self.__selectedCourse__ = selectedCourse
        self.__approvedCourse__ = approvedCourse
        self.__transcript__ = transcript

    # getters and setters
    @property
    def semester(self):
        return self.__semester__

    @semester.setter
    def semester(self, semester: int):
        self.__semester__ = semester

    @property
    def enteranceYear(self):
        return self.__enteranceYear__

    @enteranceYear.setter
    def enteranceYear(self, enteranceYear: int):
        self.__enteranceYear__ = enteranceYear

    @property
    def status(self):
        return self.__status__

    @status.setter
    def status(self, status: str):
        self.__status__ = status

    def addSelectedCourse(self, course: Course):
        self.__selectedCourse__.append(course)

    def removeSelectedCourse(self, course: Course):
        # TODO: implement, can be __eq__ method use in the Course class or
        # use while loop and check the course name etc.
        pass

    def addApprovedCourse(self, course: Course):
        self.__approvedCourse__.append(course)

    def removeApprovedCourse(self, course: Course):
        # TODO: implement, can be __eq__ method use in the Course class or
        # use while loop and check the course name etc.
        pass

    def printSelectedCourse(self):
        print("SELECTED COURSES:")
        for index, course in enumerate(self.__selectedCourse__):
            print(f"{index+1}. {course.getFullName()}")

    def printTranscript(self):
        print("TRANSCRIPT:")
        # TODO: implement, writing __str__ in transcript class
        print(self.__transcript__)
