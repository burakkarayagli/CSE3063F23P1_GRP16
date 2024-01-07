import unittest
from Staff import Staff, TimeInterval

class StaffTest(unittest.TestCase):
    def setUp(self):
        self.office_hours = [TimeInterval("09:00", "12:00", "Monday"), TimeInterval("14:00", "17:00", "Wednesday")]
        self.staff = Staff("John", "Doe", "johndoe", "password", "Excellent", self.office_hours, 50000, "Full-time")

    def test_get_reputation(self):
        self.assertEqual("Excellent", self.staff.reputation)

    def test_set_reputation(self):
        self.staff.reputation = "Good"
        self.assertEqual("Good", self.staff.reputation)

    def test_get_office_hours(self):
        self.assertEqual(self.office_hours, self.staff.office_hours)

    def test_set_office_hours(self):
        new_office_hours = [TimeInterval("08:00", "11:00", "Tuesday")]
        self.staff.office_hours = new_office_hours
        self.assertEqual(new_office_hours, self.staff.office_hours)

    def test_get_salary(self):
        self.assertEqual(50000, self.staff.salary)

    def test_get_employment_status(self):
        self.assertEqual("Full-time", self.staff.employment_status)

    def test_set_employment_status(self):
        self.staff.employment_status = "Part-time"
        self.assertEqual("Part-time", self.staff.employment_status)

    # Add more tests for other methods as needed

if __name__ == '__main__':
    unittest.main()
