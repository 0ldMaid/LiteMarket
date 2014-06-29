//-OLDMAID

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

import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.Arrays;
import java.util.Comparator;


import java.awt.Desktop;
import javax.swing.JOptionPane;

import java.awt.datatransfer.*;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 


import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;



import org.apache.commons.io.IOUtils;




import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;



















public class lm extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener, ChangeListener{

Timer xtimerx;//class loop.
Toolkit toolkit;

String CURRENCY = new String("BTC");


static String account_id = new String("");
static String account_password = new String("");
static String account_password2 = new String("");

JPanel jdx_px0 = new JPanel();
JPanel jdx_px1 = new JPanel();
JPanel jdx_px2 = new JPanel();

//program info
static String program_id = new String("LiteMarket");
static String program_version = new String("1.1.1.0");


//wallet value
static String wallet_value_s = new String("0.00000000");
static Long wallet_value = 0l;
static Long wallet_value_confirm = 0l;
static Long sale_price = 10000l;
static String sale_price_s = new String("0.001");
static Long wallet_value_paid = 0l;




JMenuItem file_run = new JMenuItem("New Item");
JMenuItem file_export_items = new JMenuItem("Export Items.csv");
JMenuItem file_export_orders = new JMenuItem("Export Orders.csv");
JMenuItem file_export_purchases = new JMenuItem("Export Purchases.csv");
JMenuItem file_exit = new JMenuItem("Shutdown(0) Force Exit");

JMenuItem edit_new = new JMenuItem("New Item");
JMenuItem edit_new10 = new JMenuItem("Add 10 New Items");
JMenuItem edit_edit = new JMenuItem("Edit Item");
JMenuItem edit_replace = new JMenuItem("Replace Tool");
JMenuItem edit_delete = new JMenuItem("Delete");

JMenuItem tools_editname = new JMenuItem("Edit Store Name");
JMenuItem tools_editpass = new JMenuItem("Edit Store Password");
JMenuItem tools_editcurrency = new JMenuItem("Edit Store Currency");
JMenuItem tools_editdbpass = new JMenuItem("Edit Database Password");

ButtonGroup group = new ButtonGroup();
JRadioButtonMenuItem two_factor_y = new JRadioButtonMenuItem("Two factor Auth ON");
JRadioButtonMenuItem two_factor_n = new JRadioButtonMenuItem("Two factor Auth OFF");
JMenuItem tools_send = new JMenuItem("Send To Address");
JMenuItem tools_donate = new JMenuItem("Donate BTC");

JMenuItem database_info = new JMenuItem("Database Info");

JMenuItem node_settings = new JMenuItem("Node Status Window");





ButtonGroup group_btc = new ButtonGroup();
JRadioButtonMenuItem info_account = new JRadioButtonMenuItem("Blockchaing.info Account");
JRadioButtonMenuItem btqt_account = new JRadioButtonMenuItem("Bitcoin QT Account");
JMenuItem account_settings = new JMenuItem("Account Settings");


static final int FPS_MIN1 = 0;
static final int FPS_MAX1 = 1;
static final int FPS_INIT1 = 0;    //initial frames per second

JSlider framesPerPage1 = new JSlider(JSlider.VERTICAL, FPS_MIN1, FPS_MAX1, FPS_INIT1);
//JSlider xselector1 = new JSlider(JSlider.VERTICAL, FPS_MIN1, FPS_MAX1, FPS_INIT1);





//info

FlowLayout flow_ex = new FlowLayout(0);
FlowLayout flow_edit = new FlowLayout(0);
FlowLayout flow0 = new FlowLayout(0);
FlowLayout flow1 = new FlowLayout(0);
FlowLayout flow2 = new FlowLayout(0);
FlowLayout flow3 = new FlowLayout(0);
FlowLayout flow5 = new FlowLayout(0);
FlowLayout flow6 = new FlowLayout(0);

//info





Dimension dimx = new Dimension();//for csv field. 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
Dimension jd = new Dimension(1,1);
int[] selected_int = new int[1];
int total_items_selected = 0;
int jdi0 = 0;
int jdi1 = 0;
int xzx = 1160;
int xzy = 690;
int sf_xzx = 500;
int sf_xzy = 300;
int csv_width = 0;
int db_number = 0;
int dbx_start = 0;
int dbx_end = 0;
int dbx_end_start = 0;//number to show between end and start
int dbx_total = 0;//websites total number of items. 
int item_size = 18;
int disx_num = 0;
int stripesx = 0;
int ix0 = 0;
int ix1 = 0;
int pressx = 0;//SHIFT
int pressy = 0;//CONTROL
int pressx_repaint = 0;
int pps_old = 0;//framesPerPage1.getValue() old

static int fire_edit_open = 0;
static int fire_settings_open = 0;

static int wallet_system = 0;//1 = QT, 0 = blockchain.info
static int pay_for_item = 0;//yes or no
static int quantityx = 0;
static int what_item = 0;
static int what_item_old = 0;
static int what_item2 = 0;
static int sort_int = 0;
static int found_1 = 0;
static int db_sections = 82;
static int runxx = 0;
static int items_for_sale = 0;
static int items_for_sale_total = 0;
static int getting_items = 0;
static int connection_active = 0;
static int rpc_connection_active = 0;
static int server_requests = 0;
static int api_port = 9292;
static int server_port = 9293;//9293
static int rpc_wallet_port = 8332;  //AUR 12341
static int serverx_active = 0;
static int firexdb = 0;//load db
static int firex2 = 0;//
static int db_section = 0;
static int dbx_value = 0;
static int new_address_item = 0;
static int second_passworld_select = 0;


static final int buyer_address_1_xx = 0;
static final int buyer_address_2_xx = 1;
static final int buyer_address_city_xx = 2;
static final int buyer_address_state_xx = 3;
static final int buyer_address_zip_xx = 4;
static final int buyer_address_country_xx = 5;
static final int buyer_id_xx = 6;
static final int buyer_ip_xx = 7;
static final int buyers_email_xx = 8;
static final int buyers_first_name_xx = 9;
static final int buyers_last_name_xx = 10;
static final int buyers_notes_xx = 11;
static final int buyers_phone_xx = 12;
static final int currency_xx = 13;
static final int custom_template_xx = 14;
static final int custom_1_xx = 15;
static final int custom_2_xx = 16;
static final int custom_3_xx = 17;
static final int item_errors_xx = 18;
static final int item_date_listed_xx = 19;
static final int item_date_listed_day_xx = 20;
static final int item_date_listed_int_xx = 21;
static final int item_hits_xx = 22;
static final int item_confirm_code_xx = 23;
static final int item_confirmed_xx = 24;
static final int item_cost_xx = 25;
static final int item_description_xx = 26;
static final int item_id_xx = 27;
static final int item_price_xx = 28;
static final int item_weight_xx = 29;
static final int item_listing_id_xx = 30;
static final int item_notes_xx = 31;
static final int item_package_d_xx = 32;
static final int item_package_l_xx = 33;
static final int item_package_w_xx = 34;
static final int item_part_number_xx = 35;
static final int item_title_xx = 36;
static final int item_title_url_xx = 37;
static final int item_type_xx = 38;
static final int item_search_1_xx = 39;
static final int item_search_2_xx = 40;
static final int item_search_3_xx = 41;
static final int item_site_id_xx = 42;
static final int item_site_url_xx = 43;
static final int item_picture_1_xx = 44;
static final int item_total_on_hand_xx = 45;
static final int sale_date_payment_received_xx = 46;
static final int sale_date_shipped_xx = 47;
static final int sale_date_sold_xx = 48;
static final int sale_final_value_fee_xx = 49;
static final int sale_handling_xx = 50;
static final int sale_payment_address_xx = 51;
static final int sale_payment_type_xx = 52;
static final int sale_fees_xx = 53;
static final int sale_quantity_sold_xx = 54;
static final int sale_id_xx = 55;
static final int sale_seller_id_xx = 56;
static final int sale_status_xx = 57;
static final int sale_tax_xx = 58;
static final int sale_shipping_company_xx = 59;
static final int sale_shipping_in_xx = 60;
static final int sale_shipping_out_xx = 61;
static final int sale_source_of_sale_xx = 62;
static final int sale_total_sale_amount_xx = 63;
static final int sale_tracking_number_xx = 64;
static final int sale_transaction_id_xx = 65;
static final int sale_transaction_info_xx = 66;
static final int seller_address_1_xx = 67;
static final int seller_address_2_xx = 68;
static final int seller_address_city_xx = 69;
static final int seller_address_state_xx = 70;
static final int seller_address_zip_xx = 71;
static final int seller_address_country_xx = 72;
static final int seller_id_xx = 73;
static final int seller_ip_xx = 74;
static final int seller_email_xx = 75;
static final int seller_first_name_xx = 76;
static final int seller_last_name_xx = 77;
static final int seller_notes_xx = 78;
static final int seller_phone_xx = 79;
static final int seller_logo_xx = 80;
static final int seller_url_xx = 81;



Image labelx;


JPanel jpk_top = new JPanel();
JPanel jpk_toolbar = new JPanel();
JPanel jpk_spacer1 = new JPanel();
JPanel jpk_search = new JPanel();
JPanel jpk_center_x1 = new JPanel();
JPanel jpk_center_x2 = new JPanel();
JPanel jpk_center = new JPanel();
JPanel jpk_inv = new JPanel();
JPanel jpk_qb1 = new JPanel();
JPanel jpk_qb2 = new JPanel();
JPanel jpk_sx = new JPanel();
JPanel jpk_menu = new JPanel();
JPanel jpk_info = new JPanel();


JScrollPane scrollPane_x = new JScrollPane(jpk_sx);

JPopupMenu menu = new JPopupMenu("Popup");
JMenuItem item0;
JMenuItem item1;
JMenuItem item2;
JMenuItem item3;
JMenuItem item4;
JMenuItem item5;
JMenuItem item6;

JMenuItem item_0;
JMenuItem item_1;
JMenuItem item_2;
JMenuItem item_3;
JMenuItem item_4;
JMenuItem item_5;
JMenuItem item_6;

JMenuItem itemx0;
JMenuItem itemx1;
JMenuItem itemx2;

JMenuItem items0;
JMenuItem items1;
JMenuItem items2;
JMenuItem items3;
JMenuItem items4;
JMenuItem items5;
JMenuItem items6;








JMenu fileMenu = new JMenu("File");
JMenu editMenu = new JMenu("Edit");
JMenu toolMenu = new JMenu("Tools");
JMenu databaseMenu = new JMenu("Database");
JMenu accountMenu = new JMenu("Account");
JMenu spaceMenu = new JMenu("|");
JMenu nodeMenu = new JMenu("Nodes");


static Color st_gray1 = new Color(0.8f, 0.8f, 0.8f);//light gray for sites
static Color st_gray2 = new Color(0.99f, 0.99f, 0.99f);//darker gray for sites
Color xstripesc = new Color(0.0f, 0.0f, 0.0f);
Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color greenx = new Color(0.15f, 0.6f, 0.25f);
Color redx = new Color(0.9f, 0.1f, 0.1f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color grayxb = new Color(0.6f, 0.6f, 0.6f);
static Color grayx1 = new Color(0.4f, 0.4f, 0.4f);
static Color grayx2 = new Color(0.7f, 0.7f, 0.7f);
static Color grayx3 = new Color(0.85f, 0.85f, 0.85f);
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



Font f_nx = new Font("Arial", Font.PLAIN, 10);
Font f_01 = new Font("Arial", Font.PLAIN, 10);
Font f_02 = new Font("Arial", Font.PLAIN, 25);

JButton coins = new JButton("Loading...");
JButton inventory = new JButton("Orders (x)()");
JButton purchased = new JButton("Purchased (x)");

JButton sell_button = new JButton("Sell(x)");
JButton buy_button = new JButton("Buy(x)");

JButton qrcodepic = new JButton("");

JButton sort_1 = new JButton("New");
JButton sort_2 = new JButton("View/Edit");
JButton sort_3 = new JButton("Select All");
JButton sort_4 = new JButton("Delete");
JButton sort_5 = new JButton("Refresh");
JButton sort_6 = new JButton("Ship");
JButton sort_7 = new JButton("Replace");
JButton sort_8 = new JButton("Server");

JButton buy_1 = new JButton("Buy");
JButton buy_2 = new JButton("Sell");
JButton buy_3 = new JButton("Bid");
JButton buy_4 = new JButton("Ask");
JButton buy_5 = new JButton("Send");
JButton buy_6 = new JButton("Receive");


JButton xtype = new JButton("");
JButton xactive = new JButton("");

JButton new_image = new JButton("");
JButton new_label = new JButton("");
JButton new_tracking = new JButton("");



ImageIcon imx0;
ImageIcon imx1;
ImageIcon imx2;
ImageIcon imx3;
ImageIcon imx4;
ImageIcon imx5;
ImageIcon imx6;
ImageIcon imx7;
ImageIcon imx8;
ImageIcon imx9;
ImageIcon imx_on;
ImageIcon imx_off;



JButton[][] display_csvx_field_extra = new JButton[2][1000];
JButton[][] display_csvx_field = new JButton[8][1000];
JPanel[] jpkx = new JPanel[1000];


String[] test = new String[1];
String[] database = new String[1];
String[] node_network = new String[1];
static String[] carbon_settings = new String[100];
static String[][] carbon = new String[82][1];
static String[][] carbon_sell = new String[82][1];
static String[][] carbon_buy = new String[82][1];
static String[][] carbon_sold = new String[82][0];
static String[][] carbon_purchase = new String[82][0];
static String error_codes_client = new String("");
static String httpx = new String("");
static String passx = new String("");
static String search_text = new String("");
static String search_field = new String("");
static String item_idx_buy = new String("");
static String second_password = new String("");
static String new_wallet_address = new String("");
static String rpcaddress_confirm = new String("");
static String send_payment_address = new String("");
static String send_payment_amount = new String("");


//edit
JLabel edit_info = new JLabel("Item (x)", JLabel.LEFT);
JTextField edit_title = new JTextField("", 30);
JTextField edit_part = new JTextField("", 20);
JTextField edit_cost = new JTextField("", 8);
JTextField edit_price = new JTextField("", 8);
JTextField edit_toh = new JTextField("", 10);
JTextField edit_weight = new JTextField("", 10);
JTextField edit_picture = new JTextField("", 47);
JTextField edit_id_test = new JTextField("", 1);



//search

JTextField searchx = new JTextField("", 15);
JComboBox<String> searchf = new JComboBox<String>();
JButton searchb = new JButton("Search");


//search


JLabel infoxs1 = new JLabel("Loading...", JLabel.LEFT);
JLabel infoxs2 = new JLabel("Loading...", JLabel.LEFT);
JLabel infoxs3 = new JLabel("Loading...", JLabel.LEFT);
JLabel infoxs4 = new JLabel("LiteMarket Port:9293   API Port:9292   Currency:" + CURRENCY + "   Program Version:" + program_version + "   Database Version:10.5.3.0", JLabel.LEFT);


Label infox1 = new Label("start", Label.LEFT);
JLabel infox2 = new JLabel("Database: Online", JLabel.LEFT);
JLabel infox3 = new JLabel("Server: Online", JLabel.LEFT);
JLabel infox4 = new JLabel("Uses(0)", JLabel.LEFT);
JLabel infox5 = new JLabel("Wallet: Online", JLabel.LEFT);



//connect

JLabel url_info1 = new JLabel("Node Network", JLabel.RIGHT);
JLabel url_info2 = new JLabel("Connect To Host", JLabel.RIGHT);
JLabel url_info3 = new JLabel("Password", JLabel.RIGHT);
JLabel url_info4 = new JLabel("", JLabel.LEFT);
JTextField urlc1 = new JTextField("", 20);
JTextField urlp1 = new JTextField("", 20);
JComboBox<String> urlx1 = new JComboBox<String>();
JButton url_connect = new JButton("Connect");

private static final long serialVersionUID = 1;













lm(){//**************************************************************************


	super("LiteMarket - No Wallet");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);

	load_class_files();

	try{loadx(); load_settings();}catch(Exception e){System.out.println("LOAD DB FAILED"); build_settings(); build_db bdb = new build_db();}

	
	try{
	xzx = Integer.parseInt(carbon_settings[0]);
	xzy = Integer.parseInt(carbon_settings[1]);
	}catch(Exception e){xzx = 300; xzy = 300;}


	int cenx = (scrSize.width / 2) - (xzx / 2);
	int ceny = (scrSize.height / 2) - (xzy / 2);

	setSize(xzx, xzy);
	setLocation(cenx, (ceny - 14));
	setResizable(true);
	setAlwaysOnTop(false);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){save_settings(); savex(); System.exit(0);}});




//the program icon 
	//Image imageppx = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	Image imageppx = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	setIconImage(imageppx);






	imx0 = new ImageIcon(this.getClass().getResource("images/bitcoin.png"));
	imx1 = new ImageIcon(this.getClass().getResource("images/inventory.png"));
	imx2 = new ImageIcon(this.getClass().getResource("images/message-no.png"));
	imx3 = new ImageIcon(this.getClass().getResource("images/messages.png"));
	imx4 = new ImageIcon(this.getClass().getResource("images/message-yes.png"));
	imx5 = new ImageIcon(this.getClass().getResource("images/message-yes.png"));
	imx6 = new ImageIcon(this.getClass().getResource("images/settings.png"));
	imx7 = new ImageIcon(this.getClass().getResource("images/database.png"));
	imx8 = new ImageIcon(this.getClass().getResource("images/cart.png"));
	imx9 = new ImageIcon(this.getClass().getResource("images/qrcode_icon.png"));
	imx_on = new ImageIcon(this.getClass().getResource("images/buttonimage2.png"));
	imx_off = new ImageIcon(this.getClass().getResource("images/buttonimage3.png"));

	infox1.setText("load resorces");





//menu



	//carbon_sold = new String[82][0];
	//carbon_purchase = new String[82][0];

//mouse right clicks



	item0 = new JMenuItem("View");
	item0.setFont(f_01);
	item0.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){}});
	menu.add(item0);

	item1 = new JMenuItem("New Payment Address");
	item1.setFont(f_01);
	item1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e){get_new_payment_address();}});
	menu.add(item1);



//mouse right clicks






//menu

	qrcodepic.setMargin(new Insets(0, 0, 0, 0));
  	qrcodepic.addActionListener(this);
 	qrcodepic.setPreferredSize(new Dimension(75, 75));
 	qrcodepic.setIcon(imx9); 
	qrcodepic.setHorizontalTextPosition(JButton.CENTER);
 	qrcodepic.setForeground(grayx3);
	qrcodepic.setBorder(null);
	qrcodepic.setToolTipText("LiteMarket");

