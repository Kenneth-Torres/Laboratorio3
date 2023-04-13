/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentcion;

import Logic.Account;
import Logic.CentralBank;
import Logic.Client;
import Logic.CommercialBank;
import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorios
 */
public class SistemTest {

    public static void test() {
        CentralBank centralBank = new CentralBank(JOptionPane.showInputDialog("Ingrese el nombre del banco central"));
        System.out.println(centralBank.toString());
        String accion = "";
        do {
            CommercialBank bankAccount = null;
            Account account = null;
            accion = JOptionPane.showInputDialog("Escriba  'banco' ,'cuenta' ,'transaccion','bitacora' y 'salir' para terminar");
            switch (accion) {
                case "banco":
                    bankAccount = new CommercialBank(JOptionPane.showInputDialog("Ingrese el nombre del banco comercial"), centralBank);
                    System.out.println(bankAccount.toString());
                    break;
                case "cuenta":
                    bankAccount = centralBank.searchBank(JOptionPane.showInputDialog("Ingrese el nombre del banco al que corresponde la cuenta"));
                    Client client = new Client(JOptionPane.showInputDialog("Ingrese la cedula del cliente"), JOptionPane.showInputDialog("Ingrese un nombre para el cliente"),
                            JOptionPane.showInputDialog("Ingrese un numero de telefono para el cliente"), JOptionPane.showInputDialog("Ingrese una direccion para el cliente"));
                    switch (JOptionPane.showInputDialog("Tipo de cuenta que desea crear 'ahorros' o 'corriente'")) {
                        case "ahorros":
                            bankAccount.createAccount("savingAccount", Integer.parseInt(JOptionPane.showInputDialog("plazo Meses")), (float) (0.02),
                                     JOptionPane.showInputDialog("Numero de cuenta"), client, Integer.parseInt(JOptionPane.showInputDialog("saldo")));
                            break;
                        case "corriente":
                            bankAccount.createAccount("currentAccount", 0, (float) (0.20), JOptionPane.showInputDialog("Numero de cuenta"),client,Integer.parseInt(JOptionPane.showInputDialog("saldo")));
                            break;
                    }//fin creacion de cuentas
                    break;
                case "transaccion":
                    bankAccount = centralBank.searchBank(JOptionPane.showInputDialog("Ingrese el nombre del banco al que corresponde la cuenta"));
                    account = bankAccount.searchAccount(JOptionPane.showInputDialog("Ingrese el numero de cuenta"));
                    switch (JOptionPane.showInputDialog("Tipo de transaccion 'depisto' ,'retiro' y 'sinpe'")) {
                        case "deposito":
                            account.deposit(Double.parseDouble(JOptionPane.showInputDialog("Dinero a depositar")));
                            break;
                        case "retiro":
                            account.withdraw(Double.parseDouble(JOptionPane.showInputDialog("Dinero a retirar")));
                            break;
                        case "sinpe":
                            account.sinpe(Double.parseDouble(JOptionPane.showInputDialog("Dinero a trasferir")), JOptionPane.showInputDialog("numero de telefono de destinatario"));
                            break;
                    }//fin creacion de cuentas
                    break;
                case "bitacora":
                    bankAccount = centralBank.searchBank(JOptionPane.showInputDialog("Ingrese el nombre del banco al que corresponde la cuenta"));
                    account = bankAccount.searchAccount(JOptionPane.showInputDialog("Ingrese el numero de cuenta"));
                    System.out.println("Transacciones relizadas por la cuenta");
                    for (int i = 0; i < account.getTransagtionLogs().size(); i++) {
                        if (account.getTransagtionLogs().get(i) != null) {
                            System.out.println(account.getTransagtionLogs().get(i).toString());
                        }//si no cunta con valores nulos se carga se muestra en consola la informacion
                    }//muestra la lista de transacciones
                    break;
            }//fin del switch
            System.out.println(" ");
        } while (!accion.equals("salir"));//fin while 
    }//fin del metodo de prueba
    
}//class
