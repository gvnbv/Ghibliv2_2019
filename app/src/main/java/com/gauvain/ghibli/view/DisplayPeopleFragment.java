package com.gauvain.ghibli.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bastou.ghibli.R;
import com.gauvain.ghibli.model.People;


public class DisplayPeopleFragment extends Fragment{

    private TextView name;
    private TextView age;
    private TextView gender;
    private TextView eyes;
    private TextView hair;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.display_people_layout, container, false);
        name = view.findViewById(R.id.name_people);
        gender = view.findViewById(R.id.gender_people);
        age = view.findViewById(R.id.age_people);
        eyes = view.findViewById(R.id.eyes_people);
        hair = view.findViewById(R.id.hair_people);
        return view;
    }

    public void displayPeople(People p){
        name.setText(p.getName());
        gender.setText(p.getGender());
        age.setText(p.getAge());
        eyes.setText(p.getEye_color());
        hair.setText(p.getHair_color());
    }
}
