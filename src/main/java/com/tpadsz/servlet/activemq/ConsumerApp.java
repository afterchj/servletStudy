package com.tpadsz.servlet.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class ConsumerApp implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerApp.class);
    private static final String BROKER_URL = "failover://tcp://192.168.51.88:61616";
    private static final String SUBJECT = "myTest-activemq-queue";

    public static void main(String[] args) throws JMSException {
        //��ʼ��ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //����mq����
        Connection conn = connectionFactory.createConnection();
        //��������
        conn.start();
        //�����Ự
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //ͨ���Ự����Ŀ��
        Destination dest = session.createQueue(SUBJECT);
        //����mq��Ϣ��������
        MessageConsumer consumer = session.createConsumer(dest);
        //��ʼ��MessageListener
        ConsumerApp me = new ConsumerApp();
        //���������趨��������
        consumer.setMessageListener(me);
    }

    public void onMessage(Message message) {
        TextMessage txtMessage = (TextMessage) message;
        try {
            LOGGER.info("get message " + txtMessage.getText());
        } catch (JMSException e) {
            LOGGER.error("error {}", e);
        }
    }
}
