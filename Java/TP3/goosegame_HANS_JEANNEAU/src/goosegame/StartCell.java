package goosegame;

public class StartCell implements Cell {
	
	//Constructeur : 
	public StartCell() {
		
	}
	
	public boolean canBeLeft() {
		// CanBeLeft renvoie toujours true pour la case d�part
		return true;
	}

	/**
	 * @return l'indice de la case, c'est � dire 0
	 */
	public int getIndex() {
		return 0;
	}
	
	/**
	 * @return 0, l'indice de la case d�part
	 */
	public int handleMove(int d) {
		return 0;
	}


	public boolean isBusy() {
		// isBusy renvoie toujours false pour la case d�part
		return false;
	}

	
	public void welcomePlayer(Player p) {
		// welcomePlayer ne renvoie rien pour la case d�part
		p.setCell(this);
	}

	//geter getPlayer() 
	public Player getPlayer() {
		return this.getPlayer();
	}
	
}
