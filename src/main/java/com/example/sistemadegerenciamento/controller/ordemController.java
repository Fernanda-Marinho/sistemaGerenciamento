package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.HelloApplication;
import com.example.sistemadegerenciamento.models.Ordem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ordemController {

    @FXML
    private Button btnCadastrarOrdem;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnSceneClientes;

    @FXML
    private Button btnSceneEstoque;

    @FXML
    private Button btnSceneHome;

    @FXML
    private Button btnSceneOrdens;

    @FXML
    private Button btnSceneTecnicos;

    @FXML
    private TextField idCliente;

    @FXML
    private Label labelErro;

    @FXML
    private TableView<Ordem> tabelaOrdensAbertas;

    @FXML
    private TableView<Ordem> tabelaOrdensCanceladas;

    @FXML
    private TableView<Ordem> tabelaOrdensEspera;

    @FXML
    private TableView<Ordem> tabelaOrdensFinalizadas;

    private ObservableList<Ordem> ordensEmAbertoData;

    private ObservableList<Ordem> ordensEmEsperaData;

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        //Em Aberto
        DAO.getOrdem().atualizaColecaoDoArquivoOrdensAbertas(DAO.getOrdemDAOArquivo().lerArquivoOrdensEmAberto());

        this.ordensEmAbertoData = FXCollections.observableArrayList();
        this.ordensEmAbertoData.addAll(DAO.getOrdem().findManyEmAberto());

        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1EmAberto = new TableColumn("ID");
        TableColumn coluna2EmAberto = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3EmAberto = new TableColumn("SERVIÇOS");

        coluna1EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensAbertas.getColumns().addAll(coluna1EmAberto, coluna2EmAberto, coluna3EmAberto);
        this.tabelaOrdensAbertas.setItems(ordensEmAbertoData);

        //Em espera
        DAO.getOrdem().atualizaColecaoDoArquivoOrdensEmEspera(DAO.getOrdemDAOArquivo().lerArquivoOrdensEmEspera());

        this.ordensEmEsperaData = FXCollections.observableArrayList();
        this.ordensEmEsperaData.addAll(DAO.getOrdem().findManyEmEspera());

        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1EmEspera = new TableColumn("ID");
        TableColumn coluna2EmEspera = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3EmEspera = new TableColumn("SERVIÇOS");

        coluna1EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensEspera.getColumns().addAll(coluna1EmEspera, coluna2EmEspera, coluna3EmEspera);
        this.tabelaOrdensEspera.setItems(ordensEmEsperaData);
    }

    @FXML
    void btnCadastraOrdem(ActionEvent event) {

    }

    @FXML
    void btnSalvaDados(ActionEvent event) {

    }

    @FXML
    void btnSceneClientesAction(ActionEvent event) {
        HelloApplication.telaScreen("cliente");
    }

    @FXML
    void btnSceneEstoqueAction(ActionEvent event) {
        HelloApplication.telaScreen("estoque");

    }

    @FXML
    void btnSceneHomeAction(ActionEvent event) {
        HelloApplication.telaScreen("inicial");
    }

    @FXML
    void btnSceneTecnicosAction(ActionEvent event) {
        HelloApplication.telaScreen("tecnico");

    }
    @FXML
    void btnSceneOrdensAction(ActionEvent event) {
        HelloApplication.telaScreen("ordens");
    }

}
