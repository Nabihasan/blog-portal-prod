package com.ms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ms.enume.Designation;
import com.ms.enume.Gender;
import com.ms.enume.Role;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



/**
 * This is @User Class.
 */
@Document(collection = "Users")
public class User {
    /**
     * This is minimum length of password.
     */
    private static final int PASSWORD_MIN_LENGTH = 8;
    /**
     * This is minimum length of field.
     */
    private static final int FIELD_MIN_LENGTH = 3;
    /**
     * This is minimum length of number.
     */
    private static final int NUM_MIN_LENGTH = 10;
    /**
     * This is max length of number.
     */
    private static final int NUM_MAX_LENGTH = 10;
    /**
     * This is userId.
     */
    @Id
    private String userID;
    /**
     * This is firstName.
     */
    @NotEmpty(message = "required")
    @Size(min = FIELD_MIN_LENGTH, message = "please fill first name properly")
    private String firstName;
    /**
     * This is lastName.
     */
    @NotEmpty(message = "required")
    @Size(min = FIELD_MIN_LENGTH, message = "please fill last name properly")
    private String lastName;
    /**
     * This is Email.
     */
    @NotEmpty(message = "required")
    @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$")
    private String email;
    /**
     * This is password.
     */
    @NotEmpty(message = "required")
    @Size(min = PASSWORD_MIN_LENGTH, message = "please fill password must be 8")
    private String password;
    /**
     * This is Contact.
     */
    @NotEmpty(message = "required")
    @Size(min = NUM_MIN_LENGTH, max = NUM_MAX_LENGTH, message = "please fill contact number correct 10 digit")
    private String contact;
    /**
     * This is gender.
     */
   // @NotNull(message = "required")
    private Gender gender;
    /**
     * This is Role.
     */
   //@NotNull(message = "required")
    private Role role;
    /**
     * This is designation.
     */
    //@NotNull(message = "required")
    private Designation designation;

    /**
     * getter method for @getUserID.
     * @return userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * setter method for @setUserID.
     * @param userID
     */
    public void setUserID(final String userID) {
        this.userID = userID;
    }

    /**
     * getter method for @getFirstName.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter method for @setFirstName.
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter method for @getLastName.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter method for @setLastName.
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter method for @getEmail.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter method for @setEmail.
     * @param email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * getter method for @getPassword.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter method for @setPassword.
     * @param password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * getter method for @getContact.
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * setter method for @setContact.
     * @param contact
     */
    public void setContact(final String contact) {
        this.contact = contact;
    }

    /**
     * getter method for @getGender.
     * @return gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * setter method for @setGender.
     * @param gender
     */
    public Gender setGender(final Gender gender) {
        return this.gender = gender;
    }

    /**
     * getter method for @getRole.
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * setter method for @setRole.
     * @param role
     */
    public Role setRole(final Role role) {
        return this.role=role;
    }

    /**
     * getter method for @getDesignation.
     * @return designation
     */
    public Designation getDesignation() {
        return designation;
    }

    /**
     * setter method for @setDesignation.
     * @param designation
     */
    public Designation setDesignation(final Designation designation) {
        return this.designation = designation;
    }

    /**
     * This is User no argument constructor.
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "User [userID=" + userID + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + ", contact=" + contact + ", gender=" + gender
                + ", role=" + role + ", designation=" + designation + "]";
    }

    /**
     * This is toString method.
     */
   
}
