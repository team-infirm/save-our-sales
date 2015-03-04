package com.sagepay.sos.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class Cancellation {

    private String transactionId;
    private DateTime executedTime;
    private Integer transactionValue;
    private String vendorName;
    private String vendorId;
    private Boolean hasBeenRecoveredPreviously;
    private String customerEmail;
    private String customerMobileNumber;

    @JsonProperty
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @JsonProperty
    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @JsonProperty
    public Boolean getHasBeenRecoveredPreviously() {
        return hasBeenRecoveredPreviously;
    }

    public void setHasBeenRecoveredPreviously(Boolean hasBeenRecoveredPreviously) {
        this.hasBeenRecoveredPreviously = hasBeenRecoveredPreviously;
    }

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

    @JsonProperty
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }
}
