package org.Behavioral.commandv2;

public class Task {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    public void solveProblem(){
        System.out.println("Solving the problem with ID " + id);
    }
}
