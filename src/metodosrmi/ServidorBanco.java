/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosrmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

/**
 *
 * @author matheus
 */
public class ServidorBanco extends UnicastRemoteObject implements ServicosBancarios{
    private float saldo;
    
    
    public ServidorBanco() throws RemoteException{
        super();
        saldo = 0;
        
        try {
            System.setProperty("java.rmi.server.hostname","172.16.34.206");
            LocateRegistry.createRegistry(4891);
            ServicosBancarios sb = new ServidorBanco();
            Naming.rebind("SERV_BANCARIO", (Remote) sb);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    @Override
    public synchronized  void depositar(float valor) throws RemoteException {
        saldo = saldo + valor;
    }

    @Override
    public synchronized void sacar(float valor) throws RemoteException, SaldoInsuficienteException{
        if(valor <= saldo){
            saldo = saldo - valor;
        }
        else{
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public synchronized float getSaldo() throws RemoteException {
        return saldo;
    }
    
    public static void main(String[] args) {
        try {
            ServidorBanco servidorBanco = new ServidorBanco();
        } catch (RemoteException e) {
             System.out.println(e.getMessage());
            return;
        }
    }
    
}
