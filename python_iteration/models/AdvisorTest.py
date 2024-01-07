import unittest
from Student import Student
from Advisor import Advisor
from Course import Course
from CourseSection import CourseSection
from Lecturer import Lecturer
from TimeInterval import TimeInterval

class TestAdvisorFunctions(unittest.TestCase):

    def setUp(self):
        self.time_interval1 = TimeInterval("09:00", "12:00", "Monday")
        self.time_interval2 = TimeInterval("13:00", "15:00", "Wednesday")

        self.course = Course(
            "C101",
            "Computer Science 101",
            "Introduction to Computer Science",
            [],
            1,
            3
        )

        self.lecturer = Lecturer("John", "Doe", "john.doe", "password123", "PhD")

        self.course_section = CourseSection(
            self.course,
            [self.time_interval1, self.time_interval2],
            "A",
            self.lecturer,
            30,
            20,
            3,
            "Lecture"
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
            None
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
            [self.student]
        )

    def test_add_student(self):
        self.advisor.add_student(self.student)
        self.assertIn(self.student, self.advisor.students)

    def test_delete_student(self):
        self.advisor.add_student(self.student)
        self.advisor.__deleteStudent(self.student)
        self.assertNotIn(self.student, self.advisor.students)

    def test_student_course_organization(self):
        self.advisor.add_student(self.student)
        self.advisor.__studentCourseOrganization()

    def test_get_combined_courses(self):
        self.student.__waitingCourses = [CourseSection("Math101", "M101", 3)]
        available_courses = [CourseSection("Physics101", "P101", 3)]
        combined_courses = self.advisor.__getCombinedCourses(self.student)
        expected_combined_courses = self.student.__waitingCourses + available_courses
        self.assertEqual(combined_courses, expected_combined_courses)

    def test_approve_student(self):
        self.advisor.add_student(self.student)
        self.advisor.__approveStudent(self.student, ["1"])

    def test_reject_student(self):
        self.advisor.add_student(self.student)
        self.advisor.__rejectStudent(self.student, "*")

    
if __name__ == '__main__':
    unittest.main()
