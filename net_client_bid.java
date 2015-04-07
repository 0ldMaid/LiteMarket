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
import java.util.*;

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







public class net_client_bid{


Timer xtimerx;//class loop.
Toolkit toolkit;

int arrayx_size = 0;
String[][] bufferarray = new String[82][1];




net_client_bid(){//*****************************************************************



request_bid();



}//*********************************************************************************














public void request_bid(){//*****************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();

obj.put(lm.program_version, "bid");
obj.put("password", lm.passx);
obj.put("item_id",               lm.carbon_buy[lm.item_id_xx][lm.what_item]);
obj.put("bid",                   lm.send_bid_amount);
obj.put("btc_address",           lm.carbon_settings[11]);
obj.put("buyer_address_1",       lm.carbon_buy[lm.buyer_address_1_xx][lm.what_item]);
obj.put("buyer_address_2",       lm.carbon_buy[lm.buyer_address_2_xx][lm.what_item]);
obj.put("buyer_address_city",    lm.carbon_buy[lm.buyer_address_city_xx][lm.what_item]);
obj.put("buyer_address_state",   lm.carbon_buy[lm.buyer_address_state_xx][lm.what_item]);
obj.put("buyer_address_zip",     lm.carbon_buy[lm.buyer_address_zip_xx][lm.what_item]);
obj.put("buyer_address_country", lm.carbon_buy[lm.buyer_address_country_xx][lm.what_item]);
obj.put("buyers_email",          lm.carbon_buy[lm.buyers_email_xx][lm.what_item]);
obj.put("buyers_phone",          lm.carbon_buy[lm.buyers_phone_xx][lm.what_item]);



StringWriter out = new StringWriter();
obj.writeJSONString(out);
jsonText = out.toString();
System.out.println(jsonText);

}catch(Exception e){System.out.println("JSON ERROR");}




try{

String sentence;   
String modifiedSentence = new String(""); 




	try{

		System.out.println("socket");

		SocketFactory factory = lm.tor.getSocketFactory();

   		Socket socket = factory.createSocket(lm.httpx, 80);

		System.out.println("socketg");

    		OutputStream outputStream = socket.getOutputStream();
    		PrintWriter outx = new PrintWriter(outputStream);
    		outx.print(jsonText + "\r\n\r\n");
    		outx.flush();
    		InputStream inputStream = socket.getInputStream();
    		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    		BufferedReader in = new BufferedReader(inputStreamReader);

		System.out.println("socketw");

    		String line;
    		while ((line = in.readLine()) != null) {

    		  System.out.println(line);
		  modifiedSentence = line;

    		}//*************************************

   		outx.close();
    		in.close();
    		socket.close();

	}catch(Exception e){e.printStackTrace();}






	arrayx_size = 0;

	JSONParser parser = new JSONParser();

	try {//*********************************************************
 

		Object obj = parser.parse(modifiedSentence);
 
         	JSONArray array = (JSONArray)obj;

		bufferarray = new String[82][(array.size() + 1)];

		arrayx_size = array.size() + 1;

		System.out.println(array.size());

		if(array.size() > 0){


  		System.out.println(bufferarray.length);


			for(int loop = 0; loop < array.size(); loop++){

        		System.out.println(array.get(loop));
			bufferarray[lm.item_id_xx][(loop + 1)] = new String(array.get(loop).toString());
        		System.out.println();

			}//********************************************


		lm.carbon_buy = bufferarray;

		}//if_size************
		else{JOptionPane.showMessageDialog(null, "Request returned 0 results");}


	}//try
	catch (ParseException e){e.printStackTrace(); lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Connection failure!");}



}catch(Exception e){lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Server returned unexpected data!"); lm.error_codes_client = "";}

}//*********************************************************************************************











}//last
