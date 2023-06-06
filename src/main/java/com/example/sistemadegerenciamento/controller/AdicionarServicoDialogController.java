package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.HelloApplication;
import com.example.sistemadegerenciamento.models.CategoriaServico;
import com.example.sistemadegerenciamento.models.Peca;
import com.example.sistemadegerenciamento.models.Servico;
import com.example.sistemadegerenciamento.models.StatusOrdem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class AdicionarServicoDialogController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private ComboBox<String> categoria;

    @FXML
    private TextField descricao;

    @FXML
    private Label labelErro;

    @FXML
    private TextField nomePeca;

    @FXML
    private TextField valor;
    private ObservableList<String> categoriasData;

    @FXML
    void initialize() {
        ArrayList<String> listaCategorias = new ArrayList<>();
        listaCategorias.add("FORMATACAO");
        listaCategorias.add("LIMPEZA");
        listaCategorias.add("MONTAGEM");
        listaCategorias.add("MANUTENCAO");
        categoriasData = FXCollections.observableArrayList(listaCategorias);
        categoria.setItems(categoriasData);
        //Finalizar essa parte!
    }

    //Erro quando adiciona um serviço: todas as ordens são atualizadas com os serviços da ordem que foi adicionado o serviço.
    @FXML
    void btnAdiciona(ActionEvent event) throws Exception {
        try {
            String categoriaAtual = this.categoria.getSelectionModel().getSelectedItem();
            if (categoriaAtual.equals("MONTAGEM")) {
                Peca peca = new Peca(this.nomePeca.getText(), Double.parseDouble(this.valor.getText()));
                Servico servico = new Servico(CategoriaServico.MONTAGEM, Double.parseDouble(this.valor.getText()),
                        ServicosDialogController.ordemAbertaNoMomento.getOrdemID(), peca, this.descricao.getText());
                if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ABERTA){
                    DAO.getOrdem().findByIdAberta(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                } else if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ESPERA){
                    DAO.getOrdem().findById(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                }
                ObservableLists.servicosData.add(servico);
            } else if (categoriaAtual.equals("LIMPEZA")) {
                Servico servico = new Servico(CategoriaServico.LIMPEZA, Double.parseDouble(this.valor.getText()),
                        ServicosDialogController.ordemAbertaNoMomento.getOrdemID(), null, this.descricao.getText());
                if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ABERTA){
                    DAO.getOrdem().findByIdAberta(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                } else if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ESPERA){
                    DAO.getOrdem().findById(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                }
                ObservableLists.servicosData.add(servico);
            } else if (categoriaAtual.equals("FORMATACAO")) {
                Servico servico = new Servico(CategoriaServico.FORMATACAO, Double.parseDouble(this.valor.getText()),
                        ServicosDialogController.ordemAbertaNoMomento.getOrdemID(), null, this.descricao.getText());
                if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ABERTA){
                    DAO.getOrdem().findByIdAberta(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                } else if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ESPERA){
                    DAO.getOrdem().findById(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                }
                ObservableLists.servicosData.add(servico);
            } else if (categoriaAtual.equals("MANUTENCAO")) {
                Servico servico = new Servico(CategoriaServico.FORMATACAO, Double.parseDouble(this.valor.getText()),
                        ServicosDialogController.ordemAbertaNoMomento.getOrdemID(), null, this.descricao.getText());
                if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ABERTA){
                    DAO.getOrdem().findByIdAberta(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                } else if (ServicosDialogController.ordemAbertaNoMomento.getStatus() == StatusOrdem.ESPERA){
                    DAO.getOrdem().findById(ServicosDialogController.ordemAbertaNoMomento.getOrdemID()).addServico(servico);
                }
                ObservableLists.servicosData.add(servico);
            }
            ObservableLists.pecasData.clear();
            ObservableLists.pecasData.addAll(DAO.getEstoque().findManyPecas());
            ObservableLists.ordensEmAbertoData.clear();
            ObservableLists.ordensEmEsperaData.clear();
            ObservableLists.ordensEmAbertoData.addAll(DAO.getOrdem().findManyEmAberto());
            ObservableLists.ordensEmEsperaData.addAll(DAO.getOrdem().findManyEmEspera());
            labelErro.setText("Serviço adicionado com sucesso.");
        } catch (Exception e) {
            labelErro.setText(e.toString());
        }
    }
}
