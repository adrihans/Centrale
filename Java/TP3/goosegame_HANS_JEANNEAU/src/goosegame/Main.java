package goosegame;

/**
 * Classe main pour lancer et executer une partie 
 * @author adrien et Tanguy
 *
 */

public class Main {

	public static void main(String[] args) {
		
		// On créé le plateau sur lequel on joue : 
		Board board = new ClassicalBoard();
		// On initialise le jeu avec le plateau créé : 
		Game game = new Game(board);
		game.getBoard().initBoard();
		// On défini les joueurs : 
		Player firstPlayer = new Player("Adrien");
		Player secondPlayer = new Player("Tanguy");
		Player thirdPlayer = new Player("Toto");
		// On ajoute les joueurs au jeu : 
		game.addPlayer(firstPlayer);
		game.addPlayer(secondPlayer);
		game.addPlayer(thirdPlayer);
		
		// On joue : 
		game.play();
		System.out.println("end");

	}

}
