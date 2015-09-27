package com.adskom.sample;

import com.adskom.sdk.Adskom;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	Button button;
	TextView link;	
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		addListenerOnButton();
		addListenerOnLink();		
	}

	public void addListenerOnLink() {
		link = (TextView) findViewById(R.id.txtTrack);				
		link.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View args) {
				track("Link");
			}

		});

	}
	
	public void addListenerOnButton() {
		button = (Button) findViewById(R.id.btnTrack);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View args) {
				track("Button");
			}

		});

	}
	
	private void track(String from){
		String result = Adskom.track(123, "view ad");
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context).
				setTitle(from).setMessage(result).setPositiveButton("Ok",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					}
				});
		alertDialogBuilder.create().show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
