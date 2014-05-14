package com.example.testApp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vmobs.alerts.AlertsActivity;

public class MyActivity extends Activity {
	ListView list;
	ArrayList<String> listItems = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	int clickCounter = 0;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	public void moveToAlerts(View view) {
		 Intent intent = new Intent(this, AlertsActivity.class);
		    startActivity(intent);
	}

	
}
