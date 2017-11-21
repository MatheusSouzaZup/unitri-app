package com.unitriapp.matheus.unitriapp.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.content.AvaliacaoByAluno;

import java.util.List;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AvaliacaoAdapter extends RecyclerView.Adapter<AvaliacaoAdapter.MyViewHolder> {
    List<AvaliacaoByAluno> mList;
    public AvaliacaoAdapter(List<AvaliacaoByAluno> list) {
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_avaliacao, parent, false);
        AvaliacaoAdapter.MyViewHolder myViewHolder = new AvaliacaoAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tvName.setText(mList.get(position).getNome());
            holder.tvPontos.setText(mList.get(position).getPontos());
    }

    @Override
    public int getItemCount() {
        if(mList == null)
        return 0;
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvPontos;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name);
            tvPontos = (TextView) itemView.findViewById(R.id.pontos);
        }
    }

}
