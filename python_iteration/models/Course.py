from types import List


class Course:
    def __init__(
        self,
        short_name="",
        full_name="",
        description="",
        prerequisite=List[str](),
        semester=0,
        credit=0,
    ):
        self.__short_name = short_name
        self.__full_name = full_name
        self.__description = description
        self.__prerequisite = prerequisite
        self.__semester = semester
        self.__credit = credit

    @property
    def short_name(self) -> str:
        return self.__short_name

    @short_name.setter
    def short_name(self, short_name: str):
        self.__short_name = short_name

    @property
    def full_name(self) -> str:
        return self.__full_name

    @full_name.setter
    def full_name(self, full_name: str):
        self.__full_name = full_name

    @property
    def description(self) -> str:
        return self.__description

    @description.setter
    def description(self, description: str):
        self.__description = description

    @property
    def semester(self) -> int:
        return self.__semester

    @semester.setter
    def semester(self, semester: int):
        self.__semester = semester

    @property
    def credit(self) -> str:
        self.__credit

    @property.setter
    def credit(self, credit: int):
        if 0 < credit < 10:
            self.__credit = credit
        else:
            print("Credit must be between 1 and 9")

    def add_prerequisite(self, prerequisite: str) -> bool:
        self.__prerequisite.append(prerequisite)
        return True

    def remove_prerequisite(self, prerequisite: str) -> bool:
        if prerequisite in self.__prerequisite:
            self.__prerequisite.remove(prerequisite)
            return True
        return False

    def get_prerequisites(self) -> str:
        if not self.__prerequisite or len(self.__prerequisite) == 0:
            return "There is no prerequisite"
        return ",".join(self.prerequisite)

    def __str__(self):
        return (
            f"Course Code: {self.short_name}\n"
            f"Course Name: {self.full_name}\n"
            f"Description: {self.description}\n"
            f"Prerequisite: {self.get_prerequisites()}\n"
            f"Semester: {self.semester}\n"
            f"Credit: {self.credit}\n"
            f"---------"
        )
