package com.vmobs.service;

import android.support.v4.app.ListFragment;
import android.util.Log;
import com.vmobs.model.alert.AlertsDto;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;

/**
 * Created by liorm on 20/05/2014.
 */
public class ServiceManager {

    private static final String BASE = "https://{0}/suite-api/api/";
    private String baseUrl = "https://{0}/suite-api/api/";
    private String user = "admin";
    private String pass = "Admin123!";
    private String ip = "10.23.203.6";

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

    public ServiceManager(String ip, String user, String pass) {
//        this.ip = ip;
//        this.user = user;
//        this.pass = pass;
        baseUrl = MessageFormat.format(BASE, this.ip);
    }

    public void getAlerts(VcopsDataAcceptor<AlertsDto> dataAcceptor){
      AlertService alertService = new AlertService(dataAcceptor, baseUrl,
              user, pass);
      alertService.execute("96ddab79-31fa-41ad-84ca-05aa99cc998a");
    }
}
