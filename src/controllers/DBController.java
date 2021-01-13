package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

public class DBController implements Initializable{
	
	public Label lblAmountCustomer;
	public Label lblAmountStaff;
	public Label lblAmountAdmins;
	public Label lblAmountOrders;
	public Label lblDeDuursteBestelling;
	public Label lblAveragePrice;
	
	public VBox DBManager;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.refresh();
		lblAmountStaff.setText("De database bevat " + String.valueOf(SQL_methods.SQL.amountOfType("staff")) + " medewerker.");
		lblAmountOrders.setText("Er zijn in totaal " + String.valueOf(SQL_methods.SQL.amountOfType("orders")) + " bestellingen geplaatst, door " + String.valueOf(SQL_methods.SQL.amountOfCustomersOrdered()) + " klanten!");
		lblAmountAdmins.setText("De database bevat " + String.valueOf(SQL_methods.SQL.amountOfType("admins")) + " admins");
		lblDeDuursteBestelling.setText("De duurste bestelling was \u20AC " + String.valueOf(SQL_methods.SQL.CalcPriceOrder("MAX")) + " en de goedkoopste \u20AC" + String.valueOf(SQL_methods.SQL.CalcPriceOrder("MIN")));
		lblAveragePrice.setText("De gemiddelde prijs van een bestelling is: \u20AC" + String.valueOf(SQL_methods.SQL.CalcPriceOrder("AVG")));
		lblAmountCustomer.setText("De database bevat " + String.valueOf(SQL_methods.SQL.amountOfType("customers")) + " klanten");
		
		DBManager.setBackground(new Background(new BackgroundImage(new Image("file:///C:/Users/leviv/Java Course/FXTry2/rsc/backgrounds/background admin.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
	}
	
	public void back() {
		Main.window.setScene(Main.sceneAdmin);
		Main.window.setTitle("Pizza Suite (Admin panel)");
	}public void refresh() {
		lblAmountStaff.setText("De database bevat " + String.valueOf(SQL_methods.SQL.amountOfType("staff")) + " medewerker.");
		lblAmountOrders.setText("Er zijn in totaal " + String.valueOf(SQL_methods.SQL.amountOfType("orders")) + " bestellingen geplaatst, door " + String.valueOf(SQL_methods.SQL.amountOfCustomersOrdered()) + " klanten!");
		lblAmountAdmins.setText("De database bevat " + String.valueOf(SQL_methods.SQL.amountOfType("admins")) + " admins");
		lblDeDuursteBestelling.setText("De duurste bestelling was \u20AC " + String.valueOf(SQL_methods.SQL.CalcPriceOrder("MAX")) + " en de goedkoopste \u20AC" + String.valueOf(SQL_methods.SQL.CalcPriceOrder("MIN")));
		lblAveragePrice.setText("De gemiddelde prijs van een bestelling is: \u20AC" + String.valueOf(SQL_methods.SQL.CalcPriceOrder("AVG")));
		lblAmountCustomer.setText("De database bevat " + String.valueOf(SQL_methods.SQL.amountOfType("customers")) + " klanten");
	}
}
