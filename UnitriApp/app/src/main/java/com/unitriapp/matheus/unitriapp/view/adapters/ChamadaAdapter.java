package com.unitriapp.matheus.unitriapp.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.content.Students;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class ChamadaAdapter extends RecyclerView.Adapter<ChamadaAdapter.MyViewHolder> {
    List<Students> mList;

    public ChamadaAdapter(List<Students> list) {
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chamada, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(holder.presenteCB.isChecked()) {
            mList.get(position).setPresent(true);
        }
        else{
            mList.get(position).setPresent(false);
        }
        holder.tvName.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    public List<Students> getList() {
        return mList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public CheckBox presenteCB;
        public CheckBox ausenteCB;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name);
            presenteCB = (CheckBox) itemView.findViewById(R.id.cb_presente);
            ausenteCB = (CheckBox) itemView.findViewById(R.id.cb_ausente);
        }
    }

}
