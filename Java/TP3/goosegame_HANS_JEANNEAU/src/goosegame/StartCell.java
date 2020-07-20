package goosegame;

public class StartCell implements Cell {
	
	//Constructeur : 
	public StartCell() {
		
	}
	
	public boolean canBeLeft() {
		// CanBeLeft renvoie toujours true pour la case départ
		return true;
	}

	/**
	 * @return l'indice de la case, c'est à dire 0
	 */
	public int getIndex() {
		return 0;
	}
	
	/**
	 * @return 0, l'indice de la case départ
	 */
	public int handleMove(int d) {
		return 0;
	}


	public boolean isBusy() {
		// isBusy renvoie toujours false pour la case départ
		return false;
	}

	
	public void welcomePlayer(Player p) {
		// welcomePlayer ne renvoie rien pour la case départ
		p.setCell(this);
	}

	//geter getPlayer() 
	public Player getPlayer() {
		return this.getPlayer();
	}
	
}