//databases

	sell_button.setMargin(new Insets(0, 0, 0, 0));
  	sell_button.addActionListener(this);
 	sell_button.setPreferredSize(new Dimension(120, 25));
 	sell_button.setIcon(imx_off); 
	sell_button.setHorizontalTextPosition(JButton.CENTER);
 	sell_button.setForeground(grayx3);
	sell_button.setBorder(null);
	sell_button.setToolTipText("Create items to sell");

	buy_button.setMargin(new Insets(0, 0, 0, 0));
  	buy_button.addActionListener(this);
 	buy_button.setPreferredSize(new Dimension(120, 25));
 	buy_button.setIcon(imx_on); 
	buy_button.setHorizontalTextPosition(JButton.CENTER);
 	buy_button.setForeground(whitex);
	buy_button.setBorder(null);
	buy_button.setToolTipText("Items you can buy");

//databases

//buy box

	buy_1.setMargin(new Insets(0, 0, 0, 0));
  	buy_1.addActionListener(this);
 	buy_1.setPreferredSize(new Dimension(120, 22));
	buy_1.setHorizontalTextPosition(JButton.CENTER);
 	buy_1.setForeground(blackx);
	buy_1.setBackground(grayx2);
	buy_1.setToolTipText("Buy");

	buy_2.setMargin(new Insets(0, 0, 0, 0));
  	buy_2.addActionListener(this);
 	buy_2.setPreferredSize(new Dimension(120, 22));
	buy_2.setHorizontalTextPosition(JButton.CENTER);
 	buy_2.setForeground(blackx);
	buy_2.setBackground(grayx2);
	buy_2.setToolTipText("Sell");

	buy_3.setMargin(new Insets(0, 0, 0, 0));
  	buy_3.addActionListener(this);
 	buy_3.setPreferredSize(new Dimension(120, 22));
	buy_3.setHorizontalTextPosition(JButton.CENTER);
 	buy_3.setForeground(blackx);
	buy_3.setBackground(grayx2);
	buy_3.setToolTipText("Bid");

	buy_4.setMargin(new Insets(0, 0, 0, 0));
  	buy_4.addActionListener(this);
 	buy_4.setPreferredSize(new Dimension(120, 22));
	buy_4.setHorizontalTextPosition(JButton.CENTER);
 	buy_4.setForeground(blackx);
	buy_4.setBackground(grayx2);
	buy_4.setToolTipText("Ask");

	buy_5.setMargin(new Insets(0, 0, 0, 0));
  	buy_5.addActionListener(this);
 	buy_5.setPreferredSize(new Dimension(120, 22));
	buy_5.setHorizontalTextPosition(JButton.CENTER);
 	buy_5.setForeground(blackx);
	buy_5.setBackground(grayx2);
	buy_5.setToolTipText("Send");

	buy_6.setMargin(new Insets(0, 0, 0, 0));
  	buy_6.addActionListener(this);
 	buy_6.setPreferredSize(new Dimension(120, 22));
	buy_6.setHorizontalTextPosition(JButton.CENTER);
 	buy_6.setForeground(blackx);
	buy_6.setBackground(grayx2);
	buy_6.setToolTipText("Receive");

//buy box

//sort sections

	sort_1.setMargin(new Insets(0, 0, 0, 0));
  	sort_1.addActionListener(this);
 	sort_1.setPreferredSize(new Dimension(80, 30));
	sort_1.setHorizontalTextPosition(JButton.CENTER);
 	sort_1.setForeground(blackx);
	sort_1.setBackground(grayx3);
	sort_1.setToolTipText("New Item");

	sort_2.setMargin(new Insets(0, 0, 0, 0));
  	sort_2.addActionListener(this);
 	sort_2.setPreferredSize(new Dimension(80, 30));
	sort_2.setHorizontalTextPosition(JButton.CENTER);
 	sort_2.setForeground(blackx);
	sort_2.setBackground(grayx3);
	sort_2.setToolTipText("Edit");

	sort_3.setMargin(new Insets(0, 0, 0, 0));
  	sort_3.addActionListener(this);
 	sort_3.setPreferredSize(new Dimension(80, 30));
	sort_3.setHorizontalTextPosition(JButton.CENTER);
 	sort_3.setForeground(blackx);
	sort_3.setBackground(grayx3);
	sort_3.setToolTipText("Sort");

	sort_4.setMargin(new Insets(0, 0, 0, 0));
  	sort_4.addActionListener(this);
 	sort_4.setPreferredSize(new Dimension(80, 30));
	sort_4.setHorizontalTextPosition(JButton.CENTER);
 	sort_4.setForeground(blackx);
	sort_4.setBackground(grayx3);
	sort_4.setToolTipText("Delete");

	sort_5.setMargin(new Insets(0, 0, 0, 0));
  	sort_5.addActionListener(this);
 	sort_5.setPreferredSize(new Dimension(80, 30));
	sort_5.setHorizontalTextPosition(JButton.CENTER);
 	sort_5.setForeground(blackx);
	sort_5.setBackground(grayx3);
	sort_5.setToolTipText("Refresh");

	sort_6.setMargin(new Insets(0, 0, 0, 0));
  	sort_6.addActionListener(this);
 	sort_6.setPreferredSize(new Dimension(80, 30));
	sort_6.setHorizontalTextPosition(JButton.CENTER);
 	sort_6.setForeground(blackx);
	sort_6.setBackground(grayx3);
	sort_6.setToolTipText("Select All");

	sort_7.setMargin(new Insets(0, 0, 0, 0));
  	sort_7.addActionListener(this);
 	sort_7.setPreferredSize(new Dimension(80, 30));
	sort_7.setHorizontalTextPosition(JButton.CENTER);
 	sort_7.setForeground(blackx);
	sort_7.setBackground(grayx3);
	sort_7.setToolTipText("Replace Tool");

	sort_8.setMargin(new Insets(0, 0, 0, 0));
  	sort_8.addActionListener(this);
 	sort_8.setPreferredSize(new Dimension(80, 30));
	sort_8.setHorizontalTextPosition(JButton.CENTER);
 	sort_8.setForeground(blackx);
	sort_8.setBackground(grayx3);
	sort_8.setToolTipText("Server ON OFF");

//sort sections

//connect

	infoxs1.setPreferredSize(new Dimension(600, 20));
	infoxs1.setFont(f_01);
	infoxs1.setForeground(blackx);//darkgray08
	infoxs1.setToolTipText("Status");

	infoxs2.setPreferredSize(new Dimension(600, 20));
	infoxs2.setFont(f_01);
	infoxs2.setForeground(blackx);//darkgray08
	infoxs2.setToolTipText("Database system");

	infoxs3.setPreferredSize(new Dimension(600, 20));
	infoxs3.setFont(f_01);
	infoxs3.setForeground(blackx);//darkgray08
	infoxs3.setToolTipText("");

	infoxs4.setPreferredSize(new Dimension(600, 20));
	infoxs4.setFont(f_01);
	infoxs4.setForeground(blackx);//darkgray08
	infoxs4.setToolTipText("");






	url_connect.setMargin(new Insets(0, 0, 0, 0));
  	url_connect.addActionListener(this);
 	url_connect.setPreferredSize(new Dimension(120, 25));
 	//url_connect.setIcon(imx_off); 
	url_connect.setHorizontalTextPosition(JButton.CENTER);
 	url_connect.setForeground(blackx);
 	url_connect.setBackground(grayx3);
	//url_connect.setBorder(null);
	url_connect.setToolTipText("Connect");




	url_info1.setPreferredSize(new Dimension(150, 20));
	//url_info1.setFont(f_01);
	url_info1.setForeground(blackx);//darkgray08
	url_info1.setToolTipText("");

	url_info2.setPreferredSize(new Dimension(152, 20));
	url_info2.setFont(f_01);
	url_info2.setForeground(blackx);//darkgray08
	url_info2.setToolTipText("URL or IP");

	url_info3.setPreferredSize(new Dimension(152, 20));
	url_info3.setFont(f_01);
	url_info3.setForeground(blackx);//darkgray08
	url_info3.setToolTipText("Password");

	url_info4.setPreferredSize(new Dimension(255, 20));
	url_info4.setFont(f_01);
	url_info4.setForeground(blackx);//darkgray08
	url_info4.setToolTipText("");



	node_network[0] = new String("Offline");	

	urlx1 = new JComboBox<String>(node_network);
	urlx1.setSelectedIndex(0);
	urlx1.addActionListener(this);
	urlx1.setPreferredSize(new Dimension(225, 20));
	urlx1.setEnabled(true);	
	urlx1.setToolTipText("LiteMarket Node Network");
	urlx1.setFont(f_01);


//connect

//search

	databasex();
	start_buy_list();


	searchf = new JComboBox<String>(database);

	  try{
	  ix0 = Integer.parseInt(carbon_settings[4]);
	  searchf.setSelectedIndex(ix0);
	  }catch(Exception e){ix0 = 0;}

	searchf.addActionListener(this);
	searchf.setPreferredSize(new Dimension(120, 20));
	searchf.setEnabled(true);
	searchf.setFont(f_01);

	searchb.setMargin(new Insets(0, 0, 0, 0));
  	searchb.addActionListener(this);
	searchb.setPreferredSize(new Dimension(60, 20));
	searchb.setHorizontalTextPosition(JButton.CENTER);
	searchb.setForeground(blackx);
	searchb.setBackground(grayx3);
	searchb.setToolTipText("Search");

	show_text();

//search

//slider

	framesPerPage1.addChangeListener(this);
	framesPerPage1.setPreferredSize(new Dimension(30, 400));

	//Turn on labels at major tick marks.
	framesPerPage1.setMajorTickSpacing(1);
	framesPerPage1.setMinorTickSpacing(1);
	framesPerPage1.setPaintTicks(true);
	framesPerPage1.setPaintLabels(false);
	framesPerPage1.setPaintTrack(false); 
	framesPerPage1.setSnapToTicks(true); 
	framesPerPage1.setInverted(true);

	//framesPerPage1.setTickColor(whitex);







//slider

//payment

	coins.setPreferredSize(new Dimension(300, 27));
	coins.setIcon(imx0);
	coins.setFont(f_02);
	coins.setOpaque(true);
	coins.setBackground(whitex);//darkgray08
	coins.setForeground(blackx);//darkgray08
	coins.setHorizontalAlignment(SwingConstants.LEFT);
	coins.setToolTipText("Bitcoins in the bank");
	coins.setBorder(null); 
  	coins.setContentAreaFilled(false);
	coins.setFocusPainted(false);
	coins.setOpaque(true);
	coins.addActionListener(this);

	inventory.setPreferredSize(new Dimension(300, 27));
	inventory.setIcon(imx1);
	inventory.setFont(f_02);
	inventory.setOpaque(true);
	inventory.setBackground(whitex);//darkgray08
	inventory.setForeground(blackx);//darkgray08
	inventory.setHorizontalAlignment(SwingConstants.LEFT);
	inventory.setToolTipText("New orders to ship");
	inventory.setBorder(null); 
  	inventory.setContentAreaFilled(false);
	inventory.setFocusPainted(false);
	inventory.setOpaque(true);
	inventory.addActionListener(this);

	purchased.setPreferredSize(new Dimension(300, 27));
	purchased.setIcon(imx8);
	purchased.setFont(f_02);
	purchased.setOpaque(true);
	purchased.setBackground(whitex);//darkgray08
	purchased.setForeground(blackx);//darkgray08
	purchased.setHorizontalAlignment(SwingConstants.LEFT);
	purchased.setToolTipText("Purchase history");
	purchased.setBorder(null); 
  	purchased.setContentAreaFilled(false);
	purchased.setFocusPainted(false);
	purchased.setOpaque(true);
	purchased.addActionListener(this);

	JPanel jpk_pay = new JPanel();
	//jpk_pay.setLayout(new GridBagLayout());
	jpk_pay.setPreferredSize(new Dimension(300, 100));
	jpk_pay.setBackground(grayx3);//darkgray08
	jpk_pay.add(coins);
	jpk_pay.add(inventory);
	jpk_pay.add(purchased);




//payment

//info



	edit_info.setPreferredSize(new Dimension(563, 20));

	xtype.setMargin(new Insets(0, 0, 0, 0));
  	xtype.addActionListener(this);
 	xtype.setPreferredSize(new Dimension(90, 20));
	xtype.setHorizontalTextPosition(JButton.CENTER);
 	xtype.setForeground(blackx);
 	xtype.setBackground(grayx3);
	xtype.setBorder(BorderFactory.createLineBorder(blackx));
	xtype.setToolTipText("Listing Type");

	xactive.setMargin(new Insets(0, 0, 0, 0));
  	xactive.addActionListener(this);
 	xactive.setPreferredSize(new Dimension(90, 20));
	xactive.setHorizontalTextPosition(JButton.CENTER);
 	xactive.setForeground(blackx);
 	xactive.setBackground(grayx3);
	xactive.setBorder(BorderFactory.createLineBorder(blackx));
	xactive.setToolTipText("Active or Hidden");




	infox1.setPreferredSize(new Dimension(300, 20));
	//infox1.setIcon(imx6);
	infox1.setFont(f_01);
	infox1.setForeground(blackx);//darkgray08
	//infox1.setToolTipText("status");

	infox2.setPreferredSize(new Dimension(145, 20));
	infox2.setIcon(imx4);
	infox2.setFont(f_01);
	infox2.setForeground(blackx);//darkgray08
	infox2.setToolTipText("Database system");

	infox3.setPreferredSize(new Dimension(130, 20));
	infox3.setIcon(imx2);
	infox3.setFont(f_01);
	infox3.setForeground(blackx);//darkgray08
	infox3.setToolTipText("Server System");

	infox4.setPreferredSize(new Dimension(110, 20));
	infox4.setIcon(imx2);
	infox4.setFont(f_01);
	infox4.setForeground(blackx);//darkgray08
	infox4.setToolTipText("Server Requests");

	infox5.setPreferredSize(new Dimension(110, 20));
	infox5.setIcon(imx2);
	infox5.setFont(f_01);
	infox5.setForeground(blackx);//darkgray08
	infox5.setToolTipText("QT Wallet");

	flow5.setHgap(0);
	flow5.setVgap(2);





	edit_title.setToolTipText("Edit Title");
	edit_title.setBorder(BorderFactory.createLineBorder(bluex1));

	edit_part.setToolTipText("Edit Part Number");
	edit_part.setBorder(BorderFactory.createLineBorder(bluex1));

	edit_cost.setToolTipText("Edit Cost");
	edit_cost.setBorder(BorderFactory.createLineBorder(redx));

	edit_price.setToolTipText("Edit Price");
	edit_price.setBorder(BorderFactory.createLineBorder(blackx));

	edit_toh.setToolTipText("Edit Total On Hand");
	edit_toh.setBorder(BorderFactory.createLineBorder(redx));

	edit_weight.setToolTipText("Edit Weight");
	edit_weight.setBorder(BorderFactory.createLineBorder(bluex1));

	edit_picture.setToolTipText("Edit Picture");
	edit_picture.setBorder(BorderFactory.createLineBorder(bluex1));



	urlc1.setToolTipText("Store IP Example: xxx.xxx.xxx.xxx");
	urlc1.setBorder(BorderFactory.createLineBorder(whitex));

	urlp1.setToolTipText("Store Password");
	urlp1.setBorder(BorderFactory.createLineBorder(whitex));

	searchx.setToolTipText("Search Store");
	searchx.setBorder(BorderFactory.createLineBorder(whitex));






