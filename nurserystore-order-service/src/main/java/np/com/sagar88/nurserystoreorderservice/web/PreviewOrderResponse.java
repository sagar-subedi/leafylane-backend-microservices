package np.com.sagar88.nurserystoreorderservice.web;

import np.com.sagar88.nurserystoreorderservice.feign.web.GetAddressResponse;
import np.com.sagar88.nurserystoreorderservice.repository.dao.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sagar Subedi, Date : 06-Dec-2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreviewOrderResponse {
    private List<OrderItem> orderItems = new ArrayList<>();
    private GetAddressResponse shippingAddress;
    private GetAddressResponse billingAddress;
    private Card card;
    private Double itemsTotalPrice;
    private Double taxPrice;
    private Double shippingPrice;
    private Double totalPrice;
}
