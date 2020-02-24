package io.turntabl.Empire.Job;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Job {

    public  static void main (String args[]) throws Exception {


        URL url = new URL("");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.connect();

        int code = http.getResponseCode();
        System.out.println("Response code is"+code);

    }
}
