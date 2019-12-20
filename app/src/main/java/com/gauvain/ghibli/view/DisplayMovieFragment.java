package com.gauvain.ghibli.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bastou.ghibli.R;
import com.gauvain.ghibli.model.Movie;


public class DisplayMovieFragment extends Fragment{

    private TextView title;
    private TextView director;
    private TextView producer;
    private TextView desc;
    private TextView date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.display_movie_layout, container, false);
        title = view.findViewById(R.id.title_movie);
        director = view.findViewById(R.id.director_movie);
        producer = view.findViewById(R.id.producer_movie);
        desc = view.findViewById(R.id.description_movie);
        date = view.findViewById(R.id.date);
        return view;
    }

    public void displayMovie(Movie m){
        title.setText(m.getTitle());
        director.setText(m.getDirector());
        producer.setText(m.getProducer());
        desc.setText(m.getDesc());
        date.setText(m.getDate());
    }
}
