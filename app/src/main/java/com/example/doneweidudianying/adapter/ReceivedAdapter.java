package com.example.doneweidudianying.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.bean.QueryuserBean;
import com.example.doneweidudianying.bean.ReceivedBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReceivedAdapter extends RecyclerView.Adapter<ReceivedAdapter.Holder> {
    private Context mContext;
    private List<ReceivedBean.ResultBean> list;

    public ReceivedAdapter(Context mContext, List<ReceivedBean.ResultBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.received_item, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fresco.setImageURI(list.get(position).getImageUrl());
        holder.fen.setText(list.get(position).getScore()+"分");
        holder.name.setText(list.get(position).getName()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView fresco;
        private final TextView fen;
        private final TextView name;
        private final TextView bt;

        public Holder(@NonNull View itemView) {
            super(itemView);
            fresco = itemView.findViewById(R.id.receivedfresco);
            fen = itemView.findViewById(R.id.receivedfen);
            name = itemView.findViewById(R.id.receivedname);
            bt = itemView.findViewById(R.id.receivedbt);
        }
    }

}
