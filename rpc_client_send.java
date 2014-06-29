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









rpc_client_send(){


payx();


}//***************











	public void payx(){

	infox2.setText("Pay for item RPC");


	String toaddress = lm.send_payment_address;
	System.out.println(toaddress);

	String xamount = lm.send_payment_address.replace(".", "");
	xamount = Long.toString( (Long.parseLong(xamount) * lm.quantityx) );
	System.out.println(xamount);



	String wallet_value_s = xamount;

	if(wallet_value_s.length() == 1){wallet_value_s = "0.0000000" + wallet_value_s;}
	else if(wallet_value_s.length() == 2){wallet_value_s = "0.000000" + wallet_value_s;}
	else if(wallet_value_s.length() == 3){wallet_value_s = "0.00000" + wallet_value_s;}
	else if(wallet_value_s.length() == 4){wallet_value_s = "0.0000" + wallet_value_s;}
	else if(wallet_value_s.length() == 5){wallet_value_s = "0.000" + wallet_value_s;}
	else if(wallet_value_s.length() == 6){wallet_value_s = "0.00" + wallet_value_s;}
	else if(wallet_value_s.length() == 7){wallet_value_s = "0.0" + wallet_value_s;}
	else if(wallet_value_s.length() == 8){wallet_value_s = "0." + wallet_value_s;}

	if(xamount.length() >= 9){wallet_value_s = wallet_value_s.substring(0, wallet_value_s.length() -8) + "." + wallet_value_s.substring(wallet_value_s.length() -8, wallet_value_s.length());}



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
