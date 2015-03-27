import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;



public class jdb_save{

    /* the default framework is embedded*/
    private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";


    int ix0 = 0;
    int ix1 = 0;

    String cx0 = new String();
    String cx1 = new String();
    String cx2 = new String();




    jdb_save(){//************************************************************************


        /* parse the arguments to determine which framework is desired*/
        //parseArguments(args);

        System.out.println("");
        System.out.println("JDB saving starting in " + framework + " mode");

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



            conn = DriverManager.getConnection(protocol + dbName + ";create=true", props);

            System.out.println("Connected to and created database " + dbName);

            // We want to control transactions manually. Autocommit is on by
            // default in JDBC.
            conn.setAutoCommit(false);

            /* Creating a statement object that we can use for running various
             * SQL statements commands against the database.*/
            s = conn.createStatement();
            statements.add(s);



            // delete the table


ix1 = 20000;

ix0 = 0;
try{s.execute("drop table settings");}catch (SQLException se){System.out.println("DB does not Exist0."); ix0 = 1;}
try{s.execute("drop table settings");}catch (SQLException se){System.out.println("DB does not Exist1."); ix0 = 1;}

// We create a table...
if(ix0 == 1){//******************************************************

	s.execute("create table settings(value varchar(160), align varchar(60))"); 
System.out.println("Created table settings");

}//****************************************************************


try{s.execute("drop table sell_db");}catch (SQLException se){System.out.println("DB does not Exist0."); ix0 = 1;}
try{s.execute("drop table sell_db");}catch (SQLException se){System.out.println("DB does not Exist1."); ix0 = 1;}

// We create a table...
if(ix0 == 1){//******************************************************

	s.execute("create table sell_db(buyer_address_1 varchar(160), buyer_address_2 varchar(160), buyer_address_city varchar(160), buyer_address_state varchar(160), buyer_address_zip varchar(160), buyer_address_country varchar(160), buyer_id varchar(160), buyer_ip varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(160), buyers_payment_address varchar(160), buyers_phone varchar(160), currency varchar(160), custom_template varchar(160), custom_1 varchar(160), custom_2 varchar(160), custom_3 varchar(160), item_errors varchar(160), item_date_listed varchar(160), item_date_listed_day varchar(160), item_date_listed_int varchar(160), item_hits varchar(160), item_confirm_code varchar(160), item_confirmed varchar(160), item_cost varchar(160), item_description varchar(3160), item_id varchar(160), item_price varchar(160), item_weight varchar(160), item_listing_id varchar(160), item_notes varchar(160), item_package_d varchar(160),item_package_l varchar(160), item_package_w varchar(160), item_part_number varchar(160), item_title varchar(160), item_title_url varchar(160), item_type varchar(160), item_search_1 varchar(160), item_search_2 varchar(160), item_search_3 varchar(160), item_site_id varchar(160), item_site_url varchar(160), item_picture_1 varchar(160), item_total_on_hand varchar(160), sale_date_payment_received varchar(160), sale_date_shipped varchar(160), sale_date_sold varchar(160), sale_final_value_fee varchar(160), sale_handling varchar(160), sale_payment_address varchar(160), sale_payment_type varchar(160), sale_fees varchar(160), sale_quantity_sold varchar(160), sale_id varchar(160), sale_seller_id varchar(160), sale_status varchar(160), sale_tax varchar(160), sale_shipping_company varchar(160), sale_shipping_in varchar(160), sale_shipping_out varchar(160), sale_source_of_sale varchar(160), sale_total_sale_amount varchar(160), sale_tracking_number varchar(160), sale_transaction_id varchar(160), sale_transaction_info varchar(160), seller_address_1 varchar(160), seller_address_2 varchar(160), seller_address_city varchar(160), seller_address_state varchar(160), seller_address_zip varchar(160), seller_address_country varchar(160), seller_id varchar(160), seller_ip varchar(160), seller_email varchar(160), seller_first_name varchar(160), seller_last_name varchar(160), seller_notes varchar(160), seller_phone varchar(160), seller_logo varchar(160), seller_url varchar(160))"); 
System.out.println("Created table buy");

}//****************************************************************


try{s.execute("drop table buy_db");}catch (SQLException se){System.out.println("DB does not Exist0."); ix0 = 1;}
try{s.execute("drop table buy_db");}catch (SQLException se){System.out.println("DB does not Exist1."); ix0 = 1;}

// We create a table...
if(ix0 == 1){//******************************************************

	s.execute("create table buy_db(buyer_address_1 varchar(160), buyer_address_2 varchar(160), buyer_address_city varchar(160), buyer_address_state varchar(160), buyer_address_zip varchar(160), buyer_address_country varchar(160), buyer_id varchar(160), buyer_ip varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(160), buyers_payment_address varchar(160), buyers_phone varchar(160), currency varchar(160), custom_template varchar(160), custom_1 varchar(160), custom_2 varchar(160), custom_3 varchar(160), item_errors varchar(160), item_date_listed varchar(160), item_date_listed_day varchar(160), item_date_listed_int varchar(160), item_hits varchar(160), item_confirm_code varchar(160), item_confirmed varchar(160), item_cost varchar(160), item_description varchar(3160), item_id varchar(160), item_price varchar(160), item_weight varchar(160), item_listing_id varchar(160), item_notes varchar(160), item_package_d varchar(160),item_package_l varchar(160), item_package_w varchar(160), item_part_number varchar(160), item_title varchar(160), item_title_url varchar(160), item_type varchar(160), item_search_1 varchar(160), item_search_2 varchar(160), item_search_3 varchar(160), item_site_id varchar(160), item_site_url varchar(160), item_picture_1 varchar(160), item_total_on_hand varchar(160), sale_date_payment_received varchar(160), sale_date_shipped varchar(160), sale_date_sold varchar(160), sale_final_value_fee varchar(160), sale_handling varchar(160), sale_payment_address varchar(160), sale_payment_type varchar(160), sale_fees varchar(160), sale_quantity_sold varchar(160), sale_id varchar(160), sale_seller_id varchar(160), sale_status varchar(160), sale_tax varchar(160), sale_shipping_company varchar(160), sale_shipping_in varchar(160), sale_shipping_out varchar(160), sale_source_of_sale varchar(160), sale_total_sale_amount varchar(160), sale_tracking_number varchar(160), sale_transaction_id varchar(160), sale_transaction_info varchar(160), seller_address_1 varchar(160), seller_address_2 varchar(160), seller_address_city varchar(160), seller_address_state varchar(160), seller_address_zip varchar(160), seller_address_country varchar(160), seller_id varchar(160), seller_ip varchar(160), seller_email varchar(160), seller_first_name varchar(160), seller_last_name varchar(160), seller_notes varchar(160), seller_phone varchar(160), seller_logo varchar(160), seller_url varchar(160))"); 
System.out.println("Created table buy");

}//****************************************************************


try{s.execute("drop table sold_db");}catch (SQLException se){System.out.println("DB does not Exist0."); ix0 = 1;}
try{s.execute("drop table sold_db");}catch (SQLException se){System.out.println("DB does not Exist1."); ix0 = 1;}

// We create a table...
if(ix0 == 1){//******************************************************

	s.execute("create table sold_db(buyer_address_1 varchar(160), buyer_address_2 varchar(160), buyer_address_city varchar(160), buyer_address_state varchar(160), buyer_address_zip varchar(160), buyer_address_country varchar(160), buyer_id varchar(160), buyer_ip varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(160), buyers_payment_address varchar(160), buyers_phone varchar(160), currency varchar(160), custom_template varchar(160), custom_1 varchar(160), custom_2 varchar(160), custom_3 varchar(160), item_errors varchar(160), item_date_listed varchar(160), item_date_listed_day varchar(160), item_date_listed_int varchar(160), item_hits varchar(160), item_confirm_code varchar(160), item_confirmed varchar(160), item_cost varchar(160), item_description varchar(3160), item_id varchar(160), item_price varchar(160), item_weight varchar(160), item_listing_id varchar(160), item_notes varchar(160), item_package_d varchar(160),item_package_l varchar(160), item_package_w varchar(160), item_part_number varchar(160), item_title varchar(160), item_title_url varchar(160), item_type varchar(160), item_search_1 varchar(160), item_search_2 varchar(160), item_search_3 varchar(160), item_site_id varchar(160), item_site_url varchar(160), item_picture_1 varchar(160), item_total_on_hand varchar(160), sale_date_payment_received varchar(160), sale_date_shipped varchar(160), sale_date_sold varchar(160), sale_final_value_fee varchar(160), sale_handling varchar(160), sale_payment_address varchar(160), sale_payment_type varchar(160), sale_fees varchar(160), sale_quantity_sold varchar(160), sale_id varchar(160), sale_seller_id varchar(160), sale_status varchar(160), sale_tax varchar(160), sale_shipping_company varchar(160), sale_shipping_in varchar(160), sale_shipping_out varchar(160), sale_source_of_sale varchar(160), sale_total_sale_amount varchar(160), sale_tracking_number varchar(160), sale_transaction_id varchar(160), sale_transaction_info varchar(160), seller_address_1 varchar(160), seller_address_2 varchar(160), seller_address_city varchar(160), seller_address_state varchar(160), seller_address_zip varchar(160), seller_address_country varchar(160), seller_id varchar(160), seller_ip varchar(160), seller_email varchar(160), seller_first_name varchar(160), seller_last_name varchar(160), seller_notes varchar(160), seller_phone varchar(160), seller_logo varchar(160), seller_url varchar(160))"); 
System.out.println("Created table sold");

}//****************************************************************


try{s.execute("drop table purchase_db");}catch (SQLException se){System.out.println("DB does not Exist0."); ix0 = 1;}
try{s.execute("drop table purchase_db");}catch (SQLException se){System.out.println("DB does not Exist1."); ix0 = 1;}

// We create a table...
if(ix0 == 1){//******************************************************

	s.execute("create table purchase_db(buyer_address_1 varchar(160), buyer_address_2 varchar(160), buyer_address_city varchar(160), buyer_address_state varchar(160), buyer_address_zip varchar(160), buyer_address_country varchar(160), buyer_id varchar(160), buyer_ip varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(160), buyers_payment_address varchar(160), buyers_phone varchar(160), currency varchar(160), custom_template varchar(160), custom_1 varchar(160), custom_2 varchar(160), custom_3 varchar(160), item_errors varchar(160), item_date_listed varchar(160), item_date_listed_day varchar(160), item_date_listed_int varchar(160), item_hits varchar(160), item_confirm_code varchar(160), item_confirmed varchar(160), item_cost varchar(160), item_description varchar(3160), item_id varchar(160), item_price varchar(160), item_weight varchar(160), item_listing_id varchar(160), item_notes varchar(160), item_package_d varchar(160),item_package_l varchar(160), item_package_w varchar(160), item_part_number varchar(160), item_title varchar(160), item_title_url varchar(160), item_type varchar(160), item_search_1 varchar(160), item_search_2 varchar(160), item_search_3 varchar(160), item_site_id varchar(160), item_site_url varchar(160), item_picture_1 varchar(160), item_total_on_hand varchar(160), sale_date_payment_received varchar(160), sale_date_shipped varchar(160), sale_date_sold varchar(160), sale_final_value_fee varchar(160), sale_handling varchar(160), sale_payment_address varchar(160), sale_payment_type varchar(160), sale_fees varchar(160), sale_quantity_sold varchar(160), sale_id varchar(160), sale_seller_id varchar(160), sale_status varchar(160), sale_tax varchar(160), sale_shipping_company varchar(160), sale_shipping_in varchar(160), sale_shipping_out varchar(160), sale_source_of_sale varchar(160), sale_total_sale_amount varchar(160), sale_tracking_number varchar(160), sale_transaction_id varchar(160), sale_transaction_info varchar(160), seller_address_1 varchar(160), seller_address_2 varchar(160), seller_address_city varchar(160), seller_address_state varchar(160), seller_address_zip varchar(160), seller_address_country varchar(160), seller_id varchar(160), seller_ip varchar(160), seller_email varchar(160), seller_first_name varchar(160), seller_last_name varchar(160), seller_notes varchar(160), seller_phone varchar(160), seller_logo varchar(160), seller_url varchar(160))"); 
System.out.println("Created table purchase");

}//****************************************************************


try{s.execute("drop table blocked_db");}catch (SQLException se){System.out.println("DB does not Exist0."); ix0 = 1;}
try{s.execute("drop table blocked_db");}catch (SQLException se){System.out.println("DB does not Exist1."); ix0 = 1;}

// We create a table...
if(ix0 == 1){//******************************************************

	s.execute("create table blocked_db(blocked_address varchar(100))"); 
System.out.println("Created table blocked ip");

}//****************************************************************










         //and add a few rows...

	PreparedStatement ps = null;

	

	ps = conn.prepareStatement("insert into settings(value, align) values (?,?)");

	int numrows = 0;



	for(int loop1 = 0; loop1 < lm.carbon_settings.length; loop1++){//********************


	    System.out.println(lm.carbon_settings[loop1]);
            ps.setString(1,lm.carbon_settings[loop1]);
            ps.setString(2,Integer.toString((1000 + loop1)));


	numrows = numrows + ps.executeUpdate();


	}//*******************************************************************************

	ps.close();





	System.out.println("DBsx");




         //and add a few rows...

	ps = null;

	System.out.println("DBsx1");

	ps = conn.prepareStatement("insert into sell_db(buyer_address_1, buyer_address_2, buyer_address_city, buyer_address_state, buyer_address_zip, buyer_address_country, buyer_id, buyer_ip, buyers_email, buyers_first_name, buyers_last_name, buyers_payment_address, buyers_phone, currency, custom_template, custom_1, custom_2, custom_3, item_errors, item_date_listed, item_date_listed_day, item_date_listed_int, item_hits, item_confirm_code, item_confirmed, item_cost, item_description, item_id, item_price, item_weight, item_listing_id, item_notes, item_package_d, item_package_l, item_package_w, item_part_number, item_title, item_title_url, item_type, item_search_1, item_search_2, item_search_3, item_site_id, item_site_url, item_picture_1, item_total_on_hand, sale_date_payment_received, sale_date_shipped, sale_date_sold, sale_final_value_fee, sale_handling, sale_payment_address, sale_payment_type, sale_fees, sale_quantity_sold, sale_id, sale_seller_id, sale_status, sale_tax, sale_shipping_company, sale_shipping_in, sale_shipping_out, sale_source_of_sale, sale_total_sale_amount, sale_tracking_number, sale_transaction_id, sale_transaction_info, seller_address_1, seller_address_2, seller_address_city, seller_address_state, seller_address_zip, seller_address_country, seller_id, seller_ip, seller_email, seller_first_name, seller_last_name, seller_notes, seller_phone, seller_logo, seller_url) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

	numrows = 0;

	System.out.println("DBsx2");

	for(int loop1 = 0; loop1 < lm.carbon_sell[0].length; loop1++){//********************

            ps.setString(1,lm.carbon_sell[0][loop1]);//loop1
            ps.setString(2,lm.carbon_sell[1][loop1]);
            ps.setString(3,lm.carbon_sell[2][loop1]);
            ps.setString(4,lm.carbon_sell[3][loop1]);
            ps.setString(5,lm.carbon_sell[4][loop1]);
            ps.setString(6,lm.carbon_sell[5][loop1]);
            ps.setString(7,lm.carbon_sell[6][loop1]);
            ps.setString(8,lm.carbon_sell[7][loop1]);
            ps.setString(9,lm.carbon_sell[8][loop1]);
            ps.setString(10,lm.carbon_sell[9][loop1]);
            ps.setString(11,lm.carbon_sell[10][loop1]);
            ps.setString(12,lm.carbon_sell[11][loop1]);
            ps.setString(13,lm.carbon_sell[12][loop1]);
            ps.setString(14,lm.carbon_sell[13][loop1]);
            ps.setString(15,lm.carbon_sell[14][loop1]);
            ps.setString(16,lm.carbon_sell[15][loop1]);
            ps.setString(17,lm.carbon_sell[16][loop1]);
            ps.setString(18,lm.carbon_sell[17][loop1]);
            ps.setString(19,lm.carbon_sell[18][loop1]);
            ps.setString(20,lm.carbon_sell[19][loop1]);
            ps.setString(21,lm.carbon_sell[20][loop1]);
            ps.setString(22,lm.carbon_sell[21][loop1]);
            ps.setString(23,lm.carbon_sell[22][loop1]);
            ps.setString(24,lm.carbon_sell[23][loop1]);
            ps.setString(25,lm.carbon_sell[24][loop1]);
            ps.setString(26,lm.carbon_sell[25][loop1]);
            ps.setString(27,lm.carbon_sell[26][loop1]);
            ps.setString(28,lm.carbon_sell[27][loop1]);
            ps.setString(29,lm.carbon_sell[28][loop1]);
            ps.setString(30,lm.carbon_sell[29][loop1]);
            ps.setString(31,lm.carbon_sell[30][loop1]);
            ps.setString(32,lm.carbon_sell[31][loop1]);
            ps.setString(33,lm.carbon_sell[32][loop1]);
            ps.setString(34,lm.carbon_sell[33][loop1]);
            ps.setString(35,lm.carbon_sell[34][loop1]);
            ps.setString(36,lm.carbon_sell[35][loop1]);
            ps.setString(37,lm.carbon_sell[36][loop1]);
            ps.setString(38,lm.carbon_sell[37][loop1]);
            ps.setString(39,lm.carbon_sell[38][loop1]);
            ps.setString(40,lm.carbon_sell[39][loop1]);
            ps.setString(41,lm.carbon_sell[40][loop1]);
            ps.setString(42,lm.carbon_sell[41][loop1]);
            ps.setString(43,lm.carbon_sell[42][loop1]);
            ps.setString(44,lm.carbon_sell[43][loop1]);
            ps.setString(45,lm.carbon_sell[44][loop1]);
            ps.setString(46,lm.carbon_sell[45][loop1]);
            ps.setString(47,lm.carbon_sell[46][loop1]);
            ps.setString(48,lm.carbon_sell[47][loop1]);
            ps.setString(49,lm.carbon_sell[48][loop1]);
            ps.setString(50,lm.carbon_sell[49][loop1]);
            ps.setString(51,lm.carbon_sell[50][loop1]);
            ps.setString(52,lm.carbon_sell[51][loop1]);
            ps.setString(53,lm.carbon_sell[52][loop1]);
            ps.setString(54,lm.carbon_sell[53][loop1]);
            ps.setString(55,lm.carbon_sell[54][loop1]);
            ps.setString(56,lm.carbon_sell[55][loop1]);
            ps.setString(57,lm.carbon_sell[56][loop1]);
            ps.setString(58,lm.carbon_sell[57][loop1]);
            ps.setString(59,lm.carbon_sell[58][loop1]);
            ps.setString(60,lm.carbon_sell[59][loop1]);
            ps.setString(61,lm.carbon_sell[60][loop1]);
            ps.setString(62,lm.carbon_sell[61][loop1]);
            ps.setString(63,lm.carbon_sell[62][loop1]);
            ps.setString(64,lm.carbon_sell[63][loop1]);
            ps.setString(65,lm.carbon_sell[64][loop1]);
            ps.setString(66,lm.carbon_sell[65][loop1]);
            ps.setString(67,lm.carbon_sell[66][loop1]);
            ps.setString(68,lm.carbon_sell[67][loop1]);
            ps.setString(69,lm.carbon_sell[68][loop1]);
            ps.setString(70,lm.carbon_sell[69][loop1]);
            ps.setString(71,lm.carbon_sell[70][loop1]);
            ps.setString(72,lm.carbon_sell[71][loop1]);
            ps.setString(73,lm.carbon_sell[72][loop1]);
            ps.setString(74,lm.carbon_sell[73][loop1]);
            ps.setString(75,lm.carbon_sell[74][loop1]);
            ps.setString(76,lm.carbon_sell[75][loop1]);
            ps.setString(77,lm.carbon_sell[76][loop1]);
            ps.setString(78,lm.carbon_sell[77][loop1]);
            ps.setString(79,lm.carbon_sell[78][loop1]);
            ps.setString(80,lm.carbon_sell[79][loop1]);
            ps.setString(81,lm.carbon_sell[80][loop1]);
            ps.setString(82,lm.carbon_sell[81][loop1]);

	numrows = numrows + ps.executeUpdate();


	}//*******************************************************************************

	ps.close();














         //and add a few rows...

	ps = null;

	

	ps = conn.prepareStatement("insert into sold_db(buyer_address_1, buyer_address_2, buyer_address_city, buyer_address_state, buyer_address_zip, buyer_address_country, buyer_id, buyer_ip, buyers_email, buyers_first_name, buyers_last_name, buyers_payment_address, buyers_phone, currency, custom_template, custom_1, custom_2, custom_3, item_errors, item_date_listed, item_date_listed_day, item_date_listed_int, item_hits, item_confirm_code, item_confirmed, item_cost, item_description, item_id, item_price, item_weight, item_listing_id, item_notes, item_package_d, item_package_l, item_package_w, item_part_number, item_title, item_title_url, item_type, item_search_1, item_search_2, item_search_3, item_site_id, item_site_url, item_picture_1, item_total_on_hand, sale_date_payment_received, sale_date_shipped, sale_date_sold, sale_final_value_fee, sale_handling, sale_payment_address, sale_payment_type, sale_fees, sale_quantity_sold, sale_id, sale_seller_id, sale_status, sale_tax, sale_shipping_company, sale_shipping_in, sale_shipping_out, sale_source_of_sale, sale_total_sale_amount, sale_tracking_number, sale_transaction_id, sale_transaction_info, seller_address_1, seller_address_2, seller_address_city, seller_address_state, seller_address_zip, seller_address_country, seller_id, seller_ip, seller_email, seller_first_name, seller_last_name, seller_notes, seller_phone, seller_logo, seller_url) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

	numrows = 0;



	for(int loop1 = 0; loop1 < lm.carbon_sold[0].length; loop1++){//********************

            ps.setString(1,lm.carbon_sold[0][loop1]);
            ps.setString(2,lm.carbon_sold[1][loop1]);
            ps.setString(3,lm.carbon_sold[2][loop1]);
            ps.setString(4,lm.carbon_sold[3][loop1]);
            ps.setString(5,lm.carbon_sold[4][loop1]);
            ps.setString(6,lm.carbon_sold[5][loop1]);
            ps.setString(7,lm.carbon_sold[6][loop1]);
            ps.setString(8,lm.carbon_sold[7][loop1]);
            ps.setString(9,lm.carbon_sold[8][loop1]);
            ps.setString(10,lm.carbon_sold[9][loop1]);
            ps.setString(11,lm.carbon_sold[10][loop1]);
            ps.setString(12,lm.carbon_sold[11][loop1]);
            ps.setString(13,lm.carbon_sold[12][loop1]);
            ps.setString(14,lm.carbon_sold[13][loop1]);
            ps.setString(15,lm.carbon_sold[14][loop1]);
            ps.setString(16,lm.carbon_sold[15][loop1]);
            ps.setString(17,lm.carbon_sold[16][loop1]);
            ps.setString(18,lm.carbon_sold[17][loop1]);
            ps.setString(19,lm.carbon_sold[18][loop1]);
            ps.setString(20,lm.carbon_sold[19][loop1]);
            ps.setString(21,lm.carbon_sold[20][loop1]);
            ps.setString(22,lm.carbon_sold[21][loop1]);
            ps.setString(23,lm.carbon_sold[22][loop1]);
            ps.setString(24,lm.carbon_sold[23][loop1]);
            ps.setString(25,lm.carbon_sold[24][loop1]);
            ps.setString(26,lm.carbon_sold[25][loop1]);
            ps.setString(27,lm.carbon_sold[26][loop1]);
            ps.setString(28,lm.carbon_sold[27][loop1]);
            ps.setString(29,lm.carbon_sold[28][loop1]);
            ps.setString(30,lm.carbon_sold[29][loop1]);
            ps.setString(31,lm.carbon_sold[30][loop1]);
            ps.setString(32,lm.carbon_sold[31][loop1]);
            ps.setString(33,lm.carbon_sold[32][loop1]);
            ps.setString(34,lm.carbon_sold[33][loop1]);
            ps.setString(35,lm.carbon_sold[34][loop1]);
            ps.setString(36,lm.carbon_sold[35][loop1]);
            ps.setString(37,lm.carbon_sold[36][loop1]);
            ps.setString(38,lm.carbon_sold[37][loop1]);
            ps.setString(39,lm.carbon_sold[38][loop1]);
            ps.setString(40,lm.carbon_sold[39][loop1]);
            ps.setString(41,lm.carbon_sold[40][loop1]);
            ps.setString(42,lm.carbon_sold[41][loop1]);
            ps.setString(43,lm.carbon_sold[42][loop1]);
            ps.setString(44,lm.carbon_sold[43][loop1]);
            ps.setString(45,lm.carbon_sold[44][loop1]);
            ps.setString(46,lm.carbon_sold[45][loop1]);
            ps.setString(47,lm.carbon_sold[46][loop1]);
            ps.setString(48,lm.carbon_sold[47][loop1]);
            ps.setString(49,lm.carbon_sold[48][loop1]);
            ps.setString(50,lm.carbon_sold[49][loop1]);
            ps.setString(51,lm.carbon_sold[50][loop1]);
            ps.setString(52,lm.carbon_sold[51][loop1]);
            ps.setString(53,lm.carbon_sold[52][loop1]);
            ps.setString(54,lm.carbon_sold[53][loop1]);
            ps.setString(55,lm.carbon_sold[54][loop1]);
            ps.setString(56,lm.carbon_sold[55][loop1]);
            ps.setString(57,lm.carbon_sold[56][loop1]);
            ps.setString(58,lm.carbon_sold[57][loop1]);
            ps.setString(59,lm.carbon_sold[58][loop1]);
            ps.setString(60,lm.carbon_sold[59][loop1]);
            ps.setString(61,lm.carbon_sold[60][loop1]);
            ps.setString(62,lm.carbon_sold[61][loop1]);
            ps.setString(63,lm.carbon_sold[62][loop1]);
            ps.setString(64,lm.carbon_sold[63][loop1]);
            ps.setString(65,lm.carbon_sold[64][loop1]);
            ps.setString(66,lm.carbon_sold[65][loop1]);
            ps.setString(67,lm.carbon_sold[66][loop1]);
            ps.setString(68,lm.carbon_sold[67][loop1]);
            ps.setString(69,lm.carbon_sold[68][loop1]);
            ps.setString(70,lm.carbon_sold[69][loop1]);
            ps.setString(71,lm.carbon_sold[70][loop1]);
            ps.setString(72,lm.carbon_sold[71][loop1]);
            ps.setString(73,lm.carbon_sold[72][loop1]);
            ps.setString(74,lm.carbon_sold[73][loop1]);
            ps.setString(75,lm.carbon_sold[74][loop1]);
            ps.setString(76,lm.carbon_sold[75][loop1]);
            ps.setString(77,lm.carbon_sold[76][loop1]);
            ps.setString(78,lm.carbon_sold[77][loop1]);
            ps.setString(79,lm.carbon_sold[78][loop1]);
            ps.setString(80,lm.carbon_sold[79][loop1]);
            ps.setString(81,lm.carbon_sold[80][loop1]);
            ps.setString(82,lm.carbon_sold[81][loop1]);

	numrows = numrows + ps.executeUpdate();


	}//*******************************************************************************

	ps.close();









         //and add a few rows...

	ps = null;

	

	ps = conn.prepareStatement("insert into purchase_db(buyer_address_1, buyer_address_2, buyer_address_city, buyer_address_state, buyer_address_zip, buyer_address_country, buyer_id, buyer_ip, buyers_email, buyers_first_name, buyers_last_name, buyers_payment_address, buyers_phone, currency, custom_template, custom_1, custom_2, custom_3, item_errors, item_date_listed, item_date_listed_day, item_date_listed_int, item_hits, item_confirm_code, item_confirmed, item_cost, item_description, item_id, item_price, item_weight, item_listing_id, item_notes, item_package_d, item_package_l, item_package_w, item_part_number, item_title, item_title_url, item_type, item_search_1, item_search_2, item_search_3, item_site_id, item_site_url, item_picture_1, item_total_on_hand, sale_date_payment_received, sale_date_shipped, sale_date_sold, sale_final_value_fee, sale_handling, sale_payment_address, sale_payment_type, sale_fees, sale_quantity_sold, sale_id, sale_seller_id, sale_status, sale_tax, sale_shipping_company, sale_shipping_in, sale_shipping_out, sale_source_of_sale, sale_total_sale_amount, sale_tracking_number, sale_transaction_id, sale_transaction_info, seller_address_1, seller_address_2, seller_address_city, seller_address_state, seller_address_zip, seller_address_country, seller_id, seller_ip, seller_email, seller_first_name, seller_last_name, seller_notes, seller_phone, seller_logo, seller_url) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

	numrows = 0;



	for(int loop1 = 0; loop1 < lm.carbon_purchase[0].length; loop1++){//********************

            ps.setString(1,lm.carbon_purchase[0][loop1]);
            ps.setString(2,lm.carbon_purchase[1][loop1]);
            ps.setString(3,lm.carbon_purchase[2][loop1]);
            ps.setString(4,lm.carbon_purchase[3][loop1]);
            ps.setString(5,lm.carbon_purchase[4][loop1]);
            ps.setString(6,lm.carbon_purchase[5][loop1]);
            ps.setString(7,lm.carbon_purchase[6][loop1]);
            ps.setString(8,lm.carbon_purchase[7][loop1]);
            ps.setString(9,lm.carbon_purchase[8][loop1]);
            ps.setString(10,lm.carbon_purchase[9][loop1]);
            ps.setString(11,lm.carbon_purchase[10][loop1]);
            ps.setString(12,lm.carbon_purchase[11][loop1]);
            ps.setString(13,lm.carbon_purchase[12][loop1]);
            ps.setString(14,lm.carbon_purchase[13][loop1]);
            ps.setString(15,lm.carbon_purchase[14][loop1]);
            ps.setString(16,lm.carbon_purchase[15][loop1]);
            ps.setString(17,lm.carbon_purchase[16][loop1]);
            ps.setString(18,lm.carbon_purchase[17][loop1]);
            ps.setString(19,lm.carbon_purchase[18][loop1]);
            ps.setString(20,lm.carbon_purchase[19][loop1]);
            ps.setString(21,lm.carbon_purchase[20][loop1]);
            ps.setString(22,lm.carbon_purchase[21][loop1]);
            ps.setString(23,lm.carbon_purchase[22][loop1]);
            ps.setString(24,lm.carbon_purchase[23][loop1]);
            ps.setString(25,lm.carbon_purchase[24][loop1]);
            ps.setString(26,lm.carbon_purchase[25][loop1]);
            ps.setString(27,lm.carbon_purchase[26][loop1]);
            ps.setString(28,lm.carbon_purchase[27][loop1]);
            ps.setString(29,lm.carbon_purchase[28][loop1]);
            ps.setString(30,lm.carbon_purchase[29][loop1]);
            ps.setString(31,lm.carbon_purchase[30][loop1]);
            ps.setString(32,lm.carbon_purchase[31][loop1]);
            ps.setString(33,lm.carbon_purchase[32][loop1]);
            ps.setString(34,lm.carbon_purchase[33][loop1]);
            ps.setString(35,lm.carbon_purchase[34][loop1]);
            ps.setString(36,lm.carbon_purchase[35][loop1]);
            ps.setString(37,lm.carbon_purchase[36][loop1]);
            ps.setString(38,lm.carbon_purchase[37][loop1]);
            ps.setString(39,lm.carbon_purchase[38][loop1]);
            ps.setString(40,lm.carbon_purchase[39][loop1]);
            ps.setString(41,lm.carbon_purchase[40][loop1]);
            ps.setString(42,lm.carbon_purchase[41][loop1]);
            ps.setString(43,lm.carbon_purchase[42][loop1]);
            ps.setString(44,lm.carbon_purchase[43][loop1]);
            ps.setString(45,lm.carbon_purchase[44][loop1]);
            ps.setString(46,lm.carbon_purchase[45][loop1]);
            ps.setString(47,lm.carbon_purchase[46][loop1]);
            ps.setString(48,lm.carbon_purchase[47][loop1]);
            ps.setString(49,lm.carbon_purchase[48][loop1]);
            ps.setString(50,lm.carbon_purchase[49][loop1]);
            ps.setString(51,lm.carbon_purchase[50][loop1]);
            ps.setString(52,lm.carbon_purchase[51][loop1]);
            ps.setString(53,lm.carbon_purchase[52][loop1]);
            ps.setString(54,lm.carbon_purchase[53][loop1]);
            ps.setString(55,lm.carbon_purchase[54][loop1]);
            ps.setString(56,lm.carbon_purchase[55][loop1]);
            ps.setString(57,lm.carbon_purchase[56][loop1]);
            ps.setString(58,lm.carbon_purchase[57][loop1]);
            ps.setString(59,lm.carbon_purchase[58][loop1]);
            ps.setString(60,lm.carbon_purchase[59][loop1]);
            ps.setString(61,lm.carbon_purchase[60][loop1]);
            ps.setString(62,lm.carbon_purchase[61][loop1]);
            ps.setString(63,lm.carbon_purchase[62][loop1]);
            ps.setString(64,lm.carbon_purchase[63][loop1]);
            ps.setString(65,lm.carbon_purchase[64][loop1]);
            ps.setString(66,lm.carbon_purchase[65][loop1]);
            ps.setString(67,lm.carbon_purchase[66][loop1]);
            ps.setString(68,lm.carbon_purchase[67][loop1]);
            ps.setString(69,lm.carbon_purchase[68][loop1]);
            ps.setString(70,lm.carbon_purchase[69][loop1]);
            ps.setString(71,lm.carbon_purchase[70][loop1]);
            ps.setString(72,lm.carbon_purchase[71][loop1]);
            ps.setString(73,lm.carbon_purchase[72][loop1]);
            ps.setString(74,lm.carbon_purchase[73][loop1]);
            ps.setString(75,lm.carbon_purchase[74][loop1]);
            ps.setString(76,lm.carbon_purchase[75][loop1]);
            ps.setString(77,lm.carbon_purchase[76][loop1]);
            ps.setString(78,lm.carbon_purchase[77][loop1]);
            ps.setString(79,lm.carbon_purchase[78][loop1]);
            ps.setString(80,lm.carbon_purchase[79][loop1]);
            ps.setString(81,lm.carbon_purchase[80][loop1]);
            ps.setString(82,lm.carbon_purchase[81][loop1]);

	numrows = numrows + ps.executeUpdate();


	}//*******************************************************************************

	ps.close();









         //and add a few rows...

	ps = null;

	

	ps = conn.prepareStatement("insert into blocked_db(blocked_address) values (?)");

	numrows = 0;



	for(int loop1 = 0; loop1 < lm.carbon_blockip.length; loop1++){//********************


	    System.out.println(lm.carbon_blockip[loop1]);
            ps.setString(1,lm.carbon_blockip[loop1]);


	numrows = numrows + ps.executeUpdate();


	}//*******************************************************************************

	ps.close();















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

            if (framework.equals("embedded")){
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
    }












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
