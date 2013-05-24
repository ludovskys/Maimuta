package com.example.maimuta;

public class Parameters {
	
	/* GLOBAL */
	public static String TASK_NAME = "TaskName";
	
	/* TRAINING PROGRAM */
	public static String VISUAL_STIMULI_FORM = "VisualStimuliForm";
	public static String VISUAL_STIMULI_COLOR = "VisualStimuliColor";
	public static String ACTION_WHEN_FAILED = "ActionWhenFailed";
	public static String DELAY_BETWEEN_FIGURES = "DelayBetweenFigures";
	public static String DELAY_MAXIMUM_ALLOWED = "DelayMaximumAllowed";
	
	public static String LIST = "list";
	public static String EDIT_TEXT_NUMBER = "editTextNumber";
	public static String EDIT_TEXT = "editText";
	
	// Fonction qui renvoie un tableau de paramètres pour un test de type TrainingProgram
	public static String[][] getTrainingProgramParameters()
	{
		String res[][] = {
				{ "Nom de la tâche", "", TASK_NAME, EDIT_TEXT },
				{ "Forme du stimuli visuel", "", VISUAL_STIMULI_FORM, LIST },
				{ "Couleur du stimuli visuel", "", VISUAL_STIMULI_COLOR, LIST },
				{ "Action si mauvaise réponse", "", ACTION_WHEN_FAILED, LIST },
				{ "Temps entre cibles (en ms)", "", DELAY_BETWEEN_FIGURES, EDIT_TEXT_NUMBER },
				{ "Temps de réponse max autorisé (en ms)", "", DELAY_MAXIMUM_ALLOWED, EDIT_TEXT_NUMBER }
		};
		
		return res;
	}
	
	// Fonction qui renvoie un tableau de paramètres pour un test de type TrainingProgram
	public static String[][] getDMSParameters()
	{
		// TODO
		String res[][] = {
				{ "Temps entre cibles (en ms)", "", DELAY_BETWEEN_FIGURES, EDIT_TEXT_NUMBER },
				{ "Temps de réponse max autorisé (en ms)", "", DELAY_MAXIMUM_ALLOWED, EDIT_TEXT_NUMBER }
		};
		
		return res;
	}
	
	// Retoure un tableau contenant les différentes valeurs d'un paramètre
	public static CharSequence[] getParametersValues(String param)
	{
		CharSequence[] res = new CharSequence[10];
		
		// Si le paramètre courant est la forme du stimuli visuel
		if (param.equalsIgnoreCase(VISUAL_STIMULI_FORM))
		{
			res = new CharSequence[2];
			res[0] = "Cercle";
			res[1] = "Carré";
		}
		// couleur du stimuli
		else if (param.equalsIgnoreCase(VISUAL_STIMULI_COLOR))
		{
			res = new CharSequence[3];
			res[0] = "Rouge";
			res[1] = "Bleu";
			res[2] = "Vert";
		}
		// Action à effectuer en cas d'erreur
		else if (param.equalsIgnoreCase(ACTION_WHEN_FAILED))
		{
			res = new CharSequence[2];
			res[0] = "Pas de réaction";
			res[1] = "Mauvaise réponse (fin du test)";
		}
		
		return res;
	}
	
	public static int getStimuliValueForm(String value)
	{
		int res = 0;
		
		if (value.equalsIgnoreCase("Cercle"))
		{
			res = SystemUtils.STIMULI_FORM_ROUND;
		}
		else if (value.equalsIgnoreCase("Carré"))
		{
			res = SystemUtils.STIMULI_FORM_SQUARE;
		}
		
		return res;
	}
	

}
