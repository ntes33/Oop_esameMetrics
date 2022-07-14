package it.univpm.esameMetricsTweeter.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.Data;


           /*
            *  Classe che modella tutti gli attribuiti
            */

 
@AllArgsConstructor  // chiama automaticamente i costrutori
@Data                //Genera i setter e getter

public class Tweet {
	
		    // Data di creazione del Tweet
		    private String created_at;
		    
		    // ID del tweet
		    private long idtweet;
		    
		    // Il texto contenuto del Tweet
		    private String text;
		    
		    
		    private String source;
		    
		    // Numero dei Likes
		    private long n_like;
		    
		    // Numero dei Retweets
		    private long n_retweet;
		    
		    private boolean favourites;
		    
		    private boolean retweeted;
		    
		    //Id del utente
		    private long id_user;
		    
		    // Nome dell utente
		    private String name;
		    
		    //Localita 
		    private String Location;
		    
		    private long Follower;
		    
		    private long Following;
		    
		    
		    /*    
		     *  CONSTRUCTORS 
		     */    
		    public Tweet() {
		        
		    }

		    /*
			 * Fa parsing della data e trasforma la stringa in un oggetto Date
			 * @return Oggetto data (con il formato di Twitter)
			 * @throws ParseException se ci sono problemi con il formato della data
			 */
			public Date parsedDate() throws ParseException {
				SimpleDateFormat sf = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
				sf.setLenient(false);
				return sf.parse(this.created_at);
			}

}
