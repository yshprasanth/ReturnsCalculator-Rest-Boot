package com.returns.calculator.service.factory.impl;


import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.domain.service.IContext;
import com.returns.calculator.service.builder.ITradeBuilder;
import com.returns.calculator.service.factory.ITradeFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Factory class to create Trade objects
 */
@Component
@Qualifier("fxTradeFactory")
public class FxTradeFactory implements ITradeFactory<FxTrade> {

    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    @Qualifier("fxTradeBuilder")
    ITradeBuilder<FxTrade> tradeBuilder;

    /**
     * Factory method that will determine the type of Trade and create an object accordingly.
     *
     * @param context
     * @return
     */
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

            logger.info("Created trade object:" + trade);

            tradeBuilder.buildTrade(context, Optional.of(trade));

            logger.info("Built trade object:" + trade);
        }

        return Optional.ofNullable(trade);
    }

    public void setTradeBuilder(ITradeBuilder<FxTrade> tradeBuilder) {
        this.tradeBuilder = tradeBuilder;
    }
}
