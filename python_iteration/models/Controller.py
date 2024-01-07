from DataInitializer import DataInitializer

data = DataInitializer()
courses = data.courses
course_sections = data.course_sections
lecturers = data.lecturers
students = data.students
advisors = data.advisors

logedUser = None


# find the student file
if "1" == input("press 1 to search"):
    password = input()
    import os
    import json

    database_folder = "python_iteration/database"

    for student_file in os.listdir(database_folder):
        if student_file != "parameters.json":
            with open(os.path.join(database_folder, student_file), "r") as f:
                data = json.load(f)
                if password == data["password"]:
                    print(student_file)


# Login
def login(logedUser):
    print("WELECOME TO COURSE REGISTRATION SYSTEM")
    while logedUser == None:
        username = "burak"
        password = "burakkarayagli"
        for lecturer in lecturers:
            if lecturer.username == username and lecturer.password == password:
                logedUser = lecturer
                break
        for student in students:
            if student.username == username and student.password == password:
                logedUser = student
                break
        for advisor in advisors:
            if advisor.username == username and advisor.password == password:
                logedUser = advisor
                break
        if logedUser == None:
            print("Wrong username or password. Please try again")
    return logedUser


logedUser = login(logedUser)
logedUser.getMenu()  # burdan girip butun islemleri class in icinde yapilabili
