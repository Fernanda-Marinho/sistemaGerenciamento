package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.HelloApplication;
import com.example.sistemadegerenciamento.models.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ClienteController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField endereco;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TableView<Cliente> tabelaCliente;

    @FXML
    private TextField telefone;

    @FXML
    private Label labelErro;
    @FXML
    private Label labelDate;


    @FXML
    //Carrega todos os dados a serem mostrados no View.
    void initialize() throws IOException, ClassNotFoundException {
        TimeNow.timeNow(labelDate);

        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1 = new TableColumn("ID");
        TableColumn coluna2 = new TableColumn("NOME");
        TableColumn coluna3 = new TableColumn("ENDEREÇO");
        TableColumn coluna4 = new TableColumn("TELEFONE");

        coluna1.setCellValueFactory(new PropertyValueFactory<Cliente, String>("clienteID"));
        coluna2.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        coluna3.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        coluna4.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        this.tabelaCliente.getColumns().addAll(coluna1, coluna2, coluna3, coluna4);
        this.tabelaCliente.setItems(ObservableLists.clientesData);
    }

    @FXML
    void btnAdiciona(ActionEvent event) {
        try {
            //.getText() pega o texto em String do textfield.
            Cliente cliente = new Cliente(this.nomeCliente.getText(), this.endereco.getText(), this.telefone.getText());
            DAO.getCliente().create(cliente);
            ObservableLists.clientesData.add(cliente);
            //Para limpar o conteúdo do textfield.
            this.nomeCliente.clear();
            this.endereco.clear();
            this.telefone.clear();
            this.labelErro.setText("");
        } catch (Exception e){
            //O setText no label carrega uma String na interface.
            this.labelErro.setText("Erro ao digitar os dados.");
        }
    }

    @FXML
    void btnAltera(ActionEvent event) {
        try {
            //.getSelectionModel().getSelectedIndex() pega o índice do item selecionado da tabela.
            int selecionadoTabelaIndice = this.tabelaCliente.getSelectionModel().getSelectedIndex();

            if (selecionadoTabelaIndice>=0) {
                Cliente selecionadoTabela = this.tabelaCliente.getSelectionModel().getSelectedItem();

                int clienteID = selecionadoTabela.getClienteID();
                //.getText() pega o texto em String do textfield.
                DAO.getCliente().update(clienteID, this.nomeCliente.getText(), this.endereco.getText(), this.telefone.getText());
                ObservableLists.clientesData.set(selecionadoTabelaIndice, DAO.getCliente().findById(clienteID));
                //Para limpar o conteúdo do textfield.
                this.nomeCliente.clear();
                this.endereco.clear();
                this.telefone.clear();
                this.labelErro.setText("");
            }
        } catch (Exception e){
            //O setText no label carrega uma String na interface.
            this.labelErro.setText("Erro ao digitar os dados.");
        }
    }

    @FXML
    void btnExclui(ActionEvent event) throws Exception {
        //.getSelectionModel().getSelectedIndex() pega o índice do item selecionado da tabela.
        int selecionadoTabelaIndice = this.tabelaCliente.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaIndice>=0) {
            Cliente selecionadoTabela = this.tabelaCliente.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            DAO.getCliente().delete(clienteID);
            ObservableLists.clientesData.remove(selecionadoTabelaIndice);
        }
    }

    @FXML
    void btnSalvaDados(ActionEvent event) throws IOException {
        DAO.getClienteDAOArquivo().salvarArquivo();
    }

    @FXML
    void btnSceneClientesAction(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("cliente");
    }

    @FXML
    void btnSceneEstoqueAction(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("estoque");
    }

    @FXML
    void btnSceneHomeAction(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("inicial");
    }

    @FXML
    void btnSceneTecnicosAction(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("tecnico");
    }

    @FXML
    void btnSceneOrdensAction(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("ordens");
    }
    @FXML
    void btnClose() throws IOException {
        SaveData.saveAllData();
        TimeNow.stop = true;
        System.exit(0);
    }
}
