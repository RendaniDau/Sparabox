package com.sparabox.controller;

import com.sparabox.business.AccountFlow;
import com.sparabox.business.DashboardFlow;
import com.sparabox.domain.business.DashboardDto;
import com.sparabox.domain.business.LinkCardRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    private final DashboardFlow dashboardFlow;

    private final AccountFlow accountFlow;

    @Autowired
    public DashboardController(DashboardFlow dashboardFlow, AccountFlow accountFlow) {
        this.dashboardFlow = dashboardFlow;
        this.accountFlow = accountFlow;
    }

    @GetMapping
    @ResponseBody
    public DashboardDto getDashboard(Principal principal) {
        LOGGER.info("::getDashboard({})", principal.getName());
        return dashboardFlow.getDashboard(principal.getName());
    }

    @PostMapping("validate-account")
    @ResponseBody
    public Boolean validateAccount(Principal principal, @RequestBody LinkCardRequestDto linkCardRequestDto) {
        LOGGER.info("::validateAccount({}, {})", principal.getName(), linkCardRequestDto.getAccountNumber());
        return accountFlow.validateAccountNumber(linkCardRequestDto.getAccountNumber());
    }

    @PostMapping("link-account")
    @ResponseBody
    public Boolean linkAccount(Principal principal, @RequestBody LinkCardRequestDto linkCardRequestDto) {
        LOGGER.info("::linkAccount({}, {}, {})", principal.getName(), linkCardRequestDto.getAccountNumber(), linkCardRequestDto.getCardNumber());
        return accountFlow.linkUserToAccount(principal.getName(), linkCardRequestDto.getAccountNumber(), linkCardRequestDto.getCardNumber());
    }

    @PostMapping("link-message-token")
    @ResponseBody
    public Boolean linkMessage(Principal principal, @RequestParam("messageToken") String messageToken) {
        LOGGER.info("::linkUserToMessageToken({}, {})", principal.getName(), messageToken);
        return accountFlow.linkUserToMessageToken(principal.getName(), messageToken);
    }
}
