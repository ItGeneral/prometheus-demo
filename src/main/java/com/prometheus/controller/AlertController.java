package com.prometheus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjiuhua
 * Created by 2020/6/17 19:30
 */
@RestController
public class AlertController {

    @PostMapping(value = "/alert")
    public void receiveAlert(@RequestBody String json) {
        System.out.println(json);
        //此处可以根据接受到的告警信息，自定义通知操作，如发送邮件等
    }


}
