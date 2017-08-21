package com.returns.calculator.service.interest.impl;

import com.returns.calculator.builder.TradeBuilder;
import com.returns.calculator.domain.metadata.StaticType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.dao.impl.DAOService;
import com.returns.calculator.service.exchange.impl.CurrencyExchangeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import static org.junit.Assert.*;

/** 
* InterestCalculatorService Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class InterestCalculatorServiceTest { 

    InterestCalculatorService interestCalculatorService;
    CurrencyExchangeService currencyExchangeService;
    DAOService daoService;

    @Before
    public void before() throws Exception {
        interestCalculatorService = new InterestCalculatorService();

        currencyExchangeService = new CurrencyExchangeService();
        daoService = new DAOService();
        daoService.loadStaticData(StaticType.CURRENCY_EXCHANGE);
        currencyExchangeService.setDaoService(daoService);

        interestCalculatorService.setCurrencyExchangeService(currencyExchangeService);
    }

    @After
    public void after() throws Exception {
        interestCalculatorService = null;
    }

    /**
    *
    * Method: execute(Optional<FxTrade> trade)
    *
    */
    @Test
    public void testExecute() throws Exception {
        FxTrade fxTrade = new FxTrade();
        TradeBuilder.buildFxTrade(fxTrade);

        interestCalculatorService.execute(Optional.of(fxTrade));

        assertNotNull(fxTrade.getCompoundInterest());
        assertNotNull(fxTrade.getAnnualSimpleInterest());
    }

} 
