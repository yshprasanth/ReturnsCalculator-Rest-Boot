package com.returns.calculator.service.validation.impl;

import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("validationService")
public class ValidationService implements IService<FxTrade> {
    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        // Todo
    }
}
