package np.com.sagar88.leafylane.paymentservice.service;

import np.com.sagar88.leafylane.paymentservice.web.CreatePaymentMethodRequest;
import np.com.sagar88.leafylane.paymentservice.web.GetPaymentMethodResponse;

import java.util.List;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
