package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
    @Test
    void criaTecnico() {
        Tecnico tec = new Tecnico(false, "lalala", "12345");
        DAO.getTecnico().create(tec);
        int id = tec.getTecnicoID();
        assertEquals(tec, DAO.getTecnico().findById(id));
    }
    @Test
    void deletaTecnico() throws Exception {
        Tecnico tec = new Tecnico(true, "lalala", "12345");
        DAO.getTecnico().create(tec);
        Tecnico tec2 = new Tecnico(false, "lelele", "12345");
        DAO.getTecnico().create(tec2);
        int id = tec2.getTecnicoID();
        if (tec.isAdm()){
            DAO.getTecnico().delete(id);
        }
        assertNotEquals(tec2, DAO.getTecnico().findById(id));
    }
    @Test
    void atualizaTecnico() {
        DAO.getTecnico().deleteMany();
        Tecnico tecnico = new Tecnico(true, "admin", "admin");
        Tecnico tecnico2 = new Tecnico(false, "robert", "blabla");
        DAO.getTecnico().create(tecnico);
        DAO.getTecnico().create(tecnico2);
        if (tecnico.isAdm())
            DAO.getTecnico().update(tecnico2.getTecnicoID(), "manuela", "bleble");
        assertEquals(DAO.getTecnico().findById(tecnico2.getTecnicoID()).getNome(), "manuela");
        assertEquals(DAO.getTecnico().findById(tecnico2.getTecnicoID()).getSenha(), "bleble");

    }

    @Test
    void buscaTodosTecnicos() {
        DAO.getTecnico().deleteMany();
        Tecnico tecnico = new Tecnico(false, "Roberto", "12345");
        Tecnico tecnico2 = new Tecnico(true, "Juliana Passos", "admin");
        DAO.getTecnico().create(tecnico);
        DAO.getTecnico().create(tecnico2);
        HashMap <Integer, Tecnico> tecnicos = new HashMap<>();
        tecnicos.put(tecnico.getTecnicoID(), tecnico);
        tecnicos.put(tecnico2.getTecnicoID(), tecnico2);
        assertEquals(DAO.getTecnico().findMany(), tecnicos);
    }

    @Test
    void buscaTecnico() {
        Tecnico tec = new Tecnico(false, "Maria", "mdemdime");
        DAO.getTecnico().create(tec);
        assertEquals(tec, DAO.getTecnico().findById(tec.getTecnicoID()));
    }

    @Test
    void validaLogin() {
        Tecnico tec = new Tecnico(false, "Maria", "mdemdime");
        DAO.getTecnico().create(tec);
        String login = new String("Maria");
        String senha = new String("mdemdime");
        assertEquals(senha, DAO.getTecnico().findById(tec.getTecnicoID()).getSenha());
        assertEquals(login, DAO.getTecnico().findById(tec.getTecnicoID()).getNome());
    }

    @Test
    void criaCliente() {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        assertEquals(DAO.getCliente().findById(cliente.getClienteID()), cliente);
    }

    @Test
    void atualizaCliente() {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        DAO.getCliente().update(cliente.getClienteID(), "Douglas Oliveira", "rua ble ble", "750293432");
        assertEquals(DAO.getCliente().findById(cliente.getClienteID()).getNome(), "Douglas Oliveira");
        assertEquals(DAO.getCliente().findById(cliente.getClienteID()).getEndereco(), "rua ble ble");
        assertEquals(DAO.getCliente().findById(cliente.getClienteID()).getTelefone(), "750293432");
        assertNotEquals(DAO.getCliente().findById(cliente.getClienteID()).getNome(), "Douglas");
    }

    @Test
    void deletaCliente() throws Exception {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        DAO.getCliente().delete(cliente.getClienteID());
        assertEquals(null, DAO.getCliente().findById(1));
    }

    @Test
    void buscaTodosClientes() {
        DAO.getCliente().deleteMany();
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        Cliente cliente2 = new Cliente("Jorge Silva", "malamamalam", "24234324");
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        clientes.put(cliente.getClienteID(), cliente);
        clientes.put(cliente2.getClienteID(), cliente2);
        DAO.getCliente().create(cliente);
        DAO.getCliente().create(cliente2);
        assertEquals(clientes, DAO.getCliente().findMany());
    }

    @Test
    void buscaCliente() {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        assertEquals(cliente, DAO.getCliente().findById(cliente.getClienteID()));
    }

    @Test
    void criaOrdem() {
        Ordem ordem = new Ordem(1);
        DAO.getOrdem().create(ordem);
        assertEquals(DAO.getOrdem().findById(ordem.getOrdemID()), ordem);
    }

    @Test
    void finalizaOrdem() {
        Ordem ordem = new Ordem(1);
        DAO.getOrdem().create(ordem);
        DAO.getOrdem().abrirOrdem(ordem.getOrdemID(), 1);
        DAO.getOrdem().finalizarOrdem(ordem.getOrdemID());
        assertEquals(DAO.getOrdem().findByIdFinalizada(ordem.getOrdemID()), ordem);
    }

    @Test
    void cancelaOrdem() {
        Ordem ordem = new Ordem(1);
        DAO.getOrdem().create(ordem);
        DAO.getOrdem().cancelarOrdem(ordem.getOrdemID());
        assertEquals(DAO.getOrdem().findByIdCancelada(ordem.getOrdemID()), ordem);
    }

    @Test
    void addServico() throws Exception {
        Ordem ordem = new Ordem(1);
        Servico serv = new Servico(CategoriaServico.FORMATACAO, 4342.3, 1, null, "sem descr");
        ordem.addServico(serv);
        DAO.getOrdem().create(ordem);
        assertEquals(DAO.getOrdem().findById(ordem.getOrdemID()).getServicos().get(0), serv);
    }

    @Test
    void finalizaServico() throws Exception {
        Ordem ordem = new Ordem(1);
        Servico serv = new Servico(CategoriaServico.FORMATACAO, 4342.3, 1, null, "sem descr");
        ordem.addServico(serv);
        DAO.getOrdem().create(ordem);
        ordem.finalizarServico(serv, 5);
        assertEquals(ordem.gerarMediaDeSatisfacaoDoCliente(), 5.0);
    }

    @Test
    void buscaServicosPorOrdem() throws Exception {
        Ordem ordem = new Ordem(1);
        Servico serv = new Servico(CategoriaServico.FORMATACAO, 4342.3, 1, null, "sem descr");
        Servico serv2 = new Servico(CategoriaServico.FORMATACAO, 4342.3, 1, null, "sem descr");
        ArrayList<Servico> servicos = new ArrayList<>();
        servicos.add(serv);
        servicos.add(serv2);
        ordem.addServico(serv);
        ordem.addServico(serv2);
        DAO.getOrdem().create(ordem);
        assertEquals(DAO.getOrdem().findById(ordem.getOrdemID()).getServicos(), servicos);
    }

    @Test
    void removeServico() throws Exception {
        Ordem ordem = new Ordem(1);
        Servico serv = new Servico(CategoriaServico.FORMATACAO, 4342.3, 1, null, "sem descr");
        Servico serv2 = new Servico(CategoriaServico.FORMATACAO, 4342.3, 1, null, "sem descr");
        ArrayList<Servico> servicos = new ArrayList<>();
        servicos.add(serv);
        servicos.add(serv2);
        ordem.addServico(serv);
        ordem.addServico(serv2);
        ordem.removerServico(serv);
        DAO.getOrdem().create(ordem);
        assertNotEquals(DAO.getOrdem().findById(ordem.getOrdemID()).getServicos(), servicos);
    }

    @Test
    void relacionaOrdemATecnico() {
        Ordem ordem = new Ordem(2);
        Tecnico tecnico = new Tecnico(true, "admin", "admin");
        DAO.getTecnico().create(tecnico);
        DAO.getOrdem().create(ordem);
        DAO.getOrdem().abrirOrdem(ordem.getOrdemID(), tecnico.getTecnicoID());
        DAO.getTecnico().findById(tecnico.getTecnicoID()).addOrdem(DAO.getOrdem().findById(ordem.getOrdemID()));
        assertEquals(DAO.getOrdem().findByIdAberta(ordem.getOrdemID()).getTecnicoID(), tecnico.getTecnicoID());
        assertEquals(DAO.getTecnico().findById(tecnico.getTecnicoID()).isComOrdem(), true);
    }

    @Test
    void gerarFatura() throws Exception {
        Ordem ordem = new Ordem(1);
        DAO.getOrdem().create(ordem);
        Servico serv = new Servico(CategoriaServico.LIMPEZA, 123, 1, null, "sem");
        DAO.getOrdem().findById(ordem.getOrdemID()).addServico(serv);
        DAO.getOrdem().abrirOrdem(ordem.getOrdemID(), 1);
        DAO.getOrdem().finalizarOrdem(ordem.getOrdemID());
        Fatura fat = DAO.getOrdem().findByIdFinalizada(ordem.getOrdemID()).gerarFatura();
        assertEquals(fat.getValorTotal(), 123);
    }

    @Test
    void verEstoque() {
        Peca peca = new Peca("RAM", 123);
        OrdemCompra ordemCompra = new OrdemCompra(peca, 10, 123);
        DAO.getEstoque().addOrdemCompra(ordemCompra);
        Peca peca2 = new Peca("RAM", 123);
        OrdemCompra ordemCompra2 = new OrdemCompra(peca, 10, 123);
        DAO.getEstoque().addOrdemCompra(ordemCompra2);
        assertEquals(DAO.getEstoque().verEstoque().get(peca), 20);
    }

    @Test
    void realizaOrdemCompra() {
        Peca peca = new Peca("RAM", 123);
        OrdemCompra ordemCompra = new OrdemCompra(peca, 10, 123);
        DAO.getEstoque().addOrdemCompra(ordemCompra);
        assertEquals(true, DAO.getEstoque().verDisponibilidadeDePeca(peca.getNome()));
    }

    @Test
    void main() {
    }
}