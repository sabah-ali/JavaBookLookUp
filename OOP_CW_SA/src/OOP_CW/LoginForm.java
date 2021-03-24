package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedWriter;
import java.io.IOException;
public class LoginForm implements HttpHandler{
	  public void handle(HttpExchange he) throws IOException {
		  String response = "Welcome to OOP";
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    
	   
	    out.write("<html>" +
			      "<head> <title>Login Page</title> "+
			         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
				"</head>" +
					      "<body>" +
					      "<h1> Log in Below</h1>"+
					      "<a href=\"/RootHandler\">Back to Book Libary</a>" +
					      "<form method=\"Get\" action=\"/admin\">"+
					      "<div class=\"/form-group\">"+
					      "<label for=\"/username\">Username:</label>"+
					      "<input type=\"/text\" class=\"/form-control\" id=\"/username\">" +
					      "</div>"+
					      "<div class=\"/form-group\">"+
					      "<label for=\"/psw\">Password:</label>"+
					      "<input type=\"/password\" class=\"/form-control\" id=\"/pws\">" +
					      "<button type=\"/submit\" class=\"/btn btn-primary\">Log in</button>"+
					      "</body>"+
					      "</html>"
					      );
	    
	    out.close();
	    
	  }
	  
	  
}
