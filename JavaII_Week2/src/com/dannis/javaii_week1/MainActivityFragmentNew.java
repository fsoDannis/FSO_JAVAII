package com.dannis.javaii_week1;

import com.dannis.javaii_week1.MainActivity.ButtonClickHandler;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityFragmentNew extends Fragment implements OnClickListener {

	EditText nameEditCtrl;
	Button btnCtlr;
	String name;
	ImageView image;
	Button button2;
	TextView backMsg;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.mainnew, container);
		return view;
		
		backMsg = (TextView) view.findViewById(R.id.textView3);
		nameEditCtrl = (EditText) view.findViewById(R.id.editText1);
		btnCtlr = (Button) view.findViewById(R.id.button1);
		btnCtlr.setOnClickListener(new ButtonClickHandler());

		//addListenerOnButton();
		//getSubScreenInfo();
		
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		if (nameEditCtrl != null && nameEditCtrl.getText().length() != 0) {
			name = nameEditCtrl.getText().toString();
		} else {
			name = "Uh Oh.. You did not select a valid name.";
		}
		Intent intObj = new Intent(MainActivity.this,
				SubScreen.class);
		intObj.putExtra("USERNAME", name);
		startActivity(intObj);
	}		 
		
	}


}
