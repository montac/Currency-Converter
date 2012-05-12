/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class BaseCurrencyConverterTest {
    
    public BaseCurrencyConverterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getConversionMatrix method, of class BaseCurrencyConverter.
     */
    @Test
    public void testGetConversionMatrix() {
        System.out.println("getConversionMatrix");
        String[] currencies = new String[]{"USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "MXN", "TND"};
        BaseCurrencyConverter instance = new BaseCurrencyConverterImpl();
        //CurrencyPair[][] expResult = null;
        //CurrencyPair[][] result = instance.getConversionMatrix(currencies);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class BaseCurrencyConverterImpl extends BaseCurrencyConverter {

        @Override
        public float convert(String currencyFrom, String currencyTo) throws IOException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void convert(CurrencyPair[] currencyPairs) throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
