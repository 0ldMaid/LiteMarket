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








public class blockchain_api_send extends JFrame{


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





blockchain_api_send(){//*****************************************************************

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




	get_wallet_pay_x();



}//*****************************************************************************












	public void get_wallet_pay_x(){//**********************

	System.out.println("Send Payment API...");

	int send_error = 0;


	String rpcurl = lm.carbon_settings[10];
	String rpcaddress = lm.carbon_settings[11];
	String rpcuser = lm.carbon_settings[12];
	String rpcpassword = lm.carbon_settings[13];
	String toaddress = lm.send_payment_address;

	System.out.println(rpcuser);
	System.out.println(rpcpassword);
	System.out.println(rpcaddress);
	System.out.println(toaddress);

	String xamount = lm.send_payment_amount;
	System.out.println(xamount);

	int testd = xamount.indexOf(".");
	if(testd == -1){System.out.println("ERROR"); send_error++;}

	//0.00000000
	      if((xamount.length() - testd) > 9){xamount = xamount.substring(0, (testd + 9));}
	else if((xamount.length() - testd) == 9){xamount = xamount + "";}
	else if((xamount.length() - testd) == 8){xamount = xamount + "0";}
	else if((xamount.length() - testd) == 7){xamount = xamount + "00";}
	else if((xamount.length() - testd) == 6){xamount = xamount + "000";}
	else if((xamount.length() - testd) == 5){xamount = xamount + "0000";}
	else if((xamount.length() - testd) == 4){xamount = xamount + "00000";}
	else if((xamount.length() - testd) == 3){xamount = xamount + "000000";}
	else if((xamount.length() - testd) == 2){xamount = xamount + "0000000";}
	else if((xamount.length() - testd) == 1){xamount = xamount + "00000000";}
	else if((xamount.length() - testd) == 0){System.out.println("ERROR"); send_error++;}



	xamount = xamount.replace(".","");

	Long conv1 = Long.parseLong(xamount);

	xamount = Long.toString(conv1);

	System.out.println(xamount);




        String line = new String();
	String line2 = new String();



if(send_error == 0){

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





	}//try
	catch(ParseException e){e.printStackTrace(); JOptionPane.showMessageDialog(null, e.getMessage() + " " + line); sale_status_xx = "Error";}


             

        }//try
        catch (MalformedURLException e) {System.out.println("Malformed URL: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage()); sale_status_xx = "Error";}
        catch (IOException e) {System.out.println("I/O Error: " + e.getMessage()); JOptionPane.showMessageDialog(null, e.getMessage()); sale_status_xx = "Error";}
	catch (Exception e) {JOptionPane.showMessageDialog(null, "User or Pass is Probably Wrong 32 " + line); sale_status_xx = "Error";}


}//*****************
else{System.out.println("Error Sending Payment.");}

	}//***************get_wallet_pay_x()














}//last
