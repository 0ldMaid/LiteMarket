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







public class krypton_net_server{


Timer xtimerx;//class loop.
Toolkit toolkit;

String user_ip = new String("");

String client_address_connect = new String("127.0.0.1");
int client_port_connect = 0000;



krypton_net_server(){//*****************************************************************




toolkit = Toolkit.getDefaultToolkit();
xtimerx = new Timer();
xtimerx.schedule(new RemindTask_server(), 0);










}//*****************************************************************************













	class RemindTask_server extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************



	while(true){   


	try{          

	String jsonText = new String("");
	String responsex = new String("0");

	ServerSocket welcomeSocket = new ServerSocket(krypton.p2p_port, 0, InetAddress.getByAddress(new byte[] {0x00,0x00,0x00,0x00}) );          
	Socket connectionSocket = welcomeSocket.accept();
	user_ip = connectionSocket.getRemoteSocketAddress().toString();
	BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
	DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());             
	String clientSentence = inFromClient.readLine();
	String capitalizedSentence;   

	JSONParser parser = new JSONParser();

	try {



		responsex = "e000";

		Object obj = parser.parse(clientSentence);
 
		JSONObject jsonObject = (JSONObject) obj;
  
		String request = (String) jsonObject.get("request");
		System.out.println("get " + request);


		try{

		   String join_request = new String("");
		   if(request.equals("join")){join_request = (String) jsonObject.get("idx");}

		   String error_request = new String("");
		   if(request.equals("report")){error_request = (String) jsonObject.get("worker");}


			if(request.equals("status")){responsex = "active";}

			else if(request.equals("position")){responsex = Integer.toString(krypton.nodex_number);}

			else if(request.equals("idx")){responsex = krypton.settingsx[5];}

			else if(request.equals("network")){responsex = get_network();}

			else if(request.equals("providers")){responsex = get_providers();}

			else if(request.equals("join") && krypton.open_network == 1){responsex = join_network(join_request);}

			else if(request.equals("report")){responsex = error_node(error_request);}
	
			else{responsex = "e002";}



		}catch (Exception e) {e.printStackTrace(); responsex = "e100";}


	}catch (Exception e) {e.printStackTrace(); responsex = "e100";}



		JSONObject obj = new JSONObject();
		obj.put("response", responsex);

		StringWriter out = new StringWriter();
		obj.writeJSONString(out);
		jsonText = out.toString();
		System.out.println("SEND RESPONSE " + responsex);

           
	//System.out.println("SERVER GETS: " + clientSentence);             
	//capitalizedSentence = clientSentence.toUpperCase() + '\n';             
	outToClient.writeBytes(jsonText + '\n'); 


	welcomeSocket.close();

	}catch(Exception e){e.printStackTrace(); System.exit(0);}



	

         
	}//*****while




	}//runx***************************************************************************************************
        }//remindtask











	public String get_network(){

	String jsonarry = new String("");


		JSONObject objrx = new JSONObject();

		System.out.println("krypton.network " + krypton.network[0].length);

		for(int loop = 0; loop < 100; loop++){

			try{objrx.put(krypton.network[0][loop],krypton.network[1][loop] + "*" + krypton.network[2][loop]);}
			catch(Exception e){objrx.put(Integer.toString(loop),"null");}

		}//***********************************


		jsonarry = JSONValue.toJSONString(objrx);


	return jsonarry;

	}//*************************






	public String get_providers(){

	String jsonarry = new String("");


		JSONObject objrx = new JSONObject();

		System.out.println("krypton.providers " + krypton.providers[0].length);

		for(int loop = 0; loop < 100; loop++){

			try{objrx.put(krypton.providers[0][loop],krypton.providers[1][loop] + "*" + krypton.providers[2][loop]);}
			catch(Exception e){objrx.put(Integer.toString(loop),"null");}

		}//***********************************


		jsonarry = JSONValue.toJSONString(objrx);


	return jsonarry;

	}//*************************














	public String join_network(String idx){

	String jsonarry = new String("");
	String jsonText = new String("");
	int join_location = 101;



		//test for open chain link
		for(int loop = 0; loop < krypton.network[0].length; loop++){

			if(krypton.network[1][loop].equals("xxxx")){join_location = loop; break;}
			else{join_location = 101;}

		}//*********************************************************

		System.out.println("join_location " + join_location);

		user_ip = "9085";

		String response2x = JOptionPane.showInputDialog(null, "Enter Node IP:", "IP Address", JOptionPane.QUESTION_MESSAGE);
		if(response2x.length() > 0){user_ip = response2x;}




	//test the client's network
	try{

	JSONObject obj = new JSONObject();
	obj.put("request","status");
	obj.put("idx", idx);

	StringWriter out = new StringWriter();
	obj.writeJSONString(out);
	jsonText = out.toString();
	System.out.println(jsonText);

	}catch(Exception e){System.out.println("JSON ERROR");}


	String sentence = new String("");
	String modifiedSentence = new String("");  
	String JsonSentence = new String(""); 

	System.out.println("Test client network...");

	try{

	BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
	Socket clientSocket = new Socket("localhost", Integer.parseInt(user_ip));   
	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    
	sentence = jsonText;  
	outToServer.writeBytes(sentence + '\n');   
	modifiedSentence = inFromServer.readLine();   
	System.out.println("FROM SERVER: " + modifiedSentence);
	clientSocket.close();


		JSONParser parser = new JSONParser();
		Object obj = parser.parse(modifiedSentence);
		JSONObject jsonObject = (JSONObject) obj;
  
		String response = (String) jsonObject.get("response");
		System.out.println("JSON " + response);

		JsonSentence = response;

		if(JsonSentence.equals("active")){

			jsonarry = Integer.toString(join_location);

			//test for public key
			for(int loop = 0; loop < krypton.network[0].length; loop++){
	
				if(krypton.network[2][loop].equals(idx)){join_location = 101; System.out.println("KEY ACTIVE!"); break;}

			}//*********************************************************

			System.out.println("join_location " + join_location);

			if(join_location < 101){

				jsonarry = Integer.toString(join_location);

				//krypton.network[0][join_location] = "";
				krypton.network[1][join_location] = user_ip;
				krypton.network[2][join_location] = idx;


				System.out.println("save size " + krypton.network[0][0].length());
				System.out.println("save size " + krypton.network[1][0].length());
				System.out.println("save size " + krypton.network[2][0].length());

				krypton_database_save save = new krypton_database_save();

			}//*********************
			else{jsonarry = "denied";}

		}//*******************************
		else{jsonarry = "denied";}


	}catch(Exception e){jsonarry = "denied";}


	System.out.println("jsonarry " + jsonarry);
	return jsonarry;

	}//***********************************







	public String error_node(String node){

	System.out.println("Test error node for response...");

	     client_port_connect = Integer.parseInt(node);
	     client_address_connect = node;
	     String test = request_status();

	if(!test.equals("active")){

	System.out.println("REMOVE NODE! " + node);


		String[][] network2 = new String[3][krypton.network_chain];
		int error_list = 0;
		int error_hold = 0;

		for(int loop = 0; loop < krypton.network[0].length; loop++){


			//System.out.println(loop);
			//System.out.println(krypton.network[1][loop]);
			//System.out.println(node);


			if(!krypton.network[1][loop].equals(node)){

			network2[0][error_list] = new String(Integer.toString(error_list));
			network2[1][error_list] = new String(krypton.network[1][loop]);
			network2[2][error_list] = new String(krypton.network[2][loop]);

			error_list++;
			}//****************************************


		}//*********************************************************

			network2[0][99] = "99";
			network2[1][99] = "xxxx";
			network2[2][99] = "xxxx";

		System.out.println("error_list " + error_list);
		if(error_list == 99){krypton.network = network2; update_network_list();}
		else{System.out.println("NEW NETWORK LIST TOO SMALL 9238");}

	}//************************
	else{System.out.println("NODE IS ACTIVE.");}


	return node;

	}//***********************************








public String request_status(){//*****************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();
obj.put("request","status");

StringWriter out = new StringWriter();
obj.writeJSONString(out);
jsonText = out.toString();
System.out.println(jsonText);

}catch(Exception e){System.out.println("JSON ERROR");}


String sentence = new String("");
String modifiedSentence = new String("");  
String JsonSentence = new String(""); 


try{

System.out.println("address: " + client_port_connect);

BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
Socket clientSocket = new Socket("localhost", client_port_connect);   
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    
sentence = jsonText;  
outToServer.writeBytes(sentence + '\n');   
modifiedSentence = inFromServer.readLine();   
System.out.println("FROM SERVER: " + modifiedSentence);
clientSocket.close();


		JSONParser parser = new JSONParser();
		Object obj = parser.parse(modifiedSentence);
		JSONObject jsonObject = (JSONObject) obj;
  
		String response = (String) jsonObject.get("response");
		System.out.println("JSON " + response);

		JsonSentence = response;


}catch(Exception e){System.out.println("Cannot find node!"); JsonSentence = "not active!";}


return JsonSentence;

}//***********************************************************************************************





public void update_network_list(){


krypton_database_save save = new krypton_database_save();


}//*******************************



}//last
