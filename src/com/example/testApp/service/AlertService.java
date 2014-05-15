package com.example.testApp.service;

import android.os.AsyncTask;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liorm on 15/05/2014.
 */
public class AlertService extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... params) {
        // The connection URL
        String url = params[0];

// Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

// Add the String message converter
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP GET request, marshaling the response to a String
        String result = restTemplate.getForObject(url, String.class, "Android");
        System.out.println(result);
        return result;
    }
}
