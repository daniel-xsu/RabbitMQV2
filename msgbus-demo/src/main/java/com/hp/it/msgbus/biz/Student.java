package com.hp.it.msgbus.biz;

import com.hp.it.messagebus.entity.BasePojo;
import com.hp.it.messagebus.entity.StaticSequence;

/**
 * Created by xukej on 2014-08-01.
 */

public class Student extends BasePojo {


    private int no;
    private String name;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student(String name, String department) {
        this.no = StaticSequence.getValue();
        this.name = name;
        this.department = department;
    }


}

