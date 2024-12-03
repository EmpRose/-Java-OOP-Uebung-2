package components;
import exeptions.FuelLevelTooLowExeption;
import interfaces.PowerSource;

public class Engine implements PowerSource {
    private int fuelLevel;

    public Engine(int fuelLevel){
        this.fuelLevel = fuelLevel;
    }

    public boolean hasFuel(){
        return fuelLevel > 0;
    }

    public void consumeFuel(int amount){
        if(fuelLevel >= 0){
            fuelLevel -= amount;
        }else{
            System.out.println("Nicht genug Sprit!");
        }
    }

    @Override
    public void start() throws FuelLevelTooLowExeption {
        if(fuelLevel <= 0){
            throw new FuelLevelTooLowExeption("Nicht genug Sprit");
        }else{
            System.out.println("Antrieb startet. Aktuelle Spritmenge: " + fuelLevel + " Liter");
        }
    }

    @Override
    public void stop(){
        System.out.println("Engine stopt.");
    }


    public void refuel(int amount){
        fuelLevel += amount;
        System.out.println("Motor getankt. Treibstoffstand: " + fuelLevel + " Liter.");
    }

    public int getFuelLevel(){
        return fuelLevel;
    }
}
