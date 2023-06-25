import java.util.Arrays;

/** 
 * Making Dealership class as the managers class
 * manages Car class objects
 */
public class Dealership {

    /**  creating a field that is an array of Car objects
     by default the value will be null
    */
    private Car[] cars;

    /**
     * Constructor - setting instance variable to a new Car[] array with the same length as parameter -
     * - then using for loop to copy each element of array parameter onto instance variable (array)
     * again, using a deep copy of object instead of Arrays.toCopyOf(), which is just a shallow copy that would still point to same reference
     * @param Car[] array of objects
     */
    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
        
    }

    /**
     * Setter method: adding Car objects to the field, hence the parameters
     * @param car (object to be added)
     * @param index (target index position of object in the array)
     * 
     * inside method: setting the index position selected in the array to a new Car object using the copy constructor -
     * - to add the Car object; again, using the copy constructor to avoid reference traps from happening when setting objects to each other
     */
    public void setCar(Car car, int index) {
        this.cars[index] = new Car(car);

    }

    /**
     * Grabbing a specific car object from the cars array in class
     * NOT using Cars[] getCars() because that would return the entire array or a copy of it. Waste of memory
     * @param index (position)
     * @return a new Car object of that index position; essentially making a copy of that object to avoid a reference trap
     * 
     */
    public Car getCar(int index) {
        return new Car(this.cars[index]);
    }

    /**
     * "Selling" a car; setting the selected car based on index to drive() -
     * - and setting it to null (because it's been sold an not part of dealership cars no more)
     * that null position leaves room for an object that can be added
     * @param int index of object
     */

    public void sell(int index) {
        this.cars[index].drive();
        this.cars[index] = null;

    }

    /**
     * Searching for a car based on make and price
     * @param String make
     * @param double price
     * @return String with index position and object with toString() to display full info
     * for loop will crash if it encounters a null in the array (NullPointerException) -
     * - throwing in condition to check if there's a null and skip it if there is one.
     */
    public String search(String make, int budget) {
        for (int i=0; i < this.cars.length; i++) {
            if(this.cars[i] == null) {
                continue;
            } else if (this.cars[i].getMake().equals(make) && this.cars[i].getPrice() <= budget) {
                return "\nWe have found one in spot " + i + "\n" + this.cars[i].toString() +
                "\nAre you interested?";
            }
        }
        return "Sorry, we couldn't find any cars";
    }
    /**
     * toString() method for dealership class
     * @return String (Parking spots and car objects with toString())
     * implementing a condition to check a null and return string that says empty -
     * - else loop goes through and adds car objects with .toString()
     */

    public String toString(){
        String temp = "";
        for (int i=0; i < this.cars.length; i++) {
            temp = temp + "Parking Spot: " + i + "\n";
            if(this.cars[i] == null) {
                temp = temp + "Spot is empty\n";
            } else {
            temp = temp + this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }
}    
