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
import com.gauvain.ghibli.model.People;

import java.util.ArrayList;


public class ListPeopleFragment extends Fragment {

    private RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);
        recyclerView = view.findViewById(R.id.listview);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    public void setNewDataSet(ArrayList<People> peoples, MainActivity mainActiivty){
        peopleAdapter = new PeopleAdapter(new ArrayList<People>(), mainActiivty);
        peopleAdapter.setValues(peoples);
        recyclerView.setAdapter(peopleAdapter);
        peopleAdapter.notifyDataSetChanged();
    }

}
