package com.pc.saxparsing;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SaxParsingActivity extends Activity {

	ListView mListView;

	Button btn;

	List <ScoreInfo> info = null;

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sax_parsing);
		mListView = (ListView) findViewById(R.id.listView);
		btn = (Button) findViewById(R.id.button);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick (View v) {
				try {
					info = SAXXMLParser.parse(getAssets().open("scoreinfo.xml"));
					System.out.println("info size...."+info.size());
					ArrayAdapter <ScoreInfo> adapter = new ArrayAdapter <ScoreInfo>(SaxParsingActivity.this, R.layout.list_item, info);
					mListView.setAdapter(adapter);
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu (Menu menu) {
		getMenuInflater().inflate(R.menu.activity_sax_parsing, menu);
		return true;
	}
}
