package fr.alexandrebertrand.am.model;

import java.time.LocalDateTime;

/**
 * Account of an user
 */
public class Account {

    /*
     * Attributes
     */

    /** Unique identifier of an account */
    private Long id;

    /** User name of the account */
    private String username;

    /** Description of the account */
    private String description;

    /** Creation date of the account */
    private LocalDateTime creationDate;

    /** Last update date of the account */
    private LocalDateTime updateDate;

    /*
     * Constructors
     */

    /**
     * Empty constructor
     */
    public Account() {
    }

    /**
     * Initialize a new account
     * 
     * @param username     User name of the account
     * @param description  Description of the account
     */
    public Account(String username, String description) {
        this.username = username;
        this.description = description;
    }
    
    /*
     * Method
     */
    
    public String toString() {
        return "id: " + id + ", " +
               "username: " + username + ", " +
               "description: " + description + ", " +
               "creationDate: " + creationDate + ", " +
               "updateDate: " + updateDate + ".";
    }

    /*
     * Getters & Setters
     */

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

}
