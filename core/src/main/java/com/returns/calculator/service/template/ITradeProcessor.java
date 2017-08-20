package com.returns.calculator.service.template;

import com.returns.calculator.domain.Trade;
import com.returns.calculator.domain.service.IContext;
import com.returns.calculator.service.IService;
import com.returns.calculator.service.factory.ITradeFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class ITradeProcessor<C extends IContext, T extends Trade> {

    @Autowired
    private ITradeFactory<T> tradeFactory;

    @Autowired
    private IService<T> validationService;

    @Autowired
    private IService<T> enrichmentService;

    @Autowired
    private IService<T> interestCalculatorService;

    @Autowired
    private IService<T> daoService;

    protected abstract Optional<T> createTrade(Optional<C> c) throws Exception;
    protected abstract void validateTrade(Optional<T> t) throws Exception;
    protected abstract void enrichTrade(Optional<T> t) throws Exception;
    protected abstract void calculateInterest(Optional<T> t) throws Exception;
    protected abstract void persistTrade(Optional<T> t) throws Exception;

    public final Optional<T> execute(Optional<C> context) {

        Optional<T> trade = Optional.empty();

        try {
            trade = createTrade(context);

            validateTrade(trade);
            enrichTrade(trade);
            calculateInterest(trade);
            persistTrade(trade);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return trade;
    }

    public ITradeFactory<T> getTradeFactory() {
        return tradeFactory;
    }

    public void setTradeFactory(ITradeFactory<T> tradeFactory) {
        this.tradeFactory = tradeFactory;
    }

    public IService<T> getValidationService() {
        return validationService;
    }

    public void setValidationService(IService<T> validationService) {
        this.validationService = validationService;
    }

    public IService<T> getEnrichmentService() {
        return enrichmentService;
    }

    public void setEnrichmentService(IService<T> enrichmentService) {
        this.enrichmentService = enrichmentService;
    }

    public IService<T> getInterestCalculatorService() {
        return interestCalculatorService;
    }

    public void setInterestCalculatorService(IService<T> interestCalculatorService) {
        this.interestCalculatorService = interestCalculatorService;
    }

    public IService<T> getDaoService() {
        return daoService;
    }

    public void setDaoService(IService<T> daoService) {
        this.daoService = daoService;
    }
}
