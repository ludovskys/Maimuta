package com.example.maimuta;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	// Options du menu
	private static int CONTEXT_MENU_CHOOSE_TYPE_CHOICE_TRAINING_PROGRAM = 1;
	private static int CONTEXT_MENU_CHOOSE_TYPE_CHOICE_DMS = 2;
	private static int CONTEXT_MENU_CHOOSE_TYPE_CHOICE_DNMS = 3;
	
	Button buttonStartTest;
	EditText editTextName;
	
	// Fenêtre de dialogue
	AlertDialog alertDialogNameMissing;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Titre et sous-titre de l'action bar
		ActionBar actionBar = getActionBar();
		actionBar.setSubtitle(R.string.action_bar_subtitle);
		actionBar.setTitle(R.string.action_bar_title);
		
		// Initialisations des objets de la vue
		editTextName = (EditText)findViewById(R.id.editTextName);
		buttonStartTest = (Button)findViewById(R.id.buttonStartTest);
		
		alertDialogNameMissing = new AlertDialog.Builder(this).create();
		
		// Au clique sur ce bouton, on associe un menu contextuel
		registerForContextMenu(buttonStartTest);
		
		// Ecouteur du bouton
		buttonStartTest.setOnClickListener(new OnClickListener(){

			@Override 
			public void onClick(View v) {
				// On vérifie qu'un pseudo a bien été donné
				if (editTextName.getText().toString().equalsIgnoreCase(""))
				{		
					// Si ce n'est pas le cas, on affiche une fenêtre d'erreur
					alertDialogNameMissing.setTitle(R.string.error);
					alertDialogNameMissing.setMessage(getString(R.string.fill_name));
					
					alertDialogNameMissing.setButton(RESULT_OK, "OK", new DialogInterface.OnClickListener() {
					      public void onClick(DialogInterface dialog, int which) {

					      }
					});
					
					alertDialogNameMissing.show();
				}
				else
				{
					// On ouvre le menu contextuel
					openContextMenu(v);
				}
			}
			
		});
	}
	
	// Appelé lorsque l'activité s'affiche
	@Override
	protected void onResume()
	{
		super.onResume();
		
		// S'il y a des données a envoyé ET qu'on est connecté à Internet
        if (AppSettings.getBoolean("dataToSend") && SystemUtils.isOnline(this))
        {
        	sendWaitingDatas();
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override  
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) 
	{  
		super.onCreateContextMenu(menu, v, menuInfo);  
		menu.setHeaderTitle(R.string.context_menu_choose_type);  
		menu.add(0, CONTEXT_MENU_CHOOSE_TYPE_CHOICE_TRAINING_PROGRAM, 0, R.string.context_menu_choose_type_choice_training_program);  
		menu.add(0, CONTEXT_MENU_CHOOSE_TYPE_CHOICE_DMS, 0, R.string.context_menu_choose_type_choice_dms);  
		menu.add(0, CONTEXT_MENU_CHOOSE_TYPE_CHOICE_DNMS, 0, R.string.context_menu_choose_type_choice_dnms); 
	} 
	
	// Appelé lors du choix dans le menu
	@Override  
	public boolean onContextItemSelected(MenuItem item) 
	{  
		boolean res = false;
		// Si un pseudo a bien été donné
		if (!editTextName.getText().toString().equalsIgnoreCase(""))
		{			
			AppSettings.setString("userName", editTextName.getText().toString());
			
			if(item.getItemId() == CONTEXT_MENU_CHOOSE_TYPE_CHOICE_TRAINING_PROGRAM)
			{
				// training program
			}
			else if(item.getItemId() == CONTEXT_MENU_CHOOSE_TYPE_CHOICE_DMS)
			{
				// dms
			}
			else if(item.getItemId() == CONTEXT_MENU_CHOOSE_TYPE_CHOICE_DNMS)
			{
				// dnms
			}
			else 
			{
				res = false;
			}
		}
		else
		{	
			res = false;
		}

		return res; 
	}
	
	// Fonction qui traîte l'envoi des données
	public void sendWaitingDatas()
	{
		/*
		ProcessExecuterModule processExecuterModule = new ProcessExecuterModule();
		
		String sendResultByEmail = (settings.getBoolean("sendResultByEmail", false)) ? "0" : "1";
		
		int numberOfWaitingDatas = settings.getInt("numberOfWaitingDatas", 0);
		
		while (numberOfWaitingDatas > 0)
		{
			processExecuterModule.runSendTestData(MainActivity.this,settings.getString("fileTitle"+numberOfWaitingDatas, ""),
					settings.getString("testData"+numberOfWaitingDatas, ""),sendResultByEmail,
					settings.getString("fileTitle2"+numberOfWaitingDatas, ""), settings.getString("xmlResults"+numberOfWaitingDatas, ""));
			
			numberOfWaitingDatas--; 
		}
		
		editor.putInt("numberOfWaitingDatas", 0);
		editor.putBoolean("dataToSend", false);
		
		editor.commit(); 
		*/ 
	} 

}
