package com.kahvedunyasi.barista.data.network.request.post;

public class LoginRequestModel {

    private String identifier;
    private String secret;
    private String type;
    private String token;

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
                "LoginRequestModel{" +
                        "identifier = '" + identifier + '\'' +
                        ",secret = '" + secret + '\'' +
                        ",type = '" + type + '\'' +
                        ",token = '" + token + '\'' +
                        "}";
    }

}
