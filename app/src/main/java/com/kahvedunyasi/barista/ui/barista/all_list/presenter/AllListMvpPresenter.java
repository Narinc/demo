package com.kahvedunyasi.barista.ui.barista.all_list.presenter;

import com.kahvedunyasi.barista.data.network.model.RobotPosProduct;
import com.kahvedunyasi.barista.data.network.model.request.CloseShopRequest;
import com.kahvedunyasi.barista.di.scope.PerActivity;
import com.kahvedunyasi.barista.ui.barista.all_list.view.AllListMvpView;
import com.kahvedunyasi.barista.ui.base.MvpPresenter;

/**
 * Created by kuka on 26.07.2018.
 */

@PerActivity
public interface AllListMvpPresenter<V extends AllListMvpView> extends MvpPresenter<V> {

    void getAllList();

    void getRobotposProductListByStoreCode(String storeCode, boolean forceUpdate);

    void setStockStatus(boolean stockOut, RobotPosProduct posProduct, int position);

    void setBusyStatus(CloseShopRequest closeShopRequest, boolean status);
}
