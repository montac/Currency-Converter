/*
 * Classe pour extraire le cours de la bourse (Stock Quotes)
 * 
 */
package stockquotes;

import java.lang.String.*;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


public class YStockQuotes {
    
    /**
     * @param string Nom de l'action, exemple: "AAPL" pour Apple ou MSFT pour Microsoft  
     * @return String resultat
     * @see <a href="http://www.gummy-stuff.org/Yahoo-data.htm">Yahoo finance tags</a>
     */     
    public String getQuote(String input) throws IOException{  
        
        String quoteFormat = "&f=b2c6p2";  // format du résultat 
         //b2 = Ask (Real-time)                   
         //p2 = Change Percent       
         //c6 = Change (Real-time) 
        
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s="+input+quoteFormat);
        // exemple pour Apple
        // http://quote.yahoo.com/d/quotes.csv?s=AAPL&f=b2c6p2
        
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(httpGet, responseHandler);
        httpclient.getConnectionManager().shutdown();
        
        return responseBody;
    }
         
}
