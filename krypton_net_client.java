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









public class krypton_net_client{


Timer xtimerx;//class loop.
Toolkit toolkit;

String client_address_connect = new String("127.0.0.1");
int client_port_connect = 0000;




krypton_net_client(){//*****************************************************************

System.out.println("network size " + krypton.network[0].length);

if(krypton.network[0].length == 0){


	int response = JOptionPane.showConfirmDialog(null, "No network found!\nIf this is the first network node click 'Yes.'\nIf you want to add a node to connect to click 'No.'");
	System.out.println("response " + response);
 	if(response == 1){

	String response2 = JOptionPane.showInputDialog(null, "Enter Node IP:", "IP Address", JOptionPane.QUESTION_MESSAGE);
	if(response2.length() > 0){

		krypton.nodex_number = 101;

		client_port_connect = Integer.parseInt(response2); 
		client_address_connect = response2; 
		String status = request_status();

		if(status.equals("active")){

			System.out.println("active");

			String[][] network2 = request_network();

			if(network2[0].length == 100){System.out.println("success"); krypton.network = network2; update_network_list();}

		}//*************************


	}//************************

	}//***************
	else if(response == 0){

	System.out.println("Enter your external IP address.");

		String response2 = JOptionPane.showInputDialog(null, "Enter your external IP address:", "IP Address", JOptionPane.QUESTION_MESSAGE);
		if(response2.length() > 0){

		krypton.nodex_number = 0;

		System.out.println("test");
		String network[][] = new String[3][100];

			for(int loop = 0; loop < 100; loop++){

			//System.out.println("run2");

			network[0][loop] = new String(Integer.toString(loop));
			network[1][loop] = new String("xxxx");
			network[2][loop] = new String("xxxx");

			}//***********************************

			   //save the host address
			   network[0][0] = new String("0");
			   network[1][0] = new String(response2);
			   network[2][0] = new String(krypton.settingsx[5]);

			   krypton.network = network;

			   System.out.println("test2 " + krypton.network[0].length + " " + network[0].length);

				System.out.println("save sizec " + krypton.network[0][0].length());
				System.out.println("save sizec " + krypton.network[1][0].length());
				System.out.println("save sizec " + krypton.network[2][0].length());


			   krypton_database_save dbs = new krypton_database_save();
		


		}//************************
		else{JOptionPane.showMessageDialog(null, "You cannot create a network without a host!");}

	}//********************


}//********************************
else{


System.out.println("krypton.network " + krypton.network[0].length);

System.out.println("krypton.network 1 " + krypton.network[0][0]);
System.out.println("krypton.network 2 " + krypton.network[1][0]);

}//**






toolkit = Toolkit.getDefaultToolkit();
xtimerx = new Timer();
xtimerx.schedule(new RemindTask_client(), 0);




}//*****************************************************************************










	class RemindTask_client extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

	System.out.println("Krypton Network Client...");

	while(true){   


	if(krypton.nodex_number == 0){master_node();}
	else if(krypton.nodex_number == 1){second_node();}
	else{other_node();}//else


	try{Thread.sleep(3500);} catch (InterruptedException e){}


	}//*****while

	}//runx*************************************************************************************************
        }//remindtask












	public void master_node(){

	System.out.println("Master node work...");

	try{
	if(!krypton.network[1][1].equals("xxxx")){test_second_node();}
	}catch(Exception e){System.out.println("Error testing backup node...");}


	}//***********************







	public void second_node(){

	System.out.println("Backup node work...");

	int master_active = 0;
	

		//test lead node
		for(int loop = 0; loop < 3; loop++){

		    client_port_connect = Integer.parseInt(krypton.network[1][0]);
		    client_address_connect = krypton.network[1][0]; 
		    String status = request_status();

		    if(status.equals("active")){
		    master_active = 1; 

			String[][] network = request_network();
			if(network[0].length == krypton.network_chain){

			System.out.println("success"); 
			krypton.network = network; 
			update_network_list(); 


			int test = test_join();

				if(test != 101){String testx = join_network();}//*************
				else{System.out.println("Did not pass network test.");}

			}//********************************************

		    break;
		    }//*************************

		try{Thread.sleep(1000);} catch (InterruptedException e){}

		}//*********************************


	if(master_active == 1){System.out.println("MASTER IS ACTIVE.");}
	else{rebuild_network_list_node_1();}


	test_network_tree();

	}//***********************







	public void other_node(){

	System.out.println("Other node work...");


		//look for an active node
		for(int loop = 0; loop < krypton.network[0].length; loop++){

		if(!krypton.network[1][loop].equals("xxxx")){

		    client_port_connect = Integer.parseInt(krypton.network[1][loop]);
		    client_address_connect = krypton.network[1][loop]; 
		    String status = request_status();

		    if(status.equals("active")){

			String[][] network = request_network();
			if(network[0].length == 100){

			System.out.println("success"); 
			krypton.network = network; 
			update_network_list(); 

			//if not a node request a slot.

			int test = test_join();

				if(test != 101){String testx = join_network();}//*************
				else{System.out.println("Did not pass network test.");}

			break;
			}//if*************************

		    }//*************************

		}//******************************************

		}//*********************************************************

	test_network_tree();

	}//**********************















public void test_second_node(){

	String node = new String(krypton.network[1][1]);
	client_port_connect = Integer.parseInt(krypton.network[1][1]);
	client_address_connect = krypton.network[1][1]; 

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



}//****************************









