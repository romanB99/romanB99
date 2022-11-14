
/*
 * class name = Rent
 * Name = Roman Brik
 * ID = 207412735
 * this is the Rent class of maman 12.
 */


public class Rent {
    //finals values
    private final short WEEK_DAYS = 7;
    private final double DISCOUNT = 0.9;
    private final int PRICE_A = 100;
    private final int PRICE_B = 150;
    private final int PRICE_C = 180;
    private final int PRICE_D = 240;
    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;

    //constructor

    /**
     *
     * @param name gets a type String name.
     * @param car get a Car object it will be the car that is being rented.
     * @param pick get a Date object which represents the pickup Date of the car.
     * @param ret get a Date object which represents the return date of the car
     * The return date must be at least one day after the pickup date, otherwise set it to one day after the pick up date manually.
     */
    public Rent(String name, Car car, Date pick, Date ret){
        if(ret.after(pick)){                                        //validity check
            _name = name;
            _car = new Car(car);
            _pickDate = new Date(pick);
            _returnDate = new Date(ret);
        }
        else{
            _name = name;
            _car = new Car(car);
            _pickDate = new Date(pick);
            _returnDate = new Date(pick.tomorrow());             //if return date wasnt at least one day after pick date than return date will be 1 day after pic
        }
    }
    /**
     *
     * @param other gets Rent object and copies it to a new place in memory.
     */
    //copy constructor
    public Rent(Rent other){
            if(other._returnDate.after(other._pickDate)){         //validity check
                _name = other._name;
                _car = new Car(other._car);
                _pickDate = new Date(other._pickDate);
                _returnDate = new Date(other._returnDate);
            }
            else {
                _name = other._name;
                _car = new Car(other._car);
                _pickDate = new Date(other._pickDate);
                _returnDate = new Date(other._pickDate.tomorrow());             //if return date wasnt at least one day after pick date than return date will be 1 day after pic
            }
    }

    /**
     *
     * @param other the Rent object that compares to this Rent object
     * @return true if the two Rent objects are equal otherwise false. it will be considered equal if the name,car,pick and return date are the same.
     */
    //check if equal function
    public boolean equals(Rent other){
        if(other._name.equals(_name) && (other._car.equals(_car)) &&                                      //checking if all the fields(name,Car,return date and pick date) are equal if yes than -> true else -> false
                other._returnDate.equals(_returnDate) && other._pickDate.equals(_pickDate))
            return true;
        else
            return false;
    }

    /**
     *
     * @return returns an integer which represents how many days the rent will be
     */
    //how many days rented calculator
    public int howManyDays(){
        return _pickDate.difference(_returnDate);                                                       //return how many days is rented.
    }

    /**
     *
     * @return an integer which represents the price of the rent, calculated by the type and how many days the rent is.
     */
    // get price method
    public int getPrice(){
        int days = howManyDays();                //number of days
        int howManyWeeks = days/ WEEK_DAYS;        //number of whole weeks
        int daysOfFinalWeek = days% WEEK_DAYS;    //number of reminder days in the final week
            if('A' == _car.getType())
                return (int)(((WEEK_DAYS * PRICE_A *howManyWeeks)*(DISCOUNT)) + (daysOfFinalWeek* PRICE_A));               //calculates price for type A
            else if('B' == _car.getType())
                return (int)(((WEEK_DAYS *PRICE_B*howManyWeeks)*(DISCOUNT)) + (daysOfFinalWeek*PRICE_B));               //calculates price for type B
            else if('C' == _car.getType())
                return (int)(((WEEK_DAYS * PRICE_C *howManyWeeks)*(DISCOUNT)) + (daysOfFinalWeek* PRICE_C));               //calculates price for type C
            else
                return (int)(((WEEK_DAYS *PRICE_D*howManyWeeks)*(DISCOUNT)) + (daysOfFinalWeek*PRICE_D));               //calculates price for type D
    }

    /**
     *
     * @param newCar the Rent object that compares to this Rent object
     * @return it will return an integer which represents the difference in price from the newCar to the old Car.
     * if the two Cars are the same it returns 0.
     */
    //upgrade function
    public int upgrade(Car newCar){
        if(!newCar.better(_car))                 //if the car isn't better no change and return 0
            return 0;
        else{
            int priceBefore = this.getPrice();      //price of rent with old car
            this.setCar(newCar);
            int priceNew = this.getPrice();        //price of rent with new car
            return (priceNew - priceBefore);
        }
    }

    /**
     *
     * @param other the Rent object that compares to this Rent object
     * @return a new Rent object, if the dates overlap it will return the unified dates for example - Rent r1 = 01/05/2020 - 11/05/2020
     * Rent r2 = 05/05/2020 - 15/05/2020.  the returned Rent objct will have pick date of 01/05/2020 and return date of 15/05/2020.
     * returns null if there's no overlap.
     */
    //overlap function returns the lowest date between them and the highest
    public Rent overlap(Rent other){
        if(!other._name.equals(_name) || !other._car.equals(_car))      //if the name or the car of the new rental doesn't overlap
            return null;
        if(other._pickDate.after(_returnDate) || (other._returnDate.before(_pickDate)))            //dates don't overlap
            return null;
        else if(((other._returnDate.after(_returnDate)) || (other._returnDate.equals(_returnDate)))
                && ((other._pickDate.before(_pickDate)) || (other._pickDate.equals(_pickDate))))    //if other pick date is before or equal and return date is after or equal it will be the new date
            return new Rent(other._name, other._car, other._pickDate,other._returnDate);
        else if (((other._returnDate.after(_returnDate)) || (other._returnDate.equals(_returnDate)))
                && ((_pickDate.before(other._pickDate)) || (other._pickDate.equals(_pickDate))))  //if current pick date is before or equal and other return date is after or equal it will be the new date
            return new Rent(other._name, other._car, _pickDate, other._returnDate);
        else if(((_returnDate.after(other._returnDate)) || (other._returnDate.equals(_returnDate)))
                && ((_pickDate.before(other._pickDate)) || (other._pickDate.equals(_pickDate))))     //if current pick date is before or equal and return date is after or equal it will be the new date
            return new Rent(other._name, other._car, _pickDate,_returnDate);
        else
            return new Rent(other._name, other._car, other._pickDate, _returnDate);                 //if other pick date is before or equal and current return date is after or equal it will be the new date
        }
        //toString
    public String toString(){
        return("Name:" + _name + " From:" + _pickDate + " To:" + _returnDate +
                " Type:" + _car.getType() + " Days:" + howManyDays() + " Price:" + getPrice());
    }

    //getters
    //get name
    public String getName() {
        return _name;
    }
    //get car
    public Car getCar(){
        return _car;
    }
    //get pick-date
    public Date getPickDate(){
        return _pickDate;
    }
    //get return date
    public Date getReturnDate(){
        return _returnDate;
    }
    //setters
    //set name
    public void setName(String name){
        _name = name;
    }
    //set car
    public void setCar(Car car){
        _car = car;
    }
    //set pick date
    public void setPickDate(Date pickDate){
        if(_returnDate.after(pickDate))         //validity check
            _pickDate = pickDate;           //if valid update if not stay the same
        else
            _pickDate = _pickDate;
    }
    //set return date
    public void setReturnDate(Date returnDate){
        if(returnDate.after(_pickDate))         //validity check
            _returnDate = returnDate;       //if valid update if not stay the same
        else
            _returnDate = _returnDate;
    }

}
