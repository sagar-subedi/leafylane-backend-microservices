package np.com.sagar88.leafylaneorderservice.service;

import np.com.sagar88.leafylaneorderservice.web.CreateOrderRequest;
import np.com.sagar88.leafylaneorderservice.web.CreateOrderResponse;
import np.com.sagar88.leafylaneorderservice.web.PreviewOrderRequest;
import np.com.sagar88.leafylaneorderservice.web.PreviewOrderResponse;

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
