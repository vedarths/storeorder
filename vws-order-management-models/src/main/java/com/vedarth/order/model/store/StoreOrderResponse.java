package com.vedarth.order.model.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StoreOrderResponse {

    public List<StoreOrder> getStoreOrders() {
        return storeOrders;
    }

    private List<StoreOrder> storeOrders;

    private StoreOrderResponse() {

    }

    @JsonCreator
    public StoreOrderResponse(@JsonProperty("storeOrders") List<StoreOrder> storeOrders) {
        this.storeOrders = storeOrders;
    }


    public static final class Builder {
        private List<StoreOrder> storeOrders;

        private Builder() {
        }

        public static Builder aStoreOrderResponse() {
            return new Builder();
        }

        public Builder withStoreOrders(List<StoreOrder> storeOrders) {
            this.storeOrders = storeOrders;
            return this;
        }

        public StoreOrderResponse build() {
            return new StoreOrderResponse(storeOrders);
        }
    }
}
