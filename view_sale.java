import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class view_sale extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 500;
int xzy = 640;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);



Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color grayx1 = new Color(0.7f, 0.7f, 0.7f);
Color grayx2 = new Color(0.6f, 0.6f, 0.6f);
Color xstripesc = new Color(0.0f, 0.0f, 0.0f);
Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color greenx = new Color(0.15f, 0.6f, 0.25f);
Color redx = new Color(0.9f, 0.1f, 0.1f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color grayxb = new Color(0.6f, 0.6f, 0.6f);
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


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");




JLabel header1_l = new JLabel("currency", JLabel.RIGHT);
JLabel header2_l = new JLabel("custom_template", JLabel.RIGHT);
JLabel header6_l = new JLabel("item_errors", JLabel.RIGHT);
JLabel header7_l = new JLabel("item_date_listed", JLabel.RIGHT);
JLabel header8_l = new JLabel("item_date_listed_day", JLabel.RIGHT);
JLabel header9_l = new JLabel("item_date_listed_int", JLabel.RIGHT);
JLabel header10_l = new JLabel("hits", JLabel.RIGHT);
JLabel header11_l = new JLabel("item_confirm_code", JLabel.RIGHT);
JLabel header12_l = new JLabel("item_confirmed", JLabel.RIGHT);
JLabel header13_l = new JLabel("cost", JLabel.RIGHT);
JLabel header14_l = new JLabel("item_description", JLabel.RIGHT);
JLabel header15_l = new JLabel("item_id", JLabel.RIGHT);
JLabel header16_l = new JLabel("sale_price", JLabel.RIGHT);
JLabel header17_l = new JLabel("weight", JLabel.RIGHT);
JLabel header18_l = new JLabel("item_listing_id", JLabel.RIGHT);
JLabel header19_l = new JLabel("item_notes", JLabel.RIGHT);
JLabel header20_l = new JLabel("item_package_d", JLabel.RIGHT);
JLabel header21_l = new JLabel("item_package_l", JLabel.RIGHT);
JLabel header22_l = new JLabel("item_package_w", JLabel.RIGHT);
JLabel header23_l = new JLabel("item_part_number", JLabel.RIGHT);
JLabel header24_l = new JLabel("title", JLabel.RIGHT);
JLabel header25_l = new JLabel("item_title_url", JLabel.RIGHT);
JLabel header26_l = new JLabel("item_type", JLabel.RIGHT);
JLabel header30_l = new JLabel("seller_id", JLabel.RIGHT);
JLabel header31_l = new JLabel("item_site_url", JLabel.RIGHT);
JLabel header32_l = new JLabel("picture_1", JLabel.RIGHT);
JLabel header33_l = new JLabel("sale_quantity_sold", JLabel.RIGHT);

JLabel header34_l = new JLabel("payment_address", JLabel.RIGHT);
JLabel header35_l = new JLabel("sale_id", JLabel.RIGHT);
JLabel header36_l = new JLabel("seller_id", JLabel.RIGHT);
JLabel header37_l = new JLabel("sale_status", JLabel.RIGHT);
JLabel header38_l = new JLabel("shipping_company", JLabel.RIGHT);
JLabel header39_l = new JLabel("tracking_number", JLabel.RIGHT);
JLabel header40_l = new JLabel("transaction_id", JLabel.RIGHT);
JLabel header41_l = new JLabel("transaction_info", JLabel.RIGHT);





JTextField currency = new JTextField("", 8);
JTextField custom_template = new JTextField("", 28);
JTextField item_errors = new JTextField("", 8);
JTextField item_date_listed = new JTextField("", 8);
JTextField item_date_listed_day = new JTextField("", 8);
JTextField item_date_listed_int = new JTextField("", 8);
JTextField hits = new JTextField("", 8);
JTextField item_confirm_code = new JTextField("", 8);
JTextField item_confirmed = new JTextField("", 8);
JTextField cost = new JTextField("", 8);
JTextArea addressb = new JTextArea("", 6, 40);
JTextField item_id = new JTextField("", 28);
JTextField sale_price = new JTextField("", 8);
JTextField weight = new JTextField("", 8);
JTextField item_listing_id = new JTextField("", 28);
JTextField item_notes = new JTextField("", 28);
JTextField item_package_d = new JTextField("", 8);
JTextField item_package_l = new JTextField("", 8);
JTextField item_package_w = new JTextField("", 8);
JTextField item_part_number = new JTextField("", 28);
JTextField title = new JTextField("", 28);
JTextField item_title_url = new JTextField("", 28);
JTextField item_type = new JTextField("", 8);
JTextField item_seller_id = new JTextField("", 28);
JTextField item_site_url = new JTextField("", 28);
JTextField picture_1 = new JTextField("", 28);
JTextField sale_quantity_sold = new JTextField("", 8);

JTextField sale_payment_address = new JTextField("", 28);
JTextField sale_id = new JTextField("", 28);
JTextField sale_seller_id = new JTextField("", 28);
JTextField sale_status = new JTextField("", 28);
JTextField sale_shipping_company = new JTextField("", 28);
JTextField sale_tracking_number = new JTextField("", 28);
JTextField sale_transaction_id = new JTextField("", 28);
JTextField sale_transaction_info = new JTextField("", 28);






JLabel header1_space = new JLabel("", JLabel.LEFT);
JLabel header2_space = new JLabel("", JLabel.LEFT);
JLabel header3_space = new JLabel("", JLabel.LEFT);


int what_item_save = 0;









view_sale(){//****************************

	super("view Sale (null)");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, (ceny -10));
	setResizable(false);

        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){}});


	what_item_save = lm.what_item;
	setTitle("View Sale (" + lm.carbon_sold[lm.sale_id_xx][what_item_save] + ")");



