package com.yvonne.bankcommon.service;

public interface BankBAccountService {
    boolean increaseAccountBalance(String user_id,String inAccountNo, double amount);
}
