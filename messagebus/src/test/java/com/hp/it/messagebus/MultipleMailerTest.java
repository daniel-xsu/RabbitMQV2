package com.hp.it.messagebus;

import com.hp.it.messagebus.mailer.Mailer;
import com.hp.it.messagebus.mailer.MailerNotFoundException;
import com.hp.it.messagebus.mailer.PostOfficeYellowPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xukej on 2014-07-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:RabbitMQMailerContext.xml")
public class MultipleMailerTest {

    @Autowired()
    private PostOfficeYellowPage yellowPage;

    @Test
    public void testMultipleMailer() throws Exception {

        final int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i=0; i<200; i++) {
            executorService.execute(new MyRunnable(i));
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("end of testing MultipleMailer.");

    }

    public class MyRunnable implements Runnable {
        int count;
        public MyRunnable(int _count) {
            this.count = _count;
        }
        public void run() {
            try {
                Mailer daniel = yellowPage.getMailer("com.hp.it.daniel");
                Order order = new Order("Television", "China");
                daniel.write(order);
                System.out.println("Thread id: " + Thread.currentThread().getId() + " Message is : --> " + order.toString());
            } catch (MailerNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
