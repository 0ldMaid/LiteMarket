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

import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;
 
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import com.sun.net.ssl.internal.www.protocol.https.*;
import java.security.Security;

import javax.net.ssl.TrustManager.*;
import javax.net.ssl.X509TrustManager.*;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;



public class blockchain_api_test{


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




blockchain_api_test(){

get_wallet_balance();






}//*********



     





	public void get_wallet_balance(){//**********************

	System.out.println("Get Balance...");


	rpcurl = lm.carbon_settings[10];
	rpcaddress = lm.carbon_settings[11];
	rpcuser = lm.carbon_settings[12];
  	rpcpassword = lm.carbon_settings[13];


	System.out.println(rpcuser);
	System.out.println(rpcpassword);
	System.out.println(rpcaddress);



        String line = new String();
	String line2 = new String();




	String url1 = new String("https://blockchain.info/merchant/" + rpcuser + "/balance?password=" + rpcpassword);


        try {






	    System.out.println("GO0");
             
            URL url = new URL(url1);
	    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

	    System.out.println("GO1");

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            //BufferedReader in = new BufferedReader(null); 

	    System.out.println("GO2");

            while ((line = in.readLine()) != null) {

                System.out.println(line);
		line2 = line2 + line;

            }

            in.close();




	JSONParser parser = new JSONParser();
 
	try {
 
		Object obj = parser.parse(line2);
 
		JSONObject jsonObject = (JSONObject) obj;
  
		//String address = (String) jsonObject.get("address");
		//System.out.println(address);

		String balance = (String) jsonObject.get("balance").toString();
		System.out.println(balance);
		lm.wallet_value = (long) Long.parseLong(balance);
 		System.out.println("lm.wallet_value " + lm.wallet_value);
 
	}//try
	catch(ParseException e){e.printStackTrace(); JOptionPane.showMessageDialog(null, e.getMessage());}


             

        }//try
        catch (MalformedURLException e) {System.out.println("Malformed URL: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage());}
        catch (IOException e) {System.out.println("I/O Error: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage());}
	catch (Exception e) {System.out.println(e.getMessage()); JOptionPane.showMessageDialog(null, "User or Pass is Probably Wrong " + line);}



	}//***************test_for_sales()













}//last



