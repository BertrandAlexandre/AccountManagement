package fr.alexandrebertrand.am.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * User of the application
 */
@Entity
public class User {

    /*
     * Attributes
     */

    /** Unique identifier of an user */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** First name of the user */
    @NotBlank(message = "First name should be filled!")
    private String firstName;

    /** Last name of the user */
    @NotBlank(message = "Last name should be filled!")
    private String lastName;

    /** Born date of the user */
    @NotNull(message = "Born date should be filled!")
    private LocalDate bornDate;

    /** Gender of the user */
    @NotNull(message = "Gender should be filled!")
    private Gender gender;

    /** Profession of the user */
    private String profession;

    /** Creation date of the user */
    @NotNull(message = "Creation date should be filled!")
    private LocalDateTime creationDate;

    /** Last update date of the user */
    @NotNull(message = "Last update date should be filled!")
    private LocalDateTime updateDate;
   
    /** Accounts of the user */
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    /*
     * Constructors
     */

    /**
     * Empty constructor.
     */
    public User() {
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    /**
     * Initialize a new user
     * 
     * @param firstName  First name of the user
     * @param lastName   Last name of the user
     * @param bornDate   Born date of the user
     * @param gender     Gender of the user
     * @param profession Profession of the user
     */
    public User(String firstName, String lastName, LocalDate bornDate, Gender gender, String profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.gender = gender;
        this.profession = profession;
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    /*
     * Getters & Setters
     */

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setUpdateDate();
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setUpdateDate();
    }

    public LocalDate getBornDate() {
        return this.bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
        setUpdateDate();
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        setUpdateDate();
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public List<Account> getAccounts() {
        return this.accounts;
    }

}
