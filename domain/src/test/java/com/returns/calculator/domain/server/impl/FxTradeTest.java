package com.returns.calculator.domain.server.impl;

import com.returns.calculator.domain.helper.TradeBuilder;
import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.Assert.*;

/** 
* FxTrade Tester.
 *
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class FxTradeTest {

    private FxTrade testObj;

    @Before
    public void before() throws Exception {
        testObj = new FxTrade();
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
        TradeBuilder.buildFxTrade(testObj);

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
        assertNotNull(testObj.getTradeId());
    }


    /**
     * Method: testCompare()
     */
    @Test
    public void testCompare() throws Exception {
        TradeBuilder.buildFxTrade(testObj);
        FxTrade testObj2 = new FxTrade();
        TradeBuilder.buildFxTrade(testObj2);

        int result = testObj2.compareTo(testObj2);

        assertEquals(0, result);

    }
}
