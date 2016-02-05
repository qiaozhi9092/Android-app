package com.example.homework6;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyMainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);//used layout main
		addButton_hello();
		final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.black1);//used the music black1
		mp1.start();//sound when starts the application
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_main, menu);
		return true;
	}
	
	public void addButton_hello() {
		final MediaPlayer mp = MediaPlayer.create(this, R.raw.iphone1);//sound iphone1 when clicked the button
		Button b_hello = (Button) findViewById(R.id.button_hello);
		b_hello.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mp.start();
				startActivity(new Intent(MyMainActivity.this, MyActivity2.class));//goes to second activity
			
			
			}
		});

	}

}
