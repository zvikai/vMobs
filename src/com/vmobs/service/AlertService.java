package com.vmobs.service;

import android.app.ListActivity;
import android.os.AsyncTask;
import com.vmobs.model.alert.AlertConverter;
import com.vmobs.model.alert.AlertsDto;
import com.vmobs.alerts.AlertsListAdapter;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liorm on 15/05/2014.
 */
public class AlertService extends AsyncTask<String, String, AlertsDto> {

    private ListActivity listActivity;
    private final String baseUrl;
    private final String user;
    private final String pass;

    public AlertService(ListActivity listActivity, String baseUrl, String user, String pass) {
        this.listActivity = listActivity;
        this.baseUrl = baseUrl;
        this.user = user;
        this.pass = pass;
    }

    @Override
    protected AlertsDto doInBackground(String... params) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

        ResponseEntity<AlertsDto> result = restTemplate.exchange("https://10.23.203.6/suite-api/api/alerts?{resourceId}",
                HttpMethod.GET, createRequestEntity(), AlertsDto.class, params[0]);
        return  result.getBody();
    }

    @Override
    protected void onPostExecute(AlertsDto alertsDto) {
        listActivity.setListAdapter(new AlertsListAdapter(listActivity, AlertConverter.convert(alertsDto)));
    }

    private HttpEntity createRequestEntity(){
        HttpAuthentication authHeader = new HttpBasicAuthentication(user, pass);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAuthorization(authHeader);
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        return requestEntity;
    }
}
