package com.example.maimuta;

import java.util.Date;

// Objet Abstrait Trial (correspond � un essai de chaque t�che d'un test)
public abstract class Trial {
	
	/* CONSTANTES */
	
	// essai r�ussi
	public static int TRIAL_RESULT_SUCCESS = 1;
	
	// essai rat�
	public static int TRIAL_RESULT_FAILED = 2;
	
	// essai omis
	public static int TRIAL_RESULT_OMITED = 3;
	
	// essai abandonn�
	public static int TRIAL_RESULT_ABANDONED = 4;
	
	// essai � c�t�
	public static int TRIAL_RESULT_NEARBY = 5;
	
	// essai pr�coce
	public static int TRIAL_RESULT_PRECOCIOUS = 6;
	
	/* ATTRIBUTS */
	
	//  num�ro absolu de l'essai dans l'ordre de r�alisation selon la batterie de tests
	private int absoluteNumber;
	
	// nom du testeur
	private String testerName;
	
	// type de la t�che (entier)
	private int testType;
	
	// nom de la t�che
	private String testName;
	
	// r�sultat de la t�che
	private int trialResult;
	
	// date du lancement de la t�che
	private Date taskStartDate;
	
	// date de d�but de l'essai (il faudra ensuite juste l'heure de d�but)
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
