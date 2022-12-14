package com.example.med_app;

public class Organization {
    private String organizationName;
    private String country;
    private String city;
    private String state;
    private String district;
    private String postalCode;
    private String contactPurpose;
    private String firstName;
    private String lastName;
    private String telecom;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContactPurpose() {
        return contactPurpose;
    }

    public void setContactPurpose(String contactPurpose) {
        this.contactPurpose = contactPurpose;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelecom() {
        return telecom;
    }

    public void setTelecom(String telecom) {
        this.telecom = telecom;
    }

    public Organization(String organizationName, String country, String city, String state, String district, String postalCode, String contactPurpose, String firstName, String lastName, String telecom) {
        this.organizationName = organizationName;
        this.country = country;
        this.city = city;
        this.state = state;
        this.district = district;
        this.postalCode = postalCode;
        this.contactPurpose = contactPurpose;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telecom = telecom;
    }

    public Organization() {
    }
}
