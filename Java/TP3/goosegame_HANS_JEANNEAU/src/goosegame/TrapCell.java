package goosegame;

/**
 *Classe TrapCell d�finissant les cases "pi�ge", sur lesquelles le joueur ne pourra plus jouer 
 *tant qu�il restera dans cette case (donc jusqu'� ce qu�un autre joueur tombe �galement 
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
	// M�thode canBeLeft toujours � false pour TrapCell (case pi�ge)
	public boolean canBeLeft() {
		//Retourne toujours false tant que le joueur est sur la case "pi�ge"
		return false;
	}
	/**
	 * Handle Move retourne simplement l'indice de la case pour une case "pi�ge". 
	 */
	public int handleMove(int diceThrow) {
		System.out.println(" (trap) ");
		return this.index;
	}
}
