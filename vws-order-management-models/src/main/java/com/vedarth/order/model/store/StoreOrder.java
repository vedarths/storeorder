package com.vedarth.order.model.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StoreOrder {

    private String storeId;
    private String orderNumber;
    private List<StoreOrderItem> storeOrderItems;

    @JsonCreator
    private StoreOrder(@JsonProperty("storeId") String storeId,
                       @JsonProperty("orderNumber") String orderNumber,
                       @JsonProperty("storeOrderItems") List<StoreOrderItem> storeOrderItems) {
        this.storeId = storeId;
        this.orderNumber = orderNumber;
        this.storeOrderItems = storeOrderItems;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<StoreOrderItem> getStoreOrderItems() {
        return storeOrderItems;
    }
}
