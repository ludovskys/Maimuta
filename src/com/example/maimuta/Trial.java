package com.example.maimuta;

import java.util.Date;

// Objet Abstrait Trial (correspond à un essai de chaque tâche d'un test)
public abstract class Trial {
	
	/* CONSTANTES */
	
	// essai réussi
	public static int TRIAL_RESULT_SUCCESS = 1;
	
	// essai raté
	public static int TRIAL_RESULT_FAILED = 2;
	
	// essai omis
	public static int TRIAL_RESULT_OMITED = 3;
	
	// essai abandonné
	public static int TRIAL_RESULT_ABANDONED = 4;
	
	// essai à côté
	public static int TRIAL_RESULT_NEARBY = 5;
	
	// essai précoce
	public static int TRIAL_RESULT_PRECOCIOUS = 6;
	
	/* ATTRIBUTS */
	
	//  numéro absolu de l'essai dans l'ordre de réalisation selon la batterie de tests
	private int absoluteNumber;
	
	// nom du testeur
	private String testerName;
	
	// type de la tâche (entier)
	private int testType;
	
	// nom de la tâche
	private String testName;
	
	// résultat de la tâche
	private int trialResult;
	
	// date du lancement de la tâche
	private Date taskStartDate;
	
	// date de début de l'essai (il faudra ensuite juste l'heure de début)
	private Date trialStartDate;
	
	// date de fin de l'essai (il faudra ensuite juste l'heure de fin)
	private Date trialEndDate;
	
	/* GETTER AND SETTER */

	public int getAbsoluteNumber() {
		return absoluteNumber;
	}

	public void setAbsoluteNumber(int absoluteNumber) {
		this.absoluteNumber = absoluteNumber;
	}

	public String getTesterName() {
		return testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}

	public int getTestType() {
		return testType;
	}

	public void setTestType(int testType) {
		this.testType = testType;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTrialResult() {
		return trialResult;
	}

	public void setTrialResult(int trialResult) {
		this.trialResult = trialResult;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTrialStartDate() {
		return trialStartDate;
	}

	public void setTrialStartDate(Date trialStartDate) {
		this.trialStartDate = trialStartDate;
	}

	public Date getTrialEndDate() {
		return trialEndDate;
	}

	public void setTrialEndDate(Date trialEndDate) {
		this.trialEndDate = trialEndDate;
	}

}
