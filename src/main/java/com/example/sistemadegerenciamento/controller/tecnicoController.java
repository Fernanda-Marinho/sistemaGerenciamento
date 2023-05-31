package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class tecnicoController {

    @FXML
    private Button btnCadastrarTecnico;

    @FXML
    private Button btnEditarTecnico;

    @FXML
    private Button btnRemoverTecnico;

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
    private TextField senhaTecnico;

    @FXML
    private TableView<?> tabelaTecnico;

    @FXML
    private TextField userTecnico;

    @FXML
    private TextField userTecnicoAtual;

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
