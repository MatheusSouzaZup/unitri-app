package com.unitriapp.matheus.unitriapp.view.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.unitriapp.matheus.unitriapp.R;
import com.unitriapp.matheus.unitriapp.model.content.Matter;
import com.unitriapp.matheus.unitriapp.view.activities.MainActivity;
import com.unitriapp.matheus.unitriapp.view.fragments.TransactionFragment;

import java.util.List;

/**
 * Created by Matheus on 19/11/2017.
 */

public class HomeRecyclerHorizontalAdapter extends RecyclerView.Adapter<HomeRecyclerHorizontalAdapter.MyViewHolder>  {
    private List<Matter> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private MainActivity mActivity;

    public HomeRecyclerHorizontalAdapter(Context context, List<Matter> matterList) {
        mList = matterList;
        mContext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(mList.get(position).getName());
        Glide.with(mContext).load(R.drawable.default_image)
                .centerCrop()
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(TransactionFragment.newInstance(mList.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mList == null)
            return 0;
        return mList.size();
    }
    private void replaceFragment(Fragment fragment) {
        if (mContext instanceof MainActivity) {
            mActivity = (MainActivity) mContext;
        }

        mActivity.replaceFragment(fragment);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;


        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.ivRecyclerHorizontal);
            textView = (TextView) itemView.findViewById(R.id.tvHorizontalRecycler);
        }
    }
}
