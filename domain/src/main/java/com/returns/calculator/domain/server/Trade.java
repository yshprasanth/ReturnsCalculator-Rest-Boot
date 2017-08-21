package com.returns.calculator.domain.server;

import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Server-side Trade interface
 */
public interface Trade extends Serializable, Comparable<Trade> {

    Integer getTradeId();
    String getClientName();
    ProductType getProductType();
    BuySell getBuySell();
    String getCurrency();
    String getCounterParty();
    Date getTradeEffectiveDate();
    Date getTradeMaturityDate();
    String getDescription();
    BigDecimal getQuantity();
    BigDecimal getPrincipal();
    Double getAnnualInterestRate();
    Integer getCompoundFrequency();
    Term getCompoundFrequencyTerm();
    Integer getPaymentLength();

    Double getCompoundInterest();
    Double getAnnualSimpleInterest();

}
