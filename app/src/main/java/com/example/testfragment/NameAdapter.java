package com.example.testfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    ArrayList<Name> names;
    ItemOnClickListener itemOnClickListener;

    public NameAdapter(ArrayList<Name> names, ItemOnClickListener itemOnClickListener) {
        this.names = names;
        this.itemOnClickListener = itemOnClickListener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custum_name_layout, parent, false);
        return new NameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Name name = names.get(position);
        holder.bind(name);

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Name name;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.custom_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemOnClickListener.onClick(name);
                }
            });

        }


        void bind(Name name) {
            this.name = name;
            textView.setText(name.getName());
        }

    }
}
