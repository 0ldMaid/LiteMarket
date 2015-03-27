import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Comparator;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.KeyPair;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.spongycastle.util.encoders.Base64;



public class krypton_build_settings{









public krypton_build_settings(){


	System.out.println("Build new settings file...");

	PrivateKey priv_e = null;




	try{

    	KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    	kpg.initialize(1024);
    	KeyPair keyPair = kpg.genKeyPair();

    	System.out.println("");
    	System.out.println("privateKey Base 64: " + Base64.toBase64String(keyPair.getPrivate().getEncoded()) );
    	System.out.println("");
    	System.out.println("Public Base 64: " + Base64.toBase64String(keyPair.getPublic().getEncoded()) );
    	System.out.println("");





		try {
       		BufferedWriter out = new BufferedWriter(new FileWriter("krypton_settings.ini"));

		out.write("Krypton");
		out.newLine();
		out.write("1.0.1");
		out.newLine();
		out.write("LiteMarket");
		out.newLine();
		out.write("9295");
		out.newLine();
		out.write("1");
		out.newLine();
		out.write(Base64.toBase64String(keyPair.getPrivate().getEncoded()) );
		out.newLine();
		out.write(Base64.toBase64String(keyPair.getPublic().getEncoded()) );

        	out.close();
        	} catch (IOException e) {System.out.println("print fail.");}



	}catch(Exception e){e.printStackTrace();}

}//makek************************













}//last