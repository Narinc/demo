package com.kahvedunyasi.barista.data.network.service;

import com.kahvedunyasi.barista.data.network.error.NetworkError;
import com.kahvedunyasi.barista.data.network.model.RobotPosProduct;
import com.kahvedunyasi.barista.data.network.model.request.CloseShopRequest;
import com.kahvedunyasi.barista.data.network.model.response.StockOutRequest;
import com.kahvedunyasi.barista.data.network.serviceimpl.barista.RobotbosServiceImpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by kuka on 26.07.2018.
 */

@Singleton
public class RobotposService {

    private final RobotbosServiceImpl robotbosServiceImpl;

    @Inject
    public RobotposService(RobotbosServiceImpl robotbosServiceImpl) {
        this.robotbosServiceImpl = robotbosServiceImpl;
    }

    public Disposable getProduct(final ProductServiceCallback<List<RobotPosProduct>> callback, String authToken) {
        return robotbosServiceImpl.getRobotPosProductList(authToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<RobotPosProduct>>() {
                    @Override
                    public void accept(List<RobotPosProduct> robotPosProducts) throws Exception {
                        callback.onSuccess(robotPosProducts);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onError(new NetworkError(throwable));
                    }
                });

    }

    public Disposable getProductListByStoreCode(final ProductServiceCallback<List<RobotPosProduct>> callback, String authToken, String storeCode) {
        return robotbosServiceImpl.getProductListByStoreCode(authToken, storeCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<RobotPosProduct>>() {
                    @Override
                    public void accept(List<RobotPosProduct> robotPosProducts) throws Exception {
                        callback.onSuccess(robotPosProducts);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onError(new NetworkError(throwable));
                    }
                });
    }

    public Disposable stockoutProduct(final ProductServiceCallback<ResponseBody> callback, String authToken, StockOutRequest stockOutRequest) {
        return robotbosServiceImpl.stockOutProduct(authToken, stockOutRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody object) throws Exception {
                        callback.onSuccess(object);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onError(new NetworkError(throwable));
                    }
                });
    }

    public Disposable stockInProduct(final ProductServiceCallback<ResponseBody> callback, String authToken, StockOutRequest stockOutRequest) {
        return robotbosServiceImpl.stockInProduct(authToken, stockOutRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody object) throws Exception {
                        callback.onSuccess(object);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onError(new NetworkError(throwable));
                    }
                });
    }

    public Disposable signAsBusyBranch(final ProductServiceCallback<ResponseBody> callback, String authToken, CloseShopRequest closeShopRequest, boolean status) {
        return robotbosServiceImpl.signAsBusyBranch(authToken, closeShopRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        callback.onSuccess(responseBody);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onError(new NetworkError(throwable));
                    }
                });
    }

    public Disposable signAsNotBusyBranch(final ProductServiceCallback<ResponseBody> callback, String authToken, CloseShopRequest closeShopRequest, boolean status) {
        return robotbosServiceImpl.signAsNotBusyBranch(authToken, closeShopRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        callback.onSuccess(responseBody);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onError(new NetworkError(throwable));
                    }
                });
    }

    public interface ProductServiceCallback<T> {
        void onSuccess(T response);

        void onError(NetworkError networkError);
    }
}
