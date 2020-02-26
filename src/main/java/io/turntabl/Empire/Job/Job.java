package io.turntabl.Empire.Job;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Job {

        public static void getStatus(String url) throws IOException {
                String result = "";
                int code = 200;
                try{
                        URL siteURL = new URL(url);
                        HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(3000);
                        connection.connect();

                        code = connection.getResponseCode();
                        if (code == 200) {
//                                result = "-> Green <-\t
                                System.out.println("green");

                        }
                        else {
                                System.out.println("red");

                        }
                }
                catch (Exception e){
                        System.out.println(e.getMessage());
                }
        }
}


