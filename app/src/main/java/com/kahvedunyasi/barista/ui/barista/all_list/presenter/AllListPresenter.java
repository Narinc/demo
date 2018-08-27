package com.kahvedunyasi.barista.ui.barista.all_list.presenter;

import android.util.Log;

import com.kahvedunyasi.barista.data.DataManager;
import com.kahvedunyasi.barista.data.network.error.NetworkError;
import com.kahvedunyasi.barista.data.network.model.RobotPosProduct;
import com.kahvedunyasi.barista.data.network.model.RobotPosProductRequest;
import com.kahvedunyasi.barista.data.network.model.request.CloseShopRequest;
import com.kahvedunyasi.barista.data.network.model.response.StockOutRequest;
import com.kahvedunyasi.barista.data.network.service.RobotposService;
import com.kahvedunyasi.barista.di.component.NetworkComponent;
import com.kahvedunyasi.barista.ui.barista.all_list.view.AllListMvpView;
import com.kahvedunyasi.barista.ui.base.BasePresenter;
import com.kahvedunyasi.barista.util.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;

/**
 * Created by kuka on 26.07.2018.
 */

public class AllListPresenter<V extends AllListMvpView> extends BasePresenter<V> implements AllListMvpPresenter<V> {
    private static final String TAG = "AllListPresenter";

    @Inject
    public AllListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, NetworkComponent networkComponent) {
        super(dataManager, schedulerProvider, compositeDisposable, networkComponent);
    }

    @Override
    public void getAllList() {
        getMvpView().showLoading();
        getNetworkComponent().getRobotposService().getProduct(new RobotposService.ProductServiceCallback<List<RobotPosProduct>>() {
            @Override
            public void onSuccess(List<RobotPosProduct> response) {
                getMvpView().hideLoading();
                getMvpView().showList(response);
            }

            @Override
            public void onError(NetworkError networkError) {
                getMvpView().hideLoading();
                Log.e(TAG, "onError: ", networkError.getError());
            }
        }, getDataManager().getCurrentUserAccessToken());
    }

    @Override
    public void getRobotposProductListByStoreCode(String storeCode, final boolean forceUpdate) {
        if (forceUpdate) {
            getMvpView().showLoading();
        }
        getNetworkComponent().getRobotposService().getProductListByStoreCode(new RobotposService.ProductServiceCallback<List<RobotPosProduct>>() {
            @Override
            public void onSuccess(List<RobotPosProduct> response) {
                if (forceUpdate) {
                    getMvpView().hideLoading();
                } else getMvpView().closeRefresh();

                getMvpView().showList(response);
            }

            @Override
            public void onError(NetworkError networkError) {
                if (forceUpdate) {
                    getMvpView().hideLoading();
                } else getMvpView().closeRefresh();
                getMvpView().onError(networkError.getAppErrorMessage());

                Log.e(TAG, "onError: ", networkError.getError());
            }
        }, getDataManager().getCurrentUserAccessToken(), storeCode);
    }

    @Override
    public void setStockStatus(boolean stockOut, final RobotPosProduct posProduct, final int position) {
        getMvpView().showLoading();
        RobotPosProductRequest robotPosProductRequest = new RobotPosProductRequest();
        robotPosProductRequest.setRobotposProduct(posProduct);

        if (stockOut) {
            StockOutRequest stockOutRequest = new StockOutRequest(posProduct.getId(), posProduct.getStoreCode(), posProduct.getExternalCode());
            getNetworkComponent().getRobotposService().stockoutProduct(new RobotposService.ProductServiceCallback<ResponseBody>() {

                @Override
                public void onSuccess(ResponseBody o) {
                    getMvpView().hideLoading();
                }

                @Override
                public void onError(NetworkError networkError) {
                    getMvpView().hideLoading();

                    posProduct.setStockOut(!posProduct.isStockOut());
                    posProduct.setStockOutFromUser(false);
                    getMvpView().takeItBack(posProduct, position);
                }
            }, getDataManager().getCurrentUserAccessToken(), stockOutRequest);
        } else {
            StockOutRequest stockOutRequest = new StockOutRequest(posProduct.getId(), posProduct.getStoreCode(), posProduct.getExternalCode());
            getNetworkComponent().getRobotposService().stockInProduct(new RobotposService.ProductServiceCallback<ResponseBody>() {

                @Override
                public void onSuccess(ResponseBody o) {
                    getMvpView().hideLoading();
                }

                @Override
                public void onError(NetworkError networkError) {
                    getMvpView().hideLoading();

                    posProduct.setStockOut(!posProduct.isStockOut());
                    posProduct.setStockOutFromUser(false);
                    getMvpView().takeItBack(posProduct, position);
                }
            }, getDataManager().getCurrentUserAccessToken(), stockOutRequest);
        }

    }

    @Override
    public void setBusyStatus(CloseShopRequest closeShopRequest, final boolean status) {
        getMvpView().showLoading();
        if (status){
            getNetworkComponent().getRobotposService().signAsBusyBranch(new RobotposService.ProductServiceCallback<ResponseBody>() {
                @Override
                public void onSuccess(ResponseBody response) {
                    getMvpView().hideLoading();
                }

                @Override
                public void onError(NetworkError networkError) {
                    getMvpView().hideLoading();
                    getMvpView().takeItBack(!status);
                    getMvpView().onError(networkError.getAppErrorMessage());
                    Log.e(TAG, "onError: ", networkError.getError());
                }
            }, getDataManager().getCurrentUserAccessToken(), closeShopRequest, status);
        }else {
            getNetworkComponent().getRobotposService().signAsNotBusyBranch(new RobotposService.ProductServiceCallback<ResponseBody>() {
                @Override
                public void onSuccess(ResponseBody response) {
                    getMvpView().hideLoading();
                }

                @Override
                public void onError(NetworkError networkError) {
                    getMvpView().hideLoading();
                    getMvpView().takeItBack(!status);
                    getMvpView().onError(networkError.getAppErrorMessage());
                    Log.e(TAG, "onError: ", networkError.getError());
                }
            }, getDataManager().getCurrentUserAccessToken(), closeShopRequest, status);
        }

    }
}
