package com.yvonne.bankB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.yvonne.bankcommon.service.BankBAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankB")
public class AccountController {
    @Autowired
    private BankBAccountService bankBAccountService;
    @GetMapping("/hi")
    public String hello(){
        return "hi,this is bankB!";
    }

    @RequestMapping("/transfer")
    public Boolean transfer() {
        this.bankBAccountService.increaseAccountBalance("ls","LS_MY", 10d);
        return true;
    }
}
