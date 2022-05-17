package org.creational.dao;

import java.util.ArrayList;
import java.util.List;

public class Database implements PersonDAO{

    private List<PersonEntity> people;

    public Database() {
        this.people = new ArrayList<>();
    }

    @Override
    public void insert(PersonEntity personEntity) {
        this.people.add(personEntity);
    }

    @Override
    public void remove(PersonEntity personEntity) {
        this.people.remove(personEntity);
    }

    @Override
    public List<PersonEntity> getPeople() {
        return this.people;
    }
}
