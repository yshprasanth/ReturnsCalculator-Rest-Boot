package com.returns.calculator.domain.service.impl;

import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;
import com.returns.calculator.domain.service.IContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Context object that will be passed across to Factory and other services.
 *
 * Holds decision making attributes and the values that were passed to API
 */
public class Context implements IContext{

    private static final long serialVersionUID = -11L;

    private String clientName;
    private ProductType productType;
    private BuySell buySellType;
    private String currency;
    private String counterParty;
    private String description;
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

    @Override
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public void setBuySell(BuySell buySell) {
        this.buySellType = buySell;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    @Override
    public void setTradeEffectiveDate(Date tradeEffectiveDate) {
        this.tradeEffectiveDate = tradeEffectiveDate;
    }

    @Override
    public void setTradeMaturityDate(Date tradeMaturityDate) {
        this.tradeMaturityDate = tradeMaturityDate;
    }

    @Override
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    @Override
    public void setAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public void setCompoundFrequency(Integer compoundFrequency) {
        this.compoundFrequency = compoundFrequency;
    }

    @Override
    public void setCompoundFrequencyTerm(Term compoundFrequencyTerm) {
        this.compoundFrequencyTerm = compoundFrequencyTerm;
    }

    @Override
    public void setPaymentLength(Integer paymentLength) {
        this.paymentLength = paymentLength;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getClientName() {
        return this.clientName;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Context{" +
                "clientName=" + clientName +
                ", productType=" + productType +
                ", buySellType=" + buySellType +
                ", currency='" + currency + '\'' +
                ", counterParty='" + counterParty + '\'' +
                ", description='" + description + '\'' +
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
