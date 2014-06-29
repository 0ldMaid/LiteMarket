import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class edit_item extends JFrame{//************************************************************************

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
JLabel header3_l = new JLabel("custom_1", JLabel.RIGHT);
JLabel header4_l = new JLabel("custom_2", JLabel.RIGHT);
JLabel header5_l = new JLabel("custom_3", JLabel.RIGHT);
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
JLabel header27_l = new JLabel("item_search_1", JLabel.RIGHT);
JLabel header28_l = new JLabel("item_search_2", JLabel.RIGHT);
JLabel header29_l = new JLabel("item_search_3", JLabel.RIGHT);
JLabel header30_l = new JLabel("seller_id", JLabel.RIGHT);
JLabel header31_l = new JLabel("item_site_url", JLabel.RIGHT);
JLabel header32_l = new JLabel("picture_1", JLabel.RIGHT);
JLabel header33_l = new JLabel("item_total_on_hand", JLabel.RIGHT);




JTextField currency = new JTextField("", 8);
JTextField custom_template = new JTextField("", 28);
JTextField custom_1 = new JTextField("", 28);
JTextField custom_2 = new JTextField("", 28);
JTextField custom_3 = new JTextField("", 28);
JTextField item_errors = new JTextField("", 8);
JTextField item_date_listed = new JTextField("", 8);
JTextField item_date_listed_day = new JTextField("", 8);
JTextField item_date_listed_int = new JTextField("", 8);
JTextField hits = new JTextField("", 8);
JTextField item_confirm_code = new JTextField("", 8);
JTextField item_confirmed = new JTextField("", 8);
JTextField cost = new JTextField("", 8);
JTextArea item_description = new JTextArea("", 6, 40);
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
JTextField item_search_1 = new JTextField("", 28);
JTextField item_search_2 = new JTextField("", 28);
JTextField item_search_3 = new JTextField("", 28);
JTextField item_seller_id = new JTextField("", 28);
JTextField item_site_url = new JTextField("", 28);
JTextField picture_1 = new JTextField("", 28);
JTextField item_total_on_hand = new JTextField("", 8);






JLabel header1_space = new JLabel("", JLabel.LEFT);
JLabel header2_space = new JLabel("", JLabel.LEFT);
JLabel header3_space = new JLabel("", JLabel.LEFT);


int what_item_save = lm.what_item;









edit_item(){//****************************

	super("Edit item (null)");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, (ceny -10));
	setResizable(false);

        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x();}});


	what_item_save = lm.what_item;
	setTitle("Edit item (" + lm.carbon_sell[lm.item_part_number_xx][what_item_save] + ")");



