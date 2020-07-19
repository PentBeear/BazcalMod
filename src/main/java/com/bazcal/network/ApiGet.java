package com.bazcal.network;


import java.io.IOException;

import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

import com.bazcal.gui.GuiResult;
import com.bazcal.bazcalmodmain.BazcalMainMod;

import com.google.gson.Gson;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import org.apache.commons.lang3.ArrayUtils;

import java.nio.charset.StandardCharsets;

import java.util.ArrayList;
import java.util.Arrays;








public class ApiGet { // 

	public static String input;
	private final static String USER_AGENT = "Mozilla/5.0";

	
	public static ArrayList<String> itemNames = new ArrayList<String>(Arrays.asList());
	public static ArrayList<Double> itemInvests = new ArrayList<Double>(Arrays.asList());
	public static ArrayList<Double> itemProfits = new ArrayList<Double>(Arrays.asList());
	public static void main(String[] args) throws IOException {


       

	}
	
	
	class FormatterItems // handles the json array
	{
		String name;
		double evolume;
		double invested;
		double pinvested;
		double eprofit;
		double pprofit;
		
		@Override
	    public String toString() {
	    	
	    	if (itemNames.size() > 5){}
	    	else
	    	{
	    		itemNames.add(name);
	    		System.out.println(name);
	    	}
	    	
	    	if (itemInvests.size() > 5){}
	    	else
	    	{
	    		itemInvests.add(invested);
	    		System.out.print( " " + invested);
	    	}
	    	
	    	if (itemProfits.size() > 5){}
	    	else
	    	{
	    		itemProfits.add(eprofit);
	    		System.out.print(" " + eprofit);
	    		System.out.println();
	    	}

	    	

	        return "Array{" + "name=" + name + ", evolume=" + evolume + "," + "pinvested=" + pinvested + ", eprofit=" + eprofit + ", pprofit=" + pprofit + '}';
	    }
	}
	
	class Formatter { // Gets the non array items

	    private String responseTime;
	    private Long coins;
	    ArrayList<FormatterItems> bazaarItems;
	    
	    
	    Gson gson = new Gson();  
	    //FormatterItems[] founderArray = gson.fromJson(bazaarItems.toString(), FormatterItems[].class);  
	    
	    
	    
	    @Override
	    public String toString() {
	    	System.out.println(bazaarItems);
	    //	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(bazaarItems.toString()));
	        return "BazcalData{" + "coins=" + coins + ", bazaarItems="
	                + bazaarItems + '}';
	    }
	}
	
	
	
	public static int getMax(int[] inputArray){ 
	    int maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
	
	
	
	static Thread apiHelper = new Thread(() -> {
	   
		  
		   
		
		
		
	});
	

	

	
	
	public static void MyGETRequest() throws IOException {

		
		System.out.println("Sending HTTPS GET request");
		String httpsURL = "https://bazcal.jbsalenger.com/api/personal/" + input;
		URL url = new URL(httpsURL);
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		
      
		itemNames.clear();
		itemInvests.clear();
		itemProfits.clear();
	
            InputStream is = conn.getInputStream(); // Gets the json data then reads it and formats it. This line causes the game the crash on release build
            Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
            
            Gson gson = new Gson();
	        Formatter td = gson.fromJson(reader, Formatter.class);
	        System.out.println(td);
		
		  if (itemNames.size() == 6) // Checks for a proper return on the api request
        {
        	
        	System.out.println(itemNames.size());
        	GuiResult.displayedItem1 = itemNames.get(5) + " Invest " + itemInvests.get(5) + " Profit " + itemProfits.get(5);
        	GuiResult.displayedItem2 = itemNames.get(4) + " Invest " + itemInvests.get(4) + " Profit " + itemProfits.get(4);
        	GuiResult.displayedItem3 = itemNames.get(3) + " Invest " + itemInvests.get(3) + " Profit " + itemProfits.get(3);
        	GuiResult.displayedItem4 = itemNames.get(2) + " Invest " + itemInvests.get(2) + " Profit " + itemProfits.get(2);
        	GuiResult.displayedItem5 = itemNames.get(1) + " Invest " + itemInvests.get(1) + " Profit " + itemProfits.get(1);
        	GuiResult.displayedItem6 = itemNames.get(0) + " Invest " + itemInvests.get(0) + " Profit " + itemProfits.get(0);
        	GuiResult.length = new int[] { GuiResult.displayedItem1.length() , GuiResult.displayedItem2.length() , GuiResult.displayedItem3.length() , GuiResult.displayedItem4.length() , GuiResult.displayedItem5.length() , GuiResult.displayedItem6.length() };
        	GuiResult.endLength = getMax(GuiResult.length);
        }
        else
        {
        	
        	System.out.println(itemNames.size());
        	GuiResult.displayedItem1 = "ERROR FALSE REQUEST";
        	GuiResult.displayedItem2 = "ERROR FALSE REQUEST";
        	GuiResult.displayedItem3 = "ERROR FALSE REQUEST";
        	GuiResult.displayedItem4 = "ERROR FALSE REQUEST";
        	GuiResult.displayedItem5 = "ERROR FALSE REQUEST";
        	GuiResult.displayedItem6 = "ERROR FALSE REQUEST";
        	GuiResult.endLength = 0;
        }
        	
            
            
           // Gson gson = new Gson();
            // Formatter td = gson.fromJson(reader, Formatter.class);
           // Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(td.toString()));
            
            
       
            
       
           
        
	 
        
        
        

        
        

        
        
        //JsonObject jsonObject = jsonElement.getAsJsonObject()
        //System.out.println(jsonObject.get("bazaarItems"));
        

	            

	        BazcalMainMod.renderOverlay = true;


	    } 

	}
	
	

