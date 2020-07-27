package com.sparabox.controller;

import com.sparabox.business.AuthorizationRequestProcessor;
import com.sparabox.domain.business.AuthorizationRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rendani.dau on 2020/04/23.
 */
@RestController
@RequestMapping("/investec")
public class InvestecIntegrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvestecIntegrationController.class);

    private final AuthorizationRequestProcessor authorizationRequestProcessor;

    @Autowired
    public InvestecIntegrationController(AuthorizationRequestProcessor authorizationRequestProcessor) {
        this.authorizationRequestProcessor = authorizationRequestProcessor;
    }

    @GetMapping
    @ResponseBody
    public String testRunning() {
        LOGGER.info("Server is accessible");

        return "Server accessible";
    }

    @PostMapping
    @ResponseBody
    public String uploadTransaction(@RequestBody AuthorizationRequestDto request) {
        LOGGER.info("::uploadTransaction({})", request);
        authorizationRequestProcessor.processTransaction(request);
        return "OK";
    }
}
