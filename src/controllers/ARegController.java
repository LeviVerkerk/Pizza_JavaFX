package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ARegController implements Initializable{
	
	public TextField usernameField;
	public TextField nameField;
	public TextField adressField;
	public TextField cityField;
	public TextField phoneField;
	
	public PasswordField passwordField;
	
	public RadioButton rdbtnAdmin;
	public RadioButton rdbtnPersoneel;
	public RadioButton rdbtnUser;
	
	public ToggleGroup role;
	
	public VBox userFields;
	public BorderPane AReg;
	
	public void showUserFields() {
		userFields.setVisible(true);
	}
	
	public void hideUserFields() {
		userFields.setVisible(false);
	}
	
	public void back() {
		Main.window.setScene(Main.sceneAdmin);
		Main.window.setTitle("Pizza Suite (Admin Panel)");
	}
	
	public void register() {
		usernameField.setStyle("-fx-background-color: white;");
		passwordField.setStyle("-fx-background-color: white;");
		if(usernameField.getText().matches("^\\s*$")) {
			usernameField.setStyle("-fx-background-color: red;");
			JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
		}
		if(passwordField.getText().matches("^\\s*$")) {
			passwordField.setStyle("-fx-background-color: red;");
			JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
		}
		if(!(usernameField.getText().matches("^\\s*$")) && !(passwordField.getText().matches("^\\s*$")) && rdbtnAdmin.isSelected()) {
		try {
			SQL_methods.SQL.registerUserPassAdmin(usernameField.getText(), passwordField.getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usernameField.setText(null);
		passwordField.setText(null);
		}
		if(!(usernameField.getText().matches("^\\s*$")) && !(passwordField.getText().matches("^\\s*$")) && rdbtnPersoneel.isSelected()) {
			try {
				SQL_methods.SQL.registerUserPassStaff(usernameField.getText(), passwordField.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			usernameField.setText(null);
			passwordField.setText(null);
			}
		if(!(usernameField.getText().matches("^\\s*$")) && !(passwordField.getText().matches("^\\s*$")) && rdbtnUser.isSelected()) {
			phoneField.setStyle("-fx-background-color: white;");
			nameField.setStyle("-fx-background-color: white;");
			adressField.setStyle("-fx-background-color: white;");
			cityField.setStyle("-fx-background-color: white;");
			usernameField.setStyle("-fx-background-color: white;");
			passwordField.setStyle("-fx-background-color: white;");
			if(phoneField.getText().matches("[a-zA-Z]+") || phoneField.getText().length() != 10) {
				phoneField.setStyle("-fx-background-color: red;");
				JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
			}
			if(nameField.getText().matches("^s\\*$")) {
				nameField.setStyle("-fx-background-color: red;");
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

			}
			if(passwordField.getText().matches("^s\\*$")) {
				passwordField.setStyle("-fx-background-color: red;");
				JOptionPane.showMessageDialog(null, "U moet wel iets invullen","Error 01",JOptionPane.ERROR_MESSAGE);
			}
			if(!passwordField.getText().matches("^s\\*$") && !usernameField.getText().matches("^s\\*$") && !cityField.getText().matches("^s\\*$") && !adressField.getText().matches("^s\\*$") && !nameField.getText().matches("^s\\*$") && (!phoneField.getText().matches("[a-zA-Z]+") || phoneField.getText().length() == 10)) {
				//add username, phonenumber and password to an array in Login_S.java
				try {
					SQL_methods.SQL.registerUserPassUser(usernameField.getText(), passwordField.getText(), phoneField.getText(), nameField.getText(), adressField.getText(), cityField.getText());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "U bent geregistreerd!","Gelukt!",JOptionPane.OK_OPTION);
			} else {
				JOptionPane.showMessageDialog(null, "Onbekende error neem contact op met developer!","Error Unknown",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		AReg.setBackground(new Background(new BackgroundImage(new Image("file:///C:/Users/leviv/Java Course/FXTry2/rsc/backgrounds/background admin.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
		hideUserFields();
	}
}
