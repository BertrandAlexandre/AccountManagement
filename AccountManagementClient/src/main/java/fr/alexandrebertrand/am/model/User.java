package fr.alexandrebertrand.am.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * User of the application
 */
public class User {

  /*
   * Attributes
   */

  /** Unique identifier of an user */
  private Long id;

  /** First name of the user */
  private String firstName;

  /** Last name of the user */
  private String lastName;

  /** Born date of the user */
  private LocalDate bornDate;

  /** Gender of the user */
  private Gender gender;

  /** Profession of the user */
  private String profession;

  /** Creation date of the user */
  private LocalDateTime creationDate;

  /** Last update date of the user */
  private LocalDateTime updateDate;
   
  /** Accounts of the user */
  private List<Account> accounts;

  /*
   * Constructors
   */

  /**
   * Empty constructor
   */
  public User() {
    accounts = new ArrayList<>();
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
  public User(String firstName, String lastName,
              LocalDate bornDate, Gender gender, String profession) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bornDate = bornDate;
    this.gender = gender;
    this.profession = profession;
    accounts = new ArrayList<>();
  }
  
  /*
   * Method
   */
  
  public String toString() {
    return "id: " + id + ", " +
           "firstName: " + firstName + ", " +
           "lastName: " + lastName + ", " +
           "bornDate: " + bornDate + ", " +
           "gender: " + gender + ", " +
           "profession: " + profession + ", " +
           "creationDate: " + creationDate + ", " +
           "updateDate: " + updateDate + ", " +
           "accountsNumber: " + accounts.size() + ".";
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
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBornDate() {
    return this.bornDate;
  }

  public void setBornDate(LocalDate bornDate) {
    this.bornDate = bornDate;
  }

  public Gender getGender() {
    return this.gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getProfession() {
    return this.profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public LocalDateTime getCreationDate() {
    return this.creationDate;
  }

  public LocalDateTime getUpdateDate() {
    return this.updateDate;
  }

  public List<Account> getAccounts() {
    return this.accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

}
