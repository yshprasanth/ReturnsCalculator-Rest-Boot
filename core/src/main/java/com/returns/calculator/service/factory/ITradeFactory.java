package com.returns.calculator.service.factory;

import com.returns.calculator.domain.Trade;
import com.returns.calculator.domain.service.IContext;

import java.util.Optional;

public interface ITradeFactory<T extends Trade> {

    Optional<T> createTrade(Optional<? extends IContext> context);
}
