package com.example.sistemadegerenciamento.models;
//importar Calendar e definir hora da instância

import com.example.sistemadegerenciamento.DAO.DAO;

import java.util.Calendar;
import java.util.Date;

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

	//A avalição do cliente não pode ser no momento da instância. Só após finalizar o serviço/ordem.
	//Possa ser que não tenha uma descrição?

    //se a categoria for MONTAGEM, define PEÇA

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
        //this.avaliacaoCliente = avaliacaoCliente;
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
        return categoria;
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

    public void setHorarioAbertura(Calendar horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public Calendar getHorarioFechamento() {
        return horarioFechamento;
    }

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
