package SQL_methods;

import java.sql.*;

import javafx.scene.control.ListView;

//import PizzaStaff.PizzaS;

public class SQL {
	
	public static void connectToSQL() {
		
		
		try {
			@SuppressWarnings("unused")
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success");
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println(e);
		
	}
	}
	
	public static String loginUserPassArray(String a, String b) throws Throwable {
		//return "error";
		boolean user = false;
		boolean admin = false;
		boolean staff = false;
		String output = null;
		String usernamecurrent;
		String passwordcurrent;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success");
			
			String queryc = "SELECT username, cast(aes_decrypt(password, 'b/_W-u+c6>=V]UF') as char(255)) as `password` FROM customers";
			String querya = "SELECT username, cast(aes_decrypt(password, 'b/_W-u+c6>=V]UF') as char(255)) as `password` FROM admins";
			String querys = "SELECT username, cast(aes_decrypt(password, 'b/_W-u+c6>=V]UF') as char(255)) as `password` FROM staff";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(queryc);
			while(rs.next()) {
				usernamecurrent = rs.getString("username");
				passwordcurrent = rs.getString("password");
				if((usernamecurrent + passwordcurrent).equals(a + b) ) {
					user = true;
					//what should do when user logs in
					
					output = "user";
				}}
			
			if(user == false) {
				rs = stmt.executeQuery(querya);
				while(rs.next()) {
					usernamecurrent = rs.getString("username");
					passwordcurrent = rs.getString("password");
					if((usernamecurrent + passwordcurrent).equals(a + b) ) {
						admin = true;
						//what should do when admin logs in
						
						output =  "admin";
						
					}}
				
				if(admin == false) {
					rs = stmt.executeQuery(querys);
					while(rs.next()) {
						usernamecurrent = rs.getString("username");
						passwordcurrent = rs.getString("password");
						if((usernamecurrent + passwordcurrent).equals(a + b) ) {
							staff = true;
							//what should do when staff logs in
						
							output = "staff";
						}}
				
				}
			}
			if(user == false && admin==false && staff==false) {
				System.out.println("Incorrect username/password");
				//what it should do if username/password is incorrect
				
				output = "invalid";
			}
				conn.close();
			
			
			
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println(e);
		
	}
		return output;
	
		
	}


	public static void registerUserPassUser(String username, String password, String phone, String name, String adress, String woonplaats) throws Exception{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success");
			String query = "INSERT INTO customers (name, username, password, phone, adress, city)\r\n" + 
					"VALUES (?, ?, aes_encrypt(?, 'b/_W-u+c6>=V]UF'), ?, ?, ?)";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setString(1, name);
			ptmt.setString(2, username);
			ptmt.setString(3, password);
			ptmt.setString(4, phone);
			ptmt.setString(5, adress);
			ptmt.setString(6, woonplaats);
			ptmt.executeUpdate();
			System.out.println("User added successfully!");
			conn.close();
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println(e);
		
		}
	}
	public static void registerUserPassAdmin(String username, String password) throws Exception{
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
		System.out.println("Connection success!");
		String query = "INSERT INTO admins (username, password) VALUES(?, aes_encrypt(?, 'b/_W-u+c6>=V]UF'))";
		PreparedStatement ptmt = conn.prepareStatement(query);
		ptmt.setString(1, username);
		ptmt.setString(2, password);
		ptmt.executeUpdate();
		System.out.println("Admin successfully added to the db!");
		conn.close();
		}catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void registerUserPassStaff(String username, String password) throws Exception{
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
		System.out.println("Connection success!");
		String query = "INSERT INTO staff (username, password) VALUES(?, aes_encrypt(?, 'b/_W-u+c6>=V]UF'))";
		PreparedStatement ptmt = conn.prepareStatement(query);
		ptmt.setString(1, username);
		ptmt.setString(2, password);
		ptmt.executeUpdate();
		System.out.println("Staff member successfully added to the db!");
		conn.close();
		}catch (Exception e) {
			System.err.println(e);
		}
	}public static int getIDofUser(String table, String username, String password) {
		int output = 0;
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT id FROM " + table + " WHERE username = ? AND aes_decrypt(password, 'b/_W-u+c6>=V]UF') = ?";
			PreparedStatement ptmt = conn.prepareStatement(query);
			//ptmt.setString(1, table);
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			ResultSet rs = ptmt.executeQuery();
			System.out.println("Succesfully executed query!");
			while(rs.next()) {
				output = rs.getInt("id");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
		
		
	}
	public static String getInfoFromDatabase(String info, int id, String table) {
		String output = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT * FROM " + table +" WHERE ID = ?";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			output = rs.getString(info);
		}
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static int getIntFromDatabase(String info, int id, String table) {
		int output = 0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT * FROM " + table +" WHERE ID = ?";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()) {
			output = rs.getInt(info);
		}
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static void placeOrder(int customer_id, double price, String deltake, String size, boolean cheese, boolean ham, boolean salami, boolean mushroom, boolean tuna, boolean extra_veg, boolean extra_meat) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "INSERT INTO orders (customer_id, price, current_status, deltake, size, cheese, ham, salami, mushroom, tuna, extra_veg, extra_meat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, customer_id);
			ptmt.setDouble(2, price);
			ptmt.setString(3, "Wordt verwerkt!");
			ptmt.setString(4, deltake);
			ptmt.setString(5, size);
			ptmt.setBoolean(6, cheese);
			ptmt.setBoolean(7, ham);
			ptmt.setBoolean(8, salami);
			ptmt.setBoolean(9, mushroom);
			ptmt.setBoolean(10, tuna);
			ptmt.setBoolean(11, extra_veg);
			ptmt.setBoolean(12, extra_meat);
			ptmt.executeUpdate();
			
			System.out.println("Order registered in the DB!");
			conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static int amountOfType(String type) {
		int output =0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT COUNT(*) FROM " + type;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				output = rs.getInt("COUNT(*)");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	public static double CalcPriceOrder(String calc) {
		double output =0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT ROUND("+calc+"(price),2) as 'orders' FROM orders";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				output = rs.getDouble("orders");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	public static int  amountOfCustomersOrdered() {
		int output =0;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT COUNT(DISTINCT customer_id) as 'customers' FROM orders";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				output = rs.getInt("customers");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static void setOrders_in_listView(ListView<String> list) {
		try {
			//PizzaS.listmodel.removeAllElements();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT * FROM orders";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			while(rs.next()){
				String ingredients = "";
				int id = rs.getInt("id");
				boolean cheese = rs.getBoolean("cheese");
				boolean ham = rs.getBoolean("ham");
				boolean salami = rs.getBoolean("salami");
				boolean mushroom = rs.getBoolean("mushroom");
				boolean tuna = rs.getBoolean("tuna");
				boolean extra_veg = rs.getBoolean("extra_veg");
				boolean extra_meat = rs.getBoolean("extra_meat");
				if(cheese) {
					ingredients = ingredients + " cheese; ";
				}
				if(ham) {
					ingredients = ingredients + " ham; ";
				}
				
				if(salami) {
					ingredients = ingredients + " salami; ";
				}
				
				if(mushroom) {
					ingredients = ingredients + " mushroom; ";
				}
				
				if(tuna) {
					ingredients = ingredients + "  tuna; ";
				}
				if(extra_veg) {
					ingredients = ingredients + " extra vegatables; ";
				}
				if(extra_meat) {
					ingredients = ingredients + " extra meat; ";
				}
				String output = String.valueOf(id) + ", De bestellingsID is: " + String.valueOf(rs.getInt("id")) + " en de klant heeft gekozen voor: " + rs.getString("deltake") +". En wil een "
				 + rs.getString("size") + " pizza met: " + ingredients + ".";
				System.out.println(output);
				list.getItems().add(output);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateStatusOrder(String status, int id) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "UPDATE orders SET current_status = ? WHERE id= ?";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setString(1, status);
			ptmt.setInt(2, id);
			ptmt.executeUpdate();
			System.out.println("Status updated!");
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getStatusOrder(int id) {
		String output = "";
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza", "root", "");
			System.out.println("Connection success!");
			String query = "SELECT current_status FROM orders WHERE customer_id = ? ORDER BY id LIMIT 1";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
			output = rs.getString("current_status");
			}
			System.out.println("Status updated!");
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return output;
	}

	
	
}