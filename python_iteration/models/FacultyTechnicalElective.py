from typing import List

class FacultyTechnicalElective(Course):
    def __init__(self, course, dates: List[TimeInterval], sectionName: str, lecturer, quota: int,
                 location: str, requiredCredit: int = 0):
        super().__init__(course.shortName, course.fullName, course.description, course.prerequisite,
                         course.semester, course.credit, course.classHours)
        self.dates = dates
        self.sectionName = sectionName
        self.lecturer = lecturer
        self.quota = quota
        self.location = location
        self.requiredCredit = requiredCredit

    def set_dates(self, dates: List[TimeInterval]):
        self.dates = dates

    def get_dates(self) -> List[TimeInterval]:
        return self.dates

    def add_date(self, date: TimeInterval):
        self.dates.append(date)

    def remove_date(self, date: TimeInterval):
        self.dates.remove(date)

    def get_section_name(self) -> str:
        return self.sectionName

    def set_section_name(self, sectionName: str):
        self.sectionName = sectionName

    def get_lecturer(self):
        return self.lecturer

    def set_lecturer(self, lecturer):
        self.lecturer = lecturer

    def get_quota(self) -> int:
        return self.quota

    def set_quota(self, quota: int):
        self.quota = quota

    def get_required_credit(self) -> int:
        return self.requiredCredit

    def set_required_credit(self, requiredCredit: int):
        self.requiredCredit = requiredCredit

    def check_required_credit(self, total_credit: int) -> bool:
        return total_credit >= self.requiredCredit

    def __str__(self):
        return (f"Faculty Technical Elective: {self.fullName}\n"
                f"Code: {self.shortName}\n"
                f"Description: {self.description}\n"
                f"Prequisite: {', '.join(self.prerequisite)}\n"
                f"Semester: {self.semester}\n"
                f"Credit: {self.credit}\n"
                f"Class Hours: {self.classHours}\n"
                f"Section Name: {self.sectionName}\n"
                f"Lecturer: {self.lecturer.get_full_name()}\n"
                f"Quota: {self.quota}\n"
                f"Location: {self.location}\n"
                f"Required Credit: {self.requiredCredit}\n-------------")
