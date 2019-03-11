package com.example.roy.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.roy.com.model.Goods;
import com.example.roy.com.model.Orders;
import com.example.roy.com.service.OrderService;

@Controller
public class OrdersController {

    @Autowired
	private OrderService orderService;
    
    public String addOrder(Goods goods) {
    	Orders order = new Orders();
    	order.setGoodsId(goods.getId());
    	order.setQuantity(goods.getStock());
    	orderService.insert(order);
    	
		return null;
    	
    }
}
