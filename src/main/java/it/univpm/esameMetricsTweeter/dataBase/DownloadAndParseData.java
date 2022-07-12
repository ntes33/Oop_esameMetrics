package it.univpm.esameMetricsTweeter.dataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import it.univpm.esameMetricsTweeter.model.Tweet;
import it.univpm.esameMetricsTweeter.utils.SourceStringSplitter;


public class DownloadAndParseData {

	
	 /**
     * ArrayList of Tweet type to store all the data
     */
    private ArrayList<Tweet> data=new ArrayList<>();
/**
 * This function open the connection with the twitter API and reads all the information from the tweets
 * Plus this function Saves all the information by parsing all the data from the JSONObject in to an ArrayList
 * @return An ArrayList of tweets  
 * @throws org.apache.tomcat.util.json.ParseException
 * @throws IOException
 */
public ArrayList<Tweet> jsonTweets() throws org.apache.tomcat.util.json.ParseException, IOException {
    
    String search="univpm";
    URL url=new URL("https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q="+search+"&count=50");
    HttpURLConnection openConnection= (HttpURLConnection)url.openConnection();
    openConnection.setRequestMethod("GET");
    openConnection.connect();
    try
    {
    String inline ="";
    StringBuilder contentBuilder = new StringBuilder();
    try 
        {        
        BufferedReader buf=new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
            while((inline=buf.readLine())!=null)
                {
               contentBuilder.append(inline);
                }
            buf.close();
            String line = contentBuilder.toString();
            //writer.Writefile(line);
            
         JSONObject json=(JSONObject ) JSONValue.parse(line);
         JSONArray obj= (JSONArray) json.get("statuses");
         
         SourceStringSplitter o1=new SourceStringSplitter();
         for(Object o: obj) {
                Tweet t=new Tweet();
            
                t.setCreated_at((String)((JSONObject)o).get("created_at"));
                t.setIdtweet((Long)((JSONObject)o).get("id"));
                t.setText((String)((JSONObject)o).get("text"));
                t.setSource(o1.StringSplitter((String)((JSONObject)o).get("source")));
                t.setN_like((Long)((JSONObject)o).get("favorite_count"));    
                t.setN_retweet((Long)((JSONObject)o).get("retweet_count"));
                t.setRetweeted((Boolean)((JSONObject)o).get("retweeted"));
                t.setFavourites((Boolean)((JSONObject)o).get("favorited"));    
                t.setId_user((Long)((JSONObject) (((JSONObject)o).get("user"))).get("id"));
                t.setName((String)((JSONObject) (((JSONObject)o).get("user"))).get("name"));
                t.setLocation((String)((JSONObject) (((JSONObject)o).get("user"))).get("location"));
                t.setFollower((Long)((JSONObject) (((JSONObject)o).get("user"))).get("followers_count"));
                t.setFollowing((Long)((JSONObject) (((JSONObject)o).get("user"))).get("friends_count"));
                
                data.add(t);     
         }
        }
        catch(IOException e) {
        System.out.println("Errore I/O");
        System.out.println(e);
        }
    //Disconnect the HttpURLConnection stream
    }finally {
        
    }
    openConnection.disconnect();
    return data;
    }
	
	
	
	
	
	
}
