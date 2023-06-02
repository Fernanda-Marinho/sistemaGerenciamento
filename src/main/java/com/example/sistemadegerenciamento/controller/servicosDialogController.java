package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Cliente;
import com.example.sistemadegerenciamento.models.Ordem;
import com.example.sistemadegerenciamento.models.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class servicosDialogController {

    @FXML
    private Button btnCancelarOrdem;

    @FXML
    private Button btnFInalizarOrdem;

    @FXML
    private Button btnFecharServico;

    @FXML
    private Button btnFinalizarServico;

    @FXML
    private Label labelErro;

    @FXML
    private TableView<Servico> tabelaServicos;
    public static Ordem ordemAberta;
    private ObservableList<Servico> servicosData;

    //FALTA ADICIONAR OS ATRIBUTOS PARA CRIAR A TABELA. VERIFICAR SE O MÉTODO setCellValueFactory CONSEGUE ACEITAR OUTROS DADOS ALÉM DO ATRIBUTO DO OBJETO

    /*@FXML
        //Carrega todos os dados a serem mostrados no View.
    void initialize() throws IOException, ClassNotFoundException {
        this.servicosData = FXCollections.observableArrayList();
        this.servicosData.addAll(ordemAberta.getServicos());
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1 = new TableColumn("ID");
        TableColumn coluna2 = new TableColumn("NOME");
        TableColumn coluna3 = new TableColumn("ENDEREÇO");
        TableColumn coluna4 = new TableColumn("TELEFONE");


        coluna1.setCellValueFactory(new PropertyValueFactory<Cliente, String>(ordemAberta.));
        coluna2.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        coluna3.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        coluna4.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        this.tabelaCliente.getColumns().addAll(coluna1, coluna2, coluna3, coluna4);
        this.tabelaCliente.setItems(clientesData);
    }*/

    @FXML
    void btnCancelaOrdem(ActionEvent event) {

    }

    @FXML
    void btnFechaServico(ActionEvent event) {

    }

    @FXML
    void btnFinalizaOrdem(ActionEvent event) {

    }

    @FXML
    void btnFinalizaServico(ActionEvent event) {

    }

}
