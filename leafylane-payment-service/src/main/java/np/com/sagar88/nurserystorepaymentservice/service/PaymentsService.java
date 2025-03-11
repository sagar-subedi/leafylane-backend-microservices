package np.com.sagar88.leafylanepaymentservice.service;


import np.com.sagar88.leafylanepaymentservice.web.CreatePaymentRequest;
import np.com.sagar88.leafylanepaymentservice.web.CreatePaymentResponse;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