public void test_network_tree(){

System.out.println("Test network list for lazy workers.");


	if(krypton.nodex_number < 99){

		if(!krypton.network[1][(krypton.nodex_number + 1)].equals("xxxx")){


		String ipx = krypton.network[1][(krypton.nodex_number + 1)];

		client_port_connect = Integer.parseInt(ipx);
		client_address_connect = ipx;
		 
		String status = request_status();

			if(status.equals("active")){System.out.println("NETWORK LIST IS OK.");}
			else{//

			   System.out.println("REPORT WORKER.");

			   String ipx2 = krypton.network[1][0];
			   client_port_connect = Integer.parseInt(ipx2); 
			   client_address_connect = ipx2;

			   report_worker(ipx);

			}//else

		}//****************************************************************




	}//***************************

}//*****************************









public void rebuild_network_list_node_1(){

System.out.println("Master node offline or internet connection problems.");


	String[][] new_network = new String[3][100];

	for(int loop = 0; loop < 99; loop++){

	new_network[0][loop] = new String(Integer.toString(loop));
	new_network[1][loop] = krypton.network[1][(loop + 1)];
	new_network[2][loop] = krypton.network[2][(loop + 1)];

	}//**********************************


	new_network[0][99] = new String("99");
	new_network[1][99] = new String("xxxx");
	new_network[2][99] = new String("xxxx");

	System.out.println("X1 " + new_network[0][0]);
	System.out.println("X2 " + new_network[1][0]);

	System.out.println("X1 " + new_network[0][1]);
	System.out.println("X2 " + new_network[1][1]);


	try{

	krypton.network = new_network;

	krypton_database_save dbs = new krypton_database_save();


		for (int loop = 0; loop < krypton.network[0].length; loop++){

		if(krypton.network[2][loop].equals(krypton.settingsx[5])){System.out.println("NEW NODE LOCATION: " + loop); krypton.nodex_number = loop;}

		}//**********************************************************


	}catch(Exception e){System.out.println("ERROR UPDATING NETWORK...");}


}//***************************************







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
System.out.println("address: " + client_address_connect);

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













public String[][] request_network(){//*************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();
obj.put("request","network");

StringWriter out = new StringWriter();
obj.writeJSONString(out);
jsonText = out.toString();
System.out.println(jsonText);

}catch(Exception e){System.out.println("JSON ERROR");}




String sentence = new String("");
String modifiedSentence = new String("");  
String JsonSentence = new String(""); 
String[][] JsonArray = new String[3][100]; 

try{

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
		//System.out.println("JSON " + response);

		JsonSentence = response;


			Object obj2 = parser.parse(JsonSentence);
			JSONObject jsonObject2 = (JSONObject) obj2;

			for(int loop = 0; loop < 100; loop++){

				String string1 = (String) jsonObject2.get(Integer.toString(loop));

				JsonArray[0][loop] = new String(Integer.toString(loop));

				int plus = string1.indexOf("*");

				JsonArray[1][loop] = new String(string1.substring(0, plus));
				JsonArray[2][loop] = new String(string1.substring((plus + 1), string1.length()));

			}//***********************************


			try{
			System.out.println(JsonArray[0][0]);
			System.out.println(JsonArray[1][0]);
			System.out.println(JsonArray[2][0]);
			}catch(Exception e){JsonArray = new String[0][0];}

}catch(Exception e){e.printStackTrace(); System.out.println("Database Update Error 75");}


return JsonArray;

}//************************************************************************************************







public void update_network_list(){


krypton_database_save save = new krypton_database_save();


}//*******************************








public int test_join(){

System.out.println("Try to join the network TEST.");

int join_location = 101;

	//test for open chain link
	for(int loop = 0; loop < krypton.network[0].length; loop++){

			if(krypton.network[1][loop].equals("xxxx")){join_location = loop; break;}
			else{join_location = 101;}

	}//*********************************************************


	//test if already added
	for(int loop = 0; loop < krypton.network[0].length; loop++){

			if(krypton.network[2][loop].equals(krypton.settingsx[5])){join_location = 101; break;}

	}//*********************************************************


return join_location;

}//*********************






public String join_network(){

System.out.println("Try to join the network.");

int join_location = 101;
String JsonArray = new String(""); 




	//test for open chain link
	for(int loop = 0; loop < krypton.network[0].length; loop++){

			if(krypton.network[1][loop].equals("xxxx")){join_location = loop; break;}
			else{join_location = 101;}

	}//*********************************************************


	//test if already added
	for(int loop = 0; loop < krypton.network[0].length; loop++){

			if(krypton.network[2][loop].equals(krypton.settingsx[5])){join_location = 101; break;}

	}//*********************************************************




System.out.println("join_location must be < 101 " + join_location);



if(join_location < 101){



	String jsonText = new String("");

	String sentence = new String("");
	String modifiedSentence = new String("");  
	String JsonSentence = new String(""); 



	try{

		JSONObject obj = new JSONObject();
		obj.put("request","join");
		obj.put("idx", krypton.settingsx[5]);

		StringWriter out = new StringWriter();
		obj.writeJSONString(out);
		jsonText = out.toString();
		System.out.println(jsonText);

	}catch(Exception e){System.out.println("JSON ERROR");}




	try{

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


	}catch(Exception e){e.printStackTrace(); System.out.println("Join Network Error 35");}



}//*********************



return JsonArray;

}//**************************









public String report_worker(String error){//*****************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();
obj.put("request", "report");
obj.put("worker", error);

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
System.out.println("address: " + client_address_connect);

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

}//**********************************************************************************************
















}//last
