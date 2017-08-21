package com.returns.calculator.service.factory;

import com.returns.calculator.domain.server.Trade;
import com.returns.calculator.domain.service.IContext;

import java.util.Optional;

/**
 * Parent interface for Trade Factory class
 * @param <T>
 */
public interface ITradeFactory<T extends Trade> {

    Optional<T> createTrade(Optional<? extends IContext> context);
}
