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

public class TrackController implements Initializable{
	public Label lblorder;
	
	public VBox track;
	
	public void refresh() {
		lblorder.setText("Uw bestelling " + SQL_methods.SQL.getStatusOrder(LoginController.userID));
	}
	
	public void back() {
		Main.window.setScene(Main.sceneUser);
		Main.window.setTitle("Pizza Suite (Order)");
	}
	
	public void loguit() {
		LoginController.userID = 0;
		Main.window.setScene(Main.sceneLogin);
		Main.window.setTitle("Pizza Suite (Login)");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String property = System.getProperty("user.dir").replace('\\', '/');
		track.setBackground(new Background(new BackgroundImage(new Image("file:///" + property + "/rsc/backgrounds/background admin.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
	}
}
