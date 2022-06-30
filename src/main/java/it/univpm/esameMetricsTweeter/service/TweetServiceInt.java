package it.univpm.esameMetricsTweeter.service;

import java.util.ArrayList;

import it.univpm.esameMetricsTweeter.model.Tweet;

/**
 * L'interfaccia del package Service
 */

public interface TweetServiceInt {

	
	/**
	 * Restituisce tutti i Tweet inseriti
	 *
	 * @return ArrayList dei Tweet
	 * 
	 */
	public abstract ArrayList<Tweet> getTweet() ; 
	
	
	
	
	
}
