package com.deloitte.app.entities;

import java.util.Objects;

public class Wallet {
    private String mobileNo;
    private String name;
    private String password;
    private double balance;

    public Wallet() {
    }

    public Wallet(String mobileNo, String name, double balance, String password) {
        this.mobileNo = mobileNo;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double amount) {
        this.balance+=amount;
    }


    public boolean checkNumber(String number) {
        return this.getMobileNo().equals(number);
    }


    @Override
    public String toString() {
        String display = this.mobileNo+" "+this.name+" "+this.balance;
        return display;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Double.compare(wallet.balance, balance) == 0 &&
                Objects.equals(mobileNo, wallet.mobileNo) &&
                Objects.equals(name, wallet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileNo, name, balance);
    }


}
