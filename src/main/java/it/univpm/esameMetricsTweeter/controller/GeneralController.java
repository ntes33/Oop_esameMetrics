package it.univpm.esameMetricsTweeter.controller;



import java.io.IOException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public     ArrayList<Tweet> GetTweets() throws org.json.simple.parser.ParseException, ParseException, IOException{
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
    public     ArrayList<MetaData> GetMetadata() throws org.json.simple.parser.ParseException, ParseException, IOException{
        return new ArrayList<MetaData>(tSI.recordMetadata());
    }
	
	
	
	
}
