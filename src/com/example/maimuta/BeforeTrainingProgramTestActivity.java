package com.example.maimuta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class BeforeTrainingProgramTestActivity extends Activity {
	
	// All static variables
    static final String URL = "http://api.androidhive.info/music/music.xml";
    // XML node keys
    static final String KEY_SONG = "song"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_TITLE = "title";
    static final String KEY_ARTIST = "artist";
    static final String KEY_DURATION = "duration";
    static final String KEY_THUMB_URL = "thumb_url";
	
	ListView listViewTrainingProgramParameters;
	LazyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_before_training_program_test);
		
		Log.d("info","cfffafas");
		
		listViewTrainingProgramParameters = (ListView)findViewById(R.id.listViewTrainingProgramParameters);
		
		final ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    	
        // looping through all song nodes &lt;song&gt;
        for (int i = 0; i < 5; i++) 
        {
            // creating new HashMap
        	HashMap<String, String> map = new HashMap<String, String>();
            //Element e = (Element) nl.item(i);
            // adding each child node to HashMap key =&gt; value
        	/*
            map.put(KEY_ID, parser.getValue(e, KEY_ID));
            map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE));
            map.put(KEY_ARTIST, parser.getValue(e, KEY_ARTIST));
            map.put(KEY_DURATION, parser.getValue(e, KEY_DURATION));
            map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));
            */

            map.put(KEY_TITLE, "Nom paramètre");
            map.put(KEY_DURATION, "Valeur paramètre");

            // adding HashList to ArrayList
            songsList.add(map);
        }
        
        // Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, songsList);
        listViewTrainingProgramParameters.setAdapter(adapter);
 
        // Click event for single list row
        listViewTrainingProgramParameters.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            	
            	TextView duration = (TextView)view.findViewById(R.id.duration); // duration
            	
            	duration.setText("Salut les gens j'ai changé lol");
            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.before_training_program_test, menu);
		return true;
	}

}
