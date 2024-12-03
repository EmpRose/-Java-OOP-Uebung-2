package components;

import interfaces.DriveStrategy;

public class ElectricDriveStrategy implements DriveStrategy {
    @Override
    public void drive(){
        System.out.println("Fahren mit Elektromotor");
    }
}
