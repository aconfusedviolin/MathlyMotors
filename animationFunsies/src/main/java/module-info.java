module com.example.animationfunsies {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires javafx.media;

    opens mathlyMotors to javafx.fxml;
    exports mathlyMotors;
}