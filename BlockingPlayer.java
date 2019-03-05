
public class BlockingPlayer extends RandomPlayer{
	
	
	public BlockingPlayer(String name, char mark) {
		super(name,mark);
	}

	@Override
	 public void makeMove() {
		
		boolean stas=super.getBoard().testForBlocking(super.getOppMark());
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
