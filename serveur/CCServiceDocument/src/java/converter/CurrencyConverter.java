package converter;

import java.io.IOException;

/**
 *
 * @author montassar
 */
public interface CurrencyConverter {
     public float convert(String currencyFrom, String currencyTo) throws IOException;
     public void convert(CurrencyPair[] currencyPairs) throws Exception;
     
}
