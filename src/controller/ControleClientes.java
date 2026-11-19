
package controller;

import java.util.List;
import java.util.ArrayList;
import model.Cliente;

public class ControleClientes {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private String[] nomes;
    private int novoId = 0;
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public String[] getNomes() {
        return nomes;
    }
    
    public void setNomes(){
        nomes = new String[clientes.size()];
        int i = 0;
        for (Cliente c: clientes){
            nomes[i] = c.getNome();
            i++;
        }
    }
    
    public void cadastrarCliente(String nome, String cpf, String telefone, String email, String placa){
        Cliente cli = new Cliente();
        cli.setId(novoId);
        cli.setNome(nome);
        cli.setCpf(cpf);
        cli.setTelefone(telefone);
        cli.setEmail(email);
        cli.setPlacaVeiculo(placa);
        clientes.add(cli);
        novoId++;
    }
    
    public void editarCliente(int id, String nome, String cpf, String telefone, String email, String placa){
        for (Cliente c: clientes){
            if (id==c.getId()){
                if (!nome.isBlank()){
                    c.setNome(nome);
                }
                if (!cpf.isBlank()){
                    c.setCpf(cpf);
                }
                if (!telefone.isBlank()){
                    c.setTelefone(telefone);
                }
                if (!email.isBlank()){
                    c.setEmail(email);
                }
                if (!placa.isBlank()){
                    c.setPlacaVeiculo(placa);
                }
            }
        }
    }
    
    public void excluirCliente(int id){
        for (Cliente c: clientes){
            if (id==c.getId()){
                clientes.remove(c);
            }
        }
    }
    
    public String[] listarClientes(){
        String[] lista = new String[clientes.size()];
        int i = 0;
        for (Cliente c: clientes){
            lista[i] = (c.getId() + "  Nome: " + c.getNome() + "  CPF: " + c.getCpf() + "  Telefone: "+ c.getTelefone() + "  Email: " + c.getEmail() + "  Placa do Veículo: " + c.getPlacaVeiculo());
            i++;
        }
        return lista;
    }
}
