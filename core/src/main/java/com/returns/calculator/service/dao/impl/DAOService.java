package com.returns.calculator.service.dao.impl;

import com.returns.calculator.cache.Cache;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.StaticType;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DAO Service to persist the trades into database and manage in Cache.
 *
 * Todo: Persist into Database schema (preferable mysql)
 */
@Service
@Qualifier("daoService")
public class DAOService implements IService<FxTrade> {

    Logger logger = LogManager.getLogger(getClass());

    @Autowired
    @Qualifier("cache")
    private Cache cache;

    private Map<String, Double> currencyToDollarConversionRateMap = new ConcurrentHashMap<>();

    /**
     * Method from IService interface.
     *
     * Performs persistance and cache updation.
     *
     * @param trade
     */
    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        // Todo: Persist Trade to database

        // Add to cache
        cache.put(trade.get().getProductType().name(), trade.get());

        logger.info("successfully persisted trade: " + trade.get());
    }

    /**
     * Loads static data from database.
     *
     * @param type
     */
    @Override
    public void loadStaticData(StaticType type) {
        currencyToDollarConversionRateMap.putIfAbsent("USD", 1.0);
        currencyToDollarConversionRateMap.putIfAbsent("EUR", 0.85);
        currencyToDollarConversionRateMap.putIfAbsent("GBP", 1.08);
        currencyToDollarConversionRateMap.putIfAbsent("INR", 80.0);
        currencyToDollarConversionRateMap.putIfAbsent("AUD", 0.80);
        currencyToDollarConversionRateMap.putIfAbsent("YEN", 200.0);
    }

    /**
     * Gets the conversion value from static data
     *
     * @param currency
     * @return
     */
    @Override
    public double getCurrencyExchangeToUSD(String currency) {
        return currencyToDollarConversionRateMap.getOrDefault(currency, 1.0);
    }

    /**
     *  Gets all trades from cache for a given clientName
     *
     * @param clientName
     * @return
     */
    @Override
    public List<FxTrade> getTradesPerClient(String clientName) {
        return cache.getAllTradesForClient(clientName);
    }

    /**
     * Gets all trades from cache for a given productType
     * @param productType
     * @return
     */
    @Override
    public List<FxTrade> getTradesPerProductType(ProductType productType) {
        return cache.getTradesPerProductType(productType.name());
    }
}
