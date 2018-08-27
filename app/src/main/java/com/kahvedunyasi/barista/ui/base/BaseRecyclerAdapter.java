package com.kahvedunyasi.barista.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volkannarinc on 10/10/17 16:26.
 */

public abstract class BaseRecyclerAdapter<T extends RecyclerView.ViewHolder, U> extends RecyclerView.Adapter<T> {

    protected LayoutInflater inflater;
    protected Context context;
    protected List<U> objectsList;

    public BaseRecyclerAdapter(Context context) {
        this(context, new ArrayList<U>());
    }

    public BaseRecyclerAdapter(Context context, List<U> objectsList) {
        this.context = context;
        this.objectsList = objectsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return objectsList.size();
    }

    public U getItem(int position) {
        return objectsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(List<U> newData) {
        objectsList = newData;
        notifyDataSetChanged();
    }

    public void add(U item) {
        objectsList.add(item);
        notifyDataSetChanged();
    }

    public void add(int index, U item) {
        objectsList.add(index, item);
        notifyDataSetChanged();
    }

    public void setItem(int index, U item) {
        objectsList.set(index, item);
        notifyDataSetChanged();
    }

    public int getIndex(U item) {
        return objectsList.indexOf(item);
    }

    public void addList(List<U> items) {
        objectsList.addAll(items);
        notifyDataSetChanged();
    }

    public List<U> getList() {
        return objectsList;
    }

    public void remove(U item) {
        objectsList.remove(item);
        notifyDataSetChanged();
    }

    public void removeByIndex(int index) {
        objectsList.remove(index);
        notifyDataSetChanged();
    }
}
