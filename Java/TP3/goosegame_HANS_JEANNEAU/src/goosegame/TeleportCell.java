package goosegame;
/** 
 *Classe TeleportCell définissant les cases "de téléportation", sur lesquelles le pion 
 *"rebondit" jusqu'à une autre case prédéfinie. 
 * 
 * @author Adrien et Tanguy
 */



public class TeleportCell extends NormalCell implements Cell {
	// Attribut dest pour la destination
	protected final int dest;
	
	// Constructeur :
	public TeleportCell(int i, int d) {
		super(i);
		this.dest=d;
	}
	
	/**
	 * Méthode handleMove pour TeleportCell : 
	 * @return : this.dest, int, la case de destination finale
	 */
	public int handleMove(int i) {
		System.out.println(" (teleport to " +this.dest + ") "); 
		return this.dest;
	}
}