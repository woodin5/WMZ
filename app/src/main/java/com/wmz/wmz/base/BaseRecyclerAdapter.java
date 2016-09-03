package com.wmz.wmz.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wmz.wmz.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmz on 4/8/16.
 */
public class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{
    private Context mContext;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void adds(List<T> list){
        list.addAll(list);
        notifyDataSetChanged();
    }

    public void add(T item){
        list.add(item);
        notifyDataSetChanged();
    }

    public void remove(T item){
        list.remove(item);
        notifyDataSetChanged();
    }

    public void clear(){
        list.clear();
        notifyDataSetChanged();
    }

    public BaseRecyclerAdapter(Context context){
        this.mContext = context;
        this.list = new ArrayList<>();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}

