package org.Behavioral;

import org.Behavioral.command.Light;
import org.Behavioral.command.Switcher;
import org.Behavioral.command.TurnOffCommand;
import org.Behavioral.command.TurnOnCommand;
import org.Behavioral.commandv2.Algorithm;
import org.Behavioral.iterator.Iterator;
import org.Behavioral.iterator.NameRepository;
import org.Behavioral.nullPattern.CustomerFactory;
import org.Behavioral.observer.WeatherObserver;
import org.Behavioral.observer.WeatherStation;
import org.Behavioral.strategy.Add;
import org.Behavioral.strategy.Manager;
import org.Behavioral.strategy.Multiply;
import org.Behavioral.template.AlgorithmTemplate;
import org.Behavioral.template.BubbleSort;
import org.Behavioral.visitor.*;

import java.util.ArrayList;
import java.util.List;

public class BehavioralDemo {
    public static void demo(){

        /**
         * Strategy Pattern
         */
        System.out.println("Strategy Pattern");
        Manager manager = new Manager();
        manager.setStrategy(new Multiply());
        manager.operation(1,3);
        manager.setStrategy(new Add());
        manager.operation(1,3);

        /**
         * Observer Pattern
         */
        System.out.println("Observer pattern");
        WeatherStation weatherStation = new WeatherStation();
        WeatherObserver weatherObserver = new WeatherObserver(weatherStation);

        weatherStation.setHumidity(100);
        weatherStation.setPressure(200);
        weatherStation.setTemperature(300);


        /**
         * Visitor Pattern
         */

        System.out.println("Visitor Pattern");
        List<ShoppingItem> items = new ArrayList<>();
        items.add(new Table("desk",20));
        items.add(new Chair("chair1",30));
        items.add(new Chair("chair2",40));

        ShoppingCartVisitor shoppingCart = new ShoppingCart();

        double sum = items.stream()
                .mapToDouble( a -> a.accept(shoppingCart))
                .sum();
        System.out.println(sum);

        /**
         * Command Pattern
         */
        System.out.println("Command Pattern");
        Switcher switcher = new Switcher();

        Light light = new Light();
        TurnOnCommand turnOnCommand = new TurnOnCommand(light);
        TurnOffCommand turnOffCommand = new TurnOffCommand(light);

        switcher.addCommand(turnOnCommand);
        switcher.addCommand(turnOffCommand);

        switcher.executeCommands();

        /**
         * Iterator pattern
         */
        System.out.println("Iterator pattern");
        NameRepository nameRepository = new NameRepository();

        for (Iterator iter = nameRepository.getIterator(); iter.hasNext();){
            String name = (String) iter.next();
            System.out.println(name);
        }

        /**
         * Template pattern
         */
        System.out.println("Template pattern");
        int[] numbers = {1,5,3,6,-2,3-10,10};

        AlgorithmTemplate algorithmTemplate = new BubbleSort(numbers);
        algorithmTemplate.sort();

        /**
         * Null Pattern
         */
        System.out.println("Null Pattern");
        CustomerFactory customerFactory = new CustomerFactory();

        System.out.println(customerFactory.getCustomer("Joe").getCustomer());
        System.out.println(customerFactory.getCustomer("Kevin").getCustomer());


        /**
         * Command Pattern which can be invkode by diffrent threads
         */
        System.out.println("Command pattern v2");
        final Algorithm algorithm = new Algorithm();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                algorithm.produce();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                algorithm.consume();
            }
        });

        t1.start();
        t2.start();
    }
}
