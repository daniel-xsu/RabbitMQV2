package com.hp.it.messagebus;

import com.hp.it.messagebus.entity.BasePojo;
import com.hp.it.messagebus.entity.StaticSequence;


/**
 * Created by xukej on 2014-07-21.
 */
public class Order extends BasePojo {

    private int no;
    private String productName;
    private String ShipAddr;

    public Order(String productName, String shipAddr) {
        this.no = StaticSequence.getValue();
        this.productName = productName;
        ShipAddr = shipAddr;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShipAddr() {
        return ShipAddr;
    }

    public void setShipAddr(String shipAddr) {
        ShipAddr = shipAddr;
    }

}
