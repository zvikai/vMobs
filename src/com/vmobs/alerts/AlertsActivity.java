package com.vmobs.alerts;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.testApp.R;
import com.vmobs.service.ServiceManager;

public class AlertsActivity extends ListActivity {
	ArrayList<Alert> listItems = new ArrayList<Alert>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alerts_activity);
        ServiceManager SM = new ServiceManager(this);

		for (int i = 0; i < 20.; ++i) {
			listItems.add(new Alert("Alert "+i, "This is a short description", i%6));
		}
		 AlertsListAdapter adapter = new AlertsListAdapter(this, listItems);
	     setListAdapter(adapter);

        //get real alerts
        SM.getAlerts();
	}

	

}
