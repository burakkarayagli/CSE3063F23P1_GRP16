from DataInitializer import DataInitializer

data = DataInitializer()
courses = data.courses
course_sections = data.course_sections
lecturers = data.lecturers
students = data.students
advisors = data.advisors

logedUser = None


# Login
def login(logedUser):
    print("WELECOME TO COURSE REGISTRATION SYSTEM")
    while logedUser == None:
        username = input("Enter username: ")
        password = input("Enter password: ")
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
