from typing import List

from Person import Person
from Course import Course
from Transcript import Transcript
from CourseSection import CourseSection

import logging

# Configuring logging
logging.basicConfig(
    filename="logs.log",
    level=logging.INFO,
    format="%(asctime)s:%(levelname)s:%(message)s",
)
logger = logging.getLogger(__name__)

# Global variables
MAX_COURSES = 5
MAX_CREDIT_LIMIT = 30
PRIMARY_COLOR = "magenta"
SECONDARY_COLOR = "black"
TEXT_COLOR = "white"
EXIT_COLOR = "red"
INPUT_COLOR = "yellow"


# Not: Course can be CourseSection


class Student(Person):
    def __init__(
        self,
        firstName: str,
        lastName: str,
        username: str,
        password: str,
        semester: int,
        status: str,
        waitingCourses: List[CourseSection],
        approvedCourses: List[CourseSection],
        rejectedCourses: List[CourseSection],
        transcript: Transcript,
    ):
        super().__init__(firstName, lastName, username, password)
        self.__semester = semester
        self.__status = status
        self.__waitingCourses = waitingCourses
        self.__approvedCourses = approvedCourses
        self.__rejectedCourses = rejectedCourses
        self.__transcript = transcript

    # getters and setters
    @property
    def semester(self):
        return self.__semester

    @semester.setter
    def semester(self, semester: int):
        self.__semester = semester

    @property
    def enteranceYear(self):
        return self.__enteranceYear

    @enteranceYear.setter
    def enteranceYear(self, enteranceYear: int):
        self.__enteranceYear = enteranceYear

    @property
    def status(self):
        return self.__status

    @status.setter
    def status(self, status: str):
        self.__status = status

    def addwaitingCourses(self, course: CourseSection):
        self.__waitingCourses.append(course)

    def removewaitingCourses(self, course: CourseSection):
        # TODO: implement, can be __eq__ method use in the Course class or
        # use while loop and check the course name etc.
        pass

    def addapprovedCourses(self, course: CourseSection):
        self.__approvedCourses.append(course)

    def removeapprovedCourses(self, course: Course):
        # TODO: implement, can be __eq__ method use in the Course class or
        # use while loop and check the course name etc.
        pass

    def addrejectedCourses(self, course: CourseSection):
        self.__rejectedCourses.append(course)

    def removerejectedCourses(self, course: CourseSection):
        # TODO: implement, can be __eq__ method use in the Course class or
        # use while loop and check the course name etc.
        pass

    def printwaitingCourses(self):
        print("SELECTED COURSES:")
        for index, course in enumerate(self.__waitingCourses):
            print(f"{index+1}. {course.get_full_name()}")

    def printapprovedCourses(self):
        print("APPROVED COURSES:")
        for index, course in enumerate(self.__approvedCourses):
            print(f"{index+1}. {course.get_full_name()}")

    def printrejectedCourses(self):
        print("REJECTED COURSES:")
        for index, course in enumerate(self.__rejectedCourses):
            print(f"{index+1}. {course.get_full_name()}")

    def printTranscript(self):
        print("TRANSCRIPT:")
        print(self.__transcript)

    # Add course to waiting list
    def addCourse(self, course: CourseSection):
        # Check if course is already in waiting list
        if course in self.__waitingCourses:
            print("Course already in waiting list")
            return

        # Check if student has exceeded the maximum number of courses
        if len(self.__waitingCourses) == MAX_COURSES:
            print("Maximum number of courses exceeded")
            return

        if course in self.__rejectedCourses:
            # Remove course from rejected list
            self.__rejectedCourses.remove(course)
            logger.info(
                f"Course {course.get_full_name()} removed from rejected list of {self.getFullName()}"
            )

        try:
            # Add course to waiting list
            self.addwaitingCourses(course)

            logger.info(
                f"Course {course.get_full_name()} added to waiting list of {self.getFullName()}"
            )
        except Exception as e:
            print(f"Error adding course: {e}")
            logger.error(f"Error adding course: {e}")

    # Drop course from waiting list
    def dropCourse(self, course: CourseSection):
        # if course is approved student can't drop that course
        if course in self.__approvedCourses:
            print("Course already approved")
            return

        # Check if course is in waiting list
        if not self.__isCourseInWaitingCoursesList(course):
            print("Course not in waiting list")
            return

        try:
            # Remove course from waiting list
            self.__waitingCourses.remove(course)
            logger.info(
                f"Course {course.full_name} dropped from waiting list of {self.getFullName()}"
            )
        except Exception as e:
            print(f"Error dropping course: {e}")
            logger.error(f"Error dropping course: {e}")

    # INDEX METHODS
    def rejectCourseWithIndex(self, index: int):
        try:
            # Remove course from waiting list
            course = self.__waitingCourses.pop(index)
            self.__rejectedCourses.append(course)
            print(
                f"Course {course.get_full_name()} dropped from waiting list of {self.getFullName()}"
            )
            logger.info(
                f"Course {course.get_full_name()} dropped from waiting list of {self.getFullName()}"
            )
            return True
        except:
            print("Error dropping course")
            logger.error("Error dropping course")

    def approveCourseWithIndex(self, index: int):
        try:
            # Remove course from waiting list
            course = self.__waitingCourses.pop(index)
            self.__approvedCourses.append(course)
            print(
                f"Course {course.get_full_name()} approved from waiting list of {self.getFullName()}"
            )
            logger.info(
                f"Course {course.get_full_name()} approved from waiting list of {self.getFullName()}"
            )
            return True
        except Exception as e:
            print("Error dropping course")
            logger.error("Error dropping course")

    def getWaitingCoursesLength(self):
        return len(self.__waitingCourses)

    # Available Courses
    """
    If course is not in waiting list, approved list or courses that student has already passed

    If student has passed prerequisites
    """

    def getAvailableCourses(self):
        availableCourses = []

        # Getting all courses from database
        from DataInitializer import DataInitializer

        data = DataInitializer()
        allCourses = data.course_sections

        for course in allCourses:
            if self.__canStudentTakeCourse(course):
                availableCourses.append(course)

        return availableCourses

    # Private helper methods
    def __isCourseInWaitingCoursesList(self, course: CourseSection):
        return course in self.__waitingCourses

    def __isCourseInApprovedCoursesList(self, course: CourseSection):
        return course in self.__approvedCourses

    def __isCourseInRejectedCoursesList(self, course: CourseSection):
        return course in self.__rejectedCourses

    def __isCourseInCurrentCoursesList(self, course: CourseSection):
        return self.__isCourseInWaitingCoursesList(
            course
        ) or self.__isCourseInApprovedCoursesList(course)

    def __isStudentAlreadyPassedCourse(self, course: CourseSection):
        if self.__transcript.is_course_passed(course):
            return True
        return False

    # Checks passed courses with short names of prerequisites
    def __isStudentPassedPrerequisites(self, course: CourseSection):
        prerequisites = course.get_prerequisites().split(",")
        passedCourses_shortNames = self.__transcript.get_passed_course_short_names()
        # if course.full_name == "Calculus II":
        #     print(prerequisites)
        #     print(passedCourses_shortNames)

        # Remove '' if prerequisites is empty
        if prerequisites == [""]:
            prerequisites = []

        # if course.full_name == "Calculus II":
        #     print(prerequisites)
        #     print(passedCourses_shortNames)

        for prerequisite in prerequisites:
            if prerequisite not in passedCourses_shortNames:
                return False

        return True

    # Checks student's semester with semester of course
    # If student's semester is greater or equal than semester of course, returns True
    def __isStudentHasNeededSemester(self, course: CourseSection):
        if course.type == "nonTechnicalElective":
            if self.__semester == 2 or self.__semester >= 7:
                return True
            else:
                False
        elif self.__semester >= course.semester:
            return True

    def __isStudentCanTakeTechnicalElective(self, course: CourseSection):
        if course.type == "technicalElective":
            if (
                self.__semester >= 7
                and self.__transcript.get_passed_total_course_credit() >= 165
            ):
                return True
            else:
                return False
        else:
            return True

    # Checks if student can take course
    def __canStudentTakeCourse(self, course: CourseSection):
        # Check if course is in current courses list( waiting, approved or rejected courses)

        if self.__isCourseInCurrentCoursesList(course):
            return False

        # Check if student has already passed course
        if self.__isStudentAlreadyPassedCourse(course):
            return False

        # Check if student has passed prerequisites
        if not self.__isStudentPassedPrerequisites(course):
            return False

        # Check if student has needed semester
        if not self.__isStudentHasNeededSemester(course):
            # if course.full_name == "Physics II":
            #     print("Physics II")
            return False

        if not self.__isStudentCanTakeTechnicalElective(course):
            return False

        return True

    # Computes the total number of credits of courses in waiting list
    def getTotalCredits(self):
        totalCredits = 0

        for course in self.__waitingCourses:
            totalCredits += course.getCredit()

        return totalCredits

    def getWarnings(self):
        warnings = []
        current_credit = 0
        for course in self.__waitingCourses + self.__approvedCourses:
            current_credit += course.getCredit()
        if current_credit > MAX_CREDIT_LIMIT:
            warnings.append("Warning: Maximum credit limit exceeded")

        return warnings

    # Check overlap between courses in waiting list
    def checkOverlap(self):
        pass

    # Prints weekly schedule
    def printWeeklySchedule(self):
        from tabulate import tabulate

        courseSections = self.__waitingCourses

        monday, tuesday, wednesday, thursday, friday = {}, {}, {}, {}, {}

        headers = ["Time/Day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]

        table = []

        for courseSection in courseSections:
            courseSectionDates = courseSection.dates
            for date in courseSectionDates:
                dateDay = date.day_of_week
                dateStartTime = date.start_time
                dateEndTime = date.end_time

                interval = dateStartTime + " - " + dateEndTime

                if dateDay == "Monday":
                    monday[interval] = courseSection
                elif dateDay == "Tuesday":
                    tuesday[interval] = courseSection
                elif dateDay == "Wednesday":
                    wednesday[interval] = courseSection
                elif dateDay == "Thursday":
                    thursday[interval] = courseSection
                elif dateDay == "Friday":
                    friday[interval] = courseSection

        intervals = (
            list(monday.keys())
            + list(tuesday.keys())
            + list(wednesday.keys())
            + list(thursday.keys())
            + list(friday.keys())
        )
        intervals = sorted(list(set(intervals)))

        for interval in intervals:
            row = []
            row.append(interval)
            if interval in monday:
                row.append(monday[interval].get_full_name())
            else:
                row.append("")
            if interval in tuesday:
                row.append(tuesday[interval].get_full_name())
            else:
                row.append("")
            if interval in wednesday:
                row.append(wednesday[interval].get_full_name())
            else:
                row.append("")
            if interval in thursday:
                row.append(thursday[interval].get_full_name())
            else:
                row.append("")
            if interval in friday:
                row.append(friday[interval].get_full_name())
            else:
                row.append("")

            table.append(row)

        print(tabulate(table, headers=headers, tablefmt="fancy_grid"))

    def MENU_ADD_COURSE(self):
        availableCourses = self.getAvailableCourses()

        if len(availableCourses) == 0:
            print(colored_string("No available courses", "red"))
            self.getManipulationMenu()
            return

        for index, course in enumerate(availableCourses):
            print(
                colored_string(f"{index+1}", PRIMARY_COLOR)
                + colored_string("-", SECONDARY_COLOR)
                + colored_string(f" {course.full_name}", TEXT_COLOR)
                + colored_string(f", {course.type}", TEXT_COLOR)
            )

        print(colored_string("Please select a course: ", INPUT_COLOR))
        print(colored_string("0 for go back to menu", INPUT_COLOR))
        option = -1
        while option < 0 or option > len(availableCourses):
            try:
                option = int(input())
            except TypeError:
                print("Please enter a valid option")
                continue

            if option == 0:
                self.getManipulationMenu()
                return

            if option < 0 or option > len(availableCourses):
                print("Please enter a valid option")
                continue

            try:
                self.addCourse(availableCourses[option - 1])
                logger.info(
                    f"Course {availableCourses[option-1].full_name} added to waiting list of {self.getFullName()}"
                )
                self.write()
                self.MENU_ADD_COURSE()
                return
            except Exception as e:
                print(f"Error adding course: {e}")
                logger.error(f"Error adding course: {e}")
            return

    def MENU_DROP_COURSE(self):
        waitingCourses = self.__waitingCourses

        if len(waitingCourses) == 0:
            print(colored_string("No courses in waiting list", "red"))
            self.getManipulationMenu()
            return

        for index, course in enumerate(waitingCourses):
            print(
                colored_string(f"{index+1}", PRIMARY_COLOR)
                + colored_string("-", SECONDARY_COLOR)
                + colored_string(f" {course.full_name}", TEXT_COLOR)
            )

        print(colored_string("Please select a course: ", INPUT_COLOR))
        print(colored_string("0 for go back to menu", INPUT_COLOR))
        option = -1
        while option < 0 or option > len(waitingCourses):
            try:
                option = int(input())
            except TypeError:
                print("Please enter a valid option")
                continue

            if option == 0:
                self.getManipulationMenu()
                return

            if option < 0 or option > len(waitingCourses):
                print("Please enter a valid option")
                continue

            try:
                self.dropCourse(waitingCourses[option - 1])
                self.write()
                self.MENU_DROP_COURSE()
                return
            except Exception as e:
                print(f"Error dropping course: {e}")
                logger.error(f"Error dropping course: {e}")
            return

    def MENU_LIST_AVAILABLE_COURSES(self):
        from tabulate import tabulate

        if len(self.getAvailableCourses()) == 0:
            print(colored_string("No available courses", "red"))
            self.getInformationMenu()
            return

        # Prints available courses' full name, short name, credit, lecturer name
        headers = [
            "Full Name",
            "Short Name",
            "Credit",
            "Lecturer Name",
            "Time/Day",
            "Type",
        ]
        headers_with_color = [colored_string(header, "magenta") for header in headers]
        table = []
        for index, course in enumerate(self.getAvailableCourses()):
            # row color is green if index even, else row color is blue
            if index % 2 == 0:
                row_color = "green"
            else:
                row_color = "cyan"

            row = []
            row.append(course.full_name)
            row.append(course.short_name + " " + course.section_name)
            row.append(str(course.credit))
            row.append(course.get_lecturer_full_name())

            dates = course.dates
            time_day = ""
            # Monday[09:00-10:00] Tuesday[09:00-10:00] Wednesday[09:00-10:00] Thursday[09:00-10:00] Friday[09:00-10:00]
            for date in dates:
                time_day += (
                    date.day_of_week
                    + "["
                    + date.start_time
                    + "-"
                    + date.end_time
                    + "] "
                )
            row.append(time_day)
            row.append(course.type)
            # changein every item's color in row
            row = [colored_string(item, row_color) for item in row]

            table.append(row)

        print(
            tabulate(
                tabular_data=table, headers=headers_with_color, tablefmt="fancy_grid"
            )
        )

        # print(colored_string(f"{index+1}", PRIMARY_COLOR) + colored_string("-", SECONDARY_COLOR) + colored_string(f" {course.full_name}", TEXT_COLOR) + colored_string(f" {course.credit}", TEXT_COLOR))

        print(colored_string("=====================================", "black"))
        self.getInformationMenu()
        return

    def MENU_LIST_WAITING_COURSES(self):
        print("=====================================")
        if len(self.__waitingCourses) == 0:
            print(colored_string("No courses in waiting list", "red"))
            self.getInformationMenu()
            return

        for index, course in enumerate(self.__waitingCourses):
            print(
                colored_string(f"{course.full_name}", TEXT_COLOR)
                + colored_string(f" {course.credit}", TEXT_COLOR)
            )

        print(colored_string("=====================================", "black"))
        self.getInformationMenu()
        return

    def MENU_LIST_APPROVED_COURSES(self):
        print("=====================================")
        if len(self.__approvedCourses) == 0:
            print(colored_string("No courses in approved list", "red"))
            self.getInformationMenu()
            return

        for index, course in enumerate(self.__approvedCourses):
            print(
                colored_string(f"{course.full_name}", TEXT_COLOR)
                + colored_string(f" {course.credit}", TEXT_COLOR)
            )

        print(colored_string("=====================================", "black"))
        self.getInformationMenu()
        return

    def MENU_LIST_REJECTED_COURSES(self):
        print("=====================================")
        if len(self.__rejectedCourses) == 0:
            print(colored_string("No courses in rejected list", "red"))
            self.getInformationMenu()
            return

        for index, course in enumerate(self.__rejectedCourses):
            print(
                colored_string(f"{course.full_name}", TEXT_COLOR)
                + colored_string(f" {course.credit}", TEXT_COLOR)
            )

        print(colored_string("=====================================", "black"))
        self.getInformationMenu()
        return

    def MENU_LIST_TRANSCRIPT(self):
        self.printTranscript()
        self.getInformationMenu()
        return

    def MENU_DISPLAY_WEEKLY_SCHEDULE(self):
        self.printWeeklySchedule()
        self.getInformationMenu()
        return

    def MENU_EXIT(self):
        self.write()
        import Controller

    def getMenu(self):
        MenuString = (
            colored_string(f"Welcome {self.getFullName()}", "green")
            + "\n"
            + colored_string("1", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " Manipulation Menu(Add/Drop)\n"
            + colored_string("2", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " Imformation Menu(List)\n"
            # other menu option
            + colored_string("8", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " Display weekly schedule\n"
            + colored_string("9", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + colored_string(" Exit\n", EXIT_COLOR)
            + colored_string("Please select an option: ", "yellow")
        )

        print(MenuString)
        option = -1
        while option < 1 or option > 9:
            try:
                option = int(input())
            except TypeError or ValueError:
                print("Please enter a valid option")
                continue

            if option == 1:
                self.getManipulationMenu()
            elif option == 2:
                self.getInformationMenu()
            elif option == 8:
                self.MENU_DISPLAY_WEEKLY_SCHEDULE()
            elif option == 9:
                self.MENU_EXIT()
            else:
                print("Please enter a valid option")
                continue

    def getInformationMenu(self):
        MenuString = (
            colored_string("Information Menu", "green")
            + "\n"
            + colored_string("1", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " List available courses\n"
            + colored_string("2", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " List waiting courses\n"
            + colored_string("3", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " List approved courses\n"
            + colored_string("4", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " List rejected courses\n"
            + colored_string("5", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " List transcript\n"
            + colored_string("8", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " Exit \n"
            + colored_string("Please select an option: ", "yellow")
        )
        print(MenuString)
        option = 0
        while True:
            try:
                option = int(input())
            except TypeError or ValueError:
                print("Please enter a valid option")
                pass

            if option == 1:
                self.MENU_LIST_AVAILABLE_COURSES()
            elif option == 2:
                self.MENU_LIST_WAITING_COURSES()
            elif option == 3:
                self.MENU_LIST_APPROVED_COURSES()
            elif option == 4:
                self.MENU_LIST_REJECTED_COURSES()
            elif option == 5:
                self.MENU_LIST_TRANSCRIPT()
            elif option == 8:
                self.getMenu()
            else:
                print("Please enter a valid option")
                continue

    def getManipulationMenu(self):
        MenuString = (
            colored_string("Manipulation Menu", "green")
            + "\n"
            + colored_string("1", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " Add course to waiting list\n"
            + colored_string("2", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " Drop course from waiting list\n"
            + colored_string("8", PRIMARY_COLOR)
            + colored_string("-", SECONDARY_COLOR)
            + " Exit \n"
            + colored_string("Please select an option: ", "yellow")
        )

        print(MenuString)
        option = 0
        while True:
            try:
                option = int(input())
            except TypeError or ValueError:
                print("Please enter a valid option")
                pass

            if option == 1:
                self.MENU_ADD_COURSE()
            elif option == 2:
                self.MENU_DROP_COURSE()
            elif option == 8:
                self.getMenu()
            else:
                print("Please enter a valid option")
                continue

    def toJson(self):
        return {
            "personName": self._Person__personName,
            "personSurname": self._Person__personSurname,
            "username": self._Person__username,
            "password": self._Person__password,
            "semester": self.__semester,
            "status": self.__status,
            "waitingCourses": [
                {
                    "shortName": course_section.short_name,
                    "sectionName": course_section.section_name,
                }
                for course_section in self.__waitingCourses
            ],
            "approvedCourses": [
                {
                    "shortName": course_section.short_name,
                    "sectionName": course_section.section_name,
                }
                for course_section in self.__approvedCourses
            ],
            "rejectedCourses": [
                {
                    "shortName": course_section.short_name,
                    "sectionName": course_section.section_name,
                }
                for course_section in self.__rejectedCourses
            ],
            "transcript": self.__transcript.to_json(),
        }

    # it can be used for writing to json file
    def write(self):
        from DataInitializer import DataInitializer

        dataInitializer = DataInitializer()
        dataInitializer.write_student(self)


def colored_string(text, color):
    colors = {
        "reset": "\033[0m",
        "black": "\033[30m",
        "red": "\033[31m",
        "green": "\033[32m",
        "yellow": "\033[33m",
        "blue": "\033[34m",
        "magenta": "\033[35m",
        "cyan": "\033[36m",
        "white": "\033[37m",
    }

    if color not in colors:
        raise ValueError("Geçersiz renk: {}".format(color))

    return colors[color] + text + colors["reset"]