//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	setIconImage(ximagex);




	header1_space.setPreferredSize(new Dimension(390, 10));
	header2_space.setPreferredSize(new Dimension(390, 10));
	header3_space.setPreferredSize(new Dimension(390, 10));








	header1_l.setPreferredSize(new Dimension(118, 20));
	header2_l.setPreferredSize(new Dimension(118, 20));

	header6_l.setPreferredSize(new Dimension(118, 20));
	header7_l.setPreferredSize(new Dimension(118, 20));
	header8_l.setPreferredSize(new Dimension(118, 20));
	header9_l.setPreferredSize(new Dimension(118, 20));
	header10_l.setPreferredSize(new Dimension(118, 20));
	header11_l.setPreferredSize(new Dimension(118, 20));
	header12_l.setPreferredSize(new Dimension(118, 20));
	header13_l.setPreferredSize(new Dimension(118, 20));
	header14_l.setPreferredSize(new Dimension(118, 20));
	header15_l.setPreferredSize(new Dimension(118, 20));
	header16_l.setPreferredSize(new Dimension(118, 20));
	header17_l.setPreferredSize(new Dimension(118, 20));
	header18_l.setPreferredSize(new Dimension(118, 20));
	header19_l.setPreferredSize(new Dimension(118, 20));
	header20_l.setPreferredSize(new Dimension(118, 20));
	header21_l.setPreferredSize(new Dimension(118, 20));
	header22_l.setPreferredSize(new Dimension(118, 20));
	header23_l.setPreferredSize(new Dimension(118, 20));
	header24_l.setPreferredSize(new Dimension(118, 20));
	header25_l.setPreferredSize(new Dimension(118, 20));
	header26_l.setPreferredSize(new Dimension(118, 20));

	header30_l.setPreferredSize(new Dimension(118, 20));
	header31_l.setPreferredSize(new Dimension(118, 20));
	header32_l.setPreferredSize(new Dimension(118, 20));
	header33_l.setPreferredSize(new Dimension(118, 20));

	header34_l.setPreferredSize(new Dimension(118, 20));
	header35_l.setPreferredSize(new Dimension(118, 20));
	header36_l.setPreferredSize(new Dimension(118, 20));
	header37_l.setPreferredSize(new Dimension(118, 20));
	header38_l.setPreferredSize(new Dimension(118, 20));
	header39_l.setPreferredSize(new Dimension(118, 20));
	header40_l.setPreferredSize(new Dimension(118, 20));
	header41_l.setPreferredSize(new Dimension(118, 20));



	String address_x = new String(lm.carbon_sold[lm.buyers_first_name_xx][what_item_save] + " " + lm.carbon_sold[lm.buyers_last_name_xx][what_item_save] + "\n");
	address_x += new String(lm.carbon_sold[lm.buyer_address_1_xx][what_item_save]);

	if(lm.carbon_sold[lm.buyer_address_2_xx][what_item_save].length() > 1){address_x = address_x + ", " + lm.carbon_sold[lm.buyer_address_2_xx][what_item_save] + "\n";}
	else{address_x = address_x + "\n";}

	address_x += new String(lm.carbon_sold[lm.buyer_address_city_xx][what_item_save] + ", ");
	address_x += new String(lm.carbon_sold[lm.buyer_address_state_xx][what_item_save] + " ");
	address_x += new String(lm.carbon_sold[lm.buyer_address_zip_xx][what_item_save] + "\n");
	address_x += new String(lm.carbon_sold[lm.buyer_address_country_xx][what_item_save]);






	currency.setText(lm.carbon_sold[lm.currency_xx][what_item_save]);
	currency.setBorder(BorderFactory.createLineBorder(whitex));

	custom_template.setText(lm.carbon_sold[lm.custom_template_xx][what_item_save]);
	custom_template.setBorder(BorderFactory.createLineBorder(whitex));

	item_errors.setText(lm.carbon_sold[lm.item_errors_xx][what_item_save]);
	item_errors.setBorder(BorderFactory.createLineBorder(whitex));

	item_date_listed.setText(lm.carbon_sold[lm.item_date_listed_xx][what_item_save]);
	item_date_listed.setBorder(BorderFactory.createLineBorder(whitex));

	item_date_listed_day.setText(lm.carbon_sold[lm.item_date_listed_day_xx][what_item_save]);
	item_date_listed_day.setBorder(BorderFactory.createLineBorder(whitex));

	item_date_listed_int.setText(lm.carbon_sold[lm.item_date_listed_int_xx][what_item_save]);
	item_date_listed_int.setBorder(BorderFactory.createLineBorder(whitex));

	hits.setText(lm.carbon_sold[lm.item_hits_xx][what_item_save]);
	hits.setBorder(BorderFactory.createLineBorder(whitex));

	item_confirm_code.setText(lm.carbon_sold[lm.item_confirm_code_xx][what_item_save]);
	item_confirm_code.setBorder(BorderFactory.createLineBorder(whitex));

	item_confirmed.setText(lm.carbon_sold[lm.item_confirmed_xx][what_item_save]);
	item_confirmed.setBorder(BorderFactory.createLineBorder(whitex));

	cost.setText(lm.carbon_sold[lm.item_cost_xx][what_item_save]);
	cost.setBorder(BorderFactory.createLineBorder(whitex));

	addressb.setText(address_x);
	addressb.setBorder(BorderFactory.createLineBorder(whitex));
	addressb.setWrapStyleWord(true);
	addressb.setLineWrap(true);

	sale_price.setText(lm.carbon_sold[lm.item_price_xx][what_item_save]);
	sale_price.setBorder(BorderFactory.createLineBorder(whitex));

	weight.setText(lm.carbon_sold[lm.item_weight_xx][what_item_save]);
	weight.setBorder(BorderFactory.createLineBorder(whitex));

	item_listing_id.setText(lm.carbon_sold[lm.item_listing_id_xx][what_item_save]);
	item_listing_id.setBorder(BorderFactory.createLineBorder(whitex));

	item_notes.setText(lm.carbon_sold[lm.item_notes_xx][what_item_save]);
	item_notes.setBorder(BorderFactory.createLineBorder(whitex));

	item_package_d.setText(lm.carbon_sold[lm.item_package_d_xx][what_item_save]);
	item_package_d.setBorder(BorderFactory.createLineBorder(whitex));

	item_package_l.setText(lm.carbon_sold[lm.item_package_l_xx][what_item_save]);
	item_package_l.setBorder(BorderFactory.createLineBorder(whitex));

	item_package_w.setText(lm.carbon_sold[lm.item_package_w_xx][what_item_save]);
	item_package_w.setBorder(BorderFactory.createLineBorder(whitex));

	item_part_number.setText(lm.carbon_sold[lm.item_part_number_xx][what_item_save]);
	item_part_number.setBorder(BorderFactory.createLineBorder(whitex));

	title.setText(lm.carbon_sold[lm.item_title_xx][what_item_save]);
	title.setBorder(BorderFactory.createLineBorder(whitex));

	item_title_url.setText(lm.carbon_sold[lm.item_title_url_xx][what_item_save]);
	item_title_url.setBorder(BorderFactory.createLineBorder(whitex));

	item_type.setText(lm.carbon_sold[lm.item_type_xx][what_item_save]);
	item_type.setBorder(BorderFactory.createLineBorder(whitex));

	item_site_url.setText(lm.carbon_sold[lm.item_site_url_xx][what_item_save]);
	item_site_url.setBorder(BorderFactory.createLineBorder(whitex));

	picture_1.setText(lm.carbon_sold[lm.item_picture_1_xx][what_item_save]);
	picture_1.setBorder(BorderFactory.createLineBorder(whitex));

	item_seller_id.setText(lm.carbon_sold[lm.seller_id_xx][what_item_save]);
	item_seller_id.setBorder(BorderFactory.createLineBorder(redx));
	item_seller_id.setBackground(redx);
	item_seller_id.setForeground(whitex);

	item_id.setText(lm.carbon_sold[lm.item_id_xx][what_item_save]);
	item_id.setBorder(BorderFactory.createLineBorder(redx));
	item_id.setBackground(redx);
	item_id.setForeground(whitex);

	sale_quantity_sold.setText(lm.carbon_sold[lm.sale_quantity_sold_xx][what_item_save]);
	sale_quantity_sold.setBorder(BorderFactory.createLineBorder(whitex));






	sale_payment_address.setText(lm.carbon_sold[lm.seller_id_xx][what_item_save]);
	sale_payment_address.setBorder(BorderFactory.createLineBorder(whitex));

	sale_id.setText(lm.carbon_sold[lm.sale_id_xx][what_item_save]);
	sale_id.setBorder(BorderFactory.createLineBorder(whitex));

	sale_seller_id.setText(lm.carbon_sold[lm.seller_first_name_xx][what_item_save]);
	sale_seller_id.setBorder(BorderFactory.createLineBorder(whitex));

	sale_status.setText(lm.carbon_sold[lm.sale_status_xx][what_item_save]);
	sale_status.setBorder(BorderFactory.createLineBorder(whitex));

	sale_shipping_company.setText(lm.carbon_sold[lm.sale_shipping_company_xx][what_item_save]);
	sale_shipping_company.setBorder(BorderFactory.createLineBorder(whitex));

	sale_tracking_number.setText(lm.carbon_sold[lm.sale_tracking_number_xx][what_item_save]);
	sale_tracking_number.setBorder(BorderFactory.createLineBorder(whitex));

	sale_transaction_id.setText(lm.carbon_sold[lm.sale_transaction_id_xx][what_item_save]);
	sale_transaction_id.setBorder(BorderFactory.createLineBorder(whitex));

	sale_transaction_info.setText(lm.carbon_sold[lm.sale_transaction_info_xx][what_item_save]);
	sale_transaction_info.setBorder(BorderFactory.createLineBorder(whitex));









	JScrollPane scrollPaned = new JScrollPane(addressb);
	scrollPaned.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPaned.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPaned.setFont(new Font("Arial", Font.PLAIN, 14));




	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(490, 620));
	jpk2.setBackground(grayx2);//darkgray08
	jpk2.add(header24_l);		jpk2.add(title);
	jpk2.add(header23_l); 		jpk2.add(item_part_number);
	jpk2.add(header32_l);		jpk2.add(picture_1);
	jpk2.add(header2_l); 		jpk2.add(custom_template);
	jpk2.add(header1_space);
	jpk2.add(header1_l);		jpk2.add(currency);
	jpk2.add(header33_l);		jpk2.add(sale_quantity_sold);
	jpk2.add(header13_l); 		jpk2.add(cost);
	jpk2.add(header16_l);		jpk2.add(sale_price);
	jpk2.add(header20_l);		jpk2.add(item_package_d);
	jpk2.add(header21_l);		jpk2.add(item_package_l);
	jpk2.add(header22_l);		jpk2.add(item_package_w);
	jpk2.add(header17_l); 		jpk2.add(weight);
	jpk2.add(header2_space);
	jpk2.add(scrollPaned);
	jpk2.add(header3_space);
	jpk2.add(header34_l);		jpk2.add(sale_payment_address);
	jpk2.add(header35_l);		jpk2.add(sale_id);
	jpk2.add(header36_l);		jpk2.add(sale_seller_id);
	jpk2.add(header37_l);		jpk2.add(sale_status);
	jpk2.add(header38_l);		jpk2.add(sale_shipping_company);
	jpk2.add(header39_l);		jpk2.add(sale_tracking_number);
	jpk2.add(header40_l);		jpk2.add(sale_transaction_id);
	jpk2.add(header41_l);		jpk2.add(sale_transaction_info);





	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(grayx2);
	cpx.setForeground(whitex);
	cpx.add(jpk2);


	setVisible(true);


	requestFocus();



}//csv_loader_x1********************************************************










    public static void main(){

	view_sale xr = new view_sale();

    }//main










}//last****************************************