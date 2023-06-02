package com.example.sistemadegerenciamento.controller;

public class Controller {
    private static ClienteController clienteController;
    private static EstoqueController estoqueController;
    private static InicialController inicialController;
    private static OrdemController ordemController;
    private static ServicosDialogController servicosDialogController;
    private static TecnicoController tecnicoController;
    public static ClienteController getClienteController() {
        if (clienteController == null) {
            clienteController = new ClienteController();
        }
        return clienteController;
    }
    public static EstoqueController getEstoqueController() {
        if (estoqueController == null) {
            estoqueController = new EstoqueController();
        }
        return estoqueController;
    }
    public static InicialController getInicialController() {
        if (inicialController == null) {
            inicialController = new InicialController();
        }
        return inicialController;
    }
    public static OrdemController getOrdemController() {
        if (ordemController == null) {
            ordemController = new OrdemController();
        }
        return ordemController;
    }
    public static ServicosDialogController getServicosDialogController() {
        if (servicosDialogController == null) {
            servicosDialogController = new ServicosDialogController();
        }
        return servicosDialogController;
    }
    public static TecnicoController getTecnicoController() {
        if (tecnicoController == null) {
            tecnicoController = new TecnicoController();
        }
        return tecnicoController;
    }
}
