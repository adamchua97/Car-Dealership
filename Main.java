public class Main {
    public static void main(String[] args) {
        String[] parts = {"tires", "keys"};

        Car[] cars = new Car[] {
            new Car("Nissan", 5000, 2020, "red", new String[] {"tires", "keys"}),
            new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
            new Car("Chevrolet", 9000, 2017, "yellow", new String[] {"tires", "filter"}),
            new Car("Honda", 10000, 2020, "grey", new String[] {"tires", "filter", "transmission"}),
            new Car("Toyota", 12000, 2021, "green", new String[] {"tires", "filter", "transmission"})
        };


        // instatiating an object for Dealership class
        // Cars object array as parameter
        Dealership dealership1 = new Dealership(cars);

        // printing out object (with built-in toString() method)
        System.out.println(dealership1);


    }
}