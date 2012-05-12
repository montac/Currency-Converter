/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cservice;

import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class StockQuotesWSTest {
    
    public StockQuotesWSTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getStockQuotes method, of class StockQuotesWS.
     */
    @Test
    public void testGetStockQuotes() throws Exception {
        System.out.println("getStockQuotes");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        StockQuotesWS instance = (StockQuotesWS)container.getContext().lookup("java:global/classes/StockQuotesWS");
//        String expResult = "";
//        String result = instance.getStockQuotes();
//        assertEquals(expResult, result);
//        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalStockQuotes method, of class StockQuotesWS.
     */
    @Test
    public void testGetLocalStockQuotes() throws Exception {
        System.out.println("getLocalStockQuotes");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        StockQuotesWS instance = (StockQuotesWS)container.getContext().lookup("java:global/classes/StockQuotesWS");
//        String expResult = "";
//        String result = instance.getLocalStockQuotes();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
