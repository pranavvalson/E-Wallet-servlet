package com.deloitte.app.dao;

import com.deloitte.app.entities.*;
import java.util.*;

public interface IWalletDao {

    void addCustomer(Wallet w);

    Wallet  findByNumber(String mobile);

    Set<Wallet> allCustomers();

    boolean credentialsCorrect(String mobile, String password);
}
