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
import com.example.finduniversity.data.University;

import java.util.ArrayList;

public class UniversitiesListAdapter extends RecyclerView.Adapter<UniversitiesListViewHolder> {

    private final Context context;
    private final ArrayList<University> universities;

    public UniversitiesListAdapter(Context context, ArrayList<University> universities) {
        this.context = context;
        this.universities = universities;
    }

    @NonNull
    @Override
    public UniversitiesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.university_item, parent, false);
        return new UniversitiesListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversitiesListViewHolder holder, int position) {
        String universityName = universities.get(position).getName();
        holder.name.setText(universityName);
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

}


class UniversitiesListViewHolder extends RecyclerView.ViewHolder {

    ConstraintLayout item;
    TextView name;

    public UniversitiesListViewHolder(View view) {
        super(view);

        item = view.findViewById(R.id.university_item);
        name = view.findViewById(R.id.university_item_name);
    }
}