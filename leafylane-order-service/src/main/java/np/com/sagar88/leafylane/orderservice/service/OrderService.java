package np.com.sagar88.leafylane.orderservice.service;

import np.com.sagar88.leafylane.orderservice.web.CreateOrderRequest;
import np.com.sagar88.leafylane.orderservice.web.CreateOrderResponse;
import np.com.sagar88.leafylane.orderservice.web.PreviewOrderRequest;
import np.com.sagar88.leafylane.orderservice.web.PreviewOrderResponse;

import java.util.List;

/**
 * @author: Sagar Subedi,
 * Date : 2019-09-20
 */
public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    PreviewOrderResponse previewOrder(PreviewOrderRequest previewOrderRequest);

    CreateOrderResponse getOrderById(String orderId);

    List<CreateOrderResponse> getMyOrders();

    List<CreateOrderResponse> getAllOrders();
}
