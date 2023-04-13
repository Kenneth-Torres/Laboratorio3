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
public class SavingAccount extends Account{

    private Date date;
    private int monthyTerm;
    private float interest;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMonthyTerm() {
        return monthyTerm;
    }

    public void setMonthyTerm(int monthyTerm) {
        this.monthyTerm = monthyTerm;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }
    //metodos de acceso
    

    public SavingAccount(Date date, int monthyTerm, float interest, String acconuntNumber, Client accountClient, double balance,CommercialBank associateBank) {
        super(acconuntNumber, accountClient, balance,associateBank);
        this.date = date;
        this.monthyTerm = monthyTerm;
        this.interest = interest;
    }//constructor

    @Override
    public String toString() {
        return super.toString()+" SavingAccount{" + "date=" + date + ", monthyTerm=" + monthyTerm + ", interest=" + interest + '}';
    }//to string
    
    @Override
    public void deposit(double money) {
         if (money<0) {
            System.err.println("not possible to deposit");
        } else {
            super.setBalance(super.getBalance() + money);//se relizan los cambios en el balance de la cuenta
            super.getTransagtionLogs().add(new TransactionLog("deposit", this, money));//se agrega un registro al registro de la cuenta
            super.getAssociateBank().setBalanceBank(super.getAssociateBank().getBalanceBank() + money);//altera la cantidad de dinero fisico en el banco
            System.out.println("Se relizo un deposito a la cuenta " + super.toString());//se muestra la informacion
        }//if que verifica que el depisito no sea menor a 0
    }//metodo para sumar fondos a una cuenta

    @Override
    public void withdraw(double money) {
        if (money > this.getBalance()) {
            System.err.println("you have no money");
        } else {
            super.setBalance(super.getBalance() - money);//se relizan los cambios en el balance de la cuenta
            super.getTransagtionLogs().add(new TransactionLog("whidrow", this, money));//se agrega un registro al registro de la cuenta
            super.getAssociateBank().setBalanceBank(super.getAssociateBank().getBalanceBank()-money);//se realizan los cambios  en el balance del banco
            System.out.println("Se relizo un retio de la cuenta " + super.toString());//se muestra la informacion
        }//if para verificar el dinero a extraer 
    }//metodo para retirar montos

    @Override
    public void sinpe(double money, String phone) {
        if (super.getAssociateBank().transactionBetweenBanks(money, phone)) {//llama al metodo para realizar una trasferencia entre bancos
            this.withdraw(money);//realiza un retiro de fondos
            super.getTransagtionLogs().add(new TransactionLog("sinpe", this, money));//se agrega un registro al registro de la cuenta
        }//si se puede realizar la tranferencia se reliza el retiro de la cuenta y la bitacora
    }//metodo para realizar un sinpe a otra cuenta

    @Override
    public double interestCalculation() {
       double totalIntereset;
       totalIntereset=this.getMonthyTerm()*this.getInterest()*this.getBalance();
      return this.getBalance()+totalIntereset;//retorna el calculo de los interes
    }//metodo para calcular intereses
 
    
}//class
