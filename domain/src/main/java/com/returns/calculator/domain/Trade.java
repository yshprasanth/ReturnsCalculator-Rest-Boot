package com.returns.calculator.domain;

import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public interface Trade extends Serializable {

    ProductType getProductType();
    BuySell getBuySell();
    String getCurrency();
    String getCounterParty();
    Date getTradeEffectiveDate();
    Date getTradeMaturityDate();
    BigDecimal getQuantity();
    BigDecimal getPrincipal();
    Double getAnnualInterestRate();
    Integer getCompoundFrequency();
    Term getCompoundFrequencyTerm();
    Integer getPaymentLength();

}
