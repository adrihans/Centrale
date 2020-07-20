package goosegame;

public class NormalCell implements Cell {
	// Attributs de la classe NormalCell :
	protected Player thePlayer;
	protected int index; 
	
	// Constructeur pour une case "normale" : 
	public NormalCell(int i) {
		this.index =i;
		this.thePlayer=null;
	}	
	
	/**
	 * Méthode canBeLeft() pour une case normale
	 * @return true, boolean, par défaut pour une case normale le joueur peut quitter
	 * (de même pour une case "de teleportation" et une case "oie")
	 */
	public boolean canBeLeft() {
		return true;
	}
	
	/**
	 * @return index, l'indice de la case
	 */
	public int getIndex() {
		return this.index;
	}

	
	/**
	 * Handle Move retourne simplement l'indice de la case pour une case normale. 
	 */
	public int handleMove(int diceThrow) {
		System.out.println("  ");
		return this.index;
	}

	
	
	/**
	 * La méthode isBusy retourne true si un joueur est sur la case
	 */
	public boolean isBusy() {
		if (this.thePlayer==null) {
			return false;
		}
		//return this.thePlayer!=null;
		else {
		return this.thePlayer.getCell().getIndex()==this.index;
	}
	}


	/**
	 * welcomePlayer permet de gérer ce qu'il ce passe quand un joueur arrive sur la case
	 * @param : player, Player, le nouveau joueur sur la case
	 */
	public void welcomePlayer(Player player) {	
		
		if (this.isBusy() == true) {
			Player playerToTakeOff = this.getPlayer();
			//Si le joueur rebondit plusieurs fois et atteint la même case que précédemment, on ne fait rien. 
			if (playerToTakeOff != player) {
				System.out.print("                        " +"cell is busy...");
				Cell cellToSend = player.getCell();
				playerToTakeOff.setCell(cellToSend);
				System.out.println(" "+playerToTakeOff.toString() + " is sent to cell " + cellToSend.getIndex() + ".");
			}
		}
		player.setCell(this);
		this.thePlayer=player;
	}

	/**
	 * Retourne le joueur sur cette case, et null s'il n'y en a pas. 
	 */
	public Player getPlayer() {
		return this.thePlayer;
	}
	

}
