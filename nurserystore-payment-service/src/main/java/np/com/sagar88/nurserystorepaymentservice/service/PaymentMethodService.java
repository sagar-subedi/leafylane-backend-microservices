package np.com.sagar88.nurserystorepaymentservice.service;

import np.com.sagar88.nurserystorepaymentservice.web.CreatePaymentMethodRequest;
import np.com.sagar88.nurserystorepaymentservice.web.GetPaymentMethodResponse;

import java.util.List;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);

    List<GetPaymentMethodResponse> getAllMyPaymentMethods();

    GetPaymentMethodResponse getMyPaymentMethodById(String paymentMethodId);
}
