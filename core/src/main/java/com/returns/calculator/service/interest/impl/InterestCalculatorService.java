package com.returns.calculator.service.interest.impl;

import com.returns.calculator.domain.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InterestCalculatorService implements IService<FxTrade> {

    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {

    }
}
