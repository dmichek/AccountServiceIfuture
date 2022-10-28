package com.example.accountserviceifuture.mainservice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Statistic {

    private static AtomicInteger getCounter = new AtomicInteger();
    private static AtomicInteger addCounter = new AtomicInteger();
    private static AtomicLong starTimeGet = new AtomicLong();
    private static AtomicLong starTimeAdd = new AtomicLong();

    public static void incrementGetCounter() {

        if (starTimeGet.get() == 0)
            starTimeGet.set(System.currentTimeMillis());

        getCounter.incrementAndGet();
    }

    public static void incrementAddCounter() {

        if (starTimeAdd.get() == 0)
            starTimeAdd.set(System.currentTimeMillis());

        addCounter.incrementAndGet();
    }

    public static void resetStatistic() {

        getCounter.set(0);
        addCounter.set(0);
        starTimeAdd.set(0);
        starTimeGet.set(0);
    }

    public static String get() {

        Long secGet = (System.currentTimeMillis() - starTimeGet.get()) / 1000;
        Long secAdd = (System.currentTimeMillis() - starTimeAdd.get()) / 1000;

        int getCounterPerSecond = 0;
        int addCounterPerSecond = 0;

        if (secGet != 0) {
            getCounterPerSecond = (int) (getCounter.get() / secGet);
        }

        if (secAdd != 0) {
            addCounterPerSecond = (int) (addCounter.get() / secAdd);
        }

        return String.format("Count of get-request: %d, per second: %d;\n Count of add-request: %d, per second: %d",
                getCounter.get(), getCounterPerSecond, addCounter.get(), addCounterPerSecond);
    }

}
