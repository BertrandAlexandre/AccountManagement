package fr.alexandrebertrand.am.dto;

/**
 * DTO for account update
 */
public class AccountUpdateDto {

    /*
     * Attributes
     */

    /** User name of the account */
    private String username;

    /** Description of the account */
    private String description;

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

}
