package com.returns.calculator.service.template.impl;

import com.returns.calculator.domain.impl.FxTrade;
import com.returns.calculator.domain.service.impl.Context;
import com.returns.calculator.service.template.ITradeProcessor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FxTradeProcessor extends ITradeProcessor<Context, FxTrade> {

    @Override
    protected Optional<FxTrade> createTrade(Optional<Context> context) throws Exception{
        return getTradeFactory().createTrade(context);
    }

    @Override
    protected void validateTrade(Optional<FxTrade> trade)throws Exception {
        getValidationService().execute(trade);
    }

    @Override
    protected void enrichTrade(Optional<FxTrade> trade)throws Exception {
        getEnrichmentService().execute(trade);
    }

    @Override
    protected void calculateInterest(Optional<FxTrade> trade) throws Exception{
        getInterestCalculatorService().execute(trade);
    }

    @Override
    protected void persistTrade(Optional<FxTrade> trade) throws Exception{
        getDaoService().execute(trade);
    }
}
