
import json
import os

class DataInitializer:
    def __init__(self):
        self.students = []
        self.advisors = []
        self.lecturers = []
        self.parameters = []
        self.courses = []
        self.read_all()
    def read_students(self):
        import json
        directory = os.getcwd() + "/database"  # Use "/" instead of "\"
        for filename in os.listdir(directory):
            if filename != "parameters.json":
                file_dir = os.path.join(directory, filename)
            print(file_dir)
            with open(file_dir, 'r') as f:
                data = json.load(f)
                self.students.append(data)
        
        for i in range(len(self.students)):
            grades = []
            for j in range(len(self.students[i]["transcript"]["listGrades"])):
                course_info = self.students[i]["transcript"]["listGrades"][j]
                course = find_course(course_info["shortName"])
            grades.append(course)
            transcript = Transcript(grades, "")
            student = Student(students[i]["personName"], students[i]["personSurname"], students[i]["username"], students[i]["password"], students[i]["semester"], 
                        students[i]["status"], students[i]["waitingCourses"], students[i]["approvedCourses"], students[i]["rejectedCourses"], transcript)
            self.students[i] = student


    def find_course(self, shortName: str):
        for i in range(len(courses)):
            if courses[i]["shortName"] == shortName:
                return courses[i]


    def find_student(self, personName: str):
        for i in range(len(students)):
            if students[i]["shortName"] == personname:
                return students[i]
        

    def read_parameters(self):
        import json
        directory = os.getcwd() + "/database"  # Use "/" instead of "\"
        for filename in os.listdir(directory):
            file_dir = ""
            print(filename)
            if filename == "parameters.json":
                file_dir = os.path.join(directory, filename)
                with open(file_dir, 'r') as f:
                    data = json.load(f)
                    self.parameters.append(data)
    

    def read_advisors(self):
        self.advisors = self.parameters[0]["advisors"]
        for i in range(len(self.advisors)):
            advisor_students = []
            time_intervals = []
            for j in range(len(self.advisors[i]["officeHours"])):
                office_hours = self.advisors[i]["officeHours"][j]
                time_interval = TimeInterval(office_hours["startTime"], office_hours["endTime"], office_hours["dayOfWeek"])
                time_intervals.append(time_interval)
            
            for j in range(len(self.advisors[i]["students"])):
                student_name = self.advisors[i]["students"][j]["personName"]
                student = find_student(student_name)
                advisor_students.append(student)
            advisor = Advisor(self.advisors[i]["personName"], self.advisors[i]["personSurname"], self.advisors[i]["username"], self.advisors[i]["password"],
            self.advisors[i]["reputation"], time_intervals, self.advisors[i]["salary"], self.advisors[i]["employmentStatus"], advisor_students)
            self.advisors[i] = advisor 

    def read_lecturers(self):
        self.lecturers = self.parameters[0]["lecturers"]
        for i in range(len(self.lecturers)):
            time_intervals = []
            courses = []
            for j in range(len(self.lecturers[i]["officeHours"])):
                office_hours = self.advisors[i]["officeHours"][j]
                time_interval = TimeInterval(office_hours["startTime"], office_hours["endTime"], office_hours["dayOfWeek"])
                time_intervals.append(time_interval)
            
            for j in range(len(self.lecturers[i]["courses"])):
                course_name = self.lecturers[i]["courses"][j]["shortName"]
                course = find_course(course_name)
                courses.append(course)
            lecturer = Lecturer(self.lecturers[i]["personName"], self.lecturers[i]["personSurname"], self.lecturers[i]["username"],
                self.lecturers[i]["password"], self.lecturers[i]["reputation"], office_hours, self.lecturers[i]["salary"], 
                self.lecturers[i]["employmentStatus"])
            self.lecturers[i] = lecturer
    
    def read_courses(self):
        self.courses = self.parameters[0]["courses"]

    def read_all(self):
        self.read_parameters()
        self.read_students()
        self.read_advisors()
        self.read_lecturers()


datainit = DataInitializer()

print(datainit.students[0])





        
        

