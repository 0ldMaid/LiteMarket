import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.ServerSocket;

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

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;



//RPC commands

//lmx_active              program active or not returns error or 1
//lmx_get_info            returns program info

//lmx_get_items_count     returns the items for sale count
//lmx_get_items_list      returns the item ID list
//lmx_get_item_x          returns info about a given item by sale ID

//lmx_get_sales_count     returns the sales count
//lmx_get_sales_list      returns the sales ID list
//lmx_get_sale_x          returns info about a given sale by sale ID
//lmx_confirm_sales       confirms payment for items
//lmx_confirm_shipped     confirms item shipped

//lmx_get_purchase_count  returns the purchased items count
//lmx_get_purchase_list   returns the purchase ID list
//lmx_get_purchase_x      returns a purchase by ID

//lmx_get_balance         gets the balance shown in the program
//lmx_refresh_balance     refreshes the balance from the connected wallet
//lmx_get_store           gets the store name
//lmx_get_wallet_type     gets the wallet type connected to the program blockchain.info or bitcoind

//lmx_add_item            adds a new item from info provided
//lmx_edit_item           edit an item by ID











public class litemarket_api{


JSONObject jsonObject;

Timer xtimerx;//class loop.
Toolkit toolkit;

String jsonText = new String("");
String responsex = new String("");
String clientSentence;          
String capitalizedSentence;          

String passwordx = new String("");

//response object
JSONObject obj_responsex = new JSONObject();






String import1 = new String("");
String import2 = new String("");
String import3 = new String("");
String import4 = new String("");
String import5 = new String("");
String import6 = new String("");
String import7 = new String("");
String import8 = new String("");
String import9 = new String("");
String import10 = new String("");
String import11 = new String("");
String import12 = new String("");
String import13 = new String("");
String import14 = new String("");
String import15 = new String("");
String import16 = new String("");
String import17 = new String("");
String import18 = new String("");
String import19 = new String("");
String import20 = new String("");
String import21 = new String("");
String import22 = new String("");
String import23 = new String("");
String import24 = new String("");
String import25 = new String("");
String import26 = new String("");
String import27 = new String("");
String import28 = new String("");
String import29 = new String("");
String import30 = new String("");
String import31 = new String("");
String import32 = new String("");
String import33 = new String("");










litemarket_api(){//*****************************************************************

System.out.println("Start API Server");

toolkit = Toolkit.getDefaultToolkit();
xtimerx = new Timer();
xtimerx.schedule(new RemindTask_server(), 0);

}//*********************************************************************************














	class RemindTask_server extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************




	ServerSocket welcomeSocket;

