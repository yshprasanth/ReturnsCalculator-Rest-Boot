package com.returns.calculator.service.dao.impl;

import com.returns.calculator.domain.metadata.StaticType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** 
* DAOService Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class DAOServiceTest {

    DAOService daoService;

    @Before
    public void before() throws Exception {
        daoService = new DAOService();
    }

    @After
    public void after() throws Exception {
        daoService = null;
    }

    /**
    *
    * Method: execute(Optional<FxTrade> trade)
    *
    */
    @Test
    public void testExecute() throws Exception {

    }

    /**
    *
    * Method: loadStaticData(StaticType type)
    *
    */
    @Test
    public void testLoadStaticData() throws Exception {
        daoService.loadStaticData(StaticType.CURRENCY_EXCHANGE);

        assertEquals(0.85d, daoService.getCurrencyExchangeToUSD("EUR"), 0.0d);
    }


} 
