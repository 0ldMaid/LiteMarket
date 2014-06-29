import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;




public class jdb_load extends JFrame{

    /* the default framework is embedded*/
    private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";



Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 380;
int xzy = 380;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

static int error_code = 0;
int bytesRead = 0;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infox0 = new JLabel("", Label.RIGHT);
JLabel infox1 = new JLabel("", JLabel.CENTER);
Label infox2 = new Label("Loading...", Label.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int amazon_items = 0;//number of new items to submit. 
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int stop = 0;
int post_number = 1;
int what_item_here = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
static String cx2 = new String("");


File st1;


String[][] carbonfiber;
String submit_x = new String("");
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;



static String ddx;



String CONFIG_XML_NAME = "amazon_template.xml";
String SUBMIT_XML_NAME = "amazon_template.xml";
String SUBMIT_FEEDTYPE = "";
int SUBMIT_NUMBER = 0;

String spacer_0 = new String("  ");






    jdb_load(){//**************************************************************************






	super("Load Database Listings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	setDefaultLookAndFeelDecorated(false);
	setUndecorated(true);

//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	setIconImage(ximagex);


	ImageIcon imx0 = new ImageIcon(this.getClass().getResource("images/info_32e.png"));
	Icon aicon = new ImageIcon(ximagex);



infox0.setPreferredSize(new Dimension(320, 50));
infox0.setBackground(black);
infox0.setForeground(whitex);
//infox0.setOpaque(false);
//infox0.setIcon(ximagex);
infox0.setText("Version 1.1.1");
//infox0.setHorizontalTextPosition(Label.LEFT);
//infox0.setIconTextGap(30);

infox1.setPreferredSize(new Dimension(360, 360));
infox1.setText("");
infox1.setIcon(imx0);

infox2.setPreferredSize(new Dimension(360, 20));
infox2.setText(spacer_0 + "Start Database System");
infox2.setForeground(blackx);

FlowLayout fl1 = new FlowLayout();
fl1.setHgap(0);
fl1.setVgap(0);







	Container cpx = getContentPane();
	cpx.setLayout(fl1);
	//cpx.setBackground(nm.program_gray_3);
	cpx.setForeground(whitex);
	cpx.setBackground(whitex);
	cpx.add(infox1);
	cpx.add(infox2);

	error_code = 0;

	setVisible(true);












        System.out.println("JDB loader starting in " + framework + " mode");

        /* load the desired JDBC driver */
        loadDriver();

        /* We will be using Statement and PreparedStatement objects for
         * executing SQL. These objects, as well as Connections and ResultSets,
         * are resources that should be released explicitly after use, hence
         * the try-catch-finally pattern used below.
         * We are storing the Statement and Prepared statement object references
         * in an array list for convenience.
         */
        Connection conn = null;


	/* This ArrayList usage may cause a warning when compiling this class
	 * with a compiler for J2SE 5.0 or newer. We are not using generics
	 * because we want the source to support J2SE 1.4.2 environments. 
	*/


        ArrayList statements = new ArrayList(); // list of Statements, PreparedStatements
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        Statement s = null;
        ResultSet rs = null;

        try{

            Properties props = new Properties(); // connection properties
            // providing a user name and password is optional in the embedded
            // and derbyclient frameworks
            props.put("user", "");
            props.put("password", "");

            /* By default, the schema APP will be used when no username is
             * provided.
             * Otherwise, the schema name is the same as the user name (in this
             * case "user1" or USER1.)
             *
             * Note that user authentication is off by default, meaning that any
             * user can connect to your database using any password. To enable
             * authentication, see the Derby Developer's Guide.
             */

            String dbName = "LM_SETTINGS"; // the name of the database

            /*
             * This connection specifies create=true in the connection URL to
             * cause the database to be created when connecting for the first
             * time. To remove the database, remove the directory derbyDB (the
             * same as the database name) and its contents.
             *
             * The directory derbyDB will be created under the directory that
             * the system property derby.system.home points to, or the current
             * directory (user.dir) if derby.system.home is not set.
             */



            conn = DriverManager.getConnection(protocol + dbName + ";create=false", props);

            System.out.println("Connected to database " + dbName);

            // We want to control transactions manually. Autocommit is on by
            // default in JDBC.
            conn.setAutoCommit(false);

            /* Creating a statement object that we can use for running various
             * SQL statements commands against the database.*/
            s = conn.createStatement();
            statements.add(s);




	    String ssp[];
	    String ssp2[];







	    infox2.setText(spacer_0 + "Build String List: ");

	    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	    ResultSet resultSet = stmt.executeQuery("SELECT * FROM settings");

	    resultSet.last();
	    int rowCount = resultSet.getRow();

	    infox2.setText(spacer_0 + "Build String List: " + Integer.toString(rowCount));


	    ix0 = rowCount;
            //System.out.println(ix0);


//34594

	    ssp = new String[100];
	    lm.carbon_settings = ssp;

            rs = s.executeQuery("SELECT value, align FROM settings ORDER BY align");





	    ix0 = 0;
	    while(rs.next()){

	    infox2.setText(spacer_0 + "Load Items: (" + Integer.toString((ix0 + 1)) + " of " + Integer.toString(rowCount) + ") ");

	    //System.out.println(rs.getString(1));

	    lm.carbon_settings[ix0] = new String(rs.getString(1));

	    ix0++;

	    }//while















	    System.out.println(spacer_0 + "Build Sell List: ");
	    infox2.setText(spacer_0 + "Build Sell list: ");

	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	    resultSet = stmt.executeQuery("SELECT * FROM sell_db");

	    resultSet.last();
	    rowCount = resultSet.getRow();

	    infox2.setText(spacer_0 + "Build String List: " + Integer.toString(rowCount));


	    ix0 = rowCount;
            //System.out.println(ix0);


	    lm.carbon_sell = new String[82][ix0];

            rs = s.executeQuery("SELECT * FROM sell_db ");





	    ix0 = 0;
	    while(rs.next()){

	    infox2.setText(spacer_0 + "Load Items: (" + Integer.toString((ix0 + 1)) + " of " + Integer.toString(rowCount) + ") ");

	    //System.out.println(rs.getString(1));
	    //System.out.println(rs.getString(82));

	    lm.carbon_sell[0][ix0] = new String(rs.getString(1));
	    lm.carbon_sell[1][ix0] = new String(rs.getString(2));
	    lm.carbon_sell[2][ix0] = new String(rs.getString(3));
	    lm.carbon_sell[3][ix0] = new String(rs.getString(4));
	    lm.carbon_sell[4][ix0] = new String(rs.getString(5));
	    lm.carbon_sell[5][ix0] = new String(rs.getString(6));
	    lm.carbon_sell[6][ix0] = new String(rs.getString(7));
	    lm.carbon_sell[7][ix0] = new String(rs.getString(8));
	    lm.carbon_sell[8][ix0] = new String(rs.getString(9));
	    lm.carbon_sell[9][ix0] = new String(rs.getString(10));
	    lm.carbon_sell[10][ix0] = new String(rs.getString(11));
	    lm.carbon_sell[11][ix0] = new String(rs.getString(12));
	    lm.carbon_sell[12][ix0] = new String(rs.getString(13));
	    lm.carbon_sell[13][ix0] = new String(rs.getString(14));
	    lm.carbon_sell[14][ix0] = new String(rs.getString(15));
	    lm.carbon_sell[15][ix0] = new String(rs.getString(16));
	    lm.carbon_sell[16][ix0] = new String(rs.getString(17));
	    lm.carbon_sell[17][ix0] = new String(rs.getString(18));
	    lm.carbon_sell[18][ix0] = new String(rs.getString(19));
	    lm.carbon_sell[19][ix0] = new String(rs.getString(20));
	    lm.carbon_sell[20][ix0] = new String(rs.getString(21));
	    lm.carbon_sell[21][ix0] = new String(rs.getString(22));
	    lm.carbon_sell[22][ix0] = new String(rs.getString(23));
	    lm.carbon_sell[23][ix0] = new String(rs.getString(24));
	    lm.carbon_sell[24][ix0] = new String(rs.getString(25));
	    lm.carbon_sell[25][ix0] = new String(rs.getString(26));
	    lm.carbon_sell[26][ix0] = new String(rs.getString(27));
	    lm.carbon_sell[27][ix0] = new String(rs.getString(28));
	    lm.carbon_sell[28][ix0] = new String(rs.getString(29));
	    lm.carbon_sell[29][ix0] = new String(rs.getString(30));
	    lm.carbon_sell[30][ix0] = new String(rs.getString(31));
	    lm.carbon_sell[31][ix0] = new String(rs.getString(32));
	    lm.carbon_sell[32][ix0] = new String(rs.getString(33));
	    lm.carbon_sell[33][ix0] = new String(rs.getString(34));
	    lm.carbon_sell[34][ix0] = new String(rs.getString(35));
	    lm.carbon_sell[35][ix0] = new String(rs.getString(36));
	    lm.carbon_sell[36][ix0] = new String(rs.getString(37));
	    lm.carbon_sell[37][ix0] = new String(rs.getString(38));
	    lm.carbon_sell[38][ix0] = new String(rs.getString(39));
	    lm.carbon_sell[39][ix0] = new String(rs.getString(40));
	    lm.carbon_sell[40][ix0] = new String(rs.getString(41));
	    lm.carbon_sell[41][ix0] = new String(rs.getString(42));
	    lm.carbon_sell[42][ix0] = new String(rs.getString(43));
	    lm.carbon_sell[43][ix0] = new String(rs.getString(44));
	    lm.carbon_sell[44][ix0] = new String(rs.getString(45));
	    lm.carbon_sell[45][ix0] = new String(rs.getString(46));
	    lm.carbon_sell[46][ix0] = new String(rs.getString(47));
	    lm.carbon_sell[47][ix0] = new String(rs.getString(48));
	    lm.carbon_sell[48][ix0] = new String(rs.getString(49));
	    lm.carbon_sell[49][ix0] = new String(rs.getString(50));
	    lm.carbon_sell[50][ix0] = new String(rs.getString(51));
	    lm.carbon_sell[51][ix0] = new String(rs.getString(52));
	    lm.carbon_sell[52][ix0] = new String(rs.getString(53));
	    lm.carbon_sell[53][ix0] = new String(rs.getString(54));
	    lm.carbon_sell[54][ix0] = new String(rs.getString(55));
	    lm.carbon_sell[55][ix0] = new String(rs.getString(56));
	    lm.carbon_sell[56][ix0] = new String(rs.getString(57));
	    lm.carbon_sell[57][ix0] = new String(rs.getString(58));
	    lm.carbon_sell[58][ix0] = new String(rs.getString(59));
	    lm.carbon_sell[59][ix0] = new String(rs.getString(60));
	    lm.carbon_sell[60][ix0] = new String(rs.getString(61));
	    lm.carbon_sell[61][ix0] = new String(rs.getString(62));
	    lm.carbon_sell[62][ix0] = new String(rs.getString(63));
	    lm.carbon_sell[63][ix0] = new String(rs.getString(64));
	    lm.carbon_sell[64][ix0] = new String(rs.getString(65));
	    lm.carbon_sell[65][ix0] = new String(rs.getString(66));
	    lm.carbon_sell[66][ix0] = new String(rs.getString(67));
	    lm.carbon_sell[67][ix0] = new String(rs.getString(68));
	    lm.carbon_sell[68][ix0] = new String(rs.getString(69));
	    lm.carbon_sell[69][ix0] = new String(rs.getString(70));
	    lm.carbon_sell[70][ix0] = new String(rs.getString(71));
	    lm.carbon_sell[71][ix0] = new String(rs.getString(72));
	    lm.carbon_sell[72][ix0] = new String(rs.getString(73));
	    lm.carbon_sell[73][ix0] = new String(rs.getString(74));
	    lm.carbon_sell[74][ix0] = new String(rs.getString(75));
	    lm.carbon_sell[75][ix0] = new String(rs.getString(76));
	    lm.carbon_sell[76][ix0] = new String(rs.getString(77));
	    lm.carbon_sell[77][ix0] = new String(rs.getString(78));
	    lm.carbon_sell[78][ix0] = new String(rs.getString(79));
	    lm.carbon_sell[79][ix0] = new String(rs.getString(80));
	    lm.carbon_sell[80][ix0] = new String(rs.getString(81));
	    lm.carbon_sell[81][ix0] = new String(rs.getString(82));

	    ix0++;

	    }//while











	    System.out.println(spacer_0 + "Build Sold List: ");
	    infox2.setText(spacer_0 + "Build Sold List: ");

	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	    resultSet = stmt.executeQuery("SELECT * FROM sold_db");

	    resultSet.last();
	    rowCount = resultSet.getRow();

	    infox2.setText(spacer_0 + "Build String List: " + Integer.toString(rowCount));


	    ix0 = rowCount;
            //System.out.println(ix0);


	    lm.carbon_sold = new String[82][ix0];

            rs = s.executeQuery("SELECT * FROM sold_db");





	    ix0 = 0;
	    while(rs.next()){

	    infox2.setText(spacer_0 + "Load Items: (" + Integer.toString((ix0 + 1)) + " of " + Integer.toString(rowCount) + ") ");

	    //System.out.println(rs.getString(1));

	    lm.carbon_sold[0][ix0] = new String(rs.getString(1));
	    lm.carbon_sold[1][ix0] = new String(rs.getString(2));
	    lm.carbon_sold[2][ix0] = new String(rs.getString(3));
	    lm.carbon_sold[3][ix0] = new String(rs.getString(4));
	    lm.carbon_sold[4][ix0] = new String(rs.getString(5));
	    lm.carbon_sold[5][ix0] = new String(rs.getString(6));
	    lm.carbon_sold[6][ix0] = new String(rs.getString(7));
	    lm.carbon_sold[7][ix0] = new String(rs.getString(8));
	    lm.carbon_sold[8][ix0] = new String(rs.getString(9));
	    lm.carbon_sold[9][ix0] = new String(rs.getString(10));
	    lm.carbon_sold[10][ix0] = new String(rs.getString(11));
	    lm.carbon_sold[11][ix0] = new String(rs.getString(12));
	    lm.carbon_sold[12][ix0] = new String(rs.getString(13));
	    lm.carbon_sold[13][ix0] = new String(rs.getString(14));
	    lm.carbon_sold[14][ix0] = new String(rs.getString(15));
	    lm.carbon_sold[15][ix0] = new String(rs.getString(16));
	    lm.carbon_sold[16][ix0] = new String(rs.getString(17));
	    lm.carbon_sold[17][ix0] = new String(rs.getString(18));
	    lm.carbon_sold[18][ix0] = new String(rs.getString(19));
	    lm.carbon_sold[19][ix0] = new String(rs.getString(20));
	    lm.carbon_sold[20][ix0] = new String(rs.getString(21));
	    lm.carbon_sold[21][ix0] = new String(rs.getString(22));
	    lm.carbon_sold[22][ix0] = new String(rs.getString(23));
	    lm.carbon_sold[23][ix0] = new String(rs.getString(24));
	    lm.carbon_sold[24][ix0] = new String(rs.getString(25));
	    lm.carbon_sold[25][ix0] = new String(rs.getString(26));
	    lm.carbon_sold[26][ix0] = new String(rs.getString(27));
	    lm.carbon_sold[27][ix0] = new String(rs.getString(28));
	    lm.carbon_sold[28][ix0] = new String(rs.getString(29));
	    lm.carbon_sold[29][ix0] = new String(rs.getString(30));
	    lm.carbon_sold[30][ix0] = new String(rs.getString(31));
	    lm.carbon_sold[31][ix0] = new String(rs.getString(32));
	    lm.carbon_sold[32][ix0] = new String(rs.getString(33));
	    lm.carbon_sold[33][ix0] = new String(rs.getString(34));
	    lm.carbon_sold[34][ix0] = new String(rs.getString(35));
	    lm.carbon_sold[35][ix0] = new String(rs.getString(36));
	    lm.carbon_sold[36][ix0] = new String(rs.getString(37));
	    lm.carbon_sold[37][ix0] = new String(rs.getString(38));
	    lm.carbon_sold[38][ix0] = new String(rs.getString(39));
	    lm.carbon_sold[39][ix0] = new String(rs.getString(40));
	    lm.carbon_sold[40][ix0] = new String(rs.getString(41));
	    lm.carbon_sold[41][ix0] = new String(rs.getString(42));
	    lm.carbon_sold[42][ix0] = new String(rs.getString(43));
	    lm.carbon_sold[43][ix0] = new String(rs.getString(44));
	    lm.carbon_sold[44][ix0] = new String(rs.getString(45));
	    lm.carbon_sold[45][ix0] = new String(rs.getString(46));
	    lm.carbon_sold[46][ix0] = new String(rs.getString(47));
	    lm.carbon_sold[47][ix0] = new String(rs.getString(48));
	    lm.carbon_sold[48][ix0] = new String(rs.getString(49));
	    lm.carbon_sold[49][ix0] = new String(rs.getString(50));
	    lm.carbon_sold[50][ix0] = new String(rs.getString(51));
	    lm.carbon_sold[51][ix0] = new String(rs.getString(52));
	    lm.carbon_sold[52][ix0] = new String(rs.getString(53));
	    lm.carbon_sold[53][ix0] = new String(rs.getString(54));
	    lm.carbon_sold[54][ix0] = new String(rs.getString(55));
	    lm.carbon_sold[55][ix0] = new String(rs.getString(56));
	    lm.carbon_sold[56][ix0] = new String(rs.getString(57));
	    lm.carbon_sold[57][ix0] = new String(rs.getString(58));
	    lm.carbon_sold[58][ix0] = new String(rs.getString(59));
	    lm.carbon_sold[59][ix0] = new String(rs.getString(60));
	    lm.carbon_sold[60][ix0] = new String(rs.getString(61));
	    lm.carbon_sold[61][ix0] = new String(rs.getString(62));
	    lm.carbon_sold[62][ix0] = new String(rs.getString(63));
	    lm.carbon_sold[63][ix0] = new String(rs.getString(64));
	    lm.carbon_sold[64][ix0] = new String(rs.getString(65));
	    lm.carbon_sold[65][ix0] = new String(rs.getString(66));
	    lm.carbon_sold[66][ix0] = new String(rs.getString(67));
	    lm.carbon_sold[67][ix0] = new String(rs.getString(68));
	    lm.carbon_sold[68][ix0] = new String(rs.getString(69));
	    lm.carbon_sold[69][ix0] = new String(rs.getString(70));
	    lm.carbon_sold[70][ix0] = new String(rs.getString(71));
	    lm.carbon_sold[71][ix0] = new String(rs.getString(72));
	    lm.carbon_sold[72][ix0] = new String(rs.getString(73));
	    lm.carbon_sold[73][ix0] = new String(rs.getString(74));
	    lm.carbon_sold[74][ix0] = new String(rs.getString(75));
	    lm.carbon_sold[75][ix0] = new String(rs.getString(76));
	    lm.carbon_sold[76][ix0] = new String(rs.getString(77));
	    lm.carbon_sold[77][ix0] = new String(rs.getString(78));
	    lm.carbon_sold[78][ix0] = new String(rs.getString(79));
	    lm.carbon_sold[79][ix0] = new String(rs.getString(80));
	    lm.carbon_sold[80][ix0] = new String(rs.getString(81));
	    lm.carbon_sold[81][ix0] = new String(rs.getString(82));

	    ix0++;

	    }//while



















	    System.out.println(spacer_0 + "Build Purchase List: ");
	    infox2.setText(spacer_0 + "Build Purchase List: ");

	    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	    resultSet = stmt.executeQuery("SELECT * FROM purchase_db");

	    resultSet.last();
	    rowCount = resultSet.getRow();

	    infox2.setText(spacer_0 + "Build String List: " + Integer.toString(rowCount));


	    ix0 = rowCount;
            //System.out.println(ix0);


	    lm.carbon_purchase = new String[82][ix0];

            rs = s.executeQuery("SELECT * FROM purchase_db");





	    ix0 = 0;
	    while(rs.next()){

	    infox2.setText(spacer_0 + "Load Items: (" + Integer.toString((ix0 + 1)) + " of " + Integer.toString(rowCount) + ") ");

	    //System.out.println(rs.getString(1));

	    lm.carbon_purchase[0][ix0] = new String(rs.getString(1));
	    lm.carbon_purchase[1][ix0] = new String(rs.getString(2));
	    lm.carbon_purchase[2][ix0] = new String(rs.getString(3));
	    lm.carbon_purchase[3][ix0] = new String(rs.getString(4));
	    lm.carbon_purchase[4][ix0] = new String(rs.getString(5));
	    lm.carbon_purchase[5][ix0] = new String(rs.getString(6));
	    lm.carbon_purchase[6][ix0] = new String(rs.getString(7));
	    lm.carbon_purchase[7][ix0] = new String(rs.getString(8));
	    lm.carbon_purchase[8][ix0] = new String(rs.getString(9));
	    lm.carbon_purchase[9][ix0] = new String(rs.getString(10));
	    lm.carbon_purchase[10][ix0] = new String(rs.getString(11));
	    lm.carbon_purchase[11][ix0] = new String(rs.getString(12));
	    lm.carbon_purchase[12][ix0] = new String(rs.getString(13));
	    lm.carbon_purchase[13][ix0] = new String(rs.getString(14));
	    lm.carbon_purchase[14][ix0] = new String(rs.getString(15));
	    lm.carbon_purchase[15][ix0] = new String(rs.getString(16));
	    lm.carbon_purchase[16][ix0] = new String(rs.getString(17));
	    lm.carbon_purchase[17][ix0] = new String(rs.getString(18));
	    lm.carbon_purchase[18][ix0] = new String(rs.getString(19));
	    lm.carbon_purchase[19][ix0] = new String(rs.getString(20));
	    lm.carbon_purchase[20][ix0] = new String(rs.getString(21));
	    lm.carbon_purchase[21][ix0] = new String(rs.getString(22));
	    lm.carbon_purchase[22][ix0] = new String(rs.getString(23));
	    lm.carbon_purchase[23][ix0] = new String(rs.getString(24));
	    lm.carbon_purchase[24][ix0] = new String(rs.getString(25));
	    lm.carbon_purchase[25][ix0] = new String(rs.getString(26));
	    lm.carbon_purchase[26][ix0] = new String(rs.getString(27));
	    lm.carbon_purchase[27][ix0] = new String(rs.getString(28));
	    lm.carbon_purchase[28][ix0] = new String(rs.getString(29));
	    lm.carbon_purchase[29][ix0] = new String(rs.getString(30));
	    lm.carbon_purchase[30][ix0] = new String(rs.getString(31));
	    lm.carbon_purchase[31][ix0] = new String(rs.getString(32));
	    lm.carbon_purchase[32][ix0] = new String(rs.getString(33));
	    lm.carbon_purchase[33][ix0] = new String(rs.getString(34));
	    lm.carbon_purchase[34][ix0] = new String(rs.getString(35));
	    lm.carbon_purchase[35][ix0] = new String(rs.getString(36));
	    lm.carbon_purchase[36][ix0] = new String(rs.getString(37));
	    lm.carbon_purchase[37][ix0] = new String(rs.getString(38));
	    lm.carbon_purchase[38][ix0] = new String(rs.getString(39));
	    lm.carbon_purchase[39][ix0] = new String(rs.getString(40));
	    lm.carbon_purchase[40][ix0] = new String(rs.getString(41));
	    lm.carbon_purchase[41][ix0] = new String(rs.getString(42));
	    lm.carbon_purchase[42][ix0] = new String(rs.getString(43));
	    lm.carbon_purchase[43][ix0] = new String(rs.getString(44));
	    lm.carbon_purchase[44][ix0] = new String(rs.getString(45));
	    lm.carbon_purchase[45][ix0] = new String(rs.getString(46));
	    lm.carbon_purchase[46][ix0] = new String(rs.getString(47));
	    lm.carbon_purchase[47][ix0] = new String(rs.getString(48));
	    lm.carbon_purchase[48][ix0] = new String(rs.getString(49));
	    lm.carbon_purchase[49][ix0] = new String(rs.getString(50));
	    lm.carbon_purchase[50][ix0] = new String(rs.getString(51));
	    lm.carbon_purchase[51][ix0] = new String(rs.getString(52));
	    lm.carbon_purchase[52][ix0] = new String(rs.getString(53));
	    lm.carbon_purchase[53][ix0] = new String(rs.getString(54));
	    lm.carbon_purchase[54][ix0] = new String(rs.getString(55));
	    lm.carbon_purchase[55][ix0] = new String(rs.getString(56));
	    lm.carbon_purchase[56][ix0] = new String(rs.getString(57));
	    lm.carbon_purchase[57][ix0] = new String(rs.getString(58));
	    lm.carbon_purchase[58][ix0] = new String(rs.getString(59));
	    lm.carbon_purchase[59][ix0] = new String(rs.getString(60));
	    lm.carbon_purchase[60][ix0] = new String(rs.getString(61));
	    lm.carbon_purchase[61][ix0] = new String(rs.getString(62));
	    lm.carbon_purchase[62][ix0] = new String(rs.getString(63));
	    lm.carbon_purchase[63][ix0] = new String(rs.getString(64));
	    lm.carbon_purchase[64][ix0] = new String(rs.getString(65));
	    lm.carbon_purchase[65][ix0] = new String(rs.getString(66));
	    lm.carbon_purchase[66][ix0] = new String(rs.getString(67));
	    lm.carbon_purchase[67][ix0] = new String(rs.getString(68));
	    lm.carbon_purchase[68][ix0] = new String(rs.getString(69));
	    lm.carbon_purchase[69][ix0] = new String(rs.getString(70));
	    lm.carbon_purchase[70][ix0] = new String(rs.getString(71));
	    lm.carbon_purchase[71][ix0] = new String(rs.getString(72));
	    lm.carbon_purchase[72][ix0] = new String(rs.getString(73));
	    lm.carbon_purchase[73][ix0] = new String(rs.getString(74));
	    lm.carbon_purchase[74][ix0] = new String(rs.getString(75));
	    lm.carbon_purchase[75][ix0] = new String(rs.getString(76));
	    lm.carbon_purchase[76][ix0] = new String(rs.getString(77));
	    lm.carbon_purchase[77][ix0] = new String(rs.getString(78));
	    lm.carbon_purchase[78][ix0] = new String(rs.getString(79));
	    lm.carbon_purchase[79][ix0] = new String(rs.getString(80));
	    lm.carbon_purchase[80][ix0] = new String(rs.getString(81));
	    lm.carbon_purchase[81][ix0] = new String(rs.getString(82));

	    ix0++;

	    }//while









            conn.commit();
            System.out.println("Committed the transaction");






            /*
             * In embedded mode, an application should shut down the database.
             * If the application fails to shut down the database,
             * Derby will not perform a checkpoint when the JVM shuts down.
             * This means that it will take longer to boot (connect to) the
             * database the next time, because Derby needs to perform a recovery
             * operation.
             *
             * It is also possible to shut down the Derby system/engine, which
             * automatically shuts down all booted databases.
             *
             * Explicitly shutting down the database or the Derby engine with
             * the connection URL is preferred. This style of shutdown will
             * always throw an SQLException.
             *
             * Not shutting down when in a client environment, see method
             * Javadoc.
             */

            if (framework.equals("embedded"))
            {
                try
                {
                    // the shutdown=true attribute shuts down Derby
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");

                    // To shut down a specific database only, but keep the
                    // engine running (for example for connecting to other
                    // databases), specify a database in the connection URL:
                    //DriverManager.getConnection("jdbc:derby:" + dbName + ";shutdown=true");
                }
                catch (SQLException se)
                {
                    if (( (se.getErrorCode() == 50000)
                            && ("XJ015".equals(se.getSQLState()) ))) {
                        // we got the expected exception
                        System.out.println("Derby shut down normally");
                        // Note that for single database shutdown, the expected
                        // SQL state is "08006", and the error code is 45000.
                    } else {
                        // if the error code or SQLState is different, we have
                        // an unexpected exception (shutdown failed)
                        System.err.println("Derby did not shut down normally");
                        printSQLException(se);
                    }
                }
            }
        }
        catch (SQLException sqle)
        {
            printSQLException(sqle);
        } finally {
            // release all open resources to avoid unnecessary memory usage

            // ResultSet
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }

            // Statements and PreparedStatements
            int i = 0;
            while (!statements.isEmpty()) {
                // PreparedStatement extend Statement
                Statement st = (Statement)statements.remove(i);
                try {
                    if (st != null) {
                        st.close();
                        st = null;
                    }
                } catch (SQLException sqle) {
                    printSQLException(sqle);
                }
            }

            //Connection
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }




pullThePlug();


}//load






    public void pullThePlug() {

    lm.firexdb = 1;

    System.out.println("PULL THE PLUG");

    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull







    private void loadDriver() {
        /*
         *  The JDBC driver is loaded by loading its class.
         *  If you are using JDBC 4.0 (Java SE 6) or newer, JDBC drivers may
         *  be automatically loaded, making this code optional.
         *
         *  In an embedded environment, this will also start up the Derby
         *  engine (though not any databases), since it is not already
         *  running. In a client environment, the Derby engine is being run
         *  by the network server framework.
         *
         *  In an embedded environment, any static Derby system properties
         *  must be set before loading the driver to take effect.
         */
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("\nUnable to load the JDBC driver " + driver);
            System.err.println("Please check your CLASSPATH.");
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println(
                        "\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println(
                        "\nNot allowed to access the JDBC driver " + driver);
            iae.printStackTrace(System.err);
        }
    }

    /**
     * Reports a data verification failure to System.err with the given message.
     *
     * @param message A message describing what failed.
     */
    private void reportFailure(String message) {
        System.err.println("\nData verification failed:");
        System.err.println('\t' + message);
    }

    /**
     * Prints details of an SQLException chain to <code>System.err</code>.
     * Details included are SQL State, Error code, Exception message.
     *
     * @param e the SQLException from which to print details.
     */
    public static void printSQLException(SQLException e)
    {
        // Unwraps the entire exception chain to unveil the real cause of the
        // Exception.
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            // for stack traces, refer to derby.log or uncomment this:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    }

    /**
     * Parses the arguments given and sets the values of this class' instance
     * variables accordingly - that is which framework to use, the name of the
     * JDBC driver class, and which connection protocol protocol to use. The
     * protocol should be used as part of the JDBC URL when connecting to Derby.
     * <p>
     * If the argument is "embedded" or invalid, this method will not change
     * anything, meaning that the default values will be used.</p>
     * <p>
     * @param args JDBC connection framework, either "embedded", "derbyclient".
     * Only the first argument will be considered, the rest will be ignored.
     */
    private void parseArguments(String[] args)
    {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("derbyclient"))
            {
                framework = "derbyclient";
                driver = "org.apache.derby.jdbc.ClientDriver";
                protocol = "jdbc:derby://localhost:1527/";
            }
        }
    }
}
