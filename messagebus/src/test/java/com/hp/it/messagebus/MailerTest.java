package com.hp.it.messagebus;

import com.hp.it.messagebus.mailer.Mailer;
import com.hp.it.messagebus.mailer.MailerNotFoundException;
import com.hp.it.messagebus.mailer.PostOfficeYellowPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:RabbitMQMailerContext.xml")
public class MailerTest {

    @Autowired()
    private PostOfficeYellowPage yellowPage;

    @Test
    public void testMailerAction() throws Exception {
        try {
            Mailer daniel = yellowPage.getMailer("com.hp.it.daniel");
            Order order = new Order("Television","China");
            daniel.write(order);
        } catch (MailerNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("end of testMailerAction.");

    }

}
