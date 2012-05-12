package converter;

import java.util.logging.Level;
import java.util.logging.Logger;


    
public abstract class BaseCurrencyConverter implements CurrencyConverter {
    
    /**
     * méhode pour générer la matrice de combnaisons des devises
     * @param String[] tableau de devises
     * @return CurrencyPair[][] matrice de conversions
     */   
    public CurrencyPair[][] getConversionMatrix(String[] currencies){
        int size = currencies.length;
        CurrencyPair[] currencyPairs = new CurrencyPair[size * size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                currencyPairs[index++] = new CurrencyPair(currencies[i], currencies[j]);
            }
        }
        
        try {
            // Conversion
            convert(currencyPairs);
        } catch (Exception ex) {
            Logger.getLogger(BaseCurrencyConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Construction de la matrice de convesions
        CurrencyPair[][] matrix = new CurrencyPair[size][size];
        index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = i != j ? currencyPairs[index] : null;
                index++;
            }
        }
        return matrix;
    }

}
