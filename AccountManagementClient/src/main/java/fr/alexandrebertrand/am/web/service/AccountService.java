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
import fr.alexandrebertrand.am.model.User;

/**
 * Service of account resources
 */
public class AccountService {
    
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
    public AccountService() {
        objectMapper = new ObjectMapper()
                   .registerModule(new ParameterNamesModule())
                   .registerModule(new Jdk8Module())
                   .registerModule(new JavaTimeModule());
    }
    
    /*
     * Methods
     */
    
    /**
     * Get list of accounts
     * 
     * @return List of accounts
     */
    public List<Account> list() {
        List<Account> accounts = new ArrayList<>();
        try {
            String input = ServiceReference.list(Urls.API_ACCOUNTS);
            accounts = objectMapper.readValue(input, new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
    /**
     * Get data from an account
     * 
     * @param id Identifier of the account
     * @return Searched account
     */
    public Account get(Long id) {
        Account account = new Account();
        try {
            String input = ServiceReference.get(Urls.API_ACCOUNTS, id);
            account = objectMapper.readValue(input, new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }
    
    /**
     * Create a new account
     * 
     * @param user Account to create
     */
    public void create(Account account) {
        try {
            String output = objectMapper.writeValueAsString(account);
            ServiceReference.create(Urls.API_ACCOUNTS, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Update an account
     * 
     * @param user Account to update
     */
    public void update(Account account) {
        try {
            String output = objectMapper.writeValueAsString(account);
            ServiceReference.update(Urls.API_ACCOUNTS, account.getId(), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
