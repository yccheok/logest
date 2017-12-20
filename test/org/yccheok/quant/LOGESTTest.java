/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yccheok.quant;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yccheok
 */
public class LOGESTTest {
    
    public LOGESTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of logest method, of class LOGEST.
     */
    @Test
    public void testLogest() {
        // http://faq.betterinvesting.org/index.php?action=artikel&cat=3&id=16&artlang=en
        double[] y = {6207, 8279, 13931, 19315, 24006, 32479, 42905, 65225, 108249, 156508};
        double[] x = {2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012};

        double expResult = 0.4165506277448576;
        double result = LOGEST.logest(y, x);
        assertEquals(expResult, result, 0.0);
        
        // https://docs.google.com/spreadsheets/d/1ff5rpk6bilrRlzaNAqgvMojVrAnQ3ItWZUW1YeQvymQ/edit#gid=0
        y = new double[]{105.26, 114.95, 129.66, 138.29, 145.08, 149.75};
        x = new double[]{2010, 2011, 2012, 2013, 2014, 2015};
        
        expResult = 0.0748233185947389;
        result = LOGEST.logest(y, x);
        assertEquals(expResult, result, 0.0);
        
        // https://money.stackexchange.com/questions/88105/better-way-to-calculate-earning-growth-rate-to-have-quick-glance-on-company-earn
        y = new double[]{1.0, 2.2, 3.5, 4.9, 6.0};
        x = new double[]{2013, 2014, 2015, 2016, 2017};
        
        expResult = 0.5502708821214857;
        result = LOGEST.logest(y, x);
        assertEquals(expResult, result, 0.0);
    }
    
}
