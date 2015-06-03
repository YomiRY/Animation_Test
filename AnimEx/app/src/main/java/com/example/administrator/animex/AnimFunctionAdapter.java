package com.example.administrator.animex;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

public class AnimFunctionAdapter extends  RecyclerView.Adapter<AnimFunctionAdapter.ViewHolder>{

    private String[] mAnimFuncList;
    private IOnItemClickListener mListener;
    private Context mCtx;

    public AnimFunctionAdapter(Context ctx, String[] animFunc) {
        this.mCtx = ctx;
        this.mAnimFuncList = animFunc;
    }

    public void setOnItemClickListener(IOnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mCtx).inflate(R.layout.view_anim_list_item, null);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.animName.setText(mAnimFuncList[position]);
        holder.setPos(position);
    }

    public String getItem(int pos) {
        return mAnimFuncList[pos];
    }

    @Override
    public int getItemCount() {
        return mAnimFuncList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView animName;

        private View mItemView;
        private int mPos;

        public ViewHolder(View itemView) {
            super(itemView);

            this.mItemView = itemView;
            this.animName = (TextView) itemView.findViewById(R.id.tv_anim_name);

            mItemView.setOnClickListener(this);
        }

        public void setPos(int pos) {
            mPos = pos;
        }

        @Override
        public void onClick(View v) {
            if (mListener != null && mPos >= 0) {
                mListener.onItemClick(mItemView, mPos);
            }
        }
    }
}
