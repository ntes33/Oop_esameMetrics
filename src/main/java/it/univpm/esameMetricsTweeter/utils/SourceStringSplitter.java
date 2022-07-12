package it.univpm.esameMetricsTweeter.utils;

public class SourceStringSplitter {

	
	 public String StringSplitter(String jsonstr) {
	        String str_final="";
	        boolean isin=true;
	        for(char c:jsonstr.toCharArray()) {
	            if(c=='<')
	                isin =true;
	            if(!isin)
	                str_final+= c;
	            if(c=='>')
	                isin =false;
	        }
	        return str_final;
	    }
		
	
	
	
	
	
}
