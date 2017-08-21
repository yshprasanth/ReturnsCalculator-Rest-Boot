package com.returns.calculator.service;

import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.StaticType;
import com.returns.calculator.domain.server.Trade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IService<T extends Trade> {

    void execute(Optional<T> trade) throws Exception;

    default void loadStaticData(StaticType type) {
        // do nothing
    }

    default double getCurrencyExchangeToUSD(String currency) {
        return 1.0;
    }

    default List<T> getTradesPerClient(String clientName) {
     return new ArrayList<>();
    }

    default List<T> getTradesPerProductType(ProductType productType) {
        return new ArrayList<>();
    }

}
