package com.zoomtic.tamilswipe.Profile.EditProfile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.zoomtic.tamilswipe.R;
import com.squareup.picasso.Picasso;
import com.wonshinhyo.dragrecyclerview.DragAdapter;
import com.wonshinhyo.dragrecyclerview.DragHolder;
import com.wonshinhyo.dragrecyclerview.DragRecyclerView;

import java.util.ArrayList;

/**
 * Created by AQEEL on 7/16/2018.
 */

public class Profile_photos_Adapter
        extends DragAdapter {
    Context context;

    ArrayList<String> photos;

    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(String item, int postion, View view);
    }


    public Profile_photos_Adapter(Context context, ArrayList<String> arrayList, OnItemClickListener listener)  {
        super(context,arrayList);
        this.context=context;
        photos=arrayList;
        this.listener=listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewtype) {

        return new HistoryviewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_edit_profile_layout, viewGroup, false));


    }



    @Override
    public int getItemCount() {
        return photos.size();
    }

    @Override
    public void onBindViewHolder(final DragRecyclerView.ViewHolder hol, final int position) {
        super.onBindViewHolder(hol, position);
        HistoryviewHolder holder = (HistoryviewHolder) hol;
        holder.bind(photos.get(position),position,listener);

        if(photos.get(position).equals("")){
//            holder.crossbtn.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_round_add_btn));
            holder.deletebtn.setVisibility(View.GONE);
//            if(position==0){
//                holder.addbtn.setVisibility(View.GONE);
//            }else{
                holder.addbtn.setVisibility(View.VISIBLE);
//            }
            Picasso.with(context).load("null").placeholder(R.drawable.round_bg).centerCrop().resize(200,300).into(holder.image);

        }else {
//            holder.crossbtn.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_cross));
            holder.addbtn.setVisibility(View.GONE);
//            if(position==0){
//                holder.deletebtn.setVisibility(View.GONE);
//            }else{
                holder.deletebtn.setVisibility(View.VISIBLE);
//            }
            Picasso.with(context).load(photos.get(position)).placeholder(R.drawable.round_bg).centerCrop().resize(200,300).into(holder.image);
        }
     }
    /**
     * Inner Class for a recycler view
     */
    class HistoryviewHolder extends DragHolder {
        View view;
        ImageView image;
        ImageButton addbtn, deletebtn;
        public HistoryviewHolder(View itemView) {
            super(itemView);
            view = itemView;
            image=view.findViewById(R.id.image);
            addbtn=view.findViewById(R.id.add_btn);
            deletebtn=view.findViewById(R.id.delete_btn);
        }


        public void bind(final String item, final int position , final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item,position,v);
                }
            });

            addbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item,position,v);
                }
            });
            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item,position,v);
                }
            });

        }


    }

}

