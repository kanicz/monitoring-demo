package com.example.monitoringdemo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Counter demoRequests = Metrics.counter("Demo requests");

    @GetMapping
    public String demoEndpoint() {
        demoRequests.increment();
        return "Demo";
    }

}
