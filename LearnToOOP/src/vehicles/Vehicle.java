package vehicles;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected int speed;

    public Vehicle (String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    public abstract void honk(); // Abstrakte Methode: Jede Unterklasse - eigene Hupe

    public abstract void accelerate();

    public void displayInfo(){
        System.out.println(brand + " " + model + " (" + year + ")");
    }
}