//info



	jpk_search.setLayout(new FlowLayout());
	jpk_search.setPreferredSize(new Dimension(300, 100));
	jpk_search.setBackground(grayx3);//darkgray08
	jpk_search.add(infoxs1);
	jpk_search.add(infoxs2);
	jpk_search.add(infoxs3);
	jpk_search.add(infoxs4);



	flow2.setHgap(8);
	flow2.setVgap(8);
	JPanel jpk_search2 = new JPanel(flow2);
	jpk_search2.setPreferredSize(new Dimension(400, 100));
	jpk_search2.setBackground(grayx2);//darkgray08
	jpk_search2.add(url_info1);
	jpk_search2.add(urlx1);
	jpk_search2.add(url_info2);
	jpk_search2.add(urlc1);
	jpk_search2.add(url_info3);
	jpk_search2.add(urlp1);
	jpk_search2.add(url_info4);
	jpk_search2.add(url_connect);


	jpk_top.setLayout(new GridBagLayout());
	jpk_top.setPreferredSize(new Dimension(1000, 100));
	jpk_top.setBackground(grayx3);//darkgray08
	jpk_top.add(jpk_pay);
	jpk_top.add(jpk_search);
	jpk_top.add(jpk_search2);




	flow1.setHgap(5);
	flow1.setVgap(0);

	JPanel jpk_tool_search = new JPanel();
	jpk_tool_search.setLayout(flow2);
	jpk_tool_search.setPreferredSize(new Dimension(380, 25));
	jpk_tool_search.setBackground(grayx2);//darkgray08
	jpk_tool_search.add(searchx);
	jpk_tool_search.add(searchf);
	jpk_tool_search.add(searchb);

	jpk_spacer1.setPreferredSize(new Dimension(300, 25));
	jpk_spacer1.setBackground(grayxb);//darkgray08

	JPanel jpk_buy_sell = new JPanel();
	jpk_buy_sell.setLayout(flow1);
	jpk_buy_sell.setPreferredSize(new Dimension(300, 25));
	jpk_buy_sell.setBackground(grayxb);//darkgray08
	jpk_buy_sell.add(sell_button);
	jpk_buy_sell.add(buy_button);

	jpk_toolbar.setLayout(flow1);
	jpk_toolbar.setPreferredSize(new Dimension(200, 25));
	jpk_toolbar.setBackground(grayxb);//darkgray08
	jpk_toolbar.add(jpk_buy_sell);
	jpk_toolbar.add(jpk_spacer1);
	jpk_toolbar.add(jpk_tool_search);



	flow6.setHgap(13);
	flow6.setVgap(10);
	jpk_qb1.setLayout(flow6);
	jpk_qb1.setPreferredSize(new Dimension(100, 500));
	jpk_qb1.setBackground(grayx3);//darkgray08
	jpk_qb1.add(sort_1);
	jpk_qb1.add(sort_2);
	jpk_qb1.add(sort_3);
	jpk_qb1.add(sort_4);
	jpk_qb1.add(sort_5);
	jpk_qb1.add(sort_6);
	jpk_qb1.add(sort_7);
	jpk_qb1.add(sort_8);


	jpk_qb2.setLayout(new GridBagLayout());
	jpk_qb2.setPreferredSize(new Dimension(100, 500));
	jpk_qb2.setBackground(grayx3);//darkgray08










	flow_ex.setHgap(0);
	flow_ex.setVgap(0);
	jpk_sx.setLayout(flow_ex);
	jpk_sx.setPreferredSize(new Dimension(1400, 1500));
	jpk_sx.setBackground(grayx2);//darkgray08

	scrollPane_x.setPreferredSize(new Dimension(100, 360));
	//scrollPane_x.setBackground(bluex2);
	scrollPane_x.setFont(new Font("Arial", Font.PLAIN, 14));








	jpk_center_x1.setLayout(flow5);
	jpk_center_x1.setPreferredSize(new Dimension(1000, 20));
	jpk_center_x1.setBackground(grayx2);//darkgray08
	jpk_center_x1.add(jpk_qb1);
	jpk_center_x1.add(scrollPane_x);
	jpk_center_x1.add(framesPerPage1);


	flow0.setHgap(0);
	flow0.setVgap(0);
	jpk_center.setLayout(flow0);
	jpk_center.setPreferredSize(new Dimension(1000, 20));
	jpk_center.setBackground(grayx3);//darkgray08
	jpk_center.add(jpk_center_x1);





	//jdx_px0.setLayout();
	jdx_px0.setPreferredSize(new Dimension(300, 85));
	jdx_px0.setBackground(grayx2);//darkgray08
	jdx_px0.add(qrcodepic);

	flow_edit.setHgap(9);
	flow_edit.setVgap(5);
	jdx_px1.setLayout(flow_edit);
	jdx_px1.setPreferredSize(new Dimension(780, 85));
	jdx_px1.setBackground(grayx2);//darkgray08
	jdx_px1.add(edit_info);
	jdx_px1.add(xtype);
	jdx_px1.add(xactive);
	jdx_px1.add(edit_title);
	jdx_px1.add(edit_part);
	jdx_px1.add(edit_cost);
	jdx_px1.add(edit_price);
	jdx_px1.add(edit_toh);
	jdx_px1.add(edit_weight);
	jdx_px1.add(edit_picture);

	//jdx_px2.setLayout(flow2);
	jdx_px2.setPreferredSize(new Dimension(300, 85));
	jdx_px2.setBackground(grayx2);//darkgray08
	jdx_px2.add(buy_1);
	jdx_px2.add(buy_2);
	jdx_px2.add(buy_3);
	jdx_px2.add(buy_4);
	jdx_px2.add(buy_5);
	jdx_px2.add(buy_6);




	jpk_menu.setLayout(new FlowLayout());
	jpk_menu.setPreferredSize(new Dimension(1000, 80));
	jpk_menu.setBackground(grayx3);//darkgray08
	jpk_menu.add(jdx_px0);
	jpk_menu.add(jdx_px1);
	jpk_menu.add(jdx_px2);


	flow2.setHgap(5);
	flow2.setVgap(1);
	jpk_info.setLayout(flow2);
	jpk_info.setPreferredSize(new Dimension(1000, 20));
	jpk_info.setBackground(grayx3);//darkgray08
	jpk_info.add(infox1);
	jpk_info.add(infox2);
	jpk_info.add(infox3);
	jpk_info.add(infox4);
	jpk_info.add(infox5);




	this.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsListener(){

		@Override
		public void ancestorMoved(HierarchyEvent e) {
		
			refreshx();
				
		}

		@Override
		public void ancestorResized(HierarchyEvent e) {
				
			refreshx();
		
		}//override************************************			
	});//**************************************************************************





        JMenuBar menuBar = new JMenuBar();
       
	spaceMenu.setEnabled(false);

	group.add(two_factor_y);
	group.add(two_factor_n);

	group_btc.add(info_account);
	group_btc.add(btqt_account);




        // Add the menubar to the frame
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(toolMenu);
        menuBar.add(databaseMenu);
        menuBar.add(accountMenu);
        menuBar.add(spaceMenu);
        menuBar.add(nodeMenu);


	fileMenu.add(file_export_items);
	fileMenu.add(file_export_orders);
	fileMenu.add(file_export_purchases);
	fileMenu.addSeparator();
	fileMenu.add(file_exit);


	editMenu.add(edit_new);
	editMenu.add(edit_new10);
	editMenu.add(edit_edit);
	editMenu.add(edit_replace);
	editMenu.addSeparator();
	editMenu.add(edit_delete);

        toolMenu.add(two_factor_y);
        toolMenu.add(two_factor_n);
	toolMenu.addSeparator();
        toolMenu.add(tools_editname);
        toolMenu.add(tools_editpass);
        toolMenu.add(tools_editdbpass);
	toolMenu.addSeparator();
        toolMenu.add(tools_send);
	toolMenu.addSeparator();
        toolMenu.add(tools_donate);


	databaseMenu.add(database_info);

	nodeMenu.add(node_settings);




	try{	
	System.out.println("WS " + carbon_settings[26]);
	wallet_system = Integer.parseInt(carbon_settings[26]);
	}catch(Exception e){wallet_system = 0;}

	if(wallet_system == 0){info_account.setSelected(true);}
	else{btqt_account.setSelected(true);}





	info_account.addActionListener(this);
	btqt_account.addActionListener(this);
	info_account.setEnabled(true);
	btqt_account.setEnabled(true);

        accountMenu.add(info_account);
        accountMenu.add(btqt_account);
        accountMenu.addSeparator();
	accountMenu.add(account_settings);

	file_export_items.addActionListener(this);
	file_export_orders.addActionListener(this);
	file_export_purchases.addActionListener(this);
	file_exit.addActionListener(this);
	
	edit_new.addActionListener(this);
	edit_new10.addActionListener(this);
	edit_edit.addActionListener(this);
	edit_replace.addActionListener(this);
	edit_delete.addActionListener(this);

        tools_editname.addActionListener(this);
        tools_editpass.addActionListener(this);
	tools_editdbpass.addActionListener(this);
        two_factor_y.addActionListener(this);
	two_factor_n.addActionListener(this);
	tools_send.addActionListener(this);
	tools_donate.addActionListener(this);

	database_info.addActionListener(this);

	account_settings.addActionListener(this);

	node_settings.addActionListener(this);







	file_export_items.setFont(f_01);
	file_export_orders.setFont(f_01);
	file_export_purchases.setFont(f_01);
	file_exit.setFont(f_01);

	edit_new.setFont(f_01);
	edit_new10.setFont(f_01);
	edit_edit.setFont(f_01);
	edit_replace.setFont(f_01);
	edit_delete.setFont(f_01);

        tools_editname.setFont(f_01);
        tools_editpass.setFont(f_01);
	tools_editdbpass.setFont(f_01);
        two_factor_y.setFont(f_01);
	two_factor_n.setFont(f_01);
	tools_send.setFont(f_01);
	tools_donate.setFont(f_01);

	database_info.setFont(f_01);

	info_account.setFont(f_01);
	btqt_account.setFont(f_01);
	account_settings.setFont(f_01);

	node_settings.setFont(f_01);





	






	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(grayx2);
	cp.setForeground(grayx2);
	cp.add(jpk_top);
	cp.add(jpk_toolbar);
	cp.add(jpk_center);
	cp.add(jpk_menu);
	cp.add(jpk_info);
	setVisible(true);

	//get_btc_wallet();

	try{
	InetAddress IP = InetAddress.getLocalHost();
	System.out.println("IP of my system is: " + IP.getHostAddress());
	infoxs3.setText("System address: " + IP.getHostAddress());
	infoxs3.setToolTipText("Many internet connections cannot receive inbound requests. You will need to set up your system so others can connect");
	}catch(Exception e){System.out.println("Get IP address error!"); infoxs3.setText("Get IP address error!");}




	//start server
	infox1.setText("start server");
	net_server netx = new net_server(); 
	litemarket_api apix = new litemarket_api(); 

	searchb.setEnabled(false);
	searchx.setEnabled(false);
	searchf.setEnabled(false);

        addKeyListener(this);
	requestFocus();

	set_1000_page();
	if(db_section == 0){sell_button_click();}
	else{buy_button_click();}


	//start the engine
	toolkit = Toolkit.getDefaultToolkit();
	xtimerx = new Timer();
	xtimerx.schedule(new RemindTask_system_engine(), 0);


	 CURRENCY = carbon_settings[9];


//test for RPC wallet

	try{
	rpc_client_test xc = new rpc_client_test();
	if(rpc_connection_active == 1){infox5.setIcon(imx4);}
	else{infox5.setIcon(imx2);}
	}catch(Exception e){infox5.setIcon(imx2);}

//get wallet info
	get_btc_wallet();

}//*****************************************************************************















//*******************************************************************************************************************************************
//*******************************************************************************************************************************************
//display

