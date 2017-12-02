package com.tiwarithetiger11gmail.rajasthan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MURARI TIWARI on 11/28/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

   private List<Modal> modals;
    private Context context;
    public RecyclerAdapter(List<Modal> modal,Context context) {
        this.modals=modal;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.name.setText(modals.get(position).getPackname());
        //holder.name.setText(Intmodals.get(position).getPackname());
        holder.cost.setText("Cost  "+Integer.toString(modals.get(position).getCost()));
        holder.duration.setText("Duration  "+Integer.toString(modals.get(position).getDuration()));
    }

    @Override
    public int getItemCount() {
        return modals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
      TextView duration;
        TextView cost;
        TextView name;
    public MyViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        name=(TextView)itemView.findViewById(R.id.packname);
        cost=(TextView)itemView.findViewById(R.id.cost);
        duration=(TextView)itemView.findViewById(R.id.durartion);

    }

       @Override
        public void onClick(View view) {
           String url="http://10.0.2.2:3000/android/"+name.getText().toString();
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            context.startActivity(i);
        }



        }
    }




























