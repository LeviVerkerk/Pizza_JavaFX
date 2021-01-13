package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.*;


public class RegisterController implements Initializable{

	public AnchorPane registerPane;
	public TextField usernameField;
	public PasswordField passwordField;
	public TextField adressField;
	public TextField phoneField;
	public TextField cityField;
	public TextField nameField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String property = System.getProperty("user.dir").replace('\\', '/');
		registerPane.setBackground(new Background(new BackgroundImage(new Image("file:///" + property + "/rsc/backgrounds/background register.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
	}
	
	public void btncancelclicked() {
		Main.window.setScene(Main.sceneLogin);
		Main.window.setTitle("Pizza Suite (Log In)");
	}
	
	public void btnregisterclicked() {
		phoneField.setStyle("-fx-background-color: white;");
		nameField.setStyle("-fx-background-color: white;");
		adressField.setStyle("-fx-background-color: white;");
		cityField.setStyle("-fx-background-color: white;");
		usernameField.setStyle("-fx-background-color: white;");
		//passwordField.setStyle("-fx-background-color: white;");
		 if(nameField.getText().matches("^\\s*$") || adressField.getText().matches("^\\s*$") || cityField.getText().matches("^\\s*$") || phoneField.getText().length() != 10) {
		System.out.println("1");
			 if(phoneField.getText().matches("[a-zA-Z]+") || phoneField.getText().length() != 10) {
			phoneField.setStyle("-fx-background-color: red;");
			JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
		}
		
		if(adressField.getText().matches("^s\\*$")) {
			adressField.setStyle("-fx-background-color: red;");
			JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
		}
		if(cityField.getText().matches("^s\\*$")) {
			cityField.setStyle("-fx-background-color: red;");
			JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
		}
		if(usernameField.getText().matches("^s\\*$")) {
			usernameField.setStyle("-fx-background-color: red;");
			JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
		}/*
		if(passwordField.getText().matches("^s\\*$")) {
			passwordField.setStyle("-fx-background-color: red;");
			JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
		}*/
		 }else {
		try {
			SQL_methods.SQL.registerUserPassUser(usernameField.getText(), passwordField.getText(), phoneField.getText(), nameField.getText(), adressField.getText(), cityField.getText());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "U bent geregistreerd!","Gelukt!",JOptionPane.OK_OPTION);
	}

}
	
}