public void display_item(){

System.out.println("Display Item");


if(db_section == 0){//***********************************


	save_text();
	show_text();


	if(what_item != 0){show_errors(); edit_info.setText(carbon_sell[item_errors_xx][what_item]);}
	else{edit_info.setText("Item Error Status");}

	System.out.println("dbx_start " + dbx_start);
	System.out.println("dbx_end " + dbx_end);

		for(int xloop = dbx_start; xloop < dbx_end; xloop++){//****************************************************


		if(carbon_sell[item_listing_id_xx][xloop].equals("HIDDEN")){display_csvx_field_extra[1][xloop].setForeground(redx); display_csvx_field_extra[1][xloop].setText("x");}
		else{display_csvx_field_extra[1][xloop].setText("");}

		display_csvx_field[0][xloop].setText(carbon_sell[item_title_xx][xloop]);
		display_csvx_field[0][xloop].setToolTipText(carbon_sell[item_title_xx][xloop]);

		display_csvx_field[1][xloop].setText(carbon_sell[item_part_number_xx][xloop]);
		display_csvx_field[1][xloop].setToolTipText(carbon_sell[item_part_number_xx][xloop]);

		display_csvx_field[2][xloop].setText(carbon_sell[item_total_on_hand_xx][xloop]);
		display_csvx_field[2][xloop].setToolTipText(carbon_sell[item_total_on_hand_xx][xloop]);

		display_csvx_field[3][xloop].setText(carbon_sell[item_cost_xx][xloop]);
		display_csvx_field[3][xloop].setToolTipText(carbon_sell[item_cost_xx][xloop]);

		display_csvx_field[4][xloop].setText(carbon_sell[item_price_xx][xloop]);
		display_csvx_field[4][xloop].setToolTipText(carbon_sell[item_price_xx][xloop]);

		display_csvx_field[5][xloop].setText(carbon_sell[item_weight_xx][xloop]);
		display_csvx_field[5][xloop].setToolTipText(carbon_sell[item_weight_xx][xloop]);

		display_csvx_field[6][xloop].setText(carbon_sell[item_picture_1_xx][xloop]);
		display_csvx_field[6][xloop].setToolTipText(carbon_sell[item_picture_1_xx][xloop]);

		display_csvx_field[7][xloop].setText(carbon_sell[seller_id_xx][xloop]);
		display_csvx_field[7][xloop].setToolTipText(carbon_sell[seller_id_xx][xloop]);

		display_csvx_field[8][xloop].setText(carbon_sell[item_listing_id_xx][xloop]);
		display_csvx_field[8][xloop].setToolTipText(carbon_sell[item_listing_id_xx][xloop]);

		display_csvx_field[9][xloop].setText(carbon_sell[item_type_xx][xloop]);
		display_csvx_field[9][xloop].setToolTipText(carbon_sell[item_type_xx][xloop]);

		display_csvx_field[10][xloop].setText(carbon_sell[item_id_xx][xloop]);
		display_csvx_field[10][xloop].setToolTipText(carbon_sell[item_id_xx][xloop]);

		display_csvx_field[11][xloop].setText(carbon_sell[item_hits_xx][xloop]);
		display_csvx_field[11][xloop].setToolTipText(carbon_sell[item_hits_xx][xloop]);

		display_csvx_field[12][xloop].setText(carbon_sell[custom_1_xx][xloop]);
		display_csvx_field[12][xloop].setToolTipText(carbon_sell[custom_1_xx][xloop]);

		display_csvx_field[13][xloop].setText(carbon_sell[custom_2_xx][xloop]);
		display_csvx_field[13][xloop].setToolTipText(carbon_sell[custom_2_xx][xloop]);

		display_csvx_field[14][xloop].setText(carbon_sell[custom_3_xx][xloop]);
		display_csvx_field[14][xloop].setToolTipText(carbon_sell[custom_3_xx][xloop]);

		display_csvx_field[15][xloop].setText(carbon_sell[currency_xx][xloop]);
		display_csvx_field[15][xloop].setToolTipText(carbon_sell[currency_xx][xloop]);


		}//for*****************************************************************************************************


//btc
if(what_item != 0){

	String cbtc = carbon_sell[item_price_xx][what_item];

	  if(!cbtc.contains(".")){edit_price.setText("0." + cbtc);}
	  else{

		int ibtc = cbtc.indexOf(".");

		System.out.println("cbtc " + cbtc.substring(ibtc, cbtc.length()).length());

		if(cbtc.substring(ibtc, cbtc.length()).length() < 2){edit_price.setText(cbtc + "00000000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 3){edit_price.setText(cbtc + "0000000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 4){edit_price.setText(cbtc + "000000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 5){edit_price.setText(cbtc + "00000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 6){edit_price.setText(cbtc + "0000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 7){edit_price.setText(cbtc + "000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 8){edit_price.setText(cbtc + "00");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 9){edit_price.setText(cbtc + "0");}

	  }//ee


}//****************
if(what_item != 0){

	String cbtc = carbon_sell[item_cost_xx][what_item];

	  if(!cbtc.contains(".")){edit_cost.setText("0." + cbtc);}
	  else{

		int ibtc = cbtc.indexOf(".");

		System.out.println("cbtc " + cbtc.substring(ibtc, cbtc.length()).length());

		if(cbtc.substring(ibtc, cbtc.length()).length() < 2){edit_cost.setText(cbtc + "00000000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 3){edit_cost.setText(cbtc + "0000000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 4){edit_cost.setText(cbtc + "000000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 5){edit_cost.setText(cbtc + "00000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 6){edit_cost.setText(cbtc + "0000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 7){edit_cost.setText(cbtc + "000");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 8){edit_cost.setText(cbtc + "00");}
		else if(cbtc.substring(ibtc, cbtc.length()).length() < 9){edit_cost.setText(cbtc + "0");}

	  }//ee


}//****************



//ids
	if(what_item != 0){

	xactive.setText(carbon_sell[item_listing_id_xx][what_item]);
	xtype.setText(carbon_sell[item_type_xx][what_item]);

	if(xactive.getText().equals("ACTIVE")){}
	else if(xactive.getText().equals("HIDDEN")){}
	else{carbon_sell[item_listing_id_xx][what_item] = "ACTIVE";}

	if(xtype.getText().equals("LISTING")){}
	else if(xtype.getText().equals("LISTING")){}
	else{carbon_sell[item_type_xx][what_item] = "LISTING";}

	xactive.setEnabled(true);
	xtype.setEnabled(true);

	xactive.setText(carbon_sell[item_listing_id_xx][what_item]);
	xtype.setText(carbon_sell[item_type_xx][what_item]);

	}//if not 0
	else if(what_item == 0){xactive.setText("ACTIVE"); xtype.setText("LISTING"); xactive.setEnabled(false); xtype.setEnabled(false);}




	setTitle("LiteMarket - Store: " + carbon_settings[7]);




}//******************************************************
else if(db_section == 1){//******************************



		for(int xloop = dbx_start; xloop < dbx_end; xloop++){//****************************************************


		display_csvx_field[0][xloop].setText(carbon_buy[item_title_xx][xloop]);
		display_csvx_field[0][xloop].setToolTipText(carbon_buy[item_title_xx][xloop]);

		display_csvx_field[1][xloop].setText(carbon_buy[item_part_number_xx][xloop]);
		display_csvx_field[1][xloop].setToolTipText(carbon_buy[item_part_number_xx][xloop]);

		display_csvx_field[2][xloop].setText(carbon_buy[item_total_on_hand_xx][xloop]);
		display_csvx_field[2][xloop].setToolTipText(carbon_buy[item_total_on_hand_xx][xloop]);

		display_csvx_field[3][xloop].setText(carbon_buy[item_price_xx][xloop]);
		display_csvx_field[3][xloop].setToolTipText(carbon_buy[item_price_xx][xloop]);

		display_csvx_field[4][xloop].setText(carbon_buy[currency_xx][xloop]);
		display_csvx_field[4][xloop].setToolTipText(carbon_buy[currency_xx][xloop]);

		display_csvx_field[5][xloop].setText(carbon_buy[item_id_xx][xloop]);
		display_csvx_field[5][xloop].setToolTipText(carbon_buy[item_id_xx][xloop]);

		display_csvx_field[6][xloop].setText(carbon_buy[item_listing_id_xx][xloop]);
		display_csvx_field[6][xloop].setToolTipText(carbon_buy[item_listing_id_xx][xloop]);

		display_csvx_field[7][xloop].setText(carbon_buy[seller_id_xx][xloop]);
		display_csvx_field[7][xloop].setToolTipText(carbon_buy[seller_id_xx][xloop]);


		}//for*****************************************************************************************************



	setTitle("LiteMarket - " + CURRENCY + " Wallet: " + carbon_settings[11]);

	edit_info.setText("");

	edit_id_test.setText("xx");

}//db_section == 1***************************************
else if(db_section == 2){//******************************




		for(int xloop = dbx_start; xloop < dbx_end; xloop++){//****************************************************


		display_csvx_field[0][xloop].setText(carbon_sold[sale_date_sold_xx][xloop]);
		display_csvx_field[0][xloop].setToolTipText("date");

		display_csvx_field[1][xloop].setText(carbon_sold[sale_status_xx][xloop]);
		display_csvx_field[1][xloop].setToolTipText("status");

		display_csvx_field[2][xloop].setText(carbon_sold[item_part_number_xx][xloop]);
		display_csvx_field[2][xloop].setToolTipText("part_number");

		display_csvx_field[3][xloop].setText(carbon_sold[item_cost_xx][xloop]);
		display_csvx_field[3][xloop].setToolTipText("cost");

		display_csvx_field[4][xloop].setText(carbon_sold[item_price_xx][xloop]);
		display_csvx_field[4][xloop].setToolTipText("price");

		display_csvx_field[5][xloop].setText(carbon_sold[sale_quantity_sold_xx][xloop]);
		display_csvx_field[5][xloop].setToolTipText("quantity");

		display_csvx_field[6][xloop].setText(carbon_sold[currency_xx][xloop]);
		display_csvx_field[6][xloop].setToolTipText("currency");

		display_csvx_field[7][xloop].setText(carbon_sold[sale_tracking_number_xx][xloop]);
		display_csvx_field[7][xloop].setToolTipText("tracking_number");

		display_csvx_field[8][xloop].setText(carbon_sold[sale_transaction_info_xx][xloop]);
		display_csvx_field[8][xloop].setToolTipText("transaction_info");

		display_csvx_field[9][xloop].setText(carbon_sold[seller_id_xx][xloop]);
		display_csvx_field[9][xloop].setToolTipText("payment_address");

		display_csvx_field[10][xloop].setText(carbon_sold[buyers_email_xx][xloop]);
		display_csvx_field[10][xloop].setToolTipText("email");

		display_csvx_field[11][xloop].setText(carbon_sold[buyer_address_country_xx][xloop]);
		display_csvx_field[11][xloop].setToolTipText("country");


		}//for*****************************************************************************************************



	setTitle("LiteMarket - Store: " + carbon_settings[7]);

	edit_info.setText("");

	edit_id_test.setText("xx");

}//db_section == 2***************************************
else if(db_section == 3){//******************************




		for(int xloop = dbx_start; xloop < dbx_end; xloop++){//****************************************************


		display_csvx_field[0][xloop].setText(carbon_purchase[item_title_xx][xloop]);
		display_csvx_field[0][xloop].setToolTipText("title");

		display_csvx_field[1][xloop].setText(carbon_purchase[sale_quantity_sold_xx][xloop]);
		display_csvx_field[1][xloop].setToolTipText("quantity");

		display_csvx_field[2][xloop].setText(carbon_purchase[item_price_xx][xloop]);
		display_csvx_field[2][xloop].setToolTipText("price");

		display_csvx_field[3][xloop].setText(carbon_purchase[currency_xx][xloop]);
		display_csvx_field[3][xloop].setToolTipText("currency");

		display_csvx_field[4][xloop].setText(carbon_purchase[sale_status_xx][xloop]);
		display_csvx_field[4][xloop].setToolTipText("status");

		display_csvx_field[5][xloop].setText(carbon_purchase[sale_transaction_info_xx][xloop]);
		display_csvx_field[5][xloop].setToolTipText("transaction_info");

		display_csvx_field[6][xloop].setText(carbon_purchase[sale_date_sold_xx][xloop]);
		display_csvx_field[6][xloop].setToolTipText("date_sold");

		display_csvx_field[7][xloop].setText(carbon_purchase[item_type_xx][xloop]);
		display_csvx_field[7][xloop].setToolTipText("type");

		display_csvx_field[8][xloop].setText(carbon_purchase[item_site_id_xx][xloop]);
		display_csvx_field[8][xloop].setToolTipText("store");

		display_csvx_field[9][xloop].setText(carbon_purchase[item_id_xx][xloop]);
		display_csvx_field[9][xloop].setToolTipText("item_id");


		}//for*****************************************************************************************************



	setTitle("LiteMarket - " + CURRENCY + " Wallet: " + carbon_settings[11]);

	edit_info.setText("");

	edit_id_test.setText("xx");

}//db_section == 2***************************************




//if(db_section != 1){

	if(db_section == 0 || db_section == 1){multi_selt1();}
	else if(db_section == 2 || db_section == 3){multi_selt2();}

//}///****************


	try{
	display_csvx_field_extra[0][0].setText("*0");
	display_csvx_field_extra[0][0].setText("0");
	}catch(Exception e){}

	requestFocus();


	build_items_for_sale();


	infoxs1.setText(Integer.toString(total_items_selected) + " Item(s) selected");

		make_stripes();

	what_item_old = what_item;

}//************************displayitem










	public void multi_selt1(){

	System.out.println("multi 1");

	if(pressx == 0 && pressy == 0){

	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//******
	selected_int[xloop] = 0;
	}//for*******************************************************

	System.out.println(what_item);
	total_items_selected = 1;
	selected_int[what_item] = 1;

	}//if**************************




	if(pressx == 1){

	int startp = 0;
	int endrtp = 0;

	if(what_item < what_item_old){startp = what_item; endrtp = what_item_old;}
	else if(what_item > what_item_old){startp = what_item_old; endrtp = what_item;}

	total_items_selected = 0;

	for(int xloop = startp; xloop <= endrtp; xloop++){//*************************

	total_items_selected++;
	selected_int[xloop] = 1;

	}//**************************************************************************

	if(selected_int[0] == 1){selected_int[0] = 0; total_items_selected--;}

	}//*************





	if(pressy == 1){

	  if(selected_int[what_item] == 0){
	    if(what_item > 0){selected_int[what_item] = 1;}
	    show_total_select();
	  }//******************************
	  else if(selected_int[what_item] == 1){
	    if(what_item > 0){selected_int[what_item] = 0;}
	    show_total_select();
	  }//***********************************

	}//*************

	if(selected_int[0] == 1){selected_int[0] = 0; total_items_selected--;}

	}//multi_selt************







	public void multi_selt2(){

	System.out.println("multi 2");

	if(pressx == 0 && pressy == 0){

	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//******
	selected_int[xloop] = 0;
	}//for*******************************************************

	try{
	  System.out.println(what_item);
	  total_items_selected = 1;
	  selected_int[what_item] = 1;
	}catch(Exception e){infoxs1.setText("Set Selected Item Failed!");}

	}//if**************************




	if(pressx == 1){

	int startp = 0;
	int endrtp = 0;

	if(what_item < what_item_old){startp = what_item; endrtp = what_item_old;}
	else if(what_item > what_item_old){startp = what_item_old; endrtp = what_item;}

	total_items_selected = 0;

	for(int xloop = startp; xloop <= endrtp; xloop++){//*************************

	total_items_selected++;
	selected_int[xloop] = 1;

	}//**************************************************************************


	}//*************





	if(pressy == 1){

	  if(selected_int[what_item] == 0){
	    selected_int[what_item] = 1;
	    show_total_select();
	  }//******************************
	  else if(selected_int[what_item] == 1){
	    selected_int[what_item] = 0;
	    show_total_select();
	  }//***********************************

	}//*************

	}//multi_selt************






















	public void show_total_select(){

	int pb = 0;

	total_items_selected = 0;

	if(db_section == 0){pb = carbon_sell[0].length;}
	else if(db_section == 1){pb = carbon_buy[0].length;}
	else if(db_section == 2){pb = carbon_sold[0].length;}
	else if(db_section == 3){pb = carbon_purchase[0].length;}


	for(int xloop = 0; xloop < pb; xloop++){//*******************

	if(selected_int[xloop] == 1){total_items_selected++;}

	}//**********************************************************

	      if(db_section == 0 || db_section == 1){selected_int[0] = 0;}

	}//*****************************






	public void show_errors(){

	if(carbon_sell[item_listing_id_xx][what_item].equals("HIDDEN")){carbon_sell[item_errors_xx][what_item] = "Item is hidden";}
	else if(carbon_sell[item_listing_id_xx][what_item].equals("HIDDEN")){carbon_sell[item_errors_xx][what_item] = "Item is hidden";}
	else{carbon_sell[item_errors_xx][what_item] = "No Errors";}

	}//***********************








	public void show_text(){

	try{

	edit_title.setText(carbon_sell[item_title_xx][what_item]);
	edit_part.setText(carbon_sell[item_part_number_xx][what_item]);
	edit_cost.setText(carbon_sell[item_cost_xx][what_item]);
	edit_price.setText(carbon_sell[item_price_xx][what_item]);
	edit_toh.setText(carbon_sell[item_total_on_hand_xx][what_item]);
	edit_weight.setText(carbon_sell[item_weight_xx][what_item]);
	edit_picture.setText(carbon_sell[item_picture_1_xx][what_item]);

		int sps = 0;
		try{sps = carbon_sold[0].length;}catch(Exception e){sps = 0;}

	edit_id_test.setText(carbon_sell[item_id_xx][what_item] + Integer.toString(sps));

	}catch(Exception e){System.out.println("SHOW TEXT ERROR 2342"); infox1.setText("SHOW TEXT ERROR 2342");}

	}//*********************


	public void save_text(){

	try{

	System.out.println(carbon_sell[item_id_xx][what_item_old]);
	System.out.println(edit_id_test.getText());

		int sps = 0;
		try{sps = carbon_sold[0].length;}catch(Exception e){sps = 0;}

	if(what_item_old > 0 && (carbon_sell[item_id_xx][what_item_old] + Integer.toString(sps)).equals(edit_id_test.getText())){

	carbon_sell[36][what_item_old] = edit_title.getText();
	carbon_sell[35][what_item_old] = edit_part.getText();
	carbon_sell[25][what_item_old] = edit_cost.getText();
	carbon_sell[28][what_item_old] = edit_price.getText();
	carbon_sell[45][what_item_old] = edit_toh.getText();
	carbon_sell[29][what_item_old] = edit_weight.getText();
	carbon_sell[44][what_item_old] = edit_picture.getText();

	}//if******************************************************************************************

	}catch(Exception e){System.out.println("SAVE TEXT ERROR 2343"); infox1.setText("SAVE TEXT ERROR 2343");}

	}//*********************






	
//*******************************************************************************************************************************************
//*******************************************************************************************************************************************
//displayx


	public void displayx(){
	System.out.println("dislpay x dbx_end " + dbx_end);

	disx_num = 0;
	stripesx = 0;




	if(db_section == 0){display_csvx_field = new JButton[16][ dbx_end ];}
	else if(db_section == 1){display_csvx_field = new JButton[8][ dbx_end ];}
	else if(db_section == 2){display_csvx_field = new JButton[12][ dbx_end ];}
	else if(db_section == 3){display_csvx_field = new JButton[10][ dbx_end ];}

	if(db_section == 0){dbx_value = display_csvx_field.length;}
	else if(db_section == 1){dbx_value = display_csvx_field.length;}
	else if(db_section == 2){dbx_value = display_csvx_field.length;}
	else if(db_section == 3){dbx_value = display_csvx_field.length;}

	//if(db_section == 0){dbx_end = carbon_sell[0].length;}
	//else if(db_section == 1){dbx_end = carbon_buy[0].length;}
	//else if(db_section == 2){dbx_end = carbon_sold[0].length;}
	//else if(db_section == 3){dbx_end = carbon_purchase[0].length;}

	display_csvx_field_extra = new JButton[2][dbx_end];
	jpkx = new JPanel[dbx_end];

	selected_int = new int[dbx_end];


	System.out.println("DISPLAYX SPAN " + dbx_start + " - " + dbx_end);
        System.out.println("DISPLAYX " + dbx_end_start);


	jpk_sx.removeAll();

	int csv_width_total = 0;
	int csv_width_item = 0;






	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//****************************************************


	//set visable.
	display_csvx_field_extra[0][xloop] = new JButton("" + Integer.toString(xloop)); display_csvx_field_extra[0][xloop].setBorder(null);  display_csvx_field_extra[0][xloop].setPreferredSize(new Dimension(40, (item_size)));   display_csvx_field_extra[0][xloop].setOpaque(true);   display_csvx_field_extra[0][xloop].setBackground(gray7);   display_csvx_field_extra[0][xloop].setForeground(blackx);         display_csvx_field_extra[0][xloop].addActionListener(this);  display_csvx_field_extra[0][xloop].setHorizontalAlignment(SwingConstants.CENTER);    display_csvx_field_extra[0][xloop].setFont(f_nx);
	display_csvx_field_extra[1][xloop] = new JButton("");                           display_csvx_field_extra[1][xloop].setBorder(null);  display_csvx_field_extra[1][xloop].setPreferredSize(new Dimension(20, (item_size)));   display_csvx_field_extra[1][xloop].setOpaque(false);  display_csvx_field_extra[1][xloop].setBackground(blackx);  display_csvx_field_extra[1][xloop].setForeground(lightgreenx);    display_csvx_field_extra[1][xloop].addActionListener(this);  display_csvx_field_extra[1][xloop].setHorizontalAlignment(SwingConstants.CENTER);    display_csvx_field_extra[1][xloop].setFont(f_nx);

	jpkx[xloop] = new JPanel(flow_ex);
	jpkx[xloop].setPreferredSize(new Dimension(xzx, item_size));
	jpkx[xloop].setBackground(xstripesc);
	jpkx[xloop].add(display_csvx_field_extra[0][xloop]);
	jpkx[xloop].add(display_csvx_field_extra[1][xloop]);



	for(int xloopn = 0; xloopn < dbx_value; xloopn++){//**********************************

	     if(xloopn == 0 && db_section == 0){csv_width_item = 300;}
	else if(xloopn == 1 && db_section == 0){csv_width_item = 200;}
	else if(xloopn == 2 && db_section == 0){csv_width_item = 120;}
	else if(xloopn == 3 && db_section == 0){csv_width_item = 80;}
	else if(xloopn == 4 && db_section == 0){csv_width_item = 90;}
	else if(xloopn == 5 && db_section == 0){csv_width_item = 90;}
	else if(xloopn == 6 && db_section == 0){csv_width_item = 300;}
	else if(xloopn == 7 && db_section == 0){csv_width_item = 250;}
	else if(xloopn == 8 && db_section == 0){csv_width_item = 100;}
	else if(xloopn == 9 && db_section == 0){csv_width_item = 100;}
	else if(xloopn == 10 && db_section == 0){csv_width_item = 110;}
	else if(xloopn == 11 && db_section == 0){csv_width_item = 70;}
	else if(xloopn == 12 && db_section == 0){csv_width_item = 200;}
	else if(xloopn == 13 && db_section == 0){csv_width_item = 200;}
	else if(xloopn == 14 && db_section == 0){csv_width_item = 200;}
	else if(xloopn == 15 && db_section == 0){csv_width_item = 70;}

	     if(xloopn == 0 && db_section == 1){csv_width_item = 300;}
	else if(xloopn == 1 && db_section == 1){csv_width_item = 200;}
	else if(xloopn == 2 && db_section == 1){csv_width_item = 120;}
	else if(xloopn == 3 && db_section == 1){csv_width_item = 140;}
	else if(xloopn == 4 && db_section == 1){csv_width_item = 100;}
	else if(xloopn == 5 && db_section == 1){csv_width_item = 200;}
	else if(xloopn == 6 && db_section == 1){csv_width_item = 100;}
	else if(xloopn == 7 && db_section == 1){csv_width_item = 230;}

	     if(xloopn == 0 && db_section == 2){csv_width_item = 120;}
	else if(xloopn == 1 && db_section == 2){csv_width_item = 70;}
	else if(xloopn == 2 && db_section == 2){csv_width_item = 230;}
	else if(xloopn == 3 && db_section == 2){csv_width_item = 100;}
	else if(xloopn == 4 && db_section == 2){csv_width_item = 100;}
	else if(xloopn == 5 && db_section == 2){csv_width_item = 50;}
	else if(xloopn == 6 && db_section == 2){csv_width_item = 50;}
	else if(xloopn == 7 && db_section == 2){csv_width_item = 200;}
	else if(xloopn == 8 && db_section == 2){csv_width_item = 100;}
	else if(xloopn == 9 && db_section == 2){csv_width_item = 230;}
	else if(xloopn == 10 && db_section == 2){csv_width_item = 250;}
	else if(xloopn == 11 && db_section == 2){csv_width_item = 150;}

	     if(xloopn == 0 && db_section == 3){csv_width_item = 300;}
	else if(xloopn == 1 && db_section == 3){csv_width_item = 50;}
	else if(xloopn == 2 && db_section == 3){csv_width_item = 100;}
	else if(xloopn == 3 && db_section == 3){csv_width_item = 50;}
	else if(xloopn == 4 && db_section == 3){csv_width_item = 100;}
	else if(xloopn == 5 && db_section == 3){csv_width_item = 50;}
	else if(xloopn == 6 && db_section == 3){csv_width_item = 150;}
	else if(xloopn == 7 && db_section == 3){csv_width_item = 100;}
	else if(xloopn == 8 && db_section == 3){csv_width_item = 200;}
	else if(xloopn == 9 && db_section == 3){csv_width_item = 220;}
	else if(xloopn == 10 && db_section == 3){csv_width_item = 100;}



	display_csvx_field[xloopn][xloop] = new JButton("xx");              
	display_csvx_field[xloopn][xloop].setBorder(null);  
	display_csvx_field[xloopn][xloop].setPreferredSize(new Dimension(csv_width_item,(item_size)));  
	display_csvx_field[xloopn][xloop].setOpaque(false);
  	display_csvx_field[xloopn][xloop].setContentAreaFilled(false);
	display_csvx_field[xloopn][xloop].setFocusPainted(false);
	//display_csvx_field[xloopn][xloop].setBackground(blackx);  
	display_csvx_field[xloopn][xloop].setForeground(blackx);         
	display_csvx_field[xloopn][xloop].addActionListener(this);  
	display_csvx_field[xloopn][xloop].setHorizontalAlignment(SwingConstants.LEFT);
	display_csvx_field[xloopn][xloop].setFont(f_nx);




		jpkx[xloop].add(display_csvx_field[xloopn][xloop]);




	}//xloopn****************************************************************************



	}//xloop*******************************************************************************************



	if(db_section == 0){csv_width_total = 2600;}
	else if(db_section == 1){csv_width_total = 1600;}
	else if(db_section == 2){csv_width_total = 1750;}
	else if(db_section == 3){csv_width_total = 1400;}	




	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//******
	 jpk_sx.add(jpkx[xloop]);
	}//for*******************************************************


	jpk_sx.setPreferredSize(new Dimension((csv_width_total - 50), (dbx_end_start * (item_size))));
	System.out.println("csv_width_total " + csv_width_total);


	//db lines
	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//*************************
	 jpkx[xloop].setPreferredSize(new Dimension(csv_width_total + 0, item_size));
	}//for**************************************************************************






	make_stripes();
	mouse_rr();
	repaint();
	


	}//displayx***********************************************************************************************************














	public void mouse_rr(){

	int button_loader = 0;

	     if(db_section == 0){button_loader = 16;}
	else if(db_section == 1){button_loader = 8;}
	else if(db_section == 2){button_loader = 12;}
	else if(db_section == 3){button_loader = 10;}



	for(int xloop0 = dbx_start; xloop0 < dbx_end; xloop0++){//****************************************************************************************
	for(int xloop1 = 0; xloop1 < button_loader; xloop1++){//***************************************

	final int xx_xx = xloop0;
	final int xx_xy = xloop1;



	display_csvx_field[xloop1]
	[xloop0].addMouseListener(new MouseAdapter(){
	public void mouseReleased(MouseEvent e){

	System.out.println("Mouse CLICKED " + xx_xx + " " + xx_xy);
	if(SwingUtilities.isRightMouseButton(e)){menu.show(e.getComponent(), e.getX(), e.getY());}
	//else if(SwingUtilities.isLeftMouseButton(e) && xx_xx == 0){what_item = xx_xx; what_item2 = xx_xy; found_1 = xx_xx; System.out.println("WHAT ITEM" + what_item); if(db_number == 0){sort_int = xx_xy;} sortx(); display_item(); if(db_number == 0){}}
	else if(SwingUtilities.isLeftMouseButton(e)){System.out.println("xx_xx " + xx_xx); what_item = xx_xx; what_item2 = xx_xy; display_item(); found_1 = xx_xx;}
	else{infox1.setText("NOTHING FOUND");}


	if (e.getClickCount() == 2 && !e.isConsumed()) {
	e.consume();
	System.out.println("double click");

	if(db_section == 0){edit_itemx_window();}
	else if(db_section == 1){buy_item();}
	else if(db_section == 2){view_sale vsx = new view_sale();}
	else if(db_section == 3){}
	else{System.out.println("ERROR Mouse RR");}
	}//e.getClickCount() == 2***********************



	}//************************************
	});//*******************************************************************



	}//for*****************************************************************************************
	}//for************************************************************************************************************************************



	}//********************mouse_rr











//*******************************************************************************************************************************************
//*******************************************************************************************************************************************
//displayx










	public void get_btc_wallet(){

	coins.setText("Loading...." + CURRENCY);

	infox1.setText("get wallet balance");

if(wallet_system == 0){blockchain_api_balance infox = new blockchain_api_balance();}
else if(wallet_system == 1){rpc_client_balance rpcx = new rpc_client_balance();}

	System.out.println(wallet_value);


	wallet_value_s = Long.toString(wallet_value);

	if(wallet_value_s.length() == 1){wallet_value_s = "0.0000000" + wallet_value_s;}
	else if(wallet_value_s.length() == 2){wallet_value_s = "0.000000" + wallet_value_s;}
	else if(wallet_value_s.length() == 3){wallet_value_s = "0.00000" + wallet_value_s;}
	else if(wallet_value_s.length() == 4){wallet_value_s = "0.0000" + wallet_value_s;}
	else if(wallet_value_s.length() == 5){wallet_value_s = "0.000" + wallet_value_s;}
	else if(wallet_value_s.length() == 6){wallet_value_s = "0.00" + wallet_value_s;}
	else if(wallet_value_s.length() == 7){wallet_value_s = "0.0" + wallet_value_s;}
	else if(wallet_value_s.length() == 8){wallet_value_s = "0." + wallet_value_s;}


	if(Long.toString(wallet_value).length() >= 9){wallet_value_s = wallet_value_s.substring(0, wallet_value_s.length() -8) + "." + wallet_value_s.substring(wallet_value_s.length() -8, wallet_value_s.length());}


	coins.setText(wallet_value_s + " " + CURRENCY);
	display_item();

	infox1.setText("wallet balance loaded");

	}//*************************





	public void refreshx(){




	//sizes
	Dimension jd = new Dimension(1,1);
	jd = getSize();

	int x = (int) jd.getWidth();
	int y = (int) jd.getHeight();

	carbon_settings[0] = Integer.toString(x);//l
	carbon_settings[1] = Integer.toString(y);//w

	framesPerPage1.setPreferredSize(new Dimension(30, y - 329));


	jpk_top.setPreferredSize(new Dimension(x, 100));
	jpk_search.setPreferredSize(new Dimension(x - 700, 100));
	jpk_spacer1.setPreferredSize(new Dimension(x - 760, 25));
	jpk_toolbar.setPreferredSize(new Dimension(x - 10, 25));

	jpk_center.setPreferredSize(new Dimension(x, y - 327));

	jpk_center_x1.setPreferredSize(new Dimension(x - 8, y - 329));
	jpk_qb1.setPreferredSize(new Dimension(100, y - 329));
	scrollPane_x.setPreferredSize(new Dimension((x) - 139, y - 330));

	jdx_px0.setPreferredSize(new Dimension((x) - 1130, 85));

	infoxs1.setPreferredSize(new Dimension(x - 740, 20));
	infoxs2.setPreferredSize(new Dimension(x - 740, 20));
	infoxs3.setPreferredSize(new Dimension(x - 740, 20));
	infoxs4.setPreferredSize(new Dimension(x - 740, 20));

	jpk_menu.setPreferredSize(new Dimension(x - 20, 95));
	jpk_info.setPreferredSize(new Dimension(x - 20, 30));

	infox1.setPreferredSize(new Dimension(x - 550, 20));


	//label info

	sell_button.setText("Sell(" + (carbon_sell[0].length -1) + ")");
	buy_button.setText("Buy(" + (carbon_buy[0].length -1) + ")");

	inventory.setText("Orders (" + carbon_sold[0].length + ")");
	purchased.setText("Purchased (" + carbon_purchase[0].length + ")");

	//save
	save_settings();

	}//********************









	public void load_settings(){//
	
	searchx.setText(carbon_settings[3]);//search text
	db_section = Integer.parseInt(carbon_settings[2]);

	urlc1.setText(carbon_settings[5]);
	urlp1.setText(carbon_settings[6]);

	if(carbon_settings[27].equals("1")){second_passworld_select = 1; two_factor_y.setSelected(true); System.out.println("2 factor");}
	else{second_passworld_select = 0; two_factor_n.setSelected(true); System.out.println("1 factor");}


	}//***************************




	public void build_settings(){

	//carbon_settings = new String[100];

	//carbon_settings[0] = "100";//screen x
	//carbon_settings[1] = "100";//screen y
	carbon_settings[2] = Integer.toString(db_section);//db section
	carbon_settings[3] = searchx.getText();//search text
	carbon_settings[4] = "1";//search field
	carbon_settings[5] = urlc1.getText();//url text
	carbon_settings[6] = urlp1.getText();//url pass
	carbon_settings[7] = "100";//store name
	carbon_settings[8] = Long.toString(System.currentTimeMillis());//store password
	carbon_settings[9] = CURRENCY;//store currency
	carbon_settings[10] = "100";//btcinfo 1
	carbon_settings[11] = "100";//btcinfo 2
	carbon_settings[12] = "100";//btcinfo 3
	carbon_settings[13] = "100";//btcinfo 4
	carbon_settings[14] = "100";//btcinfo 5
	carbon_settings[15] = "100";//btcinfo 6
	carbon_settings[16] = "100";//btcinfo 7
	carbon_settings[17] = "100";//btcinfo 8
	carbon_settings[18] = "100";//btcinfo 9
	carbon_settings[19] = "100";//btcinfo 10
	carbon_settings[20] = "100";//btcinfo 11
	carbon_settings[21] = "100";//btcinfo 12
	carbon_settings[22] = "100";//btcinfo 13
	carbon_settings[23] = "100";//btcinfo 14
	carbon_settings[24] = "100";//btcinfo 15
	carbon_settings[25] = Long.toString(System.currentTimeMillis());//db password
	carbon_settings[26] = "0";//wallet system
	carbon_settings[27] = "0";//second password for blockchain.info
	carbon_settings[28] = "1";//search tool db section
	carbon_settings[29] = "search";//search tool text 1
	carbon_settings[30] = "replace";//search tool text 2
	carbon_settings[31] = "100";//l
	carbon_settings[32] = "100";//l
	carbon_settings[33] = "100";//l
	carbon_settings[34] = "100";//l
	carbon_settings[35] = "100";//l
	carbon_settings[36] = "100";//l
	carbon_settings[37] = "100";//l
	carbon_settings[38] = "100";//l
	carbon_settings[39] = "100";//l
	carbon_settings[40] = "100";//l
	carbon_settings[41] = "100";//l
	carbon_settings[42] = "100";//l
	carbon_settings[43] = "100";//l
	carbon_settings[44] = "100";//l
	carbon_settings[45] = "100";//l
	carbon_settings[46] = "100";//l
	carbon_settings[47] = "100";//l
	carbon_settings[48] = "100";//l
	carbon_settings[49] = "100";//l
	carbon_settings[50] = "100";//l
	carbon_settings[51] = "100";//l
	carbon_settings[52] = "100";//l
	carbon_settings[53] = "100";//l
	carbon_settings[54] = "100";//l
	carbon_settings[55] = "100";//l
	carbon_settings[56] = "100";//l
	carbon_settings[57] = "100";//l
	carbon_settings[58] = "100";//l
	carbon_settings[59] = "100";//l
	carbon_settings[60] = "100";//l
	carbon_settings[61] = "100";//l
	carbon_settings[62] = "100";//l
	carbon_settings[63] = "100";//l
	carbon_settings[64] = "100";//l
	carbon_settings[65] = "100";//l
	carbon_settings[66] = "100";//l
	carbon_settings[67] = "100";//l
	carbon_settings[68] = "100";//l
	carbon_settings[69] = "100";//l
	carbon_settings[70] = "100";//l
	carbon_settings[71] = "100";//l
	carbon_settings[72] = "100";//l
	carbon_settings[73] = "100";//l
	carbon_settings[74] = "100";//l
	carbon_settings[75] = "100";//l
	carbon_settings[76] = "100";//l
	carbon_settings[77] = "100";//l
	carbon_settings[78] = "100";//l
	carbon_settings[79] = "100";//l
	carbon_settings[80] = "100";//l
	carbon_settings[81] = "100";//l
	carbon_settings[82] = "100";//l
	carbon_settings[83] = "100";//l
	carbon_settings[84] = "100";//l
	carbon_settings[85] = "100";//l
	carbon_settings[86] = "100";//l
	carbon_settings[87] = "100";//l
	carbon_settings[88] = "100";//l
	carbon_settings[89] = "100";//l
	carbon_settings[90] = "100";//l
	carbon_settings[91] = "100";//l
	carbon_settings[92] = "100";//l
	carbon_settings[93] = "100";//l
	carbon_settings[94] = "100";//l
	carbon_settings[95] = "100";//l
	carbon_settings[96] = "100";//l
	carbon_settings[97] = "100";//l
	carbon_settings[98] = "100";//l
	carbon_settings[99] = "100";//l

	}//****************************



	public void save_settings(){

	//carbon_settings = new String[100];

	//carbon_settings[0] = "100";//screen x
	//carbon_settings[1] = "100";//screen y
	carbon_settings[2] = Integer.toString(db_section);//db section
	carbon_settings[3] = searchx.getText();//search text
	//carbon_settings[4] = "1";//search field
	carbon_settings[5] = urlc1.getText();//url text
	carbon_settings[6] = urlp1.getText();//url pass
	//carbon_settings[7] = "100";//store name
	//carbon_settings[8] = "100";//store password
	carbon_settings[9] = CURRENCY;//store currency
	//carbon_settings[10] = "0";//btcinfo 1
	//carbon_settings[11] = "0";//btcinfo 2
	//carbon_settings[12] = "0";//btcinfo 3
	//carbon_settings[13] = "0";//btcinfo 4
	//carbon_settings[14] = "0";//btcinfo 5
	//carbon_settings[15] = "0";//btcinfo 6
	//carbon_settings[16] = "0";//btcinfo 7
	//carbon_settings[17] = "0";//btcinfo 8
	//carbon_settings[18] = "0";//btcinfo 9
	//carbon_settings[19] = "0";//btcinfo 10
	//carbon_settings[20] = "0";//btcinfo 11
	//carbon_settings[21] = "0";//btcinfo 12
	//carbon_settings[22] = "0";//btcinfo 13
	//carbon_settings[23] = "0";//btcinfo 14
	//carbon_settings[24] = "0";//btcinfo 15
	//carbon_settings[25] = "0";//db password
	carbon_settings[26] = Integer.toString(wallet_system);//wallet system
	carbon_settings[27] = Integer.toString(second_passworld_select);//second password for blockchain.info
	//carbon_settings[28] = "100";//search tool db section
	//carbon_settings[29] = "100";//search tool text 1
	//carbon_settings[30] = "100";//search tool text 2
	//carbon_settings[31] = "100";//l
	//carbon_settings[32] = "100";//l
	//carbon_settings[33] = "100";//l
	//carbon_settings[34] = "100";//l
	//carbon_settings[35] = "100";//l
	//carbon_settings[36] = "100";//l
	//carbon_settings[37] = "100";//l
	//carbon_settings[38] = "100";//l
	//carbon_settings[39] = "100";//l
	//carbon_settings[40] = "100";//l
	//carbon_settings[41] = "100";//l
	//carbon_settings[42] = "100";//l
	//carbon_settings[43] = "100";//l
	//carbon_settings[44] = "100";//l
	//carbon_settings[45] = "100";//l
	//carbon_settings[46] = "100";//l
	//carbon_settings[47] = "100";//l
	//carbon_settings[48] = "100";//l
	//carbon_settings[49] = "100";//l
	//carbon_settings[50] = "100";//l
	//carbon_settings[51] = "100";//l
	//carbon_settings[52] = "100";//l
	//carbon_settings[53] = "100";//l
	//carbon_settings[54] = "100";//l
	//carbon_settings[55] = "100";//l
	//carbon_settings[56] = "100";//l
	//carbon_settings[57] = "100";//l
	//carbon_settings[58] = "100";//l
	//carbon_settings[59] = "100";//l
	//carbon_settings[60] = "100";//l
	//carbon_settings[61] = "100";//l
	//carbon_settings[62] = "100";//l
	//carbon_settings[63] = "100";//l
	//carbon_settings[64] = "100";//l
	//carbon_settings[65] = "100";//l
	//carbon_settings[66] = "100";//l
	//carbon_settings[67] = "100";//l
	//carbon_settings[68] = "100";//l
	//carbon_settings[69] = "100";//l
	//carbon_settings[70] = "100";//l
	//carbon_settings[71] = "100";//l
	//carbon_settings[72] = "100";//l
	//carbon_settings[73] = "100";//l
	//carbon_settings[74] = "100";//l
	//carbon_settings[75] = "100";//l
	//carbon_settings[76] = "100";//l
	//carbon_settings[77] = "100";//l
	//carbon_settings[78] = "100";//l
	//carbon_settings[79] = "100";//l
	//carbon_settings[80] = "100";//l
	//carbon_settings[81] = "100";//l
	//carbon_settings[82] = "100";//l
	//carbon_settings[83] = "100";//l
	//carbon_settings[84] = "100";//l
	//carbon_settings[85] = "100";//l
	//carbon_settings[86] = "100";//l
	//carbon_settings[87] = "100";//l
	//carbon_settings[88] = "100";//l
	//carbon_settings[89] = "100";//l
	//carbon_settings[90] = "100";//l
	//carbon_settings[91] = "100";//l
	//carbon_settings[92] = "100";//l
	//carbon_settings[93] = "100";//l
	//carbon_settings[94] = "100";//l
	//carbon_settings[95] = "100";//l
	//carbon_settings[96] = "100";//l
	//carbon_settings[97] = "100";//l
	//carbon_settings[98] = "100";//l
	//carbon_settings[99] = "100";//l

	}//****************************









	public void loadx(){

	System.out.println("Load DB");

	jdb_load jdbx = new jdb_load();

	System.out.println("DB Loaded");

	}//*****************



	public void savex(){

	setVisible(false);

	jdb_save jdbx = new jdb_save();
	System.out.println("SHUTDOWN");

	}//*****************













	public void databasex(){

	database = new String[82];

	database[0] = new String("buyer_address_1");
	database[1] = new String("buyer_address_2");
	database[2] = new String("buyer_address_city");
	database[3] = new String("buyer_address_state");
	database[4] = new String("buyer_address_zip");
	database[5] = new String("buyer_address_country");
	database[6] = new String("buyer_id");
	database[7] = new String("buyer_ip");
	database[8] = new String("buyers_email");
	database[9] = new String("buyers_first_name");
	database[10] = new String("buyers_last_name");
	database[11] = new String("buyers_payment_address");
	database[12] = new String("buyers_phone");
	database[13] = new String("currency");
	database[14] = new String("custom_template");
	database[15] = new String("custom_1");
	database[16] = new String("custom_2");
	database[17] = new String("custom_3");
	database[18] = new String("item_errors");
	database[19] = new String("item_date_listed");
	database[20] = new String("item_date_listed_day");
	database[21] = new String("item_date_listed_int");
	database[22] = new String("item_hits");
	database[23] = new String("item_confirm_code");
	database[24] = new String("item_confirmed");
	database[25] = new String("item_cost");
	database[26] = new String("item_description");
	database[27] = new String("item_id");
	database[28] = new String("item_price");
	database[29] = new String("item_weight");
	database[30] = new String("item_listing_id");
	database[31] = new String("item_notes");
	database[32] = new String("item_package_d");
	database[33] = new String("item_package_l");
	database[34] = new String("item_package_w");
	database[35] = new String("item_part_number");
	database[36] = new String("item_title");
	database[37] = new String("item_title_url");
	database[38] = new String("item_type");
	database[39] = new String("item_search_1");
	database[40] = new String("item_search_2");
	database[41] = new String("item_search_3");
	database[42] = new String("item_site_id");
	database[43] = new String("item_site_url");
	database[44] = new String("item_picture_1");
	database[45] = new String("item_total_on_hand");
	database[46] = new String("sale_date_payment_received");
	database[47] = new String("sale_date_shipped");
	database[48] = new String("sale_date_sold");
	database[49] = new String("sale_final_value_fee");
	database[50] = new String("sale_handling");
	database[51] = new String("sale_payment_address");
	database[52] = new String("sale_payment_type");
	database[53] = new String("sale_fees");
	database[54] = new String("sale_quantity_sold");
	database[55] = new String("sale_id");
	database[56] = new String("sale_seller_id");
	database[57] = new String("sale_status");
	database[58] = new String("sale_tax");
	database[59] = new String("sale_shipping_company");
	database[60] = new String("sale_shipping_in");
	database[61] = new String("sale_shipping_out");
	database[62] = new String("sale_source_of_sale");
	database[63] = new String("sale_total_sale_amount");
	database[64] = new String("sale_tracking_number");
	database[65] = new String("sale_transaction_id");
	database[66] = new String("sale_transaction_info");
	database[67] = new String("seller_address_1");
	database[68] = new String("seller_address_2");
	database[69] = new String("seller_address_city");
	database[70] = new String("seller_address_state");
	database[71] = new String("seller_address_zip");
	database[72] = new String("seller_address_country");
	database[73] = new String("seller_id");
	database[74] = new String("seller_ip");
	database[75] = new String("seller_email");
	database[76] = new String("seller_first_name");
	database[77] = new String("seller_last_name");
	database[78] = new String("seller_notes");
	database[79] = new String("seller_phone");
	database[80] = new String("seller_logo");
	database[81] = new String("seller_url");


	}//********************













//*******************************************************************************************************************************************
//*******************************************************************************************************************************************



//select******************************************************************************
//select******************************************************************************
//select******************************************************************************






	public void select_all_items1(){//******************************************

	System.out.println("select all ctr1: " + dbx_total + " " + dbx_start);

	total_items_selected = 0;

if(db_section == 0 || db_section == 1){
	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//***********************************************************************************

	if(xloop != 0){//*******	

	System.out.println(">>>SELECT " + xloop);
	jpkx[xloop].setBackground(selectx);
	selected_int[xloop] = 1;
	total_items_selected++;

	}//*********************

	}//for************************************************************************************************************************************
}//*************************************
if(db_section == 2 || db_section == 3){
	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//***********************************************************************************


	System.out.println(">>>SELECT " + xloop);
	jpkx[xloop].setBackground(selectx);
	selected_int[xloop] = 1;
	total_items_selected++;


	}//for************************************************************************************************************************************
}//*************************************

	if(db_section == 0 || db_section == 1){selected_int[0] = 0;}

	infoxs1.setText(Integer.toString(total_items_selected) + " Items Selected");


	


	}//select_all_items*********************************************************









