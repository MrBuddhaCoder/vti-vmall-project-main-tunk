package vn.vti.dtn2504.usermanager.service;

import java.util.List;

import vn.vti.dtn2504.usermanager.dto.request.CreateAccountRequest;
import vn.vti.dtn2504.usermanager.dto.response.CreateAccountResponse;
import vn.vti.dtn2504.usermanager.dto.response.UserResponse;

public interface UserService {
    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);

    List<UserResponse> findAllUsers();
}
