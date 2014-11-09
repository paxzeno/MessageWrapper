package com.mars_crater.sandbox.entities.vo;

import com.mars_crater.messages.Type;

import java.math.BigDecimal;

/**
 * Created by ateixeira on 08-11-2014.
 */
public class TotalsVO {

    private Integer index;
    private Type type;
    private Integer loadedQuantity;
    private BigDecimal loadedAmount;
    private Integer distributedQuantity;
    private Integer recycledQuantity;
    private BigDecimal recycledAmount;
    private Integer nonRecycledQuantity;
    private BigDecimal nonRecycledAmount;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getLoadedQuantity() {
        return loadedQuantity;
    }

    public void setLoadedQuantity(Integer loadedQuantity) {
        this.loadedQuantity = loadedQuantity;
    }

    public BigDecimal getLoadedAmount() {
        return loadedAmount;
    }

    public void setLoadedAmount(BigDecimal loadedAmount) {
        this.loadedAmount = loadedAmount;
    }

    public Integer getDistributedQuantity() {
        return distributedQuantity;
    }

    public void setDistributedQuantity(Integer distributedQuantity) {
        this.distributedQuantity = distributedQuantity;
    }

    public Integer getRecycledQuantity() {
        return recycledQuantity;
    }

    public void setRecycledQuantity(Integer recycledQuantity) {
        this.recycledQuantity = recycledQuantity;
    }

    public BigDecimal getRecycledAmount() {
        return recycledAmount;
    }

    public void setRecycledAmount(BigDecimal recycledAmount) {
        this.recycledAmount = recycledAmount;
    }

    public Integer getNonRecycledQuantity() {
        return nonRecycledQuantity;
    }

    public void setNonRecycledQuantity(Integer nonRecycledQuantity) {
        this.nonRecycledQuantity = nonRecycledQuantity;
    }

    public BigDecimal getNonRecycledAmount() {
        return nonRecycledAmount;
    }

    public void setNonRecycledAmount(BigDecimal nonRecycledAmount) {
        this.nonRecycledAmount = nonRecycledAmount;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.getIndex() != null) {
            stringBuffer.append("\nindex:" + this.getIndex());
        }
        if (this.getType() != null) {
            stringBuffer.append("\ntype:" + this.getType());
        }
        if (this.getDistributedQuantity() != null) {
            stringBuffer.append("\ndistributed quantity:" + this.getDistributedQuantity());
        }
        if (this.getLoadedQuantity() != null) {
            stringBuffer.append("\ndloaded quantity:" + this.getLoadedQuantity());
        }
        if (this.getLoadedAmount() != null) {
            stringBuffer.append("\nloaded amount:" + this.getLoadedAmount());
        }
        if (this.getRecycledQuantity() != null) {
            stringBuffer.append("\nrecycled quantity:" + this.getRecycledQuantity());
        }
        if (this.getRecycledAmount() != null) {
            stringBuffer.append("\nrecycled amount:" + this.getRecycledAmount());
        }
        if (this.getNonRecycledQuantity() != null) {
            stringBuffer.append("\nnon recycled quantity:" + this.getNonRecycledQuantity());
        }
        if (this.getNonRecycledAmount() != null) {
            stringBuffer.append("\nnon recycled amount:" + this.getNonRecycledAmount());
        }
        return stringBuffer.toString();
    }
}
