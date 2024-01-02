class Course:
    def __init__(self, shortName="", fullName="", description="", prerequisite=None, semester=0, credit=0, classHours=0):
        self.shortName = shortName
        self.fullName = fullName
        self.description = description
        self.prerequisite = prerequisite if prerequisite is not None else []
        self.semester = semester
        self.credit = credit
        self.classHours = classHours

    def get_short_name(self):
        return self.shortName

    def set_short_name(self, shortName):
        self.shortName = shortName

    def get_full_name(self):
        return self.fullName

    def set_full_name(self, fullName):
        self.fullName = fullName

    def get_description(self):
        return self.description

    def set_description(self, description):
        self.description = description

    def get_prerequisite(self):
        return self.prerequisite

    def set_prerequisite(self, prerequisite):
        self.prerequisite = prerequisite

    def remove_prerequisite(self, prerequisite):
        if prerequisite in self.prerequisite:
            self.prerequisite.remove(prerequisite)
            return True
        return False

    def add_prerequisite(self, prerequisite):
        self.prerequisite.append(prerequisite)
        return True

    def get_semester(self):
        return self.semester

    def set_semester(self, semester):
        self.semester = semester

    def get_credit(self):
        return self.credit

    def set_credit(self, credit):
        if 0 < credit < 10:
            self.credit = credit
        else:
            print("Credit must be between 1 and 9")

    def get_class_hours(self):
        return self.classHours

    def set_class_hours(self, classHours):
        if 0 < classHours < 10:
            self.classHours = classHours
        else:
            print("Class hours must be between 1 and 9")

    def get_prerequisites(self):
        if not self.prerequisite or len(self.prerequisite) == 0:
            return "There is no prerequisite"
        return " ".join(self.prerequisite)

    def __str__(self):
        return f"Course Code: {self.shortName}\nCourse Name: {self.fullName}\nDescription: {self.description}\nPrerequisite: {self.get_prerequisites()}\nSemester: {self.semester}\nCredit: {self.credit}\nClass Hours: {self.classHours}\n---------"

