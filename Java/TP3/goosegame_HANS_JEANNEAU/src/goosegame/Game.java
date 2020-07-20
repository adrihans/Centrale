package goosegame;
import java.util.*;
/**
 * Classe Game caract�ris�e par un plateau et une liste de joueurs et permet de jouer 
 * une partie du jeu de l�oie
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
	 * Ajoute un joueur au jeu et lui attribue la premi�re case
	 * @param p : Player, le nouveau joueur � ajouter
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
	 * M�thode play() pour g�rer une partie enti�re : 
	 */
	public void play() {
		// taille du plateau en nombre de cases : 
		int sizeBoard = this.getBoard().getNbOfCells() - 1;
		
		//Variable pour savoir si la partie est finie ou pas : 
		int finished =0; 
		//Tant que aucun joueur sur la case finale : 
		while(finished==0) {
			// Pour chaque joueur, on lance les d�s : 
			for (Player p : thePlayers) {
				//On v�rifie que la case peut �tre quitt�e : 
				if (p.getCell().canBeLeft()) {
					int result = p.twoDiceThrow();
					
					//On prend l'index actuel du joueur et on modifie en fonction de son lancer : 
					int currentIndex = p.getCell().getIndex();
					int interIndex = currentIndex + result; 
					int IndexToString;
					int destinationIndex;
					
					//On v�rifie que le joueur n'est pas en dehors du plateau (apr�s la case d'arriv�e) : 
					if (interIndex < sizeBoard + 1) {
						//Chaines de caract�res pour tenir les joueurs inform�s du d�roul� de la partie : 
						System.out.print(p.toString()+" is in cell "+ currentIndex+", "+ p.toString() + " throws " + result + " and reaches cell " + interIndex + " " );
						destinationIndex = this.getBoard().getCell(interIndex).handleMove(result);
						
					}
					else {
						//Si le joueur d�passe la case arriv�e avec son lancer de d�s, il va jusqu'� la case arriv�e et retourne en arri�re
						IndexToString=sizeBoard - (result -(sizeBoard - currentIndex));
						System.out.print(p.toString()+" is in cell "+ currentIndex+", "+ p.toString() + " throws " + result + " and reaches cell " + IndexToString + " " );
						destinationIndex = this.getBoard().getCell(IndexToString).handleMove(result);
					}					
					
					
					// On rev�rifie que le joueur ne sorte pas du plateau 
					// Notamment en rebondissant sur la case oie 54 pour le plateau classique : 
					//Puisqu'on �vite toute cascade, nous n'avons pas besoin de le faire plus de fois.
					if (destinationIndex > sizeBoard ) {
						destinationIndex = sizeBoard - (destinationIndex - sizeBoard);	
						System.out.println(" ----------------Out of bound, replaced to cell :  " + destinationIndex+"---------------------");
					}					
					
					Cell destinationCell = this.getBoard().getCell(destinationIndex);
					destinationCell.welcomePlayer(p);
					
					
					// On v�rifie si le joueur est gagnant : 
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