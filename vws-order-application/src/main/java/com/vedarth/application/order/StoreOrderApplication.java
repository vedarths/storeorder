package com.vedarth.application.order;


import com.vedarth.order.model.api.StoreOrderApi;
import com.vedarth.order.model.store.StoreOrder;
import com.vedarth.order.model.store.StoreOrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vedarth.order.model.store.StoreOrderResponse.Builder.aStoreOrderResponse;

@Component
public class StoreOrderApplication implements StoreOrderApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //store customer order statically to avoid repo usage
    private final Map<String, List<StoreOrder>> storeOrderMap;

    @Autowired
    public StoreOrderApplication() {
        this.storeOrderMap = new HashMap<>();
    }

    @Override
    public void create(StoreOrder storeOrder) {
        if (storeOrderMap.containsKey(storeOrder.getStoreId())) {
            storeOrderMap.get(storeOrder.getStoreId()).add(storeOrder);
        } else {
            List<StoreOrder> storeOrders = new ArrayList<>();
            storeOrders.add(storeOrder);
            storeOrderMap.put(storeOrder.getStoreId(), storeOrders);
        }
    }

    @Override
    public StoreOrderResponse getOrders(String storeId) {

        List<StoreOrder> storeOrders = new ArrayList<>();
        if (storeOrderMap.containsKey(storeId)) {
            storeOrders.addAll(storeOrderMap.get(storeId));
        }
        return aStoreOrderResponse().withStoreOrders(storeOrders)
                .build();
    }

    @Override
    public String receiptOrder(StoreOrder storeOrder) {
        logger.info("receipting store order with order number [{}]", storeOrder.getOrderNumber());
        return "SUCCESS";
    }
}
