package vehicles;

import components.Battery;
import components.ElectricDriveStrategy;
import components.Engine;
import components.FuelDriveStrategy;
import interfaces.Chargeable;
import interfaces.DriveStrategy;
import interfaces.Refuelable;

public class Motorcycle extends Vehicle implements Refuelable, Chargeable {
    private Engine engine;
    private Battery battery;
    private DriveStrategy currentDriveStrategy;

    public Motorcycle(String brand, String model, int year, int fuelLevel, int batteryCharge, DriveStrategy fuelStrategy, DriveStrategy electricStrategy ){
        super(brand,model,year);
        this.engine = new Engine(fuelLevel);
        this.battery = new Battery(batteryCharge);
        this.currentDriveStrategy = fuelStrategy;
    }

    public void switchToElectric(){
        this.currentDriveStrategy = new ElectricDriveStrategy();
        System.out.println("Auf elektrischen Antrieb gewechselt");
    }

    public void switchToFuel(){
        this.currentDriveStrategy = new FuelDriveStrategy();
        System.out.println("Auf verbrenner Antrieb gewechselt");
    }

    public void start() {
        if(currentDriveStrategy instanceof FuelDriveStrategy){
            if(engine.hasFuel()){
                System.out.println("Der Motor startet mit Sprit");
            }else{
                System.out.println("Nicht genug Sprit im Tank.");
            }
        }else if(currentDriveStrategy instanceof ElectricDriveStrategy){
            if(battery.hasCharge()){
                System.out.println("Der Elektromotor startet.");
            }else{
                System.out.println("Nicht genug Energie.");
            }
        }
    }

    public void drive(){
        currentDriveStrategy.drive();
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
    }
    @Override
    public void honk(){
        System.out.println("Motorrad-Hupe: Nup Nup");
    }

    @Override
    public void accelerate(){
        if(engine.getFuelLevel() > 0){
            engine.consumeFuel(3);
            System.out.println("Motorrad beschleunigt mit Verbrennungsmotor.");
        }else if(battery.getChargeLevel() > 0){
            System.out.println("Motorrad beschleunigt mit Elektroantrieb:");
        }else{
            System.out.println("Keine Energiequelle verfügbar. Bitte tanken oder aufladen!");
        }
    }

    @Override
    public void charge() {
        battery.charge();
    }

    @Override
    public void refuel(int amount) {
        engine.refuel(amount);
    }

    public void displayStatus(){
        System.out.println("Status des Motorrads:");
        System.out.println("Treibstoffstand: " + engine.getFuelLevel() + " Liter");
        System.out.println("Batterieladung: " + battery.getChargeLevel() + " %");
    }
}
