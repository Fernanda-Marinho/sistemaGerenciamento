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

public class InicialController {

    @FXML
    private Button btnAbrirOrdem;

    @FXML
    private Button btnCriarOrdemDeServico;

    @FXML
    private Button btnOrdemDeCompra;

    @FXML
    private Button btnPegarOrdemServico;

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
    private TextField idTecnico;
    @FXML
    private TableView<Ordem> tabelaOrdensEmAberto;
    @FXML
    private TableView<Ordem> tabelaOrdensEmEspera;

    private ObservableList<Ordem> ordensEmAbertoData;

    private ObservableList<Ordem> ordensEmEsperaData;

    void atualizaOrdens() throws IOException, ClassNotFoundException {
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

        this.tabelaOrdensEmAberto.getColumns().addAll(coluna1EmAberto, coluna2EmAberto, coluna3EmAberto);
        this.tabelaOrdensEmAberto.setItems(ordensEmAbertoData);

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

        this.tabelaOrdensEmEspera.getColumns().addAll(coluna1EmEspera, coluna2EmEspera, coluna3EmEspera);
        this.tabelaOrdensEmEspera.setItems(ordensEmEsperaData);
    }
    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        atualizaOrdens();
    }

    @FXML
    void btnCriaOrdemDeServico(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("ordens");

    }

    @FXML
    void btnFazOrdemDeCompra(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("estoque");

    }

    @FXML
    void btnPegaOrdemServico(ActionEvent event) {
        int selecionadoTabelaIndice = this.tabelaOrdensEmEspera.getSelectionModel().getSelectedIndex();
        try {
            if (selecionadoTabelaIndice>=0) {
                int tecnicoID = Integer.parseInt(this.idTecnico.getText());
                Ordem selecionadoTabela = this.tabelaOrdensEmEspera.getSelectionModel().getSelectedItem();
                if (!(DAO.getTecnico().findById(tecnicoID).isComOrdem())) {
                    DAO.getOrdem().abrirOrdem(selecionadoTabela.getOrdemID(), tecnicoID);
                    DAO.getTecnico().findById(tecnicoID).addOrdem(selecionadoTabela);
                    this.idTecnico.clear();
                    this.labelErro.setText("");
                    this.ordensEmEsperaData.remove(selecionadoTabelaIndice);
                    this.ordensEmAbertoData.add(selecionadoTabela);
                } else {
                    this.labelErro.setText("Você já está associado a uma ordem. Finalize primeiro.");
                }
            }
        } catch (Exception e){
            this.labelErro.setText("Insira um ID válido e existente.");
        }
    }

    @FXML
    void btnSalvaDados(ActionEvent event) throws IOException {
        System.out.println("salvando dados");
        DAO.getClienteDAOArquivo().salvarArquivo();
        DAO.getEstoqueDAOArquivo().salvarArquivo();
        DAO.getTecnicoDAOArquivo().salvarArquivo();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensCanceladas();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmAberto();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmEspera();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensFinalizadas();
    }

    void btnSalvaDados() throws IOException {
        DAO.getClienteDAOArquivo().salvarArquivo();
        DAO.getEstoqueDAOArquivo().salvarArquivo();
        DAO.getTecnicoDAOArquivo().salvarArquivo();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensCanceladas();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmAberto();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmEspera();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensFinalizadas();
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
    void btnAbreOrdem(ActionEvent event) throws IOException {
        int selecionadoTabelaEmEsperaIndice = this.tabelaOrdensEmEspera.getSelectionModel().getSelectedIndex();
        int selecionadoTabelaEmAbertoIndice = this.tabelaOrdensEmAberto.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaEmAbertoIndice>=0) {
            Ordem selecionadoTabela = this.tabelaOrdensEmAberto.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            HelloApplication.telaScreen("servicosDialog");
        } else if (selecionadoTabelaEmEsperaIndice>=0){
            Ordem selecionadoTabela = this.tabelaOrdensEmEspera.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            HelloApplication.telaScreen("servicosDialog");
        }
    }
    @FXML
    void btnClose() {
        System.exit(0);
    }
}
