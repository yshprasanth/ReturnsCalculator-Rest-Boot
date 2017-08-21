package com.returns.calculator.service.interest.impl;

import com.returns.calculator.domain.metadata.Term;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Interest Calculator Service object
 */
@Service
@Qualifier("interestCalculatorService")
public class InterestCalculatorService implements IService<FxTrade> {

    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    @Qualifier("currencyExchangeService")
    IService<FxTrade> currencyExchangeService;

    /**
     *
     * @param trade
     * @throws Exception
     */
    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {

        if(trade.isPresent()) {
            FxTrade fxTrade = trade.get();
            calcCompoundInterest(fxTrade);
            calcAnnualSimpleInterest(fxTrade);
            logger.info("successfully calculated interest");

            currencyExchangeService.execute(trade);
            logger.info("successfully converted interest to USD");
        }
    }

    /**
     * Calculates compound interest
     *
     * @param trade
     */
    private void calcCompoundInterest(FxTrade trade) {
        double principal = trade.getPrincipal().doubleValue();
        double rate = trade.getAnnualInterestRate().doubleValue();
        int compoundFrequency = getCompoundingFrequency(trade.getCompoundFrequency(), trade.getCompoundFrequencyTerm());
        int lengthOfTime = trade.getPaymentLength();

        double compoundInterest = (principal * (Math.pow((1 + (rate / compoundFrequency)), compoundFrequency * lengthOfTime))) - principal;

        logger.info(principal + "," + rate + "," + compoundFrequency + "," + lengthOfTime + "::" + compoundInterest);
        trade.setCompoundInterest(compoundInterest);


    }

    /**
     * Calculates simple interest
     *
     * @param trade
     */
    private void calcAnnualSimpleInterest(FxTrade trade) {
        double principal = trade.getPrincipal().doubleValue();
        double rate = trade.getAnnualInterestRate().doubleValue();
        int lengthOfTime = trade.getPaymentLength();

        double simpleInterest = (principal * rate * lengthOfTime);

        logger.info(principal + "," + rate + "," + lengthOfTime + "::" + simpleInterest);
        trade.setAnnualSimpleInterest(simpleInterest);
    }

    private int getCompoundingFrequency(Integer compoundFrequency, Term compoundFrequencyTerm) {
        if(compoundFrequencyTerm==Term.Y) {
            return 1;
        } else if(compoundFrequencyTerm==Term.M) {
            return 12/compoundFrequency;
        }

        return 1;
    }

    public void setCurrencyExchangeService(IService<FxTrade> currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

}
