
public class SmartPlayer extends BlockingPlayer {

	public SmartPlayer(String name, char mark) {
		super(name,mark);
	}
	
	@Override 
	public void makeMove() {
		boolean stas=super.getBoard().testForWinning(super.getPlayerMark());
		if(stas==true ) {
			int row= this.getBoard().getRowWin();
			int col= this.getBoard().getColWin();
			this.getBoard().addMark(row, col, super.getPlayerMark());
	    	this.getBoard().display();
	    	
		}
		else
			stas=super.getBoard().testForBlocking(super.getOppMark());
		if(stas==true ) {
			int row= this.getBoard().getRowBlocked();
			int col= this.getBoard().getColBlocked();
			this.getBoard().addMark(row, col, super.getPlayerMark());
	    	this.getBoard().display();
	    	
		}
		else
			super.makeMove();
		
		
		
		
	}

	
}
