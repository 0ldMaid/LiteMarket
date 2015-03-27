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

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;










public class krypton extends JFrame implements ActionListener{

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 500;
int xzy = 425;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

Timer xtimerx;//class loop.
Toolkit toolkit;

FlowLayout flow0 = new FlowLayout(0);
Font f_01 = new Font("Arial", Font.PLAIN, 12);

TrayIcon icon;




JMenuItem exit = new JMenuItem("Exit (Shutdown)");


ButtonGroup groupn = new ButtonGroup();
JRadioButtonMenuItem nodes_yes = new JRadioButtonMenuItem("Allow all nodes (yes)");
JRadioButtonMenuItem nodes_no = new JRadioButtonMenuItem("Allow all nodes (no)");

JMenuItem node_status = new JMenuItem("Node Network Status");






static String network[][] = new String[3][100];
static String providers[][] = new String[3][0];
static String settingsx[] = new String[11];


static String versionx = new String("1.0.1");
static String idx = new String("");
static String xtypex = new String("user");

static Long lastFrame;
static Long thisTick;
static Long seconds;
static Long starttime = (long) 100;

static int open_network = 0;//allow new nodes without confirmation
static int network_chain = 100;//number of nodes in network chain
static int send_requests = 0;
static int inbox_requests = 0;
static int get_requests = 0;
static int p2p_port = 9295;
static int peers = 0;
static int nodex_number = 101;
static int database_active = 0;
static int database_messages = 0;


static int hide_console = 0;
static int console_showing = 1;

JMenu fileMenu = new JMenu("File");
JMenu editMenu = new JMenu("Edit");
JMenu toolMenu = new JMenu("Tools");
JMenu databaseMenu = new JMenu("Database");
JMenu accountMenu = new JMenu("Account");
JMenu spaceMenu = new JMenu("|");
JMenu nodeMenu = new JMenu("Nodes");



JButton button1 = new JButton("Node");
JButton button2 = new JButton("Test");
JButton button3 = new JButton("Save");
JButton button4 = new JButton("Run");
JButton button5 = new JButton("Start");
JButton button6 = new JButton("Start");
JButton button7 = new JButton("Stop");


JLabel status1 = new JLabel("Database: Apache Derby - 10.5.3.0 - (802917)", JLabel.LEFT);
JLabel status2 = new JLabel("JSON API Client: Java Apache json-simple-1.1.1", JLabel.LEFT);
JLabel status3 = new JLabel("Settings File: krypton_settings.ini", JLabel.LEFT);
JLabel status4 = new JLabel("P2P Network Description: " + settingsx[2], JLabel.LEFT);
JLabel status5 = new JLabel("Database Status: (" + database_active + ")", JLabel.LEFT);
JLabel status6 = new JLabel("User IP: 127.0.0.1", JLabel.LEFT);
JLabel status7 = new JLabel("Status: Node Number " + nodex_number, JLabel.LEFT);
JLabel status8 = new JLabel("Server Port Binding: (Port: " + Integer.toString(p2p_port) + ")", JLabel.LEFT);
JLabel status9 = new JLabel("Payload Port Binding: (Port: " + Integer.toString(0) + ")", JLabel.LEFT);


Label status_x1 = new Label("Loading...", Label.LEFT);

Label status_ax1 = new Label("Requests:", Label.LEFT);
Label status_ax1_b = new Label("", Label.LEFT);
Label status_ax2 = new Label("Node Network:", Label.LEFT);
Label status_ax2_b = new Label("", Label.LEFT);
Label status_ax3 = new Label("Providers:", Label.LEFT);
Label status_ax3_b = new Label("", Label.LEFT);

JLabel info_am_l = new JLabel("Ad Message:", JLabel.LEFT);
JTextField info_am = new JTextField("", 30);

int ix0 = 0;
int ix1 = 0;



static Color st_gray1 = new Color(0.8f, 0.8f, 0.8f);//light gray for sites
static Color st_gray2 = new Color(0.99f, 0.99f, 0.99f);//darker gray for sites
Color xstripesc = new Color(0.0f, 0.0f, 0.0f);
Color xblue = new Color(0.1f, 0.1f, 0.16f);
Color bluex1 = new Color(0.0f, 0.0f, 0.3f);
Color bluex2 = new Color(0.1f, 0.17f, 0.39f);
Color bluex3 = new Color(0.6f, 0.67f, 0.9f);
Color bluex4 = new Color(0.3f, 0.5f, 0.6f);
Color darkgray04 = new Color(0.04f, 0.04f, 0.04f);//dark gray
Color darkgray08 = new Color(0.08f, 0.08f, 0.08f);//dark gray
Color darkgray01 = new Color(0.156f, 0.156f, 0.156f);//dark gray
Color darkgray70 = new Color(0.3f, 0.3f, 0.3f);
Color gray5 = new Color(0.5f, 0.5f, 0.5f);
Color gray6 = new Color(0.6f, 0.6f, 0.6f);
Color gray7 = new Color(0.7f, 0.7f, 0.7f);
Color gray8 = new Color(0.8f, 0.8f, 0.8f);
Color gray9 = new Color(0.9f, 0.9f, 0.9f);
Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color purple = new Color(1.0f, 0.0f, 0.8f);
Color redx = new Color(1.0f, 0.2f, 0.216f);
Color yellowx = new Color(1.0f, 0.9f, 0.0f);
Color yellowx2 = new Color(0.8f, 0.7f, 0.0f);
Color tab_off = gray8;                               //for the tabs
Color tab_on = whitex;//bluex2                       //for the tabs
Color lightgreenx = new Color(0.5f, 0.9f, 0.5f);
Color darkgreenx = new Color(0.1f, 0.3f, 0.1f);
Color darkgreebnx = new Color(0.1f, 0.3f, 0.1f);
Color yellow = bluex4;   //the selected item





Icon imx0;
Icon imx1;
Icon imx2;
Icon imx3;











krypton(){//**************************************************************************


	super("Krypton Server - Runtime: 0");
	setDefaultCloseOperation(HIDE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	setAlwaysOnTop(false);
        //addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});

        requestFocus();

//the program icon 
	Image imageppx = new ImageIcon(this.getClass().getResource("images/hex.png")).getImage();
	setIconImage(imageppx);

	imx0 = new ImageIcon(this.getClass().getResource("images/message-no.png"));
	imx1 = new ImageIcon(this.getClass().getResource("images/message-yes.png"));
	imx2 = new ImageIcon(this.getClass().getResource("images/settings.png"));
	imx3 = new ImageIcon(this.getClass().getResource("images/hex.png"));

	starttime = System.currentTimeMillis();


	status1.setPreferredSize(new Dimension(380, 20));
	status1.setForeground(Color.BLACK);
	status1.setIcon(imx0);
	status1.setFont(f_01);

	status2.setPreferredSize(new Dimension(380, 20));
	status2.setForeground(Color.BLACK);
	status2.setIcon(imx0);
	status2.setFont(f_01);

	status3.setPreferredSize(new Dimension(380, 20));
	status3.setForeground(Color.BLACK);
	status3.setIcon(imx0);
	status3.setFont(f_01);

	status4.setPreferredSize(new Dimension(380, 20));
	status4.setForeground(Color.BLACK);
	status4.setIcon(imx0);
	status4.setFont(f_01);

	status5.setPreferredSize(new Dimension(380, 20));
	status5.setForeground(Color.BLACK);
	status5.setIcon(imx0);
	status5.setFont(f_01);

	status6.setPreferredSize(new Dimension(380, 20));
	status6.setForeground(Color.BLACK);
	status6.setIcon(imx0);
	status6.setFont(f_01);

	status7.setPreferredSize(new Dimension(380, 20));
	status7.setForeground(Color.BLACK);
	status7.setIcon(imx0);
	status7.setFont(f_01);

	status8.setPreferredSize(new Dimension(380, 20));
	status8.setForeground(Color.BLACK);
	status8.setIcon(imx0);
	status8.setFont(f_01);

	status9.setPreferredSize(new Dimension(380, 20));
	status9.setForeground(Color.BLACK);
	status9.setIcon(imx0);
	status9.setFont(f_01);




	status_x1.setPreferredSize(new Dimension(440, 20));
	status_x1.setForeground(Color.BLACK);
	//status_x1.setIcon(imx2);



	info_am_l.setPreferredSize(new Dimension(100, 20));
	info_am_l.setForeground(Color.BLACK);
	//info_am_l.setIcon(imx2);




	status_ax1.setPreferredSize(new Dimension(110, 15));
	status_ax1.setForeground(Color.BLACK);

	status_ax1_b.setPreferredSize(new Dimension(200, 15));
	status_ax1_b.setForeground(Color.BLACK);

	status_ax2.setPreferredSize(new Dimension(110, 15));
	status_ax2.setForeground(Color.BLACK);

	status_ax2_b.setPreferredSize(new Dimension(200, 15));
	status_ax2_b.setForeground(Color.BLACK);

	status_ax3.setPreferredSize(new Dimension(110, 15));
	status_ax3.setForeground(Color.BLACK);

	status_ax3_b.setPreferredSize(new Dimension(200, 15));
	status_ax3_b.setForeground(Color.BLACK);








	button1.setPreferredSize(new Dimension(70, 30));
	button1.setOpaque(true);
	button1.setBackground(gray8);//darkgray08
	button1.setForeground(blackx);//darkgray08
	button1.setToolTipText("Button");

	button2.setPreferredSize(new Dimension(70, 30));
	button2.setOpaque(true);
	button2.setBackground(gray8);//darkgray08
	button2.setForeground(blackx);//darkgray08
	button2.setToolTipText("Button");

	button3.setPreferredSize(new Dimension(70, 30));
	button3.setOpaque(true);
	button3.setBackground(gray8);//darkgray08
	button3.setForeground(blackx);//darkgray08
	button3.setToolTipText("Button");

	button4.setPreferredSize(new Dimension(70, 30));
	button4.setOpaque(true);
	button4.setBackground(gray8);//darkgray08
	button4.setForeground(blackx);//darkgray08
	button4.setToolTipText("Button");

	button5.setPreferredSize(new Dimension(70, 30));
	button5.setOpaque(true);
	button5.setBackground(gray8);//darkgray08
	button5.setForeground(blackx);//darkgray08
	button5.setToolTipText("Button");

	button6.setPreferredSize(new Dimension(70, 30));
	button6.setOpaque(true);
	button6.setBackground(gray8);//darkgray08
	button6.setForeground(blackx);//darkgray08
	button6.setToolTipText("Button");

	button7.setPreferredSize(new Dimension(70, 30));
	button7.setOpaque(true);
	button7.setBackground(gray8);//darkgray08
	button7.setForeground(blackx);//darkgray08
	button7.setToolTipText("Button");







	info_am.setBorder(null);
	info_am.setBackground(gray8);
	info_am.setForeground(Color.BLACK);











	JPanel jpx0 = new JPanel();
	jpx0.setPreferredSize(new Dimension(385, 263));
	jpx0.setBackground(gray7);//darkgray08
	jpx0.add(status1);
	jpx0.add(status2);
	jpx0.add(status3);
	jpx0.add(status4);
	jpx0.add(status5);
	jpx0.add(status6);
	jpx0.add(status7);
	jpx0.add(status8);
	//jpx0.add(status9);


	JPanel jpx1 = new JPanel();
	jpx1.setPreferredSize(new Dimension(90, 263));
	jpx1.setBackground(gray8);//darkgray08
	jpx1.add(button1);
	jpx1.add(button2);
	jpx1.add(button3);
	jpx1.add(button4);
	jpx1.add(button5);
	jpx1.add(button6);
	jpx1.add(button7);





	JButton bpx2_b = new JButton("");
	bpx2_b.setPreferredSize(new Dimension(65, 65));
	bpx2_b.setOpaque(true);
	bpx2_b.setBackground(gray8);//darkgray08
	bpx2_b.setForeground(blackx);//darkgray08
	bpx2_b.setToolTipText("");
	bpx2_b.setIcon(imx3);
	bpx2_b.setEnabled(false);

	JPanel jpx2_b = new JPanel();
	jpx2_b.setPreferredSize(new Dimension(350, 65));
	jpx2_b.setBackground(gray7);//darkgray08
	//jpx2.add(info_am_l);      jpx2.add(info_am);
	jpx2_b.add(status_ax1);     jpx2_b.add(status_ax1_b);
	jpx2_b.add(status_ax2);     jpx2_b.add(status_ax2_b);
	jpx2_b.add(status_ax3);     jpx2_b.add(status_ax3_b);


	JPanel jpx2 = new JPanel();
	jpx2.setPreferredSize(new Dimension(480, 75));
	jpx2.setBackground(gray7);//darkgray08
	jpx2.add(bpx2_b);
	jpx2.add(jpx2_b);


	flow0.setVgap(0);
	JPanel jpx3 = new JPanel();
	jpx3.setLayout(flow0);
	jpx3.setPreferredSize(new Dimension(480, 20));
	jpx3.setBackground(gray7);//darkgray08
	jpx3.add(status_x1);







        JMenuBar menuBar = new JMenuBar();


        fileMenu.add(exit);
	exit.addActionListener(this);


	node_status.addActionListener(this);


	groupn.add(nodes_yes);
	groupn.add(nodes_no);





	nodeMenu.add(nodes_yes);
	nodeMenu.add(nodes_no);
	nodeMenu.addSeparator();
	nodeMenu.add(node_status);


        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(toolMenu);
        menuBar.add(databaseMenu);
        menuBar.add(accountMenu);
        menuBar.add(spaceMenu);
        menuBar.add(nodeMenu);

	spaceMenu.setEnabled(false);

	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(gray8);
	cp.setForeground(gray7);
	cp.add(jpx0);
	cp.add(jpx1);	
	cp.add(jpx2);
	cp.add(jpx3);




	//setVisible(true);
	hide_console = 1;
	console_showing = 0;


//test database driver
	try{

	PreparedStatement psInsert = null;

	status1.setIcon(imx1);
	}catch(Exception e){status1.setIcon(imx0);}


//test JSON
 	try{

	JSONObject jsonObject = null;

	status2.setIcon(imx1); 
	}catch(Exception e){status2.setIcon(imx0);}





//load settings
	status3.setIcon(imx0); 
        status3.setText("Settings File: settings DB");




//***************************************************
	load_payload();
//***************************************************







	//load the worm
	krypton_database_load xxs = new krypton_database_load();
	//email_db_load_email xxe = new email_db_load_email();

	if(database_active == 1){

		status5.setIcon(imx1); 
		status5.setText("Database Status: (" + database_active + ")");

		p2p_port = Integer.parseInt(settingsx[3]);

		idx = settingsx[0];
		//p2p_port = Integer.parseInt(settingsx[3]);
		System.out.println("P2P PORT " + settingsx[3]);
		//email_port = p2p_port + 1;

		status3.setIcon(imx1); 

		status4.setIcon(imx1); 
        	status4.setText("P2P Network Description: " + settingsx[2]);

		open_network = Integer.parseInt(settingsx[6]);
		if(open_network == 1){nodes_yes.setSelected(true); System.out.println("Network OPEN");}
		else{nodes_no.setSelected(true); System.out.println("Network CLOSED");}

	}//***********************
	else{

		status5.setIcon(imx0); 
		krypton_database_build db = new krypton_database_build();
		//email_db_build dbx = new email_db_build();

		krypton_database_load xx2 = new krypton_database_load();



		if(database_active == 1){

			status5.setIcon(imx1); 
			status5.setText("Database Status: (" + database_active + ")");

			p2p_port = Integer.parseInt(settingsx[3]);

			idx = settingsx[0];
			//p2p_port = Integer.parseInt(settingsx[3]);
			System.out.println("P2P PORT " + settingsx[3]);
			//email_port = p2p_port + 1;

			status3.setIcon(imx1); 

			status4.setIcon(imx1); 
        		status4.setText("P2P Network Description: " + settingsx[2]);

			open_network = Integer.parseInt(settingsx[6]);
			if(open_network == 1){nodes_yes.setSelected(true); System.out.println("Network OPEN");}
			else{nodes_no.setSelected(true); System.out.println("Network CLOSED");}

		}//***********************

	}//else


	System.out.println("network size " + krypton.network[0].length);




        try{

	Inet4Address.getLocalHost().getHostAddress();

	status6.setIcon(imx1); 
        status6.setText("User IP: " + Inet4Address.getLocalHost().getHostAddress());

        }catch(UnknownHostException e){}



	try {
	  InetAddress inet = InetAddress.getLocalHost();
	  InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
	  if (ips  != null ) {

	    for (int i = 0; i < ips.length; i++){System.out.println(ips[i]);}

	  }//*****************
	}catch (UnknownHostException e) {}






//worm chain
	status7.setIcon(imx1); 
        status7.setText("Status: Node Number " + nodex_number);




	status_x1.setText("Loaded");


	status_x1.setText("Start Engine");

	toolkit = Toolkit.getDefaultToolkit();
	xtimerx = new Timer();
	xtimerx.schedule(new RemindTask_engine(), 0);



//server start
	//don't start server unless needed
	//int response = JOptionPane.showConfirmDialog(null, "Start server so others can connect to you?");
 	//if(response == 0){

	status8.setText("Server Port Binding: (Port: " + Integer.toString(p2p_port) + ")");
	try{
	//krypton_net_server client = new krypton_net_server();
	status8.setIcon(imx1);
	}catch(Exception e){status8.setIcon(imx0); e.printStackTrace();}

	//}//****************

//client start
	try{
	krypton_net_client client = new krypton_net_client();
	}catch(Exception e){e.printStackTrace();}



	SysTray();

}//*****************************************************************************








	public void load_payload(){


	System.out.println("Load Payload...");

	//load email settings

		String[] email_settings = new String[1];

		try {
		BufferedReader in = new BufferedReader(new FileReader("email_settings.ini"));
		String str0;
		int xint3 = 0;
		while ((str0 = in.readLine()) != null) {email_settings[xint3] = new String(str0); xint3++;}
		in.close();

		info_am.setText(email_settings[0]);

		}catch (Exception e) {status_x1.setText("Load EMAIL SETTINGS Failed!");}










	}//************************














	class RemindTask_engine extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************


	while(true){

	status_x1.setText("Update Stats");

	// Calculate the time since the last frame
	thisTick = System.currentTimeMillis();
	seconds = (thisTick - starttime) / 1000;
	setTitle("Krypton Server - Runtime: " + Long.toString(seconds));

	int requests = send_requests + inbox_requests + get_requests;



        status7.setText("Status: Node Number " + nodex_number);

	status_ax1_b.setText("(" + requests + ")");
	status_ax2_b.setText("(" + database_messages + ")");
	status_ax3_b.setText("(" + database_messages + ")");

	//node number
	test_node_number();



	if(hide_console == 1 && console_showing == 0){setVisible(false); console_showing = 1;}
	else if(hide_console == 0 && console_showing == 1){setVisible(true); console_showing = 0;}
	else{}// no change


	try{Thread.sleep(1000);} catch (InterruptedException e){}

	}//*********


	}//runx***************************************************************************************************
        }//remindtask








	public void test_node_number(){

	try{


		for (int loop = 0; loop < network[0].length; loop++){

		if(network[2][loop].equals(settingsx[5])){nodex_number = loop;}

		}//**************************************************

		

		if(nodex_number == 0){status7.setText("Status: Node Number " + nodex_number + " MASTER NODE *");}
		else if(nodex_number < 101){status7.setText("Status: Node Number " + nodex_number);}
		else{status7.setText("Status: Network USER");}
		

	}catch(Exception e){status7.setText("Status: Node Number " + nodex_number);}



	}//****************************













	public void SysTray_message() {



      	icon.displayMessage("Alchemist", " new sale(s)", TrayIcon.MessageType.INFO);


	}//*****************************




	public void SysTray() {

	try{


	    Image ximage = ImageIO.read(getClass().getResourceAsStream("images/message-yes.png"));

      	 icon = new TrayIcon(ximage, "Krypton Server");
     	 icon.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
	    setVisible(true);
         }
     	 });

     	    SystemTray.getSystemTray().add(icon);


	}catch(Exception e){}


	}//last8********************************************






	public void savex(){


	krypton_database_save saved = new krypton_database_save();


	}//*****************






//***************************************************************************************************************************************
//***************************************************************************************************************************************

//handel all the button clicks. 
public void actionPerformed(ActionEvent event){

	if(event.getSource() == exit)                     {savex(); System.exit(0);}

	if(event.getSource() == node_status)              {krypton_view_network view = new krypton_view_network();}


}//********************************************





//start the program.
    public static void main(String[] args) {

	krypton black = new krypton();

    }//main




}//last
