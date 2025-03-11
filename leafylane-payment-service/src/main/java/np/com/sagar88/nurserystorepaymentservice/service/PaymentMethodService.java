package np.com.sagar88.leafylanepaymentservice.service;

import np.com.sagar88.leafylanepaymentservice.web.CreatePaymentMethodRequest;
import np.com.sagar88.leafylanepaymentservice.web.GetPaymentMethodResponse;

import java.util.List;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
