package np.com.sagar88.leafylane.paymentservice.service;


import np.com.sagar88.leafylane.paymentservice.web.CreatePaymentRequest;
import np.com.sagar88.leafylane.paymentservice.web.CreatePaymentResponse;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
