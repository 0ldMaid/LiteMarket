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

import com.subgraph.orchid.circuits.hs.HSDescriptorCookie;
import com.subgraph.orchid.config.TorConfigBridgeLine;
import com.subgraph.orchid.data.HexDigest;
import com.subgraph.orchid.data.IPv4Address;
import com.subgraph.orchid.encoders.Hex;
import com.subgraph.orchid.*;

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


	try{
	   initTor();
	}catch(Exception e){e.printStackTrace();}


}//*****************************************************************************














public void request_status(){//*****************************************************************

String jsonText = new String("");


try{//***********************************************

	JSONObject obj = new JSONObject();
	obj.put(lm.program_version, "connect");
	obj.put("password", lm.passx);

	StringWriter out = new StringWriter();
	obj.writeJSONString(out);
	jsonText = out.toString();
	System.out.println(jsonText);

}catch(Exception e){System.out.println("JSON ERROR");}




try{//***********************************************************************************************************************************




String sentence;   
String modifiedSentence = new String(""); 


System.out.println("go");

	try{

		System.out.println("socket");

		SocketFactory factory = lm.tor.getSocketFactory();

   		Socket socket = factory.createSocket(lm.httpx, 80);
		//socket.setSoTimeout(20000);

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







	public void initTor() throws Exception {

        // Oracle actually got permission to enable AES256 everywhere years ago anyway, they just didn't get around to
        // actually doing so yet!
        lm.tor = new TorClient();
        lm.tor.addInitializationListener(new TorInitializationListener() {
            @Override
            public void initializationProgress(String message, int percent) {

                System.out.println(">>> [ " + percent + "% ]: " + message);
		//infox1.setText("LOAD TOR >>> [ " + percent + "% ]: " + message);

            }//**************************************************************

            @Override
            public void initializationCompleted() {

                System.out.println("Tor is ready to go!");
		//infox6.setIcon(imx4);
		request_status();

            }//************************************
        });

        lm.tor.start();

    	}//****************************************



}//last


