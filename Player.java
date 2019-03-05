import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Class player holds name, mark and opponent variables of each player
 * referee uses play() method to start the game
 * 
 * @author yossri khalil
 *
 */


public class Player {

	private String name;
	private Board board;
	private  Player opponent;
	private char mark;
	
	/**
	 * default constructor, sets the name and the mark of the player
	 * 
	 * @param name : designated name of the player
	 * @param mark : designated mark to be assigned to the player
	 */
	public Player( String name, char mark) {
		this.name=name;
		this.mark=mark;
	}
	 /**
	  * setter function
	  * sets the name of the player
	  * @param name : string name of the player to be assigned
	  */
	public void setName( String name) {
		this.name=name;
	}
	/**
	 * 
	 * @return the specific mark assigned for that player
	 */
	 public char getPlayerMark() {
		 
		 return this.mark;
	 }
	/**
	 * getter function
	 * 
	 * @return name of the player
	 */
	public String getName() {
		
		return this.name;
	}
	
	/**
	 * sets the  player opponent  
	 * connects other player to this player
	 * @param opp : object of type player
	 */
	public void setOpponent( Player opp) {
		
		this.opponent=opp;
	}
	
	/**
	 * game logic: keeps playing until one player wins, or the whole board is marked
	 * calls makeMove() method and switches turn between players
	 * invoked by a player object
	 * 
	 * @throws IOException
	 */
	public void play() throws IOException {
		this.makeMove();
		Player nextPlayer= this.opponent;
		
		
		while(board.oWins()!= true && board.xWins()!=true && board.isFull()!= true) {
			nextPlayer.makeMove();
			nextPlayer= nextPlayer.opponent;
		}
		
	 if(board.oWins()==true) {
		 System.out.printf("%s is the winner \n", this.opponent.getName());		 
	 }
	 if(board.xWins()==true) {
		 System.out.printf("%s is the winner \n", this.getName());
	 }
	 
	 System.out.printf("Game Over");
		
	}
	 /**
	  * asks the player to move by entering the row and the column numbers
	  * adds the specific mark and displays the board,
	  * two int variables r and c created here to assign row and columen numbers
	  * 
	  * @throws IOException
	  */
	public void makeMove() throws IOException {
		int r,c;
		BufferedReader stdin;
		
		
		stdin = new BufferedReader(new InputStreamReader(System.in));		
		
		System.out.printf("%s ,what row should your next %c be placed in: ", this.name, this.mark);
		String input = stdin.readLine();
		r=Integer.parseInt(input);
		
		System.out.printf("%s ,what column should your next %c be placed in: ", this.name, this.mark);
		 input = stdin.readLine();
		 c=Integer.parseInt(input);
		 board.addMark(r, c, this.mark);
		 board.display();
	}
	 /**
	  * 
	  * assigns the latest copy of the game board to board attribute of each player
	  * @param board : type Board
	  */
	void setBoard(Board board) {
		this.board=board;
	
	}
	/**
	 * 
	 * @return board instance for the player
	 */
	public Board getBoard() {
		return board;
	}
	/**
	 * 
	 * @return opponent of that player
	 */
	public Player getOpp() {
		
		return opponent;
	}
	
	public char getOppMark() {
		if (this.mark=='O')
			return 'X';
		else
			return 'O';
		
		
	}
	
	
}
