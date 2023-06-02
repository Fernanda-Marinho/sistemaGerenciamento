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
    public static Ordem ordemAbertaNoMomento;
    private ObservableList<Servico> servicosData;

    //RAFA, AQUI ESTÁ O INITIALIZE. MEU INTERESSE É QUE A TABELA SÓ SEJA EXIBIDA DEPOIS QUE UMA ORDEM
    // DA PÁGINA INICIAL FOR SELECIONADA. OU SEJA, SÓ QUERO QUE SEJA EXIBIDA QUANDO O ATRIBUTO ESTÁTICO
    // ordemAbertaNoMomento for diferente de nulo, pois irei exibir na tabela dados retirados da Ordem
    // que estará nesse atributo.
    
    /*@FXML
        //Carrega todos os dados a serem mostrados no View.
    void initialize() throws IOException, ClassNotFoundException {
        System.out.println("3) initialize");
        if (ordemAbertaNoMomento != null) {
            this.servicosData = FXCollections.observableArrayList();
            this.servicosData.addAll(ordemAbertaNoMomento.getServicos());

            //Cria a coluna para usar na tabela, de maneira manual.
            TableColumn coluna1 = new TableColumn("CATEGORIA");
            TableColumn coluna2 = new TableColumn("NOME (PEÇA)");
            TableColumn coluna3 = new TableColumn("ESTÁ FINALIZADO");
            TableColumn coluna4 = new TableColumn("VALOR");


            coluna1.setCellValueFactory(new PropertyValueFactory<Servico, String>("categoriaEmString"));
            coluna2.setCellValueFactory(new PropertyValueFactory<Servico, String>("nomePeca"));
            coluna3.setCellValueFactory(new PropertyValueFactory<Servico, Boolean>("finalizado"));
            coluna4.setCellValueFactory(new PropertyValueFactory<Servico, Double>("valor"));

            this.tabelaServicos.getColumns().addAll(coluna1, coluna2, coluna3, coluna4);
            this.tabelaServicos.setItems(servicosData);
        }
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
