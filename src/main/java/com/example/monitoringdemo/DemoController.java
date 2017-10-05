package com.example.monitoringdemo;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.exporter.common.TextFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Writer;

@RestController
public class DemoController {

    private final Counter promRequestsTotal = Counter.build()
            .name("requests_total")
            .help("Total number of requests.")
            .register();

    @GetMapping
    public String demoEndpoint() {
        promRequestsTotal.inc();
        return "Demo";
    }

    @RequestMapping(path = "/prometheus")
    public void metrics(Writer responseWriter) throws IOException {
        TextFormat.write004(responseWriter, CollectorRegistry.defaultRegistry.metricFamilySamples());
        responseWriter.close();
    }

}