//select******************************************************************************
//select******************************************************************************
//select******************************************************************************


//tools******************************************************************************
//tools******************************************************************************
//tools******************************************************************************











	public void make_item(){
	
	System.out.println("Make New Item");

	int hh3 = 0;
	int hh4 = 0;

	if(db_section == 0){hh3 = carbon_sell[0].length;}
	else if(db_section == 1){hh3 = carbon_buy[0].length;}

	if(db_section == 0){hh4 = carbon_sell[0].length + 1;}
	else if(db_section == 1){hh4 = carbon_buy[0].length + 1;}

	System.out.println("hh3 " + hh3);
	System.out.println("hh4 " + hh4);

	String[][] carbon_build = new String[db_sections][hh4];


	
	for(int xloop1 = 0; xloop1 < hh3; xloop1++){//********************************************************

	for(int xloop2 = 0; xloop2 < db_sections; xloop2++){//*******************************************

	System.out.println(carbon_build[xloop2][xloop1]);
	System.out.println(carbon_sell[xloop2][xloop1]);

	if(db_section == 0){carbon_build[xloop2][xloop1] = carbon_sell[xloop2][xloop1];}
	else if(db_section == 1){carbon_build[xloop2][xloop1] = carbon_buy[xloop2][xloop1];}

	}//for*******************************************************************************************

	}//for************************************************************************************************



	carbon_build[0][hh3]  = new String("buyer_address_1");
	carbon_build[1][hh3]  = new String("buyer_address_2");
	carbon_build[2][hh3]  = new String("buyer_address_city");
	carbon_build[3][hh3]  = new String("buyer_address_state");
	carbon_build[4][hh3]  = new String("buyer_address_zip");
	carbon_build[5][hh3]  = new String("buyer_address_country");
	carbon_build[6][hh3]  = new String("buyer_id");//BTC ADDRESS
	carbon_build[7][hh3]  = new String("buyer_ip");
	carbon_build[8][hh3]  = new String("buyers_email");
	carbon_build[9][hh3]  = new String("buyers_first_name");
	carbon_build[10][hh3] = new String("buyers_last_name");
	carbon_build[11][hh3] = new String("buyers_payment_address");
	carbon_build[12][hh3] = new String("buyers_phone");
	carbon_build[13][hh3] = new String(carbon_settings[9]);//currency
	carbon_build[14][hh3] = new String("custom_template");
	carbon_build[15][hh3] = new String("custom_1");
	carbon_build[16][hh3] = new String("custom_2");
	carbon_build[17][hh3] = new String("custom_3");
	carbon_build[18][hh3] = new String("item_errors");
	carbon_build[19][hh3] = new String("item_date_listed");
	carbon_build[20][hh3] = new String("item_date_listed_day");
	carbon_build[21][hh3] = new String("item_date_listed_int");
	carbon_build[22][hh3] = new String("0");//hits
	carbon_build[23][hh3] = new String("item_confirm_code");
	carbon_build[24][hh3] = new String("item_confirmed");
	carbon_build[25][hh3] = new String("0.00");//cost
	carbon_build[26][hh3] = new String("item_description");
	carbon_build[27][hh3] = new String(Long.toString(System.currentTimeMillis()));//item_id
	carbon_build[28][hh3] = new String("110.01");//sale price
	carbon_build[29][hh3] = new String("33");//weight
	carbon_build[30][hh3] = new String("item_listing_id");//ACTIVE OR NOT
	carbon_build[31][hh3] = new String("item_notes");
	carbon_build[32][hh3] = new String("10");//item_package_d
	carbon_build[33][hh3] = new String("10");//item_package_l
	carbon_build[34][hh3] = new String("10");//item_package_w
	carbon_build[35][hh3] = new String("item_part_number");
	carbon_build[36][hh3] = new String("new item");//title
	carbon_build[37][hh3] = new String("item_title_url");
	carbon_build[38][hh3] = new String("item_type");
	carbon_build[39][hh3] = new String("item_search_1");
	carbon_build[40][hh3] = new String("item_search_2");
	carbon_build[41][hh3] = new String("item_search_3");
	carbon_build[42][hh3] = new String("item_site_id");
	carbon_build[43][hh3] = new String("item_site_url");
	carbon_build[44][hh3] = new String("[url]/pictures/");//picture_1
	carbon_build[45][hh3] = new String("0");//item_total_on_hand
	carbon_build[46][hh3] = new String("sale_date_payment_received");
	carbon_build[47][hh3] = new String("sale_date_shipped");
	carbon_build[48][hh3] = new String("sale_date_sold");
	carbon_build[49][hh3] = new String("sale_final_value_fee");
	carbon_build[50][hh3] = new String("sale_handling");
	carbon_build[51][hh3] = new String("sale_payment_address");
	carbon_build[52][hh3] = new String("sale_payment_type");
	carbon_build[53][hh3] = new String("sale_fees");
	carbon_build[54][hh3] = new String("sale_quantity_sold");
	carbon_build[55][hh3] = new String("sale_id");
	carbon_build[56][hh3] = new String("sale_seller_id");
	carbon_build[57][hh3] = new String("Unsold");//sale_status
	carbon_build[58][hh3] = new String("0.00");//sale_tax
	carbon_build[59][hh3] = new String("sale_shipping_company");
	carbon_build[60][hh3] = new String("0.00");//sale_shipping_in
	carbon_build[61][hh3] = new String("0.00");//sale_shipping_out
	carbon_build[62][hh3] = new String("sale_source_of_sale");
	carbon_build[63][hh3] = new String("sale_total_sale_amount");
	carbon_build[64][hh3] = new String("sale_tracking_number");
	carbon_build[65][hh3] = new String("sale_transaction_id");
	carbon_build[66][hh3] = new String("sale_transaction_info");
	carbon_build[67][hh3] = new String("seller_address_1");
	carbon_build[68][hh3] = new String("seller_address_2");
	carbon_build[69][hh3] = new String("seller_address_city");
	carbon_build[70][hh3] = new String("seller_address_state");
	carbon_build[71][hh3] = new String("seller_address_zip");
	carbon_build[72][hh3] = new String("seller_address_country");
	carbon_build[73][hh3] = new String("seller_id");//BTC ADDRESS
	carbon_build[74][hh3] = new String("seller_ip");
	carbon_build[75][hh3] = new String("seller_email");
	carbon_build[76][hh3] = new String("seller_first_name");
	carbon_build[77][hh3] = new String("seller_last_name");
	carbon_build[78][hh3] = new String("seller_notes");
	carbon_build[79][hh3] = new String("seller_phone");
	carbon_build[80][hh3] = new String("seller_logo");
	carbon_build[81][hh3] = new String("seller_url");



	

	if(db_section == 0){carbon_sell = carbon_build;}
	else if(db_section == 1){carbon_buy = carbon_build;}

	if(db_section == 0){dbx_end = carbon_sell[0].length;}
	else if(db_section == 1){dbx_end = carbon_buy[0].length;}

	if(db_section == 0){sell_button_click();}
	else if(db_section == 1){buy_button_click();}

	}//*********************


















	public void make_stripes(){

	System.out.println("make stripes");

	stripesx = 0;
	


	for(int xloop = dbx_start; xloop < dbx_end; xloop++){//******	

	xstripesc = st_gray1;
	if(stripesx == 1){stripesx = 0; xstripesc = st_gray2;} else{stripesx++;}
	jpkx[xloop].setBackground(xstripesc);

	if(selected_int[xloop] == 1){jpkx[xloop].setBackground(selectx);}

	}//**********************************************************

	try{
	if(db_section == 0 || db_section == 1){jpkx[0].setBackground(gray7);}
	}catch(Exception e){System.out.println("Display x not 0");}



	}//***************************make_striples















	public void start_buy_list(){

	carbon_buy = new String[82][1];

	carbon_buy[0][0] = new String("[[buyer_address_1]]");
	carbon_buy[1][0] = new String("[[buyer_address_2]]");
	carbon_buy[2][0] = new String("[[buyer_address_city]]");
	carbon_buy[3][0] = new String("[[buyer_address_state]]");
	carbon_buy[4][0] = new String("[[buyer_address_zip]]");
	carbon_buy[5][0] = new String("[[buyer_address_country]]");
	carbon_buy[6][0] = new String("[[buyer_id]]");
	carbon_buy[7][0] = new String("[[buyer_ip]]");
	carbon_buy[8][0] = new String("[[buyers_email]]");
	carbon_buy[9][0] = new String("[[buyers_first_name]]");
	carbon_buy[10][0] = new String("[[buyers_last_name]]");
	carbon_buy[11][0] = new String("[[buyers_payment_address]]");
	carbon_buy[12][0] = new String("[[buyers_phone]]");
	carbon_buy[13][0] = new String("[[currency]]");
	carbon_buy[14][0] = new String("[[custom_template]]");
	carbon_buy[15][0] = new String("[[custom_1]]");
	carbon_buy[16][0] = new String("[[custom_2]]");
	carbon_buy[17][0] = new String("[[custom_3]]");
	carbon_buy[18][0] = new String("[[item_errors]]");
	carbon_buy[19][0] = new String("[[item_date_listed]]");
	carbon_buy[20][0] = new String("[[item_date_listed_day]]");
	carbon_buy[21][0] = new String("[[item_date_listed_int]]");
	carbon_buy[22][0] = new String("[[item_hits]]");
	carbon_buy[23][0] = new String("[[item_confirm_code]]");
	carbon_buy[24][0] = new String("[[item_confirmed]]");
	carbon_buy[25][0] = new String("[[item_cost]]");
	carbon_buy[26][0] = new String("[[item_description]]");
	carbon_buy[27][0] = new String("[[item_id]]");
	carbon_buy[28][0] = new String("[[item_price]]");
	carbon_buy[29][0] = new String("[[item_weight]]");
	carbon_buy[30][0] = new String("[[item_listing_id]]");
	carbon_buy[31][0] = new String("[[item_notes]]");
	carbon_buy[32][0] = new String("[[item_package_d]]");
	carbon_buy[33][0] = new String("[[item_package_l]]");
	carbon_buy[34][0] = new String("[[item_package_w]]");
	carbon_buy[35][0] = new String("[[item_part_number]]");
	carbon_buy[36][0] = new String("[[item_title]]");
	carbon_buy[37][0] = new String("[[item_title_url]]");
	carbon_buy[38][0] = new String("[[item_type]]");
	carbon_buy[39][0] = new String("[[item_search_1]]");
	carbon_buy[40][0] = new String("[[item_search_2]]");
	carbon_buy[41][0] = new String("[[item_search_3]]");
	carbon_buy[42][0] = new String("[[item_site_id]]");
	carbon_buy[43][0] = new String("[[item_site_url]]");
	carbon_buy[44][0] = new String("[[item_picture_1]]");
	carbon_buy[45][0] = new String("[[item_total_on_hand]]");
	carbon_buy[46][0] = new String("[[sale_date_payment_received]]");
	carbon_buy[47][0] = new String("[[sale_date_shipped]]");
	carbon_buy[48][0] = new String("[[sale_date_sold]]");
	carbon_buy[49][0] = new String("[[sale_final_value_fee]]");
	carbon_buy[50][0] = new String("[[sale_handling]]");
	carbon_buy[51][0] = new String("[[sale_payment_address]]");
	carbon_buy[52][0] = new String("[[sale_payment_type]]");
	carbon_buy[53][0] = new String("[[sale_fees]]");
	carbon_buy[54][0] = new String("[[sale_quantity_sold]]");
	carbon_buy[55][0] = new String("[[sale_id]]");
	carbon_buy[56][0] = new String("[[sale_seller_id]]");
	carbon_buy[57][0] = new String("[[sale_status]]");
	carbon_buy[58][0] = new String("[[sale_tax]]");
	carbon_buy[59][0] = new String("[[sale_shipping_company]]");
	carbon_buy[60][0] = new String("[[sale_shipping_in]]");
	carbon_buy[61][0] = new String("[[sale_shipping_out]]");
	carbon_buy[62][0] = new String("[[sale_source_of_sale]]");
	carbon_buy[63][0] = new String("[[sale_total_sale_amount]]");
	carbon_buy[64][0] = new String("[[sale_tracking_number]]");
	carbon_buy[65][0] = new String("[[sale_transaction_id]]");
	carbon_buy[66][0] = new String("[[sale_transaction_info]]");
	carbon_buy[67][0] = new String("[[seller_address_1]]");
	carbon_buy[68][0] = new String("[[seller_address_2]]");
	carbon_buy[69][0] = new String("[[seller_address_city]]");
	carbon_buy[70][0] = new String("[[seller_address_state]]");
	carbon_buy[71][0] = new String("[[seller_address_zip]]");
	carbon_buy[72][0] = new String("[[seller_address_country]]");
	carbon_buy[73][0] = new String("[[seller_id]]");
	carbon_buy[74][0] = new String("[[seller_ip]]");
	carbon_buy[75][0] = new String("[[seller_email]]");
	carbon_buy[76][0] = new String("[[seller_first_name]]");
	carbon_buy[77][0] = new String("[[seller_last_name]]");
	carbon_buy[78][0] = new String("[[seller_notes]]");
	carbon_buy[79][0] = new String("[[seller_phone]]");
	carbon_buy[80][0] = new String("[[seller_logo]]");
	carbon_buy[81][0] = new String("[[seller_url]]");


	}//**************************



