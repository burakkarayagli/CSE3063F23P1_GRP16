import unittest
from Course import Course 

class CourseTest(unittest.TestCase):
    def setUp(self):
        self.course1 = Course(
            "CS101",
            "Introduction to Computer Science",
            "An introductory course to computer science",
            [],
            1,
            3,
        )
        self.course2 = Course(
            "CS102",
            "Data Structures",
            "A course on data structures",
            ["CS101"],
            2,
            4,
        )
        self.course3 = Course(
            "CS101",
            "Introduction to Computer Science",
            "An introductory course to computer science",
            [],
            1,
            3,
        )
    def test_course_properties(self):
        self.assertEqual(self.course1.short_name, "CS101")
        self.assertEqual(self.course1.full_name, "Introduction to Computer Science")
        self.assertEqual(self.course1.description, "An introductory course to computer science")
        self.assertEqual(self.course1.semester, 1)
        self.assertEqual(self.course1.credit, 3)
        self.assertEqual(self.course1.get_prerequisites(), "")
        self.assertFalse(self.course1.remove_prerequisite("NonexistentCourse"))

    def test_add_remove_prerequisite(self):
        self.assertTrue(self.course1.add_prerequisite("CS102"))
        self.assertTrue(self.course1.remove_prerequisite("CS102"))
        self.assertFalse(self.course1.remove_prerequisite("CS102"))  # Already removed

    def test_valid_credit(self):
        self.course1.credit = 5
        self.assertEqual(self.course1.credit, 5)

    def test_invalid_credit(self):
        initial_credit = self.course2.credit
        self.course2.credit = 11  # Set an invalid credit value
        self.assertEqual(self.course2.credit, initial_credit)  # Ensure credit remains unchanged

    def test_to_json(self):
        expected_json = {
            "shortName": "CS101",
            "fullName": "Introduction to Computer Science",
            "description": "An introductory course to computer science",
            "prerequisite": [],
            "semester": 1,
            "credit": 3,
        }
        self.assertEqual(self.course1.to_json(), expected_json)

    def test_equality(self):
        self.assertEqual(self.course1, self.course1)  # Same course
        self.assertNotEqual(self.course1, self.course2)  # Different courses

    def test_str_method(self):
        expected_str_output = (
            "Course Code: CS101\n"
            "Course Name: Introduction to Computer Science\n"
            "Description: An introductory course to computer science\n"
            "Prerequisite: \n"
            "Semester: 1\n"
            "Credit: 3\n"
            "---------"
        )
        self.assertEqual(str(self.course1), expected_str_output)

    def test_eq_method(self):
        self.assertEqual(self.course1, self.course3)  # Same course code
        self.assertNotEqual(self.course1, self.course2)  # Different course code

if __name__ == '__main__':
    unittest.main()
