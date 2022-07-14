package it.univpm.esameMetricsTweeter.service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import it.univpm.esameMetricsTweeter.exception.WrongFilterException;
import it.univpm.esameMetricsTweeter.filters.Filtri;
import it.univpm.esameMetricsTweeter.model.MetaData;
import it.univpm.esameMetricsTweeter.model.Tweet;

@Service
public class TweetServiceImpl implements TweetServiceInt {

	/**
	 * The application dataPool
	 */
	public ArrayList<Tweet> dataBase = new ArrayList<>();

	/**
	 * Costructor
	 * 
	 * @throws ParseException
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	public TweetServiceImpl() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException {
		dataBase = jsonData.jsonTweets();
	}

	/**
	 * Metadata Visualizzation method
	 * 
	 * @return An ArrayList of metadata
	 */

	@Override
	public ArrayList<MetaData> recordMetadata() {
		return metadata.getMetadata();
	}

	/**
	 * The function that shows all the Tweets
	 * 
	 * @return An ArrayList of Tweets
	 * @throws ParseException
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */

	@Override
	public ArrayList<Tweet> getAllTweets()
			throws ParseException, org.apache.tomcat.util.json.ParseException, IOException {
		return jsonData.jsonTweets();
	}

	/**
	 * IL metodo fa il parsing del JSON dei filtri e il filed "data" serve per fare
	 * statistiche su tutti i dati in modo da poter usare esattamente questa
	 * funzione ( base)anche per le statistiche del progetto.
	 */
	@Override
	public ArrayList<Tweet> getTweetsFilter(String body, ArrayList<Tweet> dataBase)
			throws ParseException, WrongFilterException {

		JsonObject gson = new Gson().fromJson(body, JsonObject.class);
		String filterFiled = gson.get("filter_field").getAsString();
		String filterType = gson.get("filter_type").getAsString();
		JsonElement param = gson.get("parameters");

		ArrayList<Tweet> listaFiltrata = new ArrayList<Tweet>();

		/**
		 * Eccezione che parte dal momento in cui i filtri inseriti non sono corretti
		 */
		if (!filterFiled.equals("likes") && !filterFiled.equals("retweets") && !filterFiled.equals("time")
				&& !filterFiled.equals("data"))
			throw new WrongFilterException("Il filtro inserito non è corretto!");

		if (filterFiled.equals("likes")) {
			listaFiltrata = Filtri.filterByLikes(dataBase, filterType, param);
		}
		
		
		if (filterFiled.equals("retweets")) {
			listaFiltrata = Filtri.filterByRetweet(dataBase, filterType, param);
		}
		
		
		if (filterFiled.equals("time")) {
			try {
				listaFiltrata = Filtri.filterByTime(dataBase, filterType, param);
			} catch (java.text.ParseException | WrongFilterException e) {

				e.printStackTrace();
			}
		}
		// serve per richiedere le statistiche su tutti i dati
		if (filterFiled.equals("statTwitt")) {
			listaFiltrata = dataBase;
		}
		return listaFiltrata;
	}

}
