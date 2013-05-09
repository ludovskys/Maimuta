package com.example.maimuta;

import android.app.Application;
import android.content.SharedPreferences;

public class AppSettings {
	
	// CONSTANTES
	
	public static final String MAIMUTA_PREFS_NAME = "MaimutaPrefs";

	// VALEURS POSSIBLES POUR LES PREFERENCES

	public static final int STATUS_UNLOGGED      = 0;
	public static final int STATUS_GUEST         = 1;
	public static final int STATUS_MEMBER_LOGGED = 2;
	
	// METHODES
	
	public static boolean getBoolean(String name)
	{
		Application _app = MaimutaApplication.getApp();
		SharedPreferences settings = _app.getSharedPreferences(MAIMUTA_PREFS_NAME, android.content.Context.MODE_PRIVATE);
		boolean result = settings.getBoolean(name, false);
		return result;
	}

	public static void setBoolean(String name, boolean value)
	{
		Application _app = MaimutaApplication.getApp();
		SharedPreferences settings = _app.getSharedPreferences(MAIMUTA_PREFS_NAME, android.content.Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putBoolean(name, value);
	    editor.commit();
	}

	public static int getInt(String name)
	{
		Application _app = MaimutaApplication.getApp();
		SharedPreferences settings = _app.getSharedPreferences(MAIMUTA_PREFS_NAME, android.content.Context.MODE_PRIVATE);
		int result = settings.getInt(name, 0);
		return result;
	}

	public static void setInt(String name, int value)
	{
		Application _app = MaimutaApplication.getApp();
		SharedPreferences settings = _app.getSharedPreferences(MAIMUTA_PREFS_NAME, android.content.Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt(name, value);
	    editor.commit();
	}
}