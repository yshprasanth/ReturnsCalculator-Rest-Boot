package com.returns.calculator.domain.server.impl;

import com.returns.calculator.domain.metadata.BuySell;
import com.returns.calculator.domain.metadata.ProductType;
import com.returns.calculator.domain.metadata.Term;
import com.returns.calculator.domain.server.Trade;

import java.math.BigDecimal;
import java.util.Date;

public class FxTrade implements Trade{

    private static final long serialVersionUID = -121212121L;

    private Integer tradeId;
    private String clientName;
    private ProductType productType;
    private BuySell buySellType;
    private String currency;
    private String counterParty;
    private Date tradeEffectiveDate;
    private Date tradeMaturityDate;
    private String description;
    private BigDecimal quantity;
    private BigDecimal principal;
    private Double annualInterestRate;
    private Integer compoundFrequency;
    private Term compoundFrequencyTerm;
    private Integer paymentLength;

    private Double compoundInterest;
    private Double annualSimpleInterest;

    @Override
    public Integer getTradeId() {
        return tradeId;
    }

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
    public String getDescription() {
        return description;
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

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
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

    public void setDescription(String description) {
        this.description = description;
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
    public int compareTo(Trade o) {

        if(this.productType==o.getProductType() &&
                this.buySellType==o.getBuySell() &&
                this.counterParty.equals(o.getCounterParty()) &&
                this.currency.equals(o.getCurrency()) &&
                this.annualInterestRate.equals(o.getAnnualInterestRate()) &&
                this.tradeEffectiveDate.equals(o.getTradeEffectiveDate()) &&
                this.tradeMaturityDate.equals(o.getTradeMaturityDate()) &&
                this.compoundFrequency.equals(o.getCompoundFrequency()) &&
                this.compoundFrequencyTerm==o.getCompoundFrequencyTerm() &&
                this.paymentLength.equals(o.getPaymentLength()) &&
                this.quantity.equals(o.getQuantity()) &&
                this.principal.equals(o.getPrincipal())){
            return 0;
        }
        else
            return this.tradeId.compareTo(o.getTradeId());

    }

    @Override
    public Double getCompoundInterest() {
        return compoundInterest;
    }

    @Override
    public Double getAnnualSimpleInterest() {
        return annualSimpleInterest;
    }

    public void setCompoundInterest(Double compoundInterest) {
        this.compoundInterest = compoundInterest;
    }

    public void setAnnualSimpleInterest(Double simpleInterest) {
        this.annualSimpleInterest = simpleInterest;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String getClientName() {
        return this.clientName;
    }

    @Override
    public String toString() {
        return "FxTrade{" +
                "tradeId=" + tradeId +
                ", clientName=" + clientName +
                ", productType=" + productType +
                ", buySellType=" + buySellType +
                ", currency='" + currency + '\'' +
                ", counterParty='" + counterParty + '\'' +
                ", description=" + description +
                ", tradeEffectiveDate=" + tradeEffectiveDate +
                ", tradeMaturityDate=" + tradeMaturityDate +
                ", quantity=" + quantity +
                ", principal=" + principal +
                ", annualInterestRate=" + annualInterestRate +
                ", compoundFrequency=" + compoundFrequency +
                ", compoundFrequencyTerm=" + compoundFrequencyTerm +
                ", paymentLength=" + paymentLength +
                ", compoundInterest=" + compoundInterest +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }
}
