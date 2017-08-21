package com.returns.calculator.service.enrichment.impl;

import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.service.IService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("enrichmentService")
public class EnrichmentService implements IService<FxTrade> {

    @Override
    public void execute(Optional<FxTrade> trade) throws Exception {
        // To Do
    }
}

