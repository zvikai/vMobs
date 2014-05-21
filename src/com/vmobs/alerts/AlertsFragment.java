package com.vmobs.alerts;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import com.vmobs.model.alert.AlertConverter;
import com.vmobs.model.alert.AlertsDto;
import com.vmobs.service.ServiceManager;
import com.vmobs.service.VcopsDataAcceptor;


public class AlertsFragment extends ListFragment {
	ArrayList<Alert> listItems = new ArrayList<Alert>();
	 @Override
     public void onActivityCreated(Bundle savedInstanceState) {
         super.onActivityCreated(savedInstanceState);

         //TODO pass the real ip and credentials
         ServiceManager SM = new ServiceManager("", "", "");

         //set mock alerts
         for (int i = 0; i < 20.; ++i) {
        	 listItems.add(new Alert("Alert "+i, "This is a short description", i%6));
         }
         AlertsListAdapter adapter = new AlertsListAdapter(getActivity(), listItems);
         setListAdapter(adapter);

         //get real alerts
         SM.getAlerts(new VcopsDataAcceptor<AlertsDto>() {
             @Override
             public void accept(AlertsDto data) {
                 setListAdapter(new AlertsListAdapter(getActivity(), AlertConverter.convert(data)));
             }
         });
     }

	

}
