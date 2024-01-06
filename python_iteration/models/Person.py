from abc import ABC, abstractmethod


class Person(ABC):
    def __init__(self, personName, personSurname, username, password):
        self.__personName = personName
        self.__personSurname = personSurname
        self.__username = username
        self.__password = password

    @property
    def personName(self):
        return self.__personName

    @personName.setter
    def personName(self, personName):
        self.__personName = personName

    @property
    def personSurname(self):
        return self.__personSurname

    @personSurname.setter
    def personSurname(self, personSurname):
        self.__personSurname = personSurname

    def getFullName(self):
        return self.__personName + " " + self.__personSurname

    @property
    def username(self):
        return self.__username

    @username.setter
    def username(self, username):
        self.__username = username

    @property
    def password(self):
        return self.__password

    @password.setter
    def setPassword(self, password):
        self.__password = password

    # It extensively displays information related to the user.
    # It will display accordingly with the type of the user.(advisor, student, etc.)
    @abstractmethod
    def getInformationMenu(self):
        pass

    # There must be an abstract method for the menu
    # There will be menus exist depending on the type of the user.
    @abstractmethod
    def getMenu(self):
        pass

    def getManipulationMenu():
        pass

    def __str__(self):
        return self.__personName + " " + self.__personSurname
