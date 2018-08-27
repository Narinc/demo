package com.kahvedunyasi.barista.util.enums;


public enum AuthenticationType {
    PASSWORD(0, "PASSWORD"),
    PHONE(1, "PHONE"),
    FACEBOOK(2, "FACEBOOK"),
    GOOGLE(3, "GOOGLE"),
    TWITTER(3, "TWITTER"),
    INSTAGRAM(4, "INSTAGRAM"),
    FORGOT_PASSWORD(99, "FORGOT_PASSWORD");

    private final int id;
    private String value;

    AuthenticationType(int id, String value) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }
}
