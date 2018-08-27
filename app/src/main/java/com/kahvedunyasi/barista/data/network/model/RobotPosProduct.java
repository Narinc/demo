package com.kahvedunyasi.barista.data.network.model;

/**
 * Created by kuka on 26.07.2018.
 */

public class RobotPosProduct {
    private String salesPrice;

    private String groupName;

    private String storeName;

    private String packagePrice;

    private String status;

    private String productCode;

    private String barcode;

    private String benchPrice;

    private String barPrice;

    private String id;

    private String unit;

    private String categoryName;

    private boolean stockOut;

    private String tablePrice;

    private String defaultPrice;

    private String productName;

    private String externalCode;

    private String storeCode;

    private boolean stockOutFromUser = true;

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBenchPrice() {
        return benchPrice;
    }

    public void setBenchPrice(String benchPrice) {
        this.benchPrice = benchPrice;
    }

    public String getBarPrice() {
        return barPrice;
    }

    public void setBarPrice(String barPrice) {
        this.barPrice = barPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isStockOut() {
        return stockOut;
    }

    public void setStockOut(boolean stockOut) {
        this.stockOut = stockOut;
    }

    public String getTablePrice() {
        return tablePrice;
    }

    public void setTablePrice(String tablePrice) {
        this.tablePrice = tablePrice;
    }

    public String getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(String defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public boolean isStockOutFromUser() {
        return stockOutFromUser;
    }

    public void setStockOutFromUser(boolean stockOutFromUser) {
        this.stockOutFromUser = stockOutFromUser;
    }

    @Override
    public String toString() {
        return "ClassPojo [salesPrice = " + salesPrice + ", groupName = " + groupName + ", storeName = " + storeName + ", packagePrice = " + packagePrice + ", status = " + status + ", productCode = " + productCode + ", barcode = " + barcode + ", benchPrice = " + benchPrice + ", barPrice = " + barPrice + ", id = " + id + ", unit = " + unit + ", categoryName = " + categoryName + ", stockOut = " + stockOut + ", tablePrice = " + tablePrice + ", defaultPrice = " + defaultPrice + ", productName = " + productName + ", externalCode = " + externalCode + ", storeCode = " + storeCode + "]";
    }
}