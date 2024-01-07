import unittest
from io import StringIO
from datetime import datetime
from Person import Person  # Make sure to import your required classes
from Course import Course
from Transcript import Transcript
from CourseSection import CourseSection
from Student import Student
from TimeInterval import TimeInterval
from Lecturer import Lecturer
from Advisor import Advisor


class StudentTest(unittest.TestCase):
    def setUp(self):
        self.time_interval1 = TimeInterval("09:00", "12:00", "Monday")
        self.time_interval2 = TimeInterval("13:00", "15:00", "Wednesday")

        self.course = Course(
            "C101", "Computer Science 101", "Introduction to Computer Science", [], 1, 3
        )

        self.lecturer = Lecturer(
            "John", "Doe", "john.doe", "password123", "PhD", [], 10000, "Full-time", []
        )

        self.course_section = CourseSection(
            self.course,
            [self.time_interval1, self.time_interval2],
            "A",
            self.lecturer,
            30,
            20,
            3,
            "Lecture",
        )

        self.student = Student(
            "Alice",
            "Johnson",
            "alice.johnson",
            "password789",
            3,
            "Active",
            [],
            [],
            [],
            None,
        )

        self.advisor = Advisor(
            "Jane",
            "Smith",
            "jane.smith",
            "password456",
            "High",
            [self.time_interval1],
            60000,
            "Full-time",
            [self.student],
        )

    def test_add_waiting_courses(self):
        new_course = CourseSection("CHEM101", "A", 3, "Jane Doe", "Thursday", "11:00", "12:00", 1)
        self.student.addwaitingCourses(new_course)
        self.assertIn(new_course, self.student.__waitingCourses)

    def test_remove_waiting_courses(self):
        course_to_remove = self.student.__waitingCourses[0]
        self.student.removewaitingCourses(course_to_remove)
        self.assertNotIn(course_to_remove, self.student.__waitingCourses)

    def test_add_approved_courses(self):
        new_course = CourseSection("ENG101", "A", 3, "Emily Johnson", "Friday", "14:00", "15:00", 1)
        self.student.addapprovedCourses(new_course)
        self.assertIn(new_course, self.student.__approvedCourses)

    def test_remove_approved_courses(self):
        course_to_remove = self.student.__approvedCourses[0]
        self.student.removeapprovedCourses(course_to_remove)
        self.assertNotIn(course_to_remove, self.student.__approvedCourses)

    def test_add_rejected_courses(self):
        new_course = CourseSection("HIST101", "A", 3, "George Smith", "Monday", "11:00", "12:00", 1)
        self.student.addrejectedCourses(new_course)
        self.assertIn(new_course, self.student.__rejectedCourses)

    def test_remove_rejected_courses(self):
        course_to_remove = self.student.__rejectedCourses[0]
        self.student.removerejectedCourses(course_to_remove)
        self.assertNotIn(course_to_remove, self.student.__rejectedCourses)

    def test_is_course_in_waiting_courses_list(self):
        new_course = CourseSection("CHEM101", "A", 3, "Jane Doe", "Thursday", "11:00", "12:00", 1)
        self.student.addwaitingCourses(new_course)
        self.assertTrue(self.student.__isCourseInWaitingCoursesList(new_course))


if __name__ == "__main__":
    unittest.main()
