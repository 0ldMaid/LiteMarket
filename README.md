<h1>
<a name="user-content-litemarket" class="anchor" href="#litemarket" aria-hidden="true"><span class="octicon octicon-link"></span></a>LiteMarket</h1>

<p>Bitcoin sales platform</p>

<p>The Litemarket platform is intended to make setting up a small Bitcoin shop simple. Rather then relying on old website building tools and complicated payment systems, Litemarket is a desktop server application allowing buyers and sellers to connect on a small scale. Site by site. </p>

<p>The platform can be used as a shop server for buyers to connect to, or can be used by buyers to connect to another friend's shop. All requests are JSON requests back and forth between the programs. The server program must have the ability to receive incoming socket connections just like a website server. If your using 3G or behind some router you probably won't be able to host a shop. Buyers should have no trouble connecting to an established store. </p>

<p>Litemarket is a breakdown of the website to it's simplest parts. A database, and a way to view it's contents. When you go to a website they have great graphics and logos, videos everywhere and all kinds of extra stuff. Although that stuff looks great and helps to calm your fears of entering your credit card info. In the world of Bitcoin it's not necessary. I always hear people talking about how they want Amazon or eBay to except Bitcoin. But I really think the point of Bitcoin is that you don't need those big systems anymore. They where built to make it easy to buy and sell in a dangerous internet age. Bitcoin will make the process of payments on the internet a simple one on a world scale. And I think this kind of personal sales platform goes along with the idea well. </p>

<p>When I first learned to make websites I remember thinking how easy it was. How I had looked at these sites for so long, amazed at the skill. And then after taking a 1 hour html online class realized I could do the same. Then later, it all came crashing down when I learned that if you want your website to accept payments...... you needed to be smart. Money on the internet is difficult, it wasn't made with that in mind. Bitcoin was built just for that need. And I think the old website model will change as well, as we learn we no longer need these complicated checkout carts. </p>

<p>Donate: 18WcknETBsjEB5JfdXipyExrjKkjP8N6XG</p>



RPC commands.

    lmx_active              program active or not returns error or 1
    lmx_get_info            returns program info

    lmx_get_items_count     returns the items count for database 0
    lmx_get_item_x          returns info about a given item by by ID

    lmx_get_sales_count     returns the sales count
    lmx_get_sale_x          returns info about a given sale by sale ID
    lmx_confirm_sales       confirms payment for items
    lmx_confirm_shipped     confirms item shipped

    lmx_get_purchase_count  returns the purchased items count
    lmx_get_purchase_x      returns a purchase by ID
    
    lmx_get_balance         gets the balance shown in the program
    lmx_refresh_balance     refreshes the balance from the connected wallet
    lmx_get_store           gets the store name
    lmx_get_wallet_type     gets the wallet type connected to the program blockchain.info or bitcoind

    lmx_add_item            adds a new item from info provided
    lmx_edit_item           edit an item by ID




Database Structure.

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

