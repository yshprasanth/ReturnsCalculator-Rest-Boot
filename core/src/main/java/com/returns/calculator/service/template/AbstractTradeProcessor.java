package com.returns.calculator.service.template;

import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.server.Trade;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.domain.service.IContext;
import com.returns.calculator.service.IService;
import com.returns.calculator.service.factory.ITradeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractTradeProcessor<C extends IContext, T extends Trade> {

    @Autowired
    @Qualifier("fxTradeFactory")
    private ITradeFactory<T> tradeFactory;

    @Autowired
    @Qualifier("validationService")
    private IService<T> validationService;

    @Autowired
    @Qualifier("enrichmentService")
    private IService<T> enrichmentService;

    @Autowired
    @Qualifier("interestCalculatorService")
    private IService<T> interestCalculatorService;

    @Autowired
    @Qualifier("daoService")
    private IService<T> daoService;

    @Autowired
    @Qualifier("idGeneratorService")
    private IService<T> idGeneratorService;

    protected abstract Optional<T> createTrade(Optional<C> c) throws Exception;
    protected abstract void validateTrade(Optional<T> t) throws Exception;
    protected abstract void enrichTrade(Optional<T> t) throws Exception;
    protected abstract void calculateInterest(Optional<T> t) throws Exception;
    protected abstract void persistTrade(Optional<T> t) throws Exception;

    ExecutorService executor = Executors.newFixedThreadPool(5);


    public final Integer execute(Optional<C> context) throws Exception{

        final Optional<T> trade = createTrade(context);
        getIdGeneratorService().execute(trade);

        executor.execute(() -> {
                                try {
                                    executeAsync(context, trade);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });

        return trade.get().getTradeId();
    }

    private final void executeAsync(Optional<C> context, Optional<T> trade) throws Exception{
        try {
            validateTrade(trade);
            enrichTrade(trade);
            calculateInterest(trade);
            persistTrade(trade);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<T> getTradesPerClient(String clientName) {
        return daoService.getTradesPerClient(clientName);
    }

    public List<T> getTradesPerProductType(ProductType productType) {
        return daoService.getTradesPerProductType(productType);
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

    public IService<T> getIdGeneratorService() {
        return idGeneratorService;
    }

    public void setIdGeneratorService(IService<T> idGeneratorService) {
        this.idGeneratorService = idGeneratorService;
    }
}
