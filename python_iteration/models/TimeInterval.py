class TimeInterval:
    def __init__(self, start_time, end_time, day_of_week):
        self.__day_of_week = day_of_week
        self.__start_time = start_time
        self.__end_time = end_time

    def __eq__(self, other):
        # compare the day_of_week and start_time
        if isinstance(other, TimeInterval):
            if self.day_of_week == other.day_of_week:
                if self.start_time == other.start_time:
                    return True
            return False
        else:
            raise TypeError("other must be a TimeInterval object")

    @property
    def day_of_week(self):
        return self.__day_of_week

    @day_of_week.setter
    def day_of_week(self, day_of_week):
        if isinstance(day_of_week, str):
            self.__day_of_week = day_of_week
        else:
            raise TypeError("day_of_week must be a string")

    @property
    def start_time(self):
        return self.__start_time

    @start_time.setter
    def start_time(self, start_time):
        if isinstance(start_time, str):
            self.__start_time = start_time
        else:
            raise TypeError("start_time must be a string")

    @property
    def end_time(self):
        return self.__end_time

    @end_time.setter
    def end_time(self, end_time):
        if isinstance(end_time, str):
            self.__end_time = end_time
        else:
            raise TypeError("end_time must be a string")

    def __str__(self):
        return f"Date: {self.day_of_week}, {self.start_time} - {self.end_time}\n"
