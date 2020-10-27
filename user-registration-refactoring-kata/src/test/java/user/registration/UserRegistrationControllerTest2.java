package user.registration;

import org.apache.catalina.connector.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.assertj.core.api.BDDAssertions.then;

public class UserRegistrationControllerTest2 {


    @Before
    public void setup() throws IOException {
        UserRegistrationController.orm = new UserOrmRepository();
        EmailServiceInterface emailService = new EmailService();
    }

    @Test
    public void should_success_when_everything_is_valid() throws Exception {
        HttpServletRequest request = new ApplicationHttpRequest();
        request.setAttribute("name", "Codium");
        request.setAttribute("email", "my@email.com");
        request.setAttribute("password", "myPass_123123");

        ResponseEntity<User> entity = UserRegistrationController.createUser(request);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
//    @Test
//    public void should_returns_a_user_with_the_email_when_everything_is_valid() throws Exception {
//        String arguments = "?name=Codium&email=my@email.com&password=myPass_123123";
//        String url = "http://localhost:" + this.port + "/users" + arguments;
//
//        ResponseEntity<User> entity = this.testRestTemplate.postForEntity(url, null, User.class);
//
//        then(entity.getBody().getEmail()).isEqualTo("my@email.com");
//    }
//
//    @Test
//    public void should_returns_a_user_with_the_name_when_everything_is_valid() throws Exception {
//        String arguments = "?name=Codium&email=my@email.com&password=myPass_123123";
//        String url = "http://localhost:" + this.port + "/users" + arguments;
//
//        ResponseEntity<User> entity = this.testRestTemplate.postForEntity(url, null, User.class);
//
//        then(entity.getBody().getName()).isEqualTo("Codium");
//    }
//
//    @Test
//    public void should_fail_when_password_is_short() throws Exception {
//        String arguments = "?name=Codium&email=my@email.com&password=myPass_";
//        String url = "http://localhost:" + this.port + "/users" + arguments;
//
//        ResponseEntity<String> entity = this.testRestTemplate.postForEntity(url, null, String.class);
//
//        then(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//        then(entity.getBody().toString()).isEqualTo("The password is not valid");
//    }
//
//    @Test
//    public void should_fail_when_email_is_used() throws Exception {
//        String arguments = "?name=Codium&email=same@email.com&password=myPass_123123";
//        String url = "http://localhost:" + this.port + "/users" + arguments;
//        this.testRestTemplate.postForEntity(url, null, String.class);
//
//        ResponseEntity<String> entity = this.testRestTemplate.postForEntity(url, null, String.class);
//
//        then(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//        then(entity.getBody().toString()).isEqualTo("The email is already in use");
//    }
//
//
//    @Test
//    public void should_generate_a_random_id_when_everything_is_valid() throws Exception {
//        String arguments = "?name=Codium&email=my@email.com&password=myPass_123123";
//        String url = "http://localhost:" + this.port + "/users" + arguments;
//
//        ResponseEntity<User> entity = this.testRestTemplate.postForEntity(url, null, User.class);
//
//        then(entity.getBody().getId()).isNotEqualTo(1);
//    }

}