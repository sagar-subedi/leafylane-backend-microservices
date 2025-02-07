package np.com.sagar88.nurserystorepaymentservice.service;


import np.com.sagar88.nurserystorepaymentservice.web.CreatePaymentRequest;
import np.com.sagar88.nurserystorepaymentservice.web.CreatePaymentResponse;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
public interface PaymentsService {
    CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest);
}
