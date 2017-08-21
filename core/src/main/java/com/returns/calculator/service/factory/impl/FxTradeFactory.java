package com.returns.calculator.service.factory.impl;


import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.domain.service.IContext;
import com.returns.calculator.service.builder.ITradeBuilder;
import com.returns.calculator.service.factory.ITradeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Qualifier("fxTradeFactory")
public class FxTradeFactory implements ITradeFactory<FxTrade> {

    @Autowired
    @Qualifier("fxTradeBuilder")
    ITradeBuilder<FxTrade> tradeBuilder;

    @Override
    public Optional<FxTrade> createTrade(Optional<? extends IContext> context) {
        FxTrade trade = null;

        if(context.isPresent()){
            switch (context.get().getProductType()) {
                case SWAP:
                    trade = new FxTrade();
                    break;
                case SWAPSPREAD:
                    trade = new FxTrade(); // replace with other object type
                    break;
                case CAPFLOOR:
                    trade = new FxTrade();
                    break;
                default:
                    trade = new FxTrade();
            }

            tradeBuilder.buildTrade(context, Optional.of(trade));
        }

        return Optional.ofNullable(trade);
    }

}
