package com.example.maimuta;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;

public class SystemUtils {
	
	public static int NUMBER_MAX_TRIALS_MODE = 1;
	public static int MAX_TIME_MODE = 2;
	
	public static int DMS_TEST = 3;
	public static int TRAINING_PROGRAM_TEST = 4;
	public static int DNMS_TEST = 8;
	
	public static int STATE_PAUSE = 5;
	public static int STATE_PLAY = 6;
	public static int STATE_FINISH = 7;
	
	public static final String PREFS_TEST = "FILETEST";
	
	// r�cup�ration de la hauteur de l'�cran de l'appareil courant
	public static int getScreenHeight(Activity act)
	{
		DisplayMetrics displaymetrics = new DisplayMetrics();
		act.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int screenHeight = displaymetrics.heightPixels;
		
		return screenHeight;
	}
	
	// r�cup�ration de la largeur de l'�cran de l'appareil courant
	public static int getScreenWidth(Activity act)
	{
		DisplayMetrics displaymetrics = new DisplayMetrics();
		act.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int screenWidth = displaymetrics.widthPixels;
		
		return screenWidth;
	}
	
	// permet de savoir si l'on dispose d'une connexion Internet active ou non
	public static boolean isOnline(Activity act)
	{
	    ConnectivityManager cm =
	        (ConnectivityManager) act.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    
	    if (netInfo != null && netInfo.isConnected()) 
	    {
	        return true;
	    }
	    
	    return false;
	}


}

