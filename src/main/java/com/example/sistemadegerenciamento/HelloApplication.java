package com.example.sistemadegerenciamento;

import com.example.sistemadegerenciamento.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;


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

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("GERENCIADOR DE SERVIÇOS");

        Parent fxmlInicial = FXMLLoader.load(getClass().getResource("views/inicial.fxml"));
        System.out.println("Ok!");
        inicialScene = new Scene(fxmlInicial);
        System.out.println("Ok!");
        Image image = new Image(getClass().getResourceAsStream("images/icon_computer_logo.png"));
        primaryStage.getIcons().add(image);
        System.out.println(getClass().getResourceAsStream(""));
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
                //Parent fxmlServicosDialog = FXMLLoader.load(getClass().getResource("servicosDialog.fxml"));
                FXMLLoader fxmlServicosDialog = new FXMLLoader(HelloApplication.class.getResource("views/servicosDialog.fxml"));
                servicosDialogScene = new Scene(fxmlServicosDialog.load());
                Stage stageDialog = new Stage();
                stageDialog.setTitle("ORDEM");
                stageDialog.setScene(servicosDialogScene);
                stageDialog.setResizable(false);
                stageDialog.centerOnScreen();
                stageDialog.initModality(Modality.APPLICATION_MODAL);
                stageDialog.showAndWait();
        }
    }

    public static void main(String[] args) throws Exception, IOException, ClassNotFoundException {
        launch();
        //Alteração pendente: no dialog, trocar estratégia. Colocar igual o vídeo de Tosta. Do jeito que está o initialize se apresenta primeiro que a chamada do botão e do case switch. Portanto, não dá para atualizar a ordem atual antes de inicializar.
        //Falta consertar a quantidade na tabela de estoquee controller
        //MainController.main(args);
    }
}