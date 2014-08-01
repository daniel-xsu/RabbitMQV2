package com.hp.it.messagebus.postman;

/**
 * Created by xukej on 2014-07-17.
 */
public class PostmanNotFoundException extends  Exception {
    String postmanName = "";
    PostmanNotFoundException(String postmanName) {
        super();
        this.postmanName = postmanName;
    }
    public String toString(){
        return ("The postman : [ " + this.postmanName + " ] is not exist, please check your postman name.") ;
    }
}
