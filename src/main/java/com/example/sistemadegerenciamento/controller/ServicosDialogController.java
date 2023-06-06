package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.HelloApplication;
import com.example.sistemadegerenciamento.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import  java.io.FileWriter;

import java.io.BufferedWriter;
import java.io.File;

import java.io.IOException;
import java.nio.file.Paths;

public class ServicosDialogController {

    @FXML
    private Button btnCancelarOrdem;

    @FXML
    private Button btnFinalizarOrdem;

    @FXML
    private Button btnFinalizarServico;

    @FXML
    private Button btnAdicionarServico;

    @FXML
    private Label labelErro;

    @FXML
    private TableView<Servico> tabelaServicos;
    public static Ordem ordemAbertaNoMomento;


    @FXML
        //Carrega todos os dados a serem mostrados no View.
    void initialize() throws IOException, ClassNotFoundException {
        if (ordemAbertaNoMomento != null) {
            ObservableLists.servicosData = FXCollections.observableArrayList();
            ObservableLists.servicosData.addAll(ordemAbertaNoMomento.getServicos());

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
            this.tabelaServicos.setItems(ObservableLists.servicosData);
        }
    }

    @FXML
    void btnCancelaOrdem(ActionEvent event) {
        if (ordemAbertaNoMomento.getStatus() == StatusOrdem.ABERTA || ordemAbertaNoMomento.getStatus() == StatusOrdem.ESPERA){
            Ordem ordem = DAO.getOrdem().cancelarOrdem(ordemAbertaNoMomento.getOrdemID());
            if (ordem != null){
                if (ordem.getStatus() == StatusOrdem.ABERTA){
                    DAO.getTecnico().findById(ordem.getTecnicoID()).fechaOrdem();
                    ObservableLists.ordensEmAbertoData.remove(ordem);
                } else {
                    ObservableLists.ordensEmEsperaData.remove(ordem);
                }
                ordem.setStatus(StatusOrdem.CANCELADA);
                ObservableLists.ordensCanceladasData.add(ordem);
                this.labelErro.setText("");
            } else {
                this.labelErro.setText("Houve um erro.");
            }
        } else {
            this.labelErro.setText("Para ser cancelada, precisa estar aberta ou em espera.");
        }
    }
    @FXML
    void btnFinalizaOrdem(ActionEvent event) {
        if (ordemAbertaNoMomento.getStatus() == StatusOrdem.ABERTA){
            Ordem ordem = DAO.getOrdem().finalizarOrdem(ordemAbertaNoMomento.getOrdemID());
            DAO.getTecnico().findById(ordem.getTecnicoID()).fechaOrdem();
            ordem.setStatus(StatusOrdem.FINALIZADA);
            ObservableLists.ordensFinalizadasData.add(ordem);
            ObservableLists.ordensEmAbertoData.remove(ordem);
            //Gerando fatura
            String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
            String nomeArquivo = diretorioAtual + "\\faturas\\fatura" + "Ordem" + String.valueOf(ordem.getOrdemID()) + ".txt";
            File arquivo = new File(nomeArquivo);
            try {
                //Salva arquivo
                arquivo.createNewFile();
                FileWriter fw = new FileWriter( arquivo );
                BufferedWriter bw = new BufferedWriter( fw );
                bw.write(ordem.gerarFatura().toString());
                bw.close();
                fw.close();
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command("cmd.exe", "/c", nomeArquivo);
                processBuilder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            labelErro.setText("Para a ordem ser finalizada, precisa estar aberta.");
        }

    }

    @FXML
    void btnFinalizaServico(ActionEvent event) {
        int selecionadoTabelaIndice = this.tabelaServicos.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaIndice>=0) {
            Servico selecionadoTabela = this.tabelaServicos.getSelectionModel().getSelectedItem();
            if (ordemAbertaNoMomento.getStatus() == StatusOrdem.ESPERA){
                DAO.getOrdem().findById(ordemAbertaNoMomento.getOrdemID()).finalizarServico(selecionadoTabela, 0);
            } else if (ordemAbertaNoMomento.getStatus() == StatusOrdem.ABERTA){
                ObservableLists.servicosData.remove(selecionadoTabela);
            }
            this.labelErro.setText("");
        }
    }

    @FXML
    void btnAdicionaServico(ActionEvent event) throws IOException {
        HelloApplication.telaScreen("adicionarServicoDialogController");
    }
}