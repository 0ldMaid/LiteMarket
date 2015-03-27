import java.math.*;

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

import java.text.SimpleDateFormat;
import java.util.Date;




import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



class rpc_client_buy{


private static final String COMMAND_GET_BALANCE = "getbalance";
private static final String COMMAND_GET_INFO = "getinfo";
private static final String COMMAND_GET_NEW_ADDRESS = "getnewaddress";
private static final String COMMAND_SEND_TO_ADDRESS = "sendtoaddress";


Label infox1 = new Label("", Label.LEFT);
Label infox2 = new Label("Loading...", Label.LEFT);

int loopxp = 0;


String sale_transaction_infox = new String("x");
String sale_transaction_idx = new String("x");

String bufferx = new String("");

String sale_status_xx = new String("Paid");









rpc_client_buy(){



loopxp = lm.what_item;

request_status();



}//**********











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
String modifiedSentence;   

BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in) );
Socket clientSocket = new Socket(lm.httpx, lm.server_port);   
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    
sentence = jsonText;  
outToServer.writeBytes(sentence + '\n');   
modifiedSentence = inFromServer.readLine();   
System.out.println("FROM SERVER: " + modifiedSentence);
clientSocket.close();





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

	infox2.setText("Pay for item RPC");


	String toaddress = lm.carbon_buy[lm.seller_id_xx][loopxp];
	System.out.println(toaddress);

	String xamount = lm.carbon_buy[lm.item_price_xx][loopxp].replace(".", "");
	xamount = Long.toString( (Long.parseLong(xamount) * lm.quantityx) );
	System.out.println(xamount);


	BigDecimal amount = new BigDecimal(xamount);  
        BigDecimal size = new BigDecimal("100000000");   
        System.out.println(amount.divide(size));

	BigDecimal balance_x = amount.divide(size);  

	String wallet_value_s = balance_x.toString();

	String xamount2 = wallet_value_s;

	JSONObject json = invokeRPC(UUID.randomUUID().toString(), COMMAND_SEND_TO_ADDRESS, toaddress, xamount2);


	}//****************















private JSONObject invokeRPC(String id, String method, String toaddress, String xamountx) {




		DefaultHttpClient httpclient = new DefaultHttpClient();

		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("method", method);
		if (null != toaddress && null != xamountx) {

			//JSONArray array = new JSONArray();
			//array.addAll(params);
			//json.put("params", params);

			JSONArray list = new JSONArray();
  			list.add(toaddress);
  			list.add(new Float(Float.parseFloat(xamountx)));
			json.put("params", list);

		}//******************



		JSONObject responseJsonObj = null;
		try {
			httpclient.getCredentialsProvider().setCredentials(new AuthScope("localhost", lm.rpc_wallet_port),
					new UsernamePasswordCredentials("user1", "pass2"));
			StringEntity myEntity = new StringEntity(json.toJSONString());
			System.out.println(json.toString());
			HttpPost httppost = new HttpPost("http://localhost:" + Integer.toString(lm.rpc_wallet_port));
			httppost.setEntity(myEntity);

			System.out.println("executing request" + httppost.getRequestLine());
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			if (entity != null) {

				System.out.println("Response content length: " + entity.getContentLength());
				bufferx = EntityUtils.toString(entity);
				System.out.println(bufferx);

			}

			System.out.println("JSON1");

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(bufferx);
 
			JSONObject jsonObject = (JSONObject) obj;
  
			System.out.println("JSON2");


				try{
				String result = (String) jsonObject.get("result").toString();
				if(result != null){sale_transaction_idx = result;}
				}catch(Exception e){lm.rpc_connection_active = 0;}


			System.out.println("JSON3");


				try{
				String error = (String) jsonObject.get("error").toString();
				if(error != null){JOptionPane.showMessageDialog(null, error); sale_status_xx = "Error";}
				}catch(Exception e){System.out.println("No Errors");}


			System.out.println("JSON4");



		} catch (ClientProtocolException e) {


			lm.rpc_connection_active = 0;
			e.printStackTrace();
		} catch (IOException e) {


			lm.rpc_connection_active = 0;
			e.printStackTrace();
		} catch (ParseException e) {


			lm.rpc_connection_active = 0;
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {


			lm.rpc_connection_active = 0;
			e.printStackTrace();
		} finally {


			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}






		return responseJsonObj;


}











}//last
