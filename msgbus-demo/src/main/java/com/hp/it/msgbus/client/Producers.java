package com.hp.it.msgbus.client;

import com.hp.it.messagebus.mailer.Mailer;
import com.hp.it.messagebus.mailer.MailerNotFoundException;
import com.hp.it.messagebus.mailer.PostOfficeYellowPage;
import com.hp.it.msgbus.biz.Student;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

;


public class Producers
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("RabbitMQMailerContext.xml");
        PostOfficeYellowPage yellowPage = (PostOfficeYellowPage)context.getBean("postOfficeYellowPage");


        final int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i=0; i<200; i++) {
            executorService.execute(new Producers().new MyRunnable(yellowPage));
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("end of testing MultipleMailer.");
        context.close();
    }

    public class MyRunnable implements Runnable {
        PostOfficeYellowPage yellowPage;
        public MyRunnable(PostOfficeYellowPage yellowPage) {
            this.yellowPage = yellowPage;
        }
        public void run() {
            try {
                Mailer daniel = yellowPage.getMailer("com.hp.it.daniel");
                Student joe = new Student("joe","science");
                daniel.write(joe);
                System.out.println("Thread id: " + Thread.currentThread().getId() + " Message is : --> " + joe.toString());
            } catch (MailerNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
