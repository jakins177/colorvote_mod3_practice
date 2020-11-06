package com.geektechnique.colorvote.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.client.MongoCursor;



public class ColorDataBase {
	String url;
	String user;
	String password;
	
	public ColorDataBase() {
		super();
		this.url = "jdbc:postgresql://localhost:5432/BestPrimaryColorDB";
		this.user = "postgres";
		this.password = "admin";
		

	}
	
	
	
	
	
public int getRedCount() {
		
		int theTotal = 0;
		Connection c = null;

		   Statement stmt = null;

		   try {

		      Class.forName("org.postgresql.Driver");

		      c = DriverManager.getConnection(this.url,this.user, this.password);

//		     c.setAutoCommit(false);

		      System.out.println("Successfully Connected.");

		      


		      stmt = c.createStatement();

		      ResultSet rs = stmt.executeQuery( "SELECT COUNT(*) AS total FROM red_votes" );

		      while ( rs.next() ) {

		        

		        // String  name = rs.getString("name");
		         
		        theTotal = rs.getInt("total");

		        
		      }

		      rs.close();

		      stmt.close();

		      c.close();

		   } catch ( Exception e ) {

		      System.err.println( e.getClass().getName()+": "+ e.getMessage() );

		     // System.exit(0);

		   }

		   System.out.println(" Data Retrieved Successfully ..");

		return theTotal;
	}
	
	
public int getBlueCount() {
		
		int theTotal = 0;
		Connection c = null;

		   Statement stmt = null;

		   try {

		      Class.forName("org.postgresql.Driver");

		      c = DriverManager.getConnection(this.url,this.user, this.password);

//		     c.setAutoCommit(false);

		      System.out.println("Successfully Connected.");

		      


		      stmt = c.createStatement();

		      ResultSet rs = stmt.executeQuery( "SELECT COUNT(*) AS total FROM blue_votes" );

		      while ( rs.next() ) {

		        

		        // String  name = rs.getString("name");
		         
		        theTotal = rs.getInt("total");

		        
		      }

		      rs.close();

		      stmt.close();

		      c.close();

		   } catch ( Exception e ) {

		      System.err.println( e.getClass().getName()+": "+ e.getMessage() );

		     // System.exit(0);

		   }

		   System.out.println(" Data Retrieved Successfully ..");

		return theTotal;
	}
	
	
	public int getYellowCount() {
		
		int theTotal = 0;
		Connection c = null;

		   Statement stmt = null;

		   try {

		      Class.forName("org.postgresql.Driver");

		      c = DriverManager.getConnection(this.url,this.user, this.password);

//		     c.setAutoCommit(false);

		      System.out.println("Successfully Connected.");

		      stmt = c.createStatement();

		      ResultSet rs = stmt.executeQuery( "SELECT COUNT(*) AS total FROM yellow_votes" );

		      while ( rs.next() ) {

		        

		        // String  name = rs.getString("name");
		         
		        theTotal = rs.getInt("total");

		        
		      }

		      rs.close();

		      stmt.close();

		      c.close();

		   } catch ( Exception e ) {

		      System.err.println( e.getClass().getName()+": "+ e.getMessage() );

		     // System.exit(0);

		   }

		   System.out.println(" Data Retrieved Successfully ..");

		return theTotal;
	}
	
	
	public void createUserBlue(String userName) {
		this.createUserRecord(userName);
		
		 String username = userName;
	        String query = "INSERT INTO blue_votes(name) VALUES(?)";

	        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
	             PreparedStatement pst = con.prepareStatement(query)) {
	            
	           // pst.setInt(1, id);
	            pst.setString(1, username);
	            pst.executeUpdate();

	        } catch (SQLException ex) {

	            System.out.println(ex.getMessage());
	        }
	}
	
	public void createUserYellow(String userName) {
		this.createUserRecord(userName);
		
		 String username = userName;
	        String query = "INSERT INTO yellow_votes(name) VALUES(?)";

	        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
	             PreparedStatement pst = con.prepareStatement(query)) {
	            
	           // pst.setInt(1, id);
	            pst.setString(1, username);
	            pst.executeUpdate();

	        } catch (SQLException ex) {

	            System.out.println(ex.getMessage());
	        }
		
	}
	
	
	
	public void createUserRed(String userName) {
		this.createUserRecord(userName);
		
		 String username = userName;
	        String query = "INSERT INTO red_votes(name) VALUES(?)";

	        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
	             PreparedStatement pst = con.prepareStatement(query)) {
	            
	           // pst.setInt(1, id);
	            pst.setString(1, username);
	            pst.executeUpdate();

	        } catch (SQLException ex) {

	            System.out.println(ex.getMessage());
	        }
	
	
	}
		
	public void createUserRecord(String userName) {   
        String username = userName;
        String query = "INSERT INTO users(name) VALUES(?)";

        try (Connection con = DriverManager.getConnection(this.url, this.user, this.password);
             PreparedStatement pst = con.prepareStatement(query)) {
            
           // pst.setInt(1, id);
            pst.setString(1, username);
            pst.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
		
		
		
		

	}
	
	
	
	public List<User> checkForDupes(String userNameToCheck)
	{
		List<User> userList = new ArrayList<>();
		Connection c = null;

		   Statement stmt = null;

		   try {

		      Class.forName("org.postgresql.Driver");

		      c = DriverManager.getConnection(this.url,this.user, this.password);

//		     c.setAutoCommit(false);

		      System.out.println("Successfully Connected.");



		      stmt = c.createStatement();

		      ResultSet rs = stmt.executeQuery( "SELECT * from users WHERE name = '" + userNameToCheck + "';" );

		      while ( rs.next() ) {

		        

		         String  name = rs.getString("name");
		         
		        userList.add(new User(name));

		        
		      }

		      rs.close();

		      stmt.close();

		      c.close();

		   } catch ( Exception e ) {

		      System.err.println( e.getClass().getName()+": "+ e.getMessage() );

		      System.exit(0);

		   }

		   System.out.println(" Data Retrieved Successfully ..");


		   return userList;

	}
	
	public List<User> getAllUserRecords() {
		
		List<User> userList = new ArrayList<>();
		Connection c = null;

		   Statement stmt = null;

		   try {

		      Class.forName("org.postgresql.Driver");

		      c = DriverManager.getConnection(this.url,this.user, this.password);

//		     c.setAutoCommit(false);

		      System.out.println("Successfully Connected.");



		      stmt = c.createStatement();

		      ResultSet rs = stmt.executeQuery( "select * from users;" );

		      while ( rs.next() ) {

		        

		         String  name = rs.getString("name");
		         
		        userList.add(new User(name));

		        
		      }

		      rs.close();

		      stmt.close();

		      c.close();

		   } catch ( Exception e ) {

		      System.err.println( e.getClass().getName()+": "+ e.getMessage() );

		      System.exit(0);

		   }

		   System.out.println(" Data Retrieved Successfully ..");


//		List<Person> personList = new ArrayList<>();
//
//		MongoCursor<Document> cursor = collection.find().iterator();
//		try {
//			while (cursor.hasNext()) {
//				String documentString = cursor.next().toJson();
//
//				System.out.println(documentString);
//
//				// JSON Parse Example
//
//				JSONObject obj = new JSONObject(documentString);
//
//				System.out.println("the obj is: " + obj);
//				String userID = obj.getString("id");
//				String name = obj.getString("name");
//				// String mongoID = obj.getJSONObject("_id").getString("$oid");
//
//				System.out.println("the user ID is " + userID);
//				System.out.println("the user Name is " + name);
//
//				UUID userUUID = UUID.fromString(userID);
//
//				personList.add(new Person(userUUID, name));
//
//			}
//		}
//
//		finally {
//			cursor.close();
//		}
//
//		return personList;
		
		return userList;
	}
	
	
	
	
	
	
	public void testConnection()
	{
	
		try(Connection connection = DriverManager.getConnection(this.url, this.user, this.password);){
			if(connection != null) {
				System.out.println("Connected to PostgreSQL server succesfully!" );
			}else {
				System.out.println("Failed to connect to PostgesSQL server" );
				
			}
			
			Statement statment = connection.createStatement();
			ResultSet resultSet = statment.executeQuery("SELECT VERSION()");
			
			if(resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
