package com.example.sistemadegerenciamento;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.controller.MainController;
import com.example.sistemadegerenciamento.controller.ObservableLists;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.io.IOException;
import java.nio.file.Paths;


public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene inicialScene;
    private static Scene clienteScene;
    private static Scene tecnicoScene;
    private static Scene estoqueScene;
    private static Scene ordemScene;
    private static Scene servicosDialogScene;
    private static Scene adicionarServicosDialogScene;

    public void atualizaColecoesDosArquivosDAO() throws IOException, ClassNotFoundException {
        DAO.getOrdem().atualizaColecaoDoArquivoOrdensAbertas(DAO.getOrdemDAOArquivo().lerArquivoOrdensEmAberto());
        ObservableLists.ordensEmAbertoData = FXCollections.observableArrayList();
        ObservableLists.ordensEmAbertoData.addAll(DAO.getOrdem().findManyEmAberto());
        DAO.getOrdem().atualizaColecaoDoArquivoOrdensEmEspera(DAO.getOrdemDAOArquivo().lerArquivoOrdensEmEspera());
        ObservableLists.ordensEmEsperaData = FXCollections.observableArrayList();
        ObservableLists.ordensEmEsperaData.addAll(DAO.getOrdem().findManyEmEspera());
        DAO.getOrdem().atualizaColecaoDoArquivoOrdensCanceladas(DAO.getOrdemDAOArquivo().lerArquivoOrdensCanceladas());
        ObservableLists.ordensCanceladasData = FXCollections.observableArrayList();
        ObservableLists.ordensCanceladasData.addAll(DAO.getOrdem().findManyCanceladas());
        DAO.getOrdem().atualizaColecaoDoArquivoOrdensFinalizadas(DAO.getOrdemDAOArquivo().lerArquivoOrdensFinalizadas());
        ObservableLists.ordensFinalizadasData = FXCollections.observableArrayList();
        ObservableLists.ordensFinalizadasData.addAll(DAO.getOrdem().findManyFinalizadas());
        DAO.getCliente().atualizaColecaoDoArquivo(DAO.getClienteDAOArquivo().lerArquivo());
        ObservableLists.clientesData = FXCollections.observableArrayList();
        ObservableLists.clientesData.addAll(DAO.getCliente().findManyArrayList());
        DAO.getEstoque().atualizaColecaoDoArquivo(DAO.getEstoqueDAOArquivo().lerArquivo());
        ObservableLists.pecasData = FXCollections.observableArrayList();
        ObservableLists.pecasData.addAll(DAO.getEstoque().findManyPecas());
        DAO.getTecnico().atualizaColecaoDoArquivo(DAO.getTecnicoDAOArquivo().lerArquivo());
        ObservableLists.tecnicosData = FXCollections.observableArrayList();
        ObservableLists.tecnicosData.addAll(DAO.getTecnico().findManyArrayList());
    }

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        atualizaColecoesDosArquivosDAO();

        stage = primaryStage;
        primaryStage.setTitle("GERENCIADOR DE SERVIÇOS");

        Parent fxmlInicial = FXMLLoader.load(getClass().getResource("views/inicial.fxml"));
        inicialScene = new Scene(fxmlInicial);

        //Adiciona ícone ao aplicativo
        Image image = new Image(getClass().getResourceAsStream("images/icon_computer_logo.png"));
        primaryStage.getIcons().add(image);

        primaryStage.setScene(inicialScene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();

        Parent fxmlCliente = FXMLLoader.load(getClass().getResource("views/cliente.fxml"));
        clienteScene = new Scene(fxmlCliente);

        Parent fxmlTecnico = FXMLLoader.load(getClass().getResource("views/tecnico.fxml"));
        tecnicoScene = new Scene(fxmlTecnico);

        Parent fxmlEstoque = FXMLLoader.load(getClass().getResource("views/estoque.fxml"));
        estoqueScene = new Scene(fxmlEstoque);

        Parent fxmlOrdem = FXMLLoader.load(getClass().getResource("views/ordem.fxml"));
        ordemScene = new Scene(fxmlOrdem);

    }
    public static void telaScreen(String nome) throws IOException {
        switch (nome) {
            case "inicial":
                //A página inicial precisa ser carregada toda vez que for chamada para atualizar as labels.
                Parent fxmlInicial = FXMLLoader.load(HelloApplication.class.getResource("views/inicial.fxml"));
                inicialScene = new Scene(fxmlInicial);
                stage.setScene(inicialScene);
                stage.setResizable(false);
                break;
            case "cliente":
                stage.setScene(clienteScene);
                stage.setResizable(false);
                break;
            case "tecnico":
                stage.setScene(tecnicoScene);
                stage.setResizable(false);
                break;
            case "estoque":
                stage.setScene(estoqueScene);
                stage.setResizable(false);
                break;
            case "ordens":
                stage.setScene(ordemScene);
                stage.setResizable(false);
                break;
            case "servicosDialog":
                FXMLLoader fxmlServicosDialog = new FXMLLoader(HelloApplication.class.getResource("views/servicosDialog.fxml"));
                servicosDialogScene = new Scene(fxmlServicosDialog.load());
                Stage stageDialogServicos = new Stage();
                stageDialogServicos.setTitle("ORDEM");
                stageDialogServicos.setScene(servicosDialogScene);
                stageDialogServicos.setResizable(false);
                stageDialogServicos.centerOnScreen();
                stageDialogServicos.initModality(Modality.APPLICATION_MODAL);
                stageDialogServicos.showAndWait();
                break;
            case "adicionarServicoDialogController":
                FXMLLoader fxmlAdicionarServicosDialog = new FXMLLoader(HelloApplication.class.getResource("views/adicionarServicoDialog.fxml"));
                adicionarServicosDialogScene = new Scene(fxmlAdicionarServicosDialog.load());
                Stage stageDialogAdicionarServicos = new Stage();
                stageDialogAdicionarServicos.setTitle("ADICIONAR SERVIÇO");
                stageDialogAdicionarServicos.setScene(adicionarServicosDialogScene);
                stageDialogAdicionarServicos.setResizable(false);
                stageDialogAdicionarServicos.centerOnScreen();
                stageDialogAdicionarServicos.initModality(Modality.APPLICATION_MODAL);
                stageDialogAdicionarServicos.showAndWait();
        }
    }

    public static void main(String[] args) throws Exception, IOException, ClassNotFoundException {
        launch();
        //MainController.main(args);
    }
}