import unittest
from Staff import Staff
from TimeInterval import TimeInterval


class StaffTest(unittest.TestCase):
    def test_get_reputation(self):
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        self.assertEqual("Excellent", staff.get_reputation())

    def test_set_reputation(self):
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        staff.set_reputation("Good")
        self.assertEqual("Good", staff.get_reputation())

    def test_get_office_hours(self):
        office_hours = [
            TimeInterval("09:00", "12:00", "Monday"),
            TimeInterval("14:00", "17:00", "Wednesday"),
        ]
        staff = Staff(
            "John",
            "Doe",
            "johndoe",
            "password",
            "Excellent",
            office_hours,
            50000,
            "Full-time",
        )
        self.assertEqual(office_hours, staff.get_office_hours())

    def test_set_office_hours(self):
        office_hours = [
            TimeInterval("09:00", "12:00", "Monday"),
            TimeInterval("14:00", "17:00", "Wednesday"),
        ]
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        staff.set_office_hours(office_hours)
        self.assertEqual(office_hours, staff.get_office_hours())

    def test_add_office_hours(self):
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        office_hour = TimeInterval("09:00", "12:00", "Monday")
        staff.add_office_hours(office_hour)
        self.assertIn(office_hour, staff.get_office_hours())

    def test_delete_office_hours(self):
        office_hours = [
            TimeInterval("09:00", "12:00", "Monday"),
            TimeInterval("14:00", "17:00", "Wednesday"),
        ]
        staff = Staff(
            "John",
            "Doe",
            "johndoe",
            "password",
            "Excellent",
            office_hours,
            50000,
            "Full-time",
        )
        office_hour_to_delete = TimeInterval("09:00", "12:00", "Monday")
        staff.delete_office_hours(office_hour_to_delete)
        self.assertNotIn(office_hour_to_delete, staff.get_office_hours())

    def test_get_salary(self):
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        self.assertEqual(50000, staff.get_salary())

    def test_set_salary(self):
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        staff.set_salary(60000)
        self.assertEqual(60000, staff.get_salary())

    def test_get_employment_status(self):
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        self.assertEqual("Full-time", staff.get_employment_status())

    def test_set_employment_status(self):
        staff = Staff(
            "John", "Doe", "johndoe", "password", "Excellent", [], 50000, "Full-time"
        )
        staff.set_employment_status("Part-time")
        self.assertEqual("Part-time", staff.get_employment_status())

    # Add more tests for other methods as needed


if __name__ == "__main__":
    unittest.main()
