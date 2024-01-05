from Person import Person


class Staff(Person):
    def __init__(
        self,
        person_name,
        person_surname,
        username,
        password,
        reputation,
        office_hours,
        salary,
        employment_status,
    ):
        super().__init__(person_name, person_surname, username, password)
        self.__reputation = reputation
        self.__office_hours = office_hours
        self.__salary = salary
        self.__employment_status = employment_status

    @property
    def reputation(self):
        return self.__reputation

    @reputation.setter
    def reputation(self, reputation):
        self.__reputation = reputation

    @property
    def office_hours(self):
        return self.__office_hours

    @office_hours.setter
    def office_hours(self, office_hours):
        self.__office_hours = office_hours

    def add_office_hour(self, office_hour):
        self.__office_hours.append(office_hour)
        return True

    def delete_office_hour(self, office_hour):
        if office_hour in self.__office_hours:
            self.__office_hours.remove(office_hour)
            return True
        return False

    @property
    def salary(self):
        return self.__salary

    @salary.setter
    def salary(self, salary):
        self.__salary = salary

    @property
    def employment_status(self):
        return self.__employment_status

    @employment_status.setter
    def employment_status(self, employment_status):
        self.__employment_status = employment_status
