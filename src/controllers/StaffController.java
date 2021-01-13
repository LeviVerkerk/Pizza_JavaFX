package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class StaffController implements Initializable{
	
	@FXML public ListView<String> list;
	
	public BorderPane StaffPane;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println(list);
		String property = System.getProperty("user.dir").replace('\\', '/');
		StaffPane.setBackground(new Background(new BackgroundImage(new Image("file:///" + property + "/rsc/backgrounds/background login.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
		list.getItems().clear();
		SQL_methods.SQL.setOrders_in_listView(list);
		

	}
	
	public void btnAdresVerkrijgenClicked() {
		int id = Integer.parseInt( list.getSelectionModel().getSelectedItem().substring(0, list.getSelectionModel().getSelectedItem().indexOf(",")));
		if(SQL_methods.SQL.getInfoFromDatabase("deltake", id, "orders").equals("Deliver")) {
			int customer_id = SQL_methods.SQL.getIntFromDatabase("customer_id", id, "orders");
			System.out.println(String.valueOf(customer_id));
			String adres = SQL_methods.SQL.getInfoFromDatabase("adress", customer_id, "customers");
			String woonplaats = SQL_methods.SQL.getInfoFromDatabase("city", customer_id, "customers");
			String naam = SQL_methods.SQL.getInfoFromDatabase("name", customer_id, "customers");
			String telefoon = SQL_methods.SQL.getInfoFromDatabase("phone", customer_id, "customers");
			JOptionPane.showMessageDialog(null, "Het adres van de klant is: " + adres + ", " + woonplaats + ". De bestelling is geplaatst door: " + naam + ". Doet de klant niet open dit is zijn/haar nummer: " + telefoon + ".");
		}else {
			JOptionPane.showMessageDialog(null, "De klant komt de bestelling ophalen!");
		}
	}
	
	public void btnLogUitClicked() {
		LoginController.userID = 0;
		Main.window.setScene(Main.sceneLogin);
		Main.window.setTitle("Pizza Suite (Login)");
	}
	
	public void btnRefreshClicked() {
		list.getItems().clear();
		SQL_methods.SQL.setOrders_in_listView(list);
		
	}
	
	public void btnKlaarClicked() {
		if(list.getSelectionModel().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You have to select an item in order to change status!", "Error 03", JOptionPane.ERROR_MESSAGE);
		} else {
		int id = Integer.parseInt( list.getSelectionModel().getSelectedItem().toString().substring(0, list.getSelectionModel().getSelectedItem().toString().indexOf(",")));
		System.out.println("Selected id is: " + String.valueOf(id));
		SQL_methods.SQL.updateStatusOrder("is klaar!", id);
		System.out.println("Status successfully updated!");
		}
	}
	
	public void btnInDeOvenClicked() {
		if(list.getSelectionModel().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You have to select an item in order to change status!", "Error 03", JOptionPane.ERROR_MESSAGE);
		} else {
		int id = Integer.parseInt( list.getSelectionModel().getSelectedItem().toString().substring(0, list.getSelectionModel().getSelectedItem().toString().indexOf(",")));
		System.out.println("Selected id is: " + String.valueOf(id));
		SQL_methods.SQL.updateStatusOrder("wordt gebakken!", id);
		System.out.println("Status successfully updated!");
		}
	}
	
	public void btnCookingClicked() {
		if(list.getSelectionModel().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You have to select an item in order to change status!", "Error 03", JOptionPane.ERROR_MESSAGE);
		} else {
		int id = Integer.parseInt( list.getSelectionModel().getSelectedItem().toString().substring(0, list.getSelectionModel().getSelectedItem().toString().indexOf(",")));
		System.out.println("Selected id is: " + String.valueOf(id));
		SQL_methods.SQL.updateStatusOrder("wordt bereid!", id);
		System.out.println("Status successfully updated!");
		}
	}
}
