import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class btcinfo_settings extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 400;
int xzy = 400;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);



Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color grayx1 = new Color(0.7f, 0.7f, 0.7f);
Color grayx2 = new Color(0.6f, 0.6f, 0.6f);



String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");





JLabel header1_lx = new JLabel("name", JLabel.RIGHT);
JLabel header2_lx = new JLabel("address 1", JLabel.RIGHT);
JLabel header3_lx = new JLabel("city", JLabel.RIGHT);
JLabel header4_lx = new JLabel("state", JLabel.RIGHT);
JLabel header5_lx = new JLabel("zip", JLabel.RIGHT);
JLabel header6_lx = new JLabel("country", JLabel.RIGHT);

JTextField add_name = new JTextField("", 15);
JTextField add_add1 = new JTextField("", 15);
JTextField add_city = new JTextField("", 15);
JTextField add_state = new JTextField("", 15);
JTextField add_zip = new JTextField("", 15);
JTextField add_country = new JTextField("", 15);


JLabel header1_l = new JLabel("btc_url", JLabel.RIGHT);
JLabel header2_l = new JLabel("btc_address", JLabel.RIGHT);
JLabel header3_l = new JLabel("btc_user", JLabel.RIGHT);
JLabel header4_l = new JLabel("btc_password", JLabel.RIGHT);

JTextField btc_url = new JTextField("URL", 15);
JTextField btc_address = new JTextField("Address", 15);
JTextField btc_user = new JTextField("User", 15);
JTextField btc_password = new JTextField("Password", 15);


JLabel header1_lxx = new JLabel("e-mail", JLabel.RIGHT);
JLabel header2_lxx = new JLabel("e-mail", JLabel.RIGHT);

JTextField user_email = new JTextField("", 15);
JTextField user_ = new JTextField("", 15);









JLabel header0_space = new JLabel("", JLabel.LEFT);
JLabel header1_space = new JLabel("", JLabel.LEFT);
JLabel header2_space = new JLabel("", JLabel.LEFT);
JLabel header3_space = new JLabel("", JLabel.LEFT);







btcinfo_settings(){//****************************

	super("Blockchain Info/User Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x();}});





//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	setIconImage(ximagex);



	header0_space.setPreferredSize(new Dimension(290, 20));
	header1_space.setPreferredSize(new Dimension(290, 20));
	header2_space.setPreferredSize(new Dimension(290, 20));
	header3_space.setPreferredSize(new Dimension(290, 20));





	header1_lx.setPreferredSize(new Dimension(90, 20));
	header2_lx.setPreferredSize(new Dimension(90, 20));
	header3_lx.setPreferredSize(new Dimension(90, 20));
	header4_lx.setPreferredSize(new Dimension(90, 20));
	header5_lx.setPreferredSize(new Dimension(90, 20));
	header6_lx.setPreferredSize(new Dimension(90, 20));

	add_name.setText(lm.carbon_settings[14]);
	add_add1.setText(lm.carbon_settings[15]);
	add_city.setText(lm.carbon_settings[16]);
	add_state.setText(lm.carbon_settings[17]);
	add_zip.setText(lm.carbon_settings[18]);
	add_country.setText(lm.carbon_settings[19]);

	add_name.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	add_add1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	add_city.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	add_state.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	add_zip.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	add_country.setBorder(BorderFactory.createLineBorder(Color.WHITE));





	header1_l.setPreferredSize(new Dimension(90, 20));
	header2_l.setPreferredSize(new Dimension(90, 20));
	header3_l.setPreferredSize(new Dimension(90, 20));
	header4_l.setPreferredSize(new Dimension(90, 20));


	btc_url.setEnabled(false);
	btc_url.setText("https://blockchain.info");
	btc_address.setText(lm.carbon_settings[11]);
	btc_user.setText(lm.carbon_settings[12]);
	btc_password.setText(lm.carbon_settings[13]);

	btc_url.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	btc_address.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	btc_user.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	btc_password.setBorder(BorderFactory.createLineBorder(Color.WHITE));



	header1_lxx.setPreferredSize(new Dimension(90, 20));
	header2_lxx.setPreferredSize(new Dimension(90, 20));

	user_email.setText(lm.carbon_settings[20]);
	user_email.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	user_.setText(lm.carbon_settings[21]);









	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(350, 380));
	jpk2.setBackground(grayx2);//darkgray08
	jpk2.add(header0_space);
	jpk2.add(header1_lx);		jpk2.add(add_name);
	jpk2.add(header2_lx); 		jpk2.add(add_add1);
	jpk2.add(header3_lx);		jpk2.add(add_city);
	jpk2.add(header4_lx);		jpk2.add(add_state);
	jpk2.add(header5_lx);		jpk2.add(add_zip);
	jpk2.add(header6_lx);		jpk2.add(add_country);
	jpk2.add(header1_space);
	jpk2.add(header1_l);		jpk2.add(btc_url);
	jpk2.add(header2_l); 		jpk2.add(btc_address);
	jpk2.add(header3_l);		jpk2.add(btc_user);
	jpk2.add(header4_l);		jpk2.add(btc_password);
	jpk2.add(header2_space);
	jpk2.add(header1_lxx);		jpk2.add(user_email);
	//jpk2.add(header2_lxx);		jpk2.add(user_);



	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(grayx2);
	cpx.setForeground(whitex);
	cpx.add(jpk2);


	setVisible(true);


	requestFocus();



}//csv_loader_x1********************************************************








	public void savex_x(){

	lm.carbon_settings[10] = btc_url.getText();
	lm.carbon_settings[11] = btc_address.getText();
	lm.carbon_settings[12] = btc_user.getText();
	lm.carbon_settings[13] = btc_password.getText();

	lm.carbon_settings[14] = add_name.getText();
	lm.carbon_settings[15] = add_add1.getText();
	lm.carbon_settings[16] = add_city.getText();
	lm.carbon_settings[17] = add_state.getText();
	lm.carbon_settings[18] = add_zip.getText();
	lm.carbon_settings[19] = add_country.getText();

	lm.carbon_settings[20] = user_email.getText();
	lm.carbon_settings[21] = user_.getText();

	}//savex






    public static void main(){

	btcinfo_settings xr = new btcinfo_settings();

    }//main










}//last****************************************