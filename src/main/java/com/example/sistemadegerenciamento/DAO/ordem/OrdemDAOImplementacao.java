package com.example.sistemadegerenciamento.DAO.ordem;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.CategoriaServico;
import com.example.sistemadegerenciamento.models.Ordem;
import com.example.sistemadegerenciamento.models.Servico;
import com.example.sistemadegerenciamento.models.StatusOrdem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrdemDAOImplementacao implements OrdemDAO{
    //Ordens em aberto e em espera
    HashMap<Integer, Ordem> ordensEmEspera = new HashMap<Integer, Ordem>();
    HashMap<Integer, Ordem> ordensAberta = new HashMap<>();
    HashMap<Integer, Ordem> ordensFinalizadas = new HashMap<>();
    HashMap<Integer, Ordem> ordensCanceladas = new HashMap<>();

    @Override
    public Ordem create(Ordem ordem) {
        ordensEmEspera.put(ordem.getOrdemID(), ordem);
        return null;
    }

    @Override
    public Ordem findById(int ordemID) {
        return ordensEmEspera.get(ordemID);
    }
    @Override
    public void delete(int ordemID) throws Exception {
        if (ordensEmEspera.get(ordemID) != null){
            ordensEmEspera.remove(ordemID);
        }
    }

    @Override
    public void deleteMany() {
        ordensEmEspera.clear();
    }
    //Se a ordem for cancelada, as peças que foram utilizadas, são devolvidas.
    public void cancelarOrdem(int ordemID){
        //Quando cancelar, tem que devolver as peças para o estoque
        this.ordensCanceladas.put(ordemID, this.ordensAberta.get(ordemID));
        this.ordensAberta.remove(ordemID);
        ArrayList<Servico> servicos = this.ordensCanceladas.get(ordemID).getServicos();
        for (int i=0; i<servicos.size(); i++){
            if (servicos.get(i).getCategoria() == CategoriaServico.MONTAGEM){
                DAO.getEstoque().devolucaoPeca(servicos.get(i).getPeca(), 1);
            }
        }
    }
    public Ordem finalizarOrdem(int ordemID){
        //Só pode finalizar ordem se todos os serviços forem finalizados
        this.ordensFinalizadas.put(ordemID, this.ordensAberta.get(ordemID));
        this.ordensAberta.remove(ordemID);
        return this.ordensFinalizadas.get(ordemID);
    }

    public void abrirOrdem(int ordemID, int tecnicoID){
        this.ordensAberta.put(ordemID, this.ordensEmEspera.get(ordemID));
        this.ordensEmEspera.remove(ordemID);
        this.ordensAberta.get(ordemID).setStatus(StatusOrdem.ABERTA);
        this.ordensAberta.get(ordemID).setTecnicoID(tecnicoID);
    }

    public long gerarTempoMedioDeOrdensFinalizadas(){
        long tempoMedioDeOrdensFinalizadas = 0;
        for (Map.Entry<Integer, Ordem> valor : ordensFinalizadas.entrySet()){
            tempoMedioDeOrdensFinalizadas = tempoMedioDeOrdensFinalizadas + valor.getValue().getTempoMedioDeServicos();
        }
        return tempoMedioDeOrdensFinalizadas;
    }

    public String gerarMediaSatisfacaoPorOrdem(){
        String satisfacaoGeral = new String();
        String nomeCliente;
        double mediaCliente;
        for (Map.Entry<Integer, Ordem> valor : ordensFinalizadas.entrySet()){
            nomeCliente = DAO.getCliente().findById(valor.getValue().getClienteID()).getNome();
            mediaCliente = valor.getValue().gerarMediaDeSatisfacaoDoCliente();
            satisfacaoGeral = "Ordem ID: " + valor.getValue().getOrdemID() + " - Cliente: " + nomeCliente + " - Média da satisfação por serviços: " + mediaCliente + ";\n";
        }
        return satisfacaoGeral;
    }

    public String verOrdensEmEspera(){
        String ordensEspera = new String();
        for (Map.Entry<Integer, Ordem> valor : ordensEmEspera.entrySet()){
            ordensEspera = ordensEspera + "Ordem: " + valor.getKey() + "\n";
        }
        return ordensEspera;
    }

}
