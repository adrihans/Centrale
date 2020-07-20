package goosegame;

public class ClassicalBoard extends Board {
	
	//Contructeur : 
	public ClassicalBoard() {
		super(64);
	}
	
	protected void initBoard() {
		Cell[] myCells = new Cell[64];
		
		//Case départ : 
		myCells[0]=new StartCell();
				
		for (int i=1;i<64;i++) {
			myCells [i]=new NormalCell(i);
		}
		
		//Définition des cases "oie"
		int[] gooseCells = {9,18,27,36,45,54};
		
		for (int i : gooseCells) {
			myCells [i] = new GooseCell(i);
		}
		
		// Cases "d'attente"
		myCells[19] = new WaitingCell(19,2);
				
		//Cases "piège"
		myCells[31]=new TrapCell(31);
		myCells[52]=new TrapCell(52);
		
		//Cases "de téléportation" : 

		myCells[6] = new TeleportCell(6,12);
		myCells[42] = new TeleportCell(42,30);
		myCells[58] = new TeleportCell(58,1);
		
		this.setTheCells(myCells);
	}
	
}
