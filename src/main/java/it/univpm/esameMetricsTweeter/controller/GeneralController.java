package it.univpm.esameMetricsTweeter.controller;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.esameMetricsTweeter.exception.EmptyListException;
import it.univpm.esameMetricsTweeter.exception.WrongFilterException;
import it.univpm.esameMetricsTweeter.model.MetaData;
import it.univpm.esameMetricsTweeter.model.Tweet;
import it.univpm.esameMetricsTweeter.service.TweetServiceInt;
import it.univpm.esameMetricsTweeter.stats.StatsTweets;



// Controllore dell'applicazione

@RestController
public class GeneralController {

	/**
	 * Inizializzazione Service 
	 */
	@Autowired
	private TweetServiceInt tSI;

	/**
	 * per avere tutti i twitt
	 * 
	 * @return An ArrayList of tweets that contains all the data
	 * @throws org.json.simple.parser.ParseException
	 * @throws ParseException
	 * @throws IOException
	 * @throws EmptyListException  Caso in cui la lista  dataPool è vuota
	 */
	@GetMapping("/GetTweets")
	public ArrayList<Tweet> getTweets() throws org.json.simple.parser.ParseException, ParseException, IOException, EmptyListException {
		return new ArrayList<Tweet>(tSI.getAllTweets());
	}

	/**
	 * per avere la  MetaData
	 * 
	 * @return Un ArrayList di Metadata
	 * @throws org.json.simple.parser.ParseException
	 * @throws ParseException
	 * @throws IOException
	 */
	@GetMapping("/GetMetaData")
	public ArrayList<MetaData> getMetadata() throws org.json.simple.parser.ParseException, ParseException, IOException {
		return new ArrayList<MetaData>(tSI.recordMetadata());
	}

	
	/**
	 * Statistiche dei dati richiesti dal JSON inserito nel body (scritto come i
	 * Filtri)
	 * @param bodyFilter Statistiche richieste scritte in formato JSON (come i filtri)               
	 * @return Elenco delle statistiche
	 * @throws ParseException  Caso di filtro per Data (errore nella data)                                            
	 * @throws WrongFilterException   Caso filtro errato
	 * @throws java.text.ParseException
	 * @throws org.json.simple.parser.ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 * @throws EmptyListException    Caso in cui la lista  dataPool è vuota
	 */
	@PostMapping("/twitt/stats")
	public ResponseEntity<Object> stats(@RequestBody String bodyFilter) throws ParseException, WrongFilterException,
			org.json.simple.parser.ParseException, java.text.ParseException, IOException, EmptyListException {

		return new ResponseEntity<Object>(StatsTweets.stats(tSI.getTweetsFilter(bodyFilter, tSI.getAllTweets())),
				HttpStatus.OK);

	}

	/**
	 * Filtraggio dei dati in base al JSON inserito nel body
	 *
	 * 
	 * @param bodyFilter Il filtro richiesto in formato JSON (come Stringa)
	 * @return Elenco dei tweet filtrati
	 * @throws ParseException Caso del filtro della data con formato sbagliato                                      
	 * @throws WrongFilterException                  Caso filtro errato
	 * @throws org.json.simple.parser.ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 * 
	 */
	@PostMapping("/twitt/filter")
	public ResponseEntity<Object> getTweetsFilter(@RequestBody String bodyFilter) throws ParseException, WrongFilterException,
			EmptyListException, org.json.simple.parser.ParseException, java.text.ParseException, IOException {

		return new ResponseEntity<Object>(tSI.getTweetsFilter(bodyFilter, tSI.getAllTweets()), HttpStatus.OK);

	}

}
