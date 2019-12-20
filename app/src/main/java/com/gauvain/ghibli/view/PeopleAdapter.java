package com.gauvain.ghibli.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gauvain.ghibli.MainActivity;
import com.bastou.ghibli.R;
import com.gauvain.ghibli.model.People;

import java.util.List;


public class PeopleAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<People> values;
    private MainActivity mainActivity;

    public void setValues(List<People> values) {
        this.values = values;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PeopleAdapter(List<People> myDataset, MainActivity mainActivity) {
        this.setValues(myDataset);
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_list_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final People people = values.get(position);
        holder.text_field.setText(people.getName());
        holder.text_field.setText(people.getName());
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.displayPeoples(people);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}