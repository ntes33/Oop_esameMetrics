package it.univpm.esameMetricsTweeter.model;

public class MetaData {

	
	/**
     * Name tag of the field
     */
    private String nametag;
    /**
     * Short description of what the fields contains
     */
    private String  info;
    /**
     * The info of the type of the field
     */
    private String type;
    
    public MetaData(String nametag, String info, String type) {
        super();
        this.nametag = nametag;
        this.info = info;
        this.type = type;
    }
    public MetaData() {
        
    }
    public String getNametag() {
        return this.nametag;
    }
    public void setNametag(String nametag) {
        this.nametag = nametag;
    }
    public String getInfo() {
        return this.info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

	
	
	
	
	
	
}
