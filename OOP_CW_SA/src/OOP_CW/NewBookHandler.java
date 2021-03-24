package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class NewBookHandler implements HttpHandler  {
	public void handle(HttpExchange he) throws IOException{
		System.out.println("NewBookHandler...");
		BufferedReader in  = new BufferedReader(new InputStreamReader (he.getRequestBody()));
		String line;
		String request = "";
		while((line = in.readLine()) !=null) {
			request = request + line;
			
		}
		
		System.out.println("request is " +request);
	
		// Creating a HashMap
		
		HashMap<String, String> map = Util.requestStringToMap(request);
		
		System.out.println(map);
		
		//Adding to the HashMap
		String IDst = map.get("id");
        int ID = Integer.parseInt(IDst);
        String Title = map.get("Title");
        String Author = map.get("Author");
        String Yearst = map.get("Year");
        int Year = Integer.parseInt(Yearst);
        String Editionst = map.get("Edition");
        int Edition = Integer.parseInt(Editionst);
        String Publisher = map.get("Publisher");
        String ISBN = map.get("ISBN");
        String Cover = map.get("Cover");
        String Condition = map.get("Condition");
        String Pricest = map.get("Price");
        int Price = Integer.parseInt(Pricest);
        String Notes = map.get("Notes");       
       
        
        
        //
        BookDao books = new BookDao();
        Book addBook = new Book(ID,Title,Author,Year,Edition,Publisher,ISBN,Cover,Condition,Price,Notes);
        System.out.println(addBook);
        System.out.println(map);
        System.out.println("Adding new book");
        
        try {
        	books.addBook(addBook);
        System.out.println();
        
        
        
        	he.sendResponseHeaders(200, 0);
            BufferedWriter out  = new BufferedWriter(new OutputStreamWriter (he.getResponseBody()));
            System.out.println(request);
            
            out.write(
          	      "<html>" +
          	      "<head> <title>Book Library</title> "+
          	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
          	      "</head>" +
          	      "<body>" +
          	      "<h1> Book Deleted</h1>"+
          	      "<table class=\"table\">" +
          	      "<thead>" +
          	      "  <tr>" +
          	      "    <th>ID</th>" +
          	      "    <th>Title</th>" +
          	      "    <th>Author</th>" +
          	      "    <th>Year</th>" +
          	      "    <th>Editon</th>" +
          	      "    <th>Publisher</th>" +
          	      "    <th>ISBN</th>" +
          	      "    <th>Cover</th>" +
          	      "    <th>Condition</th>" +
          	      "    <th>Price(&pound;)</th>" +
          	      "    <th>Notes</th>" +
          	      "  </tr>" +
          	      "</thead>" +
          	      "<tbody>");

            out.write(
          	      "  <tr>"       +
          	      "    <td>"+ addBook.getID() + "</td>" +
          	      "    <td>"+ addBook.getTitle() + "</td>" +
          	      "    <td>"+ addBook.getAuthor() + "</td>" +
          	      "    <td>"+ addBook.getYear() + "</td>" +
          	      "    <td>"+ addBook.getEdition() + "</td>" +
          	      "    <td>"+ addBook.getPublisher() + "</td>" +
          	      "    <td>"+ addBook.getISBN() + "</td>" +
          	      "    <td>"+ addBook.getCover() + "</td>" +
          	      "    <td>"+ addBook.getCondition() + "</td>" +
          	      "    <td>"+ addBook.getPrice() + "</td>" +
          	      "    <td>"+ addBook.getNotes() + "</td>" +
          	      "  </tr>" 
          	        );


            
            out.write(
            	      "</tbody>" +
            	      "</table>" +
            	      "<a href=\"/\">Back to List </a>"+
            	      "</body>" +
            	      "</html>");
	
              out.close();
        }catch (SQLException se) {
        	System.out.println(se.getMessage());
        }

     
        	
	}
        
	}


	

