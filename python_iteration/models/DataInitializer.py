from Advisor import Advisor
from Lecturer import Lecturer
from Student import Student
from Grade import Grade
from Transcript import Transcript
from Course import Course
from CourseSection import CourseSection
from TimeInterval import TimeInterval

import os
import json

database_folder = "python_iteration/database"


class DataInitializer:
    def __init__(self):
        self.students = []
        self.advisors = []
        self.lecturers = []
        self.courses = []
        self.course_sections = []
        self.read_data()

    #  find if already have
    def find_course(self, shortName):
        for i in range(len(self.courses)):
            if self.courses[i].short_name == shortName:
                return self.courses[i]
        return None

    def find_course_section(self, shortName, sectionName):
        for i in range(len(self.course_sections)):
            if (
                self.course_sections[i].short_name == shortName
                and self.course_sections[i].section_name == sectionName
            ):
                return self.course_sections[i]
        return None

    def find_student(self, password):
        for i in range(len(self.students)):
            if self.students[i].password == password:
                return self.students[i]
        return None

    # create instance from json
    def time_interval_to_instance(self, time_interval_json):
        time_intervals = []
        for i in range(len(time_interval_json)):
            time_interval = TimeInterval(
                time_interval_json[i].get("startTime"),
                time_interval_json[i].get("endTime"),
                time_interval_json[i].get("dayOfWeek"),
            )
            time_intervals.append(time_interval)
        return time_intervals

    def transcript_to_instance(self, transcript_json):
        grades = []
        for i in range(len(transcript_json)):
            course_info = transcript_json[i]
            course = self.find_course(course_info["shortName"])
            if course is None:
                print(
                    f"Error: Course({course_info['shortName']}) not found in transcript"
                )
                break
            grade = Grade(course, course_info["grade"])
            grades.append(grade)
        transcript = Transcript(grades)
        return transcript

    # read
    def read_course(self):
        with open(os.path.join(database_folder, "parameters.json"), "r") as f:
            data = json.load(f)
            courses_json = data["courses"]

            for i in range(len(courses_json)):
                course = Course(
                    courses_json[i].get("shortName"),
                    courses_json[i].get("fullName"),
                    courses_json[i].get("description"),
                    courses_json[i].get("prerequisite"),
                    courses_json[i].get("semester"),
                    courses_json[i].get("credit"),
                )
                self.courses.append(course)

    def read_course_sections(self):
        with open(os.path.join(database_folder, "parameters.json"), "r") as f:
            data = json.load(f)
            course_sections_json = data["courseSections"]
            for i in range(len(course_sections_json)):
                course = self.find_course(course_sections_json[i].get("shortName"))
                if course is None:
                    print(
                        f"Error: Course({course_sections_json[i].get('shortName')}) not found in read_course_sections"
                    )
                    break
                dates = self.time_interval_to_instance(
                    course_sections_json[i].get("dates")
                )
                course_section = CourseSection(
                    course=course,
                    dates=dates,
                    section_name=course_sections_json[i].get("sectionName"),
                    lecturer=None,
                    quota=course_sections_json[i].get("quota"),
                    number_of_student=course_sections_json[i].get("numberOfStudent", 0),
                    required_credit=course_sections_json[i].get("requiredCredit", 0),
                    type=course_sections_json[i]["type"],
                )
                self.course_sections.append(course_section)

    def read_student(self):
        for student_file in os.listdir(database_folder):
            if student_file != "parameters.json":
                with open(os.path.join(database_folder, student_file), "r") as f:
                    data = json.load(f)
                    transcript = self.transcript_to_instance(data["transcript"])
                    student = Student(
                        data["personName"],
                        data["personSurname"],
                        data["username"],
                        data["password"],
                        data["semester"],
                        data["status"],
                        [
                            self.find_course_section(
                                each["shortName"], each["sectionName"]
                            )
                            for each in data["waitingCourses"]
                        ],
                        [
                            self.find_course_section(
                                each["shortName"], each["sectionName"]
                            )
                            for each in data["approvedCourses"]
                        ],
                        [
                            self.find_course_section(
                                each["shortName"], each["sectionName"]
                            )
                            for each in data["rejectedCourses"]
                        ],
                        transcript,
                    )
                    self.students.append(student)

    def read_course(self):
        with open(os.path.join(database_folder, "parameters.json"), "r") as f:
            data = json.load(f)
            courses_json = data["courses"]

            for i in range(len(courses_json)):
                course = Course(
                    courses_json[i].get("shortName"),
                    courses_json[i].get("fullName"),
                    courses_json[i].get("description"),
                    courses_json[i].get("prerequisite"),
                    courses_json[i].get("semester"),
                    courses_json[i].get("credit"),
                )
                self.courses.append(course)

    def read_course_sections(self):
        with open(os.path.join(database_folder, "parameters.json"), "r") as f:
            data = json.load(f)
            course_sections_json = data["courseSections"]
            for i in range(len(course_sections_json)):
                course = self.find_course(course_sections_json[i].get("shortName"))
                if course is None:
                    print(
                        f"Error: Course({course_sections_json[i].get('shortName')}) not found in read_course_sections"
                    )
                    break
                dates = self.time_interval_to_instance(
                    course_sections_json[i].get("dates")
                )
                course_section = CourseSection(
                    course=course,
                    dates=dates,
                    section_name=course_sections_json[i].get("sectionName"),
                    lecturer=None,
                    quota=course_sections_json[i].get("quota"),
                    number_of_student=course_sections_json[i].get("numberOfStudent", 0),
                    required_credit=course_sections_json[i].get("requiredCredit", 0),
                    type=course_sections_json[i]["type"],
                )
                self.course_sections.append(course_section)

    def read_lecturer(self):
        with open(os.path.join(database_folder, "parameters.json"), "r") as f:
            data = json.load(f)
            lecturers_json = data["lecturers"]
            for i in range(len(lecturers_json)):
                time_intervals = self.time_interval_to_instance(
                    lecturers_json[i].get("officeHours")
                )
                lecturer = Lecturer(
                    lecturers_json[i].get("personName"),
                    lecturers_json[i].get("personSurname"),
                    lecturers_json[i].get("username"),
                    lecturers_json[i].get("password"),
                    lecturers_json[i].get("reputation"),
                    time_intervals,
                    lecturers_json[i].get("salary"),
                    lecturers_json[i].get("employmentStatus"),
                    None,
                )
                self.lecturers.append(lecturer)

    def read_advisor(self):
        with open(os.path.join(database_folder, "parameters.json"), "r") as f:
            data = json.load(f)
            advisors_json = data["advisors"]
            for i in range(len(advisors_json)):
                time_intervals = self.time_interval_to_instance(
                    advisors_json[i].get("officeHours")
                )
                advisor = Advisor(
                    advisors_json[i].get("personName"),
                    advisors_json[i].get("personSurname"),
                    advisors_json[i].get("username"),
                    advisors_json[i].get("password"),
                    advisors_json[i].get("reputation"),
                    time_intervals,
                    advisors_json[i].get("salary"),
                    advisors_json[i].get("employmentStatus"),
                    None,
                )
                self.advisors.append(advisor)

    def write_student(self, student):
        fileList = os.listdir(database_folder)
        correct_file = None
        for f in fileList:
            if f.startswith("150"):
                with open(os.path.join(database_folder, f), "r") as file:
                    data = json.load(file)
                    if data["password"] == student.password:
                        correct_file = f
                        break
        with open(os.path.join(database_folder, correct_file), "w") as file:
            json.dump(student.toJson(), file, indent=2, ensure_ascii=False)

    # def write_course(self, course):
    #     data = []
    #     with open(os.path.join(database_folder, "parameters.json"), "r") as f:
    #         data = json.load(f)
    #         courses_json = data["courses"]
    #         is_exist = False
    #         for i in range(len(courses_json)):
    #             if courses_json[i]["shortName"] == course.short_name:
    #                 courses_json[i] = course.to_json()
    #                 is_exist = True
    #                 break
    #         if not is_exist:
    #             courses_json.append(course.to_json())
    #         data["courses"] = courses_json
    #     with open(os.path.join(database_folder, "parameters.json"), "w") as f:
    #         json.dump(data, f, indent=2, ensure_ascii=False)

    # def write_course_section(self, course_section):
    #     data = []
    #     with open(os.path.join(database_folder, "parameters.json"), "r") as f:
    #         data = json.load(f)
    #         course_sections_json = data["courseSections"]
    #         is_exist = False
    #         for i in range(len(course_sections_json)):
    #             if (
    #                 course_sections_json[i]["shortName"] == course_section.short_name
    #                 and course_sections_json[i]["sectionName"]
    #                 == course_section.section_name
    #             ):
    #                 course_sections_json[i] = course_section.to_json()
    #                 is_exist = True
    #                 break
    #         if not is_exist:
    #             course_sections_json.append(course_section.to_json())
    #         data["courseSections"] = course_sections_json
    #     with open(os.path.join(database_folder, "parameters.json"), "w") as f:
    #         json.dump(data, f, indent=2, ensure_ascii=False)

    # def write_lecturer(self, lecturer):
    #     data = []
    #     with open(os.path.join(database_folder, "parameters.json"), "r") as f:
    #         data = json.load(f)
    #         lecturers_json = data["lecturers"]
    #         is_exist = False
    #         for i in range(len(lecturers_json)):
    #             if lecturers_json[i]["password"] == lecturer.password:
    #                 lecturers_json[i] = lecturer.to_json()
    #                 is_exist = True
    #                 break
    #         if not is_exist:
    #             lecturers_json.append(lecturer.to_json())
    #         data["lecturers"] = lecturers_json
    #     with open(os.path.join(database_folder, "parameters.json"), "w") as f:
    #         json.dump(data, f, indent=2, ensure_ascii=False)

    # def write_advisor(self, advisor):
    #     data = []
    #     with open(os.path.join(database_folder, "parameters.json"), "r") as f:
    #         data = json.load(f)
    #         advisors_json = data["advisors"]
    #         is_exist = False
    #         for i in range(len(advisors_json)):
    #             if advisors_json[i]["password"] == advisor.password:
    #                 advisors_json[i] = advisor.toJson()
    #                 is_exist = True
    #                 break
    #         if not is_exist:
    #             advisors_json.append(advisor.toJson())
    #         data["advisors"] = advisors_json
    #     with open(os.path.join(database_folder, "parameters.json"), "w") as f:
    #         json.dump(data, f, indent=2, ensure_ascii=False)

    def lecturer_and_course_section(self):
        for lecturer in self.lecturers:
            with open(os.path.join(database_folder, "parameters.json"), "r") as f:
                data = json.load(f)
                course_sections_json = data["courseSections"]
                for i in range(len(course_sections_json)):
                    if course_sections_json[i]["lecturer"] == lecturer.password:
                        section = self.find_course_section(
                            course_sections_json[i]["shortName"],
                            course_sections_json[i]["sectionName"],
                        )
                        lecturer.add_course(section)
                        section.set_lecturer(lecturer)

    def advisor_and_student(self):
        for advisor in self.advisors:
            with open(os.path.join(database_folder, "parameters.json"), "r") as f:
                data = json.load(f)
                advisor_json = data["advisors"]
                for i in range(len(advisor_json)):
                    if advisor_json[i]["password"] == advisor.password:
                        students = advisor_json[i]["students"]
                        for password in students:
                            student = self.find_student(password)
                            advisor.add_student(student)

    def read_data(self):
        self.read_course()
        self.read_course_sections()
        self.read_lecturer()
        self.read_advisor()
        self.read_student()
        self.lecturer_and_course_section()
        self.advisor_and_student()
