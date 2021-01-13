package controllers;

import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class LoginController implements Initializable{
	public TextField usernameField;
	public TextField passwordField;
	public Button btnRegister;
	public AnchorPane LoginPane;
	public static int userID;
	
	public void btnregisterclicked(){
		Main.window.setScene(Main.sceneRegister);
		Main.window.setTitle("Pizza Suite (Registreren)");
	}
	
	public void btnclosedclicked(){
		Main.window.close();
	}
	
	public void onEnter(ActionEvent ae){
		   btnloginclicked();
		   System.out.println("test");
		}
	
	public void btnloginclicked() {
		System.out.println("Clicked!");
		
		String typeuser = "invalid";
		try {
			typeuser = SQL_methods.SQL.loginUserPassArray(usernameField.getText(), passwordField.getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(typeuser.equals("admin")) {
			userID = SQL_methods.SQL.getIDofUser("admins", usernameField.getText(), passwordField.getText());
			passwordField.setText(null);
			usernameField.setText(null);
			Main.window.setScene(Main.sceneAdmin);
			Main.window.setTitle("Pizza Suite (Admin Panel)");
		}
		if(typeuser.equals("user")) {
			userID = SQL_methods.SQL.getIDofUser("customers", usernameField.getText(), passwordField.getText());
			passwordField.setText(null);
			usernameField.setText(null);
			Main.window.setScene(Main.sceneUser);
			Main.window.setTitle("Pizza Suite (User order)");
		}
		if(typeuser.equals("staff")) {
			userID = SQL_methods.SQL.getIDofUser("staff", usernameField.getText(), passwordField.getText());
			usernameField.setText(null);
			passwordField.setText(null);
			Main.window.setScene(Main.sceneStaff);
			Main.window.setTitle("Pizza Suite (Mederwerkers)");
		}
		
		if(typeuser.equals("invalid")) {
			JOptionPane.showMessageDialog(null, "Invalid password and username!", "Error 02", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String property = System.getProperty("user.dir").replace('\\', '/');
		System.out.println(property);

		LoginPane.setBackground(new Background(new BackgroundImage(new Image("file:///" + property + "/rsc/backgrounds/background_login.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
	}
	
	
	


}
