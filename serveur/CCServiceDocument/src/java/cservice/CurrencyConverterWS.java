/*
 * Classe de WebService pour la récupration des cours de la devise
 * 
 */
package cservice;

import converter.YahooCurrencyConverter;
import converter.CurrencyPair;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author montassar
 */
@WebService(serviceName = "CurrencyConverterWS")
@Stateless()
public class CurrencyConverterWS {

    /**
     * Operation qui récupère la mise à jour des conversions depuuis YahooWS
     * @return string Chaine au format JSON contenant les conversions 
     * @version 1.0
     */
    @WebMethod(operationName = "getConversionRates")
    public String getConversionRates() {

        String[] currencies = new String[]{"USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "MXN", "TND"};
          
        // Racine du fichier JSON
        JSONObject json = new JSONObject();
        // Elements de niveau 1
        JSONArray  liste = new JSONArray();
        
        
        // Instanciaion de la classe du convertisseur (qui va appeler le service YahooFinance) 
        YahooCurrencyConverter ycc = new YahooCurrencyConverter();
        
        for (int i = 0; i < currencies.length; i++){
             JSONObject liste_currTo_  = new JSONObject();
             liste_currTo_.put("curr_code", currencies[i]);
             //liste_currTo_.put("curr_name", "NameOf "+currencies[i]);

             JSONArray sous_liste_currTo_ = new JSONArray(); // sous-liste des conversions
             JSONObject element_sous_liste_ = new JSONObject();

             for (int j =0 ; j < currencies.length; j++){
                try {
                    float price = ycc.convert(currencies[i], currencies[j]);
                    element_sous_liste_.put(currencies[j],price);
                } catch (IOException ex) {
                    Logger.getLogger(CurrencyConverterWS.class.getName()).log(Level.SEVERE, null, ex);
                }

             }

             sous_liste_currTo_.add(element_sous_liste_);
             liste_currTo_.put("liste_conv", sous_liste_currTo_);
             liste.add(liste_currTo_);           
        }
        
        json.put("conversions", liste); //insertion des objets générés dans la racine 'conversions'
       
        return json.toJSONString();
    }

    /**
     * @return String Chaine au format JSON contenant les conversions 
     * @version 2.0
     */
    @WebMethod(operationName = "getConversionRatesV2")
    public String getConversionRatesV2() {
          YahooCurrencyConverter ycc = new YahooCurrencyConverter();
          String[] currencies = new String[]{"USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "MXN", "TND"};
                 
          CurrencyPair[][] currencyPairs = ycc.getConversionMatrix(currencies);
      
        
        // Racine du fichier JSON
        JSONObject json = new JSONObject();
        // Elements de niveau 1
         JSONArray  liste = new JSONArray();
       
         for (int i = 0; i < currencies.length; i++){
             JSONObject liste_currTo_  = new JSONObject();
             liste_currTo_.put("curr_code", currencies[i]);
             
             
             JSONArray sous_liste_currTo_ = new JSONArray(); // sous-liste des conversions
             JSONObject element_sous_liste_ = new JSONObject();
             
             for (int j =0 ; j < currencies.length; j++){
                CurrencyPair currencyPair = currencyPairs[i][j];
                //currencyRow[j]  = (currencyPair != null ? currencyPair.getPrice() : null);
                element_sous_liste_.put(currencies[j],currencyPair != null ? currencyPair.getPrice() : 1);            
             }
             
             sous_liste_currTo_.add(element_sous_liste_);
             liste_currTo_.put("liste_conv", sous_liste_currTo_);
             liste.add(liste_currTo_);  
                
         }
         
        json.put("conversions", liste);
        
        return json.toJSONString();
    }

    /**
     * Operation de test: récupère la mise à jour des conversions à partir du fichier local JSON (sans invoquer le YahooWS )
     * @return String Chaine au format JSON contenant les conversions 
     * @version version de test 
     */
    @WebMethod(operationName = "getLocalConversionRates")
    public String getLocalConversionRates() {
        
        JSONObject jsonobj = new JSONObject();      
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("D:\\www\\converter_mobile\\app\\test_conversions.json"));
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
