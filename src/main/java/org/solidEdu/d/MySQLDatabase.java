package org.solidEdu.d;

public class MySQLDatabase implements Database {

    @Override
    public void connect(){
        System.out.println("Connecting to MySQL database...");
    }

    @Override
    public void disconnect(){
        System.out.println("Disconnecting MySQL database...");
    }
}
