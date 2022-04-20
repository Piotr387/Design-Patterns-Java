package org.solidEdu.l;

public class ElectricCar implements ElectricVehicle{
    @Override
    public void speed() {
        System.out.println("Speed up....");
    }

    @Override
    public void chargeBattery() {
        System.out.println("Charging battey... ");
    }
}
