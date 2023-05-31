package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class estoqueController {

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
    private TableView<?> tabelaEstoque;

    @FXML
    private TextField valorPeca;

    @FXML
    void btnRealizaOrdemCompra(ActionEvent event) {

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
