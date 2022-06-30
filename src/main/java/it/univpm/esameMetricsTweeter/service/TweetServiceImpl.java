package it.univpm.esameMetricsTweeter.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.univpm.esameMetricsTweeter.model.Tweet;

   /**
    * Implementazione dell'interfaccia Service
    * 
    */

    @Service
public class TweetServiceImpl  implements TweetServiceInt {

	
	
	//ArrayList di Tweet che serve a memorizzare i Tweet 
	
	private static ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	
	
	@Override
	public ArrayList<Tweet> getTweet()  {
		
		/**Eccezione nel caso in cui la lista sia vuota*/
		if (tweetList.isEmpty())
			

		
		return tweetList;
		return null;
		
	}
	
	
	
	
	
	
	
}
