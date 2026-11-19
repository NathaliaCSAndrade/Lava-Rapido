
package controller;

import java.util.ArrayList;
import java.util.List;
import model.TipoServico;
import model.NomeServico;


public class ControleServicos {
    private List<TipoServico> servicos = new ArrayList<TipoServico>();
    private String[] tipos;
    private int novoId = 0;
    
    public List<TipoServico> getServicos() {
        return servicos;
    }
    
    public String[] getNomesServ(){
        NomeServico[] servicos = NomeServico.values();
        String[] nomesServ = new String[servicos.length];
        int i = 0;
        while (i<servicos.length){
            nomesServ[i] = servicos[i].toString();
            i++;
        }
        return nomesServ;
    }
    
    public String[] getTipos(){
        return tipos;
    }
    
    public void setTipos(){
        tipos = new String[servicos.size()];
        int i = 0;
        for (TipoServico s: servicos){
            tipos[i] = s.getNome();
            i++;
        }
    }
    
    public void cadastrarServico(String nome, String descricao, double preco){
        TipoServico servico = new TipoServico();
        servico.setId(novoId);
        servico.setNome(NomeServico.valueOf(nome));
        servico.setDescricao(descricao);
        servico.setPreco(preco);
        servicos.add(servico);
        novoId++;
    }
    
    public String[] listarServicos(){
        String[] lista = new String[servicos.size()];
        int i = 0;
        for (TipoServico ts: servicos){
            lista[i]= (ts.getId() + "  Nome: " + ts.getNome() + "  Descrição: " + ts.getDescricao() + "  Preço: R$ " + ts.getPreco());
            i++;
        }
        return lista;
    }
}
