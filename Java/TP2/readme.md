# TP Pierre feuille ciseaux
# Auteurs : Adrien HANS & Tanguy JEANNEAU

Question 1 : 
	/**
	 * Méthode playOneTurn() permettant de faire jouer un tour de jeu: 
	 */
	public void playOneTurn() {
		//Chaque joueur joue : 
		Shape s1=j1.play()
		Shape s2=j2.play()
		
		//On compare les coups des deux joueurs :
		int comp = s1.compareTo(s2)
		if(comp>0) {
			//Le joueur 1 gagne
			j1.addPoint(2)
		} 
		else if(comp<0) {
			//Le joueur 2 gagne
			j2.addPoint(2)
		}else {
			//Egalité 
			j1.addPoint(1)
			j2.addPoint(1)
		}

Question 2 : 
        On identifie déjà plusieurs classes : 
        
        Class Game
        Méthode  + playOneTurn()

        Class Player 
        Attributs  -name:String
        Méthode + play() : Shape

        Class Shape
        Méthode +compareTo(s:Shape) : int

        Class Comparable<Shape>

Question 3 : 
        Afin de permettre au joueur d'avoir une stratégie, on ajoute un attribut Strategy dans la class Player et on ajoute une méthode setStrategy et une méthode getStrategy dans la class Player

        Class Player 
        Attributs 
        -name:String
        -strategy : Strategy
        Méthode 
        + play() : Shape
        +setStrategy(s:Strategy)
        +getStrategy():Strategy

Question 4 : 
        Afin de permettre au joueur de choisir parmi différentes stratégies, on défini une interface Strategy

        On défini une class AlwaysStrat pour les stratégies consistant à jouer toujours la même chose
        class AlwaysStrat
        Attribut : 
        -theShape : Shape
        Méthodes : 
        + AlwaysStrat(s:Shape)
        + nextShape() : Shape


        On défini une class SequenceStrat pour les stratégies consistant à jouer une séquence de mains(pierre, feuille ou ciseaux) 
        Class SequenceStrat
        Attributs : 
        int indice 
        Méthode : 
        + SequenceStrat(Shape[] seq)
        + nextShape():Shape


        On défini une class RandomStrat pour la stratégie consistant à jouer de façon alétaoire. 
        Il faudra modifier la class Player en conséquence. 
        Ceendant, la class Game na pas besoin d'être modifiée. 

Question 5 : 
        Afin de permettre au joueur d'avoir une stratégie de jeu qui consiste à choisir le coup à chaque manche, on défini une class HumanStrategy
        Avec la méthode +nextShape():Shape



Question 6 : 
        On doit créer l'ensemble des classes définies dans les questions précédentes, en modifiant les différents éléments en conséquence. 
        On créé la classe Main pour pouvoir faire jouer un "joueur humain" contre un joueur géré par le programme, appelé "ordinateur" dont la stratégie est choisie alétaoirement parmi les 8 créées. 
        on a aussi fait en sorte que le joueur "humain" puisse choisir son nom et le nombre de manches de chaque partie. 
