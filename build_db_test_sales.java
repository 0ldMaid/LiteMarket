
public class build_db_test_sales{







build_db_test_sales(){//*********************************************




System.out.println("Build DB");


lm.carbon_sold = new String[82][1];

lm.carbon_sold[0][0] = new String("[[buyer_address_1]]");
lm.carbon_sold[1][0] = new String("[[buyer_address_2]]");
lm.carbon_sold[2][0] = new String("[[buyer_address_city]]");
lm.carbon_sold[3][0] = new String("[[buyer_address_state]]");
lm.carbon_sold[4][0] = new String("[[buyer_address_zip]]");
lm.carbon_sold[5][0] = new String("[[buyer_address_country]]");
lm.carbon_sold[6][0] = new String("[[buyer_id]]");
lm.carbon_sold[7][0] = new String("[[buyer_ip]]");
lm.carbon_sold[8][0] = new String("[[buyers_email]]");
lm.carbon_sold[9][0] = new String("[[buyers_first_name]]");
lm.carbon_sold[10][0] = new String("[[buyers_last_name]]");
lm.carbon_sold[11][0] = new String("[[buyers_payment_address]]");
lm.carbon_sold[12][0] = new String("[[buyers_phone]]");
lm.carbon_sold[13][0] = new String("[[currency]]");
lm.carbon_sold[14][0] = new String("[[custom_template]]");
lm.carbon_sold[15][0] = new String("[[custom_1]]");
lm.carbon_sold[16][0] = new String("[[custom_2]]");
lm.carbon_sold[17][0] = new String("[[custom_3]]");
lm.carbon_sold[18][0] = new String("[[item_errors]]");
lm.carbon_sold[19][0] = new String("[[item_date_listed]]");
lm.carbon_sold[20][0] = new String("[[item_date_listed_day]]");
lm.carbon_sold[21][0] = new String("[[item_date_listed_int]]");
lm.carbon_sold[22][0] = new String("[[item_hits]]");
lm.carbon_sold[23][0] = new String("[[item_confirm_code]]");
lm.carbon_sold[24][0] = new String("[[item_confirmed]]");
lm.carbon_sold[25][0] = new String("[[item_cost]]");
lm.carbon_sold[26][0] = new String("[[item_description]]");
lm.carbon_sold[27][0] = new String("[[item_id]]");
lm.carbon_sold[28][0] = new String("[[item_price]]");
lm.carbon_sold[29][0] = new String("[[item_weight]]");
lm.carbon_sold[30][0] = new String("[[item_listing_id]]");
lm.carbon_sold[31][0] = new String("[[item_notes]]");
lm.carbon_sold[32][0] = new String("[[item_package_d]]");
lm.carbon_sold[33][0] = new String("[[item_package_l]]");
lm.carbon_sold[34][0] = new String("[[item_package_w]]");
lm.carbon_sold[35][0] = new String("[[item_part_number]]");
lm.carbon_sold[36][0] = new String("test sale");//[[item_title]]
lm.carbon_sold[37][0] = new String("[[item_title_url]]");
lm.carbon_sold[38][0] = new String("[[item_type]]");
lm.carbon_sold[39][0] = new String("[[item_search_1]]");
lm.carbon_sold[40][0] = new String("[[item_search_2]]");
lm.carbon_sold[41][0] = new String("[[item_search_3]]");
lm.carbon_sold[42][0] = new String("[[item_site_id]]");
lm.carbon_sold[43][0] = new String("[[item_site_url]]");
lm.carbon_sold[44][0] = new String("[[item_picture_1]]");
lm.carbon_sold[45][0] = new String("[[item_total_on_hand]]");
lm.carbon_sold[46][0] = new String("[[sale_date_payment_received]]");
lm.carbon_sold[47][0] = new String("[[sale_date_shipped]]");
lm.carbon_sold[48][0] = new String("[[sale_date_sold]]");
lm.carbon_sold[49][0] = new String("[[sale_final_value_fee]]");
lm.carbon_sold[50][0] = new String("[[sale_handling]]");
lm.carbon_sold[51][0] = new String("[[sale_payment_address]]");
lm.carbon_sold[52][0] = new String("[[sale_payment_type]]");
lm.carbon_sold[53][0] = new String("[[sale_fees]]");
lm.carbon_sold[54][0] = new String("[[sale_quantity_sold]]");
lm.carbon_sold[55][0] = new String("[[sale_id]]");
lm.carbon_sold[56][0] = new String("[[sale_seller_id]]");
lm.carbon_sold[57][0] = new String("[[sale_status]]");
lm.carbon_sold[58][0] = new String("[[sale_tax]]");
lm.carbon_sold[59][0] = new String("[[sale_shipping_company]]");
lm.carbon_sold[60][0] = new String("[[sale_shipping_in]]");
lm.carbon_sold[61][0] = new String("[[sale_shipping_out]]");
lm.carbon_sold[62][0] = new String("[[sale_source_of_sale]]");
lm.carbon_sold[63][0] = new String("[[sale_total_sale_amount]]");
lm.carbon_sold[64][0] = new String("[[sale_tracking_number]]");
lm.carbon_sold[65][0] = new String("[[sale_transaction_id]]");
lm.carbon_sold[66][0] = new String("[[sale_transaction_info]]");
lm.carbon_sold[67][0] = new String("[[seller_address_1]]");
lm.carbon_sold[68][0] = new String("[[seller_address_2]]");
lm.carbon_sold[69][0] = new String("[[seller_address_city]]");
lm.carbon_sold[70][0] = new String("[[seller_address_state]]");
lm.carbon_sold[71][0] = new String("[[seller_address_zip]]");
lm.carbon_sold[72][0] = new String("[[seller_address_country]]");
lm.carbon_sold[73][0] = new String("[[seller_id]]");
lm.carbon_sold[74][0] = new String("[[seller_ip]]");
lm.carbon_sold[75][0] = new String("[[seller_email]]");
lm.carbon_sold[76][0] = new String("[[seller_first_name]]");
lm.carbon_sold[77][0] = new String("[[seller_last_name]]");
lm.carbon_sold[78][0] = new String("[[seller_notes]]");
lm.carbon_sold[79][0] = new String("[[seller_phone]]");
lm.carbon_sold[80][0] = new String("[[seller_logo]]");
lm.carbon_sold[81][0] = new String("[[seller_url]]");


lm.carbon_purchase = new String[82][1];

lm.carbon_purchase[0][0] = new String("[[buyer_address_1]]");
lm.carbon_purchase[1][0] = new String("[[buyer_address_2]]");
lm.carbon_purchase[2][0] = new String("[[buyer_address_city]]");
lm.carbon_purchase[3][0] = new String("[[buyer_address_state]]");
lm.carbon_purchase[4][0] = new String("[[buyer_address_zip]]");
lm.carbon_purchase[5][0] = new String("[[buyer_address_country]]");
lm.carbon_purchase[6][0] = new String("[[buyer_id]]");
lm.carbon_purchase[7][0] = new String("[[buyer_ip]]");
lm.carbon_purchase[8][0] = new String("[[buyers_email]]");
lm.carbon_purchase[9][0] = new String("[[buyers_first_name]]");
lm.carbon_purchase[10][0] = new String("[[buyers_last_name]]");
lm.carbon_purchase[11][0] = new String("[[buyers_payment_address]]");
lm.carbon_purchase[12][0] = new String("[[buyers_phone]]");
lm.carbon_purchase[13][0] = new String("[[currency]]");
lm.carbon_purchase[14][0] = new String("[[custom_template]]");
lm.carbon_purchase[15][0] = new String("[[custom_1]]");
lm.carbon_purchase[16][0] = new String("[[custom_2]]");
lm.carbon_purchase[17][0] = new String("[[custom_3]]");
lm.carbon_purchase[18][0] = new String("[[item_errors]]");
lm.carbon_purchase[19][0] = new String("[[item_date_listed]]");
lm.carbon_purchase[20][0] = new String("[[item_date_listed_day]]");
lm.carbon_purchase[21][0] = new String("[[item_date_listed_int]]");
lm.carbon_purchase[22][0] = new String("[[item_hits]]");
lm.carbon_purchase[23][0] = new String("[[item_confirm_code]]");
lm.carbon_purchase[24][0] = new String("[[item_confirmed]]");
lm.carbon_purchase[25][0] = new String("[[item_cost]]");
lm.carbon_purchase[26][0] = new String("[[item_description]]");
lm.carbon_purchase[27][0] = new String("[[item_id]]");
lm.carbon_purchase[28][0] = new String("[[item_price]]");
lm.carbon_purchase[29][0] = new String("[[item_weight]]");
lm.carbon_purchase[30][0] = new String("[[item_listing_id]]");
lm.carbon_purchase[31][0] = new String("[[item_notes]]");
lm.carbon_purchase[32][0] = new String("[[item_package_d]]");
lm.carbon_purchase[33][0] = new String("[[item_package_l]]");
lm.carbon_purchase[34][0] = new String("[[item_package_w]]");
lm.carbon_purchase[35][0] = new String("[[item_part_number]]");
lm.carbon_purchase[36][0] = new String("test sale");//
lm.carbon_purchase[37][0] = new String("[[item_title_url]]");
lm.carbon_purchase[38][0] = new String("[[item_type]]");
lm.carbon_purchase[39][0] = new String("[[item_search_1]]");
lm.carbon_purchase[40][0] = new String("[[item_search_2]]");
lm.carbon_purchase[41][0] = new String("[[item_search_3]]");
lm.carbon_purchase[42][0] = new String("[[item_site_id]]");
lm.carbon_purchase[43][0] = new String("[[item_site_url]]");
lm.carbon_purchase[44][0] = new String("[[item_picture_1]]");
lm.carbon_purchase[45][0] = new String("[[item_total_on_hand]]");
lm.carbon_purchase[46][0] = new String("[[sale_date_payment_received]]");
lm.carbon_purchase[47][0] = new String("[[sale_date_shipped]]");
lm.carbon_purchase[48][0] = new String("[[sale_date_sold]]");
lm.carbon_purchase[49][0] = new String("[[sale_final_value_fee]]");
lm.carbon_purchase[50][0] = new String("[[sale_handling]]");
lm.carbon_purchase[51][0] = new String("[[sale_payment_address]]");
lm.carbon_purchase[52][0] = new String("[[sale_payment_type]]");
lm.carbon_purchase[53][0] = new String("[[sale_fees]]");
lm.carbon_purchase[54][0] = new String("[[sale_quantity_sold]]");
lm.carbon_purchase[55][0] = new String("[[sale_id]]");
lm.carbon_purchase[56][0] = new String("[[sale_seller_id]]");
lm.carbon_purchase[57][0] = new String("[[sale_status]]");
lm.carbon_purchase[58][0] = new String("[[sale_tax]]");
lm.carbon_purchase[59][0] = new String("[[sale_shipping_company]]");
lm.carbon_purchase[60][0] = new String("[[sale_shipping_in]]");
lm.carbon_purchase[61][0] = new String("[[sale_shipping_out]]");
lm.carbon_purchase[62][0] = new String("[[sale_source_of_sale]]");
lm.carbon_purchase[63][0] = new String("[[sale_total_sale_amount]]");
lm.carbon_purchase[64][0] = new String("[[sale_tracking_number]]");
lm.carbon_purchase[65][0] = new String("[[sale_transaction_id]]");
lm.carbon_purchase[66][0] = new String("[[sale_transaction_info]]");
lm.carbon_purchase[67][0] = new String("[[seller_address_1]]");
lm.carbon_purchase[68][0] = new String("[[seller_address_2]]");
lm.carbon_purchase[69][0] = new String("[[seller_address_city]]");
lm.carbon_purchase[70][0] = new String("[[seller_address_state]]");
lm.carbon_purchase[71][0] = new String("[[seller_address_zip]]");
lm.carbon_purchase[72][0] = new String("[[seller_address_country]]");
lm.carbon_purchase[73][0] = new String("[[seller_id]]");
lm.carbon_purchase[74][0] = new String("[[seller_ip]]");
lm.carbon_purchase[75][0] = new String("[[seller_email]]");
lm.carbon_purchase[76][0] = new String("[[seller_first_name]]");
lm.carbon_purchase[77][0] = new String("[[seller_last_name]]");
lm.carbon_purchase[78][0] = new String("[[seller_notes]]");
lm.carbon_purchase[79][0] = new String("[[seller_phone]]");
lm.carbon_purchase[80][0] = new String("[[seller_logo]]");
lm.carbon_purchase[81][0] = new String("[[seller_url]]");




}//vm*****************************************************








}//last
