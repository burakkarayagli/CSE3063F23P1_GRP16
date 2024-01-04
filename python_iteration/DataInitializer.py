
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
    
    def read_lecturers(self):
        self.lecturers = self.parameters[0]["lecturers"]
    
    def read_courses(self):
        self.courses = self.parameters[0]["courses"]

    def read_all(self):
        self.read_parameters()
        self.read_advisors()
        self.read_students()
        self.read_lecturers()





        
        

