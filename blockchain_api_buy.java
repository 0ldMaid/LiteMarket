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

import java.text.SimpleDateFormat;
import java.util.Date;

import java.net.HttpURLConnection;
import javax.net.SocketFactory;






public class blockchain_api_buy extends JFrame{


Timer xtimerx;//class loop.
Toolkit toolkit;


Label infox1 = new Label("", Label.LEFT);
Label infox2 = new Label("Loading...", Label.LEFT);


String sale_transaction_infox = new String("x");
String sale_transaction_idx = new String("x");


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

int loopxp = 0;


Color xstripesc = new Color(0.0f, 0.0f, 0.0f);
Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color greenx = new Color(0.15f, 0.6f, 0.25f);
Color redx = new Color(0.9f, 0.1f, 0.1f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color grayxb = new Color(0.6f, 0.6f, 0.6f);
Color grayx1 = new Color(0.4f, 0.4f, 0.4f);
Color grayx2 = new Color(0.7f, 0.7f, 0.7f);
Color grayx3 = new Color(0.85f, 0.85f, 0.85f);
Color purple = new Color(1.0f, 0.0f, 0.8f);
Color bluex1 = new Color(0.4f, 0.4f, 0.9f);
Color selectx = new Color(1.0f, 0.9f, 0.0f);
Color yellowx = new Color(1.0f, 0.9f, 0.0f);
Color yellowx2 = new Color(0.8f, 0.7f, 0.0f);
Color lightgreenx = new Color(0.5f, 0.9f, 0.5f);
Color darkgreenx = new Color(0.1f, 0.3f, 0.1f);
Color darkgreebnx = new Color(0.1f, 0.3f, 0.1f);
Color gray5 = new Color(0.5f, 0.5f, 0.5f);
Color gray6 = new Color(0.6f, 0.6f, 0.6f);
Color gray7 = new Color(0.7f, 0.7f, 0.7f);
Color gray8 = new Color(0.8f, 0.8f, 0.8f);
Color gray9 = new Color(0.9f, 0.9f, 0.9f);


String sale_status_xx = new String("Paid");





blockchain_api_buy(){//*****************************************************************

	super("Creating transaction");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

//the program icon 
	Image imageppx = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	setIconImage(imageppx);


	infox1.setPreferredSize(new Dimension(350, 90));
	infox1.setText("");
	infox1.setForeground(blackx);

	infox2.setPreferredSize(new Dimension(340, 25));
	infox2.setText("Reserve item");
	infox2.setForeground(blackx);


	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(grayx3);
	cpx.setForeground(blackx);
	cpx.add(infox1);
	cpx.add(infox2);



	//setVisible(true);

	loopxp = lm.what_item;


	request_status();



}//*****************************************************************************














public void request_status(){//*****************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();
obj.put(lm.program_id, "reserve");
obj.put("password",  lm.passx);
obj.put("item_id",   lm.item_idx_buy);
obj.put("buyer_id",  lm.carbon_settings[11]);
obj.put("quantity",  Integer.toString(lm.quantityx));
obj.put("seller_id", lm.carbon_buy[lm.seller_id_xx][lm.what_item]);

//make sure item is still the same
obj.put("[[currency]]",               lm.carbon_buy[lm.currency_xx][lm.what_item]);
obj.put("[[item_part_number]]",       lm.carbon_buy[lm.item_part_number_xx][lm.what_item]);
obj.put("[[item_price]]",             lm.carbon_buy[lm.item_price_xx][lm.what_item]);
obj.put("[[item_title]]",             lm.carbon_buy[lm.item_title_xx][lm.what_item]);
obj.put("[[item_total_on_hand]]",     lm.carbon_buy[lm.item_total_on_hand_xx][lm.what_item]);

obj.put("buyer_name",     lm.carbon_settings[14]);
obj.put("buyer_address1", lm.carbon_settings[15]);
obj.put("buyer_city",     lm.carbon_settings[16]);
obj.put("buyer_state",    lm.carbon_settings[17]);
obj.put("buyer_zip",      lm.carbon_settings[18]);
obj.put("buyer_country",  lm.carbon_settings[19]);
obj.put("buyer_email",    lm.carbon_settings[20]);

StringWriter out = new StringWriter();
obj.writeJSONString(out);
jsonText = out.toString();
System.out.println(jsonText);

}catch(Exception e){System.out.println("JSON ERROR");}




try{

String sentence;   
String modifiedSentence = new String("");

System.out.println("go");



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





	JSONParser parser = new JSONParser();

	try {//*********************************************************
 

		Object obj = parser.parse(modifiedSentence);
 
		JSONObject jsonObject = (JSONObject) obj;
  
		String request = (String) jsonObject.get("response");
		String sale_transaction_info = (String) jsonObject.get("sale_transaction_info");
		System.out.println(request);

		sale_transaction_infox = sale_transaction_info;

		sale_status_xx = "Paid";

		if(request.equals("1")){infox2.setText("Reserved"); lm.connection_active = 1; payx(); receipt(); lm.pay_for_item = 1;}
		else{infox2.setText("ERROR"); lm.connection_active = 0; lm.pay_for_item = 0; JOptionPane.showMessageDialog(null, "Server Denied Request. Item could have changed. Reload items and try again.");}


	}//try
	catch (ParseException e){e.printStackTrace(); lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Connection failure!");}



}catch(Exception e){lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Unknown Error!"); lm.error_codes_client = "";}

}//*********************************************************************************************








public void receipt(){

infox2.setText("Save transaction");

try{


System.out.println("carbon_purchase.length " + lm.carbon_purchase[0].length);

String[][] arraybuffer = new String[lm.db_sections][(lm.carbon_purchase[0].length + 1)];
				
System.out.println("2");

	for(int xloop1 = 0; xloop1 < lm.carbon_purchase[0].length; xloop1++){//***********	
	for(int xloop2 = 0; xloop2 < lm.carbon_purchase.length; xloop2++){//*********

	arraybuffer[xloop2][xloop1] = lm.carbon_purchase[xloop2][xloop1];

	}//**************************************************************************
	}//*******************************************************************************


System.out.println("3");


//date


	

int add1 = (arraybuffer[0].length -1);

DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
Date date = new Date();
System.out.println(dateFormat.format(date));


arraybuffer[0][add1] = new String(lm.carbon_settings[15]);//buyer_address_1
arraybuffer[1][add1] = new String("");//buyer_address_2
arraybuffer[2][add1] = new String(lm.carbon_settings[16]);//buyer_address_city
arraybuffer[3][add1] = new String(lm.carbon_settings[17]);//buyer_address_state
arraybuffer[4][add1] = new String(lm.carbon_settings[18]);//buyer_address_zip
arraybuffer[5][add1] = new String(lm.carbon_settings[19]);//buyer_address_country
arraybuffer[6][add1] = new String(lm.carbon_settings[11]);//buyer_id
arraybuffer[7][add1] = new String("buyer_ip");
arraybuffer[8][add1] = new String(lm.carbon_settings[20]);//buyers_email
arraybuffer[9][add1] = new String(lm.carbon_settings[14]);//buyers_first_name
arraybuffer[10][add1] = new String("buyers_last_name");
arraybuffer[11][add1] = new String(lm.carbon_settings[11]);//buyers_payment_address
arraybuffer[12][add1] = new String("buyers_phone");
arraybuffer[13][add1] = new String(lm.carbon_settings[9]);
arraybuffer[14][add1] = new String(lm.carbon_buy[lm.custom_template_xx][loopxp]);//custom_template
arraybuffer[15][add1] = new String(lm.carbon_buy[lm.custom_1_xx][loopxp]);//custom_1
arraybuffer[16][add1] = new String(lm.carbon_buy[lm.custom_2_xx][loopxp]);//custom_2
arraybuffer[17][add1] = new String(lm.carbon_buy[lm.custom_3_xx][loopxp]);//custom_3
arraybuffer[18][add1] = new String(lm.carbon_buy[lm.item_errors_xx][loopxp]);//item_errors
arraybuffer[19][add1] = new String(lm.carbon_buy[lm.item_date_listed_xx][loopxp]);//item_date_listed
arraybuffer[20][add1] = new String(lm.carbon_buy[lm.item_date_listed_day_xx][loopxp]);//item_date_listed_day
arraybuffer[21][add1] = new String(lm.carbon_buy[lm.item_date_listed_int_xx][loopxp]);//item_date_listed_int
arraybuffer[22][add1] = new String(lm.carbon_buy[lm.item_hits_xx][loopxp]);//item_hits
arraybuffer[23][add1] = new String("0");//item_confirm_code
arraybuffer[24][add1] = new String("0");//item_confirmed
arraybuffer[25][add1] = new String(lm.carbon_buy[lm.item_cost_xx][loopxp]);//item_cost
arraybuffer[26][add1] = new String(Integer.toString(lm.carbon_buy[lm.item_description_xx][loopxp].length()));//item_description
arraybuffer[27][add1] = new String(lm.carbon_buy[lm.item_id_xx][loopxp]);//item_id
arraybuffer[28][add1] = new String(lm.carbon_buy[lm.item_price_xx][loopxp]);//item_price
arraybuffer[29][add1] = new String(lm.carbon_buy[lm.item_weight_xx][loopxp]);//item_weight
arraybuffer[30][add1] = new String(lm.carbon_buy[lm.item_listing_id_xx][loopxp]);//item_listing_id
arraybuffer[31][add1] = new String(lm.carbon_buy[lm.item_notes_xx][loopxp]);//item_notes
arraybuffer[32][add1] = new String(lm.carbon_buy[lm.item_package_d_xx][loopxp]);//item_package_d
arraybuffer[33][add1] = new String(lm.carbon_buy[lm.item_package_l_xx][loopxp]);//item_package_l
arraybuffer[34][add1] = new String(lm.carbon_buy[lm.item_package_w_xx][loopxp]);//item_package_w
arraybuffer[35][add1] = new String(lm.carbon_buy[lm.item_part_number_xx][loopxp]);//item_part_number
arraybuffer[36][add1] = new String(lm.carbon_buy[lm.item_title_xx][loopxp]);//item_title
arraybuffer[37][add1] = new String(lm.carbon_buy[lm.item_title_url_xx][loopxp]);//item_title_url
arraybuffer[38][add1] = new String(lm.carbon_buy[lm.item_type_xx][loopxp]);//item_type
arraybuffer[39][add1] = new String(lm.carbon_buy[lm.item_search_1_xx][loopxp]);//item_search_1
arraybuffer[40][add1] = new String(lm.carbon_buy[lm.item_search_2_xx][loopxp]);//item_search_2
arraybuffer[41][add1] = new String(lm.carbon_buy[lm.item_search_3_xx][loopxp]);//item_search_3
arraybuffer[42][add1] = new String(lm.carbon_buy[lm.item_site_id_xx][loopxp]);//item_site_id
arraybuffer[43][add1] = new String(lm.carbon_buy[lm.item_site_url_xx][loopxp]);//item_site_url
arraybuffer[44][add1] = new String(lm.carbon_buy[lm.item_picture_1_xx][loopxp]);//item_picture_1
arraybuffer[45][add1] = new String(lm.carbon_buy[lm.item_total_on_hand_xx][loopxp]);//item_total_on_hand
arraybuffer[46][add1] = new String("sale_date_payment_received");
arraybuffer[47][add1] = new String("sale_date_shipped");
arraybuffer[48][add1] = new String(dateFormat.format(date));
arraybuffer[49][add1] = new String("sale_final_value_fee");
arraybuffer[50][add1] = new String("0.00");//sale_handling
arraybuffer[51][add1] = new String("");//sale_payment_address
arraybuffer[52][add1] = new String("");//sale_payment_type
arraybuffer[53][add1] = new String("0.00");//sale_fees
arraybuffer[54][add1] = new String(Integer.toString(lm.quantityx));//sale_quantity_sold
arraybuffer[55][add1] = new String("sale_id");
arraybuffer[56][add1] = new String("sale_seller_id");
arraybuffer[57][add1] = new String(sale_status_xx);//sale_status
arraybuffer[58][add1] = new String("0.00");//sale_tax
arraybuffer[59][add1] = new String("sale_shipping_company");
arraybuffer[60][add1] = new String("0.00");//sale_shipping_in
arraybuffer[61][add1] = new String("0.00");//sale_shipping_out
arraybuffer[62][add1] = new String("");//sale_source_of_sale
arraybuffer[63][add1] = new String("sale_total_sale_amount");
arraybuffer[64][add1] = new String("");//sale_tracking_number
arraybuffer[65][add1] = new String(sale_transaction_idx);
arraybuffer[66][add1] = new String(sale_transaction_infox);//sale_transaction_info
arraybuffer[67][add1] = new String("seller_address_1");
arraybuffer[68][add1] = new String("seller_address_2");
arraybuffer[69][add1] = new String("seller_address_city");
arraybuffer[70][add1] = new String("seller_address_state");
arraybuffer[71][add1] = new String("seller_address_zip");
arraybuffer[72][add1] = new String("seller_address_country");
arraybuffer[73][add1] = new String(lm.carbon_buy[lm.seller_id_xx][loopxp]);//seller_id
arraybuffer[74][add1] = new String("seller_ip");
arraybuffer[75][add1] = new String("seller_email");
arraybuffer[76][add1] = new String("seller_first_name");
arraybuffer[77][add1] = new String("seller_last_name");
arraybuffer[78][add1] = new String("seller_notes");
arraybuffer[79][add1] = new String("seller_phone");
arraybuffer[80][add1] = new String("seller_logo");
arraybuffer[81][add1] = new String("seller_url");

System.out.println("4");

lm.carbon_purchase = arraybuffer;

System.out.println("5");




}catch(Exception e){e.printStackTrace(); System.out.println("<<< add to db failed");}




}//*******************







	public void payx(){

	infox2.setText("Pay for item");
	get_wallet_pay_x();


	}//****************













	public void get_wallet_pay_x(){//**********************

	System.out.println("Send Payment API...");


	String rpcurl = lm.carbon_settings[10];
	String rpcaddress = lm.carbon_settings[11];
	String rpcuser = lm.carbon_settings[12];
  	String rpcpassword = lm.carbon_settings[13];
	String toaddress = lm.carbon_buy[lm.seller_id_xx][loopxp];

	System.out.println(toaddress);

	String xamount = lm.carbon_buy[lm.item_price_xx][loopxp].replace(".", "");
	xamount = Long.toString( (Long.parseLong(xamount) * lm.quantityx) );



	System.out.println(rpcuser);
	System.out.println(rpcpassword);
	System.out.println(rpcaddress);
	System.out.println(xamount);


        String line = new String();
	String line2 = new String();








	String url1 = new String("https://blockchain.info/merchant/" + rpcuser + "/payment?password=" + rpcpassword + "&second_password=" + lm.second_password + "&to=" + toaddress + "&amount=" + xamount);

        try {

             

            // Sets the authenticator that will be used by the networking code
            // when a proxy or an HTTP server asks for authentication.

            //Authenticator.setDefault(new CustomAuthenticator());
	    System.out.println("GO");
             
            URL url = new URL(url1);

             

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

             



            while ((line = in.readLine()) != null) {

                System.out.println(line);
		line2 = line2 + line;

            }

            in.close();




	JSONParser parser = new JSONParser();
 
	try{
 
		Object obj = parser.parse(line2);
 
		JSONObject jsonObject = (JSONObject) obj;
  
		String message = (String) jsonObject.get("message");
		System.out.println(message);

		JOptionPane.showMessageDialog(null, message);

		String tx_hash = (String) jsonObject.get("tx_hash").toString();
		System.out.println(tx_hash);

		sale_transaction_idx = tx_hash;

		//String notice = (String) jsonObject.get("notice").toString();
		//System.out.println(notice);


 
	}//try
	catch(ParseException e){e.printStackTrace(); JOptionPane.showMessageDialog(null, e.getMessage() + " " + line); sale_status_xx = "Error";}


             

        }//try
        catch (MalformedURLException e) {System.out.println("Malformed URL: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage()); sale_status_xx = "Error";}
        catch (IOException e) {System.out.println("I/O Error: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage()); sale_status_xx = "Error";}
	catch (Exception e) {JOptionPane.showMessageDialog(null, "User or Pass is Probably Wrong 32 " + line); sale_status_xx = "Error";}



	}//***************test_for_sales()














}//last
