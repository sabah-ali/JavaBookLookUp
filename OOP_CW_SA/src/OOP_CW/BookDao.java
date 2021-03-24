package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDao {

	// creating the BookDao to read the sql file and creating the connection.

	public BookDao() {}
	   
	   private static Connection getDBConnection() {
		   Connection dbConnection = null;
		   try {
			   Class.forName("org.sqlite.JDBC");
		   } catch (ClassNotFoundException e){
			   System.out.println(e.getMessage());
		   }
		   try {
			   String dbURL = "jdbc:sqlite:Books.db";
			   dbConnection = DriverManager.getConnection(dbURL);
			   return dbConnection;
		   } catch (SQLException e) {                                                                                                                                                                                                              
			   System.out.println(e.getMessage());
		   }
		   return dbConnection;
	   }
	   //Getting books from the books database
	   
	   public ArrayList<Book> getAllBooks() throws SQLException {
		   System.out.println("Retrieving all Books... ");
		   Connection dbConnection = null;
		   Statement statement = null;
		   ResultSet result = null;
		   String query ="SELECT * FROM Book;";
		   ArrayList<Book> books = new ArrayList<>();
		   
		   try {
			   dbConnection = getDBConnection();
			   statement = dbConnection.createStatement();
			   System.out.println("DBQuery = " + query);
			   result = statement.executeQuery(query);  // Execute SQL query and record response to string
			   while (result.next()) {
				   int ID = result.getInt("id");
				   String title = result.getString("Title");
				   String author = result.getString("Author");
				   int edition = result.getInt("Edition");
				   String publisher = result.getString("Publisher");
				   int year = result.getInt("Year");
				   int price = result.getInt("Price");
				   String isbn = result.getString("ISBN");
				   String cover = result.getString("Cover");
				   String condition = result.getString("Condition");
				   String notes = result.getString("Notes");
				   
				   books.add(new Book (ID, title, author, year, edition, publisher, isbn, cover, condition, price, notes));
				   
				   
			   } 
				   } catch(Exception e) { System.out.println("Get all books: " + e );
				   }
		   finally {
					   if (result != null) {
							result.close();
						}
						if (statement != null) {
							statement.close();
						}
						if (dbConnection != null) {
							dbConnection.close();
						}
					   
				   }
				   return books;
		   
			   
		   }
	   
	   // Getting a book from the database via id
		   
	   public Book getBook (int id) throws SQLException {
		   Book temp = null;
		   Connection dbConnection = null;
		   Statement statement = null;
		   ResultSet result = null;
		   
		   String query ="SELECT * FROM Book WHERE ID = " + id + ";";
		   
		   try {
			   dbConnection = getDBConnection();
			   statement = dbConnection.createStatement();
			   System.out.println("DBQuery: " + query);
			   // execute SQL query
			   result = statement.executeQuery(query);
			   
			   while (result.next()) {
				   int ID = result.getInt("id");
				   String title = result.getString("Title");
				   String author = result.getString("Author");
				   int edition = result.getInt("Edition");
				   String publisher = result.getString("Publisher");
				   int year = result.getInt("Year");
				   int price = result.getInt("Price");
				   String isbn = result.getString("ISBN");
				   String cover = result.getString("Cover");
				   String condition = result.getString("Condition");
				   String notes = result.getString("Notes");
				   
				   
					
					temp = new Book(ID, title, author, year, edition, publisher, isbn, cover, condition, price, notes);

				   
			   }
		   } 
		   finally {
				if (result != null) {
					result.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
	   }
		   return temp; 
	   }
	   
	   // Deleting a book from the database via id
		   
		 public Boolean deleteBook(int id) throws SQLException {
			 System.out.println("Deleting Book");
			 Connection dbConnection = null;
			 Statement statement = null;
			 int result = 0;
			 String query = "DELETE FROM Book WHERE ID = " + id + ";";
			 
			 try {
				 dbConnection = getDBConnection();
				 statement = dbConnection.createStatement();
				 System.out.println(query);
				 // execute SQL query
				 result = statement.executeUpdate(query);
			 } finally {
				 if (statement != null) {
					 statement.close();
				 }
				 if (dbConnection != null) {
					 dbConnection.close();
				 }
				 
			 }
			 if (result == 1) {
				 return true;
			 } else {
				 return false;
			 }
			 
		 	}
		// Updating a book from the database 
		 public Boolean updateBook(Book book) throws SQLException {
			 Connection dbConnection = null;
			 Statement statement = null;
			 String query = "UPDATE Book" + " SET ID = '" + book.getID() + "'," + "Title = '" + book.getTitle()
		 	+ "'," + "Author = '" + book.getAuthor() + "'," + "Year = " + book.getYear() + ", Edition = " + book.getEdition() + "," 
					 + "Publisher = '" + book.getPublisher() + "'," + "ISBN = '" + book.getISBN() + "'," + "Cover = '" + book.getCover() + "',"
					 + "Condition = '" + book.getCondition() + "'," + "Price = " + book.getPrice() + "," + "Notes = '" + book.getNotes() + "'"+" WHERE ID = " + book.getID()
						+ ";";
			 try { 
				 dbConnection = getDBConnection();
				 statement = dbConnection.createStatement();
				 System.out.println(query);
				 // execute SQL update
				 statement.executeUpdate(query);
			 } catch (SQLException e) { 
				 System.out.println(e.getMessage());
				 return false;
		 
		 } finally {

				if (statement != null) {
					statement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
		 
		 
		 }  return true;
		 
		 }
		 
		// Adding a book from the database 
		 public boolean addBook(Book in) throws SQLException{
			 Connection dbConnection = null;
			 Statement statement = null;
			 String update = "INSERT INTO Book (ID, Title, Author, Year,Edition, Publisher, ISBN, Cover, Condition, Price, Notes) VALUES ("+in.getID()+",'"+in.getTitle()+ "','"+ in.getAuthor() + "'," +in.getYear()+","+in.getEdition()+ ",'" + in.getPublisher()+ "','" + in.getISBN() + "','" + in.getCover() + "','" + in.getCondition() + "'," + in.getPrice()+ ",'" + in.getNotes()+"');"; 
				boolean ok = false;
			 try {
				 dbConnection = getDBConnection();
				 statement = dbConnection.createStatement();
				 System.out.println(update);
				 //execute SQL query 
				 statement.executeUpdate(update);
				 ok = true;
			 } catch (SQLException e) {
				 System.out.println(e.getMessage());
			 } finally {
				 if(statement != null) {
					 statement.close();
				 }
				 if (dbConnection != null) {
					 dbConnection.close();
				 }
			 }
			 return ok;
		 }
		 
		// Inserting a book to the database 
		 public boolean insertRecordIntobookTable(Book in) throws SQLException { 
			 Connection dbConnection = null;
			 Statement statement = null;
			 
			 String update = "INSERT INTO Book (ID, Title, Author, Year,Edition, Publisher, ISBN, Cover, Condition, Price, Notes) VALUES ("+in.getID() +",'"+ in.getTitle() + "','" + in.getAuthor() + "'," +in.getYear()+","+in.getEdition()+ ",'" + in.getPublisher()+ "','" + in.getISBN() + "','" + in.getCover() +"','" + in.getCondition() + "'," + in.getPrice()+ ",'" + in.getNotes()+"');"; 
				boolean ok = false;
				try { 
					dbConnection = getDBConnection();
					statement = dbConnection.createStatement();
					System.out.println(update);
					//execute SQL query 
					
					statement.executeUpdate(update);
					ok = true;
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					} 
				finally {
					if (statement != null) {
						statement.close();
					}
					if (dbConnection != null) {
						dbConnection.close();
					}
					
				}
			return ok;
		 }
		 
		 // retrieving the user name and password from the database for the log in
		 public ArrayList<Users> getAllUsers() throws SQLException {
			   System.out.println("Retrieving all Users... ");
			   Connection dbConnection = null;
			   Statement statement = null;
			   ResultSet result = null;
			   String query ="SELECT * FROM Users;";
			   ArrayList<Users> User = new ArrayList<>();
			   
			   try {
				   dbConnection = getDBConnection();
				   statement = dbConnection.createStatement();
				   System.out.println("DBQuery = " + query);
				   result = statement.executeQuery(query);  // Execute SQL query and record response to string
				   while (result.next()) {
					   
					   String UserName = result.getString("UserName");
					   String Password = result.getString("Password");
					   
						  User.add(new Users (UserName, Password));
				
					   
					   
				   } 
					   } catch(Exception e) { System.out.println("Get all Users: " + e );
					   }
			   finally {
						   if (result != null) {
								result.close();
							}
							if (statement != null) {
								statement.close();
							}
							if (dbConnection != null) {
								dbConnection.close();
							}
						   
					   }
					   return User;
			   
				   
			   }
			   
		 //getting the user and password 
			   public boolean getUser (String UserName, String Password) throws SQLException {
				   boolean temp = false;
				   Connection dbConnection = null;
				   Statement statement = null;
				   ResultSet result = null;
				   
				   String query ="SELECT * FROM Users WHERE UserName = " + UserName + ";";
				   
				   try {
					   dbConnection = getDBConnection();
					   statement = dbConnection.createStatement();
					   System.out.println("DBQuery: " + query);
					   // execute SQL query
					   result = statement.executeQuery(query);
					   
					   while (result.next()) {
						   
						   String UserName1 = result.getString("UserName");
						   String Password1 = result.getString("Password");
						   
						  System.out.println(UserName1);
						  System.out.println(Password1);
						  
						  if(Password1.equals(Password1)) {
							  System.out.println("Password correct" + UserName1);
							  temp = true;
							  
						  }
						  else {
							  System.out.println("UserName and Password incorrect, try again");
							  temp= false;
						  }
							
					   }
				   } 
				   finally {
						if (result != null) {
							result.close();
						}
						if (statement != null) {
							statement.close();
						}
						if (dbConnection != null) {
							dbConnection.close();
						}
			   }
				   return temp;
			   
		   }
		   
		  
		   
}
