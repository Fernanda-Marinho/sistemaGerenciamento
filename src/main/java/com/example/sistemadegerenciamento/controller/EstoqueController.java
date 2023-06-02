package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.DAO.estoque.EstoqueDAOImplementacao;
import com.example.sistemadegerenciamento.HelloApplication;
import com.example.sistemadegerenciamento.models.Cliente;
import com.example.sistemadegerenciamento.models.OrdemCompra;
import com.example.sistemadegerenciamento.models.Peca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class EstoqueController {

    @FXML
    private Button btnExportarEstoque;
    @FXML
    private Button btnRealizarOrdemCompra;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnSceneClientes;

    @FXML
    private Button btnSceneEstoque;

    @FXML
    private Button btnSceneHome;

    @FXML
    private Button btnSceneTecnicos;

    @FXML
    private Label labelErro;

    @FXML
    private TextField nomePeca;

    @FXML
    private TextField quantidadePeca;
    @FXML
    private TableView<Peca> tabelaEstoque;
    @FXML
    private TextField valorPeca;
    private ObservableList<Peca> pecasData;

    @FXML
        //Carrega todos os dados a serem mostrados no View.
    void initialize() throws IOException, ClassNotFoundException {
        DAO.getEstoque().atualizaColecaoDoArquivo(DAO.getEstoqueDAOArquivo().lerArquivo());
        this.pecasData = FXCollections.observableArrayList();
        this.pecasData.addAll(DAO.getEstoque().findManyPecas());
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1 = new TableColumn("NOME PEÇA");
        TableColumn coluna2 = new TableColumn("QUANTIDADE");

        coluna1.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        coluna2.setCellValueFactory(new PropertyValueFactory<Cliente, String>("quantidade"));

        this.tabelaEstoque.getColumns().addAll(coluna1, coluna2);
        this.tabelaEstoque.setItems(pecasData);
    }

    @FXML
    void btnExportaEstoque(ActionEvent event) {

    }
    @FXML
    void btnRealizaOrdemCompra(ActionEvent event) {
        try {
            //.getText() pega o texto em String do textfield.
            Peca peca = new Peca(this.nomePeca.getText(), Double.parseDouble(this.valorPeca.getText()));
            OrdemCompra ordemCompra = new OrdemCompra(peca, Integer.parseInt(this.quantidadePeca.getText()), Double.parseDouble(this.valorPeca.getText()));
            DAO.getEstoque().addOrdemCompra(ordemCompra);
            this.pecasData.add(peca);
            //Para limpar o conteúdo do textfield.
            this.nomePeca.clear();
            this.valorPeca.clear();
            this.quantidadePeca.clear();
            this.labelErro.setText("");
        } catch (Exception e){
            //O setText no label carrega uma String na interface.
            this.labelErro.setText("Erro ao digitar os dados.");
        }
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
