package com.hp.it.msgbus.client;
;
import com.hp.it.messagebus.mailer.Mailer;
import com.hp.it.messagebus.mailer.MailerNotFoundException;
import com.hp.it.messagebus.mailer.PostOfficeYellowPage;
import com.hp.it.msgbus.biz.Student;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Producer
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("RabbitMQMailerContext.xml");


        PostOfficeYellowPage yellowPage = (PostOfficeYellowPage)context.getBean("postOfficeYellowPage");

        try {
            Mailer daniel = yellowPage.getMailer("com.hp.it.daniel");
            Student joe = new Student("joe","science");
            daniel.write(joe);

//            Order order = new Order(100,"Television","China");
//            daniel.write(order);
        } catch (MailerNotFoundException e) {
            e.printStackTrace();
        }

        context.close();

    }
}
