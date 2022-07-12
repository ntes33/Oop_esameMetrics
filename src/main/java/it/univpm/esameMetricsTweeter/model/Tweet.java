package it.univpm.esameMetricsTweeter.model;


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
		    
		    private long id_user;
		    
		    private String name;
		    
		    private String Location;
		    
		    private long Follower;
		    
		    private long Following;
		    
		    /**
		     *     
		     *  CONSTRUCTORS 
		     */    
		    public Tweet() {
		        
		    }
		    public Tweet(String created_at, long idtweet, String text, String source, Long n_like, Long n_retweet,
		            boolean favourites, boolean retweeted, long id_user, String name, String location, Long follower,
		            Long following) {
		        super();
		        this.created_at = created_at;
		        this.idtweet = idtweet;
		        this.text = text;
		        this.source = source;
		        this.n_like = n_like;
		        this.n_retweet = n_retweet;
		        this.favourites = favourites;
		        this.retweeted = retweeted;
		        this.id_user = id_user;
		        this.name = name;
		        this.Location = location;
		        this.Follower = follower;
		        this.Following = following;
		    }
		    public String getCreated_at() {
		        return created_at;
		    }


		    public void setCreated_at(String created_at) {
		        this.created_at = created_at;
		    }


		    public long getIdtweet() {
		        return idtweet;
		    }


		    public void setIdtweet(long idtweet) {
		        this.idtweet = idtweet;
		    }


		    public String getText() {
		        return text;
		    }


		    public void setText(String text) {
		        this.text = text;
		    }


		    public String getSource() {
		        return source;
		    }


		    public void setSource(String source) {
		        this.source = source;
		    }
		    public Long getN_like() {
		        return n_like;
		    }


		    public void setN_like(Long n_like) {
		        this.n_like = n_like;
		    }


		    public Long getN_retweet() {
		        return n_retweet;
		    }


		    public void setN_retweet(Long n_retweet) {
		        this.n_retweet = n_retweet;
		    }


		    public boolean isFavourites() {
		        return favourites;
		    }


		    public void setFavourites(boolean favourites) {
		        this.favourites = favourites;
		    }


		    public boolean isRetweeted() {
		        return retweeted;
		    }


		    public void setRetweeted(boolean retweeted) {
		        this.retweeted = retweeted;
		    }
		    public long getId_user() {
		        return id_user;
		    }


		    public void setId_user(long id) {
		        this.id_user = id;
		    }


		    public String getName() {
		        return name;
		    }


		    public void setName(String name) {
		        this.name = name;
		    }


		    public String getLocation() {
		        return Location;
		    }


		    public void setLocation(String location) {
		        Location = location;
		    }


		    public Long getFollower() {
		        return Follower;
		    }


		    public void setFollower(Long follower) {
		        Follower = follower;
		    }


		    public Long getFollowing() {
		        return Following;
		    }


		    public void setFollowing(Long following) {
		        Following = following;
		    }
		    
	
	
	
	
}
