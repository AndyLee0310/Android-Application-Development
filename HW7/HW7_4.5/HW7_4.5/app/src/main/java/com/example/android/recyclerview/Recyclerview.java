package com.example.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class Recyclerview extends RecyclerView.Adapter<Recyclerview.RecipeViewHolder> {

    public final static String EXTRA_NAME = ".EXTRA.NAME";

    private final LinkedList<String> RecTitles;
    private final LinkedList<String> RecDess;
    private final LayoutInflater LtInfr;

    public Recyclerview(Context context, LinkedList<String> recTitles, LinkedList<String> recDess) {
        LtInfr = android.view.LayoutInflater.from(context);
        this.RecTitles = recTitles;
        this.RecDess = recDess;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LtInfr.inflate(R.layout.recycler_list, parent, false);
        return new RecipeViewHolder(ItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int pos) {
        String CurTitle = RecTitles.get(pos);
        holder.recTitleView.setText(CurTitle);

        String CurDes = RecDess.get(pos);
        holder.recDesView.setText(CurDes);
    }

    @Override
    public int getItemCount() {
        return RecTitles.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView recTitleView;
        public final TextView recDesView;
        public final Recyclerview Adapter;

        public RecipeViewHolder(View itemView, Recyclerview adapter) {
            super(itemView);
            this.Adapter = adapter;
            itemView.setOnClickListener(this);

            recTitleView = itemView.findViewById(R.id.textView);
            recDesView = itemView.findViewById(R.id.textDescription);
        }

        @Override
        public void onClick(View view) {
            int Position = getLayoutPosition();
            String element = RecTitles.get(Position);

            Bundle extras = new Bundle();
            extras.putString(EXTRA_NAME, element);

            Intent intent = new Intent(view.getContext(), Recipe_Activity.class);
            intent.putExtras(extras);

            view.getContext().startActivity(intent);
        }
    }
}