package com.deloitte.app.dao;

import com.deloitte.app.entities.Wallet;
import com.deloitte.app.exception.*;

import java.util.*;

public class WalletDaoImpl implements IWalletDao{
    private Map<String, Wallet> store = new HashMap<>();


    @Override
    public void addCustomer(Wallet w) {
        store.put(w.getMobileNo(), w);
    }

    @Override
    public Wallet findByNumber(String mobile) {
        Wallet wallet = store.get(mobile);
        if(wallet == null) {
            throw new NumberNotFoundException("Number not found!");
        }
        return wallet;
    }

    @Override
    public Set<Wallet> allCustomers() {
        Collection<Wallet> wallet = store.values();
        Set<Wallet> customers = new HashSet<>(wallet);
        return customers;
    }

    @Override
    public boolean credentialsCorrect(String mobile, String password) {
        Wallet user = store.get(mobile);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
