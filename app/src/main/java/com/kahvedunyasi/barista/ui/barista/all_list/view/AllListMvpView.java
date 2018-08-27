package com.kahvedunyasi.barista.ui.barista.all_list.view;

import com.kahvedunyasi.barista.data.network.model.RobotPosProduct;
import com.kahvedunyasi.barista.ui.base.MvpView;

import java.util.List;

/**
 * Created by kuka on 26.07.2018.
 */

public interface AllListMvpView extends MvpView {
    void showList(List<RobotPosProduct> robotPosProducts);

    void checkedChange(boolean stockOut, RobotPosProduct posProduct, int position);

    void takeItBack(RobotPosProduct posProduct, int position);

    void closeRefresh();

    void takeItBack(boolean status);
}
