package com.example.maimuta;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BeforeDMSorDNMSTestActivity extends Activity {
	
	// Permet de savoir si le type de test est DMS ou DNMS
	int testType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_before_dms_or_dnms_test);
		
		// R�cup�ration des infos envoy�s par la vue pr�c�dente (MainActivity)
		Bundle infos = getIntent().getExtras();
		
		// R�cup�ration du type de test
		testType = infos.getInt("testType", 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.before_dmsor_dnm, menu);
		return true;
	}

}
