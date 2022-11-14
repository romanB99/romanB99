

/*
 * class name = Date
 * Name = Roman Brik
 * ID = 207412735
 * this is the Date class of maman 12.

 */
public class Date {
    //final variables
    private final int SMALL_FEBRUARY_DAY = 28;
    private final int BIG_FEBRUARY_DAY = 29;
    private final int BIG_MONTH_DAYS = 31;
    private final int REGULAR_MONTH_DAYS = 30;
    private final int YEAR_MIN = 1000;
    private final int YEAR_MAX = 9999;
    private final int NUMBER_OF_MONTHS = 12;
    private final int DEFAULT_DAY = 1;
    private final int DEFAULT_MONTH = 1;
    private final int DEFAULT_YEAR = 2000;
    //Local variables
    private int _day;
    private int _month;
    private int _year;
    //constructor
    /**
     * creates a new Date object
     * @param day the day in the month(1-31) checks for special days in months for example february will have regularly 28 days and in leap year will have 29.
     * or months with 30 days only and some months with 31 days.
     * @param month the month in the year(1-12)
     * @param year the year (in 4 digits)
     * if the Date won't be valid it will set a default date of 01/01/2020
     */
    public Date(int day, int month, int year){
        if(isValid(day,month,year)) {           //validity check
            _day = day;
            _month = month;
            _year = year;
        }
        else {
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;                     //if not valid it's 01/01/2000
            _year = DEFAULT_YEAR;
        }
    }
    //copy constructor
    /**
     *
     * @param other gets Date object and copies it to a new place in memory.
     */
    public Date (Date other){
            if(isValid(other._day,other._month,other._year)) {           //validity check
                _day = other._day;
                _month = other._month;
                _year = other._year;
            }
            else {
                _day = DEFAULT_DAY;
                _month = DEFAULT_MONTH;                     //if not valid it's 01/01/2000
                _year = DEFAULT_YEAR;
            }
    }

    /**
     *
     * @param other the Date object that compares to this Date object
     * @return true if the dates are the same otherwise returns false.
     */
    //equals function
    public boolean equals (Date other){
        if((other._day == _day) && (other._month == _month) && (other._year == _year))                  //checking if all the fields(day,month,year) are equal if yes than -> true else -> false
            return true;
        else
            return false;
    }

    /**
     *
     * @param other the Date object that compares to this Date object
     * @return  true if this Date object is before than the other Date object being compared to otherwise returns false.
     */
    //before function
    public boolean before(Date other) {
        if (this.equals(other))                         //if equals than its not before -> false
                return false;
        if (other._year < _year)                        //if other is before that this is after -> false
            return false;
        else if (other._year == _year) {
            if (other._month == _month) {                       // if year is equal and month is equal but this._day is before than its true else false
                if (other._day > _day)
                    return true;
                else
                    return false;
            } else if (other._month < _month)                   //if other month is before -> false else  -> true
                return false;
             else
                return true;
        } else
            return true;                                        // if this._year is before than  -> true
    }

    /**
     *
     * @param other the Date object that compares to this Date object
     * @return true if this Date object is after than the other Date object being compared to otherwise returns false.
     */
    //after function
    public boolean after(Date other){
        return (other.before(this));
    }

    /**
     *
     * @param other the Date object that compares to this Date object
     * @return the difference in days between the other date and this date. (always will be a positive int). if the dates are the same will return 0.
     */
    //difference function
    public int difference(Date other){
        int numberOfDays = calculateDate(other._day, other._month, other._year);
        int currentDays = calculateDate(_day,_month,_year);
        if(numberOfDays <= currentDays)
            return currentDays - numberOfDays;                      //if current date is after the other.
        else
            return numberOfDays - currentDays;                      //if current date is after the other.
    }

    /**
     *
     * @return a String that represents the Date object. an example of the returned String can be - 10/05/2015 or 01/01/2000.
     */
    //toString function
    public String toString(){
        if(_month/10 == 0 && _day/10 == 0){                         //if day and month number print extra '0' before the number
            return("0" + _day + "/" + "0" + _month + "/" + _year);
        }
        else if (_month/10 == 0 && _day/10 >= 1){
            return(_day + "/" + "0" + _month + "/" + _year);                //if day is 2 numbers and  month is 1 number print extra '0' before the month only
        }
        else if (_month/10 >= 1 && _day/10 == 0){
            return("0" + _day + "/" +  _month + "/" + _year);                //if day is 1 number and  month is 2 number print extra '0' before the day only
        }
        else
            return (_day + "/" + _month + "/" + _year);                     //day and month are 2 numbers than no need to print '0' before
    }

    /**
     *
     * @return a Date object which represents the tomorrow day of the current day of the Date object.
     */
    //tomorrow function
    public Date tomorrow() {
        Date tomorrow = new Date(this);                                                 //need to create new object so we dont change this object
        if (isValid(tomorrow._day + 1,tomorrow._month,tomorrow._year)) {                //checking if next day is valid
            tomorrow._day++;
            tomorrow._month = _month;
            tomorrow._year = _year;
            return tomorrow;
        }
        else if (isValid(tomorrow._day = 1 ,tomorrow._month + 1,tomorrow._year)){           //if next day not valid then check if month has ended
            tomorrow._day = 1;
            tomorrow._month++;
            tomorrow._year = _year;
            return tomorrow;
        }
        else {
            tomorrow._day = 1;                                                               // if the month++ and day = 1 is not valid it means the year has ended
            tomorrow._month = 1;
            tomorrow._year++;
            return tomorrow;
        }
    }
    //getters
    //day getter
    public int getDay(){
        return _day;
    }
    //month getter
    public int getMonth(){
        return _month;
    }
    //year getter
    public int getYear(){
        return _year;
    }
    //setters

    /**
     *
     * @param dayToSet gets a day int and changes the current day if the input day is valid, if not valid won't change anything.
     */
    //day setter
    public void setDay(int dayToSet){
        if(isValid(dayToSet, _month, _year))
            _day = dayToSet;                    //if valid update if not stay the same
    }

    /**
     *
     * @param monthToSet gets a month int and changes the current month if the input month is valid, if not valid won't change anything.
     */
    //month setter
    public void setMonth(int monthToSet){
        if(isValid(_day, monthToSet, _year))
            _month = monthToSet;              //if valid update if not stay the same
    }

    /**
     *
     * @param yearToSet gets a year int and changes the current year if the input year is valid, if not valid won't change anything.
     */
    //year setter
    public void setYear(int yearToSet){
        if(isValid(_day, _month, yearToSet))
             _year = yearToSet;             //if valid update if not stay the same
    }


    //check validity of date provided
    private boolean isValid(int day, int month, int year){
        if (day > BIG_MONTH_DAYS || month > NUMBER_OF_MONTHS || year > YEAR_MAX || year < YEAR_MIN || day <= 0 || month <= 0 )            //general date check
            return false;
        if((month == 4 || month == 6 || month == 9 || month == 11) && day > REGULAR_MONTH_DAYS)
            return false;
        if(month == 2) {                                                             //february check
            if ((year % 400 == 0) || ((year % 4 ==0) && (year % 100 != 0))){        //if the year can be divided by 400 or can be divided by 4 and not 100 there can be 29 days
                if(day > BIG_FEBRUARY_DAY)                                          //if the statement is true than it is a leap year, and the maximum day is 29.
                    return false;
                else
                    return true;
            }
            else if(day > SMALL_FEBRUARY_DAY)                                                       //all other february months can be only 28 days(not leap years)
                return false;
        }
        return true;
    }

    //calculates the days the formula is given.
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }
}
