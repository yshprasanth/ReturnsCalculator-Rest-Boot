package com.returns.calculator.service.dao.impl;

import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is used to generate unique identifier for every trade.
 */
@Service
@Qualifier("idGeneratorService")
public class IdGeneratorService implements IService<FxTrade> {

    Logger logger = LogManager.getLogger(getClass());

    // Variable to mock database sequence
    private AtomicInteger idCounter = new AtomicInteger(99999);

    /**
     * Ideally this will connect to database and get the id from a sequence.
     *
     * For this prototype, we are using a variable to hold the id value.
     *
     * @param trade
     * @throws Exception
     */
    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        if(trade.isPresent()) {
            FxTrade fxTrade = trade.get();
            fxTrade.setTradeId(idCounter.incrementAndGet());

            logger.info("Generated Id:" + fxTrade.getTradeId());
        }
    }
}
