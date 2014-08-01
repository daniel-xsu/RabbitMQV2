package com.hp.it.messagebus.postman;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

/**
 * Created by xukej on 2014-07-31.
 */
public class Postman {

    private CachingConnectionFactory connectionFactory;
    private int channelCacheSize;
    private int maxConcurrentConsumers;
    private int concurrentConsumers;
    private String mailboxName;
    private LetterListener listener;

    private SimpleMessageListenerContainer container;

    public void setConnectionFactory(CachingConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void setChannelCacheSize(int channelCacheSize) {
        this.channelCacheSize = channelCacheSize;
    }
    public void setConcurrentConsumers(int concurrentConsumers) {
        this.concurrentConsumers = concurrentConsumers;
    }

    public void setMailboxName(String mailboxName) {
        this.mailboxName = mailboxName;
    }

    public void setMaxConcurrentConsumers(int maxConcurrentConsumers) {
        this.maxConcurrentConsumers = maxConcurrentConsumers;
    }

    public void setListener(LetterListener listener) {
        this.listener = listener;
    }


    public Postman() {

    }

    public void init() {
        connectionFactory.setChannelCacheSize(this.channelCacheSize);
        MessageListenerAdapter adapter = new MessageListenerAdapter(this.listener);

        container = new SimpleMessageListenerContainer(this.connectionFactory);
        container.setMessageListener(adapter);
        container.setQueueNames(this.mailboxName + ".inQueue");
        container.setMaxConcurrentConsumers(this.maxConcurrentConsumers);
        container.setConcurrentConsumers(this.concurrentConsumers);

    }

    public void waitLetter(int ms) {

        this.container.start();
        System.out.println("begin processing letters.");

        if (ms > 0) {
            try {
                System.out.println("press ctrl+C to stop the listener....");
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end of processing letters, bye!.");
            this.container.stop();
        }

    }

    public void stop() {
        if (this.container.isActive()) this.container.stop();
    }

}
