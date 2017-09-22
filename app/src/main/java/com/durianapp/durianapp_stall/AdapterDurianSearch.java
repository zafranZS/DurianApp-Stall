package com.durianapp.durianapp_stall;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

/**
 * Created by Amer S Alkatheri on 19-Jun-17.
 */

public class AdapterDurianSearch extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataDurianSearch> data = Collections.emptyList();
    DataDurianSearch current;

    // create constructor to initialize context and data sent from MainActivity
    public AdapterDurianSearch(Context context, List<DataDurianSearch> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_durian, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        DataDurianSearch current=data.get(position);

        myHolder.idh = current.durianId;
        myHolder.nameh = current.durianName;
        myHolder.textFishName.setText(current.durianName);
        myHolder.textSize.setText("Sweetness: " + current.durianSweetness);
        myHolder.textType.setText("Bitterness: " + current.durianBitterness);
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        int idh;
        String nameh;
        TextView textFishName, textSize, textType;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textFishName= (TextView) itemView.findViewById(R.id.textFishName);
            textSize = (TextView) itemView.findViewById(R.id.textSize);
            textType = (TextView) itemView.findViewById(R.id.textType);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {
            //Toast.makeText(context, "You clicked an id =" + idh, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, DurianInfoActivity.class);
            intent.putExtra("DURIAN_ID", idh);
            intent.putExtra("DURIAN_TITLE", nameh);
            context.startActivity(intent);
        }
    }
}