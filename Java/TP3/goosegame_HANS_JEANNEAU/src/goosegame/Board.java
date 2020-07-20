package goosegame;
/**
 * Classe Board qui permet de représenter le plateau de jeu contenant les différentes cases 
 * 
 * @author Adrien et Tanguy
 */

public abstract class Board {
	
	//Attribut : nombre de cases du plateau 
	protected final int nbOfCells;
	//Cases du jeu
	protected Cell[] theCells;
	
	
	// Constructeur Board(nbOfCells : int)
	public Board(int nbCells){
		this.nbOfCells=nbCells;
	}
	
	
	
	// Méthode initBoard() qui construit le plateau suivant celui voulu
	protected abstract void initBoard(); 
	
	
	// getter getCell(n : int) : Cell 
	public Cell getCell(int n) {
		return this.theCells[n];
		
	}
	
	//getter getNbOfCells() : int
	public int getNbOfCells() {
		return this.nbOfCells;
	}
	

	// setter pour définir les cases du jeu :
	public void setTheCells(Cell[] cells) {
		this.theCells=cells;
	}	
	
}
