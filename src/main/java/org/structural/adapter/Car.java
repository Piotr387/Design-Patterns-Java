package org.structural.adapter;

public class Car implements Vehicle{
    @Override
    public void accelerate() {
        System.out.println("Car is speeding up ");
    }
}
