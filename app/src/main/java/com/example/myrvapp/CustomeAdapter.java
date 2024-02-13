package com.example.myrvapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

     ArrayList<DataModel> dataset;//0.we need to save the arr for using
      ArrayList<DataModel> filteredList;//for the searching

    //pass the arr from the main
    public CustomeAdapter(ArrayList<DataModel> dataset) {
        this.dataset=dataset;
        this.filteredList = new ArrayList<>(dataset);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<DataModel> filteredList) {
        this.filteredList = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{//2.THE CONNECTION TO THE CARD,take out the data

        TextView textCharacterName;
        TextView textCharacterDescription;
        ImageView characterImage;

        public MyViewHolder (View itemView){//content of the card,for using
            super(itemView);
            textCharacterName=itemView.findViewById(R.id.textView1);
            textCharacterDescription=itemView.findViewById(R.id.textView2);
            characterImage=itemView.findViewById(R.id.imageView);

        }

    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);//1.return the card was opened
        MyViewHolder myVHolder=new MyViewHolder(view); //MyViewHolder--all the data on the card
        return myVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {//in the back have a loop for the object[i]==position,paas all the arr
        DataModel currentItem = filteredList.get(position);//for the searching

        holder.textCharacterName.setText(currentItem.getCharacterName());
        holder.textCharacterDescription.setText(currentItem.getCharacterDescription());
        holder.characterImage.setImageResource(currentItem.getCharacterImage());

        //holder.textCharacterName.setText(dataset.get(position).getCharacterName());
        //holder.textCharacterDescription.setText(dataset.get(position).getCharacterDescription());
       // holder.characterImage.setImageResource(dataset.get(position).getCharacterImage());


        // Adding click listener to the itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event
                String characterName = dataset.get(position).getCharacterName();
                String message = "Clicked on " + characterName;
                Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show(); // Show the Toast message
            }
        });

    }

//    @Override
//    public int getItemCount() {
//        return dataset.size();
//    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }



}
