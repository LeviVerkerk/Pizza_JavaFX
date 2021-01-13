package application;
	



import java.io.IOException;




import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	//All Scenes are declared here
	public static Stage window;
	public static Scene sceneRegister;
	public static Scene sceneLogin;
	public static Scene sceneUser;
	public static Scene sceneAdmin;
	public static Scene sceneStaff;
	public static Scene sceneTrack;
	public static Scene sceneDB;
	public static Scene sceneAReg;
	
	//So are the panes
	AnchorPane root;
	BorderPane PizzaUser;
	AnchorPane register;
	BorderPane PizzaAdmin;
	BorderPane PizzaStaff;
	BorderPane AReg;
	VBox Track;
	VBox DB;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		
		//The scenes are initiated
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("/GUI/Inlog.fxml"));
			PizzaUser = (BorderPane)FXMLLoader.load(getClass().getResource("/GUI/User.fxml"));
			register = (AnchorPane)FXMLLoader.load(getClass().getResource("/GUI/Register.fxml"));
			PizzaAdmin = (BorderPane)FXMLLoader.load(getClass().getResource("/GUI/Admin.fxml"));
			PizzaStaff = (BorderPane)FXMLLoader.load(getClass().getResource("/GUI/Staff.fxml"));
			AReg = (BorderPane)FXMLLoader.load(getClass().getResource("/GUI/AdminReg.fxml"));
			Track = (VBox)FXMLLoader.load(getClass().getResource("/GUI/TrackndTrace.fxml"));
			DB = (VBox)FXMLLoader.load(getClass().getResource("/GUI/DBManager.fxml"));
			
			
			sceneUser = new Scene(PizzaUser, 800,500);
			sceneAdmin = new Scene(PizzaAdmin, 600, 340);
			sceneLogin = new Scene(root,800,500);
			sceneRegister = new Scene(register, 550, 425);
			sceneStaff = new Scene(PizzaStaff, 600, 400);
			sceneTrack = new Scene(Track, 600, 300);
			sceneDB = new Scene(DB, 600, 275 );
			sceneAReg = new Scene(AReg, 600, 400);
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setScene(sceneLogin);
			window.setTitle("Pizza Suite (Login)");
			window.getIcons().add(new Image("file:///C:/Users/leviv/Java Course/FXTry2/rsc/img/icon-pizza.png"));
			window.centerOnScreen();
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		
			
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
		
}
