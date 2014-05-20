package com.vmobs.alerts;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;


public class AlertsFragment extends ListFragment {
	ArrayList<Alert> listItems = new ArrayList<Alert>();
	 @Override
     public void onActivityCreated(Bundle savedInstanceState) {
         super.onActivityCreated(savedInstanceState);
         for (int i = 0; i < 20.; ++i) {
        	 listItems.add(new Alert("Alert "+i, "This is a short description", i%6));
         }
         AlertsListAdapter adapter = new AlertsListAdapter(getActivity(), listItems);
         setListAdapter(adapter);
     }

	

}
