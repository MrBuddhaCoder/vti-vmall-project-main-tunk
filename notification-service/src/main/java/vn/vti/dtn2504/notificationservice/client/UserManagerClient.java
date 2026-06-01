package vn.vti.dtn2504.notificationservice.client;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import vn.vti.dtn2504.common.api.response.ApiResponse;
import vn.vti.dtn2504.notificationservice.client.dto.User;

@Component
public class UserManagerClient {

    private static final String USER_MANAGER_BASE_URL = "http://user-manager";

    private final RestClient restClient;

    public UserManagerClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl(USER_MANAGER_BASE_URL)
                .build();
    }

    public List<User> findAllUsers() {
        ApiResponse<List<User>> response = restClient.get()
                .uri("/api/v1/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        if (response == null || response.getData() == null) {
            return Collections.emptyList();
        }
        return response.getData();
    }
}
