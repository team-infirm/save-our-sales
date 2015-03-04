package com.sagepay.sos.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChaserRequest {

    @JsonProperty
    private List<ChaserRequestContent> chaserRequests;

    public List<ChaserRequestContent> getChaserRequestContents() {
        return chaserRequests;
    }

    public void setChaserRequestContents(List<ChaserRequestContent> transactionId) {
        this.chaserRequests = transactionId;
    }
}
