package com.example.maimuta;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class TrainingProgramTestActivity extends Activity {
	
	/* CONSTANTES */
	
	// pas d'action si mauvaise réponse
	public static int ACTION_BAD_ANSWER_NO = 1;
	
	// action échoué si mauvaise réponse
	public static int ACTION_BAD_ANSWER_TRAIL_FAILED = 2;
	
	
	/* ATTRIBUTS */
	
	CustomDrawableViewTrainingProgram customDrawableViewTrainingProgram;
	
	Chronometer chronometer;
	
	RelativeLayout relativeLayout;
	
	/* attributs correspondants aux paramètres passées */
	
	String taskName;
	
	int stimuliForm;
	
	int stimuliColor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_training_program_test);
				
		/* Récupération des paramètres du test Training Program */

		
		
	}

}

