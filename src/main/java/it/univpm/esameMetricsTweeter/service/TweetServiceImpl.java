package it.univpm.esameMetricsTweeter.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import com.google.gson.JsonObject;

import it.univpm.esameMetricsTweeter.exception.EmptyListException;
import it.univpm.esameMetricsTweeter.model.Tweet;


         // Implementazione dell'interfaccia Service
 

@Service
public class TweetServiceImpl implements TweetServiceInt {

	     // ArrayList di Tweet che serve a memorizzare i Tweet

	private static ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	public ArrayList<Tweet> getTweet() throws EmptyListException {

		/** Eccezione nel caso in cui la lista sia vuota */
		if (tweetList.isEmpty())
			throw new EmptyListException("La lista è vuota!");

		return tweetList;
	}

	@Override
	public void addTweetsArray(Tweet[] tweetArray) {

		tweetList.clear();
		for (int i = 0; i < tweetArray.length; i++) {
		tweetList.add(tweetArray[i]);
		}
	}

	@Override
	public Tweet[] addJSON(String body) {

		JsonObject myObject = new Gson().fromJson(body, JsonObject.class);
		JsonArray array = myObject.getAsJsonArray("statuses");
		/**
		 * Se il tweet è un retweet, i dati vengono presi da retweeted_status altrimenti
		 * non sono verosimili, spesso sono 0, perchè Twitter salva il conteggio reale
		 * nel tweet originale
		 */
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getAsJsonObject().has("retweeted_status")) {
				JsonObject obj = new JsonObject();
				obj = array.get(i).getAsJsonObject();
				obj.addProperty("retweet_count", array.get(i).getAsJsonObject().get("retweeted_status")
						.getAsJsonObject().get("retweet_count").getAsBigInteger());
				obj.addProperty("favorite_count", array.get(i).getAsJsonObject().get("retweeted_status")
						.getAsJsonObject().get("favorite_count").getAsBigInteger());
				array.set(i, obj);
			}

		}
		Gson GoogleSon = new Gson();
		Tweet[] gsonArray = GoogleSon.fromJson(array, Tweet[].class);
		return gsonArray;
	}

	
	
	
	
	
	
}
