package com.kahvedunyasi.barista.data.network.request.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequestModel {

    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("lastname")
    private String lastName;
    @Expose
    @SerializedName("identifier")
    private String identifier;
    @Expose
    @SerializedName("secret")
    private String secret;
    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("token")
    private String token;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("profilePicture")
    private String profilePicture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private String getIdentifier() {
        if (identifier == null)
            identifier = "";

        return identifier;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    private String getSecret() {
        return secret;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        if (type == null)
            type = "";

        return type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String getToken() {
        if (token == null)
            token = "";

        return token;
    }

    @Override
    public String toString() {
        return
                "RegisterRequestModel{" +
                        "name = '" + name + '\'' +
                        ",lastname = '" + lastName + '\'' +
                        ",identifier = '" + identifier + '\'' +
                        ",secret = '" + secret + '\'' +
                        ",type = '" + type + '\'' +
                        ",token = '" + token + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",email = '" + email + '\'' +
                        "}";

    }

    public void setProfilePicture(String photoUrl) {
        this.profilePicture = photoUrl;
    }
}
