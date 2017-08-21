package com.returns.calculator.domain.service.impl;

import com.returns.calculator.domain.helper.TradeBuilder;
import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/** 
* Context Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class ContextTest { 

    private Context testObj;

    @Before
    public void before() throws Exception {
        testObj = new Context();
    }

    @After
    public void after() throws Exception {
        testObj = null;
    }

    /**
     * Method: testGettersAndSetters()
     */
    @Test
    public void testGettersAndSetters() throws Exception {
        TradeBuilder.buildContext(testObj);

        assertEquals(10.0d, (double) testObj.getAnnualInterestRate(), 0);
        assertEquals(BuySell.Buy, testObj.getBuySell());
        assertEquals("Test Client", testObj.getClientName());
        assertEquals(Integer.valueOf(3), testObj.getCompoundFrequency());
        assertEquals(Term.M, testObj.getCompoundFrequencyTerm());
        assertEquals("Test Cpty", testObj.getCounterParty());
        assertEquals("GBP", testObj.getCurrency());
        assertEquals("Swaps 10Y2M", testObj.getDescription());
        assertEquals(Integer.valueOf(5), testObj.getPaymentLength());
        assertEquals(BigDecimal.valueOf(1000.0d), testObj.getPrincipal());
        assertEquals(ProductType.SWAP, testObj.getProductType());
        assertEquals(BigDecimal.valueOf(10000), testObj.getQuantity());
        assertNotNull(testObj.getTradeEffectiveDate());
        assertNotNull(testObj.getTradeMaturityDate());
    }

} 
