package com.yvonne.bankA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yvonne.bankcommon.service.BankAAccountService;

@RestController
@RequestMapping("/bank1")
public class AccountController {
    @Autowired
    private BankAAccountService accountService;

    @GetMapping("/hi")
    public String hello(){
        return "hi,this is bankA!";
    }


    @RequestMapping("/transfer")
    public Boolean transferNest() {
        return accountService.decreaseBalance("zs","ls", 100);
    }


}
