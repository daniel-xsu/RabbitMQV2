package com.hp.it.messagebus.mailer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by xukej on 2014-07-31.
 */
public class PostOfficeYellowPage {

    private MailboxBook mailboxBook;

    public void setMailboxBook(MailboxBook mailboxBook) {
        this.mailboxBook = mailboxBook;
    }

    public PostOfficeYellowPage(){

    }

    public Mailer getMailer(String mailboxName) throws MailerNotFoundException {
        RabbitTemplate rt = this.mailboxBook.getMailerByMailboxName(mailboxName);
        if (rt == null) throw new MailerNotFoundException(mailboxName);
        return new MailerImpl(rt);
    }

}
