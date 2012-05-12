/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class CurrencyPairTest {
    
    public CurrencyPairTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getFrom method, of class CurrencyPair.
     */
    @Test
    public void testGetFrom() {
        System.out.println("getFrom");
        CurrencyPair instance = new CurrencyPair("EUR", "USD");
        String expResult = "EUR";
        String result = instance.getFrom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFrom method, of class CurrencyPair.
     */
    @Test
    public void testSetFrom() {
        System.out.println("setFrom");
        String from = "EUR";
        CurrencyPair instance = new CurrencyPair("EUR", "USD");
        instance.setFrom(from);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTo method, of class CurrencyPair.
     */
    @Test
    public void testGetTo() {
        System.out.println("getTo");
        CurrencyPair instance = new CurrencyPair("EUR", "USD");
        String expResult = "USD";
        String result = instance.getTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTo method, of class CurrencyPair.
     */
    @Test
    public void testSetTo() {
        System.out.println("setTo");
        String to = "";
        CurrencyPair instance = new CurrencyPair("EUR", "USD");
        instance.setTo(to);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class CurrencyPair.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        CurrencyPair instance = new CurrencyPair("EUR", "USD");
        float expResult = 0.0F;
        float result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
