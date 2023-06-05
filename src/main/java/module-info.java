module com.example.sistemadegerenciamento {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.commons;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.sistemadegerenciamento to javafx.fxml, javafx.graphics;
    opens com.example.sistemadegerenciamento.models;
    exports com.example.sistemadegerenciamento;
    exports com.example.sistemadegerenciamento.controller;
    opens com.example.sistemadegerenciamento.controller to javafx.fxml, javafx.graphics;
}