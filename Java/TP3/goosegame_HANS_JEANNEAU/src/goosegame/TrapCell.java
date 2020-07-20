package goosegame;

/**
 *Classe TrapCell définissant les cases "piège", sur lesquelles le joueur ne pourra plus jouer 
 *tant qu’il restera dans cette case (donc jusqu'à ce qu’un autre joueur tombe également 
 *sur cette case). 
 * 
 * 
 * @author Adrien et Tanguy 
 */
public class TrapCell extends NormalCell implements Cell{
	//
	public TrapCell(int i){
		super(i);
	}
	// Méthode canBeLeft toujours à false pour TrapCell (case piège)
	public boolean canBeLeft() {
		//Retourne toujours false tant que le joueur est sur la case "piège"
		return false;
	}
	/**
	 * Handle Move retourne simplement l'indice de la case pour une case "piège". 
	 */
	public int handleMove(int diceThrow) {
		System.out.println(" (trap) ");
		return this.index;
	}
}
