package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class OrderController implements Initializable{

	//fields from the FXML
	public TextField nameField;
	public TextField phoneField;
	public TextField adressField;
	public TextField cityField;
	
	//buttons from the FXML
	public Button totalbutton;
	public Button sendbutton;
	public Button btnLogUit;
	public Button btnTrack;
	
	//textareas from the FXML
	public TextArea output;
	
	//layouts from the FXML
	public VBox fields;
	public BorderPane PizzaUser;
	
	
	//radiobuttons from the FXML
	public RadioButton smallsize;
	public RadioButton mediumsize;
	public RadioButton bigsize;
	public RadioButton extrabigsize;
	public RadioButton choicetake;
	public RadioButton choicedeliver;
	
	
	//togglegroups from the FXML
	public ToggleGroup size;
	public ToggleGroup del;
	
	
	//Checboxes from the FXML
	public CheckBox choicecheese;
	public CheckBox choiceham;
	public CheckBox choicesalami;
	public CheckBox choicemushroom;
	public CheckBox choicetuna;
	public CheckBox choicemeat;
	public CheckBox choiceveg;
	
	
	//vars for SQL
	String deltake;
	String sizeSQL;
	boolean cheese = false;
	boolean ham = false;
	boolean salami = false;
	boolean mushroom = false;
	boolean tuna = false;
	boolean extra_veg = false;
	boolean extra_meat = false;
	
	//calc vars
	double price;
	public double pricestan = 5;
	public double pricedel = 3;
	
	//output vars
	String line1;
	String line2;
	String line3;
	String hamstr = "";
	String cheesestr = "";
	String salamistr = "";
	String mushroomstr = "";
	String tunastr = "";
	String vegstr = "";
	String meatstr = "";
	int sizeswitch;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String property = System.getProperty("user.dir").replace('\\', '/');
		PizzaUser.setBackground(new Background(new BackgroundImage(new Image("file:///" + property + "/rsc/backgrounds/background user.png",800,500,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT)));
		
	}public void initialize() {
		nameField.setText(SQL_methods.SQL.getInfoFromDatabase("name", LoginController.userID, "customers"));
		phoneField.setText(SQL_methods.SQL.getInfoFromDatabase("phone", LoginController.userID, "customers"));
		adressField.setText(SQL_methods.SQL.getInfoFromDatabase("adress", LoginController.userID, "customers"));
		cityField.setText(SQL_methods.SQL.getInfoFromDatabase("city", LoginController.userID, "customers"));
		
		System.out.println("lkaas");
		
		System.out.println(SQL_methods.SQL.getInfoFromDatabase("city", LoginController.userID, "customers") + "kaas");
	}
	
	
	
	public void totalClicked() {
		  hamstr = "";
    	  cheesestr = "";
    	  salamistr = "";
    	  mushroomstr = "";
    	  tunastr = "";
    	  vegstr = "";
    	  meatstr = "";
    	  //if someone didnt fill in a field now the fields are white again if he filled them in now
    	nameField.setStyle("-fx-background-color: white;");
    	adressField.setStyle("-fx-background-color: white;");
    	cityField.setStyle("-fx-background-color: white;");
    	phoneField.setStyle("-fx-background-color: white;");
    	//these are the price calculation
    	 //if you choose to deliver this should happen
        if(choicedeliver.isSelected()) {
        	
        	price += AdminController.pricedel();
        	
        	line2 = "\n" + "Bezorgen:" + "\n" + nameField.getText() + "\n" + adressField.getText() + "\n" + cityField.getText() + "\n" + phoneField.getText() + "\n";    	
        	}
       
        phoneField.setText(SQL_methods.SQL.getInfoFromDatabase("phone", LoginController.userID, "customers"));
        //if a field is not filled in the field shoud become red
        if(choicedeliver.isSelected() && (nameField.getText().matches("^\\s*$") || adressField.getText().matches("^\\s*$") || cityField.getText().matches("^\\s*$") || phoneField.getText().length() != 10)) {
    	if(choicedeliver.isSelected() && nameField.getText().matches("^\\s*$")) {
    		nameField.setStyle("-fx-background-color: red;");
    		output.setText("U moet wel uw adres invullen!");
    	}
    if(choicedeliver.isSelected() && adressField.getText().matches("^\\s*$")) {
    	adressField.setStyle("-fx-background-color: red;");
    	output.setText("U moet wel uw adres invullen!");
    	}
    if(choicedeliver.isSelected() && cityField.getText().matches("^\\s*$")) {
    	cityField.setStyle("-fx-background-color: red;");
    	output.setText("U moet wel uw adres invullen!");
    }
    if(choicedeliver.isSelected() && phoneField.getText().length() != 10) {
    	phoneField.setStyle("-fx-background-color: red;");
    	output.setText("U moet wel uw adres invullen!");
    }}
        
        
    else {
    	//used to change the price based on size
    	price = AdminController.pricestan();
    	if(smallsize.isSelected()) {
    		sizeswitch = 1;
    		sizeSQL = "small";
    	}
    	if(mediumsize.isSelected()) {
    		sizeswitch = 2;
    		sizeSQL = "medium";
    	}
    	if(bigsize.isSelected()) {
    		sizeswitch = 3;
    		sizeSQL = "large";
    	}
    	if(extrabigsize.isSelected()) {
    		sizeswitch = 4;
    		sizeSQL = "extra large";
    	}
    	switch (sizeswitch) {
    	case 1: 	    line1 = "Kleine pizza";	    break;
    	case 2:			price += (AdminController.pricesize());					line1 = "Medium pizza";	    break;
    	case 3:		price += (AdminController.pricesize())*2;	    line1 = "Grote pizza";	    break;
    	case 4:		price += (AdminController.pricesize())*3;	    line1 = "Extra grote pizza";	    break;
    	}
    	

        //for extra ingredients u pay 0.75
        if(choicecheese.isSelected()){
          price += (AdminController.priceex()); 
          cheesestr = "- Kaas" + "\n";
          cheese = true;
        }
        if(choiceham.isSelected()){
          price += (AdminController.priceex()); 
          hamstr = "- Ham" + "\n";
          ham = true;
        }
        if(choicemushroom.isSelected()){
          price += (AdminController.priceex());
          mushroomstr = "- Champignon" + "\n";
          mushroom = true;
        }
        if(choicetuna.isSelected()){
            price += (AdminController.priceex());
            tunastr = "- Tuna" + "\n";
            tuna = true;
          }
        if(choicesalami.isSelected()){
            price += (AdminController.priceex());
            salamistr = "- Salami" + "\n";
            salami = true;
          }
        //for extra meat or vegetables u pay 1.50 
        if(choiceveg.isSelected()){
            price += (AdminController.priceex())*2;
            vegstr = "- Extra groenten" + "\n";
            extra_veg = true;
          }
        if(choicemeat.isSelected()){
            price += (AdminController.priceex())*2;
            meatstr = "- Extra vlees" + "\n";
            extra_meat = true;
          }
        //if you choose to deliver the adress fill in stuff gets visible
        if(choicedeliver.isSelected()) {
        	deltake = "Deliver";
        	price += AdminController.pricedel();
        	line2 = "\n" + "Bezorgen:" + "\n" + nameField.getText() + "\n" + adressField.getText() + "\n" + cityField.getText() + "\n" + phoneField.getText() + "\n";    	
        	}
        
        //if someone choses take away the string should say take-away.
        if(choicetake.isSelected()) {
        	deltake = "Take Away";
        	line2 = "\n" + "Afhalen" + "\n";
        }
    		//if all the fields are filled in correcly it should do this
        	 line3 = "\n" + "Totale prijs: " + "\u20ac" + " " + String.format("%.2f", price).replaceAll("[.]", ",");
        	    output.setText(line1 + "\n" + "Ingredienten:" + "\n"+ cheesestr + hamstr + tunastr + salamistr + mushroomstr + vegstr + meatstr + line2 + line3);
        	    sendbutton.setDisable(false);;}
	}
	
	public void sendClicked() {
		SQL_methods.SQL.placeOrder(LoginController.userID, price, deltake, sizeSQL, cheese, ham, salami, mushroom, tuna, extra_veg, extra_meat);
  	  
  	  //if some1 presses this button the applets needs to be resetted to how it looked on the start
  	  output.setText("");
  	  nameField.setText("");
  	  adressField.setText("");
  	  cityField.setText("");
  	  phoneField.setText("");
  	  choiceham.setSelected(false);
  	  choicecheese.setSelected(false);
  	  choicetuna.setSelected(false);
  	  choicesalami.setSelected(false);
  	  choicemushroom.setSelected(false);
  	  choiceveg.setSelected(false);
  	  choicemeat.setSelected(false);
  	  del.selectToggle(null);;
  	  size.selectToggle(null);;
  	  sendbutton.setDisable(true);
  	  
	}
	
	public void logoutClicked() {
		LoginController.userID = 0;
		Main.window.setScene(Main.sceneLogin);
		Main.window.setTitle("Pizza Suite (Login)");
	}
	
	public void tackClicked() {
		Main.window.setScene(Main.sceneTrack);
		Main.window.setTitle("Pizza Suite (Track and Trace)");
	}

	
}
