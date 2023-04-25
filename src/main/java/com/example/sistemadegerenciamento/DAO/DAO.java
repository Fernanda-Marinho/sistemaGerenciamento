package com.example.sistemadegerenciamento.DAO;

import com.example.sistemadegerenciamento.DAO.cliente.ClienteDAO;
import com.example.sistemadegerenciamento.DAO.cliente.ClienteDAOArquivo;
import com.example.sistemadegerenciamento.DAO.cliente.ClienteDAOImplementacao;
import com.example.sistemadegerenciamento.DAO.estoque.EstoqueDAO;
import com.example.sistemadegerenciamento.DAO.estoque.EstoqueDAOArquivo;
import com.example.sistemadegerenciamento.DAO.estoque.EstoqueDAOImplementacao;
import com.example.sistemadegerenciamento.DAO.ordem.OrdemDAO;
import com.example.sistemadegerenciamento.DAO.ordem.OrdemDAOImplementacao;
import com.example.sistemadegerenciamento.DAO.tecnico.TecnicoDAO;
import com.example.sistemadegerenciamento.DAO.tecnico.TecnicoDAOImplementacao;

/**
 * Classe responsável por salvar e chamar todas as implementações dos DAOs dos modelos (padrão singleton).
 * Como esta classe só tem atributos e métodos estáticos, consegue ser utilizado em qualquer lugar.
 * Sendo assim, possibilita que a persistência seja manipulada de qualquer classe.
 * Por fim, ela mantém o contato entre os models e a persistência.
 * */

public class DAO {
    private static ClienteDAO clienteDAO;
    private static ClienteDAOArquivo clienteDAOArquivo;
    private static OrdemDAO ordemDAO;
    private static TecnicoDAO tecnicoDAO;
    private static EstoqueDAO estoqueDAO;
    private static EstoqueDAOArquivo estoqueDAOArquivo;

    /*
    * Método estático que retorna um clienteDAOImplementacao. Isso é possível pois ClienteDAO é implementado por
    * ClienteDAOImplementacao. Então, ClienteDAOImplementacao é uma classe "filho" de ClienteDAO.
    * Por sua vez, ClienteDAO extende o CRUD. Por isso, ClienteDAOImplementacao também extende CRUD.
    * */

    /**
     * Método estático que retorna o ClienteDAO.
     * */
    public static ClienteDAO getCliente() {
        if (clienteDAO == null) {
            clienteDAO = new ClienteDAOImplementacao();
        }
        return clienteDAO;
    }

    public static ClienteDAOArquivo getClienteDAOArquivo() {
        if (clienteDAOArquivo == null) {
            clienteDAOArquivo = new ClienteDAOArquivo();
        }
        return clienteDAOArquivo;
    }
    /**
     * Método estático que retorna a OrdemDAO.
     * */
    public static OrdemDAO getOrdem() {
        if (ordemDAO == null){
            ordemDAO = new OrdemDAOImplementacao();
        }
        return ordemDAO;
    }
    /**
     * Método estático que retorna o TecnicoDAO.
     * */
    public static TecnicoDAO getTecnico() {
        if (tecnicoDAO == null){
            tecnicoDAO = new TecnicoDAOImplementacao();
        }
        return tecnicoDAO;
    }
    /**
     * Método estático que retorna o EstoqueDAO.
     * */
    public static EstoqueDAO getEstoque() {
        if (estoqueDAO == null){
            estoqueDAO = new EstoqueDAOImplementacao();
        }
        return estoqueDAO;
    }

    public static  EstoqueDAOArquivo getEstoqueDAOArquivo() {
        if (estoqueDAOArquivo == null){
            estoqueDAOArquivo = new EstoqueDAOArquivo();
        }
        return estoqueDAOArquivo;
    }
}
