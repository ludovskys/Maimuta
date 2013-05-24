package com.example.maimuta;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class BeforeTrainingProgramTestActivity extends Activity {
	
	ListView listViewTrainingProgramParameters;
	LazyAdapter adapter;
	
	// Tableau qui contiendra les param�tres du TrainingProgram
	String[][] tabParameters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_before_training_program_test);
		
		tabParameters = Parameters.getTrainingProgramParameters();
		
		listViewTrainingProgramParameters = (ListView)findViewById(R.id.listViewTrainingProgramParameters);
		
		final ArrayList<HashMap<String, String>> parametersList = new ArrayList<HashMap<String, String>>();
    	
        // on boucle sur les diff�rents param�tres
        for (int i = 0; i < tabParameters.length; i++) 
        {
        	HashMap<String, String> map = new HashMap<String, String>();

            map.put(SystemUtils.KEY_PARAMETER_NAME, tabParameters[i][0]);
            map.put(SystemUtils.KEY_PARAMETER_VALUE, tabParameters[i][1]);
            map.put(SystemUtils.KEY_PARAMETER_TAG_1, tabParameters[i][2]);
            map.put(SystemUtils.KEY_PARAMETER_TAG_2, tabParameters[i][3]);

            // On remet les valeurs des param�tres � vide dans les fichiers de l'app
			AppSettings.setString(tabParameters[i][2], "");

            // on ajoute la hashlist dans la liste
            parametersList.add(map);
        }
        
        // Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, parametersList, SystemUtils.TRAINING_PROGRAM_TEST);
        listViewTrainingProgramParameters.setAdapter(adapter);
 
        // Lors d'un click sur un �l�ment de la liste
        listViewTrainingProgramParameters.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            	
            	// R�cup�ration des objets de la cellule s�lectionn�
            	final TextView parameterValue = (TextView)view.findViewById(R.id.textViewParameterValue);
            	final TextView parameterName = (TextView)view.findViewById(R.id.textViewParameterName);
            	
            	// Si le param�tre courant a besoin d'un champ de texte pour �tre �diter
            	if (parameterName.getTag(R.string.key_parameter_tag_2).toString().equalsIgnoreCase(Parameters.EDIT_TEXT_NUMBER))
            	{
            		// Affichage d'un champ de saisie
                	
                	AlertDialog.Builder alert = new AlertDialog.Builder(BeforeTrainingProgramTestActivity.this);

                	alert.setTitle("Veuillez renseigner une valeur");
                	alert.setMessage(parameterName.getText());

                	// Set an EditText view to get user input 
                	final EditText input = new EditText(BeforeTrainingProgramTestActivity.this);
                	input.setInputType(InputType.TYPE_CLASS_NUMBER);
                	alert.setView(input);

                	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
                	{
    	            	public void onClick(DialogInterface dialog, int whichButton) 
    	            	{
    	            		String value = input.getText().toString();
    	            		parameterValue.setText(value);
    	            		AppSettings.setString(parameterName.getTag(R.string.key_parameter_tag_1).toString(), value);
    	            	}
                	});

                	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() 
                	{
                		public void onClick(DialogInterface dialog, int whichButton) 
                		{
                			// Canceled.
                		}
                	});

                	alert.show();
            	}
            	else if (parameterName.getTag(R.string.key_parameter_tag_2).toString().equalsIgnoreCase(Parameters.EDIT_TEXT))
            	{
            		// Affichage d'un champ de saisie
                	
                	AlertDialog.Builder alert = new AlertDialog.Builder(BeforeTrainingProgramTestActivity.this);

                	alert.setTitle("Veuillez renseigner une valeur");
                	alert.setMessage(parameterName.getText());

                	// Set an EditText view to get user input 
                	final EditText input = new EditText(BeforeTrainingProgramTestActivity.this);
                	alert.setView(input);

                	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
                	{
    	            	public void onClick(DialogInterface dialog, int whichButton) 
    	            	{
    	            		String value = input.getText().toString();
    	            		parameterValue.setText(value);
    	            		AppSettings.setString(parameterName.getTag(R.string.key_parameter_tag_1).toString(), value);
    	            	}
                	});

                	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() 
                	{
                		public void onClick(DialogInterface dialog, int whichButton) 
                		{
                			// Canceled.
                		}
                	});

                	alert.show();
            	}
            	// Si le param�tre courant a plusieurs valeurs, on affiche ces valeurs dans une liste
            	else if (parameterName.getTag(R.string.key_parameter_tag_2).toString().equalsIgnoreCase(Parameters.LIST))
            	{
            		// R�cup�ration des valeurs des param�tres
            		final CharSequence[] items = Parameters.getParametersValues(
            				parameterName.getTag(R.string.key_parameter_tag_1).toString());

                	AlertDialog.Builder builder = new AlertDialog.Builder(BeforeTrainingProgramTestActivity.this);
                	builder.setTitle("Veuillez choisir un �l�ment");
                	builder.setItems(items, new DialogInterface.OnClickListener() 
                	{
                		// Lors du choix
                	    public void onClick(DialogInterface dialog, int item)
                	    {
                	    	String value = items[item].toString();
    	            		parameterValue.setText(value); 
    	            		AppSettings.setString(parameterName.getTag(R.string.key_parameter_tag_1).toString(), value);
                	    }
                	});
                	AlertDialog alert = builder.create();
                	alert.show();
            	}
            	
            	
            	
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.before_training_program_test, menu);
		
		menu.findItem(R.id.action_start).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
			
				// V�rifier que tous les param�tres ont �t� remplis
				
				boolean isAllParametersFilled = true;
				
				Intent intent = new Intent(BeforeTrainingProgramTestActivity.this, TrainingProgramTestActivity.class);
				
				// On boucle sur tous les param�tres dispos
				for (int i = 0; i < tabParameters.length; i++) 
				{					
					// Si un des param�tres n'est pas renseign�
					if (AppSettings.getString(tabParameters[i][2]).equalsIgnoreCase(""))
					{
						isAllParametersFilled = false;
						
						// Si un des param�tres manque, on casse la boucle
						break;
					}
					else
					{
						// Si le param�tre est renseign�, on l'ajoute � la prochaine activit� pour pouvoir ensuite le r�cup�r�
						
						intent.putExtra(tabParameters[i][2], AppSettings.getString(tabParameters[i][2]));
						
					}
				}
				
				// Si tous les param�tres sont ok
				if (isAllParametersFilled)
				{
					Log.d("info", "Ready for this shit");
					
					// go to the test activity
					startActivity(intent);
				}
				else
				{
					Log.d("info", "NOT READY for this shit");
					
					// On avertit l'utilisateur qu'il manque un ou plusieurs param�tres
					
					AlertDialog alertDialog = new AlertDialog.Builder(BeforeTrainingProgramTestActivity.this).create();
					
					alertDialog.setTitle(R.string.error);
					alertDialog.setMessage(getString(R.string.fill_input_text));
					
					alertDialog.setButton(RESULT_OK, "OK", new DialogInterface.OnClickListener() {
					      public void onClick(DialogInterface dialog, int which) {

					      }
					});
					
					// error
					alertDialog.show();
				}
				
				return false;
			}
		});
		
		return true;
	}

}
