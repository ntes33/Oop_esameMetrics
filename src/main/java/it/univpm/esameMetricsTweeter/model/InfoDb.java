package it.univpm.esameMetricsTweeter.model;

import java.util.ArrayList;



public class InfoDb {

	
	
	/**
     * The arrayList of Metadata
     */
        private ArrayList<MetaData> metadata=new ArrayList<MetaData>();
    /**
     * Constructor that builds The ArrayList that contains the MetaData
     * @return An arrayList of SingleMetadata
     */
public InfoDb() {    
    metadata.add(new MetaData("created_at", "Date Day and time of the tweet", "String"));
    metadata.add(new MetaData("idtweet", "a unique id of the tweet", "long"));
    metadata.add(new MetaData("text", "text of the tweet", "String"));
    metadata.add(new MetaData("source", "Source of the tweet", "String"));
    metadata.add(new MetaData("n_like", "number of likes of the tweet", "long"));
    metadata.add(new MetaData("n_retweet", "number of re-tweet of the tweet", "long"));
    metadata.add(new MetaData("favourites", "If the tweet is liked or not ", "boolean")); 
    metadata.add(new MetaData("retweeted", "If the tweet was Retweeted or not ", "boolean"));
    metadata.add(new MetaData("id_user", "id of the user that has tweeted ", "long"));
    metadata.add(new MetaData("name", "name of the user that has tweeted ", "String"));
    metadata.add(new MetaData("Location", "Location of the tweet", "String"));
    metadata.add(new MetaData("Follower", "number of followers of the user", "long"));
    metadata.add(new MetaData("Following", "number of accounts that the user follows", "long"));
}    
    /**
     * Return the metadata
     * @return metadata
     */
    public ArrayList<MetaData> getMetadata(){
        return this.metadata;
    }
	
	
	

	
	
	
}
