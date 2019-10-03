import java.util.List;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel {
	private int [][] board;
	private List<Coordinate> moves;
	private BufferedImage welcomePage = null;
	private BufferedImage instructionsPage = null;
	private BufferedImage player1Wins = null;
	private BufferedImage player2Wins = null;
	public static final int COURT_WIDTH = 600;
    public static final int COURT_HEIGHT = 535;
    
    

    private int currColumn; 
    
    
    
    private boolean player1turn;
    
     // Current status text, i.e. "Running..."
	private boolean undoClicked = true;
	
	
	private boolean instructions = false;
	private boolean start;

	
	public Board (JLabel status) {
		//list of all the moves that the players make
		moves = new LinkedList<Coordinate>();
		board = new int [6][7];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = 0; 
				//initially sets each element to 0, indicating an empty slot
			}
		}
		try {
			welcomePage = (ImageIO.read(new File("files/gameHome2.jpg")));
			instructionsPage = (ImageIO.read(new File("files/instructionsConnect4.jpg")));
			player1Wins = (ImageIO.read(new File("files/player1Won.jpg")));
			player2Wins = (ImageIO.read(new File("files/player2Won.jpg")));


		} catch (FileNotFoundException e1) {
			System.out.println("File not Found");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Invalid Image");
		}
		player1turn = true;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        repaint(); 
        
	
	}
	
	
	
	public void startGame() {
		//used in repaint, for button, if this method is true thus
		//the button has been pushed and the board will be displayed
		start=true;
		
	}
	
	protected void showInstructions() {
		
		instructions=true;
	}
	
	protected void setColumn(int currColumn) {
	
		this.currColumn = currColumn; 
	}
	
	/*protected void setElement(int x, int y, int val) {
		board[x][y]=val;
	} */
	
	protected int [][] getBoard() {
		return board;
	}
	protected void flipState() {
		//after a move has been made, will change the state, thus the color of the filled circle will now change
		player1turn=!player1turn;
	}
	
	protected boolean returnPlayer1State() {
		if (player1turn==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int whoseTurn() {
		if (player1turn) {
			return 1;
		}
		else {
			return 2;
		}
	}

	
	
	
	public boolean checkWin() {
		//check the horizontal 
		

		for (int x=5; x>=0; x--) {
			for (int y=0; y<4; y++) {
				if (board[x][y] == board[x][y+1] && board[x][y] == board[x][y+2]
				    && board[x][y] == board[x][y+3] && board[x][y] != 0) 
				{
					
					return true;
				}
			}
		}
		
		//check vertical 
		for (int x=5; x>=3; x--) {
			for (int y=0; y<7; y++) {
				if (board[x][y] == board[x-1][y] && board[x][y] == board[x-2][y]
				    && board[x][y] == board[x-3][y] && board[x][y] != 0) 
				{

					return true;
				}
			}
		}
		
		
		//descending diagonals
		for (int x=0; x<3; x++) {
			for (int y=0; y<4; y++) {
				if (board[x][y] == board[x+1][y+1] && board[x][y] == board[x+2][y+2]
					&& board[x][y] == board[x+3][y+3] && board[x][y] != 0) 
				{
					return true;
				}
			}
		}
		//ascending diagonals
		for (int x=0; x<6; x++) {
			for (int y=0; y<7; y++) {
				if ((x-3>0) && (y+3<7)) {
					if (board[x][y] == board[x-1][y+1] && board[x][y] == board[x-2][y+2]
					    && board[x][y] == board[x-3][y+3] && board[x][y] != 0) 
					{
						
						return true;
					}
				}
			}
		}
		return false;
		
		
	}

	
	
	//similar to previous method, except returns an int, signifying the winner
	public int whoWon() {
		//check the horizontal 
		

		for (int x=5; x>=0; x--) {
			for (int y=0; y<4; y++) {
				if (board[x][y] == board[x][y+1] && board[x][y] == board[x][y+2]
				    && board[x][y] == board[x][y+3] && board[x][y] != 0 && board[x][y]==1) 
				{
					
					return 1;
				}
				else if(board[x][y] == board[x][y+1] && board[x][y] == board[x][y+2]
					    && board[x][y] == board[x][y+3] && board[x][y] != 0 && board[x][y]==2) 
				{
						
					return 2;
				}
			}
			
		}
		
		//check vertical 
		for (int x=5; x>=3; x--) {
			for (int y=0; y<7; y++) {
				if (board[x][y] == board[x-1][y] && board[x][y] == board[x-2][y]
				    && board[x][y] == board[x-3][y] && board[x][y] != 0 && board[x][y]==1) 
				{

					return 1;
				}
				else if (board[x][y] == board[x-1][y] && board[x][y] == board[x-2][y]
					    && board[x][y] == board[x-3][y] && board[x][y] != 0 && board[x][y]==2) 
					{

						return 2;
					}
			}
		}
		
		
		//descending diagonals
		for (int x=0; x<3; x++) {
			for (int y=0; y<4; y++) {
				if (board[x][y] == board[x+1][y+1] && board[x][y] == board[x+2][y+2]
					&& board[x][y] == board[x+3][y+3] && board[x][y] != 0 && board[x][y]==1) 
				{
					return 1;
				}
				else if (board[x][y] == board[x+1][y+1] && board[x][y] == board[x+2][y+2]
						&& board[x][y] == board[x+3][y+3] && board[x][y] != 0 && board[x][y]==2) 
					{
						return 2;
					}
			}
		}
		//ascending diagonals
		for (int x=0; x<6; x++) {
			for (int y=0; y<7; y++) {
				if ((x-3>0) && (y+3<7)) {
					if (board[x][y] == board[x-1][y+1] && board[x][y] == board[x-2][y+2]
					    && board[x][y] == board[x-3][y+3] && board[x][y] != 0 && board[x][y]==1) 
					{
						
						return 1;
					}
					else if (board[x][y] == board[x-1][y+1] && board[x][y] == board[x-2][y+2]
						    && board[x][y] == board[x-3][y+3] && board[x][y] != 0 && board[x][y]==2) 
						{
							
							return 2;
						}
				}
			}
		}

		return 0;
		
	}	
	
	//adds to the list of moves, and also flips the state, so that it is the other player's turn after the current move has been made
	
	public void makeMove() {
		int lastRow = 0; 
		if(board[0][currColumn] != 0) {
			flipState();
			return;
		}
		
		for(int i = 1 ; i < board.length; i++) {
			if(board[i][currColumn] == 0) {
				lastRow++;  
			}
		}
		System.out.println("lastRow: " + (lastRow+1));
		if(player1turn) {
			board[lastRow][currColumn] = 1;
			//fills the array with either a 1 or a 2, depending on which player made the turn
			Coordinate currMove = new Coordinate(currColumn, lastRow);
			moves.add(currMove);
		}else{
			board[lastRow][currColumn] = 2; 
			Coordinate currMove = new Coordinate(currColumn, lastRow);
			moves.add(currMove);
		} 
		if(checkWin()) {
			System.out.println("THIS IS WINNER"+ board[lastRow][currColumn]);
		}
		
		undoClicked = true;
	}
	
	protected void setElement(int row, int column, int val) {
		board[row][column]=val;
	}

	
	
	public void undo() {
		//checking to see if the button has been clicked, and if so, the previous move will be removed from the list 
		if(undoClicked == true) {
			Coordinate badMove = moves.remove(moves.size()-1);
			board[badMove.getY()][badMove.getX()]=0;
		}
		repaint();
		
	}
	
	public void reset () {
		//sets all elements in the array to 0
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = 0; 
			}
		}
		repaint(); 
	}
	
	public void write () throws IOException {
		BufferedWriter outputwriter = null;
	    outputwriter = new BufferedWriter(new FileWriter("/Users/ssd/eclipse-workspace/ConnectFour/src/savedGame.txt"));
	    for (int i=0; i<board.length; i++) {
	    	for (int j=0; j<board[0].length; j++) {
	    		outputwriter.write(Integer.toString(board[i][j]) + ":");
	    	}
	    	outputwriter.newLine();
	    }
	    outputwriter.flush();
	    outputwriter.close();
	}
	
	public void read() throws FileNotFoundException {
	
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader("/Users/ssd/eclipse-workspace/ConnectFour/src/savedGame.txt"));
		int [][] loadedBoard = new int [6][7];
		String nextLine;
		try {
			int j = 0; 
			nextLine = reader.readLine();
			while(nextLine != null) {
				String[] numberStrings = nextLine.split(":");
				
				for(int i = 0; i <7; i++) {
					loadedBoard[j][i] = Integer.parseInt(numberStrings[i].trim()); 
				}
				nextLine = reader.readLine();
				j++; 
			}
			System.out.println("THIS IS LOADED ARRAY");
			for(int i = 0; i < loadedBoard.length; i++) {
				for(int z = 0; z < loadedBoard[0].length; z++) {
					System.out.print(loadedBoard[i][z] + " "); 
				}
				System.out.println();
			}
			board = loadedBoard;
			repaint();
			reader.close();
		} catch (IOException e) {
			System.out.println("Invalid file");
			e.printStackTrace();
		}
		
		
	}
	
	
	public void stopShowingInstructions() {
		instructions = false;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(instructions) {	
			g.drawImage(instructionsPage, 0, 0, COURT_WIDTH, COURT_HEIGHT, null);		
		}
		else if(!start) {
			g.drawImage(welcomePage, 0, 0, COURT_WIDTH, COURT_HEIGHT, null);
		}
		else if(whoWon()==1) {
			g.drawImage(player1Wins, 0, 0, COURT_WIDTH, COURT_HEIGHT, null);
		}
		else if (whoWon()==2) {
			g.drawImage(player2Wins, 0, 0, COURT_WIDTH, COURT_HEIGHT, null);

		}
		else{
		//draws the circles depending on if the element is 0 (white, because that slot is empty)
		// 1, if it was player 1's turn-then the circle will be red
		//2, if it was player 2's turn-then the circle will be yellow
		setBackground(Color.blue);
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
			if(board[i][j]== 1){
				g.setColor(Color.RED);
				g.fillOval((j*80) + 27, (i*85) + 10, 65,65);
			}else if(board[i][j]== 2){
				g.setColor(Color.YELLOW);
				g.fillOval((j*80) + 27, (i*85) + 10, 65,65);
			}
			else if((board[i][j]== 0)){
				g.setColor(Color.WHITE);
				g.fillOval((j*80) + 27, (i*85) + 10, 65,65);
			}
		}
		}	
	}
		

	}
	public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }

	public void setUndoClicked(boolean b) {
		undoClicked = b; 
		
	}

	public boolean getUndoClick() {
		return undoClicked;
	}
	
	
	

}
