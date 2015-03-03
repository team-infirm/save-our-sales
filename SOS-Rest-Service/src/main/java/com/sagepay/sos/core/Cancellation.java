package com.sagepay.sos.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class Cancellation {

    private String transactionId;
    private DateTime executedTime;
    private Integer transactionValue;

    @JsonProperty
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty
    public DateTime getExecutedTime() {
        return executedTime;
    }

    public void setExecutedTime(DateTime executedTime) {
        this.executedTime = executedTime;
    }

    @JsonProperty
    public Integer getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Integer transactionValue) {
        this.transactionValue = transactionValue;
    }
}
