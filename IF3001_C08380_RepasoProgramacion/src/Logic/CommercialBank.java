/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Laboratorios
 */
public class CommercialBank{
    
    private String bankName;
    private double balanceBank;
    private CentralBank centralBank;
    private ArrayList<Account> accounts;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public double getBalanceBank() {
        return balanceBank;
    }

    public void setBalanceBank(double balanceBank) {
        this.balanceBank = balanceBank;
    }

    public CentralBank getCentralBank() {
        return centralBank;
    }

    public void setCentralBank(CentralBank centralBank) {
        this.centralBank = centralBank;
    }
    //metodos de acceso

    public CommercialBank(String bankName, CentralBank centralBank) {
        this.bankName = bankName;
        this.balanceBank = 0;
        this.centralBank = centralBank;
        this.accounts = new ArrayList<>();
        this.centralBank.getBanks().add(this);//se agrega a la lista de bancos comeciales
    } //constructor

    @Override
    public String toString() {
        return "CommercialBank{" + "bankName=" + bankName + ", balanceBank=" + balanceBank + ", centralBank=" + centralBank + ", accounts=" + accounts + '}';
    }//to string

    public void createAccount(String tipoCuenta, int monthyTerm, float interest, String acconuntNumber, Client accountClient, double balance) {
        Account newAccount = null;
        if (tipoCuenta.equals("savingAccount")) {
            float curretItrerest = (float) (0.02);//interes de cuenta
            newAccount = new SavingAccount(new Date(), monthyTerm, curretItrerest, acconuntNumber, accountClient, balance, this);//instacia de un objeto cuenta
        } else if (tipoCuenta.equals("currentAccount")) {//en caso deuna centa corriente el proceso de creacion es igual
            float curretItrerest = (float) (0.14);
            newAccount = new CurrentAccount(curretItrerest, acconuntNumber, accountClient, balance, this);   
        }//crea un tipo de cuenta
        this.accounts.add(newAccount);//agrega la cuenta a la lista de cuentas existentes
        System.out.println("El calculo del interes de la cuenta es igual a : "+newAccount.interestCalculation());//muestra el resultado del calculo de intres
        System.out.println("Se creo una nueva cuenta en el banco " + this.bankName + " la cuenta es " + newAccount.toString());//enprime en consola la informacion de la cuenta
        this.balanceBank+=balance;//agrega la cuenta a la lista
    }//metodo que crea un nueva cuenta
    
    public void makeTransfer(double money, String phone){
        for (Account account : accounts) {
            if (account.getAccountClient().getPhone().equals(phone)) {
                account.deposit(money);//realiza la accion de deposito
                break;//si se encontro la cuenta no es necesario continuar el ciclo
            }//si que verifica la cuenta segun el numero de telefono
        }//recorre las cuentas abiertas para buscar
    }//metodo que realiza una transferecia dentro del mismo banco
    
    public boolean transactionBetweenBanks(double money, String phone){
        if (this.centralBank.moneyVerification(this, money)) {
            this.centralBank.transactionBetweenBanks(money, phone);//llama al metodo de la clase padre que permite la transaferencia entre bancos
            return true;
        } else {
            System.err.println("Este banco no puede relizar esta transferencia");
            return false;
        }//valida el saldo entre bancos para realizar la transfarencia
    }//metodo que realiza una transferecia dentro del mismo banco
    
    public Account searchAccount(String searchAccount){
        for (Account account : accounts) {
            if (searchAccount.equals(account.getAcconuntNumber())) {
                return account;//retorna la cuenta
            }//si el numero de cuenta resivido corresponde a una del banco la retorna 
        }//busca la cuenta del banco comercial
        return null;
    }//metodo que retorna un banco
    
}//class
