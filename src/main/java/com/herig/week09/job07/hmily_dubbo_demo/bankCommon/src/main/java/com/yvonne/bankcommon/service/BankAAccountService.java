package com.yvonne.bankcommon.service;


public interface BankAAccountService {

    Boolean decreaseBalance(String from, String to, double amount);

}
