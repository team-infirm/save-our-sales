package com.sagepay.sos.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChaserRequest {

    @JsonProperty
    private List<String> transactionIds;

    public List<String> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionId(List<String> transactionId) {
        this.transactionIds = transactionId;
    }
}
