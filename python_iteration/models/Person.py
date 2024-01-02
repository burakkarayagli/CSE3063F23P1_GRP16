from abc import ABC, abstractmethod
class Person:    
    def __init__(self, personName, personSurname, username, password):
        self.__personName = personName
        self.__personSurname = personSurname
        self.__username = username
        self.__password = password
    
    
    def getPersonName(self):
        return self.__personName
    
    def getFullName(self):
        return self.__personName+" "+self.__personSurname
    
    def setPersonName(self, personName):
        self.__personName = personName
    
    def getPersonSurname(self):
        return self.__personSurname

    def setPersonSurname(self, personSurname):
        self.__personName = personName

    
    def getUsername(self):
        return self.__username

    def setUsername(self, username):
        self.__username = username
    
    def setPassword(self, password):
        self.__password = password

    # There must be an abstract method for menu
    @abstractmethod
    def getMenu(self):
        pass