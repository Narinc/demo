package com.kahvedunyasi.barista.data.network.model;

/**
 * Created by kuka on 26.07.2018.
 */

public class RobotPosProductRequest {
    private RobotPosProduct robotposProduct;

    private RobotPosProduct[] robotposProducts;

    public RobotPosProduct getRobotposProduct() {
        return robotposProduct;
    }

    public void setRobotposProduct(RobotPosProduct robotposProduct) {
        this.robotposProduct = robotposProduct;
    }

    public RobotPosProduct[] getRobotposProducts() {
        return robotposProducts;
    }

    public void setRobotposProducts(RobotPosProduct[] robotposProducts) {
        this.robotposProducts = robotposProducts;
    }

    @Override
    public String toString() {
        return "ClassPojo [robotposProduct = " + robotposProduct + ", robotposProducts = " + robotposProducts + "]";
    }
}