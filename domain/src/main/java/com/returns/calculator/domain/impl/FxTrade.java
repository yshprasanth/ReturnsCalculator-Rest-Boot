package com.returns.calculator.domain.impl;

import com.returns.calculator.domain.Trade;
import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;

import java.math.BigDecimal;
import java.util.Date;

public class FxTrade implements Trade{

    private static final long serialVersionUID = -121212121L;

    private ProductType productType;
    private BuySell buySellType;
    private String currency;
    private String counterParty;
    private Date tradeEffectiveDate;
    private Date tradeMaturityDate;
    private BigDecimal quantity;
    private BigDecimal principal;
    private Double annualInterestRate;
    private Integer compoundFrequency;
    private Term compoundFrequencyTerm;
    private Integer paymentLength;

    @Override
    public ProductType getProductType() {
        return productType;
    }

    @Override
    public BuySell getBuySell() {
        return buySellType;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public String getCounterParty() {
        return counterParty;
    }

    @Override
    public Date getTradeEffectiveDate() {
        return tradeEffectiveDate;
    }

    @Override
    public Date getTradeMaturityDate() {
        return tradeMaturityDate;
    }

    @Override
    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getPrincipal() {
        return principal;
    }

    @Override
    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

    @Override
    public Integer getCompoundFrequency() {
        return compoundFrequency;
    }

    @Override
    public Term getCompoundFrequencyTerm() {
        return compoundFrequencyTerm;
    }

    @Override
    public Integer getPaymentLength() {
        return paymentLength;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setBuySellType(BuySell buySellType) {
        this.buySellType = buySellType;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public void setTradeEffectiveDate(Date tradeEffectiveDate) {
        this.tradeEffectiveDate = tradeEffectiveDate;
    }

    public void setTradeMaturityDate(Date tradeMaturityDate) {
        this.tradeMaturityDate = tradeMaturityDate;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public void setAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setCompoundFrequency(Integer compoundFrequency) {
        this.compoundFrequency = compoundFrequency;
    }

    public void setCompoundFrequencyTerm(Term compoundFrequencyTerm) {
        this.compoundFrequencyTerm = compoundFrequencyTerm;
    }

    public void setPaymentLength(Integer paymentLength) {
        this.paymentLength = paymentLength;
    }

    @Override
    public String toString() {
        return "FxTrade{" +
                "productType=" + productType +
                ", buySellType=" + buySellType +
                ", currency='" + currency + '\'' +
                ", counterParty='" + counterParty + '\'' +
                ", tradeEffectiveDate=" + tradeEffectiveDate +
                ", tradeMaturityDate=" + tradeMaturityDate +
                ", quantity=" + quantity +
                ", principal=" + principal +
                ", annualInterestRate=" + annualInterestRate +
                ", compoundFrequency=" + compoundFrequency +
                ", compoundFrequencyTerm=" + compoundFrequencyTerm +
                ", paymentLength=" + paymentLength +
                '}';
    }
}
