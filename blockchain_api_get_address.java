import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import javax.imageio.ImageIO;
import javax.imageio.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;



public class blockchain_api_get_address{


	//Long wallet_value = (long) 0l;
	//Long sale_price = (long) 10000l;
	//String sale_price_s = new String("0.001");
	//Long wallet_value_paid = (long) 0l;


	String rpcurl = "http://blockchain.info/latestblock";
	String rpcaddress = new String("");
	String rpcuser = new String("");
  	String rpcpassword = new String("");


	int sale_in_progress = 0;
	int running_yes = 0;
	int running_time = 0;
	int running_int = 0;//timed refresh
	int paidx = 0;
	int sale_successful = 0;


	Timer xtimerx;//class loop.
	Toolkit toolkit;


	Icon imx0;
	Icon imx1;
	Icon imx2;
	Icon imx3;

	JLabel QR_CODE = new JLabel("", JLabel.CENTER);
	Label payment = new Label("(Select item)", Label.LEFT);





	Color blackx = new Color(0.0f, 0.0f, 0.0f);
	Color whitex = new Color(1.0f, 1.0f, 1.0f);
	Color st_gray1 = new Color(0.4f, 0.4f, 0.4f);
	Color st_gray2 = new Color(0.2f, 0.2f, 0.2f);





blockchain_api_get_address(){

get_wallet_address();






}//********************



     






	public void get_wallet_address(){//**********************

	System.out.println("Get Balance...");


	String rpcurl = lm.carbon_settings[10];
	String rpcaddress = lm.carbon_settings[11];
	String rpcuser = lm.carbon_settings[12];
  	String rpcpassword = lm.carbon_settings[13];
	String adlabel = lm.carbon_sell[lm.item_part_number_xx][lm.new_address_item];


	System.out.println(rpcuser);
	System.out.println(rpcpassword);
	System.out.println(rpcaddress);



        String line = new String();
	String line2 = new String();




	String url1 = new String("https://blockchain.info/merchant/" + rpcuser + "/new_address?password=" + rpcpassword + "&second_password=" + lm.second_password);

        try {

             

            // Sets the authenticator that will be used by the networking code
            // when a proxy or an HTTP server asks for authentication.

            //Authenticator.setDefault(new CustomAuthenticator());
	    System.out.println("GO0");
             
            URL url = new URL(url1);
	    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

	    System.out.println("GO1");

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            //BufferedReader in = new BufferedReader(null); 

             



            while ((line = in.readLine()) != null) {

                System.out.println(line);
		line2 = line2 + line;

            }

            in.close();




	JSONParser parser = new JSONParser();
 
	try{
 
		Object obj = parser.parse(line2);
 
		JSONObject jsonObject = (JSONObject) obj;
  
		String address = (String) jsonObject.get("address");
		System.out.println(address);

		lm.new_wallet_address = address;

		//String label = (String) jsonObject.get("label");
		//System.out.println(label);

 
	}//try
	catch(ParseException e){e.printStackTrace(); JOptionPane.showMessageDialog(null, e.getMessage());}


             

        }//try
        catch (MalformedURLException e) {System.out.println("Malformed URL: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage());}
        catch (IOException e) {System.out.println("I/O Error: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage());}
	catch (Exception e) {JOptionPane.showMessageDialog(null, "User or Pass is Probably Wrong 22 " + line);}



	}//***************test_for_sales()








}//last
