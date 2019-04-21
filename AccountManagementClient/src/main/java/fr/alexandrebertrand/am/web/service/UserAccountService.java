package fr.alexandrebertrand.am.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import fr.alexandrebertrand.am.config.Urls;
import fr.alexandrebertrand.am.model.Account;

/**
 * Service of user account resources
 */
public class UserAccountService {

  /*
   * Attribute
   */

  /** Service mapper */
  private ObjectMapper objectMapper;

  /*
   * Constructor
   */

  /**
   * Build a new user service
   */
  public UserAccountService() {
    objectMapper = new ObjectMapper()
           .registerModule(new ParameterNamesModule())
           .registerModule(new Jdk8Module())
           .registerModule(new JavaTimeModule());
  }

  /*
   * Methods
   */

  /**
   * Get list of users
   * 
   * @param userId Identifier of the user
   * @return List of users
   */
  public List<Account> list(Long userId) {
    List<Account> accounts = new ArrayList<>();
    try {
      String input = ServiceReference.list(Urls.API_USERS + "/" + userId +
          "/accounts");
      accounts = objectMapper.readValue(input, new TypeReference<List<Account>>(){});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return accounts;
  }

  /**
   * Get data from an user
   * 
   * @param id     Identifier of the account
   * @param userId Identifier of the user
   * @return Searched user
   */
  public Account get(Long id, Long userId) {
    Account account = new Account();
    try {
      String input = ServiceReference.get(Urls.API_USERS + "/" + userId +
          "/accounts", id);
      account = objectMapper.readValue(input, Account.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return account;
  }

  /**
   * Create a new user
   * 
   * @param account Account to create
   */
  public void create(Account account) {
    try {
      String output = objectMapper.writeValueAsString(account);
      ServiceReference.create(Urls.API_USERS + "/" + account.getUserId() +
          "/accounts", output);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Update an user
   * 
   * @param account Account to update
   */
  public void update(Account account) {
    try {
      String output = objectMapper.writeValueAsString(account);
      ServiceReference.update(Urls.API_USERS + "/" + account.getUserId() +
          "/accounts", account.getId(), output);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

