package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;
    
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName = "";

    @Min(value=0, message="must be greater than or equal to zero")
    @Max(value=10, message="must be less than or equal to zero")
    private int freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 charrs/digits")
    private String postalCode;

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getFreePasses() {
        return this.freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
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

}
