package np.com.sagar88.leafylane.orderservice.controller;

import np.com.sagar88.leafylane.orderservice.service.NotificationService;
import np.com.sagar88.leafylane.orderservice.service.OrderService;
import np.com.sagar88.leafylane.orderservice.web.CreateOrderRequest;
import np.com.sagar88.leafylane.orderservice.web.CreateOrderResponse;
import np.com.sagar88.leafylane.orderservice.web.PreviewOrderRequest;
import np.com.sagar88.leafylane.orderservice.web.PreviewOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

/**
 * @author: Sagar Subedi,
 * Date : 2019-07-14
 */
@RestController
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @Autowired
    NotificationService notificationService;
    
    @PostMapping("/order")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest) {

        CreateOrderResponse createOrderResponse = orderService.createOrder(createOrderRequest);
        notificationService.sendNotification("Order created for billing address: " + createOrderResponse.getBillingAddress());
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<CreateOrderResponse> getOrderById(@PathVariable("orderId") String orderId) {

        CreateOrderResponse createOrderResponse = orderService.getOrderById(orderId);
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping("/order/myorders")
    public ResponseEntity<List<CreateOrderResponse>> getMyOrders() {

        List<CreateOrderResponse> createOrderResponse = orderService.getMyOrders();
        return ResponseEntity.ok(createOrderResponse);
    }

    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<CreateOrderResponse>> getAllOrders() {
        List<CreateOrderResponse> createOrderResponse = orderService.getAllOrders();
        return ResponseEntity.ok(createOrderResponse);
    }

    @PostMapping("/previewOrder")
    public ResponseEntity<PreviewOrderResponse> previewOrder(@RequestBody @Valid PreviewOrderRequest previewOrderRequest) {

        PreviewOrderResponse previewOrderResponse = orderService.previewOrder(previewOrderRequest);

        return ResponseEntity.ok(previewOrderResponse);
    }
}
