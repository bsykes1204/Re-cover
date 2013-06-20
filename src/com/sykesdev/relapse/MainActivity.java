package com.sykesdev.relapse;

import java.util.Locale;
import android.app.ActionBar;
import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {

	
	Button b1, b2, b3, b4;
	int request_Code = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		b1 = (Button) findViewById(R.id.button_sponsor);
		b1.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) {
				Intent i = new Intent(Intent.ACTION_DIAL);
				i.setData(Uri.parse("tel:+8005555555"));
				startActivity(i);
			}
		});
		
		b2 = (Button) findViewById(R.id.button_cab);
		b2.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) {
				Intent i = new Intent(Intent.ACTION_DIAL);
				i.setData(Uri.fromParts("tel", "#8924", "#"));
				startActivity(i);
			}
		});
		
		b3 = (Button) findViewById(R.id.button_meeting);
		b3.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("http://meetings.intherooms.com/#"));
				startActivity(i);
			}
		});
		
		
		b4 = (Button) findViewById(R.id.button_meeting);
		b4.setOnClickListener(new OnClickListener()
		{
			public void onClick(View arg0) {
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("http://meetings.intherooms.com/#"));
				startActivity(i);
			}
		});
		
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if (requestCode == request_Code)
		{
			if (resultCode == RESULT_OK)
			{
				Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
				Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(data.getData().toString()));
				startActivity(i);
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
