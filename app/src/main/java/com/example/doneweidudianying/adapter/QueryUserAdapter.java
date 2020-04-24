package com.example.doneweidudianying.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doneweidudianying.R;
import com.example.doneweidudianying.bean.QueryuserBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QueryUserAdapter extends RecyclerView.Adapter<QueryUserAdapter.Holder> {
    private Context mContext;
    private List<QueryuserBean.ResultBean> list;

    public QueryUserAdapter(Context mContext, List<QueryuserBean.ResultBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(mContext, R.layout.queryuser_item, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.sdw.setImageURI(list.get(position).getHeadPic());
        holder.name.setText(list.get(position).getNickName()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdw;
        private final TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            sdw = itemView.findViewById(R.id.headmysdw);
            name = itemView.findViewById(R.id.headmyname);
        }
    }

}
