package com.hp.it.messagebus.mailer;

/**
 * Created by xukej on 2014-07-17.
 */
public class MailerNotFoundException extends  Exception {
    String mailboxName = "";
    MailerNotFoundException(String mailboxName) {
        super();
        this.mailboxName = mailboxName;
    }
    public String toString(){
        return ("The mailbox : [ " + this.mailboxName + " ] is not exist, please check your mail box name.") ;
    }
}
