import java.util.Arrays;

public class Car {
        // making the fields private; Fields should always be private; should NOT have direct access to them outside of the Class
    // 'private' prevents from accessing fields directly and possibly changing it unintentionally; preserves the state of the object
    // when you adding a new field, make sure to UPDATE everything applicable; constructors, copy constructor, getters and setters...
    private String make;
    private double price;
    private int year;
    private String color;
    private String[] parts;

    public Car(String make, double price, int year, String color, String[] parts) {
        this.make = make;
        this.price = price;
        this.year = year;
        this.color = color;
        // setting it to a copy of the array, not the actual array parameter; remember Reference Trap
        // if you set it to the parts array, then multiple things will refer to the same parts array
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    // Getters and Setters Methods (a.k.a Accessors and Mutators)

    // Getter (Accessors) method: returns a field's value; they don't take parameters
    // creating getter methods for each field of Class
    public String getMake() {
        return this.make;
    }

    public double getPrice() {
        return this.price;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public String[] getParts() {
        // return a copy of array, not the actual field
        return Arrays.copyOf(this.parts, this.parts.length);
    }

    // Setters (Mutators) method: updates a field
    // inside the methods, set the current fields to the parameters to update them
    public void setMake(String make) {
        this.make = make;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setParts(String[] parts) {
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    // Copy Constructor
    public Car(Car source) {
        this.make = source.make;
        this.price = source.price;
        this.year = source.year;
        this.color = source.color;
        this.parts = Arrays.copyOf(source.parts, source.parts.length);
    }

    // Actions
    public void drive() {
        System.out.println("You bought the beautiful " + this.year + " " + this.color + " " + this.make + " for " + this.price + ".");
        System.out.println("Please drive your car to the nearest exit.\n");
    }

    // this method will connect every field from the object that calls it into a string and returns it
    // to call this method, just print out with the object as the argument, ex. System.out.println(objectName) or (objectName.toString());
    // without this method, printing out the object would just print out the class name with a hash code in the terminal
    public String toString() {
        return "Make: " + this.make + ".\n"
            + "Price: " + this.price + ".\n"
            + "Year: " + this.year + ".\n"
            + "Color: " + this.color + ".\n"
            + "Parts: " + Arrays.toString(parts) + ".\n";

    }
}
