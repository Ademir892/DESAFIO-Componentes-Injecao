package com.ComponentesEInjecao.ComponentesInjecao.services;


import com.ComponentesEInjecao.ComponentesInjecao.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    public double total(Order order) {
        double discountAmount = order.getBasic() * (order.getDiscount() / 100);
        double shipmentCost = shippingService.shipment(order);
        return order.getBasic() - discountAmount + shipmentCost;
    }
}

