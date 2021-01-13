package controllers;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.Initializable;




public class AdminController implements Initializable{
	public static double pricedel(){
		return newpricedel;
	}
	public static double pricestan(){
		return newstandprice;
	}
	public static double pricesize(){
		return newpricesize;
	}
	public static double priceex(){
		return newexprice;
	}
	
	static double newpricedel = 3;
	static double newstandprice = 5;
	static double newexprice = 0.75;
	static double newpricesize = 1;
	
	public Button btnAanpassenex;
	public Button btnAanpassensize;
	public Button btnAanpassendel;
	public Button btnAanpassenstan;
	public Button btnRegistreerNieuweAdministrator;
	public Button btnGoToDB;
	public Button btnLogUitClicked;
	
	public TextField extracostField;
	public TextField sizecostField;
	public TextField delcostField;
	public TextField standardpriceField;
	
	public BorderPane admin;
	
	public void btnAanpassenexClicked(){
		newexprice = Double.parseDouble(extracostField.getText());
	}
	
	public void btnAanpassensizeClicked() {
		newpricesize = Double.parseDouble(sizecostField.getText());
	}
	
	public void btnAanpassendelClicked() {
		newpricedel = Double.parseDouble(delcostField.getText());
	}
	
	public void btnAanpassenstanClicked() {
		newstandprice = Double.parseDouble(standardpriceField.getText());
	}
	
	public void btnRegistreerNieuweAdministratorClicked() {
		Main.window.setScene(Main.sceneAReg);
		Main.window.setTitle("Pizza Suite (Admin registreren)");
	}
	
	public void btnGoToDBClicked() {
		Main.window.setScene(Main.sceneDB);
		Main.window.setTitle("Pizza Suite (DB Manager)");
	}
	
	public void btnLogUitClicked() {
		LoginController.userID = 0;
		Main.window.setScene(Main.sceneLogin);
		Main.window.setTitle("Pizza Suite (Login)");
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		admin.setBackground(new Background(new BackgroundImage(new Image("file:///C:/Users/leviv/Java Course/FXTry2/rsc/backgrounds/background admin.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
	}
}
