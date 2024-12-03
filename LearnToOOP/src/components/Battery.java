package components;
import exeptions.BatteryLevelTooLowExeption;
import interfaces.PowerSource;

public class Battery implements PowerSource{
    private int chargeLevel;

    public Battery(int chargeLevel){
        this.chargeLevel = chargeLevel;
    }

    public boolean hasCharge(){
        return chargeLevel > 0;
    }

    public void consumeCharge(int amount){
        if(chargeLevel>= amount){
            chargeLevel -= amount;
        }else{
            System.out.println("Nicht genug Energie!");
        }
    }

    @Override
    public void start() throws BatteryLevelTooLowExeption{
        if(chargeLevel <= 0) {
            throw new BatteryLevelTooLowExeption("Nicht genug Energie!");
        }else{
            System.out.println("Motor startet. Batteriekapazität: " + chargeLevel + "%");
        }
    }

    @Override
    public void stop(){
        System.out.println("Battery stopt.");
    }

    public void charge(){
        chargeLevel = 100;
        System.out.println("Batterie vollständig aufgeladen.");
    }

    public int getChargeLevel(){
        return chargeLevel;
    }
}
