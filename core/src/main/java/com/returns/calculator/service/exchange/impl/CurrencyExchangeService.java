package com.returns.calculator.service.exchange.impl;

import com.returns.calculator.domain.metadata.StaticType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("currencyExchangeService")
public class CurrencyExchangeService implements IService<FxTrade>, InitializingBean {

    @Autowired
    @Qualifier("daoService")
    IService<FxTrade> daoService;

    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        if(trade.isPresent()) {
            FxTrade fxTrade = trade.get();
            double exchangeRate = daoService.getCurrencyExchangeToUSD(fxTrade.getCurrency());

            fxTrade.setCompoundInterest(fxTrade.getCompoundInterest() * exchangeRate);
            fxTrade.setAnnualSimpleInterest(fxTrade.getAnnualSimpleInterest() * exchangeRate);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        daoService.loadStaticData(StaticType.CURRENCY_EXCHANGE);
    }
}
