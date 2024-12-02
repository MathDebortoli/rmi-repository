/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package metodosrmi;

import java.rmi.Naming;


/**
 *
 * @author matheus
 */
public class UserRmi {

    public static void main(String[] args) {
        try {
            ServicosBancarios  servico = (ServicosBancarios) Naming.lookup("rmi://172.16.34.206:4891/SERV_BANCARIO");

            
            System.out.println("Deposito de 4000");
            servico.depositar(4000F);
            
            System.out.println("Saque de 490");
            servico.sacar(490F);
            
            float saldo = servico.getSaldo();
            System.out.println(String.valueOf(saldo));
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
            return;
        }
    }
}
