package com.gauvain.ghibli.controller;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Request extends AsyncTask<Object, Void, String> {

    private RequestResult requestResult;

    public Request(RequestResult requestResult) {
        this.requestResult = requestResult;
    }

    @Override
    protected String doInBackground(Object... params) {
        if(params.length != 1)
            return null;
        try {
            StringBuilder sb = new StringBuilder();
            URL url = new URL((String)params[0]);
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();
            this.requestResult.onResult(sb.toString());
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String str) {

    }

}