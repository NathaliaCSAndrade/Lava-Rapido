
package app;

import view.CadastrarCliente;
import controller.*;

public class Inicio {

    
    public static void main(String[] args) {
        ControleClientes controlcli = new ControleClientes();
        ControleAgenda controlagenda = new ControleAgenda();
        ControleServicos controlserv = new ControleServicos();
        controlagenda.setControleCliente(controlcli);
        controlagenda.setControleServico(controlserv);
        CadastrarCliente cli = new CadastrarCliente(controlcli, controlagenda, controlserv);
        cli.dispose();
        cli.setVisible(true);
    }
}
