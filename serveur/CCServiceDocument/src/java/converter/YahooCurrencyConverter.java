package converter;

import java.lang.String.*;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author montassar
 */
public class YahooCurrencyConverter extends BaseCurrencyConverter {

    @Override
    public float convert(String currencyFrom, String currencyTo) throws IOException {
         HttpClient httpclient = new DefaultHttpClient();
         // "http://alerts.yahoo.com/alerts/rdr.php?nep=stockpm&.pf=EURUSD=X&.done=http%3A%2F%2Ffinance.yahoo.com%2Fq%3Fs%3DEURUSD%253DX%26ql%3D0"
         HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s=" + currencyFrom + currencyTo + "=X&f=l1&e=.csv");
         ResponseHandler<String> responseHandler = new BasicResponseHandler();
         String responseBody = httpclient.execute(httpGet, responseHandler);
         httpclient.getConnectionManager().shutdown();
         
         return Float.parseFloat(responseBody);     
    }

    @Override
    public void convert(CurrencyPair[] currencyPairs) throws Exception {
         HttpClient httpclient = new DefaultHttpClient();
         StringBuffer sb = new StringBuffer();
         for (CurrencyPair currencyPair : currencyPairs) {
            sb.append("s=").append(currencyPair.getFrom()).append(currencyPair.getTo()).append("=X&");
         }
         HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?" + sb + "f=l1&e=.csv");
         ResponseHandler<String> responseHandler = new BasicResponseHandler();
         String responseBody = httpclient.execute(httpGet, responseHandler);
         httpclient.getConnectionManager().shutdown();
         String[] lines = responseBody.split("\n");
         if (lines.length != currencyPairs.length) {
            throw new IllegalStateException("Currency data mismatch");
            }
        int i = 0;
        for (String line : lines) {
            CurrencyPair currencyPair = currencyPairs[i++];
            currencyPair.price = Float.parseFloat(line);
        }       
    }         
}
