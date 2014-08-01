package com.hp.it.messagebus;

import com.hp.it.messagebus.postman.Postman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:RabbitMQPostmanContext.xml")
public class PostmanTest {

    @Autowired()
    private Postman postman;

    @Test
    public void testPostmanListen() throws Exception {

        postman.waitLetter(2000);
        postman.stop();

        System.out.println("end of testPostmanListen.");
    }
}
