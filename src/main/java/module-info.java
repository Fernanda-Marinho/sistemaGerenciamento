module com.example.sistemadegerenciamento {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.sistemadegerenciamento to javafx.fxml;
    exports com.example.sistemadegerenciamento;
}