//tools******************************************************************************
//tools******************************************************************************
//tools******************************************************************************




//tasks**************************************************************************************************
//tasks**************************************************************************************************






	class RemindTask_system_engine extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//**************************************************************************************

	runxx = 1;
	int runtimexx = 0;


	while(runxx == 1){//**************************************

	System.out.println("system loop 1");

	infox1.setText("system loop 1");


	inventory.setText("Orders (" + carbon_sold[0].length + ")");
	purchased.setText("Purchased (" + carbon_purchase[0].length + ")");


	infox1.setText("system loop 2");


	if(server_requests > 0){infox4.setIcon(imx4);}
	else{infox4.setIcon(imx2);}
	infox4.setText("Uses(" + server_requests + ")");


	infox1.setText("system loop 3");


		for(int xloop1 = 1; xloop1 < carbon_sell[0].length; xloop1++){//***********

		   try{

			if(carbon_sell[seller_id_xx][xloop1].length() < 26){
			infox1.setText("Make new ADDRESS"); 

		        	new_address_item = xloop1;
		        	//JOptionPane.showMessageDialog(null, "MAKE NEW ADDRESS " + Integer.toString(xloop1));
				get_new_payment_address2();

			carbon_sell[seller_id_xx][xloop1] = new_wallet_address;

			}//**************************************************

		   }catch(Exception e){infox1.setText("Error getting new payment address!");}

		}//************************************************************************


	infox1.setText("system loop 4");

	System.out.println("RUNTIME " + runtimexx);
		if(runtimexx == 200){

		get_sales_status();

		}//******************


	infox1.setText("system loop 5");



	try{Thread.sleep(20000);} catch(InterruptedException e){}

	if(runtimexx > 300){runtimexx = 0;}

	runtimexx++;

	}//while**************************************************

	}//runx***************************************************************************************************
        }//remindtask







	public void get_sales_status(){

	int loopxxxxx = 0;

		for(int xloop1 = 0; xloop1 < carbon_sold[0].length; xloop1++){//***********
		loopxxxxx = xloop1;


	try{

		infox1.setText("Test sales for confirmations " + Integer.toString(xloop1));

		if(carbon_sold[sale_status_xx][xloop1].equals("Reserved")){
		infox1.setText("Confirm Payments"); 

		//JOptionPane.showMessageDialog(null, "CONFIRM " + Integer.toString(xloop1));

		rpcaddress_confirm = carbon_sold[seller_id_xx][xloop1];
		System.out.println("rpcaddress_confirm " + rpcaddress_confirm);

		
				if(wallet_system == 0){blockchain_api_confirm apic = new blockchain_api_confirm();}
				else if(wallet_system == 1){rpc_client_confirm rpcx = new rpc_client_confirm();}


			System.out.println("<" + wallet_value_confirm + ">");
			System.out.println("<" + carbon_sold[sale_total_sale_amount_xx][xloop1] + ">");

			String xx = new String("<" + wallet_value_confirm + ">");
			String yy = new String("<" + carbon_sold[sale_total_sale_amount_xx][xloop1] + ">");

			if(xx.equals(yy)){System.out.println("CONFIRMED"); carbon_sold[sale_status_xx][xloop1] = "Confirmed";}
			else{System.out.println("NOT E");}

			if(db_section == 2){display_item();}
			else{System.out.println("NOT 2");}
	
		}//********************************************************

	}catch(Exception e){infox1.setText("Error getting status " + Integer.toString(loopxxxxx));}


		}//************************************************************************


	}//get_sales_status************













	class RemindTask_get_items extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//**************************************************************************************

	int item_request = 1;


	while(getting_items == 1 && carbon_buy[0].length > 1){//**


	infox1.setText("loading database items from server " + carbon_buy[item_id_xx][item_request]);

	net_client_inventory_item nclient = new net_client_inventory_item(carbon_buy[item_id_xx][item_request]);

	display_item();

	//try{Thread.sleep(200);} catch(InterruptedException e){}

	
	item_request++;

	if(item_request < carbon_buy[0].length){}
	else{getting_items = 0; System.out.println("DONE"); break;}




	}//while**************************************************

	infoxs1.setText("Item list loaded");
	buy_button_click();

	}//runx***************************************************************************************************
        }//remindtask








//tasks**************************************************************************************************
//tasks**************************************************************************************************




