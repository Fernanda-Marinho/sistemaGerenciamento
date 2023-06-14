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
import javafx.scene.input.MouseEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

public class InicialController {

    @FXML
    private Button btnAbrirOrdem;

    @FXML
    private Button btnCriarOrdemDeServico;

    @FXML
    private Button btnOrdemDeCompra;

    @FXML
    private Button btnGerarRelatorio;

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
    private Label labelVerMais;
    @FXML
    private Label labelQntdOrdensAbertas;
    @FXML
    private Label labelAlertaEstoque;
    @FXML
    private Label labelQntdOrdensEmEspera;
    @FXML
    private TextField idTecnico;
    @FXML
    private TableView<Ordem> tabelaOrdensEmAberto;
    @FXML
    private TableView<Ordem> tabelaOrdensEmEspera;
    @FXML
    private Label labelDate;

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        TimeNow.timeNow(labelDate);
        //Em Aberto
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1EmAberto = new TableColumn("ID");
        TableColumn coluna2EmAberto = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3EmAberto = new TableColumn("SERVIÇOS");

        coluna1EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3EmAberto.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensEmAberto.getColumns().addAll(coluna1EmAberto, coluna2EmAberto, coluna3EmAberto);
        this.tabelaOrdensEmAberto.setItems(ObservableLists.ordensEmAbertoData);

        //Em espera
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1EmEspera = new TableColumn("ID");
        TableColumn coluna2EmEspera = new TableColumn("NOME DO CLIENTE");
        TableColumn coluna3EmEspera = new TableColumn("SERVIÇOS");

        coluna1EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("ordemID"));
        coluna2EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("nomeCliente"));
        coluna3EmEspera.setCellValueFactory(new PropertyValueFactory<Ordem, String>("servicosEmString"));

        this.tabelaOrdensEmEspera.getColumns().addAll(coluna1EmEspera, coluna2EmEspera, coluna3EmEspera);
        this.tabelaOrdensEmEspera.setItems(ObservableLists.ordensEmEsperaData);

        this.labelQntdOrdensEmEspera.setText(String.valueOf(ObservableLists.ordensEmEsperaData.size()));
        this.labelQntdOrdensAbertas.setText(String.valueOf(ObservableLists.ordensEmAbertoData.size()));

    }

    @FXML
    void btnPegaOrdemServico(ActionEvent event) {
        try {
            int tecnicoID = Integer.parseInt(this.idTecnico.getText());
            //Pega a ordem da fila
            Ordem selecionadoTabela = ObservableLists.ordensEmEsperaData.get(0);
            if (!(DAO.getTecnico().findById(tecnicoID).isComOrdem())) {
                DAO.getOrdem().abrirOrdem(selecionadoTabela.getOrdemID(), tecnicoID);
                DAO.getTecnico().findById(tecnicoID).addOrdem(selecionadoTabela);
                ObservableLists.ordensEmEsperaData.remove(0);
                ObservableLists.ordensEmAbertoData.add(selecionadoTabela);
                this.idTecnico.clear();
                this.labelErro.setText("");
                this.labelQntdOrdensEmEspera.setText(String.valueOf(ObservableLists.ordensEmEsperaData.size()));
                this.labelQntdOrdensAbertas.setText(String.valueOf(ObservableLists.ordensEmAbertoData.size()));
            } else {
                this.labelErro.setText("Você já está associado a uma ordem. Finalize primeiro.");
            }
        } catch (Exception e){
            this.labelErro.setText("Insira um ID válido e existente.");
        }
    }

    @FXML
    void btnSalvaDados(ActionEvent event) throws IOException {
        SaveData.saveAllData();
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
    //Se eu abrir a ordem em aberto, ele sempre será registrado como aberto na ordem de precedência.
    void btnAbreOrdem(ActionEvent event) throws IOException {
        int selecionadoTabelaEmEsperaIndice = this.tabelaOrdensEmEspera.getSelectionModel().getSelectedIndex();
        int selecionadoTabelaEmAbertoIndice = this.tabelaOrdensEmAberto.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaEmAbertoIndice>=0) {
            Ordem selecionadoTabela = this.tabelaOrdensEmAberto.getSelectionModel().getSelectedItem();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            HelloApplication.telaScreen("servicosDialog");
        } else if (selecionadoTabelaEmEsperaIndice>=0){
            Ordem selecionadoTabela = this.tabelaOrdensEmEspera.getSelectionModel().getSelectedItem();
            ServicosDialogController.ordemAbertaNoMomento = selecionadoTabela;
            HelloApplication.telaScreen("servicosDialog");
        }
        this.labelQntdOrdensEmEspera.setText(String.valueOf(ObservableLists.ordensEmEsperaData.size()));
        this.labelQntdOrdensAbertas.setText(String.valueOf(ObservableLists.ordensEmAbertoData.size()));
        this.tabelaOrdensEmEspera.getSelectionModel().clearSelection();
        this.tabelaOrdensEmAberto.getSelectionModel().clearSelection();
    }

    @FXML
    void btnGeraRelatorio(ActionEvent event) {
        String relatorio = "Tempo médio de espera de ordens finalizadas: " + DAO.getOrdem().gerarTempoMedioDeOrdensFinalizadas() + "mins;\n";
        relatorio = relatorio + "Custo total de peças nas ordens de compras: R$" + DAO.getEstoque().gerarCustoTotalOrdensCompra() + ";\n";
        relatorio = relatorio + "Estoque atual:\n" + DAO.getEstoque().verEstoqueFormatado();
        relatorio = relatorio + DAO.getOrdem().gerarMediaSatisfacaoPorOrdem();
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        Date date = new Date();
        String dateModified = date.toString().replace(" ", "_");
        dateModified = dateModified.replace(":", "_");
        String nomeArquivo = diretorioAtual + "\\relatorios\\relatorio_" + dateModified + ".txt";
        File arquivo = new File(nomeArquivo);
        try {
            //Salva arquivo
            arquivo.createNewFile();
            FileWriter fw = new FileWriter( arquivo );
            BufferedWriter bw = new BufferedWriter( fw );
            bw.write(relatorio);
            bw.close();
            fw.close();
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("cmd.exe", "/c", nomeArquivo);
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void verMais(MouseEvent event) throws IOException {
        HelloApplication.telaScreen("estoque");
    }

    public Label getLabelQntdOrdensAbertas(){
        return labelQntdOrdensAbertas;
    }
    public Label getLabelQntdOrdensEmEspera() {
        return labelQntdOrdensEmEspera;
    }

    @FXML
    void btnClose() throws IOException {
        SaveData.saveAllData();
        TimeNow.stop = true;
        System.exit(0);
    }
}
