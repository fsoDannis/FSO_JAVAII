package com.example.transistioningfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflate, ViewGroup container, Bundle SavedInstanceState){
		return inflater.inflate(R.layout.fragment_1, container, false);
	}
}
