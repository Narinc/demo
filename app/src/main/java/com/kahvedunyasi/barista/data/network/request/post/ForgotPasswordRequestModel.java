package com.kahvedunyasi.barista.data.network.request.post;

public class ForgotPasswordRequestModel {

    private String email;

    public ForgotPasswordRequestModel(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
