package org.Behavioral.iterator;

public class NameRepository {

    private String[] names = {"Adam","Joe","John", "Sarah"};

    public Iterator getIterator(){
        return new NameIterator(names);
    }
}
