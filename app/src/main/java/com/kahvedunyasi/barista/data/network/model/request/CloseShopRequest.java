package com.kahvedunyasi.barista.data.network.model.request;

/**
 * Created by kuka on 20.08.2018.
 */

public class CloseShopRequest {
    private String id;

    private String shopId;

    private String productExternalCode;

    public CloseShopRequest(String shopId) {
        this.shopId = shopId;
    }

    public CloseShopRequest(String id, String shopId) {
        this.id = id;
        this.shopId = shopId;
    }

    public CloseShopRequest(String id, String shopId, String productExternalCode) {
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
        return "CloseShopRequest{" +
                "id='" + id + '\'' +
                ", shopId='" + shopId + '\'' +
                ", productExternalCode='" + productExternalCode + '\'' +
                '}';
    }
}
