package main;

import components.ElectricDriveStrategy;
import components.FuelDriveStrategy;
import interfaces.Chargeable;
import interfaces.Refuelable;
import vehicles.Car;
import vehicles.ElectricCar;
import vehicles.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        Car car = new Car(
                "BMW",
                "M3",
                2020,
                new FuelDriveStrategy(),
                60);

        ElectricCar electricCar = new ElectricCar(
                "Tesla",
                "Model S",
                2023,
                50,
                new ElectricDriveStrategy());

        Motorcycle motorcycle = new Motorcycle(
                "Ducati",
                "Panigale V4",
                2022,
                20,
                30,
                new ElectricDriveStrategy(),
                new FuelDriveStrategy());

        // Polymorphie Listen
        List<Refuelable> refuelables = new ArrayList<>();
        refuelables.add(car);
        refuelables.add(motorcycle);

        List<Chargeable> chargeables = new ArrayList<>();
        chargeables.add(electricCar);
        chargeables.add(motorcycle);

        // Betanken
        System.out.println("----Betanken----");
        for(Refuelable refuable: refuelables){
            refuable.refuel(10);
        }

        // Aufladen
        System.out.println("----Aufladen----");
        for(Chargeable chargeable : chargeables){
            chargeable.charge();
        }

        // Beschleunigen
        System.out.println("----Beschleunigen----");
        car.accelerate();
        electricCar.accelerate();
        motorcycle.accelerate();

        // Motorrad-Status-Anzeige
        System.out.println("----Motorradstatus----");
        motorcycle.displayStatus();
    }
}
