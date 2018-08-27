package com.kahvedunyasi.barista.data.network.request.post;

import java.io.Serializable;


public class UpdateValeIssueRequestModel implements Serializable {

    private String valeId;

    public UpdateValeIssueRequestModel(String valeId) {
        this.valeId = valeId;
    }

    public String getValeId() {
        return valeId;
    }

    public UpdateValeIssueRequestModel setValeId(String valeId) {
        this.valeId = valeId;
        return this;
    }
}
