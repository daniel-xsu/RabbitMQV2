package com.hp.it.messagebus;

import com.hp.it.messagebus.postman.LetterListener;

/**
 * Created by xukej on 2014-07-31.
 */

public class LetterListenerImpl implements LetterListener {

    public LetterListenerImpl() {
    }

//    @Override
//    public void handleMessage(Order order) {
//        System.out.println("Got message :" + order.toString());
//    }
    @Override
    public void handleMessage(Object obj) {
        System.out.println("My Customized listernre -- Got message :" + ((Order)obj).toString());
    }
}
