package org.structural;

import org.structural.adapter.*;
import org.structural.decorator.Beverage;
import org.structural.decorator.Milk;
import org.structural.decorator.PlainBeverage;
import org.structural.decorator.Sugar;
import org.structural.facade.SortingManager;

import java.util.ArrayList;
import java.util.Arrays;

public class StructuralDemo {
    public static void demo(){

        System.out.println("-----DECORATOR-----");
        Beverage b = new Sugar(new Milk(new PlainBeverage()));
        System.out.println(b.getCost());
        System.out.println(b.getDescription());
        System.out.println("-----FACADE-----");
        SortingManager manager = new SortingManager();
        manager.doMergeSort();
        System.out.println("-----ADAPTER-----");
        Vehicle bus = new Bus();
        Vehicle car = new Car();
        Vehicle bicycle = new BicycleAdapter(new Bicycle());

        bus.accelerate();
        car.accelerate();
        bicycle.accelerate();

    }
}
