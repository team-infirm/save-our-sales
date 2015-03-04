package com.sagepay.sos.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Chris on 3/4/2015.
 */
public class ChaserRequestContent {

    @JsonProperty
    private String id;

    @JsonProperty
    private String amount;

    public ChaserRequestContent() {}

    public ChaserRequestContent(String id, String amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
