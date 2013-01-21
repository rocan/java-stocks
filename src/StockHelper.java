import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;


public class StockHelper {

	static String symbol = "";
	static double price = 0.0; 
	static double change = 0.0; 
	static int volume = 0; 
	static double pe = 0.0;
	static double eps = 0.0; 
	static double week52low = 0.0; 
	static double week52high = 0.0; 
	static double daylow = 0.0; 
	static double dayhigh = 0.0; 
	static double movingav50day = 0.0; 
	static double marketcap = 0.0; 
	
	public Stock getStock(String symbol) {  
		
		BufferedReader b = null;  
		Stock stock = new Stock(); 
		String line; 
	
		try { 
		
			URL yahoo = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=l1c6vr2ejkghm3j3"); 
			URLConnection connection = yahoo.openConnection(); 
		
			b = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
		
			line = b.readLine(); 
		
			String[] stockinfo = line.split(","); 
		
			
			if (Pattern.matches("N/A", stockinfo[0])) {  
				price = 0; 	
			} else { 
				price = Double.parseDouble(stockinfo[0]);  
			}  
			
			//change = Double.parseDouble(stockinfo[1]); 
			
			if (Pattern.matches("N/A", stockinfo[2])) {  
				volume = 0; 	
			} else { 
				volume = Integer.parseInt(stockinfo[2]);  
			} 
			
			if (Pattern.matches("N/A", stockinfo[3])) {  
				pe = 0; 	
			} else { 
				pe = Double.parseDouble(stockinfo[3]); 
			}
			
			if (Pattern.matches("N/A", stockinfo[4])) {  
				eps = 0; 	
			} else { 
				eps = Double.parseDouble(stockinfo[4]);  
			}
			
			if (Pattern.matches("N/A", stockinfo[5])) {  
				week52low = 0; 	
			} else { 
				week52low = Double.parseDouble(stockinfo[5]);  
			}
			
			if (Pattern.matches("N/A", stockinfo[6])) {  
				week52high = 0; 	
			} else { 
				week52high = Double.parseDouble(stockinfo[6]);   
			} 
			
			if (Pattern.matches("N/A", stockinfo[7])) {  
				daylow = 0; 	
			} else { 
				daylow = Double.parseDouble(stockinfo[7]); 
			}
			
			if (Pattern.matches("N/A", stockinfo[8])) {  
				dayhigh = 0; 	
			} else { 
				dayhigh = Double.parseDouble(stockinfo[8]);  
			}
		 
			if (Pattern.matches("N/A - N/A", stockinfo[9])) {  
				movingav50day = 0; 	
			} else { 
				movingav50day = Double.parseDouble(stockinfo[9]);  
			}
			
			if (Pattern.matches("N/A", stockinfo[10])) {  
				marketcap = 0; 	
			} else { 
				marketcap = Double.parseDouble(stockinfo[10]);   
			} 
		
			stock = new Stock(symbol, price, change, volume, pe, eps, week52low, week52high, daylow, dayhigh, movingav50day, marketcap);
		
		} catch (IOException ex) { 
		
			ex.printStackTrace();
		
		}
	
		return stock;
	
	}
	
}