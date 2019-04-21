package fr.alexandrebertrand.am.dto;

import java.time.LocalDate;

import fr.alexandrebertrand.am.model.Gender;

/**
 * DTO for user update
 */
public class UserUpdateDto {

  /*
   * Attributes
   */

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

  /*
   * Getters & Setters
   */

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

}
