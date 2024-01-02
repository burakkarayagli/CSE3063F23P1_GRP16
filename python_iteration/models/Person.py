
class Person:    
    def __init__(self, personName, personSurname, username, password):
        self.personName = personName
        self.personSurname = personSurname
        self.username = username
        self.password = password
    
    
    def getPersonName(self):
        return self.personName
    
    def getFullName(self):
        return self.personName+" "+self.personSurname
    
    def setPersonName(self, personName):
        self.personName = personName
    
    def getPersonSurname(self):
        return self.personSurname

    def setPersonSurname(self, personSurname):
        self.personName = personName

    
    def getUsername(self):
        return self.username

    def setUsername(self, username):
        self.username = username
    
    def setPassword(self, password):
        self.password = password

    
    def getMenu(self):
        pass