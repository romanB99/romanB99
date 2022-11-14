
/*
 * class name = Car
 * Name = Roman Brik
 * ID = 207412735
 * this is the Car class of maman 12.

 */

public class Car {

    private final int ID_MIN = 1000000;
    private final int ID_MAX = 9999999;

    private final int DEFAULT_ID = 9999999;
    private final char DEFAULT_TYPE = 'A';
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

//constructors
    /**
     *
     * @param id    an integer which is valid only when is 7 digits, if it won't be valid will place the DEFAULT_ID which is  9999999
     * @param type  is a char A|B|C|D, D is the best and A is the worst. if the type entered is not valid (not in A|B|C|D) than it will set the default type of 'A'
     * @param brand is a string - car brand name for example "Mazda" or "BMW" or "Toyota"
     * @param isManual a flag that is true if the car is manual and false when it's automatic.
     */
    public Car(int id, char type,String brand, boolean isManual){
        boolean length = id >= ID_MIN &&  id <= ID_MAX;                 //check that the id is between 1000000 and 9999999 if its not its not valid
        if(isValid(id,type)){
            _id = id;
            _type = type;
            _brand = brand;
            _isManual = isManual;
        }
        else {
            _brand = brand;
            _isManual = isManual;
            if (length)             // length will be true if the id will be between 1000000 and 9999999
                _id = id;
            else
                _id = DEFAULT_ID;
            if ((type != 'A' && type != 'B' && type != 'C' && type != 'D'))     //if the type is not A or B or C or D than set to default type of 'A'
                _type = DEFAULT_TYPE;
            else
                _type = type;
        }

    }
//copy constructor
    /**
     *
     * @param other gets Car object and copies it to a new place in memory.
     */
    public Car(Car other){
        boolean length = other._id >= ID_MIN &&  other._id <= ID_MAX;                 //check that the id is between 1000000 and 9999999 if its not its not valid
            if(isValid(other._id,other._type)) {
                _brand = other._brand;
                _isManual = other._isManual;
                _id = other._id;
                _type = other._type;
            }
            else {
                _brand = other._brand;
                _isManual = other._isManual;
                if (length)             // length will be true if the id will be between 1000000 and 9999999
                    _id = other._id;
                else
                    _id = DEFAULT_ID;
                if ((other._type != 'A' && other._type != 'B' && other._type != 'C' && other._type != 'D'))     //if the type is not A or B or C or D than set to default type of 'A'
                _type = DEFAULT_TYPE;
                else
                    _type = other._type;
            }
    }

    //getters
    //id getter
    public int getId(){
        return _id;
    }
    //type getter
    public char getType(){
        return _type;
    }
    //brand getter
    public String getBrand(){
        return _brand;
    }
    //isManual getter
    public boolean isManual(){
        return _isManual;
    }
    //setters

    /**
     *
     * @param id gets an int value -  id from the user to set and checks if the id is valid. if it is valid it will replace the id of the object if not valid it won't do anything
     */
    //id setter
    public void setId(int id){
        if(isValid(id, _type))
             _id = id;          //if valid update if not stay the same
    }
    /**
     *
     * @param type gets a char value - type value from the user if it isn't A|B|C|D than it won't change the current type value, if it is valid it will change it.
     */
    //type setter
    public void setType(char type){
        if(isValid(_id, type))
            _type = type;       //if valid update if not stay the same
    }
    /**
     *
     * @param brand gets a String - it will update the current brand in the object with the new brand the user input.
     */
    //brand setter
    public void setBrand(String brand){
        _brand = brand;
    }

    /**
     *
     * @param manual gets a boolean value and updates the current isManual variable in the current object.
     */
    //isManual setter
    public void setIsManual(boolean manual) {
        _isManual = manual;
    }

    /**
     *
     * @return  String that represents the Car object. and example of the output will be - id:1234567 type:B brand Toyota manual
     */
    //toString function
    public String toString(){
        if(_isManual == true)
            return("id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + "manual");              //if isManual is true than its manual and print "manual"
        else
            return("id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + "auto");                //if isManual is false than its automatic and print "auto"


    }

    /**
     *
     * @param other the Car object that compares to this Car object
     * @return true if the two Car object are equal else returns false . cars are the same if they will have the same type,brand,and gear.
     */
    //equals function
    public boolean equals (Car other){
        if(_type == other._type && _brand.equals(other._brand) && _isManual == other._isManual)         //checking if all the fields of Car are equal besides the ID (type,isManual,brand)
            return true;
        else
            return false;
    }
    /**
     *
     * @param other the Car object that compares to this Car object
     * @return true if this car object is better than the Other car Object . this Car will be considered better if it has higher type (example: 'B' > 'A' than the car who is with type B will be better)
     * if the cars have the same type value it will check the isManual flag, the car with the manual flag set to false is considered better.
     * returns false if this car is no better than the other car.
     */
    //better function
    public boolean better (Car other){
        if(other._type < _type)                     //if this type is higher than the Car is better
            return true;
        else if (other._type == _type) {
            if(other._isManual && !_isManual)       //if other is auto and other is manual it will be better
                return true;
            else
                return false;
        }
        else                                    //if other._type is bigger its false
            return false;
    }

    /**
     *
     * @param other the Car object that compares to this Car object
     * @return true if this car is worse than the other car, otherwise false
     */
    //worse function
    public boolean worse (Car other){
        return (other.better(this));           //if its other is better than this is worse
    }

    //function to check validity
    private boolean isValid(int id, char type){
        boolean length = id >= ID_MIN &&  id <= ID_MAX;                 //check that the id is between 1000000 and 9999999 if its not its not valid
        if ((length) && (type == 'A' || type == 'B' || type == 'C' || type == 'D'))           //if length is 7 and type is A or B or C or D then its valid
            return true;
        else
            return false;

    }
}



