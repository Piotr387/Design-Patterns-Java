package org.creational;

import org.creational.builder.Person;
import org.creational.dao.Database;
import org.creational.dao.PersonEntity;
import org.creational.factorypattern.Algorithm;
import org.creational.factorypattern.AlgorithmFactory;
import org.creational.singleton.SingletonForRand;

public class CreationalDemo {

    public static void demo(){


        System.out.println("-----SINGLETON-----");
        for (int i = 0; i < 10; i++) {
            System.out.print(SingletonForRand.getInstance().getNumber()%50 + " ");
        }
        System.out.println();

        System.out.println("-----FACTORY PATTERN-----");
        Algorithm algorithm = AlgorithmFactory.createAlgorithm(AlgorithmFactory.SHORTEST_PATH);
        algorithm.solve();

        System.out.println("-----BUILDER-----");
        Person person = new Person.Builder("Piotr", "ptrpiw.dev@gmail.com").setAddress("Lublin").setAge(23).build();
        System.out.println(person);


        System.out.println("-----DAO-----");
        Database database = new Database();

        PersonEntity adam = new PersonEntity("Adam",40);

        database.insert(new PersonEntity("Piotr",23));
        database.insert(adam);
        database.insert(new PersonEntity("Jan",50));

        for (PersonEntity personEntity: database.getPeople()) {
            System.out.println(personEntity);
        }

        database.remove(adam);

        for (PersonEntity personEntity: database.getPeople()) {
            System.out.println(personEntity);
        }

    }
}
