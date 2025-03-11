package np.com.sagar88.leafylaneaccountservice.service;

import np.com.sagar88.leafylaneaccountservice.web.CreateUserRequest;
import np.com.sagar88.leafylaneaccountservice.web.GetUserInfoResponse;
import np.com.sagar88.leafylaneaccountservice.web.GetUserResponse;
import np.com.sagar88.leafylaneaccountservice.web.UpdateUserRequest;
import np.com.sagar88.leafylaneaccountservice.web.UpdateUserRequestFromAdmin;

import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface UserService {

  String createUser(CreateUserRequest createUserRequest);

  GetUserResponse getUserByUserName(String userName);

  GetUserResponse getUserByUserId(String userId);

  GetUserInfoResponse getUserInfo();

  void updateUserInfo(UpdateUserRequest updateUserRequest);

  void deleteUserById(String userId);

  List<GetUserResponse> getAllUsers();

  void updateUser(String userId, UpdateUserRequestFromAdmin updateUserRequestFromAdmin);
}
