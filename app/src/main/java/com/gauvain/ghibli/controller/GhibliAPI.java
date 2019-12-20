package com.gauvain.ghibli.controller;

import com.gauvain.ghibli.model.Location;
import com.gauvain.ghibli.model.Movie;
import com.gauvain.ghibli.model.People;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GhibliAPI {

    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DIRECTOR = "director";
    private static final String KEY_PRODUCER = "producer";
    private static final String KEY_DATE = "release_date";

    public static void getAllMovies(final RequestProgress requestProgress, final RequestEnd requestEnd){
        if(requestProgress != null)
            requestProgress.onUpdate(0, 1);
        new Request(new RequestResult() {
            @Override
            public void onResult(String result) {
                ArrayList<Movie> res = new ArrayList<>();
                try {
                    JSONArray array = new JSONArray(result);
                    for(int i = 0 ; i < array.length() ; i++){
                        JSONObject json = array.getJSONObject(i);
                        res.add(new Movie(json.getString(KEY_TITLE),json.getString(KEY_DESCRIPTION),json.getString(KEY_DIRECTOR),json.getString(KEY_PRODUCER),json.getString(KEY_DATE)));
                        if(requestProgress != null)
                            requestProgress.onUpdate(i, array.length());
                    }
                    if(requestProgress != null) requestProgress.onUpdate(array.length(), array.length());
                    if(requestEnd != null) requestEnd.onRequestEnd(res);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }).execute("https://ghibliapi.herokuapp.com/films");
    }

    private static final String KEY_NAME = "name";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_AGE = "age";
    private static final String KEY_EYES = "eye_color";
    private static final String KEY_HAIR = "hair_color";

    public static void getAllPeople(final RequestProgress requestProgress, final RequestEnd requestEnd){
        if(requestProgress != null)
            requestProgress.onUpdate(0, 1);
        new Request(new RequestResult() {
            @Override
            public void onResult(String result) {
                ArrayList<People> res = new ArrayList<>();
                try {
                    JSONArray array = new JSONArray(result);
                    for(int i = 0 ; i < array.length() ; i++){
                        JSONObject json = array.getJSONObject(i);
                        res.add(new People(json.getString(KEY_NAME),json.getString(KEY_GENDER),json.getString(KEY_AGE),json.getString(KEY_EYES),json.getString(KEY_HAIR)));
                        if(requestProgress != null)
                            requestProgress.onUpdate(i, array.length());
                    }
                    if(requestProgress != null) requestProgress.onUpdate(array.length(), array.length());
                    if(requestEnd != null) requestEnd.onRequestEnd(res);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }).execute("https://ghibliapi.herokuapp.com/people");
    }

    private static final String KEY_CLIMATE = "climate";
    private static final String KEY_TERRAIN = "terrain";
    private static final String KEY_SWATER = "surface_water";

    public static void getAllLocation(final RequestProgress requestProgress, final RequestEnd requestEnd){
        if(requestProgress != null)
            requestProgress.onUpdate(0, 1);
        new Request(new RequestResult() {
            @Override
            public void onResult(String result) {
                ArrayList<Location> res = new ArrayList<>();
                try {
                    JSONArray array = new JSONArray(result);
                    for(int i = 0 ; i < array.length() ; i++){
                        JSONObject json = array.getJSONObject(i);
                        res.add(new Location(json.getString(KEY_NAME),json.getString(KEY_CLIMATE),json.getString(KEY_TERRAIN),json.getString(KEY_SWATER)));
                        if(requestProgress != null)
                            requestProgress.onUpdate(i, array.length());
                    }
                    if(requestProgress != null) requestProgress.onUpdate(array.length(), array.length());
                    if(requestEnd != null) requestEnd.onRequestEnd(res);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }).execute("https://ghibliapi.herokuapp.com/locations");
    }

}
