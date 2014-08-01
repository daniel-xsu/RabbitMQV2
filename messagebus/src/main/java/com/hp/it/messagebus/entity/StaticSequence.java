package com.hp.it.messagebus.entity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xukej on 2014-08-01.
 */
public class StaticSequence {

    static AtomicInteger idx = new AtomicInteger(1);

    public static int getValue() {
        return idx.getAndIncrement();
    }
}
