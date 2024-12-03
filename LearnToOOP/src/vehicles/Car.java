package vehicles;

import components.Engine;
import interfaces.DriveStrategy;
import interfaces.Refuelable;

public class Car extends Vehicle implements Refuelable {
    private Engine engine;
    private DriveStrategy driveStrategy;
    // Konstruktor
    public Car(String brand, String model, int year, DriveStrategy driveStrategy,int fuelLevel){
        super(brand,model,year);
        this.engine = new Engine(fuelLevel);
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
    }

    @Override
    public void honk(){
        System.out.println("Hupe: Beep Beep!");
    }

    @Override
    public void accelerate(){
        if (engine.getFuelLevel() > 0){
            engine.consumeFuel(3);
            System.out.println("Das Auto beschleunigt mit Verbrennungsmotor.");
        }else{
            System.out.println("Kein Sprit mehr, aktueller Stand: " + engine.getFuelLevel() + " Liter. Bitte tanken.");
        }
    }

    @Override
    public void refuel(int amount) {
        engine.refuel(amount);
    }






}
