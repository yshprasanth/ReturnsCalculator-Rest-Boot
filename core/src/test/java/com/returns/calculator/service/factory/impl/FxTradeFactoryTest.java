package com.returns.calculator.service.factory.impl;

import com.returns.calculator.builder.TradeBuilder;
import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.domain.service.impl.Context;
import com.returns.calculator.service.builder.impl.FxTradeBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/** 
* FxTradeFactory Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class FxTradeFactoryTest { 

    FxTradeFactory tradeFactory;
    FxTradeBuilder tradeBuilder;

    @Before
    public void before() throws Exception {
        tradeFactory = new FxTradeFactory();
        tradeBuilder = new FxTradeBuilder();
        tradeFactory.setTradeBuilder(tradeBuilder);

    }

    @After
    public void after() throws Exception {
        tradeFactory = null;
    }

    /**
    *
    * Method: createTrade(Optional<? extends IContext> context)
    *
    */
    @Test
    public void testCreateTrade() throws Exception {

        Context context = new Context();
        TradeBuilder.buildContext(context);

        Optional<FxTrade> fxTradeOpt =  tradeFactory.createTrade(Optional.of(context));
        FxTrade fxTrade = fxTradeOpt.get();

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
