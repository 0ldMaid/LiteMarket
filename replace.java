import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;





public class replace extends JFrame implements ActionListener{




JFrame frame_1 = new JFrame();
//JFileChooser file_chooser = new JFileChooser(file_open_1);

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 380;
int xzy = 190;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

int runs = 50000;
String main = new String("");

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();
String cx3 = new String();
String cx4 = new String();

int section_number = 0;
int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int fg = 0;
int fs = 0;
int kcountxx = 0;
int kcountxx2 = 0;
int thisx = 0;
int loopc1 = 0;

JButton b0 = new JButton();
JButton b1 = new JButton();
JButton b2 = new JButton();
JButton b3 = new JButton();
JButton b4 = new JButton();
JButton b5 = new JButton();
JButton bx0 = new JButton();
JButton bx1 = new JButton();
JButton bx2 = new JButton();
JButton bx3 = new JButton();

JComboBox cb_column;
//JComboBox cb_sitese;

Label l0 = new Label();
Label l1 = new Label();
Label l2 = new Label();
Label l3 = new Label();
Label l4 = new Label();
Label btl0 = new Label();
Label btl1 = new Label();
Label btl2 = new Label();
Label btl3 = new Label();
Label btl4 = new Label();
Label btl5 = new Label();


JTextField sectionxa = new JTextField("", 15);
JTextField sectionxb = new JTextField("", 15);


String[][] carbonfiber = new String[0][0];
String[] silver = new String[0];
String[] gold = new String[runs];
String d1 = new String();
String d2 = new String();
String switchsx1 = new String("XMX.CSV");
String switchsx2 = new String("XMXR.CSV");
String rep1 = new String();
String rep2 = new String();
String rex = new String(".jpg.gif");
String rexw = new String("");


File filex1;
File filex2;
String str0;

Color c1 = new Color(0.1f, 0.1f, 0.1f);
Color c2 = new Color(0.09f, 0.09f, 0.13f);

Icon imx0;





	replace(){//********************************************************************************************************
	
	super("Replace");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){}});//



//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/qrcode.png")).getImage();
	setIconImage(ximagex);

//get button images from the Jar file.
	//imx0 = new ImageIcon(this.getClass().getResource("images/buttonimage.png"));


	b0 = new JButton("Replace");
	b0.setMargin(new Insets(0, 0, 0, 0));  
	b0.addActionListener(this);
	b0.setPreferredSize(new Dimension(70, 25));
	//b0.setIcon(imx0);
	b0.setHorizontalTextPosition(JButton.CENTER);
	b0.setBackground(lm.grayx3);
	b0.setForeground(Color.BLACK);

	b1 = new JButton("Undo");
	b1.setMargin(new Insets(0, 0, 0, 0));  
	b1.addActionListener(this);
	b1.setPreferredSize(new Dimension(70, 25));
	//b1.setIcon(imx0);
	b1.setHorizontalTextPosition(JButton.CENTER);
	b1.setBackground(lm.grayx3);
	b1.setForeground(Color.BLACK);
	b1.setEnabled(false);



	carbonfiber = lm.carbon_sell;
	silver = new String[carbonfiber.length];


	for(int xloop0 = 0; xloop0 < carbonfiber.length; xloop0++){//******

	silver[xloop0] = carbonfiber[xloop0][0];

	}//for


	try{
	ix0 = Integer.parseInt(lm.carbon_settings[28]);
	sectionxa.setText(lm.carbon_settings[29]);
	sectionxb.setText(lm.carbon_settings[30]);
	section_number = ix0;
	}catch(Exception e){ix0 = 1;}

	cb_column = new JComboBox(silver);

	try{
	cb_column.setSelectedIndex(ix0);
	}catch(Exception e){}

	cb_column.addActionListener(this);
	cb_column.setPreferredSize(new Dimension(360, 20));




	l0 = new Label("Select field, then search and replace.", Label.LEFT);
	l0.setPreferredSize(new Dimension(370, 20));
	l0.setBackground(lm.grayx3);
	l0.setForeground(Color.BLACK);

	l1 = new Label("Find:", Label.LEFT);
	l1.setPreferredSize(new Dimension(100, 20));
	l1.setBackground(lm.grayx3);
	l1.setForeground(Color.BLACK);

	l2 = new Label("Replace:", Label.LEFT);
	l2.setPreferredSize(new Dimension(100, 20));
	l2.setBackground(lm.grayx3);
	l2.setForeground(Color.BLACK);




        JPanel jp0 = new JPanel();
	jp0.setPreferredSize(new Dimension(370, 90));
	jp0.setBackground(lm.grayx3);
	jp0.add(l0);
	jp0.add(l1);  jp0.add(sectionxa);
	jp0.add(l2);  jp0.add(sectionxb);



        JPanel jp2 = new JPanel();
	jp2.setPreferredSize(new Dimension(370, 40));
	jp2.setBackground(lm.grayx3);
	jp2.add(b0);
	jp2.add(b1);


	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(lm.grayx2);
	cp.setForeground(lm.grayx2);
	cp.add(cb_column);
	cp.add(jp0);
	cp.add(jp2);



	setVisible(true);


	}//postid**************************************************************************************************************








	public void replacex(){

	System.out.println("section_number " + section_number);


	for (int loop0 = 1; loop0 < lm.carbon_sell[0].length; loop0++){


	cx1 = sectionxa.getText();
	cx2 = sectionxb.getText();
	l0.setText((loop0 * 100 / lm.carbon_sell[0].length) + "% Compleat."); 

	System.out.println("SS REPLACE");

	lm.carbon_sell[section_number][loop0] = lm.carbon_sell[section_number][loop0].replace(cx1,cx2);


	}//*************************************************************


	l0.setText("100% Complete."); 


	pullThePlug();

	}//********************










//handel all the button clicks. 
public void actionPerformed(ActionEvent event){




	if(event.getSource() == b0){replacex();}



	if(event.getSource() == cb_column){
           JComboBox cb = (JComboBox) event.getSource();
           Object newItem = cb.getSelectedItem();
	for (int loop1 = 0; loop1 < lm.carbon_sell.length; loop1++){//s1x

	if(lm.carbon_sell[loop1][0].equals(newItem)){section_number = loop1; System.out.println("yyyx " + loop1);}

	}//*****************************************************************
	
	}//not used






}//actionPerformed	
//***************************************************************************************************************************






    public static void main(String[] args){

	replace xr = new replace();

    }//main






    public void pullThePlug() {


    System.out.println("PULL THE PLUG");

    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull





}//last