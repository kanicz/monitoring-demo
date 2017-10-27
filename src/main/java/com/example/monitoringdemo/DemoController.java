package com.example.monitoringdemo;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Order
public class DemoController {


    @GetMapping
    public String demoEndpoint() {
        return "Demo";
    }


}
