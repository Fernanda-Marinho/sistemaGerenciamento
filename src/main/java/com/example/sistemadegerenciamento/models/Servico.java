package com.example.sistemadegerenciamento.models;
import com.example.sistemadegerenciamento.DAO.DAO;

import java.util.Calendar;
import java.util.Date;

/**
 * Classe responsável por armazenar dados e comportamentos dos serviços.
 * */
public class Servico {

    private CategoriaServico categoria;
    private double valor;
    private Calendar horarioAbertura;
    private Calendar horarioFechamento;
    private int avaliacaoCliente;
    private int ordemID;
    private Peca peca;
    private String descricao;
    private boolean finalizado;


    public Servico (CategoriaServico categoria, double valor, int ordemID, Peca peca, String descricao) throws Exception {
        if (categoria == CategoriaServico.MONTAGEM){
            if (DAO.getEstoque().verDisponibilidadeDePeca(peca)){
                DAO.getEstoque().decrementaPeca(peca);
            } else {
                throw new Exception("Peça não está disponível no estoque.");
            }
        }
        this.categoria = categoria;
        this.valor = valor;
        this.ordemID = ordemID;
        this.peca = peca;
        this.descricao = descricao;
        // Registrar a data e hora atuais
        Calendar abertura = Calendar.getInstance();
        abertura.setTime(new Date());
        this.horarioAbertura = abertura;
        this.finalizado = false;
    }

    public CategoriaServico getCategoria() {
        return this.categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getHorarioAbertura() {
        return horarioAbertura;
    }

    public Calendar getHorarioFechamento() {
        return horarioFechamento;
    }
    /**
     * Método que finaliza o serviço, registrando o horário de fechamento do serviço.
     * */
    public void finalizarServico(int avaliacaoCliente) {
        Calendar fechamento = Calendar.getInstance();
        fechamento.setTime(new Date());
        this.horarioFechamento = fechamento;
        this.finalizado = true;
        this.avaliacaoCliente = avaliacaoCliente;
    }

    public int getAvaliacaoCliente() {
        return avaliacaoCliente;
    }

    public int getOrdemID() {
        return ordemID;
    }

    public void setOrdemID(int ordemID) {
        this.ordemID = ordemID;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado(){
        return this.finalizado;
    }
}
