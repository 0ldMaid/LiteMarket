import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import javax.imageio.ImageIO;
import javax.imageio.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Calendar;
import java.text.SimpleDateFormat;





public class build_db{







build_db(){//*********************************************




System.out.println("Build DB");


lm.carbon_sell = new String[82][1];

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
lm.carbon_sell[35][0] = new String("[[item_part_number]]");
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


lm.carbon_buy = new String[82][1];

lm.carbon_buy[0][0] = new String("[[buyer_address_1]]");
lm.carbon_buy[1][0] = new String("[[buyer_address_2]]");
lm.carbon_buy[2][0] = new String("[[buyer_address_city]]");
lm.carbon_buy[3][0] = new String("[[buyer_address_state]]");
lm.carbon_buy[4][0] = new String("[[buyer_address_zip]]");
lm.carbon_buy[5][0] = new String("[[buyer_address_country]]");
lm.carbon_buy[6][0] = new String("[[buyer_id]]");
lm.carbon_buy[7][0] = new String("[[buyer_ip]]");
lm.carbon_buy[8][0] = new String("[[buyers_email]]");
lm.carbon_buy[9][0] = new String("[[buyers_first_name]]");
lm.carbon_buy[10][0] = new String("[[buyers_last_name]]");
lm.carbon_buy[11][0] = new String("[[buyers_payment_address]]");
lm.carbon_buy[12][0] = new String("[[buyers_phone]]");
lm.carbon_buy[13][0] = new String("[[currency]]");
lm.carbon_buy[14][0] = new String("[[custom_template]]");
lm.carbon_buy[15][0] = new String("[[custom_1]]");
lm.carbon_buy[16][0] = new String("[[custom_2]]");
lm.carbon_buy[17][0] = new String("[[custom_3]]");
lm.carbon_buy[18][0] = new String("[[item_errors]]");
lm.carbon_buy[19][0] = new String("[[item_date_listed]]");
lm.carbon_buy[20][0] = new String("[[item_date_listed_day]]");
lm.carbon_buy[21][0] = new String("[[item_date_listed_int]]");
lm.carbon_buy[22][0] = new String("[[item_hits]]");
lm.carbon_buy[23][0] = new String("[[item_confirm_code]]");
lm.carbon_buy[24][0] = new String("[[item_confirmed]]");
lm.carbon_buy[25][0] = new String("[[item_cost]]");
lm.carbon_buy[26][0] = new String("[[item_description]]");
lm.carbon_buy[27][0] = new String("[[item_id]]");
lm.carbon_buy[28][0] = new String("[[item_price]]");
lm.carbon_buy[29][0] = new String("[[item_weight]]");
lm.carbon_buy[30][0] = new String("[[item_listing_id]]");
lm.carbon_buy[31][0] = new String("[[item_notes]]");
lm.carbon_buy[32][0] = new String("[[item_package_d]]");
lm.carbon_buy[33][0] = new String("[[item_package_l]]");
lm.carbon_buy[34][0] = new String("[[item_package_w]]");
lm.carbon_buy[35][0] = new String("[[item_part_number]]");
lm.carbon_buy[36][0] = new String("[[item_title]]");
lm.carbon_buy[37][0] = new String("[[item_title_url]]");
lm.carbon_buy[38][0] = new String("[[item_type]]");
lm.carbon_buy[39][0] = new String("[[item_search_1]]");
lm.carbon_buy[40][0] = new String("[[item_search_2]]");
lm.carbon_buy[41][0] = new String("[[item_search_3]]");
lm.carbon_buy[42][0] = new String("[[item_site_id]]");
lm.carbon_buy[43][0] = new String("[[item_site_url]]");
lm.carbon_buy[44][0] = new String("[[item_picture_1]]");
lm.carbon_buy[45][0] = new String("[[item_total_on_hand]]");
lm.carbon_buy[46][0] = new String("[[sale_date_payment_received]]");
lm.carbon_buy[47][0] = new String("[[sale_date_shipped]]");
lm.carbon_buy[48][0] = new String("[[sale_date_sold]]");
lm.carbon_buy[49][0] = new String("[[sale_final_value_fee]]");
lm.carbon_buy[50][0] = new String("[[sale_handling]]");
lm.carbon_buy[51][0] = new String("[[sale_payment_address]]");
lm.carbon_buy[52][0] = new String("[[sale_payment_type]]");
lm.carbon_buy[53][0] = new String("[[sale_fees]]");
lm.carbon_buy[54][0] = new String("[[sale_quantity_sold]]");
lm.carbon_buy[55][0] = new String("[[sale_id]]");
lm.carbon_buy[56][0] = new String("[[sale_seller_id]]");
lm.carbon_buy[57][0] = new String("[[sale_status]]");
lm.carbon_buy[58][0] = new String("[[sale_tax]]");
lm.carbon_buy[59][0] = new String("[[sale_shipping_company]]");
lm.carbon_buy[60][0] = new String("[[sale_shipping_in]]");
lm.carbon_buy[61][0] = new String("[[sale_shipping_out]]");
lm.carbon_buy[62][0] = new String("[[sale_source_of_sale]]");
lm.carbon_buy[63][0] = new String("[[sale_total_sale_amount]]");
lm.carbon_buy[64][0] = new String("[[sale_tracking_number]]");
lm.carbon_buy[65][0] = new String("[[sale_transaction_id]]");
lm.carbon_buy[66][0] = new String("[[sale_transaction_info]]");
lm.carbon_buy[67][0] = new String("[[seller_address_1]]");
lm.carbon_buy[68][0] = new String("[[seller_address_2]]");
lm.carbon_buy[69][0] = new String("[[seller_address_city]]");
lm.carbon_buy[70][0] = new String("[[seller_address_state]]");
lm.carbon_buy[71][0] = new String("[[seller_address_zip]]");
lm.carbon_buy[72][0] = new String("[[seller_address_country]]");
lm.carbon_buy[73][0] = new String("[[seller_id]]");
lm.carbon_buy[74][0] = new String("[[seller_ip]]");
lm.carbon_buy[75][0] = new String("[[seller_email]]");
lm.carbon_buy[76][0] = new String("[[seller_first_name]]");
lm.carbon_buy[77][0] = new String("[[seller_last_name]]");
lm.carbon_buy[78][0] = new String("[[seller_notes]]");
lm.carbon_buy[79][0] = new String("[[seller_phone]]");
lm.carbon_buy[80][0] = new String("[[seller_logo]]");
lm.carbon_buy[81][0] = new String("[[seller_url]]");




}//vm*****************************************************








}//last
