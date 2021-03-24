package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditHandler implements HttpHandler {
	public void handle(HttpExchange he) throws IOException {
		String response = "Welcome to OOP";
		he.sendResponseHeaders(200, 0);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));

		BookDao Book = new BookDao();
		try {
	
			Map<String, String> parms = Util.requestStringToMap(he.getRequestURI().getQuery());

			// print the @param for debugging
			System.out.println(parms);

			// get ID number
			int ID = Integer.parseInt(parms.get("id"));
		
			Book EditBook = Book.getBook(ID);
			out.write("<html>" + "<head> <title>Book Library</title> "
					+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">"
					+ "</head>" + 
					"<body>" +
					"<h1> New Book Entry </h1>" + 
					"<form method=\"POST\" action=\"/newBook\">" + 
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
			
			out.write("  <tr>" +

				 "<td>" + EditBook.getID() + "</td>"  
					+ "<td>"
					+ "<input type=\"/text\" name=\"Title\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Author\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Year\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Edition\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Publisher\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"isbn\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Cover\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Condition\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Price\" value =\"\">" + "</td>" + "    <td>"
					+ "<input type=\"/text\" name=\"Notes\" value =\"\">" + "</td>" + "    <td>"
					+"<input type=\"submit\" value=\"Submit\">"  + "</td>" + "    <td>"
					+ "</tr>"

			);

			out.write("</tbody>" + "</table>" + "</form>" + "<a href=\"/\">Back to List </a>"
				+ "</body>" + "</html>");
			out.close();
			
			
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		out.close();

	}

}
