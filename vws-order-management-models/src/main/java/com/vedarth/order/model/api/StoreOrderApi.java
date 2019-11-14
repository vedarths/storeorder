package com.vedarth.order.model.api;

import com.vedarth.order.model.store.StoreOrder;
import com.vedarth.order.model.store.StoreOrderResponse;

public interface StoreOrderApi {

    void create(StoreOrder storeOrder);

    StoreOrderResponse getOrders(String storeId);

    String receiptOrder(StoreOrder storeOrder);
}
