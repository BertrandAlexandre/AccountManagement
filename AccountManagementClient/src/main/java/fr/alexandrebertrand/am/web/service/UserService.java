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
import fr.alexandrebertrand.am.model.User;

/**
 * Service of user resources
 */
public class UserService {
    
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
    public UserService() {
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
     * @return List of users
     */
    public List<User> list() {
        List<User> users = new ArrayList<>();
        try {
            String input = ServiceReference.list(Urls.API_USERS);
            users = objectMapper.readValue(input, new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    /**
     * Get data from an user
     * 
     * @param id Identifier of the user
     * @return Searched user
     */
    public User get(Long id) {
        User user = new User();
        try {
            String input = ServiceReference.get(Urls.API_USERS, id);
            user = objectMapper.readValue(input, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    /**
     * Create a new user
     * 
     * @param user User to create
     */
    public void create(User user) {
        try {
            String output = objectMapper.writeValueAsString(user);
            ServiceReference.create(Urls.API_USERS, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Update an user
     * 
     * @param user User to update
     */
    public void update(User user) {
        try {
            String output = objectMapper.writeValueAsString(user);
            ServiceReference.update(Urls.API_USERS, user.getId(), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
