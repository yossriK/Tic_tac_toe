import java.io.IOException;
/**
 * Referee class, holds xPlayer and oPlayer objects in addiotion to board
 * related to player in an association link
 * 
 * @author yossri khalil
 *
 */

public class Referee {

	private Board board;
	private Player xPlayer;
	private Player oPlayer;
	
	public Referee() {
		
		
	}
	/**
	 * sets the player opponent, or links the two players together
	 * calls for the play() method in class Player to start the game
	 * 
	 * @throws IOException
	 */
	
	void runTheGame() throws IOException {
		//  b
		getxPlayer().setOpponent(oPlayer);
		oPlayer.setOpponent(getxPlayer());
		xPlayer.play();
		
		
		
		
		
	}
	/**
	 * setter function : sets the oPlayer
	 * 
	 * @param oPlayer : type Player
	 */
	
	void setoPlayer( Player oPlayer) {
		
	this.oPlayer=oPlayer;
	
	}
	/**
	 * setter function: sets the xPlayer
	 * 
	 * @param xPlayer: type Player
	 */
	
	void setxPlayer( Player xPlayer) {
		
		this.xPlayer=xPlayer;
		
		}
	/**
	 * 
	 * displays the first board game 
	 * @param board
	 */
	void setBoard(Board board) {
		board.display();
		this.board=board;
		
		
		
	}
 /**
  * getter function: added in case, but not really needed
  *  
  * @return xPlayer
  */
	public Player getxPlayer() {
		return xPlayer;
	}
	
	/**
	 * getter function: not really needed, added in case
	 * 
	 * @return oPlayer
	 */
	public Player getoPlayer() {
		return oPlayer;
	}
		

}
