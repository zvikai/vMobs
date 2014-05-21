package com.vmobs.service;

import android.support.v4.app.ListFragment;
import com.vmobs.model.alert.AlertConverter;
import com.vmobs.model.alert.AlertsDto;
import com.vmobs.alerts.AlertsListAdapter;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liorm on 15/05/2014.
 */
public class AlertService extends VcopsService<String, String, AlertsDto> {

    public AlertService(VcopsDataAcceptor<AlertsDto> dataAcceptor, String baseUrl, String user, String pass) {
        super(dataAcceptor, baseUrl + "alerts", user, pass);
    }

    @Override
    protected AlertsDto doInBackground(String... params) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

        ResponseEntity<AlertsDto> result = restTemplate.exchange(baseUrl + "?showSelfAlerts=true&impactBadge=&resourceId=&start=0&limit=50&currentComponentInfo=TODO&page=0&pageSize=100",
                HttpMethod.GET, createRequestEntity(), AlertsDto.class);
        return  result.getBody();
    }

    @Override
    protected void onPostExecute(AlertsDto alertsDto) {
        dataAcceptor.accept(alertsDto);
    }
}
