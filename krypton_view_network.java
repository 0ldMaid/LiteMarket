import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;







public class krypton_view_network extends JFrame{//************************************************************************

Timer xtimerx;//class loop.
Toolkit toolkit;

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 600;
int xzy = 640;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

int refresh_1 = 0;

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



Font f_01 = new Font("Arial", Font.PLAIN, 10);







JLabel header1_space = new JLabel("ID", JLabel.LEFT);
JLabel header2_space = new JLabel("IP ADDRESS", JLabel.LEFT);
JLabel header3_space = new JLabel("NETWORK KEY", JLabel.LEFT);
JLabel header4_space = new JLabel("", JLabel.LEFT);




JLabel[][] ip_log_book = new JLabel[3][100];






krypton_view_network(){//****************************

	super("View Network");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, (ceny -10));
	setResizable(false);

        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){refresh_1 = 0;}});




//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/hex.png")).getImage();
	setIconImage(ximagex);




	header1_space.setPreferredSize(new Dimension(150, 15));
	header2_space.setPreferredSize(new Dimension(200, 15));
	header3_space.setPreferredSize(new Dimension(100, 15));
	header4_space.setPreferredSize(new Dimension(100, 15));




	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(490, 2000));
	jpk1.setBackground(grayx1);//darkgray08


	JScrollPane scrollPaned = new JScrollPane(jpk1);
	scrollPaned.setPreferredSize(new Dimension(xzx -5, xzy -85));
	scrollPaned.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPaned.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPaned.setFont(new Font("Arial", Font.PLAIN, 14));






	for(int xloop2 = 0; xloop2 < krypton.network[0].length; xloop2++){//*********************

	ip_log_book[0][xloop2] = new JLabel(krypton.network[0][xloop2], JLabel.LEFT);
	ip_log_book[1][xloop2] = new JLabel(krypton.network[1][xloop2], JLabel.LEFT);
	ip_log_book[2][xloop2] = new JLabel(krypton.network[2][xloop2], JLabel.LEFT);

	ip_log_book[0][xloop2].setPreferredSize(new Dimension(150, 15));
	ip_log_book[1][xloop2].setPreferredSize(new Dimension(200, 15));
	ip_log_book[2][xloop2].setPreferredSize(new Dimension(100, 15));

	ip_log_book[0][xloop2].setFont(f_01);
	ip_log_book[1][xloop2].setFont(f_01);
	ip_log_book[2][xloop2].setFont(f_01);

	jpk1.add(ip_log_book[0][xloop2]);
	jpk1.add(ip_log_book[1][xloop2]);
	jpk1.add(ip_log_book[2][xloop2]);

	}//**************************************************************************************






	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(490, 620));
	jpk2.setBackground(grayx2);//darkgray08







	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(grayx2);
	cpx.setForeground(whitex);
	cpx.add(header1_space);
	cpx.add(header2_space);
	cpx.add(header3_space);
	cpx.add(header4_space);
	cpx.add(scrollPaned);
	cpx.add(jpk2);


	setVisible(true);


	requestFocus();





	refresh_1 = 1;

	//start the engine
	toolkit = Toolkit.getDefaultToolkit();
	xtimerx = new Timer();
	xtimerx.schedule(new RemindTask_refresh(), 0);



}//csv_loader_x1********************************************************












	class RemindTask_refresh extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//**************************************************************************************

	while(refresh_1 == 1){//**

	System.out.println("RELOAD IP LIST");


	for(int xloop2 = 0; xloop2 < krypton.network[0].length; xloop2++){//*********************

	ip_log_book[0][xloop2].setText(krypton.network[0][xloop2]);
	ip_log_book[1][xloop2].setText(krypton.network[1][xloop2]);
	ip_log_book[2][xloop2].setText(krypton.network[2][xloop2]);

	}//**************************************************************************************



	try{Thread.sleep(5000);} catch(InterruptedException e){}



	}//while*******************

	}//runx***************************************************************************************************
        }//remindtask





















    public static void main(){

	krypton_view_network xr = new krypton_view_network();

    }//main










}//last****************************************