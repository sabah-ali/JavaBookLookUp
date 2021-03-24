package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
import java.io.OutputStream;
import java.io.*;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedWriter;
import java.io.IOException;

public class EditHashMap implements HttpHandler{
		  public void handle(HttpExchange he) throws IOException {
		   
		    System.out.println("In EditHashMap");
		    BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		    String line;
		    
			String request = "";
		    while( (line = in.readLine()) != null ){
		      request = request + line;
		    }
		    System.out.println("request is " +request);
		    
		    HashMap<String,String> map = Util.requestStringToMap(request);

		    System.out.println(map);    

		  //get ID number
		  
	        int ID = Integer.parseInt(map.get("id"));
		    
	        System.out.println(ID);
	        String line1;
	        String request1 = "";
	        while( (line1 = in.readLine()) != null) {
	            request1 = request1 + line1;
	        }
	        HashMap<String, String> map1 = Util.requestStringToMap(request1);
	        //assign form inputs
	        String idst = map1.get("id");
	        int id = Integer.parseInt(idst);
	        String title = map1.get("title");
	        String author = map1.get("author");
	        String yearst = map1.get("year");
	        int year = Integer.parseInt(yearst);
	        String editionst = map1.get("edition");
	        int edition = Integer.parseInt(editionst);
	        String publisher = map1.get("publisher");
	        String isbn = map1.get("isbn");
	        String cover = map1.get("cover");
	        String condition = map1.get("condition");
	        String pricest = map1.get("price");
	       int price = Integer.parseInt(pricest);
	        String notes = map1.get("notes");       
	       
	        Book EditBook;
	        
		    BufferedWriter out = new BufferedWriter(  
		        new OutputStreamWriter(he.getResponseBody() ));
		     
		     he.sendResponseHeaders(200,0);
		      out.write(
		      
		    		  "<h1>hello</h1>"
		    		  
		      );

		      
		      for (String key: map1.keySet()){
		          out.write(
		          "<tr>"+
		          "<td>" + key + "</td>" +
		          "<td>" + map1.get(key) + "</td>"+
		          "</tr>"); 

		        }



		        out.write(
		        "</table>" +
		        "<a href=\"/\"> click here </a" +   
		        "</body>" +
		        "</html>");
		      
		      out.close();
		      

		    }

		  
	}


