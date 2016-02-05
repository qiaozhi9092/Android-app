package com.example.homework6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MyActivity3 extends Activity {
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.myact3);//used layout myact3
addButton_cam();
addButton_exit();




Intent intent = getIntent();//takes in 3 strings
String feedback=intent.getStringExtra(MyActivity2.FEEDBACK);
String bread=intent.getStringExtra(MyActivity2.SELECTED_BREAD);
String meat=intent.getStringExtra(MyActivity2.SELECTED_MEAT);

TextView tv = (TextView) findViewById(R.id.textView_result);//display the selections and feedback result
tv.setText("You Chose: "+bread+" with "+meat+"\n"+"\nYour feedback: "+feedback+".");



}




public void addButton_cam() {//add camera button
	final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.cam);//sound cam
	Button b_cam = (Button) findViewById(R.id.button_cam);
	b_cam.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			mp1.start();
			Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent, 0);
		
		
		}
	});

}

public void addButton_exit() {//add the exit button

	final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.quit);//sound quit
	Button b_exit = (Button) findViewById(R.id.Button_exit);
	b_exit.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			mp2.start();
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		
		}
	});

}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==0){																	
		Bitmap bm = (Bitmap) data.getExtras().get("data");//saved picture in bm
		ImageView iv = (ImageView) findViewById(R.id.imageView);//use imageview to view picture
		iv.setImageBitmap(bm);
		}
	}
}

