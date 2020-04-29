package com.example.doneweidudianying.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.bean.SearchBean;
import com.example.doneweidudianying.bean.SoonBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.Holder> {
    private Context mContext;
    private List<SearchBean.ResultBean> list;

    public SearchAdapter(Context mContext, List<SearchBean.ResultBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.search_item, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fresco.setImageURI(list.get(position).getImageUrl());
        holder.name.setText("导演："+list.get(position).getDirector());
        holder.zhuyan.setText("主演："+list.get(position).getStarring());
        holder.searchfen.setText("评分："+list.get(position).getScore()+"分");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView fresco;
        private final TextView name;
        private final TextView daoye;
        private final TextView zhuyan;
        private final TextView searchfen;
        private final TextView bt;

        public Holder(@NonNull View itemView) {
            super(itemView);
            fresco = itemView.findViewById(R.id.searchfresco);
            name = itemView.findViewById(R.id.searchname);
            daoye = itemView.findViewById(R.id.searchdirectorname);
            zhuyan = itemView.findViewById(R.id.searchstarringname);
            searchfen = itemView.findViewById(R.id.searchfen);
            bt = itemView.findViewById(R.id.searchbt);
        }
    }

}
