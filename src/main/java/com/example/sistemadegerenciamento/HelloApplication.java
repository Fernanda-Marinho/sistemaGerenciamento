package com.example.sistemadegerenciamento;

import com.example.sistemadegerenciamento.controller.MainController;
import com.example.sistemadegerenciamento.controller.servicosDialogController;
import com.example.sistemadegerenciamento.models.Ordem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene inicialScene;
    private static Scene clienteScene;
    private static Scene tecnicoScene;
    private static Scene estoqueScene;
    private static Scene ordemScene;
    private static Scene servicosDialogScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("GERENCIADOR DE SERVIÇOS");

        Parent fxmlInicial = FXMLLoader.load(getClass().getResource("inicial.fxml"));
        inicialScene = new Scene(fxmlInicial);

        primaryStage.setScene(inicialScene);
        primaryStage.setResizable(false);
        primaryStage.show();

        Parent fxmlCliente = FXMLLoader.load(getClass().getResource("cliente.fxml"));
        clienteScene = new Scene(fxmlCliente);

        Parent fxmlTecnico = FXMLLoader.load(getClass().getResource("tecnico.fxml"));
        tecnicoScene = new Scene(fxmlTecnico);

        Parent fxmlEstoque = FXMLLoader.load(getClass().getResource("estoque.fxml"));
        estoqueScene = new Scene(fxmlEstoque);

        Parent fxmlOrdem = FXMLLoader.load(getClass().getResource("ordem.fxml"));
        ordemScene = new Scene(fxmlOrdem);

        Parent fxmlServicosDialog = FXMLLoader.load(getClass().getResource("servicosDialog.fxml"));
        servicosDialogScene = new Scene(fxmlServicosDialog);
    }
    public static void telaScreen(String nome) {
        switch (nome) {
            case "inicial":
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
                Stage stageDialog = new Stage();
                stageDialog.setTitle("ORDEM");
                stageDialog.setScene(servicosDialogScene);
                stageDialog.setResizable(false);
                stageDialog.centerOnScreen();
                stageDialog.initModality(Modality.APPLICATION_MODAL);
                System.out.println("2) case switch");
                stageDialog.showAndWait();
        }
    }

    public static void main(String[] args) throws Exception, IOException, ClassNotFoundException {
        launch();
        //Alteração pendente: no dialog, trocar estratégia. Colocar igual o vídeo de Tosta. Do jeito que está o initialize se apresenta primeiro que a chamada do botão e do case switch. Portanto, não dá para atualizar a ordem atual antes de inicializar.
        //MainController.main(args);
    }
}