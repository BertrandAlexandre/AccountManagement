package fr.alexandrebertrand.am.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import fr.alexandrebertrand.am.model.Gender;

/**
 * DTO for user creation
 */
public class UserCreationDto {

    /*
     * Attributes
     */

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
