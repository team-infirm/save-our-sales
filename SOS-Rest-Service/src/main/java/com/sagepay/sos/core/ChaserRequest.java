package com.sagepay.sos.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChaserRequest {
    private List<String> transactionIds;

    @JsonProperty
    public List<String> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionId(List<String> transactionId) {
        this.transactionIds = transactionId;
    }
}
