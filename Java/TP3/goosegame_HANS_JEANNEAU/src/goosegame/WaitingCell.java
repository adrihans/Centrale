package goosegame;

/**
 * Classe WaitingCell d�finissant les cases d'attente, sur lesquelles le joueur reste 
 * bloqu� pendant un nombre de tours pr�d�fini pour chaque case (sauf si un autre joueur arrive 
 * sur cette case et le renvoie donc vers sa case initiale, c�est au joueur 
 * arrivant de se retrouver en attente pour le nombre de tours initialement pr�vu pour la case) 
 * 
 * @author Adrien et Tanguy
 */


public class WaitingCell extends NormalCell implements Cell {
	//Attributs de la classe WaitingCell : 
	protected final int NbRound;
	protected int timeToWait;
	
	//Constructeur : 
	public WaitingCell(int i, int n) {
		super(i);
		this.NbRound=n;
		this.timeToWait=n;
	}
	
	//M�thode canBeLeft : 
	public boolean canBeLeft() {
		if (this.timeToWait==0) {
			return true;
		}
		else {
			timeToWait=timeToWait-1;
			return false;
		}
	}
	
	//M�thode welcomePlayer(Player p) :
	public void welcomePlayer(Player p) {
		if (this.isBusy() == true) {
			Player playerToTakeOff = this.getPlayer();
			//Si le joueur rebondit plusieurs fois et atteint la m�me case que pr�c�demment, on ne fait rien. 
			if (playerToTakeOff != p) {
			System.out.print("                        " +"cell is busy...");
			Cell cellToSend = p.getCell();
			playerToTakeOff.setCell(cellToSend);
			System.out.println(" "+playerToTakeOff.toString() + " is sent to cell " + cellToSend.getIndex() + ".");
			//Ligne qui change par rapport � la version de la case "normale" : 
			//On r�initialise le temps � attendre : 
			this.timeToWait = this.NbRound;
			}
		}
		p.setCell(this);
		this.thePlayer=p;
	}
	
	/**
	 * Handle Move retourne simplement l'indice de la case pour une case d'attente. 
	 */
	public int handleMove(int diceThrow) {
		System.out.println(" (Waiting cell) number of rounds to wait : " + this.NbRound + " ");
		return this.index;
	}

	
	
}
