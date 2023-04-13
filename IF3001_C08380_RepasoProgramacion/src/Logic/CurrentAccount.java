/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public class CurrentAccount extends Account{
    
    private float interest;

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }
    //metodos de acceso

    public CurrentAccount(float interest, String acconuntNumber, Client accountClient, double balance,CommercialBank associateBank) {
        super(acconuntNumber, accountClient, balance,associateBank);
        this.interest = interest;
    }//constructor

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
        return this.getBalance()+(this.getBalance()*this.interest/12);//retorna el calculo de los interes
    }//metodo para calcular intereses
    
}//class
