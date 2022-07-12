package it.univpm.esameMetricsTweeter.stats;

import java.util.ArrayList;
import java.util.HashMap;

import it.univpm.esameMetricsTweeter.model.Tweet;



public class Stat {

	/**
	 * Classe delle statistiche (leggere la Readme per la lista completa)
	 * @param list Lista di cui calcolare le statistiche
	 * @return Elenco delle statistiche
	 */
	
	
	/**
	 * Classe delle statistiche (leggere la Readme per la lista completa)
	 * @param list Lista di cui calcolare le statistiche
	 * @return Elenco delle statistiche
	 */
	public static HashMap<String, Float> stats(ArrayList<Tweet> list) {
		int meanFavorite = 0;
		float minFavorite = list.get(0).getN_like();
		float maxFavorite = -1;
		int meanRetweet = 0;
		float minRetweet = list.get(0).getN_retweet();
		float maxRetweet = -1;
		float varianceLikes = 0;
		float varianceRetweets = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getN_like() > maxFavorite) {
				maxFavorite = list.get(i).getN_like();
			}
			if (list.get(i).getN_like() < minFavorite) {
				minFavorite = list.get(i).getN_like();
			}
			if (list.get(i).getN_retweet() > maxRetweet) {
				maxRetweet= list.get(i).getN_retweet();
			}
			if (list.get(i).getN_retweet() < minRetweet) {
				minRetweet = list.get(i).getN_retweet();
			}
			meanFavorite += list.get(i).getN_like();
			meanRetweet += list.get(i).getN_retweet();
		}
		meanFavorite = meanFavorite / list.size();
		meanRetweet = meanRetweet / list.size();
		
		// ciclo for variaza
		for (int i = 0; i < list.size(); i++) {
			varianceLikes += Math.pow(((float)list.get(i).getN_like() - meanFavorite), 2);
			varianceRetweets += Math.pow(((float)list.get(i).getN_retweet() - meanRetweet), 2);
		}
		varianceLikes = varianceLikes / list.size();
		varianceRetweets = varianceRetweets / list.size();
		
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
	
	
	
	
	
}
