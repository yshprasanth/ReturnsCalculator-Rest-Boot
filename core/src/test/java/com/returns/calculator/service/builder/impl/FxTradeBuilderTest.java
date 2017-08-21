package com.returns.calculator.service.builder.impl;

import com.returns.calculator.builder.TradeBuilder;
import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.domain.service.impl.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/** 
* FxTradeBuilder Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class FxTradeBuilderTest { 

    private FxTradeBuilder testObj;

    @Before
    public void before() throws Exception {
        testObj = new FxTradeBuilder();
    }

    @After
    public void after() throws Exception {
        testObj = null;
    }

    /**
    *
    * Method: buildTrade(Optional<? extends IContext> context, Optional<FxTrade> trade)
    *
    */
    @Test
    public void testBuildTrade() throws Exception {
        Context context = new Context();
        TradeBuilder.buildContext(context);

        FxTrade fxTrade = new FxTrade();
        testObj.buildTrade(Optional.of(context), Optional.of(fxTrade));

        assertEquals(context.getAnnualInterestRate(), (double) fxTrade.getAnnualInterestRate(), 0);
        assertEquals(BuySell.Buy, fxTrade.getBuySell());
        assertEquals("Test Client", fxTrade.getClientName());
        assertEquals(Integer.valueOf(3), fxTrade.getCompoundFrequency());
        assertEquals(Term.M, fxTrade.getCompoundFrequencyTerm());
        assertEquals("Test Cpty", fxTrade.getCounterParty());
        assertEquals("GBP", fxTrade.getCurrency());
        assertEquals("Swaps 10Y2M", fxTrade.getDescription());
        assertEquals(Integer.valueOf(5), fxTrade.getPaymentLength());
        assertEquals(BigDecimal.valueOf(1000.0d), fxTrade.getPrincipal());
        assertEquals(ProductType.SWAP, fxTrade.getProductType());
        assertEquals(BigDecimal.valueOf(10000), fxTrade.getQuantity());
        assertNotNull(fxTrade.getTradeEffectiveDate());
        assertNotNull(fxTrade.getTradeMaturityDate());
    }
}
