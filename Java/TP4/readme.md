# Adrien HANS & Tanguy JEANNEAU
# TP 4 : Agence de Location 

#### Commentaires en plus de ceux présents dans le code : 

## Q8 :
On obtient bien la réponse souhaitée dès la première execution de `MainQ8`, c'est à dire `true`.

## Q9/10 : 
Nous avons bien géré le surcout exigé par une agence de location suspicieuse envers les clients de moins de 25 ans.
On voit, en executant la bonne partie de la classe `main`, que le prix de en utilisant la classe `SuspiciousRentalAgency` est bien 10% supérieur à celui en utilisant la classe `RentalAgency`.

## Q13 : 
On voit, en executant la bonne partie de code de la classe `main`, que le fait que le vehicule traité soit une voiture, une moto, ou bien un vehicule en général via la méthode toString() qui est modifiée. 
De plus, on voit bien que les "sélections" restent valables. 
En effet, en mettant un critère de prix à 100, car2 dont le prix est à 25 est bien affichée tandis que car1 dont le prix est à 200 ne l'est pas. 
Les affichages de la moto et de la voiture sont bien modifiés, prouvant que la méthode toString modifiée pour les classes `Car` et `Motorbike` a bien été prise en compte. 
