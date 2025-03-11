package np.com.sagar88.leafylaneaddressservice.service;



import np.com.sagar88.leafylaneaddressservice.web.CreateAddressRequest;
import np.com.sagar88.leafylaneaddressservice.web.GetAddressResponse;
import np.com.sagar88.leafylaneaddressservice.web.UpdateAddressRequest;

import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2019-09-27
 */
public interface AddressService {

  void createAddress(CreateAddressRequest createAddressRequest);

  List<GetAddressResponse> getAddress();

  void updateAddress(UpdateAddressRequest updateAddressRequest);

  GetAddressResponse getAddressById(String addressId);

  void deleteAddressById(String addressId);
}
