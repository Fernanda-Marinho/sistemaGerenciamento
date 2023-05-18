package com.example.sistemadegerenciamento;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.HashMap;

public class HelloController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private MenuItem btnSalvar;

    @FXML
    private TextField endereco;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TableView<Cliente> tabela;

    @FXML
    private TextField telefone;

    @FXML
    private Label labelErro;

    //Collections do JavaFX
    private ObservableList<Cliente> clientesData;

    /**
     * Método que faz a leitura da persistênia de dados dos clientes de uma arquivo binário através da desserialização.
     * */
    public HashMap<Integer, Cliente> lerArquivoClienteDAO() throws IOException, ClassNotFoundException {
        return DAO.getClienteDAOArquivo().lerArquivo();
    }

    /**
     * Método que atualiza a coleção de clientes em tempo de execução.
     * */
    public void carregaArquivoClienteDAO() throws IOException, ClassNotFoundException {
        DAO.getCliente().atualizaColecaoDoArquivo(lerArquivoClienteDAO());
    }
    @FXML
    //Carrega todos os dados a serem mostrados no View.
    void initialize() throws IOException, ClassNotFoundException {
        carregaArquivoClienteDAO();
        this.clientesData = FXCollections.observableArrayList();
        this.clientesData.addAll(DAO.getCliente().findManyArrayList());
        //Cria a coluna para usar na tabela, de maneira manual.
        TableColumn coluna1 = new TableColumn("ID");
        TableColumn coluna2 = new TableColumn("NOME");
        TableColumn coluna3 = new TableColumn("ENDEREÇO");
        TableColumn coluna4 = new TableColumn("TELEFONE");

        coluna1.setCellValueFactory(new PropertyValueFactory<Cliente, String>("clienteID"));
        coluna2.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        coluna3.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
        coluna4.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        this.tabela.getColumns().addAll(coluna1, coluna2, coluna3, coluna4);
        this.tabela.setItems(clientesData);

    }
    @FXML
    void btnAdiciona(ActionEvent event) {
        try {
            //.getText() pega o texto em String do textfield.
            Cliente cliente = new Cliente(this.nomeCliente.getText(), this.endereco.getText(), this.telefone.getText());
            DAO.getCliente().create(cliente);
            this.clientesData.add(cliente);
            //Para limpar o conteúdo do textfield.
            this.nomeCliente.clear();
            this.endereco.clear();
            this.telefone.clear();
            this.labelErro.setText("");
        } catch (Exception e){
            //O setText no label carrega uma String na interface.
            this.labelErro.setText("Erro ao digitar os dados.");
        }
    }

    @FXML
    void btnAltera(ActionEvent event) {
        try {
            //.getSelectionModel().getSelectedIndex() pega o índice do item selecionado da tabela.
            int selecionadoTabelaIndice = this.tabela.getSelectionModel().getSelectedIndex();
            if (selecionadoTabelaIndice>=0) {
                Cliente selecionadoTabela = this.tabela.getSelectionModel().getSelectedItem();

                int clienteID = selecionadoTabela.getClienteID();
                //.getText() pega o texto em String do textfield.
                DAO.getCliente().update(clienteID, this.nomeCliente.getText(), this.endereco.getText(), this.telefone.getText());
                this.clientesData.set(selecionadoTabelaIndice, DAO.getCliente().findById(clienteID));
                //Para limpar o conteúdo do textfield.
                this.nomeCliente.clear();
                this.endereco.clear();
                this.telefone.clear();
                this.labelErro.setText("");
            }
        } catch (Exception e){
            //O setText no label carrega uma String na interface.
            this.labelErro.setText("Erro ao digitar os dados.");
        }

    }

    @FXML
    void btnExclui(ActionEvent event) throws Exception {
        //.getSelectionModel().getSelectedIndex() pega o índice do item selecionado da tabela.
        int selecionadoTabelaIndice = this.tabela.getSelectionModel().getSelectedIndex();
        if (selecionadoTabelaIndice>=0) {
            Cliente selecionadoTabela = this.tabela.getSelectionModel().getSelectedItem();
            int clienteID = selecionadoTabela.getClienteID();
            DAO.getCliente().delete(clienteID);
            this.clientesData.remove(selecionadoTabelaIndice);
        }
    }

    @FXML
    void btnSalvaArquivo(ActionEvent event) throws IOException {
        DAO.getClienteDAOArquivo().salvarArquivo();
    }

}
