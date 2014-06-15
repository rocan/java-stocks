package com.nhefner.main;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StockHelper {
	public StockHelper() {
	}
	public double handleDouble(String x) {
		Double y;
		Pattern patternofBillion = Pattern.compile("B$");
		Matcher matchBillion=patternofBillion.matcher(x);
		Pattern patternofMillion = Pattern.compile("M$");
		Matcher matchMillion=patternofMillion.matcher(x);
		if (Pattern.matches("N/A", x)) {  
			y = 9999.99;   
		}
		else if (matchBillion.find()){
			y=Double.parseDouble(x.substring(0,x.length()-1))*1E9;
		}
		else if (matchMillion.find()){
			y=Double.parseDouble(x.substring(0,x.length()-1))*1E6;
		}
		else { 
			y = Double.parseDouble(x);  
		}  
		return y;
	}
	
	public int handleInt(String x) {
		int y;
		if (Pattern.matches("N/A", x)) {  
			y = 9999;   
		} else { 
			y = Integer.parseInt(x);  
		} 
		return y;
	}

}
