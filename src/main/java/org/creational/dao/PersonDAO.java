package org.creational.dao;

import java.util.List;

public interface PersonDAO {
    void insert(PersonEntity personEntity);
    void remove(PersonEntity personEntity);
    List<PersonEntity> getPeople();
}
