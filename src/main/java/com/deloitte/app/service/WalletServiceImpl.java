package com.deloitte.app.service;

import com.deloitte.app.dao.IWalletDao;
import com.deloitte.app.entities.Wallet;
import com.deloitte.app.exception.*;

import java.util.Set;

public class WalletServiceImpl implements IWalletService {

    private IWalletDao dao;

    public WalletServiceImpl(IWalletDao dao) {
        this.dao = dao;
    }

    public WalletServiceImpl() {
    }

    @Override
    public void addCustomer(Wallet w) {
        if(w.getMobileNo().length() == 0 || w.getMobileNo().length()<10) {
            throw new MobileNotValid("Mobile number no valid");
        }
        dao.addCustomer(w);
    }

    @Override
    public Wallet findByNumber(String mobile) {
        if(mobile.length() == 0 || mobile.length()<10) {
            throw new MobileNotValid("Mobile number no valid");
        }
        return findByNumber(mobile);
    }

    @Override
    public Set<Wallet> allCustomers() {
        Set<Wallet> customers = dao.allCustomers();
        return customers;
    }

    @Override
    public boolean credentialsCorrect(String mobile, String password) {
        boolean validated = dao.credentialsCorrect(mobile, password);
        return validated;
    }
}
