package it.univpm.esameMetricsTweeter.service;

import java.util.ArrayList;



import it.univpm.esameMetricsTweeter.model.Tweet;

    /**
     * L'interfaccia del package Service
     */

    
public interface TweetServiceInt {

	/**
	 * Mi restituisce tutti i Tweet inseriti
	 *
	 * @return ArrayList dei Tweet
	 * @throws GetTweetException Caso lista vuota
	 */
	public abstract ArrayList<Tweet> getTweet() throws GetTweetException; 
	
	/**
	 * Memorizza l'array di Tweet passato, cancellando quelli già inseriti
	 *
	 * @param tweetArray Array di Tweet
	 */
	public abstract void addTweetsArray (Tweet[] tweetArray);
	
	/**
	 * Fa il parsing del JSON ritornando un array di Tweet
	 *
	 * @param body Stringa del JSON
	 * @return Array di Tweet
	 */
	public abstract Tweet[] addJSON (String body);
	
	
}
