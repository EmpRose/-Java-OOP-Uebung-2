package interfaces;

import exeptions.BatteryLevelTooLowExeption;
import exeptions.FuelLevelTooLowExeption;

public interface PowerSource {
    void start() throws FuelLevelTooLowExeption, BatteryLevelTooLowExeption;
    void stop();
}


