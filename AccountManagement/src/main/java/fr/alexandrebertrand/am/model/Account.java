package fr.alexandrebertrand.am.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Account of an user
 */
@Entity
public class Account {

    /*
     * Attributes
     */

    /** Unique identifier of an account */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** User name of the account */
    @NotBlank(message = "User name should be filled!")
    private String username;

    /** Description of the account */
    private String description;

    /** Creation date of the account */
    @NotNull(message = "Creation date should be filled!")
    private LocalDateTime creationDate;

    /** Last update date of the account */
    @NotNull(message = "Last update date should be filled!")
    private LocalDateTime updateDate;
   
    /** User who owns this account */
    @JsonIgnore   
    @NotNull(message = "An user should be linked to this account!")
    @ManyToOne(optional = false)
    private User user;

    /*
     * Constructors
     */

    /**
     * Empty constructor
     */
    public Account() {
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    /**
     * Initialize a new account
     * 
     * @param username    User name of the account
     * @param description Description of the account
     * @param user        User who owns this account
     */
    public Account(String username, String description, User user) {
        this.username = username;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
        this.user = user;
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
        setUpdateDate();
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
        setUpdateDate();
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    private void setUpdateDate() {
        this.updateDate = LocalDateTime.now();
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
