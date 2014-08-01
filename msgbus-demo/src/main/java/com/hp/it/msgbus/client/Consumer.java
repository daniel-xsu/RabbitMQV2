package com.hp.it.msgbus.client;

import com.hp.it.messagebus.postman.Postman;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xukej on 2014-07-31.
 */
public class Consumer {
    public static void main( String[] args )
    {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("RabbitMQPostmanContext.xml");

        Postman postman = (Postman)context.getBean("postman");
        try {
            postman.waitLetter(8000);
            postman.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.close();

    }
}
