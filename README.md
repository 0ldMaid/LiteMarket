<h1>
<a name="user-content-litemarket" class="anchor" href="#litemarket" aria-hidden="true"><span class="octicon octicon-link"></span></a>LiteMarket</h1>

<p>Bitcoin sales platform</p>

<p>The Litemarket platform is intended to make setting up a small Bitcoin shop simple. Rather then relying on old website building tools and complicated payment systems, Litemarket is a desktop server application allowing buyers and sellers to connect on a small scale. Site by site. </p>

<p>The platform can be used as a shop server for buyers to connect to, or can be used by buyers to connect to another friend's shop. All requests are JSON requests back and forth between the programs. The server program must have the ability to receive incoming socket connections just like a website server. If your using 3G or behind some router you probably won't be able to host a shop. Buyers should have no trouble connecting to an established store. </p>

<p>Litemarket is a breakdown of the website to it's simplest parts. A database, and a way to view it's contents. When you go to a website they have great graphics and logos, videos everywhere and all kinds of extra stuff. Although that stuff looks great and helps to calm your fears of entering your credit card info. In the world of Bitcoin it's not necessary. I always hear people talking about how they want Amazon or eBay to accept Bitcoin. But I really think the point of Bitcoin is that you don't need those big systems anymore. They where built to make it easy to buy and sell in a dangerous internet age. Bitcoin will make the process of payments on the internet a simple one on a world scale. And I think this kind of personal sales platform goes along with the idea well. </p>

<p>Donate: 18WcknETBsjEB5JfdXipyExrjKkjP8N6XG</p>
<br>

<p>TOR torrc file</p>
You can use TOR to host your store from any computer with any internet connection. The LiteMarket can connect to stores using Orchid, but to host your store you need to download TOR.
And change the torrc file to these settings.

HiddenServiceDir C:\Users\...YOUR DOCUMENTS!...\Documents\tor\hidden_service<br>
HiddenServicePort 80 127.0.0.1:55555
<br>
If your internet connection is slow you maybe run into trouble loading the TOR files. If LiteMarket cannot connect to TOR, try searching for "Orchid" in windows and then deleting the files in that folder. Restart LiteMarket.
<br>

<p>JRE Notes.</p>
The Java JRE 7 that is packaged with the installer has 2 changes that would need to be added on your system as well if you want to use your own JRE. The Extensions, and the COMODO site certificate for Blockchain.info. At the time of writing the JRE 7 Doesn't have a certificate for Blockchain.info if you try to connect through https you'll get errors. You don't need this if your using the Bitcoin qt as your wallet. 

<br>
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



<br>
Database Structure.

	[[buyer_address_1]]
	[[buyer_address_2]]
	[[buyer_address_city]]
	[[buyer_address_state]]
	[[buyer_address_zip]]
	[[buyer_address_country]]
	[[buyer_id]]
	[[buyer_ip]]
	[[buyers_email]]
	[[buyers_first_name]]
	[[buyers_last_name]]
	[[buyers_payment_address]]
	[[buyers_phone]]
	[[currency]]
	[[custom_template]]
	[[custom_1]]
	[[custom_2]]
	[[custom_3]]
	[[item_errors]]
	[[item_date_listed]]
	[[item_date_listed_day]]
	[[item_date_listed_int]]
	[[item_hits]]
	[[item_confirm_code]]
	[[item_confirmed]]
	[[item_cost]]
	[[item_description]]
	[[item_id]]
	[[item_price]]
	[[item_weight]]
	[[item_listing_id]]
	[[item_notes]]
	[[item_package_d]]
	[[item_package_l]]
	[[item_package_w]]
	[[item_part_number]]
	[[item_title]]
	[[item_title_url]]
	[[item_type]]
	[[item_search_1]]
	[[item_search_2]]
	[[item_search_3]]
	[[item_site_id]]
	[[item_site_url]]
	[[item_picture_1]]
	[[item_total_on_hand]]
	[[sale_date_payment_received]]
	[[sale_date_shipped]]
	[[sale_date_sold]]
	[[sale_final_value_fee]]
	[[sale_handling]]
	[[sale_payment_address]]
	[[sale_payment_type]]
	[[sale_fees]]
	[[sale_quantity_sold]]
	[[sale_id]]
	[[sale_seller_id]]
	[[sale_status]]
	[[sale_tax]]
	[[sale_shipping_company]]
	[[sale_shipping_in]]
	[[sale_shipping_out]]
	[[sale_source_of_sale]]
	[[sale_total_sale_amount]]
	[[sale_tracking_number]]
	[[sale_transaction_id]]
	[[sale_transaction_info]]
	[[seller_address_1]]
	[[seller_address_2]]
	[[seller_address_city]]
	[[seller_address_state]]
	[[seller_address_zip]]
	[[seller_address_country]]
	[[seller_id]]
	[[seller_ip]]
	[[seller_email]]
	[[seller_first_name]]
	[[seller_last_name]]
	[[seller_notes]]
	[[seller_phone]]
	[[seller_logo]]
	[[seller_url]]

