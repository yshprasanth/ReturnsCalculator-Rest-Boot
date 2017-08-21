package com.returns.calculator.service.dao.impl;

import com.returns.calculator.cache.Cache;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.StaticType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Qualifier("daoService")
public class DAOService implements IService<FxTrade> {

    @Autowired
    @Qualifier("cache")
    private Cache cache;

    private Map<String, Double> currencyToDollarConversionRateMap = new ConcurrentHashMap<>();

    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        // Persist Trade

        cache.put(trade.get().getProductType().name(), trade.get());

    }

    @Override
    public void loadStaticData(StaticType type) {
        currencyToDollarConversionRateMap.putIfAbsent("USD", 1.0);
        currencyToDollarConversionRateMap.putIfAbsent("EUR", 0.85);
        currencyToDollarConversionRateMap.putIfAbsent("GBP", 1.08);
        currencyToDollarConversionRateMap.putIfAbsent("INR", 80.0);
        currencyToDollarConversionRateMap.putIfAbsent("AUD", 0.80);
        currencyToDollarConversionRateMap.putIfAbsent("YEN", 200.0);
    }

    @Override
    public double getCurrencyExchangeToUSD(String currency) {
        return currencyToDollarConversionRateMap.getOrDefault(currency, 1.0);
    }

    @Override
    public List<FxTrade> getTradesPerClient(String clientName) {
        return cache.getAllTradesForClient(clientName);
    }

    @Override
    public List<FxTrade> getTradesPerProductType(ProductType productType) {
        return cache.getTradesPerProductType(productType.name());
    }
}
