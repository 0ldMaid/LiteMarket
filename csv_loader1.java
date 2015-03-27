import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  







public class csv_loader1{//************************************************************************

int csv_passes_x = 17;

static int runx = 0;
static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int stop = 0;

String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");


File st1;
String[] CSVTEMP = new String[runs];
public static String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");




csv_loader1(File st1){//****************************

stop = 0;
csv_int = 0;
thisc3 = 0;

	try {
	BufferedReader in = new BufferedReader(new FileReader(st1));
	xlinex = blank;
	while ((xlinex = in.readLine()) != null){CSVTEMP[csv_int] = xlinex; csv_int++; thisc3++;}
	in.close();
	}catch(IOException e){working = 0; System.out.println("no file " + st1);}


if(csv_int < 1){System.out.println("file is empty."); working = 0;}
else{//**********************************************

cx0 = CSVTEMP[0];
runx = 1;


	for (int loop1 = 0; loop1 < runs; loop1++){

	ix0 = cx0.indexOf("\",");
	ix1 = cx0.indexOf(",\"");
	ix2 = cx0.indexOf(",");

	if(ix0 > -1){runx++; cx0 = cx0.substring(ix0 + 1, cx0.length());}
	else if(ix1 > -1){runx++; cx0 = cx0.substring(ix1 + 1, cx0.length());}
	else if(ix2 > -1){runx++; cx0 = cx0.substring(ix2 + 1, cx0.length());}
	else{break;}

//System.out.println("runx " + runx);

	}//******************************************





runs2 = runx;
//System.out.println("ccx " + runx);
//System.out.println("csv_int " + csv_int);

check_csv();
if(working == 1){loadxcsv();}

}//else************************************************
}//csv_loader_x1********************************************************








public void check_csv(){


carbonfiber = new String[runs2][thisc3];


}//*********************







public void loadxcsv(){//break up the csv file

	thisc2 = 0;

	for (int loop1 = 0; loop1 < csv_int; loop1++){
	cx0 = CSVTEMP[loop1];
	for (int loop2 = 0; loop2 < 500; loop2++){

if(cx0.length() < 1){System.out.println("Break!"); break;};

	if(cx0.substring(0,1).equals("\"")){//*****************
	ix0 = cx0.indexOf("\",");
	if(ix0 > -1){//***********************

//System.out.println(thisc2);
	thisc2 = loop2 + 1;
	carbonfiber[loop2][loop1] = cx0.substring(0, ix0 + 1);
	cx0 = cx0.substring(ix0 + 2, cx0.length());

	}//if*********************************
	else{carbonfiber[loop2][loop1] = cx0; if(stop == 0){thisc2++;} stop = 1; break;}

	}//if**************************************************


	else{//****************************************************************
	ix0 = cx0.indexOf(",");
	if(ix0 > -1){//***********************

if(loop2 == carbonfiber.length -1){System.out.println("fail"); break;}
	thisc2 = loop2 + 1;
	carbonfiber[loop2][loop1] = cx0.substring(0, ix0);
	cx0 = cx0.substring(ix0 + 1, cx0.length());
//System.out.println(" " + carbonfiber[loop2][loop1] + " " + loop2 + " " + loop1 + " " + carbonfiber.length);

	}//if*********************************
	else{carbonfiber[loop2][loop1] = cx0; if(stop == 0){thisc2++;} stop = 1; break;}
	}//else*****************************************************************


	}//for*************************************
	//info
	}//for**************************************


System.out.println("CSV File Has: " + thisc2 + " section(s) and: " + thisc3 + " row(s).");
//System.out.println(carbonfiber[0][0]);
//System.out.println(carbonfiber[0][1]);


}//csv


public static String[][] getData0(){return carbonfiber;} 
public static int getData1(){return thisc2;} 
public static int getData2(){return thisc3;}



}//last****************************************