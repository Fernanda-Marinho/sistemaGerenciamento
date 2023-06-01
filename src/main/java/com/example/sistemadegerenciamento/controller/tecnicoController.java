package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.HelloApplication;
import com.example.sistemadegerenciamento.models.Cliente;
import com.example.sistemadegerenciamento.models.Tecnico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

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
    private Button btnSceneOrdens;

    @FXML
    private Button btnSceneHome;

    @FXML
    private Button btnSceneTecnicos;

    @FXML
    private Label labelErro;

    @FXML
    private TextField senhaTecnico;

    @FXML
    private TableView<Tecnico> tabelaTecnico;

    @FXML
    private TextField userTecnico;

    @FXML
    private TextField userTecnicoAtual;

    private ObservableList<Tecnico> tecnicosData;


    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        DAO.getTecnico().atualizaColecaoDoArquivo(DAO.getTecnicoDAOArquivo().lerArquivo());
        this.tecnicosData = FXCollections.observableArrayList();
        this.tecnicosData.addAll(DAO.getTecnico().findManyArrayList());
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1 = new TableColumn("ID");
        TableColumn coluna2 = new TableColumn("NOME");
        TableColumn coluna3 = new TableColumn("ID ORDEM ATUAL");

        coluna1.setCellValueFactory(new PropertyValueFactory<Cliente, String>("tecnicoID"));
        coluna2.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        coluna3.setCellValueFactory(new PropertyValueFactory<Cliente, String>("idOrdemAtual"));

        this.tabelaTecnico.getColumns().addAll(coluna1, coluna2, coluna3);
        this.tabelaTecnico.setItems(tecnicosData);
    }

    @FXML
    void btnRealizaCadastroTecnico(ActionEvent event) {
        //.getText() pega o texto em String do textfield.
        if (this.userTecnicoAtual.getText().equals("admin")) {
            Tecnico tecnico = new Tecnico(false, this.userTecnico.getText(), this.senhaTecnico.getText());
            DAO.getTecnico().create(tecnico);
            this.tecnicosData.add(tecnico);
            this.userTecnicoAtual.clear();
            this.userTecnico.clear();
            this.senhaTecnico.clear();
            this.labelErro.setText("");
        } else {
            this.labelErro.setText("Apenas o administrador pode cadastrar novos usuários!");
        }
    }

    @FXML
    void btnEditaTecnico(ActionEvent event) {
        //.getSelectionModel().getSelectedIndex() pega o índice do item selecionado da tabela.
        int selecionadoTabelaIndice = this.tabelaTecnico.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaIndice>=0 && (this.userTecnicoAtual.getText() == "admin")) {
            Tecnico selecionadoTabela = this.tabelaTecnico.getSelectionModel().getSelectedItem();
            int tecnicoID = selecionadoTabela.getTecnicoID();
            //.getText() pega o texto em String do textfield.
            DAO.getTecnico().update(tecnicoID, this.userTecnico.getText(), this.senhaTecnico.getText());
            this.tecnicosData.set(selecionadoTabelaIndice, DAO.getTecnico().findById(tecnicoID));
            //Para limpar o conteúdo do textfield.
            this.userTecnicoAtual.clear();
            this.userTecnico.clear();
            this.senhaTecnico.clear();
            this.labelErro.setText("");
        } else {
            this.labelErro.setText("Somente o administrador pode atualizar os técnicos.");
        }
    }

    @FXML
    void btnRemoveTecnico(ActionEvent event) throws Exception {
        //.getSelectionModel().getSelectedIndex() pega o índice do item selecionado da tabela.
        int selecionadoTabelaIndice = this.tabelaTecnico.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaIndice>=0 && (this.userTecnicoAtual.getText() == "admin")) {
            Tecnico selecionadoTabela = this.tabelaTecnico.getSelectionModel().getSelectedItem();
            int tecnicoID = selecionadoTabela.getTecnicoID();
            DAO.getTecnico().delete(tecnicoID);
            this.tecnicosData.remove(selecionadoTabelaIndice);
            this.labelErro.setText("");
        } else {
            this.labelErro.setText("Somente o administrador pode deletar os técnicos.");
        }
    }

    @FXML
    void btnSalvaDados(ActionEvent event) throws IOException {
        DAO.getTecnicoDAOArquivo().salvarArquivo();
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
