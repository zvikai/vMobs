package com.vmobs.service;

import android.os.AsyncTask;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

/**
 * Created by liorm on 21/05/2014.
 */
public abstract class VcopsService<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    protected VcopsDataAcceptor<Result> dataAcceptor;
    protected String baseUrl;
    protected String user;
    protected String pass;

    public VcopsService(VcopsDataAcceptor<Result> dataAcceptor, String baseUrl, String user, String pass) {
        this.dataAcceptor = dataAcceptor;
        this.baseUrl = baseUrl;
        this.user = user;
        this.pass = pass;
    }

    @Override
    protected void onPostExecute(Result result) {
        dataAcceptor.accept(result);
    }

    protected HttpEntity createRequestEntity(){
        HttpAuthentication authHeader = new HttpBasicAuthentication(user, pass);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAuthorization(authHeader);
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        return requestEntity;
    }


}
