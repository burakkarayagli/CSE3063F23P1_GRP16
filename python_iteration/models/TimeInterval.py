class TimeInterval:
    def __init__(self, startTime, endTime, dayOfWeek):
        self.__dayOfWeek = dayOfWeek
        self.__startTime = startTime
        self.__endTime = endTime

    def __eq__(self, other):
        if isinstance(other, TimeInterval):
            if self.dayOfWeek == other.dayOfWeek:
                if self.startTime == other.startTime:
                    return True
            return False
        else:
            raise TypeError("other must be a TimeInterval object")

    @property
    def dayOfWeek(self):
        return self.__dayOfWeek

    @dayOfWeek.setter
    def dayOfWeek(self, dayOfWeek):
        if isinstance(dayOfWeek, str):
            self.__dayOfWeek = dayOfWeek
        else:
            raise TypeError("dayOfWeek must be a string")

    @property
    def startTime(self):
        return self.__startTime

    @startTime.setter
    def startTime(self, startTime):
        if isinstance(startTime, str):
            self.__startTime = startTime
        else:
            raise TypeError("startTime must be a string")

    @property
    def endTime(self):
        return self.__endTime

    @endTime.setter
    def endTime(self, endTime):
        if isinstance(endTime, str):
            self.__endTime = endTime
        else:
            raise TypeError("endTime must be a string")

