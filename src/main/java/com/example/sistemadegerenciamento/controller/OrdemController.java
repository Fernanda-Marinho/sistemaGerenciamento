package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.HelloApplication;
import com.example.sistemadegerenciamento.models.Cliente;
import com.example.sistemadegerenciamento.models.Ordem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class OrdemController {

    @FXML
    private Button btnCadastrarOrdem;

    @FXML
    private Button btnAbrirOrdem;

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

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        //Em Aberto
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1EmAberto = new TableColumn("ID");
        TableColumn coluna2EmAberto = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3EmAberto = new TableColumn("SERVIÇOS");

        coluna1EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensAbertas.getColumns().addAll(coluna1EmAberto, coluna2EmAberto, coluna3EmAberto);
        this.tabelaOrdensAbertas.setItems(ObservableLists.ordensEmAbertoData);

        //Em espera
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1EmEspera = new TableColumn("ID");
        TableColumn coluna2EmEspera = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3EmEspera = new TableColumn("SERVIÇOS");

        coluna1EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensEspera.getColumns().addAll(coluna1EmEspera, coluna2EmEspera, coluna3EmEspera);
        this.tabelaOrdensEspera.setItems(ObservableLists.ordensEmEsperaData);

        //Canceladas
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1Canceladas = new TableColumn("ID");
        TableColumn coluna2Canceladas = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3Canceladas = new TableColumn("SERVIÇOS");

        coluna1Canceladas.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2Canceladas.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3Canceladas.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensCanceladas.getColumns().addAll(coluna1Canceladas, coluna2Canceladas, coluna3Canceladas);
        this.tabelaOrdensCanceladas.setItems(ObservableLists.ordensCanceladasData);

        //Finalizadas
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1Finalizadas = new TableColumn("ID");
        TableColumn coluna2Finalizadas = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3Finalizadas = new TableColumn("SERVIÇOS");

        coluna1Finalizadas.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2Finalizadas.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3Finalizadas.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensFinalizadas.getColumns().addAll(coluna1Finalizadas, coluna2Finalizadas, coluna3Finalizadas);
        this.tabelaOrdensFinalizadas.setItems(ObservableLists.ordensFinalizadasData);
    }

    @FXML
    void btnCadastraOrdem(ActionEvent event) {
        try {
            int id = Integer.parseInt(this.idCliente.getText());
            Cliente cliente = DAO.getCliente().findById(id);
            Ordem ordem = new Ordem(cliente);
            DAO.getOrdem().create(ordem);
            ObservableLists.ordensEmEsperaData.add(ordem);
            //Para limpar o conteúdo do textfield.
            this.idCliente.clear();
            this.labelErro.setText("");
        } catch (Exception e){
            this.labelErro.setText("Erro ao encontrar cliente. Digite um id válido.");
        }
    }

    @FXML
    void btnSalvaDados(ActionEvent event) throws IOException {
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmAberto();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmEspera();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensFinalizadas();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensCanceladas();

    }

    @FXML
    void btnAbreOrdem(ActionEvent event) throws IOException {
        int selecionadoTabelaEmEsperaIndice = this.tabelaOrdensEspera.getSelectionModel().getSelectedIndex();
        int selecionadoTabelaEmAbertoIndice = this.tabelaOrdensAbertas.getSelectionModel().getSelectedIndex();
        int selecionadoTabelaCanceladaIndice = this.tabelaOrdensCanceladas.getSelectionModel().getSelectedIndex();
        int selecionadoTabelaFinalizadaIndice = this.tabelaOrdensFinalizadas.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaEmAbertoIndice>=0) {
            Ordem selecionadoTabela = this.tabelaOrdensAbertas.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            this.labelErro.setText("");
            HelloApplication.telaScreen("servicosDialog");
        } else if (selecionadoTabelaEmEsperaIndice>=0){
            Ordem selecionadoTabela = this.tabelaOrdensEspera.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            this.labelErro.setText("");
            HelloApplication.telaScreen("servicosDialog");
        } else if (selecionadoTabelaCanceladaIndice>=0){
            Ordem selecionadoTabela = this.tabelaOrdensCanceladas.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            this.labelErro.setText("");
            HelloApplication.telaScreen("servicosDialog");
        } else if (selecionadoTabelaFinalizadaIndice>=0){
            Ordem selecionadoTabela = this.tabelaOrdensFinalizadas.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            this.labelErro.setText("");
            HelloApplication.telaScreen("servicosDialog");
        } else {
            this.labelErro.setText("Selecione uma ordem das tabelas abaixo.");
        }
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
        System.exit(0);
    }

}
