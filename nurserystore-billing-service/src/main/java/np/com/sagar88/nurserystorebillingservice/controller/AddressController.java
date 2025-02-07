package np.com.sagar88.nurserystorebillingservice.controller;

import np.com.sagar88.nurserystorebillingservice.service.AddressService;
import np.com.sagar88.nurserystorebillingservice.web.CreateAddressRequest;
import np.com.sagar88.nurserystorebillingservice.web.GetAddressResponse;
import np.com.sagar88.nurserystorebillingservice.web.UpdateAddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Sagar Subedi,
 * Date : 2019-06-04
 */
@RestController
public class AddressController {
    
    @Autowired
    AddressService addressService;
    
    @PostMapping("/address")
    public ResponseEntity<Object> createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        addressService.createAddress(createAddressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/address")
    public ResponseEntity<Object> updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest) {
        addressService.updateAddress(updateAddressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/address")
    public ResponseEntity<List<GetAddressResponse>> getAddress() {
        List<GetAddressResponse> address = addressService.getAddress();
        return ResponseEntity.ok(address);
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<GetAddressResponse> getAddressById(@PathVariable("addressId") String addressId) {
        GetAddressResponse address = addressService.getAddressById(addressId);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<?> deleteAddressById(@PathVariable("addressId") String addressId) {
        addressService.deleteAddressById(addressId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
