package com.deloitte.app.ui;

import com.deloitte.app.dao.WalletDaoImpl;
import com.deloitte.app.entities.Wallet;
import com.deloitte.app.service.IWalletService;
import com.deloitte.app.service.WalletServiceImpl;

import java.util.Collection;
import java.util.Set;

public class Accounts {
    private WalletServiceImpl service = new WalletServiceImpl(new WalletDaoImpl());

    public static void main(String[] args) {
        Accounts acc = new Accounts();
        acc.execute();
    }

    public void execute() {
        try {
            Wallet w1 = new Wallet("9895553766", "Pranav", 500, "abc");
            Wallet w2 = new Wallet("9895550000", "Sid", 200, "sad");
            service.addCustomer(w1);
            service.addCustomer(w2);

            Set<Wallet> wallets = service.allCustomers();
            print(wallets);

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }
    }

    public void print(Collection<Wallet> wallets) {
        for(Wallet wallet : wallets) {
            System.out.println(wallet);
        }
    }
}
