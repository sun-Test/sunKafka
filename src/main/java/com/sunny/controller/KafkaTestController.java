package com.sunny.controller;


import com.sunny.service.KafkaMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/test")
@Slf4j
public class KafkaTestController {
    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @GetMapping("/sendmsg01")
    public String sendmsg01() {
        kafkaMessageProducer.sendMessage("this is msg of sunt01");
        return "sunt01 msg has been send";
    }
}
