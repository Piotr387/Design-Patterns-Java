package org.Behavioral.nullPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private List<String> customerNames;

    public Database() {
        this.customerNames = new ArrayList<>(Arrays.asList(
                "Daniel", "Adam", "Joe", "Michael"
        ));
    }

    public boolean existCustomer(String name){
        for (String s: customerNames)
            if (s.equals(name))
                return true;
       return false;
    }
}
