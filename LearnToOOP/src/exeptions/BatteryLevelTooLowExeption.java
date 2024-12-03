package exeptions;

public class BatteryLevelTooLowExeption extends Exception {
    public BatteryLevelTooLowExeption(String message){
        super(message);
    }
}
