package com.example.loginrespage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> implements Filterable {

    private List<Item> mListItem;
    private List<Item> mListItemOld;
    private Context context;


    public ItemAdapter(Context context, List<Item> mListItem){
        this.mListItem = mListItem;
        this.mListItemOld = mListItem;
        this.context = context;

    }



    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item item = mListItem.get(position);
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
        if(item == null){
            return;
        }
        holder .imgItem.setImageResource(item.getImage());
        holder.txt_name.setText(item.getName());
        holder.txt_price.setText(item.getPrice());
        holder.itemView.startAnimation(animation);

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(item);
            }
        });
    }

    private void onClickGoToDetail(Item item) {
        Intent intent = new Intent(context, DetailItemPage.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_item", item);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {

        if(mListItem != null){
            return mListItem.size();
        }
        return 0;
    }




    public  class ItemViewHolder extends RecyclerView.ViewHolder{

        private CardView layoutItem;
        private CircleImageView imgItem;
        private TextView txt_name;
        private TextView txt_price;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imgItem = itemView.findViewById(R.id.img_item);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_price = itemView.findViewById(R.id.txt_price);

        }
    }

    public void release(){
        context = null;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if(strSearch.isEmpty()){
                    mListItem = mListItemOld;

                }else{
                    List<Item> list= new ArrayList<>();
                    for(Item item : mListItemOld){
                        if(item.getName().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(item);
                        }
                    }
                    mListItem = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListItem;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                mListItem = (List<Item>) results.values;
                notifyDataSetChanged();
            }
        };
    }


}
