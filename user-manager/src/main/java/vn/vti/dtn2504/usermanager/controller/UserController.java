package vn.vti.dtn2504.usermanager.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vti.dtn2504.common.api.response.ApiResponse;
import vn.vti.dtn2504.usermanager.dto.response.UserResponse;
import vn.vti.dtn2504.usermanager.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> findAllUsers() {
        return ResponseEntity.ok(ApiResponse.success(userService.findAllUsers()));
    }
}
