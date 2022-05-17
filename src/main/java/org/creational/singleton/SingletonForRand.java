package org.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class SingletonForRand {

    private static volatile SingletonForRand instance = null;
    private List<Long> listNumbers;
    private int lastUsedIndex = 0;
    private final int CAPACITY = 1_000;
    private final long seed;

    private SingletonForRand(long seed) {
        this.seed = seed;
        if(instance != null) {
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
        listNumbers = generateArray(seed);
    }

    public static SingletonForRand getInstance() {
        return getInstance(System.currentTimeMillis());
    }

    public static SingletonForRand getInstance(long seed) {
        if(instance == null) {
            synchronized(SingletonForRand.class) {
                if(instance == null) {
                    instance = new SingletonForRand(seed);
                }
            }
        }
        return instance;
    }

    public long getNumber(){
        synchronized (SingletonForRand.class){
            if (lastUsedIndex > CAPACITY){
                listNumbers.get(listNumbers.size()-1);
                lastUsedIndex = 0;
            }
            return listNumbers.get(lastUsedIndex++);
        }
    }

    //Using The Linear Congruential Algorithm
    private List<Long> generateArray(long seed){
        long x = seed;
        long a = 3;
        long c = 3;
        List<Long> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(x);
        for (int i = 0;i < CAPACITY;i++){
            listOfNumbers.add(((listOfNumbers.get(i)*a)+c));
        }
        return listOfNumbers;
    }

    public static long random(){
        return SingletonForRand.getInstance().getNumber();
    }
}
