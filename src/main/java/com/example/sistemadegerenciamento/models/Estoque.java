package com.example.sistemadegerenciamento.models;
<<<<<<< HEAD

public class Estoque {

    private Peca pecas;
    private OrdemCompra ordensCompra;

    public Estoque(Peca pecas, OrdemCompra ordensCompra){
        this.pecas = pecas;
        this.ordensCompra = ordensCompra;
    }
=======
import java.util.ArrayList;
//Padrão singleton
//Alterações: definição das duas coleções e remoção do construtor.

public class Estoque {

	//Definição das duas coleções.
    private ArrayList<Peca> pecas = new ArrayList();
	private ArrayList<OrdemCompra> ordensCompra = new ArrayList();

	//Estoque pode surgir sem peças e sem ordemDeCompra.
    public Estoque(){

    }

	//Falta definir adicionar peças ao estoque através da ordemDeCompra.
	//Falta remover peça de acordo com retirada.
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
}
