package com.vmobs.service;

import android.app.ListActivity;
import android.util.Log;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * Created by liorm on 20/05/2014.
 */
public class ServiceManager {

    private static final String USER = "user";
    private static final String PASS = "Admin123!";

    static {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        } };

        // Installing the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            Log.e("ServiceManager", e.getMessage());
        }

        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
    }

    private ListActivity listActivity;

    public ServiceManager(ListActivity listActivity) {
        this.listActivity = listActivity;
    }

    public void getAlerts(){
      AlertService alertService = new AlertService(listActivity, "https://10.23.203.6/suite-api/api/alerts",
              USER, PASS);
      alertService.execute("96ddab79-31fa-41ad-84ca-05aa99cc998a");
    }
}
