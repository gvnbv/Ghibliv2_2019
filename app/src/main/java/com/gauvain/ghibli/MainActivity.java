package com.gauvain.ghibli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.bastou.ghibli.R;
import com.gauvain.ghibli.controller.GhibliAPI;
import com.gauvain.ghibli.controller.RequestEnd;
import com.gauvain.ghibli.model.Location;
import com.gauvain.ghibli.model.Movie;
import com.gauvain.ghibli.model.People;
import com.gauvain.ghibli.view.DisplayLocationFragment;
import com.gauvain.ghibli.view.DisplayMovieFragment;
import com.gauvain.ghibli.view.DisplayPeopleFragment;
import com.gauvain.ghibli.view.ListLocationFragment;
import com.gauvain.ghibli.view.ListMoviesFragment;
import com.gauvain.ghibli.view.ListPeopleFragment;
import com.gauvain.ghibli.view.LoadFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int LOAD_FRAGMENT_ID = 0;
    public static final int LIST_MOVIES_FRAGMENT_ID = 1;
    public static final int DISPLAY_MOVIE_FRAGMENT_ID = 2;
    public static final int LIST_PEOPLE_FRAGMENT_ID = 3;
    public static final int DISPLAY_PEOPLE_FRAGMENT_ID = 4;
    public static final int LIST_LOCATION_FRAGMENT_ID = 5;
    public static final int DISPLAY_LOCATION_FRAGMENT_ID = 6;

    private LoadFragment loadFragment;
    private ListMoviesFragment listMoviesFragment;
    private DisplayMovieFragment displayMovieFragment;
    private ListPeopleFragment listPeopleFragment;
    private DisplayPeopleFragment displayPeopleFragment;
    private ListLocationFragment listLocationFragment;
    private DisplayLocationFragment displayLocationFragment;
    private int last_fragment;
    private int actual_fragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment = (LoadFragment) getFragmentManager().findFragmentById(R.id.load_fragment);
        listMoviesFragment = (ListMoviesFragment) getFragmentManager().findFragmentById(R.id.list_movies_fragment);
        displayMovieFragment = (DisplayMovieFragment) getFragmentManager().findFragmentById(R.id.display_movie_fragment);
        listPeopleFragment = (ListPeopleFragment) getFragmentManager().findFragmentById(R.id.list_people_fragment);
        displayPeopleFragment = (DisplayPeopleFragment) getFragmentManager().findFragmentById(R.id.display_people_fragment);
        listLocationFragment = (ListLocationFragment) getFragmentManager().findFragmentById(R.id.list_location_fragment);
        displayLocationFragment = (DisplayLocationFragment) getFragmentManager().findFragmentById(R.id.display_location_fragment);
        actual_fragment = LIST_MOVIES_FRAGMENT_ID;
        last_fragment = LIST_MOVIES_FRAGMENT_ID;
        bottomNavigationView = findViewById(R.id.navigation_bar);
        displayMovies();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_movie:
                        displayMovies();
                        break;
                    case R.id.action_people:
                        displayPeoples();
                        break;
                    case R.id.action_location:
                        displayLocation();
                        break;
                }
                return true;
            }
        });
    }

    private void displayLocation(){
        displayFragment(LOAD_FRAGMENT_ID);
        final MainActivity mainActivity = this;
        GhibliAPI.getAllLocation(loadFragment, new RequestEnd() {
            @Override
            public void onRequestEnd(final Object obj) {
                loadFragment.getView().post(new Runnable() {
                    @Override
                    public void run() {
                        listLocationFragment.setNewDataSet((ArrayList<Location>)obj, mainActivity);
                        displayFragment(LIST_LOCATION_FRAGMENT_ID);
                    }
                });
            }
        });
    }

    private void displayMovies(){
        displayFragment(LOAD_FRAGMENT_ID);
        final MainActivity mainActivity = this;
        GhibliAPI.getAllMovies(loadFragment, new RequestEnd() {
            @Override
            public void onRequestEnd(final Object obj) {
                loadFragment.getView().post(new Runnable() {
                    @Override
                    public void run() {
                        listMoviesFragment.setNewDataSet((ArrayList<Movie>)obj, mainActivity);
                        displayFragment(LIST_MOVIES_FRAGMENT_ID);
                    }
                });
            }
        });
    }

    private void displayPeoples(){
        displayFragment(LOAD_FRAGMENT_ID);
        final MainActivity mainActivity = this;
        GhibliAPI.getAllPeople(loadFragment, new RequestEnd() {
            @Override
            public void onRequestEnd(final Object obj) {
                loadFragment.getView().post(new Runnable() {
                    @Override
                    public void run() {
                        listPeopleFragment.setNewDataSet((ArrayList<People>)obj, mainActivity);
                        displayFragment(LIST_PEOPLE_FRAGMENT_ID);
                    }
                });
            }
        });
    }

    public void displayMovie(Movie m){
        displayMovieFragment.displayMovie(m);
        displayFragment(DISPLAY_MOVIE_FRAGMENT_ID);
    }

    public void displayLocation(Location l){
        displayLocationFragment.displayLocation(l);
        displayFragment(DISPLAY_LOCATION_FRAGMENT_ID);
    }

    public void displayPeoples(People p){
        displayPeopleFragment.displayPeople(p);
        displayFragment(DISPLAY_PEOPLE_FRAGMENT_ID);
    }

    public void displayFragment(int id){
        loadFragment.getView().setVisibility(LOAD_FRAGMENT_ID == id ? View.VISIBLE : View.INVISIBLE);
        bottomNavigationView.setVisibility(LOAD_FRAGMENT_ID != id ? View.VISIBLE : View.INVISIBLE);
        listMoviesFragment.getView().setVisibility(LIST_MOVIES_FRAGMENT_ID == id ? View.VISIBLE : View.INVISIBLE);
        displayMovieFragment.getView().setVisibility(DISPLAY_MOVIE_FRAGMENT_ID == id ? View.VISIBLE : View.INVISIBLE);
        listPeopleFragment.getView().setVisibility(LIST_PEOPLE_FRAGMENT_ID == id ? View.VISIBLE : View.INVISIBLE);
        displayPeopleFragment.getView().setVisibility(DISPLAY_PEOPLE_FRAGMENT_ID == id ? View.VISIBLE : View.INVISIBLE);
        listLocationFragment.getView().setVisibility(LIST_LOCATION_FRAGMENT_ID == id ? View.VISIBLE : View.INVISIBLE);
        displayLocationFragment.getView().setVisibility(DISPLAY_LOCATION_FRAGMENT_ID == id ? View.VISIBLE : View.INVISIBLE);
        if(id != LOAD_FRAGMENT_ID){
            last_fragment = actual_fragment;
            actual_fragment = id;
        }
    }

    @Override
    public void onBackPressed() {
        if(last_fragment == actual_fragment){
            super.onBackPressed();
        }
        else {
            displayFragment(last_fragment);
        }
    }
}
