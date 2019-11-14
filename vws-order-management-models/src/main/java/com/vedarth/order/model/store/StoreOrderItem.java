package com.vedarth.order.model.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreOrderItem {

    private String partNumber;
    private String serialNumber;
    private Integer quantity;

    @JsonCreator
    public StoreOrderItem(@JsonProperty("partNumber") String partNumber,
                          @JsonProperty("serialNumber") String serialNumber,
                          @JsonProperty("quantity") Integer quantity) {
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.quantity = quantity;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
