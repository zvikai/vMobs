package com.vmobs.service;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import com.vmobs.model.alert.AlertsDto;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;

/**
 * Created by liorm on 20/05/2014.
 */
public class TestService extends AsyncTask<String, String, String> {

    AssetManager assetManager;



    public TestService(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override
    protected String doInBackground(String... params) {
        /******************************           accept all **********************************************/
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
            ;
        }

        // Promiscuous Hostname Verifier
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        /*****************************************************************************************************/


        // The connection URL
//        String url = params[0];

// Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

// Add the String message converter
//        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

//        ResponseEntity<SearchResultDto> result =  restTemplate.exchange(url, HttpMethod.GET, getRequestEntity(), SearchResultDto.class, "android");

// Make the HTTP GET request, marshaling the response to a String
//        SearchResultDto result = restTemplate.getForObject(url, SearchResultDto.class, "Android");

//        ResultDto result = restTemplate.getForObject(url, ResultDto.class);
        InputStream caInput = null;
        String[] certificationses = null;
        try {
            certificationses = assetManager.list("certifications");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < certificationses.length; i++) {
            URL url = null;
            try {
                url = new URL(params[0]);

//                URLConnection urlConnection = url.openConnection();
//            InputStream in = urlConnection.getInputStream();

                // Load CAs from an InputStream
// (could be from a resource or ByteArrayInputStream or ...)
//                CertificateFactory cf = CertificateFactory.getInstance("X.509");
//
//                certificationses = assetManager.list("certifications");
//                caInput = assetManager.open("certifications/" + certificationses[i]);
//
//
//
//
//                java.security.cert.Certificate ca;
//
//                ca = cf.generateCertificate(caInput);
//                System.out.println("*** File: " + certificationses[i] +" , ca=" + ((X509Certificate) ca).getSubjectDN());
//
//
//
//                String keyStoreType = KeyStore.getDefaultType();
//                KeyStore keyStore = KeyStore.getInstance(keyStoreType);
//                keyStore.load(null, /*"storePW".toCharArray()*/null);
//                keyStore.setCertificateEntry("ca", ca);
//
//
//                String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//                TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
//                tmf.init(keyStore);
//
//
//                /*************************************************************/
//                TrustManager[] trustManagers = tmf.getTrustManagers();
//                final X509TrustManager origTrustmanager = (X509TrustManager) trustManagers[0];
//
//                TrustManager[] wrappedTrustManagers = new TrustManager[]{
//                        new X509TrustManager() {
//                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                                return origTrustmanager.getAcceptedIssuers();
//                            }
//
//                            public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
//                                origTrustmanager.checkClientTrusted(certs, authType);
//                            }
//
//                            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//                                try {
//                                    origTrustmanager.checkServerTrusted(certs, authType);
//                                } catch (CertificateExpiredException e) {
//                                    e.printStackTrace();
//                                } catch (CertificateException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                };
//
//                SSLContext sc = SSLContext.getInstance("TLS");
//                sc.init(null, wrappedTrustManagers, null);
//                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

                /********************************************************************************/

// Create an SSLContext that uses our TrustManager
//                SSLContext context = SSLContext.getInstance("TLS");
//                context.init(null, tmf.getTrustManagers(), null);

                HttpAuthentication authHeader = new HttpBasicAuthentication("admin", "Admin123!");
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

//                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

// Make the HTTP GET request, marshaling the response to a String
                ResponseEntity<AlertsDto> result = restTemplate.exchange(params[0], HttpMethod.GET, requestEntity, AlertsDto.class);



//                ResultDto result = restTemplate.getForObject(params[0], ResultDto.class);


//                url = new URL(params[0]);
//                HttpsURLConnection urlConnection1 = (HttpsURLConnection) url.openConnection();
//                urlConnection1.setSSLSocketFactory(sc.getSocketFactory());
//                InputStream in = urlConnection1.getInputStream();
                System.out.println("####################  SUCESSS ############################");
                System.out.println(result);

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                try {
                    caInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//    }

//        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
        return "sucess";
    }

    private HttpEntity<?> getRequestEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        return new HttpEntity<Object>(requestHeaders);
    }
}
