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

public class FormProcessHandler implements HttpHandler{
  public void handle(HttpExchange he) throws IOException {
   
    System.out.println("In FormProcessHandler");
   
  
    BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
   
    String line;
    String request = "";
    while( (line = in.readLine()) != null ){
      request = request + line;
    }

    System.out.println("request is " +request);
    
    HashMap<String,String> map = Util.requestStringToMap(request);

    System.out.println(map);    


    BufferedWriter out = new BufferedWriter(  
        new OutputStreamWriter(he.getResponseBody() ));
     
     he.sendResponseHeaders(200,0);
      out.write(
      
    		  "<h1>hello</h1>"
    		  
      );

      
      for (String key: map.keySet()){
          out.write(
          "<tr>"+
          "<td>" + key + "</td>" +
          "<td>" + map.get(key) + "</td>"+
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