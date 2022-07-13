package it.univpm.esameMetricsTweeter.controller;



import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.esameMetricsTweeter.exception.WrongFilterStatsException;
import it.univpm.esameMetricsTweeter.model.MetaData;
import it.univpm.esameMetricsTweeter.model.Tweet;
import it.univpm.esameMetricsTweeter.service.TweetServiceInt;






@RestController

public class GeneralController {

	// public static final String url="https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/retweets_of_me.json";
	
	/**
	 * Inizializzazione Service that provides all the request
	 */
	@Autowired
	 private TweetServiceInt tSI;
	
	
    /**
     * The root that shows all the Tweets
     * @return An ArrayList of tweets that contains all the data
     * @throws org.json.simple.parser.ParseException
     * @throws ParseException
     * @throws IOException
     */
    @GetMapping("/GetTweets")
    public     ArrayList<Tweet> getTweets() throws org.json.simple.parser.ParseException, ParseException, IOException{
        return new ArrayList<Tweet>(tSI.getAllTweets());
    }
    /**
     * The root that shows the MetaData
     * @return An ArrayList of Metadata
     * @throws org.json.simple.parser.ParseException
     * @throws ParseException
     * @throws IOException
     */
    @GetMapping("/GetMetaData")
    public     ArrayList<MetaData> getMetadata() throws org.json.simple.parser.ParseException, ParseException, IOException{
        return new ArrayList<MetaData>(tSI.recordMetadata());
    }
	
	
    /**
	 * richiesta POST "/tweet/stats"
	 *
	 * @param body Stringa contenente il tipo di statistica
	 * @return ritorna solo le foto degli album che soddisfano le i parametri dei
	 *         filtri
	 * @throws MalformedURLException     eccezione di errata scrittura dell'url
	 * @throws IOException               classe base per le eccezioni generate
	 *                                   durante l'accesso a informazioni tramite
	 *                                   flussi, file e directory.
	 * @throws ParseException            eccezione che parte se il processo di
	 *                                   parsing è errato
	 * @throws WrongFilterStatsException Eccezione che parte se il tipo di filtro
	 *                                   filtro o il tipo di statistica non è
	 *                                   corretto
	 */
	@PostMapping("/tweet/stats")
	public ResponseEntity<Object> statsTweet(@RequestBody String body)
			throws  IOException, ParseException, WrongFilterStatsException {

		return new ResponseEntity<>(tSI.statsService(body), HttpStatus.OK);
	}

	
}
