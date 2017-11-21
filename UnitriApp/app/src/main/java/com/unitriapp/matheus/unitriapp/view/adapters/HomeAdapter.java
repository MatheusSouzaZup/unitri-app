package com.unitriapp.matheus.unitriapp.view.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.content.Shifts;
import com.unitriapp.matheus.unitriapp.model.response.MattersResponse;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    Context mContext;
    List<Shifts> mShiftsList;
    List<MattersResponse> mMattersResponseList;
    MainActivity mActivity;
    HomeRecyclerHorizontalAdapter mAdapter;

    public HomeAdapter(Context context, List<Shifts> shiftsList, List<MattersResponse> mattersResponseList) {
        mContext = context;
        mShiftsList =shiftsList;
        mMattersResponseList = mattersResponseList;
    }

    private void replaceFragment(Fragment fragment) {
        if (mContext instanceof MainActivity) {
            mActivity = (MainActivity) mContext;
        }

        mActivity.replaceFragment(fragment);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomeRecyclerHorizontalAdapter(mContext, mMattersResponseList.get(position).getMatters());
        holder.recyclerView.setAdapter(mAdapter);

        holder.tvTitle.setText(mShiftsList.get(position).getTurno());
    }

    @Override
    public int getItemCount() {
        if(mShiftsList == null) {
            return 0;
        }
        return mShiftsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView recyclerView;
        public TextView tvTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rvHomeList);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

}
