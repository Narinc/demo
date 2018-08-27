package com.kahvedunyasi.barista.ui.barista.all_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.kahvedunyasi.barista.R;
import com.kahvedunyasi.barista.data.network.model.RobotPosProduct;
import com.kahvedunyasi.barista.data.network.model.request.CloseShopRequest;
import com.kahvedunyasi.barista.di.component.ActivityComponent;
import com.kahvedunyasi.barista.ui.barista.all_list.adapter.ProductAdapter;
import com.kahvedunyasi.barista.ui.barista.all_list.presenter.AllListMvpPresenter;
import com.kahvedunyasi.barista.ui.barista.all_list.view.AllListMvpView;
import com.kahvedunyasi.barista.ui.base.BaseFragment;
import com.kahvedunyasi.barista.ui.base.grid.GridMarginDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends BaseFragment implements AllListMvpView {

    @Inject
    AllListMvpPresenter<AllListMvpView> presenter;

    @BindView(R.id.image_grid)
    RecyclerView grid;
    @BindView(R.id.switch_sign_as_busy)
    Switch switchSignAsBusy;
    private SwipeRefreshLayout refreshLayout;

    public static ProductListFragment newInstance() {

        Bundle args = new Bundle();

        ProductListFragment fragment = new ProductListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);

            setHasOptionsMenu(true);

            presenter.getRobotposProductListByStoreCode("068", true);

        }
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.products_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                //showFilteringPopUpMenu();
                break;
            case R.id.menu_refresh:
                presenter.getRobotposProductListByStoreCode("068", true);
                break;
        }
        return true;
    }

    @Override
    protected void setUp(View view) {
        setupRecyclerView();
        setUpSwipeRefresh(view);
        setUpSwitch();
    }

    private void setUpSwitch() {
        switchSignAsBusy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.setBusyStatus(new CloseShopRequest("068"), isChecked);
            }
        });
    }

    private void setUpSwipeRefresh(View view) {
        refreshLayout = view.findViewById(R.id.swipeContainer);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchTimelineAsync();
            }

            private void fetchTimelineAsync() {
                presenter.getRobotposProductListByStoreCode("068", false);
            }
        });
    }

    private void setupRecyclerView() {
        grid.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        grid.setHasFixedSize(true);
    }

    private void populateGrid(final List<RobotPosProduct> robotPosProducts) {
        grid.setAdapter(new ProductAdapter(getContext(), robotPosProducts, this));
    }


    @Override
    public void closeRefresh() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void takeItBack(boolean status) {
        switchSignAsBusy.setOnCheckedChangeListener(null);
        switchSignAsBusy.setChecked(status);
        setUpSwitch();
    }

    @Override
    public void takeItBack(RobotPosProduct posProduct, int position) {
        ProductAdapter adapter = (ProductAdapter) grid.getAdapter();
        adapter.setItem(position, posProduct);
    }

    @Override
    public void showList(List<RobotPosProduct> robotPosProducts) {
        populateGrid(robotPosProducts);
    }

    @Override
    public void checkedChange(boolean stockOut, RobotPosProduct posProduct, int position) {
        presenter.setStockStatus(stockOut, posProduct, position);
    }
}
