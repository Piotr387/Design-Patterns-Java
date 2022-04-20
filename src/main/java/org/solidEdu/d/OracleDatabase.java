package org.solidEdu.d;

public class OracleDatabase implements Database {

    @Override
    public void connect(){
        System.out.println("Connecting to Oracle database...");
    }

    @Override
    public void disconnect(){
        System.out.println("Disconnecting from Oracle database...");
    }
}
