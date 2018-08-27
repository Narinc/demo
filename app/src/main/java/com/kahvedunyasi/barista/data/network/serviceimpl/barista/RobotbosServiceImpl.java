package com.kahvedunyasi.barista.data.network.serviceimpl.barista;

import com.kahvedunyasi.barista.data.network.model.RobotPosProduct;
import com.kahvedunyasi.barista.data.network.model.request.CloseShopRequest;
import com.kahvedunyasi.barista.data.network.model.response.StockOutRequest;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by kuka on 26.07.2018.
 */

public interface RobotbosServiceImpl {
    @GET("/api/RobotPosProduct/GetAllRobotposProducts")
    Observable<List<RobotPosProduct>> getRobotPosProductList(@Header("Authorization") String token);

    @GET("/api/TakeAway/Barista/Products")
    Observable<List<RobotPosProduct>> getProductListByStoreCode(@Header("Authorization") String authToken, @Query("shopId") String storeCode);

    @POST("api/takeaway/barista/stockout/create")
    Observable<ResponseBody> stockOutProduct(@Header("Authorization") String authToken, @Body StockOutRequest outRequest);

    @POST("api/takeaway/barista/stockout/delete")
    Observable<ResponseBody> stockInProduct(@Header("Authorization") String authToken, @Body StockOutRequest outRequest);

    @POST("/api/takeaway/barista/closedshop/create")
    Observable<ResponseBody> signAsBusyBranch(@Header("Authorization") String authToken, @Body CloseShopRequest closeShopRequest);

    @POST("/api/takeaway/barista/closedshop/delete")
    Observable<ResponseBody> signAsNotBusyBranch(@Header("Authorization") String authToken, @Body CloseShopRequest closeShopRequest);
}
