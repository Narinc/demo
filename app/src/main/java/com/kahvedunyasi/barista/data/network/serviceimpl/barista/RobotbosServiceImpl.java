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
    Observable<List<RobotPosProduct>> getRobotPosProductList(@Header("Authorization") String token);

    Observable<List<RobotPosProduct>> getProductListByStoreCode(@Header("Authorization") String authToken, @Query("shopId") String storeCode);

    Observable<ResponseBody> stockOutProduct(@Header("Authorization") String authToken, @Body StockOutRequest outRequest);

    Observable<ResponseBody> stockInProduct(@Header("Authorization") String authToken, @Body StockOutRequest outRequest);

    Observable<ResponseBody> signAsBusyBranch(@Header("Authorization") String authToken, @Body CloseShopRequest closeShopRequest);

    Observable<ResponseBody> signAsNotBusyBranch(@Header("Authorization") String authToken, @Body CloseShopRequest closeShopRequest);
}
