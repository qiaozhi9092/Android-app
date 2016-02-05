package com.example.homework6;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MyActivity2 extends Activity {
/** Called when the activity is first created. */
	public static final String FEEDBACK = "first.second.MyActivity2.FEEDBACK";//Keys
	public static final String SELECTED_BREAD = "first.second.MyActivity2.SELECTED_BREAD";
	public static final String SELECTED_MEAT = "first.second.MyActivity2.SELECTED_MEAT";
	
	private RadioButton radioBreadButton;
	private RadioGroup rg;
	private EditText et;
	
	@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.myact2);//used layout myact2
addSubmitButton();


}

public void addSubmitButton()
{
	final MediaPlayer mp = MediaPlayer.create(this, R.raw.angry1);//sound angry1
	Button b_submit = (Button) findViewById(R.id.button_submit);
	b_submit.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			
			mp.start();
			String bread = "";
			String meat = "";
		
			startActivity(new Intent(MyActivity2.this, MyActivity3.class));
			

			radioBreadButton = (RadioButton) findViewById(R.id.radioButton_whitebread);//radio button
			if(radioBreadButton.isChecked())
				bread = "White bread";
			else
				bread = "Wheat bread";

			
			CheckBox cb = (CheckBox) findViewById(R.id.checkBox_bacon);//checkbox
			CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox_steak);
			if (cb.isChecked())
				meat = "bacon";
			if (cb2.isChecked())
				meat = "steak";
			if (cb.isChecked() && cb2.isChecked())
				meat = "bacon and steak";
			else 
				meat = "no meat";
			
				
			
			et=(EditText) findViewById(R.id.editTextField1);//text field
			String feedback=et.getText().toString();
			
			Intent intent = new Intent(MyActivity2.this, MyActivity3. class);//use intent to pass 3 strings to third activity
			intent.putExtra(SELECTED_BREAD,bread);
			intent.putExtra(SELECTED_MEAT,meat);
			intent.putExtra(FEEDBACK,feedback);

			startActivity(intent);

		
		
		}
	});

}
}		