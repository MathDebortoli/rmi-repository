/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodosrmi;
        
import java.rmi.*;

public interface ServicosBancarios extends Remote {

    public void depositar(float valor) throws RemoteException;
    
    public void sacar(float valor) throws RemoteException, SaldoInsuficienteException;
    
    public float getSaldo() throws RemoteException;
    
}
