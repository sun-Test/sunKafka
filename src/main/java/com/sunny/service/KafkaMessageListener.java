package com.sunny.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class KafkaMessageListener {

    private CountDownLatch latch = new CountDownLatch(3);

    private CountDownLatch partitionLatch = new CountDownLatch(2);

    private CountDownLatch filterLatch = new CountDownLatch(2);

    @KafkaListener(topics = "${message.topic.name}", groupId = "foo", containerFactory = "fooKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group 'foo': " + message);
        latch.countDown();
    }

    @KafkaListener(topics = "${message.topic.name}", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
    public void listenGroupBar(String message) {
        System.out.println("Received Message in group 'bar': " + message);
        latch.countDown();
    }

    @KafkaListener(topics = "${message.topic.name}", containerFactory = "headersKafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + " from partition: " + partition);
        latch.countDown();
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "${partitioned.topic.name}", partitions = { "0", "3" }), containerFactory = "partitionsKafkaListenerContainerFactory")
    public void listenToParition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + " from partition: " + partition);
        this.partitionLatch.countDown();
    }

    @KafkaListener(topics = "${filtered.topic.name}", containerFactory = "filterKafkaListenerContainerFactory")
    public void listenWithFilter(String message) {
        System.out.println("Recieved Message in filtered listener: " + message);
        this.filterLatch.countDown();
    }
}