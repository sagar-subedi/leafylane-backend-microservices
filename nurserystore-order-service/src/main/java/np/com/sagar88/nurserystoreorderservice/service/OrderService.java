package np.com.sagar88.nurserystoreorderservice.service;

import np.com.sagar88.nurserystoreorderservice.web.CreateOrderRequest;
import np.com.sagar88.nurserystoreorderservice.web.CreateOrderResponse;
import np.com.sagar88.nurserystoreorderservice.web.PreviewOrderRequest;
import np.com.sagar88.nurserystoreorderservice.web.PreviewOrderResponse;

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
