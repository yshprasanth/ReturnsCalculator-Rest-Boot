package com.returns.calculator.service.builder.impl;

import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.domain.service.IContext;
import com.returns.calculator.service.builder.ITradeBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Qualifier("fxTradeBuilder")
public class FxTradeBuilder implements ITradeBuilder<FxTrade>{

    @Override
    public void buildTrade(Optional<? extends IContext> context, Optional<FxTrade> trade) {
        FxTrade innerTrade = trade.orElseGet(() -> new FxTrade());
        if(context.isPresent()) {
            IContext innerContext = context.get();

            innerTrade.setClientName(innerContext.getClientName());
            innerTrade.setProductType(innerContext.getProductType());
            innerTrade.setBuySellType(innerContext.getBuySell());
            innerTrade.setCurrency(innerContext.getCurrency());
            innerTrade.setCounterParty(innerContext.getCounterParty());
            innerTrade.setTradeEffectiveDate(innerContext.getTradeEffectiveDate());
            innerTrade.setTradeMaturityDate(innerContext.getTradeMaturityDate());
            innerTrade.setQuantity(innerContext.getQuantity());
            innerTrade.setPrincipal(innerContext.getPrincipal());
            innerTrade.setCompoundFrequency(innerContext.getCompoundFrequency());
            innerTrade.setAnnualInterestRate(innerContext.getAnnualInterestRate());
            innerTrade.setCompoundFrequencyTerm(innerContext.getCompoundFrequencyTerm());
            innerTrade.setPaymentLength(innerContext.getPaymentLength());
            innerTrade.setDescription(innerContext.getDescription());
        }
    }
}
