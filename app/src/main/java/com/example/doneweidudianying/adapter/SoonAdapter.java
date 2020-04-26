package com.example.doneweidudianying.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.bean.ReceivedBean;
import com.example.doneweidudianying.bean.SoonBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SoonAdapter extends RecyclerView.Adapter<SoonAdapter.Holder> {
    private Context mContext;
    private List<SoonBean.ResultBean> list;

    public SoonAdapter(Context mContext, List<SoonBean.ResultBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.soon_item, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.fresco.setImageURI(list.get(position).getImageUrl());
        holder.name.setText(list.get(position).getName()+"");
        holder.time.setText(list.get(position).getReleaseTime()+"上映");
        holder.number.setText(list.get(position).getWantSeeNum()+"人想看");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView fresco;
        private final TextView name;
        private final TextView time;
        private final TextView number;
        private final TextView bt;

        public Holder(@NonNull View itemView) {
            super(itemView);
            fresco = itemView.findViewById(R.id.soonfresco);
            name = itemView.findViewById(R.id.soonname);
            time = itemView.findViewById(R.id.soontime);
            number = itemView.findViewById(R.id.soonnumber);
            bt = itemView.findViewById(R.id.soonbt);
        }
    }

}
