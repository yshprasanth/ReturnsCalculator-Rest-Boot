package com.returns.calculator.service.dao.impl;

import com.returns.calculator.domain.impl.FxTrade;
import com.returns.calculator.service.IService;

import java.util.Optional;

public class DAOService implements IService<FxTrade> {

    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        // Persist Trade
    }
}
