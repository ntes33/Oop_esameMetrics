# Progetto OOP Twitter Metrics

![Twitter](https://cdn.cms-twdigitalassets.com/content/dam/legal-twitter/privacy-policy-2022/Twitter-terms-of-service-share.jpg.twimg.768.jpg)

## Indice 🔖

* [Introduzione](#introduzione)
* [Installazione ed utilizzo](#installazione-ed-utilizzo)
* [Rotte](#rotte)
* [Filtraggio](#filtraggio)
* [Eccezioni](#eccezioni)
* [UML Case Diagram](#umlcasediagram)
* [UML Class Diagram](#umlclassdiagram)
* [Software utilizzati](#software-utilizzati)
* [Autori](#autori)

<div id='introduzione'/>

## INTRODUZIONE

Attraverso le **Application Programming Interface**, note anche come 'api' derivate dalla pagina [Twitter Developer](https://developer.twitter.com/en) , il programma valuta una lista di tweet di un account scelto per poi analizzare le metriche di engagement dei tweet. L'utente ha la possibilità di imporre le statistiche sull'engagement dei singoli tweet con media e varianza oppure imporre dei filtri per fasce orarie dei tweet.

<div id='installazione-ed-utilizzo'/>

## INSTALLAZIONE ED UTILIZZO 📖

Per poter accedere al programma è necessario clonare la repository in locale utilizzando Github Desktop oppure da terminale digitando `git clone https://github.com/ntes33/Oop_esameMetrics` .
Successivamente sarà possibile mandare in esecuzione il programma con un IDE (ad esempio Eclipse) o direttamente da terminale.

In seguito l'utente deve accedere alla cartella resources, reperibile attraverso il percorso `esameMetrics\src\main\resources`, e gestire la fase di autenticazione utilizzando la propria `apiKey` ricevuta in fase di registrazione sul [Developer Portal](https://developer.twitter.com/en/portal/dashboard) insieme al `proxy` di accesso creato per il corso di OOP e reperibile sulla [Pagina Web](https://learn.univpm.it/mod/page/view.php?id=260186) del corso.

Dopodiché l'utente può utilizzare il programma con le rotte sul client [Postman](https://www.postman.com/).

<div id='rotte'/>

## ROTTE 🌐

La creazione delle rotte è fatta in base a ciò che restituiscono:
* [Rotte /list](#Rotte-/list)
* [Rotte /metadata](#Rotte-/metadata)


Però prima di analizzare le rotte dobbiamo capire il significato dei parametri:
- `created_at` è una stringa contenente la data di creazione del Tweet
- `long id` è una stringa contenente l'id del Tweet
- `text` è una stringa contenente il testo contenuto nel Tweet
- `retweet_count` è una stringa contenente il numero dei Retweets
- `favorite_count` è una stringa contenente il numero dei Likes


### Rotte /lists 🌐

Le rotte **/lists** permettono di ottenere la lista dei Tweets, che possono essere raggruppati per data di creazione, id, testo, retweet e like, in base alla scelta della rotta da parte dell'utente. 

I parametri inseriti dall'utente servono per filtrare la lista di tutti i tweet e visualizzare solo quelli di interesse. Se i parametri di filtraggio non vengono inseriti non viene effettuato alcun filtro, e dunque verranno restituiti tutti i tweet, raggruppati o meno a seconda della rotta.

### Rotte /metadata 🌐

Le rotte **/metadata** permettono di ottenere informazioni come `nametag` con una breve descrizione riguardo il contenuto del field, `info` contenente informazioni sul tipo di field e `type`.

![image](https://user-images.githubusercontent.com/107246907/179125015-98209ab7-8db9-402c-b6ae-b07d45648238.png)


<div id='/statistics'/>

### Rotte /stats 🌐

Le statistiche prendono in considerazione i parametri:
* `param` list Lista di cui calcolare le statistiche
* `return` Elenco delle statistiche





<div id='filtraggio'/>

## Filtraggio 🌐

Avremmo potuto separare i vari filtri interni al `for` in più funzioni per avere un codice più pulito, invece abbiamo preferito evitare di renderlo più lungo dato che la complessità computazionale è la stessa.

`param` list filtra la lista database

`param` filter Il JSON di richiesta dei filtri

`param` param Parametri dei filtri

`return` Lista filtrata

`throws` WrongFilterException Caso filtro errato



<div id='eccezioni'/>

## Eccezioni ❌

Il programma contiene delle eccezioni personalizzate :

`WrongFilterException` nel caso in cui venga inserito un filtro sbagliato

`EmptyListException` che stampa un messaggio d'errore passato come parametro



<div id='umlcasediagram'/>

## UML CASE DIAGRAM 📈 

![image](https://user-images.githubusercontent.com/107246907/179115669-ba0a0231-0ee0-4323-88c4-705f11b13bed.png)




<div id='umlclassdiagram'/>

## UML CLASS DIAGRAM 📈

![image](https://user-images.githubusercontent.com/107246907/179115758-a633bd78-b6b0-4fcd-93f1-84415cb37c17.png)










<div id='software-utilizzati'/>


## SOFTWARE UTILIZZATI 🔧
La lista di software & tools utilizzati è la seguente:
* [Eclipse](https://www.eclipse.org/downloads/) - Ambiente di sviluppo
* [Postman](https://www.postman.com/) - Strumento utile per richiamare e testare le API
* [Git](https://git-scm.com/) e [GitHub]() - Sistemi per il versioning del codice
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework per sviluppo di applicazioni in Java
* [Maven](https://maven.apache.org/) - Software per gestione del progetto Java e dipendenze
* [Libreria JSON.simple](https://www.tutorialspoint.com/json_simple/index.htm) - Libreria per parsing, lettura e scrittura di oggetti e array in formato JSON
* [Javadoc](https://www.oracle.com/java/technologies/javase/javadoc-tool.html) - Strumento per la generazione automatica della documentazione del codice sorgente
* [JUnit 5](https://junit.org/junit5/) -Framework per lo unit testing
* [UML Lab Modeling IDE](https://www.uml-lab.com/en/uml-lab/) - Software per la creazione dei UML diagrams
* [Project Lombok](https://projectlombok.org/) - Libreria usata per ridurre drasticamente la verbosità del linguaggio
* [GSON] - Libreria per il JSON


<div id='autori'/>

## AUTORI 👨‍💻

* [Nguetsa Etienne Steve](https://github.com/ntes33) 60%

* [Ganeanu Daniela](https://github.com/dganeanu) 40%
    
