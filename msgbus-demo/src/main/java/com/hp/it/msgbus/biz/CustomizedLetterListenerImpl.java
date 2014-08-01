package com.hp.it.msgbus.biz;

import com.hp.it.messagebus.postman.LetterListener;

/**
 * Created by xukej on 2014-07-31.
 */

public class CustomizedLetterListenerImpl implements LetterListener {

    public CustomizedLetterListenerImpl() {
    }

//    @Override
//    public void handleMessage(Order order) {
//        System.out.println("My Customized listernre -- Got message :" + order.toString());
//    }

    @Override
    public void handleMessage(Object obj) {
        System.out.println("My Customized listernre -- Got message :" + ((Student) obj).toString());
    }
}
