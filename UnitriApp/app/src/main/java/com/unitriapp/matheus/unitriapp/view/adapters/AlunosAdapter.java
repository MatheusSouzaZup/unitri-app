package com.unitriapp.matheus.unitriapp.view.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.content.Students;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.fragments.TransactionFragment;
import com.unitriapp.matheus.unitriapp.view.fragments.alunoavaliado.AlunoAvaliadoFragment;
import com.unitriapp.matheus.unitriapp.view.fragments.avaliaaluno.AvaliaAlunoFragment;

import java.util.List;

/**
 * Created by Matheus on 20/11/2017.
 */

public class AlunosAdapter extends RecyclerView.Adapter<AlunosAdapter.MyViewHolder>{
    List<Students> mList;
    private MainActivity mActivity;
    private Context mContext;
    private String matterID;
    private int mFlag;
    public AlunosAdapter(List<Students> list,Context context,String id,int flag) {
        mList = list;
        mContext = context;
        matterID = id;
        mFlag = flag;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alunos, parent, false);
        AlunosAdapter.MyViewHolder myViewHolder = new AlunosAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvName.setText(mList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mFlag == 1) {
                    replaceFragment(AvaliaAlunoFragment.newInstance(matterID,mList.get(position).getId()));
                }
                else {
                    replaceFragment(AlunoAvaliadoFragment.newInstance(mList.get(position).getId(), matterID));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }
    private void replaceFragment(Fragment fragment) {
        if (mContext instanceof MainActivity) {
            mActivity = (MainActivity) mContext;
        }

        mActivity.replaceFragment(fragment);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.ivName);
        }
    }

}
