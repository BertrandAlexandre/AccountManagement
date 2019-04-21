package fr.alexandrebertrand.am;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import fr.alexandrebertrand.am.model.*;
import fr.alexandrebertrand.am.dto.*;

import reactor.core.publisher.Mono;

/**
 * Unit test of the application
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountManagementAppTest {

  @Autowired
  private WebTestClient webTestClient;

  /*
   * User management
   */

  @Test
  public void createUser() {
    UserCreationDto user = new UserCreationDto();
    user.setFirstName("John");
    user.setLastName("Smith");
    user.setBornDate(LocalDate.of(1992, 11, 23));
    user.setGender(Gender.MASCULINE);
    this.webTestClient.post().uri("/api/users")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .body(Mono.just(user), UserCreationDto.class)
        .exchange()
        .expectStatus().isCreated();
  }

}
