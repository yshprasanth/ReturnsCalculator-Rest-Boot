package com.returns.calculator.service;

import com.returns.calculator.domain.Trade;

import java.util.Optional;

public interface IService<T extends Trade> {

    void execute(Optional<T> trade) throws Exception;
}
