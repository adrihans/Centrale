package goosegame;
/**
 * Classe GooseCell définissant les cases "oie", sur lesquelles , le joueur double le score 
 * du dé et « rebondit » donc en avançant encore son pion d’autant de cases qu’indiqué 
 * par les dés.
 * 
 * 
 * @author Adrien et Tanguy
 */

public class GooseCell extends NormalCell implements Cell {
	//Constructeur de la classe GooseCell : 
	public GooseCell(int i) {
		super(i);
	}
	
	/**
	 * Méthode handleMove 
	 * On doit gérer la case 54 qui peut faire rebondir jusqu'à en dehors du plateau, 
	 * ce qui n'est pas vérifié "en cascade" par play() de la classe Game.
	 * @param : d,int, le lancer de dés 
	 * @return : newIndex, int, l'indice de la nouvelle case 
	 */
	public int handleMove(int d) {
		
		int newIndex = this.getIndex()+d;	
		System.out.println(" (goose !) and jumps to cell " + newIndex +	 " "); 
		return newIndex;		
	}

}
