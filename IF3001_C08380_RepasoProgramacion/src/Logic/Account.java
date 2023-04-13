/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author Laboratorios
 */
public abstract class Account {
    
    private String acconuntNumber;
    private Client accountClient;
    private double balance;
    private CommercialBank associateBank;
    private ArrayList<TransactionLog> transagtionLogs;

    public String getAcconuntNumber() {
        return acconuntNumber;
    }

    public void setAcconuntNumber(String acconuntNumber) {
        this.acconuntNumber = acconuntNumber;
    }

    public Client getAccountClient() {
        return accountClient;
    }

    public void setAccountClient(Client accountClient) {
        this.accountClient = accountClient;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CommercialBank getAssociateBank() {
        return associateBank;
    }

    public void setAssociateBank(CommercialBank associateBank) {
        this.associateBank = associateBank;
    }

    public ArrayList<TransactionLog> getTransagtionLogs() {
        return transagtionLogs;
    }

    public void setTransagtionLogs(ArrayList<TransactionLog> transagtionLogs) {
        this.transagtionLogs = transagtionLogs;
    }
    //metodos de acceso

    public Account(String acconuntNumber, Client accountClient, double balance,CommercialBank associateBank) {
        this.acconuntNumber = acconuntNumber;
        this.accountClient = accountClient;
        this.balance = balance;
        this.associateBank=associateBank;
        this.transagtionLogs = new ArrayList<>();
    }//constructor

    @Override
    public String toString() {
        return "Account{" + "acconuntNumber=" + acconuntNumber + ", accountClient=" + accountClient.toString() + ", balance=" + balance + '}';
    }
    //to string
    
    public abstract double interestCalculation();
    public abstract void deposit(double money);
    public abstract void withdraw(double money);
    public abstract void sinpe(double money,String phone);
    
    
    
}//class
