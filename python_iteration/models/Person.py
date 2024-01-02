from abc import ABC, abstractmethod

class Person(ABC):
    def __init__(self, personName, personSurname, username, password):
        self.__personName = personName
        self.__personSurname = personSurname
        self.__username = username
        self.__password = password
    
    @property
    def getPersonName(self):
        return self.__personName

    @getPersonName.setter
    def setPersonName(self, personName):
        self.__personName = personName

    @property
    def getPersonSurname(self):
        return self.__personSurname

    @getPersonSurname.setter
    def setPersonSurname(self, personSurname):
        self.__personSurname = personSurname

    def getFullName(self):
        return self.__personName + " " + self.__personSurname
    
    @property
    def getUsername(self):
        return self.__username

    @getUsername.setter
    def setUsername(self, username):
        self.__username = username
    
    @property
    def getPassword(self):
        return self.__password

    @getPassword.setter
    def setPassword(self, password):
        self.__password = password

    # There must be an abstract method for the menu
    @abstractmethod
    def getMenu(self):
        pass
