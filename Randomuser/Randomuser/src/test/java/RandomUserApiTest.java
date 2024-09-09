import TestObjects.ApiResponse;
import TestObjects.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUserApiTest {

    private static String URL = "https://randomuser.me/api/";

    @Test
    public void simplePositiveTests() throws JsonProcessingException {
        RequestSpecification request = RestAssured.given();
        Response response = request.get(URL);
        assertThat(response.getStatusCode()).isEqualTo(200);


        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponse apiResponse = objectMapper.readValue(response.getBody().asString(), ApiResponse.class);


        assertThat(apiResponse.getResults()).isNotEmpty();
        List<User> femaleUsers = apiResponse.getResults().stream()
                .filter(user -> user.getGender().equals("female"))
                .collect(Collectors.toList());
        assertThat(femaleUsers).isNotEmpty();
        assertThat(apiResponse.getResults()).allSatisfy(user -> {
            assertThat(user.getName().getFirst()).isNotBlank();
            assertThat(user.getEmail()).contains("@");
            assertThat(user.getLogin().getUuid()).hasSize(36);
        });
    }

    @Test
    public void haveAtLeastOneWoman() throws JsonProcessingException {
        RequestSpecification request = RestAssured.given();
        request.queryParams("results", "5");
        Response response = request.get(URL);
        assertThat(response.getStatusCode()).isEqualTo(200);


        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponse apiResponse = objectMapper.readValue(response.getBody().asString(), ApiResponse.class);


        assertThat(apiResponse.getResults()).isNotEmpty();
        List<User> femaleUsers = apiResponse.getResults().stream()
                .filter(user -> user.getGender().equals("female"))
                .collect(Collectors.toList());
        assertThat(femaleUsers).isNotEmpty();
    }

    @Test
    public void notHaveAnyMan() throws JsonProcessingException {
        RequestSpecification request = RestAssured.given();
        request.queryParams("results", "5");
        request.queryParams("gender", "female");
        Response response = request.get(URL);
        assertThat(response.getStatusCode()).isEqualTo(200);


        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponse apiResponse = objectMapper.readValue(response.getBody().asString(), ApiResponse.class);


        assertThat(apiResponse.getResults()).isNotEmpty();
        List<User> femaleUsers = apiResponse.getResults().stream()
                .filter(user -> user.getGender().equals("male"))
                .collect(Collectors.toList());
        assertThat(femaleUsers.isEmpty());
    }


}







