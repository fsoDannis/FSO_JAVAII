/* 
 * Project JavaII_Week2
 * Package com.dannis.javaii_week2
 * 
 * @Author Dan Annis
 * Date    May 15, 2013
 */
package com.dannis.javaii_week1;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	EditText nameEditCtrl;
	Button btnCtlr;
	String name;
	ImageView image;
	Button button2;
	TextView backMsg;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		backMsg = (TextView) findViewById(R.id.textView3);
		nameEditCtrl = (EditText) findViewById(R.id.editText1);
		btnCtlr = (Button) findViewById(R.id.button1);
		btnCtlr.setOnClickListener(new ButtonClickHandler());

		addListenerOnButton();
		getSubScreenInfo();
	}

	// Pulling out code that is not UI Specific for fragments set up
	private void getSubScreenInfo() {
			//This gets the message from the subScreen and gets it's text into the textview
			Intent intename = getIntent();
			String uname = (String) intename.getSerializableExtra("MESSAGEBACK");
			backMsg.setText(uname);
	}

	//Takes info entered in the edit box and stores the info to be picked up elsewhere. 
	public class ButtonClickHandler implements View.OnClickListener {
		public void onClick(View view) {
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
	
	//This function tells the button to call out to the web with the given URL
	private void addListenerOnButton() {
		button2 = (Button) findViewById(R.id.buttonSearch);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent browserIntent = 
						new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mlb.com"));
				startActivity(browserIntent);
			}
		});
	}
}
