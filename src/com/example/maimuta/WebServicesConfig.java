package com.example.maimuta;

public class WebServicesConfig {

	// TYPES DE CONFIGURATIONS POSSIBLES
	static final String CONFIG_LOCAL_LUDO   = "LOCAL_LUDO";
	static final String CONFIG_LOCAL_ANTOINE   = "LOCAL_ANTOINE";

	// VARIABLE QUI DETERMINE LA CONFIGURATION
	static final String CONFIG = CONFIG_LOCAL_LUDO;
	
	// VALEURS POSSIBLES POUR LA BDD
	/*
    private static final String PROD_DATABASE_NAME  = "MaimutaDatabase";
    private static final String BETA_DATABASE_NAME  = "MaimutaDatabase-BETA";
    private static final String LOCAL_DATABASE_NAME = "MaimutaDatabase-PROD";
    */

    // VALEUR DE CONFIG
    static String DATABASE_NAME = "";

    // VARIABLES DE CONFIGURATION
	
	static String WEBSERVICES_URL = "";
	
	// VALEURS DONNEES EN FONCTION

	public static void init()
	{
		// LOCAL LUDO
		if(CONFIG == CONFIG_LOCAL_LUDO)
		{
			// LUDO
			WEBSERVICES_URL = "https://pipit.u-strasbg.fr/~smoczynski/LPCDED/Maimuta/post.php";
			//DATABASE_NAME   = LOCAL_DATABASE_NAME;
		}
		
		// LOCAL ANTOINE
		if(CONFIG == CONFIG_LOCAL_ANTOINE)
		{
			// ANTOINE
			WEBSERVICES_URL = "https://pipit.u-strasbg.fr/~oblinger/Acrobatt/Interface_client/post.php";
			//DATABASE_NAME   = LOCAL_DATABASE_NAME;
		}
	}
}
