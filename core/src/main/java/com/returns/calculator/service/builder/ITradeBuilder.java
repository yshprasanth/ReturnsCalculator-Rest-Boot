package com.returns.calculator.service.builder;

import com.returns.calculator.domain.server.Trade;
import com.returns.calculator.domain.service.IContext;

import java.util.Optional;

/**
 * Builder Pattern object that will help to build Trade objects
 *
 * @param <T> Implementation of Trade interface
 */
public interface ITradeBuilder<T extends Trade> {

    /**
     * Builds Trade object from Context object
     *
     * @param context
     * @param trade
     */
    void buildTrade(Optional<? extends IContext> context, Optional<T> trade);

}