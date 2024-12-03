package components;

import interfaces.DriveStrategy;

public class FuelDriveStrategy implements DriveStrategy {
    @Override
    public void drive(){
        System.out.println("Fahren mit Verbrennermotor.");
    }
}
