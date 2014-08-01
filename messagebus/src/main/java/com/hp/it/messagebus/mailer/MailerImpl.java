package com.hp.it.messagebus.mailer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by xukej on 2014-07-17.
 */
public class MailerImpl implements Mailer {
    private RabbitTemplate rabbitTemplate = null;

    public MailerImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void write(Object contents) {
        rabbitTemplate.convertAndSend(contents);
    }
}
