package goosegame;
/**
 * Classe GooseCell d�finissant les cases "oie", sur lesquelles , le joueur double le score 
 * du d� et � rebondit � donc en avan�ant encore son pion d�autant de cases qu�indiqu� 
 * par les d�s.
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
	 * M�thode handleMove 
	 * On doit g�rer la case 54 qui peut faire rebondir jusqu'� en dehors du plateau, 
	 * ce qui n'est pas v�rifi� "en cascade" par play() de la classe Game.
	 * @param : d,int, le lancer de d�s 
	 * @return : newIndex, int, l'indice de la nouvelle case 
	 */
	public int handleMove(int d) {
		
		int newIndex = this.getIndex()+d;	
		System.out.println(" (goose !) and jumps to cell " + newIndex +	 " "); 
		return newIndex;		
	}

}
