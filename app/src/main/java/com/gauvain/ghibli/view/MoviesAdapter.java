package com.gauvain.ghibli.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.gauvain.ghibli.MainActivity;
import com.bastou.ghibli.R;
import com.gauvain.ghibli.model.Movie;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Movie> values;
    private MainActivity mainActivity;

    public void setValues(List<Movie> values) {
        this.values = values;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MoviesAdapter(List<Movie> myDataset, MainActivity mainActivity) {
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
        final Movie movie = values.get(position);
        holder.text_field.setText(movie.getTitle());
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.displayMovie(movie);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}