package fr.alexandrebertrand.am.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * DTO for account creation
 */
public class AccountCreationDto {

  /*
   * Attributes
   */

  /** User name of the account */
  @NotBlank(message = "User name should be filled")
  private String username;

  /** Description of the account */
  private String description;

  /** Identifier of the user who owns this account */
  @NotNull(message = "User identifier should be filled!")
  private Long userId;

  /*
   * Getters & Setters
   */

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

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

}
