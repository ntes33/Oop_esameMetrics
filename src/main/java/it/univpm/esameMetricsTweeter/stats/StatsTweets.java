package it.univpm.esameMetricsTweeter.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.esameMetricsTweeter.model.Tweet;

   /**
    * Classe delle statistiche 
    * @param list Lista di cui calcolare le statistiche
    * @return Elenco delle statistiche
    */

public class StatsTweets {

	
	
	// Metodo che genera le statistiche generali
	
	public static HashMap<String, Float> stats(ArrayList<Tweet>dataBase ) {
		int meanFavorite = 0;
		float minFavorite = dataBase.get(0).getN_like();
		float maxFavorite = -1;
		int meanRetweet = 0;
		float minRetweet = dataBase.get(0).getN_retweet();
		float maxRetweet = -1;
		float varianceLikes = 0;
		float varianceRetweets = 0;

		for (int i = 0; i < dataBase.size(); i++) {
			if (dataBase.get(i).getN_like() > maxFavorite) {
				maxFavorite = dataBase.get(i).getN_like();
			}
			if (dataBase.get(i).getN_like() < minFavorite) {
				minFavorite = dataBase.get(i).getN_like();
			}
			if (dataBase.get(i).getN_retweet() > maxRetweet) {
				maxRetweet= dataBase.get(i).getN_retweet();
			}
			if (dataBase.get(i).getN_retweet() < minRetweet) {
				minRetweet = dataBase.get(i).getN_retweet();
			}
			meanFavorite += dataBase.get(i).getN_like();
			meanRetweet += dataBase.get(i).getN_retweet();
		}
		meanFavorite = meanFavorite / dataBase.size();
		meanRetweet = meanRetweet / dataBase.size();
		
		// ciclo per la variaza
		for (int i = 0; i < dataBase.size(); i++) {
			varianceLikes += Math.pow(((float)dataBase.get(i).getN_like() - meanFavorite), 2);
			varianceRetweets += Math.pow(((float)dataBase.get(i).getN_retweet() - meanRetweet), 2);
		}
		varianceLikes = varianceLikes / dataBase.size();
		varianceRetweets = varianceRetweets / dataBase.size();
		
		float standardDeviationLikes = (float) Math.sqrt(varianceLikes);
		float standardDeviationRetweets = (float) Math.sqrt(varianceRetweets);
		
		HashMap<String, Float> statMap = new HashMap<String, Float>();
		statMap.put("Media dei Likes", (float)meanFavorite);
		statMap.put("Minimo dei Likes", minFavorite);
		statMap.put("Massimo dei Likes", maxFavorite);
		statMap.put("Media dei Retweets", (float) meanRetweet);
		statMap.put("Minimo dei Retweets", minRetweet);
		statMap.put("Massimo dei Retweets", maxRetweet);
		statMap.put("Varianza dei Likes", varianceLikes);
		statMap.put("Varianza dei Retweets", varianceRetweets);
		statMap.put("Deviazione Standard dei Likes", standardDeviationLikes);
		statMap.put("Deviazione Standard dei Retweets", standardDeviationRetweets);
		
		return statMap;		
		
	}
	
	
	
	
	/**
	 * Statistiche in base alle dimensione in kilobyte
	 *
	 * @param myfblist prende come parametro la lista di album
	 * @return ritorna la linked hash map contenente le statistiche temporali
	
	 *
	 */
	
	/*
	public static HashMap<String, Float> statstemp(ArrayList<Tweet> dataBase) {

		HashMap<String, Float> statMap = new HashMap<String, Float>();

		for (int i = 0; i < dataBase.size(); i++) {

			ArrayList<Integer> anni = new ArrayList<Integer>();
			ArrayList<Integer> mesi = new ArrayList<Integer>();
			ArrayList<Integer> giorni = new ArrayList<Integer>();
			
			for (int j = 0; j < dataBase.get(i).getData().size(); j++) {
                
				String dati = dataBase.get(i).getData().get(j).getCreated_at();
				int anno = Integer.parseInt(dati.substring(6));
				int mese = Integer.parseInt(dati.substring(3, 5));
				int giorno = Integer.parseInt(dati.substring(0, 2));
				anni.add(anno);
				mesi.add(mese);
				giorni.add(giorno);
			}

			int[] cadenzamesi = new int[12];
			for (int k = 0; k < mesi.size(); k++) {
				cadenzamesi[(mesi.get(k)) - 1]++;
			}

			int[] cadenzagiorni = new int[31];
			for (int k = 0; k < giorni.size(); k++) {
				cadenzagiorni[(giorni.get(k)) - 1]++;
			}

			int minAnno = anni.get(0);
			int minMese = mesi.get(0);
			int minGiorno = giorni.get(0);
			int maxAnno = 0;
			int maxMese = 0;
			int maxGiorno = 0;

			for (int j = 0; j < anni.size(); j++) {
				if (anni.get(j) < minAnno) {
					minAnno = anni.get(j);
					minMese = mesi.get(j);
					minGiorno = giorni.get(j);
				}
				if (anni.get(j) > maxAnno) {
					maxAnno = anni.get(j);
					maxMese = mesi.get(j);
					maxGiorno = giorni.get(j);
				}
				if (anni.get(j) == minAnno) {

					if (mesi.get(j) < minMese) {
						minMese = mesi.get(j);
						minGiorno = giorni.get(j);
					}
					if (mesi.get(j) == minMese) {
						if (giorni.get(j) <= minGiorno)
							minGiorno = giorni.get(j);
					}

				}

				if (anni.get(j) == maxAnno) {

					if (mesi.get(j) > maxMese) {
						maxMese = mesi.get(j);
						maxGiorno = giorni.get(j);
					}
					if (mesi.get(j) == maxMese) {
						if (giorni.get(j) >= maxGiorno)
							maxGiorno = giorni.get(j);
					}

				}

			}

			statMap.put("(ALBUM N." + (i + 1) + ")" + " Data foto più vecchia",
					minGiorno + "-" + minMese + "-" + minAnno);
			statMap.put("(ALBUM N." + (i + 1) + ")" + " Data foto più recente",
					maxGiorno + "-" + maxMese + "-" + maxAnno);

			for (int k = 0; k < cadenzamesi.length; k++) {
				if (cadenzamesi[k] != 0)
					statMap.put("(ALBUM N." + (i + 1) + ")" + " Cadenza foto nel mese numero " + (k + 1),
							cadenzamesi[k] + "");
			}

			for (int k = 0; k < cadenzagiorni.length; k++) {
				if (cadenzagiorni[k] != 0)
					statMap.put("(ALBUM N." + (i + 1) + ")" + " Cadenza foto nel giorno numero " + (k + 1),
							cadenzagiorni[k] + "");
			}

		}
		return statMap;
	}
	
	*/
	
	
	
	
	
	
	
	
}
