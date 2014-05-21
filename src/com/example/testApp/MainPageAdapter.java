package com.example.testApp;

import com.vmobs.alerts.AlertsFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
public class MainPageAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments;
    public MainPageAdapter(FragmentManager fm) {
		super(fm);
        fragments = new Fragment[3];
	}
	
	@Override
	public Fragment getItem(int i) {
		return (fragments[i] == null)? createFragment(i): fragments[i];
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "OBJECT " + (position + 1);
	}

    private Fragment createFragment(int i){
        Fragment fragment = new AlertsFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt("Alert",  i + 1);
        fragment.setArguments(args);
        fragments[i] = fragment;
        return fragment;
    }
}