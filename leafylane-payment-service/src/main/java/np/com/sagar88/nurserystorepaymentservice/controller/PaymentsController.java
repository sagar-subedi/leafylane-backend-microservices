package np.com.sagar88.leafylanepaymentservice.controller;

import lombok.extern.slf4j.Slf4j;
import np.com.sagar88.leafylanepaymentservice.service.PaymentsService;
import np.com.sagar88.leafylanepaymentservice.web.CreatePaymentRequest;
import np.com.sagar88.leafylanepaymentservice.web.CreatePaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
@RestController
@Slf4j
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping("/pay")
    public ResponseEntity<?> doPayment(@RequestBody @Valid CreatePaymentRequest createPaymentRequest) {
        CreatePaymentResponse paymentRequest = paymentsService.createPaymentRequest(createPaymentRequest);
        return new ResponseEntity<>(paymentRequest, HttpStatus.CREATED);
    }

}
