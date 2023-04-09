package com.example.sistemadegerenciamento.DAO.ordem;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.CategoriaServico;
import com.example.sistemadegerenciamento.models.Ordem;
import com.example.sistemadegerenciamento.models.Servico;
import com.example.sistemadegerenciamento.models.StatusOrdem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que implementa todos os métodos de OrdemDAO;
 * */
public class OrdemDAOImplementacao implements OrdemDAO{
    /**
     * HashMap das ordens que foram criadas, mas ainda não foram abertas;
     * */
    HashMap<Integer, Ordem> ordensEmEspera = new HashMap<Integer, Ordem>();
    /**
     * HashMap das ordens que estão abertas aguardando atendimento;
     * */
    HashMap<Integer, Ordem> ordensAberta = new HashMap<>();
    /**
     * HashMap das ordens que foram finalizadas;
     * */
    HashMap<Integer, Ordem> ordensFinalizadas = new HashMap<>();
    /**
     * HashMap das ordens que foram canceladas;
     * */
    HashMap<Integer, Ordem> ordensCanceladas = new HashMap<>();
    /**
     * Método que salva a ordem no HashMap;
     * */
    @Override
    public Ordem create(Ordem ordem) {
        ordensEmEspera.put(ordem.getOrdemID(), ordem);
        return null;
    }
    /**
     * Método que retorna a ordem buscada no HashMap;
     * */
    @Override
    public Ordem findById(int ordemID) {
        return ordensEmEspera.get(ordemID);
    }
    /**
     * Método que deleta a ordem enviada do HashMap;
     * */
    @Override
    public void delete(int ordemID) throws Exception {
        if (ordensEmEspera.get(ordemID) != null){
            ordensEmEspera.remove(ordemID);
        }
    }
    /**
     * Método que limpa todo o HashMap;
     * */
    @Override
    public void deleteMany() {
        ordensEmEspera.clear();
    }
    //Se a ordem for cancelada, as peças que foram utilizadas, são devolvidas.
    /**
     * Método que cancela uma ordem do HashMap e devolve as peças dos serviços para o estoque;
     * */
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
    /**
     * Método que finaliza a ordem;
     * */
    public Ordem finalizarOrdem(int ordemID){
        //Só pode finalizar ordem se todos os serviços forem finalizados
        this.ordensFinalizadas.put(ordemID, this.ordensAberta.get(ordemID));
        this.ordensAberta.remove(ordemID);
        this.ordensFinalizadas.get(ordemID).gerarTempoMedioDeServicos();
        return this.ordensFinalizadas.get(ordemID);
    }
    /**
     * Método que tira a ordem de espera e a abre para relacioná-la com o técnico;
     * */
    public void abrirOrdem(int ordemID, int tecnicoID){
        this.ordensAberta.put(ordemID, this.ordensEmEspera.get(ordemID));
        this.ordensEmEspera.remove(ordemID);
        this.ordensAberta.get(ordemID).setStatus(StatusOrdem.ABERTA);
        this.ordensAberta.get(ordemID).setTecnicoID(tecnicoID);
    }
    /**
     * Método que retorna o tempo médio de todas as ordens finalizadas;
     * */
    public long gerarTempoMedioDeOrdensFinalizadas(){
        long tempoMedioDeOrdensFinalizadas = 0;
        for (Map.Entry<Integer, Ordem> valor : ordensFinalizadas.entrySet()){
            tempoMedioDeOrdensFinalizadas = tempoMedioDeOrdensFinalizadas + valor.getValue().getTempoMedioDeServicos();
        }
        return tempoMedioDeOrdensFinalizadas;
    }
    /**
     * Método que retorna uma String como a média de satisfação por ordem, informando o ID da ordem, o nome do cliente e a média de satisfação;
     * */
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
    /**
     * Método que retorna as ordens em espera de atendimento;
     * */
    public String verOrdensEmEspera(){
        String ordensEspera = new String();
        for (Map.Entry<Integer, Ordem> valor : ordensEmEspera.entrySet()){
            ordensEspera = ordensEspera + "Ordem: " + valor.getKey() + "\n";
        }
        return ordensEspera;
    }

}
