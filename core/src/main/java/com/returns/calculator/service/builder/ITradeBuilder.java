package com.returns.calculator.service.builder;

import com.returns.calculator.domain.Trade;
import com.returns.calculator.domain.service.IContext;

import java.util.Optional;

public interface ITradeBuilder<T extends Trade> {

    void buildTrade(Optional<? extends IContext> context, Optional<T> trade);

}