package goosegame;
/** 
 *Classe TeleportCell d�finissant les cases "de t�l�portation", sur lesquelles le pion 
 *"rebondit" jusqu'� une autre case pr�d�finie. 
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
	 * M�thode handleMove pour TeleportCell : 
	 * @return : this.dest, int, la case de destination finale
	 */
	public int handleMove(int i) {
		System.out.println(" (teleport to " +this.dest + ") "); 
		return this.dest;
	}
}