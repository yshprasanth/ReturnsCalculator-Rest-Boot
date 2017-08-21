package com.returns.calculator.service.dao.impl;

import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Qualifier("idGeneratorService")
public class IdGeneratorService implements IService<FxTrade> {

    private AtomicInteger idCounter = new AtomicInteger(99999);

    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        if(trade.isPresent()) {
            FxTrade fxTrade = trade.get();
            fxTrade.setTradeId(idCounter.incrementAndGet());
        }
    }
}