//tools**************************************************************************************************
//tools**************************************************************************************************




	public void sortx(){

	if(db_section == 0){sortx_engine0();}
	else if(db_section == 1){}
	else if(db_section == 2){sortx_engine2();}
	else if(db_section == 3){sortx_engine3();}
	else{infox1.setText("These items cannot be sorted");}

	}//sort





	public void sortx_engine0(){//******************************************************************************************************

	int sort_int = item_part_number_xx;


	String[][] data = new String[carbon_sell[sort_int].length][2];

	for(int xloopx = 0; xloopx < carbon_sell[sort_int].length; xloopx++){//******

	data[xloopx][0] = carbon_sell[sort_int][xloopx];
	data[xloopx][1] = new String(Integer.toString(xloopx));

	}//*****************************************************************************



        Arrays.sort(data, 1, carbon_sell[sort_int].length, new Comparator<String[]>() {
            @Override

            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }

        });

        for (final String[] s : data) {
            //System.out.println(s[1] + " " + s[0]);
        }



	String[][] data2 = new String[carbon_sell.length][carbon_sell[sort_int].length];


	for(int xloop0 = 0; xloop0 < carbon_sell[sort_int].length; xloop0++){//***************
	for(int xloop1 = 0; xloop1 < carbon_sell.length; xloop1++){//***********

	data2[xloop1][xloop0] = carbon_sell[xloop1][ Integer.parseInt(data[xloop0][1]) ];

	}//************************************************************************
	}//**************************************************************************************


	carbon_sell = data2;

	display_item();



	for(int xloop = 0; xloop < db_sections; xloop++){//*******
	carbon_sell[xloop][0] = "[[" + database[xloop] + "]]";
	}//*******************************************************
	carbon_sell[sort_int][0] = "*[[" + database[sort_int] + "]]";


	}//sort*********************************************************************************************************************






	public void sortx_engine1(){//******************************************************************************************************

	int sort_int = item_title_xx;


	String[][] data = new String[carbon_buy[sort_int].length][2];

	for(int xloopx = 0; xloopx < carbon_buy[sort_int].length; xloopx++){//******

	data[xloopx][0] = carbon_buy[sort_int][xloopx];
	data[xloopx][1] = new String(Integer.toString(xloopx));

	}//*****************************************************************************



        Arrays.sort(data, 1, carbon_buy[sort_int].length, new Comparator<String[]>() {
            @Override

            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }

        });

        for (final String[] s : data) {
            //System.out.println(s[1] + " " + s[0]);
        }



	String[][] data2 = new String[carbon_buy.length][carbon_buy[sort_int].length];


	for(int xloop0 = 0; xloop0 < carbon_buy[sort_int].length; xloop0++){//***************
	for(int xloop1 = 0; xloop1 < carbon_buy.length; xloop1++){//***********

	data2[xloop1][xloop0] = carbon_buy[xloop1][ Integer.parseInt(data[xloop0][1]) ];

	}//************************************************************************
	}//**************************************************************************************


	carbon_buy = data2;

	display_item();



	for(int xloop = 0; xloop < db_sections; xloop++){//*******
	carbon_buy[xloop][0] = "[[" + database[xloop] + "]]";
	}//*******************************************************
	carbon_buy[sort_int][0] = "*[[" + database[sort_int] + "]]";


	}//sort*********************************************************************************************************************






	public void sortx_engine2(){//******************************************************************************************************

	int sort_int = sale_date_sold_xx;


	String[][] data = new String[carbon_sold[sort_int].length][2];

	for(int xloopx = 0; xloopx < carbon_sold[sort_int].length; xloopx++){//******

	data[xloopx][0] = carbon_sold[sort_int][xloopx];
	data[xloopx][1] = new String(Integer.toString(xloopx));

	}//*****************************************************************************



        Arrays.sort(data, 0, carbon_sold[sort_int].length, new Comparator<String[]>() {
            @Override

            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time2.compareTo(time1);
            }

        });

        for (final String[] s : data) {
            //System.out.println(s[1] + " " + s[0]);
        }



	String[][] data2 = new String[carbon_sold.length][carbon_sold[sort_int].length];


	for(int xloop0 = 0; xloop0 < carbon_sold[sort_int].length; xloop0++){//***************
	for(int xloop1 = 0; xloop1 < carbon_sold.length; xloop1++){//***********

	data2[xloop1][xloop0] = carbon_sold[xloop1][ Integer.parseInt(data[xloop0][1]) ];

	}//************************************************************************
	}//**************************************************************************************


	carbon_sold = data2;

	display_item();



	//for(int xloop = 0; xloop < db_sections; xloop++){//*******
	//carbon_sold[xloop][0] = "[[" + database[xloop] + "]]";
	//}//*******************************************************
	//carbon_sold[sort_int][0] = "*[[" + database[sort_int] + "]]";


	}//sort*********************************************************************************************************************






	public void sortx_engine3(){//******************************************************************************************************

	int sort_int = sale_date_sold_xx;


	String[][] data = new String[carbon_purchase[sort_int].length][2];

	for(int xloopx = 0; xloopx < carbon_purchase[sort_int].length; xloopx++){//******

	data[xloopx][0] = carbon_purchase[sort_int][xloopx];
	data[xloopx][1] = new String(Integer.toString(xloopx));

	}//*****************************************************************************



        Arrays.sort(data, 0, carbon_purchase[sort_int].length, new Comparator<String[]>() {
            @Override

            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time2.compareTo(time1);
            }

        });

        for (final String[] s : data) {
            //System.out.println(s[1] + " " + s[0]);
        }



	String[][] data2 = new String[carbon_purchase.length][carbon_purchase[sort_int].length];


	for(int xloop0 = 0; xloop0 < carbon_purchase[sort_int].length; xloop0++){//***************
	for(int xloop1 = 0; xloop1 < carbon_purchase.length; xloop1++){//***********

	data2[xloop1][xloop0] = carbon_purchase[xloop1][ Integer.parseInt(data[xloop0][1]) ];

	}//************************************************************************
	}//**************************************************************************************


	carbon_purchase = data2;

	display_item();



	//for(int xloop = 0; xloop < db_sections; xloop++){//*******
	//carbon_purchase[xloop][0] = "[[" + database[xloop] + "]]";
	//}//*******************************************************
	//carbon_purchase[sort_int][0] = "*[[" + database[sort_int] + "]]";


	}//sort*********************************************************************************************************************








//tools**************************************************************************************************
//tools**************************************************************************************************

//buttons**************************************************************************************************
//buttons**************************************************************************************************




	public void sell_button_click(){

	pressx = 0; 
	pressy = 0; 
	pressx_repaint = 0;

	what_item = 0;
	what_item_old = 0;

	db_section = 0;
	infoxs2.setText("(Sell Section) Build your database of items to sell");
	url_info2.setText("Connect To Gateway");

	qrcodepic.setEnabled(true);

 	sell_button.setIcon(imx_on); 
 	sell_button.setForeground(whitex);
 	buy_button.setIcon(imx_off); 
 	buy_button.setForeground(grayx3);

	searchb.setEnabled(false);
	searchx.setEnabled(false);
	searchf.setEnabled(false);

	item0.setEnabled(true);
	item1.setEnabled(true);

	buy_1.setEnabled(false);
	buy_2.setEnabled(false);
	buy_3.setEnabled(false);
	buy_4.setEnabled(false);
	buy_5.setEnabled(false);
	buy_6.setEnabled(false);

	sort_1.setEnabled(true);
	sort_2.setEnabled(true);
	sort_3.setEnabled(true);
	sort_4.setEnabled(true);
	sort_5.setEnabled(true);
	sort_6.setEnabled(false);
	sort_7.setEnabled(true);
	sort_8.setEnabled(true);

	edit_new.setEnabled(true);
	edit_new10.setEnabled(true);
	edit_edit.setEnabled(true);
	edit_replace.setEnabled(true);
	edit_delete.setEnabled(true);

	edit_title.setEditable(true);
	edit_part.setEditable(true);
	edit_cost.setEditable(true);
	edit_price.setEditable(true);
	edit_toh.setEditable(true);
	edit_weight.setEditable(true);
	edit_picture.setEditable(true);

	url_connect.setEnabled(false);
	urlc1.setEnabled(false);
	urlp1.setEnabled(false);

		for(int xloop = 1; xloop < carbon_sell[0].length; xloop++){//*****************

	        if(carbon_sell[item_hits_xx][xloop].equals("item_hits")){carbon_sell[item_hits_xx][xloop] = "0";}
		if(carbon_sell[seller_id_xx][xloop].equals("seller_id")){carbon_sell[seller_id_xx][xloop] = carbon_settings[11];}
		if(carbon_sell[item_id_xx][xloop].equals("item_id")){carbon_sell[item_id_xx][xloop] = Long.toString(System.currentTimeMillis());}
	        if(carbon_sell[currency_xx][xloop].equals("currency")){carbon_sell[currency_xx][xloop] = carbon_settings[9];}
	        if(carbon_sell[seller_id_xx][xloop].equals("seller_id")){carbon_sell[seller_id_xx][xloop] = carbon_settings[7];}

		}//setup**********************************************************************

	set_1000_page();
	displayx();
	display_item();
	refreshx();

	sortx();

	}//**********************








	public void buy_button_click(){

	pressx = 0; 
	pressy = 0; 
	pressx_repaint = 0;

	what_item = 0;
	what_item_old = 0;

	db_section = 1;
	infoxs2.setText("(Buy Section) Browse remote databases");
	url_info2.setText("Connect To Host");

	qrcodepic.setEnabled(true);

 	buy_button.setIcon(imx_on); 
 	buy_button.setForeground(whitex);
 	sell_button.setIcon(imx_off); 
 	sell_button.setForeground(grayx3);

	item0.setEnabled(true);
	item1.setEnabled(false);

	buy_1.setEnabled(true);
	buy_2.setEnabled(false);
	buy_3.setEnabled(false);
	buy_4.setEnabled(false);
	buy_5.setEnabled(false);
	buy_6.setEnabled(false);

	sort_1.setEnabled(false);
	sort_2.setEnabled(false);
	sort_3.setEnabled(false);
	sort_4.setEnabled(false);
	sort_5.setEnabled(true);
	sort_6.setEnabled(false);
	sort_7.setEnabled(false);
	sort_8.setEnabled(true);

	edit_new.setEnabled(false);
	edit_new10.setEnabled(false);
	edit_edit.setEnabled(false);
	edit_replace.setEnabled(false);
	edit_delete.setEnabled(false);

	edit_title.setText("");
	edit_part.setText("");
	edit_cost.setText("");
	edit_price.setText("");
	edit_toh.setText("");
	edit_weight.setText("");
	edit_picture.setText("");

	edit_title.setEditable(false);
	edit_part.setEditable(false);
	edit_cost.setEditable(false);
	edit_price.setEditable(false);
	edit_toh.setEditable(false);
	edit_weight.setEditable(false);
	edit_picture.setEditable(false);

	url_connect.setEnabled(true);
	urlc1.setEnabled(true);
	urlp1.setEnabled(true);
	xactive.setText("");
	xtype.setText("");
	xactive.setEnabled(false);
	xtype.setEnabled(false);

	set_1000_page();
	displayx();
	display_item();
	refreshx();

	sortx();

	}//**********************








	public void order_button_click(){

	pressx = 0; 
	pressy = 0; 
	pressx_repaint = 0;

	what_item = 0;
	what_item_old = 0;

	db_section = 2;
	infoxs2.setText("(Order Section) Browse new orders");
	url_info2.setText("Connect");

	qrcodepic.setEnabled(true);

 	buy_button.setIcon(imx_off); 
 	buy_button.setForeground(grayx3);
 	sell_button.setIcon(imx_off); 
 	sell_button.setForeground(grayx3);

	item0.setEnabled(true);
	item1.setEnabled(false);

	buy_1.setEnabled(false);
	buy_2.setEnabled(false);
	buy_3.setEnabled(false);
	buy_4.setEnabled(false);
	buy_5.setEnabled(false);
	buy_6.setEnabled(false);

	sort_1.setEnabled(false);
	sort_2.setEnabled(false);
	sort_3.setEnabled(true);
	sort_4.setEnabled(true);
	sort_5.setEnabled(true);
	sort_6.setEnabled(true);
	sort_7.setEnabled(false);
	sort_8.setEnabled(true);

	edit_new.setEnabled(false);
	edit_new10.setEnabled(false);
	edit_edit.setEnabled(false);
	edit_replace.setEnabled(false);
	edit_delete.setEnabled(true);

	edit_title.setText("");
	edit_part.setText("");
	edit_cost.setText("");
	edit_price.setText("");
	edit_toh.setText("");
	edit_weight.setText("");
	edit_picture.setText("");

	edit_title.setEditable(false);
	edit_part.setEditable(false);
	edit_cost.setEditable(false);
	edit_price.setEditable(false);
	edit_toh.setEditable(false);
	edit_weight.setEditable(false);
	edit_picture.setEditable(false);

	url_connect.setEnabled(false);
	urlc1.setEnabled(false);
	urlp1.setEnabled(false);
	xactive.setText("");
	xtype.setText("");
	xactive.setEnabled(false);
	xtype.setEnabled(false);

	set_1000_page();
	displayx();
	display_item();
	refreshx();

	sortx();

	}//**********************








	public void purchase_button_click(){

	pressx = 0; 
	pressy = 0; 
	pressx_repaint = 0;

	what_item = 0;
	what_item_old = 0;

	db_section = 3;
	infoxs2.setText("(Order Section) Browse new orders");
	url_info2.setText("Connect");

	qrcodepic.setEnabled(true);

 	buy_button.setIcon(imx_off); 
 	buy_button.setForeground(grayx3);
 	sell_button.setIcon(imx_off); 
 	sell_button.setForeground(grayx3);

	item0.setEnabled(true);
	item1.setEnabled(false);

	buy_1.setEnabled(false);
	buy_2.setEnabled(false);
	buy_3.setEnabled(false);
	buy_4.setEnabled(false);
	buy_5.setEnabled(false);
	buy_6.setEnabled(false);

	sort_1.setEnabled(false);
	sort_2.setEnabled(false);
	sort_3.setEnabled(true);
	sort_4.setEnabled(true);
	sort_5.setEnabled(true);
	sort_6.setEnabled(false);
	sort_7.setEnabled(false);
	sort_8.setEnabled(true);

	edit_new.setEnabled(false);
	edit_new10.setEnabled(false);
	edit_edit.setEnabled(false);
	edit_replace.setEnabled(false);
	edit_delete.setEnabled(true);

	edit_title.setText("");
	edit_part.setText("");
	edit_cost.setText("");
	edit_price.setText("");
	edit_toh.setText("");
	edit_weight.setText("");
	edit_picture.setText("");

	edit_title.setEditable(false);
	edit_part.setEditable(false);
	edit_cost.setEditable(false);
	edit_price.setEditable(false);
	edit_toh.setEditable(false);
	edit_weight.setEditable(false);
	edit_picture.setEditable(false);

	url_connect.setEnabled(false);
	urlc1.setEnabled(false);
	urlp1.setEnabled(false);
	xactive.setText("");
	xtype.setText("");
	xactive.setEnabled(false);
	xtype.setEnabled(false);

	set_1000_page();
	displayx();
	display_item();
	refreshx();

	sortx();

	}//**********************













	public void server_ox(){//********************************

	if(serverx_active == 0){

	infox1.setText("start server"); 
	infox3.setIcon(imx4);

	serverx_active = 1;

	}//*********************


	else if(serverx_active == 1){

	infox1.setText("end server"); 
	infox3.setIcon(imx2);

	serverx_active = 0;

	}//*********************

	}//*******************************************************





	




	public void connectedx(){

	getting_items = 0;//turn other worker off

	httpx = urlc1.getText();
	passx = urlp1.getText();

	httpx = httpx.toLowerCase();
	httpx = httpx.replace("http://","");
	httpx = httpx.replace("www.","");
	httpx = httpx.replace(":","");

	urlc1.setText(httpx);

	//test server
	net_client nc = new net_client(); 
	//url_info4.setText(error_codes_client);

	System.out.println(connection_active);

	if(connection_active == 1){
	searchb.setEnabled(true);
	searchx.setEnabled(true);
	searchf.setEnabled(true);
	}//************************
	else{
	searchb.setEnabled(false);
	searchx.setEnabled(false);
	searchf.setEnabled(false);
	}//************************


	}//**********************








	public void active_hidden(){

	if(carbon_sell[item_listing_id_xx][what_item].equals("HIDDEN")){

	carbon_sell[item_listing_id_xx][what_item] = "ACTIVE";
	display_item();

	}//*************************************************************
	else{

	carbon_sell[item_listing_id_xx][what_item] = "HIDDEN";
	display_item();

	}//**

	}//*************************




	public void listing_type(){



	}//*************************






	public void store_name(){

    	String response = JOptionPane.showInputDialog(null, "Enter new store name", "Edit Store Name", JOptionPane.QUESTION_MESSAGE);

	if(response.length() > 0){carbon_settings[7] = response;}

	display_item();

	}//**********************




	public void store_password(){

    	String response = JOptionPane.showInputDialog(null, "Enter new store password", "Edit Store Password", JOptionPane.QUESTION_MESSAGE);

	if(response.length() > 0){carbon_settings[8] = response;}

	display_item();

	}//**********************




	public void db_password(){

    	String response = JOptionPane.showInputDialog(null, "Enter new database password", "Edit Database Password", JOptionPane.QUESTION_MESSAGE);

	if(response.length() > 0){carbon_settings[25] = response;}

	display_item();

	}//**********************







	public void get_inventory(){

	getting_items = 0;//turn other worker off

	httpx = urlc1.getText();
	passx = urlp1.getText();
	search_text = searchx.getText();
	search_field = new String(carbon_settings[4]);

	System.out.println(httpx);
	System.out.println(search_text);
	System.out.println(search_field);

	net_client_inventory nci = new net_client_inventory(); 
	set_1000_page();
	displayx();
	display_item();

	getting_items = 1;

	toolkit = Toolkit.getDefaultToolkit();
	xtimerx = new Timer();
	xtimerx.schedule(new RemindTask_get_items(), 0);


	}//*************************







	public void buy_item(){

if(what_item != 0){

	second_password = "";

	httpx = urlc1.getText();
	passx = urlp1.getText();
	search_text = searchx.getText();
	search_field = new String(carbon_settings[4]);
	quantityx = 0;
	item_idx_buy = carbon_buy[item_id_xx][what_item];
	pay_for_item = 0;

	try{

	Double lwalletx = Double.parseDouble(wallet_value_s);
	Double litemx = Double.parseDouble(carbon_buy[item_price_xx][what_item]);

	System.out.println(lwalletx);
	System.out.println(litemx);


	if(litemx > lwalletx){JOptionPane.showMessageDialog(null, "You do not have enough money for this item!");}
	else{

		int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this item?");
 		if(response == 0){

		    	String response2 = JOptionPane.showInputDialog(null, "Enter the Quantity", "Quantity", JOptionPane.QUESTION_MESSAGE);

			if(response2.length() > 0 && Integer.parseInt(response2) <= Integer.parseInt(lm.carbon_buy[item_total_on_hand_xx][what_item])){

				quantityx = Integer.parseInt(response2); 

					if(wallet_system == 0){

						    String response3 = new String("");
						    if(second_passworld_select == 1){response3 = JOptionPane.showInputDialog(null, "Enter Second Password", "Second Password", JOptionPane.QUESTION_MESSAGE);}

						if(response3.length() > 1 || second_passworld_select == 0){second_password = response3; blockchain_api_buy ncb = new blockchain_api_buy();}
						else{JOptionPane.showMessageDialog(null, "Invalid!");}

					}//********************
					else if(wallet_system == 1){rpc_client_buy ncb = new rpc_client_buy();}//*****

			}//****************************************************************************************************************************
			else{JOptionPane.showMessageDialog(null, "Invalid quantity!");}

		}//***************

	}//else

	}catch(Exception e){e.printStackTrace(); JOptionPane.showMessageDialog(null, "Error buying the item");}

}//if

	}//********************








	public void build_items_for_sale(){

	items_for_sale = 0;
	items_for_sale_total = 0;


		for(int xloop = 1; xloop < carbon_sell[0].length; xloop++){//*******************

		if(!carbon_sell[item_listing_id_xx][xloop].equals("HIDDEN")){items_for_sale++;}

		items_for_sale_total++;

		}//*****************************************************************************

	}//********************************







	public void edit_itemx_window(){

	if(what_item != 0){
	if(total_items_selected != 1){JOptionPane.showMessageDialog(null, "You can only edit 1 item at a time!");}
	else{

	edit_id_test.setText("EDITX"); 
	edit_item ei = new edit_item();

	}//**
	}//if**************

	}//*****************************







