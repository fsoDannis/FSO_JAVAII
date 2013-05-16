/* 
 * Project JavaII_Week1
 * Package com.dannis.javaii_week1
 * 
 * @Author Dan Annis
 * Date    May 9, 2013
 */
package com.dannis.javaii_week1;


import com.dannis.javaii_week1.MainActivity.ButtonClickHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubScreen extends Activity {
	
	TextView findTeam;
	EditText nameEditCtrl2;
	Button btnCtlr2;
	String name2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subscreen);
		findTeam = (TextView) findViewById(R.id.textView1);
		Intent intename = getIntent();
		String uname = (String) intename.getSerializableExtra("USERNAME");
		findTeam.setText("You Selected: " + uname);
		
		nameEditCtrl2 = (EditText) findViewById(R.id.editText2);
		btnCtlr2 = (Button) findViewById(R.id.button2);
		btnCtlr2.setOnClickListener(new ButtonClickHandler());
	}

	//Passing the info back to the first activity
	public class ButtonClickHandler implements View.OnClickListener {
		public void onClick(View view) {
			if (nameEditCtrl2 != null && nameEditCtrl2.getText().length() != 0) {
				name2 = nameEditCtrl2.getText().toString();
			} else {
				name2 = "Whoops you didn't type anything";
			}
			Intent intObj2 = new Intent(SubScreen.this,
					MainActivity.class);
			intObj2.putExtra("MESSAGEBACK", name2);
			startActivity(intObj2);
		}
	}
}

