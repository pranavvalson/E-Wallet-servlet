package com.deloitte.app.service;

import  com.deloitte.app.entities.*;
import java.util.*;


public interface IWalletService {

    void addCustomer(Wallet w);

    Wallet  findByNumber(String mobile);

    Set<Wallet> allCustomers();

    boolean credentialsCorrect(String mobile, String password);
}
