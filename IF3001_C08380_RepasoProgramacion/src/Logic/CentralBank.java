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
public class CentralBank {
    
    private String centralBankName;
    private ArrayList<CommercialBank> banks;

    public String getCentralBankName() {
        return centralBankName;
    }

    public void setCentralBankName(String centralBankName) {
        this.centralBankName = centralBankName;
    }

    public ArrayList<CommercialBank> getBanks() {
        return banks;
    }

    public void setBanks(ArrayList<CommercialBank> banks) {
        this.banks = banks;
    }
    //metodos de acceso

    public CentralBank(String centralBankName) {
        this.centralBankName = centralBankName;
        this.banks = new ArrayList<>();
    }//constructor

    @Override
    public String toString() {
        return "CentralBank{" + "centralBankName=" + centralBankName +'}';
    }//to string

    public boolean moneyVerification(CommercialBank bankVerification,double money){
        return bankVerification.getBalanceBank()>=money;//retorna un boolean de verificacion
    }//metodo que verifica los fondos de un bank
    
    public CommercialBank searchBank(String bankName){
        for (CommercialBank bank : banks) {
            if (bankName.equals(bank.getBankName())) {
                System.out.println(bank.toString());
                return bank;
            }//si el nombre del banco es igual a un banco comerciallo retorna 
        }//recorre la lista de bancos comerciales
        return null;
    }//metodo que retorna un bank
    
    public void transactionBetweenBanks(double money, String phone){
        for (CommercialBank banco : banks) {
            banco.makeTransfer(money, phone);//llama al metodo de transaccion de los bancos hasta que se encuentra al usuario con el numero en cuestion
        }//for que pregunta a los bancos 
    }//metodo que verifica los fondos de un bank
 
}//class
