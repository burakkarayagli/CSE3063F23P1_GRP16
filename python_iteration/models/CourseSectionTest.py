import unittest
from Course import Course
from TimeInterval import TimeInterval
from CourseSection import CourseSection
from Lecturer import Lecturer


class CourseSectionTest(unittest.TestCase):
    def setUp(self):
        self.course = Course(
            short_name="CS101",
            full_name="Intro to CS",
            description="Introductory course",
            semester=1,
            credit=3,
            prerequisite=[],
        )
        self.dates = [
            TimeInterval(start_time="9:00", end_time="11:00", day_of_week="Monday"),
            TimeInterval(start_time="13:00", end_time="15:00", day_of_week="Monday"),
        ]
        self.lecturer = Lecturer(
            person_name="John",
            person_surname="Doe",
            username="lecturer_username",
            password="John Doe",
            reputation="Mr.",
            office_hours=self.dates,
            salary=1000,
            employment_status="Full Time",
            courses=[],
        )

        self.course_section1 = CourseSection(
            course=self.course,
            dates=self.dates,
            section_name="Section A",
            lecturer=self.lecturer,
            quota=30,
            number_of_student=0,
            required_credit=150,
            type="Type A",
        )

        self.course_section2 = CourseSection(
            course=self.course,
            dates=self.dates,
            section_name="Section B",
            lecturer=self.lecturer,
            quota=25,
            number_of_student=0,
            required_credit=120,
            type="Type B",
        )

    def test_str_method(self):
        expected_str_output = (
            "---------\n"
            "Course Information\n"
            "Course Code: CS101\n"
            "Course Name: Intro to CS\n"
            "Description: Introductory course\n"
            "Prerequisite: \n"
            "Semester: 1\n"
            "Credit: 3\n"
            "Section Name: Section A\n"
            "Quota: 30\n"
            "Number of Student: 0\n"
            "Required Credit: 150\n"
            "Type: Type A\n"
            "Lecturer Name: John Doe\n"
            "Dates: Monday 9:00 - 11:00, Monday 13:00 - 15:00\n"
        )
        self.assertEqual(str(self.course_section1), expected_str_output)

    def test_eq_method(self):
        self.assertEqual(self.course_section1, self.course_section1)
        self.assertNotEqual(self.course_section1, self.course_section2)

    def test_number_of_student_setter_valid_value(self):
        self.course_section1.number_of_student = 20
        self.assertEqual(self.course_section1.number_of_student, 20)

    def test_number_of_student_setter_invalid_value(self):
        with self.assertRaises(ValueError):
            self.course_section1.number_of_student = 40

    def test_required_credit_setter_valid_value(self):
        self.course_section2.required_credit = 100
        self.assertEqual(self.course_section2.required_credit, 100)

    def test_required_credit_setter_invalid_value(self):
        with self.assertRaises(ValueError):
            self.course_section2.required_credit = 250

    def test_add_dates(self):
        new_date = TimeInterval(
            start_time="13:00", end_time="15:00", day_of_week="Tuesday"
        )
        self.assertTrue(self.course_section1.add_dates(new_date))
        self.assertIn(new_date, self.course_section1.dates)

        existing_date = TimeInterval(
            start_time="9:00", end_time="11:00", day_of_week="Monday"
        )
        self.assertFalse(self.course_section2.add_dates(existing_date))
        self.assertIn(existing_date, self.course_section2.dates)

    def test_remove_dates(self):
        existing_date = TimeInterval(
            start_time="9:00", end_time="11:00", day_of_week="Monday"
        )
        self.assertTrue(self.course_section1.remove_dates(existing_date))
        self.assertNotIn(existing_date, self.course_section1.dates)

        non_existing_date = TimeInterval(
            start_time="13:00", end_time="15:00", day_of_week="Tuesday"
        )
        self.assertFalse(self.course_section2.remove_dates(non_existing_date))

    def is_time_overlap(self, date) -> bool:
        for d in self.__dates:
            if d.start_time < date.end_time and date.start_time < d.end_time:
                return True
        return False

    def check_overlap(self, course_section) -> bool:
        for d in course_section.dates:
            if self.is_time_overlap(d):
                return True
        return False

    def test_eq_method(self):
        self.assertEqual(self.course_section1, self.course_section1)
        self.assertNotEqual(self.course_section1, self.course_section2)


if __name__ == "__main__":
    unittest.main()
