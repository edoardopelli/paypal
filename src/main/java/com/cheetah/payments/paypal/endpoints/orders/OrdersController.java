package com.cheetah.payments.paypal.endpoints.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheetah.payments.paypal.order.request.OrderRequest;
import com.cheetah.payments.paypal.order.response.OrderResponse;
import com.cheetah.payments.paypal.service.orders.OrdersService;

@RestController
@RequestMapping("/paypal")
public class OrdersController {

	@Autowired
	private OrdersService service ;
	
	@PostMapping("/create/order")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
		OrderResponse response = service.createOrder(request);
		if(response==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(response);
	}
	
}
