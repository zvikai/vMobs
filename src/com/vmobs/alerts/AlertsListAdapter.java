package com.vmobs.alerts;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testApp.R;

public class AlertsListAdapter extends ArrayAdapter<Alert> {
	private final Context context;
	private final List<Alert> values;

	public AlertsListAdapter(Context context, List<Alert> values) {
		super(context, R.layout.alert_row_layout, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Alert alert = values.get(position);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.alert_row_layout, parent,
				false);
		TextView label = (TextView) rowView.findViewById(R.id.alert_label);
		TextView desc = (TextView) rowView.findViewById(R.id.alert_description);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.alert_icon);
		label.setText(alert.getTitle());
		desc.setText(alert.getDescription());
		// Change the icon for Windows and iPhone
		imageView.setImageResource(getAlertIcon(alert.getSeverity()));
		// if (s.startsWith("Windows7") || s.startsWith("iPhone")
		// || s.startsWith("Solaris")) {
		// imageView.setImageResource(R.drawable.no);
		// } else {
		// imageView.setImageResource(R.drawable.ok);
		// }
//		final LayoutParams params = desc.getLayoutParams();
//
//        if (params != null) {
//                params.height = 20;
//        }

		return rowView;
	}

	private int getAlertIcon(int i) {
		switch (i) {
		case 0:
			return R.drawable.criticality_level_0;
		case 1:
			return R.drawable.criticality_level_1;
		case 2:
			return R.drawable.criticality_level_2;
		case 3:
			return R.drawable.criticality_level_3;
		case 4:
			return R.drawable.criticality_level_4;
		case 5:
			return R.drawable.criticality_level_5;
		default:
			return R.drawable.criticality_level_0;
		}

	}

}