//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	setIconImage(ximagex);




	header1_space.setPreferredSize(new Dimension(390, 10));
	header2_space.setPreferredSize(new Dimension(390, 10));
	header3_space.setPreferredSize(new Dimension(390, 10));








	header1_l.setPreferredSize(new Dimension(118, 20));
	header2_l.setPreferredSize(new Dimension(118, 20));
	header3_l.setPreferredSize(new Dimension(118, 20));
	header4_l.setPreferredSize(new Dimension(118, 20));
	header5_l.setPreferredSize(new Dimension(118, 20));
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
	header27_l.setPreferredSize(new Dimension(118, 20));
	header28_l.setPreferredSize(new Dimension(118, 20));
	header29_l.setPreferredSize(new Dimension(118, 20));
	header30_l.setPreferredSize(new Dimension(118, 20));
	header31_l.setPreferredSize(new Dimension(118, 20));
	header32_l.setPreferredSize(new Dimension(118, 20));
	header33_l.setPreferredSize(new Dimension(118, 20));



	currency.setText(lm.carbon_sell[lm.currency_xx][what_item_save]);
	currency.setBorder(BorderFactory.createLineBorder(whitex));

	custom_template.setText(lm.carbon_sell[lm.custom_template_xx][what_item_save]);
	custom_template.setBorder(BorderFactory.createLineBorder(whitex));

	custom_1.setText(lm.carbon_sell[lm.custom_1_xx][what_item_save]);
	custom_1.setBorder(BorderFactory.createLineBorder(whitex));

	custom_2.setText(lm.carbon_sell[lm.custom_2_xx][what_item_save]);
	custom_2.setBorder(BorderFactory.createLineBorder(whitex));

	custom_3.setText(lm.carbon_sell[lm.custom_3_xx][what_item_save]);
	custom_3.setBorder(BorderFactory.createLineBorder(whitex));

	item_errors.setText(lm.carbon_sell[lm.item_errors_xx][what_item_save]);
	item_errors.setBorder(BorderFactory.createLineBorder(whitex));

	item_date_listed.setText(lm.carbon_sell[lm.item_date_listed_xx][what_item_save]);
	item_date_listed.setBorder(BorderFactory.createLineBorder(whitex));

	item_date_listed_day.setText(lm.carbon_sell[lm.item_date_listed_day_xx][what_item_save]);
	item_date_listed_day.setBorder(BorderFactory.createLineBorder(whitex));

	item_date_listed_int.setText(lm.carbon_sell[lm.item_date_listed_int_xx][what_item_save]);
	item_date_listed_int.setBorder(BorderFactory.createLineBorder(whitex));

	hits.setText(lm.carbon_sell[lm.item_hits_xx][what_item_save]);
	hits.setBorder(BorderFactory.createLineBorder(whitex));

	item_confirm_code.setText(lm.carbon_sell[lm.item_confirm_code_xx][what_item_save]);
	item_confirm_code.setBorder(BorderFactory.createLineBorder(whitex));

	item_confirmed.setText(lm.carbon_sell[lm.item_confirmed_xx][what_item_save]);
	item_confirmed.setBorder(BorderFactory.createLineBorder(whitex));

	cost.setText(lm.carbon_sell[lm.item_cost_xx][what_item_save]);
	cost.setBorder(BorderFactory.createLineBorder(whitex));

	item_description.setText(lm.carbon_sell[lm.item_description_xx][what_item_save]);
	item_description.setBorder(BorderFactory.createLineBorder(whitex));
	item_description.setWrapStyleWord(true);
	item_description.setLineWrap(true);

	sale_price.setText(lm.carbon_sell[lm.item_price_xx][what_item_save]);
	sale_price.setBorder(BorderFactory.createLineBorder(whitex));

	weight.setText(lm.carbon_sell[lm.item_weight_xx][what_item_save]);
	weight.setBorder(BorderFactory.createLineBorder(whitex));

	item_listing_id.setText(lm.carbon_sell[lm.item_listing_id_xx][what_item_save]);
	item_listing_id.setBorder(BorderFactory.createLineBorder(whitex));

	item_notes.setText(lm.carbon_sell[lm.item_notes_xx][what_item_save]);
	item_notes.setBorder(BorderFactory.createLineBorder(whitex));

	item_package_d.setText(lm.carbon_sell[lm.item_package_d_xx][what_item_save]);
	item_package_d.setBorder(BorderFactory.createLineBorder(whitex));

	item_package_l.setText(lm.carbon_sell[lm.item_package_l_xx][what_item_save]);
	item_package_l.setBorder(BorderFactory.createLineBorder(whitex));

	item_package_w.setText(lm.carbon_sell[lm.item_package_w_xx][what_item_save]);
	item_package_w.setBorder(BorderFactory.createLineBorder(whitex));

	item_part_number.setText(lm.carbon_sell[lm.item_part_number_xx][what_item_save]);
	item_part_number.setBorder(BorderFactory.createLineBorder(whitex));

	title.setText(lm.carbon_sell[lm.item_title_xx][what_item_save]);
	title.setBorder(BorderFactory.createLineBorder(whitex));

	item_title_url.setText(lm.carbon_sell[lm.item_title_url_xx][what_item_save]);
	item_title_url.setBorder(BorderFactory.createLineBorder(whitex));

	item_type.setText(lm.carbon_sell[lm.item_type_xx][what_item_save]);
	item_type.setBorder(BorderFactory.createLineBorder(whitex));

	item_search_1.setText(lm.carbon_sell[lm.item_search_1_xx][what_item_save]);
	item_search_1.setBorder(BorderFactory.createLineBorder(whitex));

	item_search_2.setText(lm.carbon_sell[lm.item_search_2_xx][what_item_save]);
	item_search_2.setBorder(BorderFactory.createLineBorder(whitex));

	item_search_3.setText(lm.carbon_sell[lm.item_search_3_xx][what_item_save]);
	item_search_3.setBorder(BorderFactory.createLineBorder(whitex));

	item_site_url.setText(lm.carbon_sell[lm.item_site_url_xx][what_item_save]);
	item_site_url.setBorder(BorderFactory.createLineBorder(whitex));

	picture_1.setText(lm.carbon_sell[lm.item_picture_1_xx][what_item_save]);
	picture_1.setBorder(BorderFactory.createLineBorder(whitex));

	item_seller_id.setText(lm.carbon_sell[lm.seller_id_xx][what_item_save]);
	item_seller_id.setBorder(BorderFactory.createLineBorder(redx));
	item_seller_id.setBackground(redx);
	item_seller_id.setForeground(whitex);

	item_id.setText(lm.carbon_sell[lm.item_id_xx][what_item_save]);
	item_id.setBorder(BorderFactory.createLineBorder(redx));
	item_id.setBackground(redx);
	item_id.setForeground(whitex);

	item_total_on_hand.setText(lm.carbon_sell[lm.item_total_on_hand_xx][what_item_save]);
	item_total_on_hand.setBorder(BorderFactory.createLineBorder(whitex));



	JScrollPane scrollPaned = new JScrollPane(item_description);
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
	jpk2.add(header33_l);		jpk2.add(item_total_on_hand);
	jpk2.add(header13_l); 		jpk2.add(cost);
	jpk2.add(header16_l);		jpk2.add(sale_price);
	jpk2.add(header20_l);		jpk2.add(item_package_d);
	jpk2.add(header21_l);		jpk2.add(item_package_l);
	jpk2.add(header22_l);		jpk2.add(item_package_w);
	jpk2.add(header17_l); 		jpk2.add(weight);
	jpk2.add(header2_space);
	jpk2.add(scrollPaned);
	jpk2.add(header3_space);
	jpk2.add(header19_l);		jpk2.add(item_notes);
	jpk2.add(header27_l); 		jpk2.add(item_search_1);
	jpk2.add(header28_l);		jpk2.add(item_search_2);
	jpk2.add(header29_l);		jpk2.add(item_search_3);
	jpk2.add(header31_l);		jpk2.add(item_site_url);
	jpk2.add(header3_l);		jpk2.add(custom_1);
	jpk2.add(header4_l);		jpk2.add(custom_2);
	jpk2.add(header5_l);		jpk2.add(custom_3);
	jpk2.add(header30_l);		jpk2.add(item_seller_id);
	jpk2.add(header15_l);		jpk2.add(item_id);

	//jpk2.add(header6_l); 		jpk2.add(item_errors);
	//jpk2.add(header7_l);		jpk2.add(item_date_listed);
	//jpk2.add(header8_l);		jpk2.add(item_date_listed_day);
	//jpk2.add(header9_l);		jpk2.add(item_date_listed_int);
	//jpk2.add(header10_l);		jpk2.add(hits);
	//jpk2.add(header11_l);		jpk2.add(item_confirm_code);
	//jpk2.add(header12_l);		jpk2.add(item_confirmed);
	//jpk2.add(header18_l);		jpk2.add(item_listing_id);
	//jpk2.add(header25_l);		jpk2.add(item_title_url);
	//jpk2.add(header26_l);		jpk2.add(item_type);





	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(grayx2);
	cpx.setForeground(whitex);
	cpx.add(jpk2);


	setVisible(true);


	requestFocus();



}//csv_loader_x1********************************************************








	public void savex_x(){

	lm.carbon_sell[13][what_item_save] = currency.getText();
	lm.carbon_sell[14][what_item_save] = custom_template.getText();
	lm.carbon_sell[15][what_item_save] = custom_1.getText();
	lm.carbon_sell[16][what_item_save] = custom_2.getText();
	lm.carbon_sell[17][what_item_save] = custom_3.getText();
	lm.carbon_sell[18][what_item_save] = item_errors.getText();
	lm.carbon_sell[19][what_item_save] = item_date_listed.getText();
	lm.carbon_sell[20][what_item_save] = item_date_listed_day.getText();
	lm.carbon_sell[21][what_item_save] = item_date_listed_int.getText();
	lm.carbon_sell[22][what_item_save] = hits.getText();
	lm.carbon_sell[23][what_item_save] = item_confirm_code.getText();
	lm.carbon_sell[24][what_item_save] = item_confirmed.getText();
	lm.carbon_sell[25][what_item_save] = cost.getText();
	lm.carbon_sell[26][what_item_save] = item_description.getText();
	lm.carbon_sell[27][what_item_save] = item_id.getText();
	lm.carbon_sell[28][what_item_save] = sale_price.getText();
	lm.carbon_sell[29][what_item_save] = weight.getText();
	lm.carbon_sell[30][what_item_save] = item_listing_id.getText();
	lm.carbon_sell[31][what_item_save] = item_notes.getText();
	lm.carbon_sell[32][what_item_save] = item_package_d.getText();
	lm.carbon_sell[33][what_item_save] = item_package_l.getText();
	lm.carbon_sell[34][what_item_save] = item_package_w.getText();
	lm.carbon_sell[35][what_item_save] = item_part_number.getText();
	lm.carbon_sell[36][what_item_save] = title.getText();
	lm.carbon_sell[37][what_item_save] = item_title_url.getText();
	lm.carbon_sell[38][what_item_save] = item_type.getText();
	lm.carbon_sell[39][what_item_save] = item_search_1.getText();
	lm.carbon_sell[40][what_item_save] = item_search_2.getText();
	lm.carbon_sell[41][what_item_save] = item_search_3.getText();
	lm.carbon_sell[lm.seller_id_xx][what_item_save] = item_seller_id.getText();
	lm.carbon_sell[43][what_item_save] = item_site_url.getText();
	lm.carbon_sell[44][what_item_save] = picture_1.getText();
	lm.carbon_sell[45][what_item_save] = item_total_on_hand.getText();

	}//savex






    public static void main(){

	edit_item xr = new edit_item();

    }//main










}//last****************************************