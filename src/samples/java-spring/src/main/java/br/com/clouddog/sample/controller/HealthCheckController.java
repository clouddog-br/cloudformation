package br.com.clouddog.ecossambiental.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/health-check")
@SuppressWarnings("unused")
class HealthCheckController {

    private static final Logger log = LoggerFactory.getLogger(HealthCheckController.class);

    private final HealthCheckResponse response = new HealthCheckResponse();

    @RequestMapping(method = RequestMethod.GET)
    public HealthCheckResponse healthCheck(@RequestHeader(value = "User-Agent") String userAgent) {
        log.info("healthCheck from: {}", userAgent);
        return response;
    }
}

class HealthCheckResponse {

    private final long startMillis = new Date().getTime();
    private final String version = this.getClass().getPackage().getImplementationVersion();

    @SuppressWarnings("unused")
    public String getVersion() {
        return version;
    }

    @SuppressWarnings("unused")
    public long getUptime() {
        long currentMillis = new Date().getTime();
        return (currentMillis - startMillis) / 1000;
    }
}