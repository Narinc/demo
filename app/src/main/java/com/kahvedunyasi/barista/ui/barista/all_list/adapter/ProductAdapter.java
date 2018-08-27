package com.kahvedunyasi.barista.ui.barista.all_list.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.kahvedunyasi.barista.R;
import com.kahvedunyasi.barista.data.network.model.RobotPosProduct;
import com.kahvedunyasi.barista.ui.barista.all_list.view.AllListMvpView;
import com.kahvedunyasi.barista.ui.base.BaseRecyclerAdapter;
import com.kahvedunyasi.barista.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kuka on 27.07.2018.
 */

public class ProductAdapter extends BaseRecyclerAdapter<BaseViewHolder, RobotPosProduct> {

    private final AllListMvpView mvpView;

    public ProductAdapter(Context context, List<RobotPosProduct> objectsList, AllListMvpView mvpView) {
        super(context, objectsList);
        this.mvpView = mvpView;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.switch_stock_out)
        Switch switchStockOut;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        protected void clear() {

        }

        public void onBind(final int position) {
            super.onBind(position);

            final RobotPosProduct robotPosProduct = objectsList.get(position);
            tvProductName.setText(robotPosProduct.getProductName());
            switchStockOut.setChecked(robotPosProduct.isStockOut());
            switchStockOut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (robotPosProduct.isStockOutFromUser()) {
                        robotPosProduct.setStockOut(isChecked);
                        mvpView.checkedChange(isChecked,robotPosProduct, position);
                    } else {
                        robotPosProduct.setStockOutFromUser(true);
                    }
                }
            });
        }
    }
}
