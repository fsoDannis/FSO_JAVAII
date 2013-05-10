/* 
 * Project JavaII_Week1
 * Package com.dannis.javaii_week1
 * 
 * @Author Dan Annis
 * Date    May 7, 2013
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
	/** Called when the activity is first created. */
	EditText nameEditCtrl;
	Button btnCtlr;
	String name;
	ImageView image;
	Button button2;
	
	//Textview for message from SubScreen
	TextView backMsg;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		backMsg = (TextView) findViewById(R.id.textView3);
		Intent intename = getIntent();
		String uname = (String) intename.getSerializableExtra("MESSAGEBACK");
		backMsg.setText(uname);
		//
		nameEditCtrl = (EditText) findViewById(R.id.editText1);
		btnCtlr = (Button) findViewById(R.id.button1);
		btnCtlr.setOnClickListener(new ButtonClickHandler());
		
		addListenerOnButton();
	}
	
//Button Listener to Call out to the web
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

	//Button Listener to go get the info and pass it on
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
}

