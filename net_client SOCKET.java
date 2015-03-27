import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

import java.net.HttpURLConnection;
import javax.net.SocketFactory;








public class net_client{


Timer xtimerx;//class loop.
Toolkit toolkit;



net_client(){//*****************************************************************



request_status();



}//*****************************************************************************














public void request_status(){//*****************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();
obj.put(lm.program_id, "connect");
obj.put("password", lm.passx);

StringWriter out = new StringWriter();
obj.writeJSONString(out);
jsonText = out.toString();
System.out.println(jsonText);

}catch(Exception e){System.out.println("JSON ERROR");}




try{

String sentence;   
String modifiedSentence;   

BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in) );
System.out.println(">>> " + lm.httpx + " " + "80");

//Socket clientSocket = new Socket(lm.httpx, lm.client_port);

	SocketFactory factory = lm.tor.getSocketFactory();
   	Socket clientSocket = factory.createSocket(lm.httpx, 80);//lm.client_port
 
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    
sentence = jsonText;  
outToServer.writeBytes(sentence + '\n');   
modifiedSentence = inFromServer.readLine();   
System.out.println("FROM SERVER: " + modifiedSentence);
clientSocket.close();


    if(modifiedSentence.contains("Offline 400")){JOptionPane.showMessageDialog(null, "SERVER IS OFFLINE");}
    else{



	JSONParser parser = new JSONParser();

	try {//*********************************************************
 

		Object obj = parser.parse(modifiedSentence);
 
		JSONObject jsonObject = (JSONObject) obj;
  
		String request = (String) jsonObject.get("response");
		String inventory = (String) jsonObject.get("inventory");
		String idx = (String) jsonObject.get("idx");

		System.out.println(request);
		System.out.println(inventory);
		System.out.println(idx);

		if(request.equals("1")){lm.connection_active = 1; JOptionPane.showMessageDialog(null, "Connected To:\n" + idx + "\nInventory (" + inventory + " items)");}
		else{lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Server ID mismatch");}


	}//try
	catch (ParseException e){e.printStackTrace(); lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Connection failure!");}



    }//else



}catch(Exception e){e.printStackTrace(); lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Cannot find a host!"); lm.error_codes_client = e.getMessage();}

}//*********************************************************************************************











}//last
