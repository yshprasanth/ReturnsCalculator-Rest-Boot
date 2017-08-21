package com.returns.calculator.builder;

import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;
import com.returns.calculator.domain.server.impl.FxTrade;
import com.returns.calculator.domain.service.impl.Context;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class TradeBuilder {

    public static void buildFxTrade(FxTrade testObj) {

        testObj.setAnnualInterestRate(10.0d);
        testObj.setBuySellType(BuySell.Buy);
        testObj.setClientName("Test Client");
        testObj.setCompoundFrequency(3);
        testObj.setCompoundFrequencyTerm(Term.M);
        testObj.setCounterParty("Test Cpty");
        testObj.setCurrency("GBP");
        testObj.setDescription("Swaps 10Y2M");
        testObj.setPaymentLength(5);
        testObj.setPrincipal(BigDecimal.valueOf(1000.0d));
        testObj.setProductType(ProductType.SWAP);
        testObj.setQuantity(BigDecimal.valueOf(10000));

        ZoneId nyZone = ZoneId.of("America/New_York");
        LocalDateTime ldtNY = LocalDateTime.now(nyZone);
        Instant instantNY = ldtNY.toInstant(ZoneOffset.UTC);

        testObj.setTradeEffectiveDate(Date.from(instantNY));
        testObj.setTradeMaturityDate(Date.from(instantNY));

        testObj.setTradeId(101);
    }

    public static FxTrade buildSimpleFxTrade(int tradeId) {
        FxTrade testObj = new FxTrade();
        testObj.setProductType(ProductType.SWAP);
        testObj.setTradeId(tradeId);
        return testObj;
    }

    public static void buildContext(Context context) {

        context.setAnnualInterestRate(10.0d);
        context.setBuySell(BuySell.Buy);
        context.setClientName("Test Client");
        context.setCompoundFrequency(3);
        context.setCompoundFrequencyTerm(Term.M);
        context.setCounterParty("Test Cpty");
        context.setCurrency("GBP");
        context.setDescription("Swaps 10Y2M");
        context.setPaymentLength(5);
        context.setPrincipal(BigDecimal.valueOf(1000.0d));
        context.setProductType(ProductType.SWAP);
        context.setQuantity(BigDecimal.valueOf(10000));

        ZoneId nyZone = ZoneId.of("America/New_York");
        LocalDateTime ldtNY = LocalDateTime.now(nyZone);
        Instant instantNY = ldtNY.toInstant(ZoneOffset.UTC);

        context.setTradeEffectiveDate(Date.from(instantNY));
        context.setTradeMaturityDate(Date.from(instantNY));
    }
}