	while(true){   


try{//*********************************************************     

	welcomeSocket = new ServerSocket(lm.api_port, 0, InetAddress.getByName("localhost"));
	Socket connectionSocket = welcomeSocket.accept(); 
	BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
	DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());             
	clientSentence = inFromClient.readLine();



	JSONParser parser = new JSONParser();

try{//*********************************************************
 

		jsonText = "";

		if(!clientSentence.contains(lm.program_id)){throw new EmptyStackException();}
		Object obj = parser.parse(clientSentence);
 
		jsonObject = (JSONObject) obj;
  
		String request = (String) jsonObject.get(lm.program_id);
		String password = (String) jsonObject.get("password");
		passwordx = password;
		System.out.println(request);




		//reset
		obj_responsex = new JSONObject();


		//response JSON
		if(request.equals("lmx_active")){
		System.out.println("active status");

		obj_responsex.put("request", 1);
		obj_responsex.put("message", "active");

		}//*****************************




		else if(request.equals("lmx_get_info")){
		System.out.println("get store info");

		obj_responsex.put("request", 1);
		obj_responsex.put("message", "active");
		obj_responsex.put("store_name", lm.carbon_settings[7]);
		obj_responsex.put("balance", Float.parseFloat(lm.wallet_value_s));
		obj_responsex.put("currency", lm.carbon_settings[9]);
		obj_responsex.put("wallet_id", lm.carbon_settings[11]);
		obj_responsex.put("items", lm.carbon_sell[0].length);
		obj_responsex.put("sales", lm.carbon_sold[0].length);
		obj_responsex.put("purchases", lm.carbon_purchase[0].length);

		}//********************************




		else if(request.equals("lmx_get_items_count")){
		System.out.println("request item count");

		obj_responsex.put("request", 1);
		obj_responsex.put("message", lm.carbon_sell[0].length);

		}//********************************************




		else if(request.equals("lmx_get_items_list")){
		System.out.println("request item list");

		obj_responsex.put("request", 1);
	        LinkedList list = new LinkedList();


			for(int xloop0 = 1; xloop0 < lm.carbon_sell[0].length; xloop0++){//**********************

				list.add(lm.carbon_sell[lm.item_id_xx][xloop0]);

			}//**************************************************************************************


		obj_responsex.put("message", list);

		}//*******************************************




		else if(request.equals("lmx_get_item_x")){
		System.out.println("request item to buy");

		String request_id = (String) jsonObject.get("item_id");
		int foundx = 0;


			for(int xloop0 = 1; xloop0 < lm.carbon_sell[0].length; xloop0++){//**********************

			if(request_id.equals(lm.carbon_sell[lm.item_id_xx][xloop0])){

				obj_responsex.put("currency",             lm.carbon_sell[13][xloop0]);
				obj_responsex.put("custom_template",      lm.carbon_sell[14][xloop0]);
				obj_responsex.put("custom_1",             lm.carbon_sell[15][xloop0]);
				obj_responsex.put("custom_2",             lm.carbon_sell[16][xloop0]);
				obj_responsex.put("custom_3",             lm.carbon_sell[17][xloop0]);
				obj_responsex.put("item_errors",          lm.carbon_sell[18][xloop0]);
				obj_responsex.put("item_date_listed",     lm.carbon_sell[19][xloop0]);
				obj_responsex.put("item_date_listed_day", lm.carbon_sell[20][xloop0]);
				obj_responsex.put("item_date_listed_int", lm.carbon_sell[21][xloop0]);
				obj_responsex.put("item_hits",            lm.carbon_sell[22][xloop0]);
				obj_responsex.put("item_confirm_code",    lm.carbon_sell[23][xloop0]);
				obj_responsex.put("item_confirmed",       lm.carbon_sell[24][xloop0]);
				obj_responsex.put("item_cost",            lm.carbon_sell[25][xloop0]);
				obj_responsex.put("item_description",     lm.carbon_sell[26][xloop0]);
				obj_responsex.put("item_id",              lm.carbon_sell[27][xloop0]);
				obj_responsex.put("item_price",           lm.carbon_sell[28][xloop0]);
				obj_responsex.put("item_weight",          lm.carbon_sell[29][xloop0]);
				obj_responsex.put("item_listing_id",      lm.carbon_sell[30][xloop0]);
				obj_responsex.put("item_notes",           lm.carbon_sell[31][xloop0]);
				obj_responsex.put("item_package_d",       lm.carbon_sell[32][xloop0]);
				obj_responsex.put("item_package_l",       lm.carbon_sell[33][xloop0]);
				obj_responsex.put("item_package_w",       lm.carbon_sell[34][xloop0]);
				obj_responsex.put("item_part_number",     lm.carbon_sell[35][xloop0]);
				obj_responsex.put("item_title",           lm.carbon_sell[36][xloop0]);
				obj_responsex.put("item_title_url",       lm.carbon_sell[37][xloop0]);
				obj_responsex.put("item_type",            lm.carbon_sell[38][xloop0]);
				obj_responsex.put("item_search_1",        lm.carbon_sell[39][xloop0]);
				obj_responsex.put("item_search_2",        lm.carbon_sell[40][xloop0]);
				obj_responsex.put("item_search_3",        lm.carbon_sell[41][xloop0]);
				obj_responsex.put("item_site_id",         lm.carbon_sell[42][xloop0]);
				obj_responsex.put("item_site_url",        lm.carbon_sell[43][xloop0]);
				obj_responsex.put("item_picture_1",       lm.carbon_sell[44][xloop0]);
				obj_responsex.put("item_total_on_hand",   lm.carbon_sell[45][xloop0]);

			foundx = 1;

			}//if********************************************************

			}//**************************************************************************************


		   if(foundx == 1){obj_responsex.put("message", "success");}
		   else{obj_responsex.put("message", "Cannot find item ID: " + request_id);}

		}//***************************************




		else if(request.equals("lmx_get_sales_count")){
		System.out.println("request sales count");

		obj_responsex.put("request", 1);
		obj_responsex.put("message", lm.carbon_sold[0].length);

		}//********************************************




		else if(request.equals("lmx_get_sales_list")){
		System.out.println("request sales list");

		obj_responsex.put("request", 1);
	        LinkedList list = new LinkedList();


			for(int xloop0 = 0; xloop0 < lm.carbon_sold[0].length; xloop0++){//**********************

				list.add(lm.carbon_sold[lm.sale_id_xx][xloop0]);

			}//**************************************************************************************


		obj_responsex.put("message", list);

		}//*******************************************




		else if(request.equals("lmx_get_sale_x")){
		System.out.println("request sale info");

		String request_id = (String) jsonObject.get("sale_id");
		int foundx = 0;


			for(int xloop0 = 0; xloop0 < lm.carbon_sold[0].length; xloop0++){//**********************

			if(request_id.equals(lm.carbon_sold[lm.sale_id_xx][xloop0])){

				obj_responsex.put("buyer_address_1",            lm.carbon_sold[0][xloop0]);
				obj_responsex.put("buyer_address_2",            lm.carbon_sold[1][xloop0]);
				obj_responsex.put("buyer_address_city",         lm.carbon_sold[2][xloop0]);
				obj_responsex.put("buyer_address_state",        lm.carbon_sold[3][xloop0]);
				obj_responsex.put("buyer_address_zip",          lm.carbon_sold[4][xloop0]);
				obj_responsex.put("buyer_address_country",      lm.carbon_sold[5][xloop0]);
				obj_responsex.put("buyer_id",                   lm.carbon_sold[6][xloop0]);
				obj_responsex.put("buyer_ip",                   lm.carbon_sold[7][xloop0]);
				obj_responsex.put("buyers_email",               lm.carbon_sold[8][xloop0]);
				obj_responsex.put("buyers_first_name",          lm.carbon_sold[9][xloop0]);
				obj_responsex.put("buyers_last_name",           lm.carbon_sold[10][xloop0]);
				obj_responsex.put("buyers_payment_address",     lm.carbon_sold[11][xloop0]);
				obj_responsex.put("buyers_phone",               lm.carbon_sold[12][xloop0]);
				obj_responsex.put("currency",                   lm.carbon_sold[13][xloop0]);
				obj_responsex.put("custom_template",            lm.carbon_sold[14][xloop0]);
				obj_responsex.put("custom_1",                   lm.carbon_sold[15][xloop0]);
				obj_responsex.put("custom_2",                   lm.carbon_sold[16][xloop0]);
				obj_responsex.put("custom_3",                   lm.carbon_sold[17][xloop0]);
				obj_responsex.put("item_errors",                lm.carbon_sold[18][xloop0]);
				obj_responsex.put("item_date_listed",           lm.carbon_sold[19][xloop0]);
				obj_responsex.put("item_date_listed_day",       lm.carbon_sold[20][xloop0]);
				obj_responsex.put("item_date_listed_int",       lm.carbon_sold[21][xloop0]);
				obj_responsex.put("item_hits",                  lm.carbon_sold[22][xloop0]);
				obj_responsex.put("item_confirm_code",          lm.carbon_sold[23][xloop0]);
				obj_responsex.put("item_confirmed",             lm.carbon_sold[24][xloop0]);
				obj_responsex.put("item_cost",                  lm.carbon_sold[25][xloop0]);
				obj_responsex.put("item_description",           lm.carbon_sold[26][xloop0]);
				obj_responsex.put("item_id",                    lm.carbon_sold[27][xloop0]);
				obj_responsex.put("item_price",                 lm.carbon_sold[28][xloop0]);
				obj_responsex.put("item_weight",                lm.carbon_sold[29][xloop0]);
				obj_responsex.put("item_listing_id",            lm.carbon_sold[30][xloop0]);
				obj_responsex.put("item_notes",                 lm.carbon_sold[31][xloop0]);
				obj_responsex.put("item_package_d",             lm.carbon_sold[32][xloop0]);
				obj_responsex.put("item_package_l",             lm.carbon_sold[33][xloop0]);
				obj_responsex.put("item_package_w",             lm.carbon_sold[34][xloop0]);
				obj_responsex.put("item_part_number",           lm.carbon_sold[35][xloop0]);
				obj_responsex.put("item_title",                 lm.carbon_sold[36][xloop0]);
				obj_responsex.put("item_title_url",             lm.carbon_sold[37][xloop0]);
				obj_responsex.put("item_type",                  lm.carbon_sold[38][xloop0]);
				obj_responsex.put("item_search_1",              lm.carbon_sold[39][xloop0]);
				obj_responsex.put("item_search_2",              lm.carbon_sold[40][xloop0]);
				obj_responsex.put("item_search_3",              lm.carbon_sold[41][xloop0]);
				obj_responsex.put("item_site_id",               lm.carbon_sold[42][xloop0]);
				obj_responsex.put("item_site_url",              lm.carbon_sold[43][xloop0]);
				obj_responsex.put("item_picture_1",             lm.carbon_sold[44][xloop0]);
				obj_responsex.put("item_total_on_hand",         lm.carbon_sold[45][xloop0]);
				obj_responsex.put("sale_date_payment_received", lm.carbon_sold[46][xloop0]);
				obj_responsex.put("sale_date_shipped",          lm.carbon_sold[47][xloop0]);
				obj_responsex.put("sale_date_sold",             lm.carbon_sold[48][xloop0]);
				obj_responsex.put("sale_final_value_fee",       lm.carbon_sold[49][xloop0]);
				obj_responsex.put("sale_handling",              lm.carbon_sold[50][xloop0]);
				obj_responsex.put("sale_payment_address",       lm.carbon_sold[51][xloop0]);
				obj_responsex.put("sale_payment_type",          lm.carbon_sold[52][xloop0]);
				obj_responsex.put("sale_fees",                  lm.carbon_sold[53][xloop0]);
				obj_responsex.put("sale_quantity_sold",         lm.carbon_sold[54][xloop0]);
				obj_responsex.put("sale_id",                    lm.carbon_sold[55][xloop0]);
				obj_responsex.put("sale_seller_id",             lm.carbon_sold[56][xloop0]);
				obj_responsex.put("sale_status",                lm.carbon_sold[57][xloop0]);
				obj_responsex.put("sale_tax",                   lm.carbon_sold[58][xloop0]);
				obj_responsex.put("sale_shipping_company",      lm.carbon_sold[59][xloop0]);
				obj_responsex.put("sale_shipping_in",           lm.carbon_sold[60][xloop0]);
				obj_responsex.put("sale_shipping_out",          lm.carbon_sold[61][xloop0]);
				obj_responsex.put("sale_source_of_sale",        lm.carbon_sold[62][xloop0]);
				obj_responsex.put("sale_total_sale_amount",     lm.carbon_sold[63][xloop0]);
				obj_responsex.put("sale_tracking_number",       lm.carbon_sold[64][xloop0]);
				obj_responsex.put("sale_transaction_id",        lm.carbon_sold[65][xloop0]);
				obj_responsex.put("sale_transaction_info",      lm.carbon_sold[66][xloop0]);
				obj_responsex.put("seller_address_1",           lm.carbon_sold[67][xloop0]);
				obj_responsex.put("seller_address_2",           lm.carbon_sold[68][xloop0]);
				obj_responsex.put("seller_address_city",        lm.carbon_sold[69][xloop0]);
				obj_responsex.put("seller_address_state",       lm.carbon_sold[70][xloop0]);
				obj_responsex.put("seller_address_zip",         lm.carbon_sold[71][xloop0]);
				obj_responsex.put("seller_address_country",     lm.carbon_sold[72][xloop0]);
				obj_responsex.put("seller_id",                  lm.carbon_sold[73][xloop0]);
				obj_responsex.put("seller_ip",                  lm.carbon_sold[74][xloop0]);
				obj_responsex.put("seller_email",               lm.carbon_sold[75][xloop0]);
				obj_responsex.put("seller_first_name",          lm.carbon_sold[76][xloop0]);
				obj_responsex.put("seller_last_name",           lm.carbon_sold[77][xloop0]);
				obj_responsex.put("seller_notes",               lm.carbon_sold[78][xloop0]);
				obj_responsex.put("seller_phone",               lm.carbon_sold[79][xloop0]);
				obj_responsex.put("seller_logo",                lm.carbon_sold[80][xloop0]);
				obj_responsex.put("seller_url",                 lm.carbon_sold[81][xloop0]);

			foundx = 1;

			}//if********************************************************

			}//**************************************************************************************


		   if(foundx == 1){obj_responsex.put("request", "1"); obj_responsex.put("message", "success");}
		   else{obj_responsex.put("request", "0");  obj_responsex.put("message", "Cannot find item ID: " + request_id);}

		}//***************************************




		else if(request.equals("lmx_get_purchase_count")){
		System.out.println("request purchase count");

		obj_responsex.put("request", 1);
		obj_responsex.put("message", lm.carbon_purchase[0].length);

		}//********************************************




		else if(request.equals("lmx_get_purchase_list")){
		System.out.println("request purchase list");

		obj_responsex.put("request", 1);
		Map json_OrderLines = new HashMap();
		List l1 = new LinkedList();


			for(int xloop0 = 0; xloop0 < lm.carbon_purchase[0].length; xloop0++){//*********************

				json_OrderLines.put("item_id" + Integer.toString(xloop0), lm.carbon_purchase[lm.sale_id_xx][xloop0]);

			}//*****************************************************************************************


		l1.add(json_OrderLines);
		obj_responsex.put("message", l1);

		}//*******************************************




		else if(request.equals("lmx_get_purchase_x")){
		System.out.println("request purchase info");

		String request_id = (String) jsonObject.get("sale_id");
		int foundx = 0;


			for(int xloop0 = 0; xloop0 < lm.carbon_purchase[0].length; xloop0++){//**********************

			if(request_id.equals(lm.carbon_purchase[lm.sale_id_xx][xloop0])){

				obj_responsex.put("buyer_address_1",            lm.carbon_purchase[0][xloop0]);
				obj_responsex.put("buyer_address_2",            lm.carbon_purchase[1][xloop0]);
				obj_responsex.put("buyer_address_city",         lm.carbon_purchase[2][xloop0]);
				obj_responsex.put("buyer_address_state]",       lm.carbon_purchase[3][xloop0]);
				obj_responsex.put("buyer_address_zip",          lm.carbon_purchase[4][xloop0]);
				obj_responsex.put("buyer_address_country",      lm.carbon_purchase[5][xloop0]);
				obj_responsex.put("buyer_id",                   lm.carbon_purchase[6][xloop0]);
				obj_responsex.put("buyer_ip",                   lm.carbon_purchase[7][xloop0]);
				obj_responsex.put("buyers_email",               lm.carbon_purchase[8][xloop0]);
				obj_responsex.put("buyers_first_name",          lm.carbon_purchase[9][xloop0]);
				obj_responsex.put("buyers_last_name",           lm.carbon_purchase[10][xloop0]);
				obj_responsex.put("buyers_payment_address",     lm.carbon_purchase[11][xloop0]);
				obj_responsex.put("buyers_phone",               lm.carbon_purchase[12][xloop0]);
				obj_responsex.put("currency",                   lm.carbon_purchase[13][xloop0]);
				obj_responsex.put("custom_template",            lm.carbon_purchase[14][xloop0]);
				obj_responsex.put("custom_1",                   lm.carbon_purchase[15][xloop0]);
				obj_responsex.put("custom_2",                   lm.carbon_purchase[16][xloop0]);
				obj_responsex.put("custom_3",                   lm.carbon_purchase[17][xloop0]);
				obj_responsex.put("item_errors",                lm.carbon_purchase[18][xloop0]);
				obj_responsex.put("item_date_listed",           lm.carbon_purchase[19][xloop0]);
				obj_responsex.put("item_date_listed_day",       lm.carbon_purchase[20][xloop0]);
				obj_responsex.put("item_date_listed_int",       lm.carbon_purchase[21][xloop0]);
				obj_responsex.put("item_hits",                  lm.carbon_purchase[22][xloop0]);
				obj_responsex.put("item_confirm_code",          lm.carbon_purchase[23][xloop0]);
				obj_responsex.put("item_confirmed",             lm.carbon_purchase[24][xloop0]);
				obj_responsex.put("item_cost",                  lm.carbon_purchase[25][xloop0]);
				obj_responsex.put("item_description",           lm.carbon_purchase[26][xloop0]);
				obj_responsex.put("item_id",                    lm.carbon_purchase[27][xloop0]);
				obj_responsex.put("item_price",                 lm.carbon_purchase[28][xloop0]);
				obj_responsex.put("item_weight",                lm.carbon_purchase[29][xloop0]);
				obj_responsex.put("item_listing_id",            lm.carbon_purchase[30][xloop0]);
				obj_responsex.put("item_notes",                 lm.carbon_purchase[31][xloop0]);
				obj_responsex.put("item_package_d",             lm.carbon_purchase[32][xloop0]);
				obj_responsex.put("item_package_l",             lm.carbon_purchase[33][xloop0]);
				obj_responsex.put("item_package_w",             lm.carbon_purchase[34][xloop0]);
				obj_responsex.put("item_part_number",           lm.carbon_purchase[35][xloop0]);
				obj_responsex.put("item_title",                 lm.carbon_purchase[36][xloop0]);
				obj_responsex.put("item_title_url",             lm.carbon_purchase[37][xloop0]);
				obj_responsex.put("item_type",                  lm.carbon_purchase[38][xloop0]);
				obj_responsex.put("item_search_1",              lm.carbon_purchase[39][xloop0]);
				obj_responsex.put("item_search_2",              lm.carbon_purchase[40][xloop0]);
				obj_responsex.put("item_search_3",              lm.carbon_purchase[41][xloop0]);
				obj_responsex.put("item_site_id",               lm.carbon_purchase[42][xloop0]);
				obj_responsex.put("item_site_url",              lm.carbon_purchase[43][xloop0]);
				obj_responsex.put("item_picture_1",             lm.carbon_purchase[44][xloop0]);
				obj_responsex.put("item_total_on_hand",         lm.carbon_purchase[45][xloop0]);
				obj_responsex.put("sale_date_payment_received", lm.carbon_purchase[46][xloop0]);
				obj_responsex.put("sale_date_shipped",          lm.carbon_purchase[47][xloop0]);
				obj_responsex.put("sale_date_sold",             lm.carbon_purchase[48][xloop0]);
				obj_responsex.put("sale_final_value_fee",       lm.carbon_purchase[49][xloop0]);
				obj_responsex.put("sale_handling",              lm.carbon_purchase[50][xloop0]);
				obj_responsex.put("sale_payment_address",       lm.carbon_purchase[51][xloop0]);
				obj_responsex.put("sale_payment_type",          lm.carbon_purchase[52][xloop0]);
				obj_responsex.put("sale_fees",                  lm.carbon_purchase[53][xloop0]);
				obj_responsex.put("sale_quantity_sold",         lm.carbon_purchase[54][xloop0]);
				obj_responsex.put("sale_id",                    lm.carbon_purchase[55][xloop0]);
				obj_responsex.put("sale_seller_id",             lm.carbon_purchase[56][xloop0]);
				obj_responsex.put("sale_status",                lm.carbon_purchase[57][xloop0]);
				obj_responsex.put("sale_tax",                   lm.carbon_purchase[58][xloop0]);
				obj_responsex.put("sale_shipping_company",      lm.carbon_purchase[59][xloop0]);
				obj_responsex.put("sale_shipping_in",           lm.carbon_purchase[60][xloop0]);
				obj_responsex.put("sale_shipping_out",          lm.carbon_purchase[61][xloop0]);
				obj_responsex.put("sale_source_of_sale",        lm.carbon_purchase[62][xloop0]);
				obj_responsex.put("sale_total_sale_amount",     lm.carbon_purchase[63][xloop0]);
				obj_responsex.put("sale_tracking_number",       lm.carbon_purchase[64][xloop0]);
				obj_responsex.put("sale_transaction_id",        lm.carbon_purchase[65][xloop0]);
				obj_responsex.put("sale_transaction_info",      lm.carbon_purchase[66][xloop0]);
				obj_responsex.put("seller_address_1",           lm.carbon_purchase[67][xloop0]);
				obj_responsex.put("seller_address_2",           lm.carbon_purchase[68][xloop0]);
				obj_responsex.put("seller_address_city",        lm.carbon_purchase[69][xloop0]);
				obj_responsex.put("seller_address_state",       lm.carbon_purchase[70][xloop0]);
				obj_responsex.put("seller_address_zip",         lm.carbon_purchase[71][xloop0]);
				obj_responsex.put("seller_address_country",     lm.carbon_purchase[72][xloop0]);
				obj_responsex.put("seller_id",                  lm.carbon_purchase[73][xloop0]);
				obj_responsex.put("seller_ip",                  lm.carbon_purchase[74][xloop0]);
				obj_responsex.put("seller_email",               lm.carbon_purchase[75][xloop0]);
				obj_responsex.put("seller_first_name",          lm.carbon_purchase[76][xloop0]);
				obj_responsex.put("seller_last_name",           lm.carbon_purchase[77][xloop0]);
				obj_responsex.put("seller_notes",               lm.carbon_purchase[78][xloop0]);
				obj_responsex.put("seller_phone",               lm.carbon_purchase[79][xloop0]);
				obj_responsex.put("seller_logo",                lm.carbon_purchase[80][xloop0]);
				obj_responsex.put("seller_url",                 lm.carbon_purchase[81][xloop0]);

			foundx = 1;

			}//if********************************************************

			}//**************************************************************************************


		   if(foundx == 1){obj_responsex.put("message", "success");}
		   else{obj_responsex.put("message", "Cannot find item ID: " + request_id);}

		}//***************************************




		else if(request.equals("lmx_add_item")){
		System.out.println("add item to market");

		try{

		add_item_market();
		obj_responsex.put("request", 1);
		obj_responsex.put("message", "success");

		}catch(Exception e){e.printStackTrace(); obj_responsex.put("request", 0); obj_responsex.put("message", "Error adding item to array!");}



		}//********************************************

		else{obj_responsex.put("request", 0); obj_responsex.put("message", "Cannot find item ID: " + request);}





}//try
catch(ParseException e){e.printStackTrace(); obj_responsex.put("request", 0); obj_responsex.put("message", "JSON Error");}
catch(Exception e){obj_responsex.put("request", 0); obj_responsex.put("message", "Unknown Error");}



		StringWriter outx = new StringWriter();
		obj_responsex.writeJSONString(outx);
		jsonText = outx.toString();
		System.out.println(jsonText);


		outToClient.writeBytes(jsonText + '\n');
		welcomeSocket.close();

}//try
catch(Exception e){System.out.println("API ERROR"); e.printStackTrace();}





         
	}//**********while




	}//runx***************************************************************************************************
        }//remindtask











	public void add_item_market(){



//pass over the items to the new list
	  int list_total = lm.carbon_sell[0].length + 1;

	  String[][] carbon_sell_hold = new String[lm.carbon_sell.length][list_total];

	  int new_row = 1;


	  for(int xloopx1 = 2; xloopx1 < list_total; xloopx1++){//****************
	  for(int xloopx2 = 0; xloopx2 < lm.carbon_sell.length; xloopx2++){//****************

		carbon_sell_hold[xloopx2][xloopx1] =  lm.carbon_sell[xloopx2][new_row]; 
		
	  }//********************************************************************************

	       System.out.println(lm.carbon_sell[0][new_row]);
	       new_row++;

	  }//**********************************************************************

		lm.carbon_sell = carbon_sell_hold;




//add the new item to the list after the header

	lm.carbon_sell[0][0] = new String("[[buyer_address_1]]");
	lm.carbon_sell[1][0] = new String("[[buyer_address_2]]");
	lm.carbon_sell[2][0] = new String("[[buyer_address_city]]");
	lm.carbon_sell[3][0] = new String("[[buyer_address_state]]");
	lm.carbon_sell[4][0] = new String("[[buyer_address_zip]]");
	lm.carbon_sell[5][0] = new String("[[buyer_address_country]]");
	lm.carbon_sell[6][0] = new String("[[buyer_id]]");
	lm.carbon_sell[7][0] = new String("[[buyer_ip]]");
	lm.carbon_sell[8][0] = new String("[[buyers_email]]");
	lm.carbon_sell[9][0] = new String("[[buyers_first_name]]");
	lm.carbon_sell[10][0] = new String("[[buyers_last_name]]");
	lm.carbon_sell[11][0] = new String("[[buyers_payment_address]]");
	lm.carbon_sell[12][0] = new String("[[buyers_phone]]");
	lm.carbon_sell[13][0] = new String("[[currency]]");
	lm.carbon_sell[14][0] = new String("[[custom_template]]");
	lm.carbon_sell[15][0] = new String("[[custom_1]]");
	lm.carbon_sell[16][0] = new String("[[custom_2]]");
	lm.carbon_sell[17][0] = new String("[[custom_3]]");
	lm.carbon_sell[18][0] = new String("[[item_errors]]");
	lm.carbon_sell[19][0] = new String("[[item_date_listed]]");
	lm.carbon_sell[20][0] = new String("[[item_date_listed_day]]");
	lm.carbon_sell[21][0] = new String("[[item_date_listed_int]]");
	lm.carbon_sell[22][0] = new String("[[item_hits]]");
	lm.carbon_sell[23][0] = new String("[[item_confirm_code]]");
	lm.carbon_sell[24][0] = new String("[[item_confirmed]]");
	lm.carbon_sell[25][0] = new String("[[item_cost]]");
	lm.carbon_sell[26][0] = new String("[[item_description]]");
	lm.carbon_sell[27][0] = new String("[[item_id]]");
	lm.carbon_sell[28][0] = new String("[[item_price]]");
	lm.carbon_sell[29][0] = new String("[[item_weight]]");
	lm.carbon_sell[30][0] = new String("[[item_listing_id]]");
	lm.carbon_sell[31][0] = new String("[[item_notes]]");
	lm.carbon_sell[32][0] = new String("[[item_package_d]]");
	lm.carbon_sell[33][0] = new String("[[item_package_l]]");
	lm.carbon_sell[34][0] = new String("[[item_package_w]]");
	lm.carbon_sell[35][0] = new String("*[[item_part_number]]");
	lm.carbon_sell[36][0] = new String("[[item_title]]");
	lm.carbon_sell[37][0] = new String("[[item_title_url]]");
	lm.carbon_sell[38][0] = new String("[[item_type]]");
	lm.carbon_sell[39][0] = new String("[[item_search_1]]");
	lm.carbon_sell[40][0] = new String("[[item_search_2]]");
	lm.carbon_sell[41][0] = new String("[[item_search_3]]");
	lm.carbon_sell[42][0] = new String("[[item_site_id]]");
	lm.carbon_sell[43][0] = new String("[[item_site_url]]");
	lm.carbon_sell[44][0] = new String("[[item_picture_1]]");
	lm.carbon_sell[45][0] = new String("[[item_total_on_hand]]");
	lm.carbon_sell[46][0] = new String("[[sale_date_payment_received]]");
	lm.carbon_sell[47][0] = new String("[[sale_date_shipped]]");
	lm.carbon_sell[48][0] = new String("[[sale_date_sold]]");
	lm.carbon_sell[49][0] = new String("[[sale_final_value_fee]]");
	lm.carbon_sell[50][0] = new String("[[sale_handling]]");
	lm.carbon_sell[51][0] = new String("[[sale_payment_address]]");
	lm.carbon_sell[52][0] = new String("[[sale_payment_type]]");
	lm.carbon_sell[53][0] = new String("[[sale_fees]]");
	lm.carbon_sell[54][0] = new String("[[sale_quantity_sold]]");
	lm.carbon_sell[55][0] = new String("[[sale_id]]");
	lm.carbon_sell[56][0] = new String("[[sale_seller_id]]");
	lm.carbon_sell[57][0] = new String("[[sale_status]]");
	lm.carbon_sell[58][0] = new String("[[sale_tax]]");
	lm.carbon_sell[59][0] = new String("[[sale_shipping_company]]");
	lm.carbon_sell[60][0] = new String("[[sale_shipping_in]]");
	lm.carbon_sell[61][0] = new String("[[sale_shipping_out]]");
	lm.carbon_sell[62][0] = new String("[[sale_source_of_sale]]");
	lm.carbon_sell[63][0] = new String("[[sale_total_sale_amount]]");
	lm.carbon_sell[64][0] = new String("[[sale_tracking_number]]");
	lm.carbon_sell[65][0] = new String("[[sale_transaction_id]]");
	lm.carbon_sell[66][0] = new String("[[sale_transaction_info]]");
	lm.carbon_sell[67][0] = new String("[[seller_address_1]]");
	lm.carbon_sell[68][0] = new String("[[seller_address_2]]");
	lm.carbon_sell[69][0] = new String("[[seller_address_city]]");
	lm.carbon_sell[70][0] = new String("[[seller_address_state]]");
	lm.carbon_sell[71][0] = new String("[[seller_address_zip]]");
	lm.carbon_sell[72][0] = new String("[[seller_address_country]]");
	lm.carbon_sell[73][0] = new String("[[seller_id]]");
	lm.carbon_sell[74][0] = new String("[[seller_ip]]");
	lm.carbon_sell[75][0] = new String("[[seller_email]]");
	lm.carbon_sell[76][0] = new String("[[seller_first_name]]");
	lm.carbon_sell[77][0] = new String("[[seller_last_name]]");
	lm.carbon_sell[78][0] = new String("[[seller_notes]]");
	lm.carbon_sell[79][0] = new String("[[seller_phone]]");
	lm.carbon_sell[80][0] = new String("[[seller_logo]]");
	lm.carbon_sell[81][0] = new String("[[seller_url]]");


//add new item **********


	try{import1 =  (String) jsonObject.get("custom_template");}   catch(Exception e){import1 = "custom_template";}
	try{import2 =  (String) jsonObject.get("custom_1");}          catch(Exception e){import2 = "custom_1";}
	try{import3 =  (String) jsonObject.get("custom_2");}          catch(Exception e){import3 = "custom_2";}
	try{import4 =  (String) jsonObject.get("custom_3");}          catch(Exception e){import4 = "custom_3";}
	try{import5 =  (String) jsonObject.get("item_cost");}         catch(Exception e){import5 = "0.90000000";}
	try{import6 =  (String) jsonObject.get("item_description");}  catch(Exception e){import6 = "item_description";}
	try{import7 =  (String) jsonObject.get("item_price");}        catch(Exception e){import7 = "1.00000000";}
	try{import8 =  (String) jsonObject.get("item_weight");}       catch(Exception e){import8 = "33";}
	try{import9 =  (String) jsonObject.get("item_listing_id");}   catch(Exception e){import9 = "item_listing_id";}
	try{import10 = (String) jsonObject.get("item_notes");}        catch(Exception e){import10 = "item_notes";}
	try{import11 = (String) jsonObject.get("item_package_d");}    catch(Exception e){import11 = "5";}
	try{import12 = (String) jsonObject.get("item_package_l");}    catch(Exception e){import12 = "5";}
	try{import13 = (String) jsonObject.get("item_package_w");}    catch(Exception e){import13 = "10";}
	try{import14 = (String) jsonObject.get("item_part_number");}  catch(Exception e){import14 = "item_part_number";}
	try{import15 = (String) jsonObject.get("item_title");}        catch(Exception e){import15 = "item_title";}
	try{import16 = (String) jsonObject.get("item_search_1");}     catch(Exception e){import16 = "item_search_1";}
	try{import17 = (String) jsonObject.get("item_search_2");}     catch(Exception e){import17 = "item_search_2";}
	try{import18 = (String) jsonObject.get("item_search_3");}     catch(Exception e){import18 = "item_search_3";}
	try{import19 = (String) jsonObject.get("item_site_id");}      catch(Exception e){import19 = "item_site_id";}
	try{import20 = (String) jsonObject.get("item_site_url");}     catch(Exception e){import20 = "item_site_url";}
	try{import21 = (String) jsonObject.get("item_picture_1");}    catch(Exception e){import21 = "item_picture_1";}
	try{import22 = (String) jsonObject.get("item_total_on_hand");}catch(Exception e){import22 = "0";}


	if(import1 == null){import1 = "custom_template";}
	if(import2 == null){import2 = "custom_1";}
	if(import3 == null){import3 = "custom_2";}
	if(import4 == null){import4 = "custom_3";}
	if(import5 == null){import5 = "0.90000000";}
	if(import6 == null){import6 = "item_description";}
	if(import7 == null){import7 = "1.00000000";}
	if(import8 == null){import8 = "33";}
	if(import9 == null){import9 = "item_listing_id";}
	if(import10 == null){import10 = "item_notes";}
	if(import11 == null){import11 = "5";}
	if(import12 == null){import12 = "5";}
	if(import13 == null){import13 = "10";}
	if(import14 == null){import14 = "item_part_number";}
	if(import15 == null){import15 = "new item from api";}
	if(import16 == null){import16 = "item_search_1";}
	if(import17 == null){import17 = "item_search_2";}
	if(import18 == null){import18 = "item_search_3";}
	if(import19 == null){import19 = "item_site_id";}
	if(import20 == null){import20 = "item_site_url";}
	if(import21 == null){import21 = "item_picture_1";}
	if(import22 == null){import22 = "0";}


	lm.carbon_sell[0][1] = new String("buyer_address_1");
	lm.carbon_sell[1][1] = new String("buyer_address_2");
	lm.carbon_sell[2][1] = new String("buyer_address_city");
	lm.carbon_sell[3][1] = new String("buyer_address_state");
	lm.carbon_sell[4][1] = new String("buyer_address_zip");
	lm.carbon_sell[5][1] = new String("buyer_address_country");
	lm.carbon_sell[6][1] = new String("buyer_id");//BTC ADDRESS
	lm.carbon_sell[7][1] = new String("buyer_ip");
	lm.carbon_sell[8][1] = new String("buyers_email");
	lm.carbon_sell[9][1] = new String("buyers_first_name");
	lm.carbon_sell[10][1] = new String("buyers_last_name");
	lm.carbon_sell[11][1] = new String("buyers_payment_address");
	lm.carbon_sell[12][1] = new String("buyers_phone");
	lm.carbon_sell[13][1] = new String(lm.carbon_settings[9]);//currency
	lm.carbon_sell[14][1] = new String(import1);//custom_template
	lm.carbon_sell[15][1] = new String(import2);//custom_1
	lm.carbon_sell[16][1] = new String(import3);//custom_2
	lm.carbon_sell[17][1] = new String(import4);//custom_3
	lm.carbon_sell[18][1] = new String("item_errors");//item_errors
	lm.carbon_sell[19][1] = new String("item_date_listed");
	lm.carbon_sell[20][1] = new String("item_date_listed_day");
	lm.carbon_sell[21][1] = new String("item_date_listed_int");
	lm.carbon_sell[22][1] = new String("0");//hits
	lm.carbon_sell[23][1] = new String("item_confirm_code");
	lm.carbon_sell[24][1] = new String("item_confirmed");
	lm.carbon_sell[25][1] = new String(import5);//cost
	lm.carbon_sell[26][1] = new String(import6);//item_description
	lm.carbon_sell[27][1] = new String(Long.toString(System.currentTimeMillis()));//item_id
	lm.carbon_sell[28][1] = new String(import7);//sale price
	lm.carbon_sell[29][1] = new String(import8);//weight
	lm.carbon_sell[30][1] = new String("HIDDEN");//item_listing_id ACTIVE OR NOT 
	lm.carbon_sell[31][1] = new String(import10);//item_notes
	lm.carbon_sell[32][1] = new String(import11);//item_package_d
	lm.carbon_sell[33][1] = new String(import12);//item_package_l
	lm.carbon_sell[34][1] = new String(import13);//item_package_w
	lm.carbon_sell[35][1] = new String(import14);//item_part_number
	lm.carbon_sell[36][1] = new String(import15);//title
	lm.carbon_sell[37][1] = new String("item_title_url");
	lm.carbon_sell[38][1] = new String("item_type");
	lm.carbon_sell[39][1] = new String(import16);//item_search_1
	lm.carbon_sell[40][1] = new String(import17);//item_search_2
	lm.carbon_sell[41][1] = new String(import18);//item_search_3
	lm.carbon_sell[42][1] = new String(import19);//item_site_id
	lm.carbon_sell[43][1] = new String(import20);//item_site_url
	lm.carbon_sell[44][1] = new String(import21);//picture_1
	lm.carbon_sell[45][1] = new String(import22);//item_total_on_hand
	lm.carbon_sell[46][1] = new String("sale_date_payment_received");
	lm.carbon_sell[47][1] = new String("sale_date_shipped");
	lm.carbon_sell[48][1] = new String("sale_date_sold");
	lm.carbon_sell[49][1] = new String("sale_final_value_fee");
	lm.carbon_sell[50][1] = new String("sale_handling");
	lm.carbon_sell[51][1] = new String("sale_payment_address");
	lm.carbon_sell[52][1] = new String("sale_payment_type");
	lm.carbon_sell[53][1] = new String("sale_fees");
	lm.carbon_sell[54][1] = new String("sale_quantity_sold");
	lm.carbon_sell[55][1] = new String("sale_id");
	lm.carbon_sell[56][1] = new String("sale_seller_id");
	lm.carbon_sell[57][1] = new String("NEW");//sale_status
	lm.carbon_sell[58][1] = new String("0.00");//sale_tax
	lm.carbon_sell[59][1] = new String("sale_shipping_company");
	lm.carbon_sell[60][1] = new String("0.00");//sale_shipping_in
	lm.carbon_sell[61][1] = new String("0.00");//sale_shipping_out
	lm.carbon_sell[62][1] = new String("sale_source_of_sale");
	lm.carbon_sell[63][1] = new String("sale_total_sale_amount");
	lm.carbon_sell[64][1] = new String("sale_tracking_number");
	lm.carbon_sell[65][1] = new String("sale_transaction_id");
	lm.carbon_sell[66][1] = new String("sale_transaction_info");
	lm.carbon_sell[67][1] = new String("seller_address_1");
	lm.carbon_sell[68][1] = new String("seller_address_2");
	lm.carbon_sell[69][1] = new String("seller_address_city");
	lm.carbon_sell[70][1] = new String("seller_address_state");
	lm.carbon_sell[71][1] = new String("seller_address_zip");
	lm.carbon_sell[72][1] = new String("seller_address_country");
	lm.carbon_sell[73][1] = new String("seller_id");//BTC ADDRESS
	lm.carbon_sell[74][1] = new String("seller_ip");
	lm.carbon_sell[75][1] = new String("seller_email");
	lm.carbon_sell[76][1] = new String("seller_first_name");
	lm.carbon_sell[77][1] = new String("seller_last_name");
	lm.carbon_sell[78][1] = new String("seller_notes");
	lm.carbon_sell[79][1] = new String("seller_phone");
	lm.carbon_sell[80][1] = new String("seller_logo");
	lm.carbon_sell[81][1] = new String("seller_url");


	System.out.println("");


		for(int xloop1 = 0; xloop1 < lm.carbon_sell.length; xloop1++){//*************

		System.out.println(lm.carbon_sell[xloop1][1]);

		}//**************************************************************************


	}//***************************















}//last
