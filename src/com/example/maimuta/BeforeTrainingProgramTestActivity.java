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
	
	// Tableau qui contiendra les paramètres du TrainingProgram
	String[][] tabParameters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_before_training_program_test);
		
		tabParameters = Parameters.getTrainingProgramParameters();
		
		listViewTrainingProgramParameters = (ListView)findViewById(R.id.listViewTrainingProgramParameters);
		
		final ArrayList<HashMap<String, String>> parametersList = new ArrayList<HashMap<String, String>>();
    	
        // on boucle sur les différents paramètres
        for (int i = 0; i < tabParameters.length; i++) 
        {
        	HashMap<String, String> map = new HashMap<String, String>();

            map.put(SystemUtils.KEY_PARAMETER_NAME, tabParameters[i][0]);
            map.put(SystemUtils.KEY_PARAMETER_VALUE, tabParameters[i][1]);
            map.put(SystemUtils.KEY_PARAMETER_TAG_1, tabParameters[i][2]);
            map.put(SystemUtils.KEY_PARAMETER_TAG_2, tabParameters[i][3]);

            // On remet les valeurs des paramètres à vide dans les fichiers de l'app
			AppSettings.setString(tabParameters[i][2], "");

            // on ajoute la hashlist dans la liste
            parametersList.add(map);
        }
        
        // Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, parametersList, SystemUtils.TRAINING_PROGRAM_TEST);
        listViewTrainingProgramParameters.setAdapter(adapter);
 
        // Lors d'un click sur un élément de la liste
        listViewTrainingProgramParameters.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            	
            	// Récupération des objets de la cellule sélectionné
            	final TextView parameterValue = (TextView)view.findViewById(R.id.textViewParameterValue);
            	final TextView parameterName = (TextView)view.findViewById(R.id.textViewParameterName);
            	
            	// Si le paramètre courant a besoin d'un champ de texte pour être éditer
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
            	// Si le paramètre courant a plusieurs valeurs, on affiche ces valeurs dans une liste
            	else if (parameterName.getTag(R.string.key_parameter_tag_2).toString().equalsIgnoreCase(Parameters.LIST))
            	{
            		// Récupération des valeurs des paramètres
            		final CharSequence[] items = Parameters.getParametersValues(
            				parameterName.getTag(R.string.key_parameter_tag_1).toString());

                	AlertDialog.Builder builder = new AlertDialog.Builder(BeforeTrainingProgramTestActivity.this);
                	builder.setTitle("Veuillez choisir un élément");
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
			
				// Vérifier que tous les paramètres ont été remplis
				
				boolean isAllParametersFilled = true;
				
				Intent intent = new Intent(BeforeTrainingProgramTestActivity.this, TrainingProgramTestActivity.class);
				
				// On boucle sur tous les paramètres dispos
				for (int i = 0; i < tabParameters.length; i++) 
				{					
					// Si un des paramètres n'est pas renseigné
					if (AppSettings.getString(tabParameters[i][2]).equalsIgnoreCase(""))
					{
						isAllParametersFilled = false;
						
						// Si un des paramètres manque, on casse la boucle
						break;
					}
					else
					{
						// Si le paramètre est renseigné, on l'ajoute à la prochaine activité pour pouvoir ensuite le récupéré
						
						intent.putExtra(tabParameters[i][2], AppSettings.getString(tabParameters[i][2]));
						
					}
				}
				
				// Si tous les paramètres sont ok
				if (isAllParametersFilled)
				{
					Log.d("info", "Ready for this shit");
					
					// go to the test activity
					startActivity(intent);
				}
				else
				{
					Log.d("info", "NOT READY for this shit");
					
					// On avertit l'utilisateur qu'il manque un ou plusieurs paramètres
					
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
