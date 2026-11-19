
package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import model.*;

public class ControleAgenda {
    private List<Agendamento> agendamentos = new ArrayList<>();
    private int novoId = 0;
    private ControleClientes controlcli;
    private ControleServicos controlserv;
    
    public void setControleCliente(ControleClientes cc){
        this.controlcli = cc;
    }
    
    public ControleClientes getControle(){
        return controlcli;
    }
    
    public void setControleServico(ControleServicos cs){
        this.controlserv = cs;
    }
    
    public ControleServicos getControleServico(){
        return controlserv;
    }
    
    public void agendar(String cli, String ts, String datahora){
        Agendamento agendamento = new Agendamento();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        agendamento.setId(novoId);
        for (Cliente c: controlcli.getClientes()){
            if (c.getNome().equalsIgnoreCase(cli)){
                agendamento.setCliente(c);
            }
        }
        for (TipoServico s: controlserv.getServicos()){
            if (s.getNome().equalsIgnoreCase(ts)){
                agendamento.setTipoServico(s);
            }
        }
        for (Agendamento a: agendamentos){
            if (!a.getDataHora().toString().equals(datahora)){
                agendamento.setDataHora(LocalDateTime.parse(datahora, formato));
                agendamento.setStatus(Status.AGENDADO);
                agendamentos.add(agendamento);
                novoId++;
            }
        }
    }
    
    public void editarAgenda(int id, String cli, String ts, String datahora){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        for (Agendamento ag: agendamentos){
            if (id==ag.getId()){
                for (Cliente c: controlcli.getClientes()){
                    if (c.getNome().equalsIgnoreCase(cli)){
                        ag.setCliente(c);
                    }
                }
                for (TipoServico s: controlserv.getServicos()){
                    if (s.getNome().equalsIgnoreCase(ts)){
                        ag.setTipoServico(s);
                    }
                }
                if (!datahora.isBlank()){
                    ag.setDataHora(LocalDateTime.parse(datahora, formato));
                }
                ag.setStatus(Status.AGENDADO);
            }
        }
    }
    
    public void cancelarAgendamento(int id){
        for (Agendamento ag: agendamentos){
            if (id==ag.getId()){
                ag.setStatus(Status.CANCELADO);
            }
        }
    }
    
    public String[] agenda(){
        String[] lista = new String[agendamentos.size()];
        int i = 0;
        for (Agendamento ag: agendamentos){
            lista[i]= (ag.getId() + "  Cliente: " + ag.getCliente().getNome() + "  Serviço: " + ag.getTipoServico().getNome() + "  Horário: " + ag.getDataHora() + "  Status: " + ag.getStatus());
            i++;
        }
        return lista;
    }
}
