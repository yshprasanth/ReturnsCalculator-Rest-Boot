package com.returns.calculator.domain.json;

import org.junit.After;
import org.junit.Before;

/** 
* Trade Tester. 
* 
* @author Sri Yalamanchili
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class TradeTest { 

    private Trade testObj;

    @Before
    public void before() throws Exception {
        testObj = new Trade();
    }

    @After
    public void after() throws Exception {
        testObj = null;
    }


} 
