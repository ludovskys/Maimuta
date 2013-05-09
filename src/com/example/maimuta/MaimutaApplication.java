package com.example.maimuta;

import android.app.Application;
import android.util.Log;

public class MaimutaApplication extends Application {

	static Application _app;
	
	static public Application getApp()
	{
		return _app;
	}
	
	@Override
	public void onCreate()
	{
		// On initialise la config
		WebServicesConfig.init();
		
		// On stocke le pointer de l'app global
		_app = this;
	}
}
