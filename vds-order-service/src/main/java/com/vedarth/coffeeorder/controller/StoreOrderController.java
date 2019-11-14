package com.vedarth.coffeeorder.controller;


import com.vedarth.order.model.store.StoreOrder;
import com.vedarth.order.model.store.StoreOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/retail/order")
public class StoreOrderController {

    private final StoreOrderService storeOrderService;

    @Autowired
    public StoreOrderController(StoreOrderService storeOrderService) {
        this.storeOrderService = storeOrderService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody StoreOrder storeOrder) {
        storeOrderService.create(storeOrder);
    }


    @GetMapping("/get/{id}")
    @ResponseBody
    public StoreOrderResponse getOrders(@PathVariable("id") String storeId) {
        return storeOrderService.getOrders(storeId);
    }

}
