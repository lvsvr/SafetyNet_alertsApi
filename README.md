# w-boar-SafetyNet_alertsApi
Spring Boot ReST API
___
## Endpoints
___
**http://localhost:8080/person**
* POST */<firstName>/<lastName>* : ajouter une personne
* PUT */<firstName>/<lastName>* : mettre à jour les informations d'une personne
* DELETE */<firstName>/<lastName>* : suppprimer une personne

**http://localhost:8080/firestation**
* POST */<address>* : ajouter le mapping d'une caserne
* PUT */<address>* : mettre à jour le mapping d'une caserne
* DELETE */<address>* : supprimer le mapping d'une caserne

**http://localhost:8080/medicalRecord**
* POST */<firstName>/<lastName>* : ajouter une dossier médiacal
* PUT */<firstName>/<lastName>* : mettre à jour un dossier médical
* DELETE */<firstName>/<lastName>* : supprimer un dossier médical

___
## URL
___

* **http://localhost:8080/firestation?stationNumber=<station_number>**

Cette url retourne une liste des personnes couvertes par la caserne de pompiers correspondante. 
Donc, si le numéro de station = 1, elle renvoie les habitants couverts par la station numéro 1. La liste 
inclut les informations spécifiques suivantes : prénom, nom, adresse, numéro de téléphone. De plus, 
elle fournit un décompte du nombre d'adultes et du nombre d'enfants (tout individu âgé de 18 ans ou 
moins) dans la zone desservie.

* **http://localhost:8080/childAlert?address=<address>**

Cette url retourne une liste d'enfants (tout individu âgé de 18 ans ou moins) habitant à cette adresse. 
La liste comprend le prénom et le nom de famille de chaque enfant, son âge et une liste des autres 
membres du foyer. S'il n'y a pas d'enfant, cette url renvoie une chaîne vide. 

* **http://localhost:8080/phoneAlert?firestation=<firestation_number>**

Cette url retourne une liste des numéros de téléphone des résidents desservis par la caserne de 
pompiers. Elle sera utilisée pour envoyer des messages texte d'urgence à des foyers spécifiques. 

* **http://localhost:8080/fire?address=<address>** 

Cette url retourne la liste des habitants vivant à l’adresse donnée ainsi que le numéro de la caserne 
de pompiers la desservant. La liste inclut le nom, le numéro de téléphone, l'âge et les antécédents 
médicaux (médicaments, posologie et allergies) de chaque personne.

* **http://localhost:8080/flood/stations?stations=<a list of station_numbers>**

Cette url retourne une liste de tous les foyers desservis par la caserne. Cette liste regroupe les 
personnes par adresse. Elle inclut aussi le nom, le numéro de téléphone et l'âge des habitants, et 
fait figurer leurs antécédents médicaux (médicaments, posologie et allergies) à côté de chaque nom.  

* **http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>** 
 
Cette url retourne le nom, l'adresse, l'âge, l'adresse mail et les antécédents médicaux (médicaments, 
posologie, allergies) de chaque habitant. Si plusieurs personnes portent le même nom, elles apparaissent 
toutes.

* **http://localhost:8080/communityEmail?city=<city>** 

Cette url retourne les adresses mail de tous les habitants de la ville.
