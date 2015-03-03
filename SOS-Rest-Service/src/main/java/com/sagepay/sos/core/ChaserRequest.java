package com.sagepay.sos.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChaserRequest {
    private String transactionId;

    @JsonProperty
    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    private RequestType requestType;


    @JsonProperty
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
