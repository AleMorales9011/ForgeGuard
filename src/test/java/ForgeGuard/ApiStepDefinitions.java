package ForgeGuard;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiStepDefinitions {
    private Response response;

    @When("I send a health check request")
    public void i_send_a_health_check_request() {
        response = given()
                .baseUri("https://practice.expandtesting.com/notes/api")
                .when()
                .get("/health-check");
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(int expectedStatus) {
        System.out.println("Actual Response Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        assertEquals(expectedStatus, response.getStatusCode(), "API response status mismatch");
    }

    @When("I send a login request")
    public void i_send_a_login_request() {
        response = given()
                .baseUri("https://practice.expandtesting.com/notes/api")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"practi1@expandtesting.com\", \"password\": \"SuperSecurePassword123!\" }")
                .when()
                .post("/users/login");
    }

    @Then("the response status must be {int}")
    public void the_response_status_must_be(int expectedStatus) {
        System.out.println("Actual Response Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        assertEquals(expectedStatus, response.getStatusCode(), "API response status mismatch");
    }

    @When("I request user info")
    public void i_request_user_info() {
        response = given()
                .baseUri("https://practice.expandtesting.com/notes/api")
                .contentType(ContentType.JSON)
                .header("x-auth-token", "9f1272d3b3e146089d475a1ee024dc95a6451739c975432ea41d0e2ed76c77a6")
                .body("{ \"email\": \"practi1@expandtesting.com\", \"password\": \"SuperSecurePassword123!\" }")
                .when()
                .get("/users/profile");
    }

    @Then("the response must be {int}")
    public void the_response_must_be(int expectedStatus) {
        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        assertEquals(expectedStatus, response.getStatusCode(), "There is a status mismatch");
    }
}

