/**
 * inherits almost everything from player, 
 * overriden makeMove()
 * 
 * @author yossri
 * @version 2.0
 *
 */
public class RandomPlayer  extends Player{
	
	private RandomGenerator ran=  new RandomGenerator();
	/**
	 * 
	 * @param name of player
	 * @param mark of player
	 */
	public RandomPlayer(String name, char mark) {
		super(name,mark);
	}
	
	/**
	 * overriden makeMove for randomplayer, 
	 * should generate random moves within limits of the box and 
	 * and should check if that spot is empty
	 */
	@Override 
	public void makeMove() {
		int row=0;//ran.discrete(0, 2);
		int col=0;//ran.discrete(0,2);
		Board theBoard=super.getBoard();
		while(theBoard.getMark(row,col)!=' ') {
			row=ran.discrete(0, 2);
			col=ran.discrete(0, 2);
		}
		
		theBoard.addMark(row, col, super.getPlayerMark());
	    theBoard.display();
		
	}
	
	
	

}
