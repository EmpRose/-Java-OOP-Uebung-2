package vehicles;

import components.Battery;
import interfaces.Chargeable;
import interfaces.DriveStrategy;

public class ElectricCar extends Vehicle implements Chargeable {
    private Battery battery;
    private DriveStrategy driveStrategy;

    public ElectricCar(String brand, String model, int year, int batteryCapacity, DriveStrategy driveStrategy){
        super(brand,model,year);
        this.battery = new Battery(batteryCapacity);
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
        System.out.println("Hupe: Leise Beep!");
    }

    @Override
    public void accelerate(){
        if(battery.getChargeLevel() > 0){
            battery.consumeCharge(5);
            System.out.println("Das Auto beschleunigt mit Elektroantrieb. Aktueller Stand: " + battery.getChargeLevel() + "%");
        }else{
            System.out.println("Nicht genug Ladung, bitte aufladen! Aktueller Stand: " + battery.getChargeLevel()+"%");
        }
    }

    @Override
    public void charge(){
        battery.charge();
    }




}
