

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 
/**
 *  class Board carrying methods responsible for creating and displaying the tic tac toe gameboard, 
 * checking for wins or losses, checking the markCount for the 9 boxes, and displaying the users input
 * 
 * 
 * @author yossri khalil
 * 
 *
 */


public class Board implements Constants {
	private char theBoard[][];
	private int markCount;
	private int rowBlocked;
	private int colBlocked;
	private int rowWin;
	private int colWin;
	
	/**
	 * sets the row to be blocked
	 * @param row
	 */
	public void setRowBlocked(int row) {
		this.rowBlocked=row;
	}
	/**
	 * sets the column to be blocked
	 * @param col
	 */
	public void setColBlocked(int col) {
		this.colBlocked=col;
	}
	
	public int getRowBlocked() {
		return this.rowBlocked;
	}
	
	
	public int getColBlocked() {
		return this.colBlocked;
	}
	private void setRowWin(int r) {
		this.rowWin=r;
		
	}
	private void setColWin(int c) {
		this.colWin=c;
		
	}
	public int getRowWin() {
		return this.rowWin;
	}
	
	
	public int getColWin() {
		return this.colWin;
	}
	
	
/**
 * constructor of class board, that sets markCount to zero, and initilazies 2D char matrix that will hold either x or o
 * 
 * 
 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
/**
 * 
 * 
 * @param row : specific row in the matrix
 * @param col : specific column in the matrix
 * @return : the content of that box in the matrix, either x or o
 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
 /**
  * 
  * 
  * @return true if the game board is filled with x's and o's ( the 9 slots are filled), else returns false
  */
	public boolean isFull() {
		return markCount == 9;
	}
/**
 * 
 * 
 * 
 * @return retruns true if the x player won i.e. filled 3 boxes diagonally, vertically or horizontally with x's, else retruns false and the game keeps going
 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
/**
 * 
 * @return retruns true if the o player won i.e. filled 3 boxes diagonally, vertically or horizontally with o's, else retruns false and the game keeps going
 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
 /**
  * displays the table each time called with filled boxes containing either x or o
  * 
  * 
  */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}
 /**
  * 
  * 
  * @param row : selected row by the user
  * @param col : selected column by the user
  * @param mark : selected mark character by the user( x or o)
  *  promises: fills that selected box with the chosen mark and increments the total count of marks in the table
  */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
 /**
  * clears the table, sets a new empty table
  * 
  * 
  */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
 /**
  * 
  * 
  * 
  * @param mark letter(x or o) passed from the OWins or XWins method  
  * @return 1 if the x or o player( depending on the mark passed) filled 3 boxes diagonally, vertically or horizontally with x's or o's respectively, else returns 0
  */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
 /**
  * displays column headers
  * 
  * 
  */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
 /**
  * 
  * displays hyphens for the board game
  */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
 /**
  * 
  * adds appropriate spaces between boxes
  */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
	/**
	 * to be used by blocking player\
	 * tests if there should be any spot to be blocked, if there exists it sets thes vlaue of col and row in 
	 * rowBlocked and colBlocked, player can call these using getters
	 *@param mark to be checked 
	 * @return if there exists a value to be blocked returns true, else false
	 * 
	 */
	public boolean testForBlocking( char mark) {
		int row, col;
		int result = 0;
		int row_result=0,col_result=0, diag_result=0;
		// traversing row by row
		for (row = 0;  row < 3; row++) {
			row_result=0;
			for (col = 0;  col < 3; col++)
				if (theBoard[row][col] == mark)
					row_result ++;			// will check if two occurences of the mark appeard in the column
			if (row_result == 2) { // at this point i already know i have to block something, i need to search for it			
				for(int c=0;c<3;c++) {   // search loop to search that specific row for empty spot
					if(theBoard[row][c]==' ') {
						this.setColBlocked(c);  
						this.setRowBlocked(row);
						return true;
					}
				}
			}
		}
		
		
		//traversing column by column
		for (col = 0;  col < 3; col++) {
			col_result=0;
			for (row = 0;  row < 3; row++)
				if (theBoard[row][col] == mark)
					col_result ++;			// will check if two occurences of the mark appeard in the column
			if (col_result == 2) { // at this point i already know i have to block something, i need to search for it			
				for(int r=0;r<3;r++) {   // search loop to search that specific row for empty spot
					if(theBoard[r][col]==' ') {
						this.setColBlocked(col);  
						this.setRowBlocked(r);
						return true;
					}
				}
			}
			
		}
		
		// traversing diagonals
		for(int i=0;i<3;i++) {
			if(theBoard[i][i]==mark)
				diag_result++;
			
			if(diag_result==2) {
				for( int r=0;r<3;r++) {
					if (theBoard[r][r]==' ') {
						this.setColBlocked(r);  
						this.setRowBlocked(r);
						return true;
					}
				}
			}
				
			
		}
		// traversing 
		for(int i=0;i<3;i++) {
			if(theBoard[i][3-1-i]==mark)
				diag_result++;
			
			if(diag_result==2) {
				for( int r=0;r<3;r++) {
					if (theBoard[r][3-1-r]==' ') {
						this.setColBlocked(3-1-r);  
						this.setRowBlocked(r);
						return true;
					}
				}
			}
				
			
		}
		
		return false;    
	}
	
	
	public boolean testForWinning( char mark) {
		int row, col;
		int result = 0;
		int row_result=0,col_result=0, diag_result=0;
		// traversing row by row
		for (row = 0;  row < 3; row++) {
			row_result=0;
			for (col = 0;  col < 3; col++)
				if (theBoard[row][col] == mark)
					row_result ++;			// will check if two occurences of the mark appeard in the column
			if (row_result == 2) { // at this point i already know i have to block something, i need to search for it			
				for(int c=0;c<3;c++) {   // search loop to search that specific row for empty spot
					if(theBoard[row][c]==' ') {
						this.setColWin(c);  
						this.setRowWin(row);
						return true;
					}
				}
			}
		}
		
		
		//traversing column by column
		for (col = 0;  col < 3; col++) {
			col_result=0;
			for (row = 0;  row < 3; row++)
				if (theBoard[row][col] == mark)
					col_result ++;			// will check if two occurences of the mark appeard in the column
			if (col_result == 2) { // at this point i already know i have to block something, i need to search for it			
				for(int r=0;r<3;r++) {   // search loop to search that specific row for empty spot
					if(theBoard[r][col]==' ') {
						this.setColWin(col);  
						this.setRowWin(r);
						return true;
					}
				}
			}
			
		}
		
		// traversing diagonals
		for(int i=0;i<3;i++) {
			if(theBoard[i][i]==mark)
				diag_result++;
			
			if(diag_result==2) {
				for( int r=0;r<3;r++) {
					if (theBoard[r][r]==' ') {
						this.setColWin(r);  
						this.setRowWin(r);
						return true;
					}
				}
			}
				
			
		}
		// traversing 
		for(int i=0;i<3;i++) {
			if(theBoard[i][3-1-i]==mark)
				diag_result++;
			
			if(diag_result==2) {
				for( int r=0;r<3;r++) {
					if (theBoard[r][3-1-r]==' ') {
						this.setColWin(3-1-r);  
						this.setRowWin(r);
						return true;
					}
				}
			}
				
			
		}
		
		return false;
	}
	
	
	
}
