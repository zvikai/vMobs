package com.example.testApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import com.example.testApp.service.AlertService;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button);
        WebView view = (WebView)findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new WebViewClient());

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                WebView view = (WebView)findViewById(R.id.webView);
                view.loadUrl("http://www.gmail.com");
            }
        });

        AlertService service = new AlertService();
        service.execute("https://ajax.googleapis.com/ajax/" +
                "services/search/web?v=1.0&q={query}");

    }
}
