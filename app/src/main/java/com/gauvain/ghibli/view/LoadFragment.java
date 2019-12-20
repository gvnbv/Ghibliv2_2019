package com.gauvain.ghibli.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bastou.ghibli.R;
import com.gauvain.ghibli.controller.RequestProgress;


public class LoadFragment extends Fragment implements RequestProgress {

    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.load_layout, container, false);
        progressBar = view.findViewById(R.id.progress_bar);
        return view;
    }


    @Override
    public void onUpdate(int progress, int max) {
        progressBar.setMax(max);
        progressBar.setProgress(progress);
    }

}
