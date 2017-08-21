package com.returns.calculator.domain.service;

import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public interface IContext extends Serializable {

    String getClientName();
    ProductType getProductType();
    BuySell getBuySell();
    String getCurrency();
    String getCounterParty();
    String getDescription();
    Date getTradeEffectiveDate();
    Date getTradeMaturityDate();
    BigDecimal getQuantity();
    BigDecimal getPrincipal();
    Double getAnnualInterestRate();
    Integer getCompoundFrequency();
    Term getCompoundFrequencyTerm();
    Integer getPaymentLength();

    void setClientName(String clientName);
    void setProductType(ProductType productType);
    void setBuySell(BuySell buySell);
    void setCurrency(String currency);
    void setCounterParty(String counterParty);
    void setDescription(String description);
    void setTradeEffectiveDate(Date tradeEffectiveDate);
    void setTradeMaturityDate(Date tradeMaturityDate);
    void setQuantity(BigDecimal quantity);
    void setPrincipal(BigDecimal principal);
    void setAnnualInterestRate(Double annualInterestRate);
    void setCompoundFrequency(Integer compoundFrequency);
    void setCompoundFrequencyTerm(Term compoundFrequencyTerm);
    void setPaymentLength(Integer paymentLength);
}
