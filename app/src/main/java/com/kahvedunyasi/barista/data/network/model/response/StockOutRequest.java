package com.kahvedunyasi.barista.data.network.model.response;

/**
 * Created by kuka on 17.08.2018.
 */

public class StockOutRequest {
    private String id;

    private String shopId;

    private String productExternalCode;

    public StockOutRequest(String id, String shopId, String productExternalCode) {
        this.id = id;
        this.shopId = shopId;
        this.productExternalCode = productExternalCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getProductExternalCode() {
        return productExternalCode;
    }

    public void setProductExternalCode(String productExternalCode) {
        this.productExternalCode = productExternalCode;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", shopId = " + shopId + ", productExternalCode = " + productExternalCode + "]";
    }
}

