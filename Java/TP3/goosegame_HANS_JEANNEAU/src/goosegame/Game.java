package goosegame;
import java.util.*;
/**
 * Classe Game caractérisée par un plateau et une liste de joueurs et permet de jouer 
 * une partie du jeu de l’oie
 * @author Adrien et Tanguy 
 *
 */
public class Game {
	
	//attributs :
	protected List<Player> thePlayers;
	protected Board board; 
	//Constructeur :
	public Game(Board b) {
		this.board = b;
		this.thePlayers = new ArrayList<Player>();
		
	}
		
	/**
	 * Methode addPlayer(p:Player)
	 * Ajoute un joueur au jeu et lui attribue la première case
	 * @param p : Player, le nouveau joueur à ajouter
	 */
	public void addPlayer(Player p) {
		this.thePlayers.add(p);
		this.getBoard().getCell(0).welcomePlayer(p);			
	}
	
	//Get Board : 
	public Board getBoard() {
		return this.board;
	}

	
	//Method play()	
	/**
	 * Méthode play() pour gérer une partie entière : 
	 */
	public void play() {
		// taille du plateau en nombre de cases : 
		int sizeBoard = this.getBoard().getNbOfCells() - 1;
		
		//Variable pour savoir si la partie est finie ou pas : 
		int finished =0; 
		//Tant que aucun joueur sur la case finale : 
		while(finished==0) {
			// Pour chaque joueur, on lance les dés : 
			for (Player p : thePlayers) {
				//On vérifie que la case peut être quittée : 
				if (p.getCell().canBeLeft()) {
					int result = p.twoDiceThrow();
					
					//On prend l'index actuel du joueur et on modifie en fonction de son lancer : 
					int currentIndex = p.getCell().getIndex();
					int interIndex = currentIndex + result; 
					int IndexToString;
					int destinationIndex;
					
					//On vérifie que le joueur n'est pas en dehors du plateau (après la case d'arrivée) : 
					if (interIndex < sizeBoard + 1) {
						//Chaines de caractères pour tenir les joueurs informés du déroulé de la partie : 
						System.out.print(p.toString()+" is in cell "+ currentIndex+", "+ p.toString() + " throws " + result + " and reaches cell " + interIndex + " " );
						destinationIndex = this.getBoard().getCell(interIndex).handleMove(result);
						
					}
					else {
						//Si le joueur dépasse la case arrivée avec son lancer de dés, il va jusqu'à la case arrivée et retourne en arrière
						IndexToString=sizeBoard - (result -(sizeBoard - currentIndex));
						System.out.print(p.toString()+" is in cell "+ currentIndex+", "+ p.toString() + " throws " + result + " and reaches cell " + IndexToString + " " );
						destinationIndex = this.getBoard().getCell(IndexToString).handleMove(result);
					}					
					
					
					// On revérifie que le joueur ne sorte pas du plateau 
					// Notamment en rebondissant sur la case oie 54 pour le plateau classique : 
					//Puisqu'on évite toute cascade, nous n'avons pas besoin de le faire plus de fois.
					if (destinationIndex > sizeBoard ) {
						destinationIndex = sizeBoard - (destinationIndex - sizeBoard);	
						System.out.println(" ----------------Out of bound, replaced to cell :  " + destinationIndex+"---------------------");
					}					
					
					Cell destinationCell = this.getBoard().getCell(destinationIndex);
					destinationCell.welcomePlayer(p);
					
					
					// On vérifie si le joueur est gagnant : 
					if (destinationIndex == sizeBoard) {
						System.out.println(p.toString()+ " has won");
						finished=1;
						break;
					}
					
				}
				//Le joueur ne peut pas quitter la case : 
				else {
					// Le joueur attend
				}
			}
			
		}
		
	}	
}