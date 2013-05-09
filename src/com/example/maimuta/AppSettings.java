package com.example.maimuta;

import android.app.Application;
import android.content.SharedPreferences;

public class AppSettings {
	
	// CONSTANTES
	
	public static final String MAIMUTA_PREFS_NAME = "MaimutaPrefs";
	
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
	
	public static String getString(String name)
	{
		Application _app = MaimutaApplication.getApp();
		SharedPreferences settings = _app.getSharedPreferences(MAIMUTA_PREFS_NAME, android.content.Context.MODE_PRIVATE);
		String result = settings.getString(name, "");
		return result;
	}

	public static void setString(String name, String value)
	{
		Application _app = MaimutaApplication.getApp();
		SharedPreferences settings = _app.getSharedPreferences(MAIMUTA_PREFS_NAME, android.content.Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putString(name, value);
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