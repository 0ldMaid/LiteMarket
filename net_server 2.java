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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//import javax.servlet.http.HttpServletResponse;








public class net_server{


Timer xtimerx;//class loop.
Toolkit toolkit;

private ExecutorService executorService = Executors.newFixedThreadPool(10);  

ServerSocket serverSocket;




net_server(){//*****************************************************************

System.out.println("Start Server");

toolkit = Toolkit.getDefaultToolkit();
xtimerx = new Timer();
xtimerx.schedule(new RemindTask_server(), 0);

}//*****************************************************************************







class RemindTask_server extends TimerTask{
Runtime rxrunti = Runtime.getRuntime();

public void run(){//************************************************************************************





   while(true){//***

	try{

	    serverSocket = new ServerSocket(55555);
	    final Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                public void run() {

                    try{
                        startServer(socket);
                    }catch(Exception ex) {ex.printStackTrace();}

                }//****************
            }).start();

	}catch(Exception e){

		e.printStackTrace();
        	System.err.println("Accept failed");
        	//System.exit(1);

    	}//******************

   }//**********while



}//runx***************************************************************************************************
}//remindtask









public void startServer(Socket socket){//************************************************************************************




ServerSocket welcomeSocket;





JSONObject jsonObject = new JSONObject();
String SYSTEM_ERROR_MESSAGE = new String("");
String jsonText = new String("");
String responsex = new String("");
String clientSentence = new String("");          
String capitalizedSentence;          
String passwordx = new String("");
String client_ip = new String("");


try{//*********************************************************     

	InetAddress IP = InetAddress.getLocalHost();





        Socket clientSocket = null; 
        try{

            clientSocket = socket;
            if(clientSocket != null){System.out.println("Connected");}

	    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while (!(inputLine = in.readLine()).equals("")){

                System.out.println(inputLine);
		clientSentence = inputLine;

		if(inputLine.equals("\r") || inputLine.equals("\n")){System.out.println("BREAK>>>"); break;}
		else{System.out.println("xx");}

	    }//*****************************************
            //in.close();

	    System.out.println(">>>");

	    client_ip = clientSocket.getRemoteSocketAddress().toString();
	    System.out.println("CLIENT ADDRESS " + clientSocket.getRemoteSocketAddress().toString());

        }catch (IOException e) {
             System.err.println("Accept failed.");
             System.exit(1);
        }//*********************

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());


        //out.println("HTTP/1.1 200 OK");
        //out.println("Content-Type: text/html");
        //out.println("\r\n");
        //out.println("<p> Hello world </p>");










	int port_x = 0;
	port_x = client_ip.indexOf(":");

	if(port_x > -1){client_ip = client_ip.substring(0, port_x);}


//update ip list

	for(int xloop = 499; xloop > 0; xloop--){//******************************

	lm.ip_log[0][xloop] = lm.ip_log[0][(xloop -1)];
	lm.ip_log[1][xloop] = lm.ip_log[1][(xloop -1)];
	lm.ip_log[2][xloop] = lm.ip_log[2][(xloop -1)];
	lm.ip_log[3][xloop] = lm.ip_log[3][(xloop -1)];

	}//**********************************************************************



	DateFormat dateFormatx = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
	Date datex = new Date();
	System.out.println(dateFormatx.format(datex));


	lm.ip_log[0][0] = client_ip;
	lm.ip_log[1][0] = dateFormatx.format(datex).toString();
	lm.ip_log[2][0] = "error";
	lm.ip_log[3][0] = "OK";



//update ip list



	JSONParser parser = new JSONParser();

try{//*********************************************************
 

		jsonText = "";

		if(!clientSentence.contains(lm.program_id)){throw new EmptyStackException();}
		Object obj = parser.parse(clientSentence);
 
		jsonObject = (JSONObject) obj;
  
		String request = (String) jsonObject.get(lm.program_id);
		String password2 = (String) jsonObject.get("password");
		passwordx = password2;
		System.out.println(request);

		//log request type
		lm.ip_log[2][0] = request;





//check for blocked ip

		int BLOCKED = 0;
		for(int xloop = 0; xloop < lm.carbon_blockip.length; xloop++){//************

		if(lm.carbon_blockip[xloop].equals(client_ip)){BLOCKED = 1;}

		}//*************************************************************************

		if(BLOCKED == 1){request = "blocked"; lm.ip_log[3][0] = "BLOCKED";}

//check for blocked ip





		if(request.equals("connect")){
		System.out.println("request type");



				responsex = "1"; 
				lm.server_requests++;

				System.out.println("build_connect");

				try{

				Map<String, String> info22 = new HashMap<String, String>();

				info22.put("response", responsex);

				if(passwordx.equals(lm.carbon_settings[8])){info22.put("inventory", Integer.toString(lm.items_for_sale_total));}
				else{info22.put("inventory", Integer.toString(lm.items_for_sale));}

				info22.put("idx", lm.carbon_settings[7]);


				JSONObject sub_obj = new JSONObject();
				sub_obj = new JSONObject(info22);

				StringWriter outs = new StringWriter();
				sub_obj.writeJSONString(outs);
				jsonText = outs.toString();
				System.out.println("SEND RESPONSE " + responsex);

				System.out.println("SERVER GOT: " + clientSentence);             
				capitalizedSentence = clientSentence.toUpperCase() + '\n';  

				}catch(Exception e){System.out.println("Build Connect failed********************************************");}



		}//***************************
		else if(request.equals("bid")){
		System.out.println("request bid");



				responsex = "1"; 
				lm.server_requests++;

				System.out.println("bid_amount");

				try{

				Map<String, String> info22 = new HashMap<String, String>();

				info22.put("response", responsex);

				if(passwordx.equals(lm.carbon_settings[8]) ){

					info22.put("inventory", Integer.toString(lm.items_for_sale_total));
					info22.put("idx", lm.carbon_settings[7]);




					JSONObject sub_obj = new JSONObject();
					sub_obj = new JSONObject(info22);

					StringWriter outs = new StringWriter();
					sub_obj.writeJSONString(out);
					jsonText = outs.toString();
					System.out.println("SEND RESPONSE " + responsex);

					System.out.println("SERVER GOT: " + clientSentence);
					capitalizedSentence = clientSentence.toUpperCase() + '\n';


				}//******************************************



				}catch(Exception e){System.out.println("Build Connect failed********************************************");}



		}//***************************
		else if(request.equals("search")){
		System.out.println("request search");



				responsex = "1"; 
			
				System.out.println("build_inventory");

				try{

				LinkedList<String> list = new LinkedList<String>();


					String search_text = (String) jsonObject.get("search_text");
					String search_field = (String) jsonObject.get("search_field");

					System.out.println("search_text " + search_text);
					System.out.println("search_field " + search_field);


				if(passwordx.equals(lm.carbon_settings[8])){
				for(int xloop = 1; xloop < lm.carbon_sell[0].length; xloop++){//****************************************************
  					if(lm.carbon_sell[ Integer.parseInt(search_field) ][xloop].toLowerCase().contains(search_text.toLowerCase()) && lm.carbon_sell[lm.seller_id_xx][xloop].length() > 26){

						if(Integer.parseInt(lm.carbon_sell[lm.item_total_on_hand_xx][xloop]) > 0){

							list.add(lm.carbon_sell[lm.item_id_xx][xloop]); 
		
							try{
							lm.carbon_sell[lm.item_hits_xx][xloop] = Long.toString(Long.parseLong(lm.carbon_sell[lm.item_hits_xx][xloop]) + 1);
							}catch(Exception e){lm.carbon_sell[lm.item_hits_xx][xloop] = "1";}

						}//***********************************************************************

					}//*******************************************************************************************************************************************************************
				}//*****************************************************************************************************************
				}//if***************************************

				else{
				for(int xloop = 1; xloop < lm.carbon_sell[0].length; xloop++){//****************************************************
  					if(lm.carbon_sell[ Integer.parseInt(search_field) ][xloop].toLowerCase().contains(search_text.toLowerCase()) && lm.carbon_sell[lm.seller_id_xx][xloop].length() > 26){
						if(!lm.carbon_sell[lm.item_listing_id_xx][xloop].equals("HIDDEN")){
				
			   			if(Integer.parseInt(lm.carbon_sell[lm.item_total_on_hand_xx][xloop]) > 0){//******

							list.add(lm.carbon_sell[lm.item_id_xx][xloop]);

							try{
							lm.carbon_sell[lm.item_hits_xx][xloop] = Long.toString(Long.parseLong(lm.carbon_sell[lm.item_hits_xx][xloop]) + 1);
							}catch(Exception e){lm.carbon_sell[lm.item_hits_xx][xloop] = "1";}
			   
			   			}//*******************************************************************************

						}//****************************************************************

					}//*******************************************************************************************************************************************************************
				}//*****************************************************************************************************************
				}//**


  				jsonText = JSONValue.toJSONString(list);
  				System.out.print(jsonText);

				//StringWriter outs = new StringWriter();
				//obj.writeJSONString(out);
				//jsonText = outs.toString();
				System.out.println("SEND RESPONSE " + responsex);

				System.out.println("SERVER GOT: " + clientSentence);             
				capitalizedSentence = clientSentence.toUpperCase() + '\n';  

				}catch(Exception e){System.out.println("Build inventory failed********************************************");}



		}//*******************************
		else if(request.equals("get_item_info")){
		System.out.println("request item info");



			responsex = "1"; 
	
			System.out.println("item info");

			try{

			Map<String, String> mapx = new HashMap<String, String>();

			mapx.put("response", responsex);

			String item_idx = (String) jsonObject.get("item_idx");
			System.out.println("item_idx " + item_idx);

			for(int xloop = 1; xloop < lm.carbon_sell[0].length; xloop++){//****************************************************

			if(lm.carbon_sell[lm.item_id_xx][xloop].equals(item_idx)){
 
			mapx.put("[[currency]]",               lm.carbon_sell[lm.currency_xx][xloop]);
			mapx.put("[[custom_template]]",        lm.carbon_sell[lm.custom_template_xx][xloop]);
			mapx.put("[[custom_1]]",               lm.carbon_sell[lm.custom_1_xx][xloop]);
			mapx.put("[[custom_2]]",               lm.carbon_sell[lm.custom_2_xx][xloop]);
			mapx.put("[[custom_3]]",               lm.carbon_sell[lm.custom_3_xx][xloop]);
			mapx.put("[[item_errors]]",            lm.carbon_sell[lm.item_errors_xx][xloop]);
			mapx.put("[[item_date_listed]]",       lm.carbon_sell[lm.item_date_listed_xx][xloop]);
			mapx.put("[[item_date_listed_day]]",   lm.carbon_sell[lm.item_date_listed_day_xx][xloop]);
			mapx.put("[[item_date_listed_int]]",   lm.carbon_sell[lm.item_date_listed_int_xx][xloop]);
			mapx.put("[[item_hits]]",              lm.carbon_sell[lm.item_hits_xx][xloop]);
			mapx.put("[[item_confirm_code]]",      lm.carbon_sell[lm.item_confirm_code_xx][xloop]);
			mapx.put("[[item_confirmed]]",         lm.carbon_sell[lm.item_confirmed_xx][xloop]);
			mapx.put("[[item_cost]]",              lm.carbon_sell[lm.item_cost_xx][xloop]);
			mapx.put("[[item_description]]",       lm.carbon_sell[lm.item_description_xx][xloop]);
			mapx.put("[[item_id]]",                lm.carbon_sell[lm.item_id_xx][xloop]);
			mapx.put("[[item_price]]",             lm.carbon_sell[lm.item_price_xx][xloop]);
			mapx.put("[[item_weight]]",            lm.carbon_sell[lm.item_weight_xx][xloop]);
			mapx.put("[[item_listing_id]]",        lm.carbon_sell[lm.item_listing_id_xx][xloop]);
			mapx.put("[[item_notes]]",             lm.carbon_sell[lm.item_notes_xx][xloop]);
			mapx.put("[[item_package_d]]",         lm.carbon_sell[lm.item_package_d_xx][xloop]);
			mapx.put("[[item_package_l]]",         lm.carbon_sell[lm.item_package_l_xx][xloop]);
			mapx.put("[[item_package_w]]",         lm.carbon_sell[lm.item_package_w_xx][xloop]);
			mapx.put("[[item_part_number]]",       lm.carbon_sell[lm.item_part_number_xx][xloop]);
			mapx.put("[[item_title]]",             lm.carbon_sell[lm.item_title_xx][xloop]);
			mapx.put("[[item_title_url]]",         lm.carbon_sell[lm.item_title_url_xx][xloop]);
			mapx.put("[[item_type]]",              lm.carbon_sell[lm.item_type_xx][xloop]);
			mapx.put("[[item_search_1]]",          lm.carbon_sell[lm.item_search_1_xx][xloop]);
			mapx.put("[[item_search_2]]",          lm.carbon_sell[lm.item_search_2_xx][xloop]);
			mapx.put("[[item_search_3]]",          lm.carbon_sell[lm.item_search_3_xx][xloop]);
			mapx.put("[[item_site_id]]",           lm.carbon_settings[7]);
			mapx.put("[[item_site_url]]",          lm.carbon_sell[lm.item_site_url_xx][xloop]);
			mapx.put("[[item_picture_1]]",         lm.carbon_sell[lm.item_picture_1_xx][xloop]);
			mapx.put("[[item_total_on_hand]]",     lm.carbon_sell[lm.item_total_on_hand_xx][xloop]);
			mapx.put("[[seller_address_1]]",       lm.carbon_sell[lm.seller_address_1_xx][xloop]);
			mapx.put("[[seller_address_2]]",       lm.carbon_sell[lm.seller_address_2_xx][xloop]);
			mapx.put("[[seller_address_city]]",    lm.carbon_sell[lm.seller_address_city_xx][xloop]);
			mapx.put("[[seller_address_state]]",   lm.carbon_sell[lm.seller_address_state_xx][xloop]);
			mapx.put("[[seller_address_zip]]",     lm.carbon_sell[lm.seller_address_zip_xx][xloop]);
			mapx.put("[[seller_address_country]]", lm.carbon_sell[lm.seller_address_country_xx][xloop]);
			mapx.put("[[seller_id]]",              lm.carbon_sell[lm.seller_id_xx][xloop]);
			mapx.put("[[seller_ip]]",              lm.carbon_sell[lm.seller_ip_xx][xloop]);
			mapx.put("[[seller_email]]",           lm.carbon_sell[lm.seller_email_xx][xloop]);
			mapx.put("[[seller_first_name]]",      lm.carbon_settings[7]);
			mapx.put("[[seller_last_name]]",       lm.carbon_settings[7]);
			mapx.put("[[seller_notes]]",           lm.carbon_sell[lm.seller_notes_xx][xloop]);
			mapx.put("[[seller_phone]]",           lm.carbon_sell[lm.seller_phone_xx][xloop]);
			mapx.put("[[seller_logo]]",            lm.carbon_sell[lm.seller_logo_xx][xloop]);
			mapx.put("[[seller_url]]",             lm.carbon_sell[lm.seller_url_xx][xloop]);

			}//*******************************************************

			}//*****************************************************************************************************************

			JSONObject sub_obj = new JSONObject();
			sub_obj = new JSONObject(mapx);

			StringWriter outs = new StringWriter();
			sub_obj.writeJSONString(out);
			jsonText = outs.toString();
			System.out.println("SEND RESPONSE " + responsex);

			System.out.println("SERVER GOT: " + clientSentence);             
			capitalizedSentence = clientSentence.toUpperCase() + '\n';  

			}catch(Exception e){System.out.println("Build inventory failed********************************************");}



		}//*****************************
		else if(request.equals("reserve")){
		System.out.println("request item to buy");





//************************************************************************************************************************************************
//************************************************************************************************************************************************
//************************************************************************************************************************************************

			System.out.println("sell_items");

			try{

			String password = (String) jsonObject.get("password");
			System.out.println("<< " + password);

			String item_id = (String) jsonObject.get("item_id");
			System.out.println("<< " + item_id);

			String buyer_id = (String) jsonObject.get("buyer_id");
			System.out.println("<< " + buyer_id);

			String quantity = (String) jsonObject.get("quantity");  
			System.out.println("<< " + quantity);

			String pay_to_address = (String) jsonObject.get("seller_id");  
			System.out.println("<< " + pay_to_address);


			String buyer_name = (String) jsonObject.get("buyer_name");
			String buyer_address1 = (String) jsonObject.get("buyer_address1");
			String buyer_city = (String) jsonObject.get("buyer_city");
			String buyer_state = (String) jsonObject.get("buyer_state");
			String buyer_zip = (String) jsonObject.get("buyer_zip");
			String buyer_country = (String) jsonObject.get("buyer_country");
			String buyer_email = (String) jsonObject.get("buyer_email");

			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(100);


			int loopxp = 0;
			int foundx = 0;

			String sale_id_x = new String("");





	if(buyer_id.length() > 26 && pay_to_address.length() > 26){

			for(int xloop = 1; xloop < lm.carbon_sell[0].length; xloop++){//****************************************************			

			if(item_id.equals(lm.carbon_sell[lm.item_id_xx][xloop])){loopxp = xloop; foundx = 1; break;}

			}//*****************************************************************************************************************

						if(foundx == 1){//

									if(lm.carbon_sell[lm.item_listing_id_xx][loopxp].equals("ACTIVE") || password.equals(lm.carbon_settings[8])){
						
												if(Integer.parseInt(lm.carbon_sell[lm.item_total_on_hand_xx][loopxp]) >= Integer.parseInt(quantity)){//*****




															//make sure item is still the same

															int equalx = 0;

															String currency = (String) jsonObject.get("[[currency]]");  
															String item_part_number = (String) jsonObject.get("[[item_part_number]]");  
															String item_price = (String) jsonObject.get("[[item_price]]");  
															String item_title = (String) jsonObject.get("[[item_title]]");  
															String item_total_on_hand = (String) jsonObject.get("[[item_total_on_hand]]");  

															if(lm.carbon_sell[lm.currency_xx][loopxp].equals(currency)){
															if(lm.carbon_sell[lm.item_part_number_xx][loopxp].equals(item_part_number)){
															if(lm.carbon_sell[lm.item_price_xx][loopxp].equals(item_price)){
															if(lm.carbon_sell[lm.item_title_xx][loopxp].equals(item_title)){
															if(lm.carbon_sell[lm.item_total_on_hand_xx][loopxp].equals(item_total_on_hand)){

															equalx = 1;
			
															}//*****************************************************************************
															}//*************************************************************
															}//*************************************************************
															}//*************************************************************************
															}//*********************************************************

															//make sure item is still the same
															if(equalx == 1){



																		  try{

												 						  System.out.println("1");
												 						  responsex = "1";

												 						  System.out.println("carbon_sold.length " + lm.carbon_sold[0].length);

												 						  String[][] arraybuffer = new String[lm.db_sections][(lm.carbon_sold[0].length + 1)];
												

												  						  String trans_infox = lm.carbon_sell[lm.item_price_xx][loopxp];
												  						  trans_infox = trans_infox.replace(".", "");

												  						  trans_infox = Long.toString( (Long.parseLong(trans_infox) * Integer.parseInt(quantity)) );


												 						  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
												 						  Date date = new Date();
												 						  System.out.println(dateFormat.format(date));


																		  Random rand = new Random();
																		  int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
																		  sale_id_x = Long.toString(System.currentTimeMillis()) + Integer.toString(randomNum);


												  						  System.out.println("2");


												  									for(int xloop1 = 0; xloop1 < lm.carbon_sold[0].length; xloop1++){//***********			
												  									for(int xloop2 = 0; xloop2 < lm.carbon_sold.length; xloop2++){//*********

																								arraybuffer[xloop2][xloop1] = lm.carbon_sold[xloop2][xloop1];

												  									}//**********************************************************************
												  									}//***************************************************************************


												  						  System.out.println("3");


																		  //date


																		  int add1 = (arraybuffer[0].length -1);

																		  arraybuffer[0][add1] = new String(buyer_address1);//buyer_address_1
																		  arraybuffer[1][add1] = new String("");//buyer_address_2
																		  arraybuffer[2][add1] = new String(buyer_city);//buyer_address_city
																		  arraybuffer[3][add1] = new String(buyer_state);//buyer_address_state
																		  arraybuffer[4][add1] = new String(buyer_zip);//buyer_address_zip
																		  arraybuffer[5][add1] = new String(buyer_country);//buyer_address_country
																		  arraybuffer[6][add1] = new String(buyer_id);//buyer_id
																		  arraybuffer[7][add1] = new String(client_ip);//buyer_ip
																		  arraybuffer[8][add1] = new String(buyer_email);//buyers_email
																		  arraybuffer[9][add1] = new String(buyer_name);//buyers_first_name
																		  arraybuffer[10][add1] = new String("");//buyers_last_name
																		  arraybuffer[11][add1] = new String(buyer_id);//buyers_payment_address
																		  arraybuffer[12][add1] = new String("");//buyers_phone
																		  arraybuffer[13][add1] = new String(lm.carbon_settings[9]);
																		  arraybuffer[14][add1] = new String(lm.carbon_sell[lm.custom_template_xx][loopxp]);//custom_template
																		  arraybuffer[15][add1] = new String(lm.carbon_sell[lm.custom_1_xx][loopxp]);//custom_1
																		  arraybuffer[16][add1] = new String(lm.carbon_sell[lm.custom_2_xx][loopxp]);//custom_2
																		  arraybuffer[17][add1] = new String(lm.carbon_sell[lm.custom_3_xx][loopxp]);//custom_3
																		  arraybuffer[18][add1] = new String(lm.carbon_sell[lm.item_errors_xx][loopxp]);//item_errors
																		  arraybuffer[19][add1] = new String(lm.carbon_sell[lm.item_date_listed_xx][loopxp]);//item_date_listed
																		  arraybuffer[20][add1] = new String(lm.carbon_sell[lm.item_date_listed_day_xx][loopxp]);//item_date_listed_day
																		  arraybuffer[21][add1] = new String(lm.carbon_sell[lm.item_date_listed_int_xx][loopxp]);//item_date_listed_int
																		  arraybuffer[22][add1] = new String(lm.carbon_sell[lm.item_hits_xx][loopxp]);//item_hits
																		  arraybuffer[23][add1] = new String("0");//item_confirm_code
																		  arraybuffer[24][add1] = new String("0");//item_confirmed
																		  arraybuffer[25][add1] = new String(lm.carbon_sell[lm.item_cost_xx][loopxp]);//item_cost
																		  arraybuffer[26][add1] = new String(Integer.toString(lm.carbon_sell[lm.item_description_xx][loopxp].length()));//item_description
																		  arraybuffer[27][add1] = new String(lm.carbon_sell[lm.item_id_xx][loopxp]);//item_id
																		  arraybuffer[28][add1] = new String(lm.carbon_sell[lm.item_price_xx][loopxp]);//item_price
																		  arraybuffer[29][add1] = new String(lm.carbon_sell[lm.item_weight_xx][loopxp]);//item_weight
																		  arraybuffer[30][add1] = new String(lm.carbon_sell[lm.item_listing_id_xx][loopxp]);//item_listing_id
																		  arraybuffer[31][add1] = new String(lm.carbon_sell[lm.item_notes_xx][loopxp]);//item_notes
																		  arraybuffer[32][add1] = new String(lm.carbon_sell[lm.item_package_d_xx][loopxp]);//item_package_d
																		  arraybuffer[33][add1] = new String(lm.carbon_sell[lm.item_package_l_xx][loopxp]);//item_package_l
																		  arraybuffer[34][add1] = new String(lm.carbon_sell[lm.item_package_w_xx][loopxp]);//item_package_w
																		  arraybuffer[35][add1] = new String(lm.carbon_sell[lm.item_part_number_xx][loopxp]);//item_part_number
																		  arraybuffer[36][add1] = new String(lm.carbon_sell[lm.item_title_xx][loopxp]);//item_title
																		  arraybuffer[37][add1] = new String(lm.carbon_sell[lm.item_title_url_xx][loopxp]);//item_title_url
																		  arraybuffer[38][add1] = new String(lm.carbon_sell[lm.item_type_xx][loopxp]);//item_type
																		  arraybuffer[39][add1] = new String(lm.carbon_sell[lm.item_search_1_xx][loopxp]);//item_search_1
																		  arraybuffer[40][add1] = new String(lm.carbon_sell[lm.item_search_2_xx][loopxp]);//item_search_2
																		  arraybuffer[41][add1] = new String(lm.carbon_sell[lm.item_search_3_xx][loopxp]);//item_search_3
																		  arraybuffer[42][add1] = new String(lm.carbon_sell[lm.item_site_id_xx][loopxp]);//item_site_id
																		  arraybuffer[43][add1] = new String(lm.carbon_sell[lm.item_site_url_xx][loopxp]);//item_site_url
																		  arraybuffer[44][add1] = new String(lm.carbon_sell[lm.item_picture_1_xx][loopxp]);//item_picture_1
																		  arraybuffer[45][add1] = new String(lm.carbon_sell[lm.item_total_on_hand_xx][loopxp]);//item_total_on_hand
																		  arraybuffer[46][add1] = new String("");//sale_date_payment_received
																		  arraybuffer[47][add1] = new String("");//sale_date_shipped
																		  arraybuffer[48][add1] = new String(dateFormat.format(date));//sale_date_sold
																		  arraybuffer[49][add1] = new String("");//sale_final_value_fee
																		  arraybuffer[50][add1] = new String("0.00");//sale_handling
																		  arraybuffer[51][add1] = new String("");//sale_payment_address
																		  arraybuffer[52][add1] = new String("");//sale_payment_type
																		  arraybuffer[53][add1] = new String("0.00");//sale_fees
																		  arraybuffer[54][add1] = new String(quantity);//sale_quantity_sold
																		  arraybuffer[55][add1] = new String(sale_id_x);//sale_id
																		  arraybuffer[56][add1] = new String("");//sale_seller_id
																		  arraybuffer[57][add1] = new String("Reserved");//sale_status
																		  arraybuffer[58][add1] = new String("0.00");//sale_tax
																		  arraybuffer[59][add1] = new String("");//sale_shipping_company
																		  arraybuffer[60][add1] = new String("0.00");//sale_shipping_in
																		  arraybuffer[61][add1] = new String("0.00");//sale_shipping_out
																		  arraybuffer[62][add1] = new String("");//sale_source_of_sale
																		  arraybuffer[63][add1] = new String(trans_infox);//sale_total_sale_amount
																		  arraybuffer[64][add1] = new String("");//sale_tracking_number
																		  arraybuffer[65][add1] = new String("");//sale_transaction_id
																		  arraybuffer[66][add1] = new String(Integer.toString(randomInt));//sale_transaction_info
																		  arraybuffer[67][add1] = new String(lm.carbon_settings[15]);//seller_address_1
																		  arraybuffer[68][add1] = new String("");//seller_address_2
																		  arraybuffer[69][add1] = new String(lm.carbon_settings[16]);//seller_address_city
																		  arraybuffer[70][add1] = new String(lm.carbon_settings[17]);//seller_address_state
																		  arraybuffer[71][add1] = new String(lm.carbon_settings[18]);//seller_address_zip
																		  arraybuffer[72][add1] = new String(lm.carbon_settings[19]);//seller_address_country
																		  arraybuffer[73][add1] = new String(lm.carbon_sell[lm.seller_id_xx][loopxp]);//seller_id
																		  arraybuffer[74][add1] = new String("");//seller_ip
																		  arraybuffer[75][add1] = new String("");//seller_email
																		  arraybuffer[76][add1] = new String(lm.carbon_settings[14]);//seller_first_name
																		  arraybuffer[77][add1] = new String("");//seller_last_name
																		  arraybuffer[78][add1] = new String("");//seller_notes
																		  arraybuffer[79][add1] = new String("");//seller_phone
																		  arraybuffer[80][add1] = new String("");//seller_logo
																		  arraybuffer[81][add1] = new String("");//seller_url

																		  System.out.println("4");

																		  lm.carbon_sold = arraybuffer;

																		  System.out.println("5");

																		  // - quantity
																		  lm.carbon_sell[lm.item_total_on_hand_xx][loopxp] = Integer.toString( Integer.parseInt(lm.carbon_sell[lm.item_total_on_hand_xx][loopxp]) - Integer.parseInt(quantity) );

																		  //get a new BTC address
																		  lm.carbon_sell[lm.seller_id_xx][loopxp] = "null";


																		  }catch(Exception e){e.printStackTrace(); responsex = "0"; System.out.println("<<< add to db failed");}


															}//if(equalx == 1)
															else{responsex = "0"; }



												}//********************************************************************************************************
												else{SYSTEM_ERROR_MESSAGE = "Error 604"; responsex = "0"; System.out.println("<<< no stock fail");}

									}//*******************************************************************************************************
									else{SYSTEM_ERROR_MESSAGE = "Error 603"; responsex = "0"; System.out.println("<<< pass fail");}

						}//*************
						else{SYSTEM_ERROR_MESSAGE = "Error 602"; responsex = "0"; System.out.println("<<< item id fail");}

	}//**********************
	else{SYSTEM_ERROR_MESSAGE = "Error 601"; responsex = "0"; System.out.println("<<< buyer id fail");}




	Map<String, String> info65 = new HashMap<String, String>();
	info65.put("response", responsex);
	info65.put("sale_transaction_info", Integer.toString(randomInt));

	JSONObject sub_obj = new JSONObject();
	sub_obj = new JSONObject(info65);

	StringWriter outs = new StringWriter();
	sub_obj.writeJSONString(out);
	jsonText = outs.toString();
	System.out.println("SEND RESPONSE " + responsex);

	System.out.println("SERVER GOT: " + clientSentence);             
	capitalizedSentence = clientSentence.toUpperCase() + '\n';  

	}catch(Exception e3){e3.printStackTrace(); System.out.println("Sell item failed********************************************");}

//************************************************************************************************************************************************
//************************************************************************************************************************************************
//************************************************************************************************************************************************





		}//*****************************
		else{responsex = "0";}


}//try
catch(ParseException e){e.printStackTrace(); responsex = "-1"; out.print("Error 500" + '\n');}
catch(Exception e){out.print("Error 501" + '\n');}


	//out.print(jsonText + '\n');

	if(lm.serverx_active == 1 && responsex.equals("0")){out.print(SYSTEM_ERROR_MESSAGE + '\n');}
	else if(lm.serverx_active == 1 && responsex.equals("1")){out.print(jsonText + '\n');}
	else{out.print("Offline 400" + '\n');}


        out.flush();
	//welcomeSocket.close();
        out.close();

        clientSocket.close();
        serverSocket.close();

}//try
catch(Exception e){System.out.println("Server ERROR");}





         




}//runx**********************************************************************************************************************

















}//last>>>>>>>>>>>
