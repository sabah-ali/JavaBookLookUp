package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;
import com.sun.net.httpserver.HttpServer;


import java.net.InetSocketAddress;

import java.io.IOException;

public class Main {
	  static final private int PORT = 8080;

	public static void main(String[] args) throws SQLException, IOException  {
		Scanner in = new Scanner(System.in);
		String selection ;
		BookDao book = new BookDao();
		
		System.out.println("Hello world!");

	    HttpServer server = HttpServer.create(new InetSocketAddress(PORT),0);

	    server.createContext("/", new RootHandler()); 
	    server.createContext("/login",new LoginForm());
	    server.createContext("/admin", new AdminTable()); 
	    server.createContext("/edit", new EditHandler()); 
	    server.createContext("/formaction", new FormProcessHandler());
	    server.createContext("/delete", new DeleteHandler()); 
	    server.createContext("/editMap", new EditHashMap());
	    server.createContext("/newBook", new NewBookHandler());
	    server.createContext("/newBookForm", new NewBookForm());
	    server.setExecutor(null);
	    server.start();
	    System.out.println("The server is listening on port " + PORT);
	    
		//Console commands
	    
		do {
		  System.out.println("--------------------");
	      System.out.println("Book Inventory");
	      System.out.println("Choose from these options");
	      System.out.println("--------------------");
	      System.out.println("[1] List all Books");
	      System.out.println("[2] Search Books by ID");
	      System.out.println("[3] Add a new Books");
	      System.out.println("[4] Update a Book by ID");
	      System.out.println("[5] Delete a Book by ID");
	      System.out.println("[6] Exit");
	      System.out.println();
	      
	      selection = in.nextLine();
	      
	      
	      switch (selection) {
	      case "1":
	    	  System.out.println("List Books");
	    	  ArrayList<Book> allbook = book.getAllBooks();
	    	  for (int i = 0; i < allbook.size(); i++) {
	    		  System.out.println(allbook.get(i));
	    	  }
	    	  System.out.println();
	    	  break;
	      case "2":
	    	  System.out.println("\nEnter Book id to get details");
	    	  int ID = Integer.parseInt(in.nextLine());
	    	  System.out.println(book.getBook(ID));
	    	  System.out.println();
	    	  break;
	      case "3":
	    	  System.out.println("Add a new Book");
	    	  Book Book = createBook();
	    	  book.addBook(Book);
	    	  System.out.println();
	    	  break;
	      case "4":
	    	  System.out.println("Update a new Book");
	    	  System.out.println("\n Enter Book id to update ");
	    	  int uID = Integer.parseInt(in.nextLine());
	    	  System.out.println(book.getBook(uID));
	    	  Book updatedBook = updateBook(book.getBook(uID));
	    	  book.updateBook(updatedBook);
	    	  break;
	      case "5":
	    	  System.out.println("Delete a Book");
	    	  System.out.println("Enter ID of Book to delete");
	          int dID = Integer.parseInt(in.nextLine());
	          book.deleteBook(dID);
	    	  break;
	      case "6":
	    	  System.out.println("Exit");
	    	  break;
	    	  default:
	    		  System.out.println("Invalid Selection!");
	    		  
	    	  
	      		}
	      
	      } while (!selection.equals("6"));
		
         BookDao Book = new BookDao();
		
		ArrayList<Book> coll = new ArrayList<Book>();
		
		try {
		coll = Book.getAllBooks();
		for(int i =0; i < coll.size() ; i++) {
			System.out.println(coll.get(i));
    }
		
		Book in1 = new Book(21, "House Of Cards: Screenplay", "Chris Sauer", 2020, 1, "Independently published ","979-8568049197", "Paperback", "New", 6, "Fairly new book, based on the series");
		Book.insertRecordIntobookTable(in1);

		in1 = new Book(22, "Billion Dollar Loser: The Epic Rise and Fall of WeWork" , "Reeves Wiederman", 2020, 1, "Hodder and Stoughton", "978-1529385083", "Kindle edition", "New", 9,"Intresting read, similar to the bad blood book");
		book.insertRecordIntobookTable(in1);
		
    coll = Book.getAllBooks();
			for(int i =0; i < coll.size() ; i++) {
				System.out.println(coll.get(i));
			}
		
		Book.deleteBook(7);
		coll = Book.getAllBooks();
			for(int i =0; i < coll.size() ; i++) {
				System.out.println(coll.get(i));
			}
   


		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	
	// CREATE A NEW BOOK in the console
	private static Book createBook() {
	    
		int id;
		String title;
		String author;
		int year;
		int edition;
		String publisher;
		String isbn;
		String cover;
		String condition;
		int price;
		String notes;
		
	    Scanner in = new Scanner(System.in);
	    
	    System.out.println("Please enter Book ID");
	    id = Integer.parseInt(in.nextLine());
	    
	    System.out.println("Please enter Title");
	    title = in.nextLine();

	    System.out.println("Please enter Author");
	    author = in.nextLine();

	    System.out.println("Please enter year");
	    year = Integer.parseInt(in.nextLine());
	    ;

	    System.out.println("Please enter edition");
	    edition = Integer.parseInt(in.nextLine());
	    
	    System.out.println("Please enter publisher");
	    publisher = (in.nextLine());
	    
	    System.out.println("Please enter ISBN");
	    isbn = (in.nextLine());
	    
	    System.out.println("Please enter Cover");
	    cover = (in.nextLine());
	    
	    System.out.println("Please enter Condition");
	    condition = (in.nextLine());
	    
	    System.out.println("Please enter price");
	    price  = Integer.parseInt(in.nextLine());
	    
	    System.out.println("Please enter Notes");
	   notes = (in.nextLine());
	    

	    return new Book(id, title, author, year, edition, publisher, isbn , cover, condition, price, notes); 
	}
	
	//UPDATE A BOOK in the console
	
	private static Book updateBook(Book book) {
	    // TODO Auto-generated method stub
		int id;
		String title;
		String author;
		int year;
		int edition;
		String publisher ;
		String isbn;
		String cover;
		String condition;
		int price;
		String notes;

	    Scanner in = new Scanner(System.in);
	    System.out.println("Updating Book with ID:" + book.getID());
	    
	    System.out.println("Please enter Title");
	    title = in.nextLine();
	    if (title.equals(""))
	      title = book.getTitle();
	    
	    System.out.println("Please enter Author");
	    String strAuthor = in.nextLine();
	    if (strAuthor.equals(""))
	      author = book.getAuthor();
	    else
	      author = (strAuthor);
	    

	    System.out.println("Please enter year");
	    String strYear = in.nextLine();
	    if (strYear.equals(""))
	      year = book.getYear();
	    else
	      year = Integer.parseInt(strYear);

	    System.out.println("Please enter Edition");
	    String strEdition = in.nextLine();
	    if (strEdition.equals(""))
	      edition = book.getEdition();
	    else
	      edition = Integer.parseInt(strEdition);
	    
	    System.out.println("Please enter Publisher ");
	    String strPublisher = in.nextLine();
	    if (strPublisher.equals(""))
	      publisher = book.getPublisher();
	    else
	      publisher = (strPublisher);
	    
	    System.out.println("Please enter ISBN");
	    String strISBN = in.nextLine();
	    if (strISBN.equals(""))
	    	isbn = book.getISBN();
	    else
	      isbn = (strISBN);
	    
	    System.out.println("Please enter Cover");
	    String strCover = in.nextLine();
	    if (strCover.equals(""))
	      cover = book.getCover();
	    else
	      cover = (strCover);
	    
	    System.out.println("Please enter Condition");
	    String strCondition = in.nextLine();
	    if (strCondition.equals(""))
	      condition = book.getCondition();
	    else
	      condition = (strCondition);
	    
	    System.out.println("Please enter Price");
	    String strPrice = in.nextLine();
	    if (strPrice.equals(""))
	      price = book.getPrice();
	    else
	      price = Integer.parseInt(strPrice);
	    
	    System.out.println("Please enter Notes");
	    String strNotes = in.nextLine();
	    if (strNotes.equals(""))
	      notes = book.getNotes();
	    else
	      notes = (strNotes);

	    
	    
	 
	    return new Book(book.getID(), title, author, year, edition, publisher, isbn , cover, condition, price, notes); 
	  }

	
	
	}

	  



	

