/*
 * Classe de WebService pour la récupration des cours des actions (stock quotes)
 * 
 */
package cservice;

import stockquotes.YStockQuotes;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ejb.Stateless;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// import des classes Patten & Matcher pour faire des tests de Expressions régulières (regex) (extactino des données d'une chaine complexe)
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author montassar
 */
@WebService(serviceName = "StockQuotes")
@Stateless()
public class StockQuotesWS {

    /**
     * Operation qui récupère la mise à jour des cours d'actions depuis YahooWS
     */
    @WebMethod(operationName = "getStockQuotes")
    public String getStockQuotes() {
        
        String[] stocks = new String[]{"AAPL", "GOOG", "MSFT", "YHOO", "ORCL", "CSCO", "INTC", "ALU", "T"};
        
        // Racine du fichier JSON
        JSONObject json = new JSONObject();
        // Elements de niveau 1
        JSONArray  liste = new JSONArray();
        
        YStockQuotes ysq = new YStockQuotes();
        String arrowUrl ="";
        String change = "";
        String changePercent = "";
        
        for (int i = 0; i < stocks.length; i++){
            try {
                String result = ysq.getQuote(stocks[i]);
                //String test_string = "584.46,\"-20.92\",\"-3.46%\"\r\n";
                //Pattern p = Pattern.compile("(.*),(.*),(.*)");
                String[] valeurs= result.split(",");
                change = valeurs[1].substring(1, valeurs[1].lastIndexOf("\""));
                changePercent = valeurs[2].substring(1, valeurs[2].lastIndexOf("\""));
                
                if (valeurs[1].charAt(1)== '+')
                    {
                        arrowUrl="app/logos/up.png";
                    }
                else{ 
                        arrowUrl="app/logos/down.png";
                }

                JSONObject listeStocks  = new JSONObject();
                listeStocks.put("stock_code", stocks[i]);
                listeStocks.put("Ask", valeurs[0]);
                listeStocks.put("Change",change);
                listeStocks.put("ChangeInPercent",changePercent);
                listeStocks.put("arrowUrl",arrowUrl);

                liste.add(listeStocks);
            } catch (IOException ex) {
                Logger.getLogger(StockQuotesWS.class.getName()).log(Level.SEVERE, null, ex);
            }
                          
        }
        
        json.put("stockquotes", liste); //insertion des objets générés dans la racine 'stockquotes'
      
        return json.toJSONString();
    }

    /**
     * Operation qui récupère la mise à jour des cours d'actions à partir du fichier local JSON (sans taper le YahooWS ) 
     */
    @WebMethod(operationName = "getLocalStockQuotes")
    public String getLocalStockQuotes() {
        
        JSONObject jsonobj = new JSONObject();      
        JSONParser parser = new JSONParser();
        
        try {
            Object obj = parser.parse(new FileReader("D:\\www\\converter_mobile\\app\\test_stockquotes.json"));
            jsonobj = (JSONObject) obj;
            
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(CurrencyConverterWS.class.getName()).log(Level.SEVERE, null, e);
        }
        catch (IOException e){
        }
        catch (ParseException e){
        }

        return jsonobj.toJSONString();
    }
       
}
