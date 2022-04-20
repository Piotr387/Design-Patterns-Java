package org.solidEdu;

import org.solidEdu.d.DatabaseHandler;
import org.solidEdu.d.OracleDatabase;
import org.solidEdu.i.BalancedTree;
import org.solidEdu.i.BinarySearchTree;
import org.solidEdu.i.Tree;
import org.solidEdu.l.ElectricCar;
import org.solidEdu.l.ElectricVehicle;
import org.solidEdu.o.InsertionSort;
import org.solidEdu.o.MergeSort;
import org.solidEdu.o.SorterManager;
import org.solidEdu.s.Book;

public class solidDemo {

    public static void demo(){
        /**
         * S - Single Responsibility Principle
         */
        Book book1 = new Book("Albert Camus", 120);
        book1.save();

        /**
         * O - Open Closed Principle
         */
        SorterManager sorterManager = new SorterManager();
        sorterManager.sort(new MergeSort());
        sorterManager.sort(new InsertionSort());
        /**
         * L - Liskov substitution principle
         */
        ElectricVehicle car = new ElectricCar();
        car.chargeBattery();
        /**
         * I - Interface Segregation Principle
         */
        Tree binarySearchTree = new BinarySearchTree();
        Tree balancedTree = new BalancedTree();
        /**
         * D - Dependency Inversion Principle
         */
        DatabaseHandler databaseHandler = new DatabaseHandler(new OracleDatabase());
        databaseHandler.connect();
        databaseHandler.disconnect();
    }
}
