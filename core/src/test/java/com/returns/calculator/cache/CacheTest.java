package com.returns.calculator.cache;

import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.builder.impl.FxTradeBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* Cache Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class CacheTest { 

    private Cache testObj;

    @Before
    public void before() throws Exception {
        testObj = Cache.getInstance();
        testObj.init();
    }

    @After
    public void after() throws Exception {
        testObj.clear();
    }


    /**
    *
    * Method: getAllTrades(S productType)
    *
    */
    @Test
    public void testGetAllTrades() throws Exception {
    }

}
