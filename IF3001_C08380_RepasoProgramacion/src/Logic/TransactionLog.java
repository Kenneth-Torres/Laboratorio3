/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.Date;

/**
 *
 * @author Laboratorios
 */
public class TransactionLog {
    
    private int transaction;
    private String event;
    private Date date;
    private Account account;
    private double movement;
    private static int consecutive;

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getMovement() {
        return movement;
    }

    public void setMovement(double movement) {
        this.movement = movement;
    }

    public static int getConsecutive() {
        return consecutive;
    }

    public static void setConsecutive(int consecutive) {
        TransactionLog.consecutive = consecutive;
    }
    //metodos de acceos

    public TransactionLog() {
        this.transaction = consecutive++;//variable statica que enumera los registros de transaccion
    }//constructor1
 

    public TransactionLog(String event, Account account, double movement) {
        this();//llamado al primer constructor
        this.event = event;
        this.date = new Date();
        this.account = account;
        this.movement = movement;
    }//constructor2

    @Override
    public String toString() {
        return "TransactionLog{" + "transaction=" + transaction + ", event=" + event + ", date=" + date + ", account=" + account + ", movement=" + movement + '}';
    }//to String
  
}//class
