package com.returns.calculator.service.dao.impl;

import com.returns.calculator.domain.server.impl.FxTrade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/** 
* IdGeneratorService Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 21, 2017</pre> 
* @version 1.0 
*/ 
public class IdGeneratorServiceTest { 

    private IdGeneratorService idGeneratorService = new IdGeneratorService();

    @Before
    public void before() throws Exception {
        idGeneratorService = new IdGeneratorService();
    }

    @After
    public void after() throws Exception {
        idGeneratorService = null;
    }

    /**
    *
    * Method: execute(Optional<FxTrade> trade)
    *
    */
    @Test
    public void testExecute() throws Exception {
        FxTrade trade = new FxTrade();
        idGeneratorService.execute(Optional.of(trade));
        assertNotNull(trade.getTradeId());
    }


} 
