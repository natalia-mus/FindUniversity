package com.example.finduniversity.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finduniversity.R;
import com.example.finduniversity.view.interfaces.OnLinkItemClick;

import java.util.List;

public class SingleUniversityLinksAdapter extends RecyclerView.Adapter<SingleUniversityLinksViewHolder> {

    Context context;
    List<String> links;
    OnLinkItemClick onLinkItemClick;

    public SingleUniversityLinksAdapter(Context context, List<String> webPages, OnLinkItemClick onLinkItemClick) {
        this.context = context;
        this.links = webPages;
        this.onLinkItemClick = onLinkItemClick;
    }

    @NonNull
    @Override
    public SingleUniversityLinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.link_item, parent, false);
        return new SingleUniversityLinksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleUniversityLinksViewHolder holder, int position) {
        holder.link.setText(links.get(position));

        holder.linkItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = links.get(position);
                onLinkItemClick.onLinkItemClicked(link);
            }
        });
    }

    @Override
    public int getItemCount() {
        return links.size();
    }
}


class SingleUniversityLinksViewHolder extends RecyclerView.ViewHolder {

    ConstraintLayout linkItem;
    TextView link;

    public SingleUniversityLinksViewHolder(View view) {
        super(view);

        linkItem = view.findViewById(R.id.link_item);
        link = view.findViewById(R.id.link_item_link);
    }
}