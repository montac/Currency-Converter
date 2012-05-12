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
public class CurrencyConverterTest {
    
    public CurrencyConverterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvert_String_String() throws Exception {
        System.out.println("convert");
        String currencyFrom = "";
        String currencyTo = "";
        CurrencyConverter instance = new CurrencyConverterImpl();
        float expResult = 0.0F;
        float result = instance.convert(currencyFrom, currencyTo);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convert method, of class CurrencyConverter.
     */
    @Test
    public void testConvert_CurrencyPairArr() throws Exception {
        System.out.println("convert");
        CurrencyPair[] currencyPairs = null;
        CurrencyConverter instance = new CurrencyConverterImpl();
        instance.convert(currencyPairs);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class CurrencyConverterImpl implements CurrencyConverter {

        public float convert(String currencyFrom, String currencyTo) throws IOException {
            return 0.0F;
        }

        public void convert(CurrencyPair[] currencyPairs) throws Exception {
        }
    }
}
