/*
 * Classe pour faire des manipulations sur une paire de devise 
 * 
 */
package converter;

/**
 * @author montassar
 */
public class CurrencyPair {
    
    private String from;
    private String to;
    float price;
    
    public CurrencyPair(String from, String to)
    {
      this.from = from;
      this.to = to;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public String getTo() {
        return to;
    }
    
    public void setTo(String to) {
        this.to = to;
    }
    
    public float getPrice()
    {
        return price;
    }   
}
