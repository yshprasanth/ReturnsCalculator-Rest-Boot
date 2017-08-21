package com.returns.calculator.service.exchange.impl;

import com.returns.calculator.domain.metadata.StaticType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Currency Exchange Service will perform the operation of converting the calculated Interest
 * from source currency to USD.
 */
@Service
@Qualifier("currencyExchangeService")
public class CurrencyExchangeService implements IService<FxTrade>, InitializingBean {

    Logger logger = LogManager.getLogger(getClass());

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

            logger.info("Converted Interest values: " + fxTrade.getCompoundInterest() + ", " + fxTrade.getAnnualInterestRate());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        daoService.loadStaticData(StaticType.CURRENCY_EXCHANGE);
        logger.info("Successfully loaded currency exchange static data !!");
    }
}