//buttons**************************************************************************************************
//buttons**************************************************************************************************



	public void export_items_csv(){

	System.out.println("Export Items");


	try {
        BufferedWriter out = new BufferedWriter(new FileWriter("LM_Items.csv"));

	for (int loop1 = 0; loop1 < carbon_sell[0].length; loop1++){//*************************
	for (int loop2 = 0; loop2 < carbon_sell.length; loop2++){//*************************

	try{out.write(carbon_sell[loop2][loop1]);}catch(Exception e){out.write("null");}
	out.write(",");

	}//for*******************************************************************************
	out.newLine();
	}//for*********************************************************************************
	
        out.close();
        } catch (IOException e) {System.out.println("print fail.");}



	JOptionPane.showMessageDialog(null, "Exported. Comma was changed to $:$ and quote was changed to $|$");


	}//*****************************









	public void export_orders_csv(){

	System.out.println("Export Orders");


	try {
        BufferedWriter out = new BufferedWriter(new FileWriter("LM_Orders.csv"));

	for (int loop1 = 0; loop1 < carbon_sold[0].length; loop1++){//*************************
	for (int loop2 = 0; loop2 < carbon_sold.length; loop2++){//*************************

	try{out.write(carbon_sold[loop2][loop1]);}catch(Exception e){out.write("null");}
	out.write(",");

	}//for*******************************************************************************
	out.newLine();
	}//for*********************************************************************************
	
        out.close();
        } catch (IOException e) {System.out.println("print fail.");}



	JOptionPane.showMessageDialog(null, "Exported. Comma was changed to $:$ and quote was changed to $|$");


	}//*****************************









	public void export_purchases_csv(){

	System.out.println("Export purchases");


	try {
        BufferedWriter out = new BufferedWriter(new FileWriter("LM_Purchases.csv"));

	for (int loop1 = 0; loop1 < carbon_purchase[0].length; loop1++){//*************************
	for (int loop2 = 0; loop2 < carbon_purchase.length; loop2++){//*************************

	try{out.write(carbon_purchase[loop2][loop1]);}catch(Exception e){out.write("null");}
	out.write(",");

	}//for*******************************************************************************
	out.newLine();
	}//for*********************************************************************************
	
        out.close();
        } catch (IOException e) {System.out.println("print fail.");}



	JOptionPane.showMessageDialog(null, "Exported. Comma was changed to $:$ and quote was changed to $|$");


	}//*****************************







	public void get_new_payment_address(){

	new_wallet_address = "";

	System.out.println("GET NEW ADDRESS");
	
	if(what_item > 0 && total_items_selected == 1){

		if(wallet_system == 0){blockchain_api_get_address iapia = new blockchain_api_get_address();} 
		else if(wallet_system == 1){rpc_client_new_address rpca = new rpc_client_new_address();}

		System.out.println(new_wallet_address);
		System.out.println(new_wallet_address.length());

			if(new_wallet_address.length() > 10 && new_wallet_address.length() < 200){carbon_sell[seller_id_xx][what_item] = new_wallet_address;}
			else{System.out.println("SET ADDRESS ERROR");}

		edit_id_test.setText("EDITX"); 
		display_item();

	}//********************************************
	else{JOptionPane.showMessageDialog(null, "Select 1 item to make a new payment address for");}

	}//***********************************







	public void get_new_payment_address2(){

	if(second_password.length() == 0 && second_passworld_select == 1){

		String response2 = JOptionPane.showInputDialog(null, "Enter second password to get new payment addresses", "New Address", JOptionPane.QUESTION_MESSAGE);
		second_password = response2;

	}//***************************************************************



	new_wallet_address = "";

	System.out.println("GET NEW ADDRESS");
	
	if(new_address_item > 0){

		if(wallet_system == 0){blockchain_api_get_address iapia = new blockchain_api_get_address();} 
		else if(wallet_system == 1){rpc_client_new_address rpca = new rpc_client_new_address();}

		System.out.println(new_wallet_address);
		System.out.println(new_wallet_address.length());

			if(new_wallet_address.length() > 26 && new_wallet_address.length() < 36){carbon_sell[seller_id_xx][new_address_item] = new_wallet_address;}
			else{System.out.println("SET ADDRESS ERROR");}

		edit_id_test.setText("EDITX"); 
		display_item();

	}//********************************************
	else{System.out.println("Cannot get new payment address.");}

	}//***********************************










	public void refresh_xx(){

	System.out.println("REFRESH");

	if(db_section == 0){}
	else if(db_section == 1){}
	else if(db_section == 2){get_sales_status();}
	else if(db_section == 3){}
	else{System.out.println("DB SECTION ERROR REFRESH");}


	}//**********************









	public void deletexx(){//*****************************************************************************************************************

	System.out.println("Delete item(s)");


	  if(db_section == 0 && what_item != 0){

	  int list_total = carbon_sell[0].length;
	  int list_after = carbon_sell[0].length - total_items_selected;

	  System.out.println("list_total " + list_total);
	  System.out.println("total_items_selected " + total_items_selected);
	  System.out.println("list_after " + list_after);

	  String[][] carbon_sell_hold = new String[carbon_sell.length][list_after];

	  int new_row = 0;


	  for(int xloopx1 = 0; xloopx1 < carbon_sell[0].length; xloopx1++){//******
	  for(int xloopx2 = 0; xloopx2 < carbon_sell.length; xloopx2++){//****************


	    if(selected_int[xloopx1] != 1 || xloopx1 == 0){

		carbon_sell_hold[xloopx2][new_row] = 
						     carbon_sell[xloopx2][xloopx1]; 
		
	    }//********************************************


	  }//******************************************************************************

	       if(selected_int[xloopx1] != 1 || xloopx1 == 0){new_row++; System.out.println(carbon_sell[0][xloopx1]);}

	  }//**********************************************************************

		carbon_sell = carbon_sell_hold;
		sell_button_click();

	  }//****************section0










	  if(db_section == 2){

	  int list_total = carbon_sold[0].length;
	  int list_after = carbon_sold[0].length - total_items_selected;

	  System.out.println("list_total " + list_total);
	  System.out.println("total_items_selected " + total_items_selected);
	  System.out.println("list_after " + list_after);

	  String[][] carbon_sold_hold = new String[carbon_sold.length][list_after];



	if(list_after == 0){carbon_sold = carbon_sold_hold;}
	else{//*************************************



	  int new_row = 0;


	  for(int xloopx1 = 0; xloopx1 < carbon_sold[0].length; xloopx1++){//******
	  for(int xloopx2 = 0; xloopx2 < carbon_sold.length; xloopx2++){//****************


	    if(selected_int[xloopx1] != 1 || xloopx1 == 0){

		carbon_sold_hold[xloopx2][new_row] = 
						     carbon_sold[xloopx2][xloopx1]; 
		
	    }//********************************************


	  }//******************************************************************************

	       if(selected_int[xloopx1] != 1){new_row++; System.out.println(carbon_sold[0][xloopx1]);}

	  }//**********************************************************************

		carbon_sold = carbon_sold_hold;

	}//else****************************************

		order_button_click();

	  }//****************section0










	  if(db_section == 3){

	  int list_total = carbon_purchase[0].length;
	  int list_after = carbon_purchase[0].length - total_items_selected;

	  System.out.println("list_total " + list_total);
	  System.out.println("total_items_selected " + total_items_selected);
	  System.out.println("list_after " + list_after);

	  String[][] carbon_purchase_hold = new String[carbon_purchase.length][list_after];

	  int new_row = 0;


	  for(int xloopx1 = 0; xloopx1 < carbon_purchase[0].length; xloopx1++){//******
	  for(int xloopx2 = 0; xloopx2 < carbon_purchase.length; xloopx2++){//****************


	    if(selected_int[xloopx1] != 1){//*************

		carbon_purchase_hold[xloopx2][new_row] = 
						         carbon_purchase[xloopx2][xloopx1]; 
		
	    }//********************************************


	  }//*********************************************************************************

	       if(selected_int[xloopx1] != 1){new_row++; System.out.println(carbon_purchase[0][xloopx1]);}

	  }//***************************************************************************

		carbon_purchase = carbon_purchase_hold;
		purchase_button_click();

	  }//****************section0


	}//********************deletex************************************************************************************************************











	public void view_edit_ss(){

	if(db_section == 0){edit_itemx_window();}
	else if(db_section == 1){}	
	else if(db_section == 2){view_sale vsx = new view_sale();}
	else if(db_section == 3){}
	else{System.out.println("Error 329283");}

	}//************************




	public void donate_btc(){

	System.out.println("Donate BTC");

	if(CURRENCY.equals("BTC")){

		String response2 = JOptionPane.showInputDialog(null, "Enter " + CURRENCY + " Amount. Example 0.12300000", "Address", JOptionPane.QUESTION_MESSAGE);
		if(response2.length() > 0){


			if(wallet_system == 0){

				   String response3 = new String("");
			   	   if(second_passworld_select == 1){response3 = JOptionPane.showInputDialog(null, "Enter Second Password", "Second Password", JOptionPane.QUESTION_MESSAGE);}

				if(response3.length() > 0 || second_passworld_select == 0){

				  lm.send_payment_address = "18WcknETBsjEB5JfdXipyExrjKkjP8N6XG";
				  lm.send_payment_amount = response2;
				  lm.second_password = response3;

				blockchain_api_send bapis = new blockchain_api_send();

				}//************************

			}//********************
			else{JOptionPane.showMessageDialog(null, "Cannot send with RPC client.");}

		}//************************


	}//*************************


	}//**********************





	public void send_btc(){

	System.out.println("Send " + CURRENCY);

	String response1 = JOptionPane.showInputDialog(null, "Enter " + CURRENCY + " Address", "Address", JOptionPane.QUESTION_MESSAGE);
	if(response1.length() > 20){

		String response2 = JOptionPane.showInputDialog(null, "Enter " + CURRENCY + " Amount. Example 0.12300000", "Address", JOptionPane.QUESTION_MESSAGE);
		if(response2.length() > 0){


			if(wallet_system == 0){

				   String response3 = new String("");
			   	   if(second_passworld_select == 1){response3 = JOptionPane.showInputDialog(null, "Enter Second Password", "Second Password", JOptionPane.QUESTION_MESSAGE);}

				if(response3.length() > 0 || second_passworld_select == 0){

				  lm.send_payment_address = response1;
				  lm.send_payment_amount = response2;
				  lm.second_password = response3;

				blockchain_api_send bapis = new blockchain_api_send();

				}//************************

			}//********************
			else{JOptionPane.showMessageDialog(null, "Cannot send with RPC client.");}

		}//************************

	}//*************************



	}//**********************












	public void ship_item_confirm(){

	String response2 = JOptionPane.showInputDialog(null, "Enter the tracking number", "Tracking", JOptionPane.QUESTION_MESSAGE);

		if(response2.length() > 1 && total_items_selected == 1){

		carbon_sold[sale_tracking_number_xx][what_item] = response2;
		carbon_sold[sale_status_xx][what_item] = "Shipped";


		//send email

		}//*****************************************************
		else{JOptionPane.showMessageDialog(null, "Error");}

	}//*****************************








//***************************************************************************************************************************
//***************************************************************************************************************************


//handel all the button clicks. 
public void actionPerformed(ActionEvent event){







	if(event.getSource() == info_account)             {wallet_system = 0;}
	if(event.getSource() == btqt_account)             {wallet_system = 1;}

	if(event.getSource() == url_connect)              {connectedx();}
	if(event.getSource() == searchb)                  {get_inventory();}

	if(event.getSource() == sell_button)              {sell_button_click();}
	if(event.getSource() == buy_button)               {buy_button_click();}

	if(event.getSource() == xactive)                  {active_hidden();}
	if(event.getSource() == xtype)                    {listing_type();}

	if(event.getSource() == coins)                    {get_btc_wallet();}
	if(event.getSource() == inventory)                {order_button_click();}
	if(event.getSource() == purchased)                {purchase_button_click();}



	if(event.getSource() == sort_1)                   {make_item();}
	if(event.getSource() == sort_2)                   {view_edit_ss();}
	if(event.getSource() == sort_3)                   {select_all_items1();}
	if(event.getSource() == sort_4)                   {deletexx();}
	if(event.getSource() == sort_5)                   {refresh_xx();}
	if(event.getSource() == sort_6)                   {ship_item_confirm();}
	if(event.getSource() == sort_7)                   {replace rx = new replace();}
	if(event.getSource() == sort_8)                   {server_ox();}

	if(event.getSource() == buy_1)                    {buy_item();}




	if(event.getSource() == file_export_items)        {export_items_csv();}
	if(event.getSource() == file_export_orders)       {export_orders_csv();}
	if(event.getSource() == file_export_purchases)    {export_purchases_csv();}
	if(event.getSource() == file_exit)                {System.exit(0);}

	if(event.getSource() == edit_new)                 {make_item();}
	if(event.getSource() == edit_new10)               {}
	if(event.getSource() == edit_edit)                {view_edit_ss();}
	if(event.getSource() == edit_replace)             {replace rx = new replace();}
	if(event.getSource() == edit_delete)              {deletexx();}

	if(event.getSource() == tools_editname)           {store_name();}
	if(event.getSource() == tools_editpass)           {store_password();}
	if(event.getSource() == tools_editdbpass)         {db_password();}
	if(event.getSource() == two_factor_y)             {second_passworld_select = 1;}
	if(event.getSource() == two_factor_n)             {second_passworld_select = 0;}
	if(event.getSource() == tools_send)               {send_btc();}
	if(event.getSource() == tools_donate)             {donate_btc();}

	if(event.getSource() == database_info)            {JOptionPane.showMessageDialog(null, "Local JDB Database: Apache Derby - 10.5.3.0 - (802917)");}

	if(event.getSource() == account_settings)         {btcinfo_settings info = new btcinfo_settings();}

	if(event.getSource() == node_settings)            {JOptionPane.showMessageDialog(null, "Node network offline");}

	




	if(event.getSource() == searchf){

           //searchf = (JComboBox) event.getSource();

           Object newItem = searchf.getSelectedItem();

	for (int loop1 = 0; loop1 < searchf.getItemCount(); loop1++){//s1x

	if(database[loop1].equals(newItem)){carbon_settings[4] = Integer.toString(loop1); System.out.println(carbon_settings[4]);}

	}//***************************************************************
	}//*******************************









}//actionPerformed	
//***************************************************************************************************************************

        public void stateChanged(ChangeEvent e){
        JSlider source = (JSlider)e.getSource();

        if(!source.getValueIsAdjusting()){

	System.out.println("SET PAGE 1000 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX SLIDER");
	set_1000_page();

	int ppsx = framesPerPage1.getValue();

	System.out.println("ppsx " + ppsx);
	System.out.println("pps_old " + pps_old);

	   if(ppsx != pps_old){
		if(db_section == 0){sell_button_click();}
		else if(db_section == 1){buy_button_click();}
		else if(db_section == 2){order_button_click();}
		else if(db_section == 3){purchase_button_click();}
	   }//*****************


	pps_old = ppsx;

	}//if******************************


        }//*************************************    




	public void set_1000_page(){

	if(db_section == 0){dbx_total = carbon_sell[0].length;}
	else if(db_section == 1){dbx_total = carbon_buy[0].length;}
	else if(db_section == 2){dbx_total = carbon_sold[0].length;}
	else if(db_section == 3){dbx_total = carbon_purchase[0].length;}


	int ppp = (dbx_total / 1000);
	int pps = framesPerPage1.getValue();

	System.out.println("framesPerPage " + ppp);
	System.out.println("framesPerPage selected " + pps);
	framesPerPage1.setMaximum(ppp);
	
	if(dbx_total < 1000){framesPerPage1.setMaximum(0); dbx_start = 0; dbx_end = dbx_total;}
	else{


	      if(pps < ppp){dbx_start = (pps * 1000); dbx_end = (pps * 1000) + 999;}
	else if(pps == ppp){dbx_start = (pps * 1000); dbx_end = dbx_total;}


	}//**


	dbx_end_start = dbx_end - dbx_start;
	System.out.println("dbx_total set 1000 page " + dbx_start + " " + dbx_end + " " + dbx_end_start);

	}//*************************













      public void keyTyped(KeyEvent e){}//typed*************************

      public void keyReleased(KeyEvent e){

      if(e.getKeyCode() == KeyEvent.VK_SHIFT){pressx = 0;}
      if(e.getKeyCode() == KeyEvent.VK_CONTROL){pressy = 0;}

      }//*********************************

      public void keyPressed(KeyEvent e){
      //System.out.println("key pressed " + e.getKeyCode());

	if(e.getKeyCode() == KeyEvent.VK_SHIFT){pressx = 1; pressx_repaint = 1;}
	if(e.getKeyCode() == KeyEvent.VK_CONTROL){pressy = 1; pressx_repaint = 1;}

	if(e.getKeyCode() == KeyEvent.VK_A && pressy == 1){select_all_items1(); pressx_repaint = 1;}

      }//pressed*************************









      public void mousePressed(MouseEvent ev) {
        if (ev.isPopupTrigger()) {menu.show(ev.getComponent(), ev.getX(), ev.getY());}
      }//**************************************

      public void mouseReleased(MouseEvent ev) {
        //if (ev.isPopupTrigger()) {menu.show(ev.getComponent(), ev.getX(), ev.getY());}
      }//***************************************

      public void mouseClicked(MouseEvent ev) {}

      public void mouseEntered(MouseEvent e){}

      public void mouseExited(MouseEvent e){}

      public void mouseDragged(MouseEvent e){}

      public void mouseMoved(MouseEvent e){}








	public void load_class_files(){




	}//****************************








//***************************************************************************************************************************



//start the program.
    public static void main(String[] args) {

	lm market = new lm();

    }//main



}//last**************************************************************************************************************************************


