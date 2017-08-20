package com.returns.calculator.service.validation.impl;

import com.returns.calculator.domain.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService implements IService<FxTrade> {
    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        // Todo
    }
}
