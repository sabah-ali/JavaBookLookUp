package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.util.ArrayList;
import java.sql.SQLException;
import java.io.BufferedWriter;
import java.io.IOException;
public class AdminTable implements HttpHandler{
	  public void handle(HttpExchange he) throws IOException {
		  String response = "Welcome to OOP";
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    BookDao Book = new BookDao();
		try {
			ArrayList<Book> allBook = Book.getAllBooks();
	   
	    out.write("<html>" +
			      "<head> <title>Book Library</title> "+
			         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
			         "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.15.1/css/all.css\" integrity=\"sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp\" crossorigin=\"anonymous\">" +
			         "</head>" +
					      "<body>" +
			         "<div class=\"/ text-center\">"+
					      "<h1> Books in Stock!</h1>"+
					      "<h3> Admin Access Page </h3>"+
					      "</div>"+
					      "<div class=\"d-flex justify-content-between\">" +
					      "<a class=\"/btn btn-primary btn-sm md-2\" href=\"/RootHandler\">Log Out</a>"+
					      "<a class=\"/ btn btn-primary btn-sm md-2\" href=\"/newBookForm\">New record</a>" +
						" </div> " +
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
					      "<tbody>" 
					      
			
					      
				);

	      for (Book b : allBook){
	        out.write(
	      "  <tr>"       +
	      "    <td>"+ b.getID() +  "</td>" +
	      "    <td>"+ b.getTitle() + "</td>" +
	      "    <td>"+ b.getAuthor() +  "</td>" +
	      "    <td>"+ b.getYear() +  "</td>" +
	      "    <td>"+ b.getEdition() + "</td>" +
	      "    <td>"+ b.getPublisher() +  "</td>" +
	      "    <td>"+ b.getISBN() + "</td>" +
	      "    <td>"+ b.getCover() +  "</td>" +
	      "    <td>"+ b.getCondition() + "</td>" +
	      "    <td>"+ b.getPrice() + "</td>" +
	      "    <td>"+ b.getNotes() +  "<div class=\"/mt-3\"> "+"<a class=\"/ btn btn-primary btn-sm md-2\" href=\"/edit?id=" + b.getID() + "\"><i class=\"fas fa-edit\"></i></a>" + "<a class=\"/btn btn-primary btn-sm md-2 \"href=\"/delete?id=" + b.getID() + "\"><i class=\"fas fa-trash-alt\"></i></a>" + "</div>" + "</td>" +
	      "  </tr>" 
	        );
	      }
	      out.write(
	      "</tbody>" +
	      "</table>" +
	      "</body>" +
	      "</html>");
	     }catch(SQLException se){
	      System.out.println(se.getMessage());
	    }
	    out.close();

	  }

	}

