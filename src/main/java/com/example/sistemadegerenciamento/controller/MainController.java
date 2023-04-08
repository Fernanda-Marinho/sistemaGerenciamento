package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Cada tecnico so pode pegar uma ordem


/*
* Barema:
* CRUD das classes
* Padrão de projeto DAO
* Teste de unidade das classes de modelo
* Testes das operações de sistema
* Registro de clientes
* Gerenciamento de ordens de serviço
* Agenda de atendimento
* Gerenciamento de peças e estoque
* Faturamento e pagamento
* Relatórios
* Documentação em JAVADOC
* Commits estruturados adequadamente
* Documentação no github
* */

/*
* No controller, utilizaremos da classe DAO para chamar o método que dá get na classe DAO necessária.
* Por exemplo, DAO.getCliente() irá retornar um ClienteDAOImplementacao, para que possa realizar o CRUD na persistência.
* */

//falta manipular estoque, criação de técnico, criação de clientes, manipulação de ordens
// manipulação de DAO. 
public class MainController {
    public Tecnico criaTecnico(boolean adm, String nome, String senha){
        Tecnico tecnico = new Tecnico(adm, nome, senha);
        DAO.getTecnico().create(tecnico);
        return tecnico;
    }
    //Se o login for o ADM, poderá deletar outros técnicos
    public void deletaTecnico(Tecnico tecnicoADM, int idTecnicoADeletar) throws Exception {
        if (tecnicoADM.isAdm()){
            DAO.getTecnico().delete(idTecnicoADeletar);
        }
    }
    public void atualizaTecnico(Tecnico tecnicoADM, int idTecnicoAAtualizar, String nome, String senha){
        if (tecnicoADM.isAdm()) {
            DAO.getTecnico().update(idTecnicoAAtualizar, nome, senha);
        }
    }
    public HashMap<Integer, Tecnico> buscaTodosTecnicos(){
        return DAO.getTecnico().findMany();
    }

    public Tecnico buscaTecnico(int idTecnico){
        return DAO.getTecnico().findById(idTecnico);
    }
    public boolean validaLogin(int tecnicoID, String nome, String senha){
        try {
            if (DAO.getTecnico().findById(tecnicoID).getSenha() == senha) {
                return true;
            }
            return false;
        } catch (NullPointerException e){
            System.out.println("Este usuário não está cadastrado.");
            return false;
        }
    }
    public Cliente criaCliente(String nome, String endereco, String telefone){
        Cliente cliente = new Cliente(nome, endereco, telefone);
        DAO.getCliente().create(cliente);
        return cliente;
    }
    public void atualizaCliente(int clienteID, String nome, String endereco, String telefone){
        DAO.getCliente().update(clienteID, nome, endereco, telefone);
    }
    public void deletaCliente(Tecnico tecnicoADM, int idCliente) throws Exception{
        if (tecnicoADM.isAdm())
            DAO.getCliente().delete(idCliente);
    }
    public HashMap<Integer, Cliente> buscaTodosClientes(){
        return DAO.getCliente().findMany();
    }
    public Cliente buscaCliente(int idCliente){
        return DAO.getCliente().findById(idCliente);
    }

    public Ordem criaOrdem(int clienteID){
        Ordem ordem = new Ordem(clienteID);
        DAO.getOrdem().create(ordem);
        return ordem;
    }
    public Fatura finalizaOrdem(int ordemID){
        Ordem ordem = DAO.getOrdem().finalizarOrdem(ordemID);
        ordem.setStatus(StatusOrdem.FINALIZADA);
        Fatura fatura = gerarFatura(ordem);
        return fatura;
    }
    public  void cancelaOrdem(int ordemID){
        DAO.getOrdem().findById(ordemID).setStatus(StatusOrdem.CANCELADA);
        DAO.getOrdem().cancelarOrdem(ordemID);
    }
    public void addServico(int ordemID, CategoriaServico categoria, double valor, Peca peca, String descricao) throws Exception {
        Servico servico = new Servico(categoria, valor, ordemID, peca, descricao);
        DAO.getOrdem().findById(ordemID).addServico(servico);
    }

    public void finalizaServico(int ordemID, Servico servico, int avaliacaoCliente){
        DAO.getOrdem().findById(ordemID).finalizarServico(servico, avaliacaoCliente);
    }
    public ArrayList<Servico> buscaServicosPorOrdem(int ordemID){
        return DAO.getOrdem().findById(ordemID).getServicos();
    }
    public void removeServico(Servico servico, int ordemID){
        DAO.getOrdem().findById(ordemID).removerServico(servico);
    }
    public boolean relacionaOrdemATecnico(int ordemID, int tecnicoID){
        if (!(DAO.getTecnico().findById(tecnicoID).isComOrdem())) {
            DAO.getOrdem().abrirOrdem(ordemID, tecnicoID);
            return true;
        }
        return false;
    }
    public Fatura gerarFatura(Ordem ordem){
        return ordem.gerarFatura();
    }
    public HashMap<Peca, Integer> verEstoque(){
        return DAO.getEstoque().verEstoque();
    }
    public void realizaOrdemCompra(Peca peca, int quantidade, double valorUnitario){
        OrdemCompra ordemCompra = new OrdemCompra(peca, quantidade, valorUnitario);
        DAO.getEstoque().addOrdemCompra(ordemCompra);
    }
    public String geraRelatorio(){
        String relatorio = new String();
        relatorio = "Tempo médio de espera de ordens finalizadas: " + DAO.getOrdem().gerarTempoMedioDeOrdensFinalizadas() + "mins;\n";
        relatorio = relatorio + "Custo total de peças nas ordens de compras: R$" + DAO.getEstoque().gerarCustoTotalOrdensCompra() + ";\n";
        relatorio = relatorio + "Estoque atual:\n" + DAO.getEstoque().verEstoqueFormatado();
        relatorio = relatorio + DAO.getOrdem().gerarMediaSatisfacaoPorOrdem();
        return relatorio;
    }

    public String verAgendaDeAtendimento(){
        return DAO.getOrdem().verOrdensEmEspera();
    }

    public static void main(String[] args) {
        //Primeiro passo é realizar login
        //Técnico ADM: login = Admin, senha = Admin
        MainController mainC = new MainController();
        mainC.criaTecnico(true, "Admin", "Admin");
        System.out.println(mainC.validaLogin(DAO.getTecnico().findById(1).getTecnicoID(), "Douglas", "123456789"));
    }
}
