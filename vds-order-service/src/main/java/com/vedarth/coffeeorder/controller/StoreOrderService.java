package com.vedarth.coffeeorder.controller;

import com.vedarth.application.order.StoreOrderApplication;
import com.vedarth.order.model.api.StoreOrderApi;
import com.vedarth.order.model.store.StoreOrder;
import com.vedarth.order.model.store.StoreOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreOrderService implements StoreOrderApi {

    private final StoreOrderApplication storeOrderApplication;

    @Autowired
    public StoreOrderService(StoreOrderApplication storeOrderApplication) {
        this.storeOrderApplication = storeOrderApplication;
    }

    @Override
    public void create(StoreOrder storeOrder) {
        storeOrderApplication.create(storeOrder);
    }

    @Override
    public StoreOrderResponse getOrders(String storeId) {
        return storeOrderApplication.getOrders(storeId);
    }

    @Override
    public String receiptOrder(StoreOrder storeOrder) {
        return storeOrderApplication.receiptOrder(storeOrder);
    }
}
