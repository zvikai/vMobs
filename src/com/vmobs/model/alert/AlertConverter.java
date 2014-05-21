package com.vmobs.model.alert;

import com.vmobs.alerts.Alert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liorm on 20/05/2014.
 */
public class AlertConverter {

    public static List<Alert> convert(AlertsDto alert){
        ArrayList<Alert> listItems = new ArrayList<Alert>();
        if(alert != null && alert.getAlerts() != null && !alert.getAlerts().isEmpty()){
            for (AlertDto alertDto : alert.getAlerts()){
                listItems.add(convert(alertDto));
            }
        } else {
            for (int i = 0; i < 17; ++i) {
                listItems.add(new Alert("Alert " + i, "This is a new description", i % 6));
            }
        }
        return listItems;
    }

    public static Alert convert(AlertDto alertDto){
        return new Alert(alertDto.getType(), alertDto.getProblemName(),convertLevel(alertDto.getAlertLevel()));
    }

    public static int convertLevel(String level){
        if(level != null){
            if (level.equals("CRITICAL")){
                return 1;
            }
        }
        return 6;
    }


}
