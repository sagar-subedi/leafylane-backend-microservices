package np.com.sagar88.nurserystorepaymentservice.service.impl;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import np.com.sagar88.nurserystorepaymentservice.commons.exception.RunTimeExceptionPlaceHolder;
import np.com.sagar88.nurserystorepaymentservice.repository.UserPaymentCustomerRepository;
import np.com.sagar88.nurserystorepaymentservice.repository.dao.UserPaymentCustomer;
import np.com.sagar88.nurserystorepaymentservice.service.PaymentsService;
import np.com.sagar88.nurserystorepaymentservice.web.CreatePaymentRequest;
import np.com.sagar88.nurserystorepaymentservice.web.CreatePaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

import static np.com.sagar88.nurserystorepaymentservice.commons.util.CommonUtilityMethods.getUserIdFromToken;


/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private UserPaymentCustomerRepository userPaymentCustomerRepository;

    @Override
    public CreatePaymentResponse createPaymentRequest(CreatePaymentRequest createPaymentRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = getUserIdFromToken(authentication);
        UserPaymentCustomer customer = userPaymentCustomerRepository.findByUserId(userIdFromToken);

        Map<String, Object> params = new HashMap<>();
        Map<String, Object> autoPaymentMethods = new HashMap<>();
        autoPaymentMethods.put("enabled", true);
        autoPaymentMethods.put("allow_redirects", "never");


        params.put("amount", createPaymentRequest.getAmount());
        params.put("currency", createPaymentRequest.getCurrency());
        params.put("payment_method", createPaymentRequest.getPaymentMethodId());
        params.put("customer", customer.getPaymentCustomerId());
        params.put("confirm", true);
        params.put("automatic_payment_methods", autoPaymentMethods);



        try {
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            CreatePaymentResponse createPaymentResponse = new CreatePaymentResponse();

            String latestChargeId = paymentIntent.getLatestCharge();
            if (latestChargeId != null) {
                Charge latestCharge = Charge.retrieve(latestChargeId);

                if (latestCharge.getPaid()) {
                    createPaymentResponse.setPaymentId(latestCharge.getId());
                    LocalDateTime paymentTime = LocalDateTime.ofInstant(
                            Instant.ofEpochSecond(latestCharge.getCreated()), // Use `ofEpochSecond`
                            TimeZone.getDefault().toZoneId()
                    );
                    createPaymentResponse.setPaymentDate(paymentTime);
                    createPaymentResponse.setCaptured(true);
                    createPaymentResponse.setReceipt_url(latestCharge.getReceiptUrl());
                    return createPaymentResponse;
                }
            }

            createPaymentResponse.setCaptured(false);
            return createPaymentResponse;

        } catch (StripeException e) {
            e.printStackTrace();
            throw new RunTimeExceptionPlaceHolder("Error while processing payment!!");
        }

    }
}
