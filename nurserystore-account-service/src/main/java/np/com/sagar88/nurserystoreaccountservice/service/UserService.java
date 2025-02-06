package np.com.sagar88.nurserystoreaccountservice.service;

import np.com.sagar88.nurserystoreaccountservice.web.CreateUserRequest;
import np.com.sagar88.nurserystoreaccountservice.web.GetUserInfoResponse;
import np.com.sagar88.nurserystoreaccountservice.web.GetUserResponse;
import np.com.sagar88.nurserystoreaccountservice.web.UpdateUserRequest;
import np.com.sagar88.nurserystoreaccountservice.web.UpdateUserRequestFromAdmin;

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
