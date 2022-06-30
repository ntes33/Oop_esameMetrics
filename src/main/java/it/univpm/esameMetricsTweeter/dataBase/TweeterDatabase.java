package it.univpm.esameMetricsTweeter.dataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

    /*Classe che ci permette di scaricare i dati contenuti nel 'API 
     * di tweeter e di fare il parsing
     * 
     * 
     * Acces token git     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
     */

public class TweeterDatabase {

	/**
	 * Richiesta HTTP per i dati da tweeter.
	 *
	 * @param tweeturl Viene passato come pametro una stringa contenente l'url.
	 * @return stringa vuota se tutto è andato a buon fine .
	 */
	public String downloadDatiFromTweeter(String tweeturl) {

		String response = "";

		try {

			URL url = new URL(tweeturl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = read.readLine();

			response = line;

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}

		return response;

	}

}
