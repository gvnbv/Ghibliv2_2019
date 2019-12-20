package com.gauvain.ghibli.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gauvain.ghibli.MainActivity;
import com.bastou.ghibli.R;
import com.gauvain.ghibli.model.Location;

import java.util.ArrayList;


public class ListLocationFragment extends Fragment {

    private RecyclerView recyclerView;
    private LocationAdapter locationAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);
        recyclerView = view.findViewById(R.id.listview);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    public void setNewDataSet(ArrayList<Location> locations, MainActivity mainActiivty){
        locationAdapter = new LocationAdapter(new ArrayList<Location>(), mainActiivty);
        locationAdapter.setValues(locations);
        recyclerView.setAdapter(locationAdapter);
        locationAdapter.notifyDataSetChanged();
    }

}
