package it.univpm.esameMetricsTweeter.filters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.google.gson.JsonElement;

import it.univpm.esameMetricsTweeter.exception.WrongFilterException;
import it.univpm.esameMetricsTweeter.model.Tweet;



public class Filtri {

	private static Object filterFiled;

	/**
	 * Filtra in base ai Likes (favorite_count)
	 * 
	 * <p>Si potevano separare in più funzioni i vari filtri interni al for per avere un codice più pulito
	 * ma sarebbe stato molto più lungo e inutile dato che poi la complessità computazionale è la stessa </p>
	 *
	 * @param list La lista da filtrare
	 * @param filter Il JSON di richiesta dei filtri
	 * @param param Parametri dei filtri
	 * @return Lista filtrata
	 * @throws WrongFilterException Caso filtro errato
	 */
	
	
	
	public static ArrayList<Tweet> filterByLikes(ArrayList<Tweet> dataBase, String filterAnnot,JsonElement param) throws WrongFilterException {
		// TODO Auto-generated method stub
		ArrayList<Tweet> listaFiltrata = new ArrayList<Tweet>();
		for (int i = 0; i < dataBase.size(); i++) {
			/**Eccezione che parte dal momento in cui i filtri inseriti non sono corretti*/
	
	
			if (!filterAnnot.equals("$gt") && !filterAnnot.equals("$gte") && !filterAnnot.equals("$lt") && !filterAnnot.equals("$lte") && !filterAnnot.contentEquals("$bt") ) 
				throw new WrongFilterException("Il filtro inserito non è corretto!");
			
			if (filterAnnot.equals("$gt") && dataBase.get(i).getN_like() > param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$gte") && dataBase.get(i).getN_like() >= param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$lt") && dataBase.get(i).getN_like() < param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$lte") && dataBase.get(i).getN_like() <= param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$bt")) {
				/** Viene messo il controllo della size dato che parametri richiesti
				 * sono esattamente due. Ciò evita anche IndexOutOfBounds */
			if (! param.isJsonArray() || param.getAsJsonArray().size() != 2) {
					/**Eccezione nel caso in cui sia sbagliato il filtro $bt*/
					
					
					throw new WrongFilterException("Filtro $bt errato, sono richiesti 2 valori");
				} else {
				
				
				/**
					 * Se sono inseriti in ordine errato (prima un paramatro maggiore e poi un minore) viene
					 * invertito il controllo
					 */
				
					if (param.getAsJsonArray().get(0).getAsInt() <= param.getAsJsonArray().get(1).getAsInt()) {
						if (dataBase.get(i).getN_like() >= param.getAsJsonArray().get(0).getAsInt()
								&& dataBase.get(i).getN_like() <= param.getAsJsonArray().get(1).getAsInt())
							listaFiltrata.add(dataBase.get(i));
					} else {
						if (dataBase.get(i).getN_like() <= param.getAsJsonArray().get(0).getAsInt()
								&& dataBase.get(i).getN_like() >= param.getAsJsonArray().get(1).getAsInt())
							listaFiltrata.add(dataBase.get(i));
					}
				}

			}
		}

		return listaFiltrata;
	}

	/**
	 * Filtra in base ai Retweets (retweet_count)
	 * 
	 * @param list La lista da filtrare
	 * @param filter Il JSON di richiesta dei filtri
	 * @param param Parametri dei filtri
	 * @return Lista filtrata
	 * @throws WrongFilterException Caso filtro è errato
	 */
	public static ArrayList<Tweet> filterByRetweet(ArrayList<Tweet>dataBase , String filterAnnot, JsonElement param) throws WrongFilterException {
		// TODO Auto-generated method stub
		ArrayList<Tweet> listaFiltrata = new ArrayList<Tweet>();
		for (int i = 0; i < dataBase.size(); i++) {
			/**Eccezione che parte dal momento in cui i filtri inseriti non sono corretti*/
			if (!filterAnnot.equals("$gt") && !filterAnnot.equals("$gte") && !filterAnnot.equals("$lt") && !filterAnnot.equals("$lte") && !filterAnnot.contentEquals("$bt") ) 
				throw new WrongFilterException("Il filtro inserito non è corretto!");
			
			if (filterAnnot.equals("$gt") && dataBase.get(i).getN_retweet() > param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$gte") && dataBase.get(i).getN_retweet() >= param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$lt") && dataBase.get(i).getN_retweet() < param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$lte") && dataBase.get(i).getN_retweet() <= param.getAsInt()) {
				listaFiltrata.add(dataBase.get(i));
			}
			if (filterAnnot.equals("$bt")) {
				if (!param.isJsonArray() || param.getAsJsonArray().size() != 2) {
					/**Eccezione nel caso in cui sia sbagliato il filtro $bt*/
					throw new WrongFilterException("Filtro $bt errato, sono richiesti 2 valori");
				} else {
					if (param.getAsJsonArray().get(0).getAsInt() <= param.getAsJsonArray().get(1).getAsInt()) {
						if (dataBase.get(i).getN_retweet() >= param.getAsJsonArray().get(0).getAsInt()
								&& dataBase.get(i).getN_retweet() <= param.getAsJsonArray().get(1).getAsInt())
							listaFiltrata.add(dataBase.get(i));
					} else {
						if (dataBase.get(i).getN_retweet() <= param.getAsJsonArray().get(0).getAsInt()
								&& dataBase.get(i).getN_retweet() >= param.getAsJsonArray().get(1).getAsInt())
							listaFiltrata.add(dataBase.get(i));
					}
				}

			}
		}

		return listaFiltrata ;
	}

	/**
	 * Filtra in base alla data di creazione del Tweet
	 * 
	 * <p>Da notare che nel filtro gte si considera il giorno dato incluso. Nel filtro
	 * gt si considera dal giorno dopo (lo stesso per lt e lte) </p>
	 *
	 * @param list La lista da filtrare
	 * @param filter Il JSON di richiesta dei filtri
	 * @param param I parametri dei filtri
	 * @return Lista filtrata
	 * @throws ParseException Caso di errore nel parsing della data
	 * @throws WrongFilterException Caso di filtro errato
	 */
	public static ArrayList<Tweet> filterByTime(ArrayList<Tweet> dataBase, String filterAnnot, JsonElement param)
			throws ParseException, WrongFilterException { 
		/**Eccezione che parte dal momento in cui i filtri inseriti non sono corretti*/
		if (!filterAnnot.equals("$gt") && !filterAnnot.equals("$gte") && !filterAnnot.equals("$lt") && !filterAnnot.equals("$lte") && !filterAnnot.contentEquals("$bt") ) 
			throw new WrongFilterException(" Attenzione Il filtro inserito non è corretto!");
		// TODO Auto-generated method stub
		ArrayList<Tweet> listaFiltrata = new ArrayList<Tweet>();
		/**
		 * E' stato scelto questo formato per il datepicker di Bootstrap per
		 * l'interfaccia grafica
		 */
		SimpleDateFormat sf = new SimpleDateFormat("MMM dd, yyyy, HH:mm:ss", Locale.ENGLISH);
		sf.setLenient(false);

		if (filterAnnot.equals("$gte")) {
			for (int i = 0; i < dataBase.size(); i++) {
				Date dateFilter;

				dateFilter = sf.parse(param.getAsString());
				if (dataBase.get(i).parsedDate().compareTo(dateFilter) > 0)
					listaFiltrata.add(dataBase.get(i));

			}
		}
		if (filterAnnot.equals("$gt")) {
			for (int i = 0; i < dataBase.size(); i++) {
				Date dateFilter;
				dateFilter = sf.parse(param.getAsString());
				/**
				 * Per aumentare il giorno (e diminuire) si utilizza la classe Calendar
				 */

				Calendar dateAfter = Calendar.getInstance();
				dateAfter.setTime(dateFilter);
				dateAfter.add(Calendar.DATE, 1);
				if (dataBase.get(i).parsedDate().compareTo(dateAfter.getTime()) > 0)
					listaFiltrata.add(dataBase.get(i));
			}
		}
		if (filterAnnot.equals("$lt")) {
			for (int i = 0; i < dataBase.size(); i++) {
				Date dateFilter;
				dateFilter = sf.parse(param.getAsString());
				
				Calendar dateBefore = Calendar.getInstance();
				dateBefore.setTime(dateFilter);
				dateBefore.add(Calendar.DATE, -1);
				
				if (dataBase.get(i).parsedDate().compareTo(dateFilter) < 0)
					listaFiltrata.add(dataBase.get(i));

			}
		}
		if (filterAnnot.equals("$lte")) {
			for (int i = 0; i < dataBase.size(); i++) {
				Date dateFilter;
				dateFilter = sf.parse(param.getAsString());
				
				if (dataBase.get(i).parsedDate().compareTo(dateFilter) < 0)
					listaFiltrata.add(dataBase.get(i));

			}
		}
		if (filterAnnot.equals("$bt")) {
			for (int i = 0; i < dataBase.size(); i++) {
				if (!param.isJsonArray() || param.getAsJsonArray().size() != 2) {
					/**Eccezione in cui il filtro $bt non sia corretto*/
					throw new WrongFilterException("Filtro $bt errato, sono richiesti 2 valori");
				} else {
					Date dateFilter1;
					try {
						dateFilter1 = sf.parse(param.getAsJsonArray().get(0).getAsString());
						Date dateFilter2 = sf.parse(param.getAsJsonArray().get(1).getAsString());
						/**
						 * Se le date da filtrare sono inserite in verso decrescente si risolve
						 * invertendole
						 */
						if (dateFilter1.compareTo(dateFilter2) > 0) {
							Date tmp = dateFilter2;
							dateFilter2 = dateFilter1;
							dateFilter1 = tmp;

						}
						if (dataBase.get(i).parsedDate().compareTo(dateFilter1) > 0
								&& dataBase.get(i).parsedDate().compareTo(dateFilter2) < 0)
							listaFiltrata.add(dataBase.get(i));
					} catch (ParseException e) {
						
						e.printStackTrace();
					}

				}
			}
		}

		return listaFiltrata;
	}
}
