package com.returns.calculator.service.interest.impl;

import com.returns.calculator.domain.metadata.Term;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("interestCalculatorService")
public class InterestCalculatorService implements IService<FxTrade> {

    @Autowired
    @Qualifier("currencyExchangeService")
    IService<FxTrade> currencyExchangeService;

    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {

        if(trade.isPresent()) {
            FxTrade fxTrade = trade.get();
            calcCompoundInterest(fxTrade);
            calcAnnualSimpleInterest(fxTrade);
            currencyExchangeService.execute(trade);
        }
    }

    private void calcCompoundInterest(FxTrade trade) {
        double principal = trade.getPrincipal().doubleValue();
        double rate = trade.getAnnualInterestRate().doubleValue();
        int compoundFrequency = getCompoundingFrequency(trade.getCompoundFrequency(), trade.getCompoundFrequencyTerm());
        int lengthOfTime = trade.getPaymentLength();

        double compoundInterest = (principal * (Math.pow((1 + (rate / compoundFrequency)), compoundFrequency * lengthOfTime))) - principal;

        trade.setCompoundInterest(compoundInterest);


    }

    private void calcAnnualSimpleInterest(FxTrade trade) {
        double principal = trade.getPrincipal().doubleValue();
        double rate = trade.getAnnualInterestRate().doubleValue();
        int lengthOfTime = trade.getPaymentLength();

        double simpleInterest = (principal * rate * lengthOfTime);

        trade.setAnnualSimpleInterest(simpleInterest);
    }

    private int getCompoundingFrequency(Integer compoundFrequency, Term compoundFrequencyTerm) {
        return 1;
    }
}
