package com.tpadsz.servlet.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class ProducerApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerApp.class);
    private static final String BROKER_URL ="failover://tcp://192.168.51.80:61616";
    private static final String SUBJECT = "myTest-activemq-queue";

    public static void main(String[] args) throws JMSException {
        //��ʼ�����ӹ���
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //�������
        Connection conn = connectionFactory.createConnection();
        //��������
        conn.start();
        //����Session���˷�����һ��������ʾ�Ự�Ƿ���������ִ�У��ڶ��������趨�Ự��Ӧ��ģʽ
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //��������
        Destination dest = session.createQueue(SUBJECT);
        //createTopic������������Topic
        //session.createTopic("TOPIC");
        //ͨ��session���Դ�����Ϣ��������
        MessageProducer producer = session.createProducer(dest);
        for (int i=0;i<10;i++) {
            //��ʼ��һ��mq��Ϣ
            TextMessage message = session.createTextMessage("hello active mq No." + i);
            //������Ϣ
            producer.send(message);
            LOGGER.info("send message {}", i);
        }

        //�ر�mq����
        conn.close();
    }
}
