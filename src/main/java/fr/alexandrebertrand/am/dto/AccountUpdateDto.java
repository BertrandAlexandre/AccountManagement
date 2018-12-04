package fr.alexandrebertrand.am.dto;

/**
 * Dto for account update.
 */
public class AccountUpdateDto {

    /*
     * Attributes.
     */

    /** Username of the account. */
    private String username;

    /** Description of the account. */
    private String description;

    /*
     * Getters.
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
