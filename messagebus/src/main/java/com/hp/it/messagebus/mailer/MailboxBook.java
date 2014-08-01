package com.hp.it.messagebus.mailer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Map;

/**
 * Created by xukej on 2014-07-31.
 */
public class MailboxBook {

    private Map<String, RabbitTemplate> mailboxBookMapping;

    public void setMailboxBookMapping(Map<String, RabbitTemplate> mailboxBookMapping) {
        this.mailboxBookMapping = mailboxBookMapping;
    }

    public MailboxBook() {

    }

    public RabbitTemplate getMailerByMailboxName(String mailboxName) {
        return this.mailboxBookMapping.get(mailboxName);
    }

}
