module com.example.javafx6quiprend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafx6quiprend to javafx.fxml;
    opens com.example.javafx6quiprend.Base to javafx.fxml;
    exports com.example.javafx6quiprend.Base;
}