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



class rpc_client_confirm{


private static final String COMMAND_GET_BALANCE = "getreceivedbyaddress";
private static final String COMMAND_GET_INFO = "getinfo";
private static final String COMMAND_GET_NEW_ADDRESS = "getnewaddress";



String bufferx = new String("");



rpc_client_confirm(){


String account = lm.rpcaddress_confirm;
String minconf = "6";

System.out.println("account " + account);
System.out.println("minconf " + minconf);


String[] params = { account, minconf };
JSONObject json = invokeRPC(UUID.randomUUID().toString(), COMMAND_GET_BALANCE, account);



}//******************








private JSONObject invokeRPC(String id, String method, String account) {




		DefaultHttpClient httpclient = new DefaultHttpClient();

		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("method", method);
		if (null != account) {


			//JSONArray array = new JSONArray();
			//array.addAll(params);
			//json.put("params", params);

			JSONArray list = new JSONArray();
  			list.add(account);
  			list.add(new Integer(6));
			json.put("params", list);


		}



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
  
			String result = (String) jsonObject.get("result").toString();
			System.out.println("x" + result + "x");


			int xx3x = result.indexOf(".");
			int xx4x = result.length() - (xx3x + 1);

			if(xx4x == 1){result = result + "0000000";}
			else if(xx4x == 2){result = result + "000000";}
			else if(xx4x == 3){result = result + "00000";}
			else if(xx4x == 4){result = result + "0000";}
			else if(xx4x == 5){result = result + "000";}
			else if(xx4x == 6){result = result + "00";}
			else if(xx4x == 7){result = result + "0";}
			else if(xx4x == 8){result = result + "";}

			result = result.replace(".", "");

			lm.wallet_value_confirm = (Long) Long.parseLong(result);





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


}//invokeRPC














}//last
