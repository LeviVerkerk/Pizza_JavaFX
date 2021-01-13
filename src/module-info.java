module FXTry2 {
    requires javafx.fxml;
    requires  javafx.controls;
    requires javafx.swing;
    requires java.sql;

    opens application;
    opens controllers;
    opens Encryption;
    opens lib;
    opens SQL_methods;
}