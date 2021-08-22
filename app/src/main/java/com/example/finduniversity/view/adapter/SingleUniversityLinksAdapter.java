package com.example.finduniversity.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finduniversity.R;

import java.util.ArrayList;
import java.util.List;

public class SingleUniversityLinksAdapter extends RecyclerView.Adapter<SingleUniversityLinksViewHolder> {

    Context context;
    List<String> links = new ArrayList<String>();

    public SingleUniversityLinksAdapter(Context context, List<String> webPages, List<String> domains) {
        this.context = context;
        links.addAll(webPages);
        links.addAll(domains);
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
    }

    @Override
    public int getItemCount() {
        return links.size();
    }
}


class SingleUniversityLinksViewHolder extends RecyclerView.ViewHolder {
    TextView link;

    public SingleUniversityLinksViewHolder(View view) {
        super(view);

        link = view.findViewById(R.id.link_item_link);
    }
}