package com.gauvain.ghibli.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bastou.ghibli.R;
import com.gauvain.ghibli.model.Location;


public class DisplayLocationFragment extends Fragment{

    private TextView name;
    private TextView climate;
    private TextView terrain;
    private TextView surfaceWater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.display_location_layout, container, false);
        name = view.findViewById(R.id.name_location);
        climate = view.findViewById(R.id.climate_location);
        terrain = view.findViewById(R.id.terrain_location);
        surfaceWater = view.findViewById(R.id.swater_location);
        return view;
    }

    public void displayLocation(Location l){
        name.setText(l.getName());
        climate.setText(l.getClimate());
        terrain.setText(l.getTerrain());
        surfaceWater.setText(l.getSurfaceWater());
    }
}
