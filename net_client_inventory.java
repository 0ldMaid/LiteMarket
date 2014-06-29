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









public class net_client_inventory{


Timer xtimerx;//class loop.
Toolkit toolkit;

int arrayx_size = 0;
String[][] bufferarray = new String[82][1];




net_client_inventory(){//*****************************************************************



request_inventory();



}//***************************************************************************************














public void request_inventory(){//*****************************************************************

String jsonText = new String("");


try{

JSONObject obj = new JSONObject();

obj.put(lm.program_id, "search");
obj.put("password", lm.passx);
obj.put("search_text", lm.search_text);
obj.put("search_field", lm.search_field);

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






	arrayx_size = 0;

	JSONParser parser = new JSONParser();

	try {//*********************************************************
 

		Object obj = parser.parse(modifiedSentence);
 
         	JSONArray array = (JSONArray)obj;

		bufferarray = new String[82][(array.size() + 1)];

		arrayx_size = array.size() + 1;

		System.out.println(array.size());

		if(array.size() > 0){
		build_list();

  		System.out.println(bufferarray.length);


			for(int loop = 0; loop < array.size(); loop++){

        		System.out.println(array.get(loop));
			bufferarray[lm.item_id_xx][(loop + 1)] = new String(array.get(loop).toString());
        		System.out.println();

			}//********************************************


		lm.carbon_buy = bufferarray;

		}//if_size************
		else{JOptionPane.showMessageDialog(null, "Request returned 0 results.");}


	}//try
	catch (ParseException e){e.printStackTrace(); lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Connection failure!");}



}catch(Exception e){lm.connection_active = 0; JOptionPane.showMessageDialog(null, "Server returned unexpected data!"); lm.error_codes_client = "";}

}//*********************************************************************************************







	public void build_list(){

	for(int loop = 0; loop < arrayx_size; loop++){

	bufferarray[0][loop] = new String("");
	bufferarray[1][loop] = new String("");
	bufferarray[2][loop] = new String("");
	bufferarray[3][loop] = new String("");
	bufferarray[4][loop] = new String("");
	bufferarray[5][loop] = new String("");
	bufferarray[6][loop] = new String("");
	bufferarray[7][loop] = new String("");
	bufferarray[8][loop] = new String("");
	bufferarray[9][loop] = new String("");
	bufferarray[10][loop] = new String("");
	bufferarray[11][loop] = new String("");
	bufferarray[12][loop] = new String("");
	bufferarray[13][loop] = new String("");
	bufferarray[14][loop] = new String("");
	bufferarray[15][loop] = new String("");
	bufferarray[16][loop] = new String("");
	bufferarray[17][loop] = new String("");
	bufferarray[18][loop] = new String("");
	bufferarray[19][loop] = new String("");
	bufferarray[20][loop] = new String("");
	bufferarray[21][loop] = new String("");
	bufferarray[22][loop] = new String("");
	bufferarray[23][loop] = new String("");
	bufferarray[24][loop] = new String("");
	bufferarray[25][loop] = new String("");
	bufferarray[26][loop] = new String("");
	bufferarray[27][loop] = new String("");
	bufferarray[28][loop] = new String("");
	bufferarray[29][loop] = new String("");
	bufferarray[30][loop] = new String("");
	bufferarray[31][loop] = new String("");
	bufferarray[32][loop] = new String("");
	bufferarray[33][loop] = new String("");
	bufferarray[34][loop] = new String("");
	bufferarray[35][loop] = new String("");
	bufferarray[36][loop] = new String("Loading...");
	bufferarray[37][loop] = new String("");
	bufferarray[38][loop] = new String("");
	bufferarray[39][loop] = new String("");
	bufferarray[40][loop] = new String("");
	bufferarray[41][loop] = new String("");
	bufferarray[42][loop] = new String("");
	bufferarray[43][loop] = new String("");
	bufferarray[44][loop] = new String("");
	bufferarray[45][loop] = new String("");
	bufferarray[46][loop] = new String("");
	bufferarray[47][loop] = new String("");
	bufferarray[48][loop] = new String("");
	bufferarray[49][loop] = new String("");
	bufferarray[50][loop] = new String("");
	bufferarray[51][loop] = new String("");
	bufferarray[52][loop] = new String("");
	bufferarray[53][loop] = new String("");
	bufferarray[54][loop] = new String("");
	bufferarray[55][loop] = new String("");
	bufferarray[56][loop] = new String("");
	bufferarray[57][loop] = new String("");
	bufferarray[58][loop] = new String("");
	bufferarray[59][loop] = new String("");
	bufferarray[60][loop] = new String("");
	bufferarray[61][loop] = new String("");
	bufferarray[62][loop] = new String("");
	bufferarray[63][loop] = new String("");
	bufferarray[64][loop] = new String("");
	bufferarray[65][loop] = new String("");
	bufferarray[66][loop] = new String("");
	bufferarray[67][loop] = new String("");
	bufferarray[68][loop] = new String("");
	bufferarray[69][loop] = new String("");
	bufferarray[70][loop] = new String("");
	bufferarray[71][loop] = new String("");
	bufferarray[72][loop] = new String("");
	bufferarray[73][loop] = new String("");
	bufferarray[74][loop] = new String("");
	bufferarray[75][loop] = new String("");
	bufferarray[76][loop] = new String("");
	bufferarray[77][loop] = new String("");
	bufferarray[78][loop] = new String("");
	bufferarray[79][loop] = new String("");
	bufferarray[80][loop] = new String("");
	bufferarray[81][loop] = new String("");

	}//*******************************************



	bufferarray[0][0] = new String("[[buyer_address_1]]");
	bufferarray[1][0] = new String("[[buyer_address_2]]");
	bufferarray[2][0] = new String("[[buyer_address_city]]");
	bufferarray[3][0] = new String("[[buyer_address_state]]");
	bufferarray[4][0] = new String("[[buyer_address_zip]]");
	bufferarray[5][0] = new String("[[buyer_address_country]]");
	bufferarray[6][0] = new String("[[buyer_id]]");
	bufferarray[7][0] = new String("[[buyer_ip]]");
	bufferarray[8][0] = new String("[[buyers_email]]");
	bufferarray[9][0] = new String("[[buyers_first_name]]");
	bufferarray[10][0] = new String("[[buyers_last_name]]");
	bufferarray[11][0] = new String("[[buyers_payment_address]]");
	bufferarray[12][0] = new String("[[buyers_phone]]");
	bufferarray[13][0] = new String("[[currency]]");
	bufferarray[14][0] = new String("[[custom_template]]");
	bufferarray[15][0] = new String("[[custom_1]]");
	bufferarray[16][0] = new String("[[custom_2]]");
	bufferarray[17][0] = new String("[[custom_3]]");
	bufferarray[18][0] = new String("[[item_errors]]");
	bufferarray[19][0] = new String("[[item_date_listed]]");
	bufferarray[20][0] = new String("[[item_date_listed_day]]");
	bufferarray[21][0] = new String("[[item_date_listed_int]]");
	bufferarray[22][0] = new String("[[item_hits]]");
	bufferarray[23][0] = new String("[[item_confirm_code]]");
	bufferarray[24][0] = new String("[[item_confirmed]]");
	bufferarray[25][0] = new String("[[item_cost]]");
	bufferarray[26][0] = new String("[[item_description]]");
	bufferarray[27][0] = new String("[[item_id]]");
	bufferarray[28][0] = new String("[[item_price]]");
	bufferarray[29][0] = new String("[[item_weight]]");
	bufferarray[30][0] = new String("[[item_listing_id]]");
	bufferarray[31][0] = new String("[[item_notes]]");
	bufferarray[32][0] = new String("[[item_package_d]]");
	bufferarray[33][0] = new String("[[item_package_l]]");
	bufferarray[34][0] = new String("[[item_package_w]]");
	bufferarray[35][0] = new String("[[item_part_number]]");
	bufferarray[36][0] = new String("[[item_title]]");
	bufferarray[37][0] = new String("[[item_title_url]]");
	bufferarray[38][0] = new String("[[item_type]]");
	bufferarray[39][0] = new String("[[item_search_1]]");
	bufferarray[40][0] = new String("[[item_search_2]]");
	bufferarray[41][0] = new String("[[item_search_3]]");
	bufferarray[42][0] = new String("[[item_site_id]]");
	bufferarray[43][0] = new String("[[item_site_url]]");
	bufferarray[44][0] = new String("[[item_picture_1]]");
	bufferarray[45][0] = new String("[[item_total_on_hand]]");
	bufferarray[46][0] = new String("[[sale_date_payment_received]]");
	bufferarray[47][0] = new String("[[sale_date_shipped]]");
	bufferarray[48][0] = new String("[[sale_date_sold]]");
	bufferarray[49][0] = new String("[[sale_final_value_fee]]");
	bufferarray[50][0] = new String("[[sale_handling]]");
	bufferarray[51][0] = new String("[[sale_payment_address]]");
	bufferarray[52][0] = new String("[[sale_payment_type]]");
	bufferarray[53][0] = new String("[[sale_fees]]");
	bufferarray[54][0] = new String("[[sale_quantity_sold]]");
	bufferarray[55][0] = new String("[[sale_id]]");
	bufferarray[56][0] = new String("[[sale_seller_id]]");
	bufferarray[57][0] = new String("[[sale_status]]");
	bufferarray[58][0] = new String("[[sale_tax]]");
	bufferarray[59][0] = new String("[[sale_shipping_company]]");
	bufferarray[60][0] = new String("[[sale_shipping_in]]");
	bufferarray[61][0] = new String("[[sale_shipping_out]]");
	bufferarray[62][0] = new String("[[sale_source_of_sale]]");
	bufferarray[63][0] = new String("[[sale_total_sale_amount]]");
	bufferarray[64][0] = new String("[[sale_tracking_number]]");
	bufferarray[65][0] = new String("[[sale_transaction_id]]");
	bufferarray[66][0] = new String("[[sale_transaction_info]]");
	bufferarray[67][0] = new String("[[seller_address_1]]");
	bufferarray[68][0] = new String("[[seller_address_2]]");
	bufferarray[69][0] = new String("[[seller_address_city]]");
	bufferarray[70][0] = new String("[[seller_address_state]]");
	bufferarray[71][0] = new String("[[seller_address_zip]]");
	bufferarray[72][0] = new String("[[seller_address_country]]");
	bufferarray[73][0] = new String("[[seller_id]]");
	bufferarray[74][0] = new String("[[seller_ip]]");
	bufferarray[75][0] = new String("[[seller_email]]");
	bufferarray[76][0] = new String("[[seller_first_name]]");
	bufferarray[77][0] = new String("[[seller_last_name]]");
	bufferarray[78][0] = new String("[[seller_notes]]");
	bufferarray[79][0] = new String("[[seller_phone]]");
	bufferarray[80][0] = new String("[[seller_logo]]");
	bufferarray[81][0] = new String("[[seller_url]]");



	}//**********************




}//last
