import static org.junit.Assert.*;


import javax.swing.JLabel;

import org.junit.Test;
public class myTests {
	
	@Test
	public void testgetX() {
		//testing the coordinate class and its constructor
		Coordinate coor = new Coordinate(5,6);
		//testing if getX works
		assertEquals(coor.getX(), 5);
		
	}
	
	@Test
	public void testgetY() {
		//testing the coordinate class and its constructor
		Coordinate coor = new Coordinate(5,6);
		//testing if getY works
		assertEquals(coor.getY(), 6);
		
	}
	

	@Test
	public void testSetColumn() {
		Board testBoard = new Board(new JLabel());
		int[][] checkWith = testBoard.getBoard();
		testBoard.setColumn(5);
		testBoard.makeMove();
		
		//setting column where the move is made to fifth
		//the chip will automatically get dropped into the lowest slot
		checkWith = testBoard.getBoard();
		assertEquals(checkWith[5][5], 1);
	
	}
	
	
	
	@Test
	public void testGetBoard() {
		//tests that the board is retrieved
		Board testBoard = new Board(new JLabel());
		int[][] checkWith = testBoard.getBoard();
		testBoard.setColumn(5);
		testBoard.makeMove();
		checkWith = testBoard.getBoard();
		assertEquals(checkWith[5][5], 1);
	
	}
	
	@Test
	public void testreturnPlayer1State() {
		//tests that the state of the boolean is true, meaning that
		//the first move will be player 1's
		Board testBoard = new Board(new JLabel());
		assertEquals(testBoard.returnPlayer1State(), true);
	}
	
	@Test
	public void testFlipState() {
		//tests that the state of the boolean is true, meaning that
		//after the first player moves it will be the second player's turn	
		Board testBoard = new Board(new JLabel());
		testBoard.flipState();
		assertEquals(testBoard.returnPlayer1State(), false);
	}
	
	@Test
	public void testWhoseTurn() {
		Board testBoard = new Board(new JLabel());
		testBoard.setColumn(5);
		testBoard.makeMove();
		//tests that 1 is returned from whoseTurn
		assertEquals(testBoard.whoseTurn(), 1);
	
	}
	
	@Test
	public void testCheckHorizontalWhoWon() {
		//sets the array equal to a vertical win
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(0, 3, 1);
		testBoard.setElement(0, 4, 1);
		testBoard.setElement(0, 5, 1);
		testBoard.setElement(0, 6, 1);
		//tests to see if whoWon returns the correct integer, indicating which player won
		assertEquals(testBoard.whoWon(),1);
	
	}
	@Test
	public void testCheckVerticalWhoWon() {
		//sets the array equal to a horizontal win
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(0, 6, 1);
		testBoard.setElement(1, 6, 1);
		testBoard.setElement(2, 6, 1);
		testBoard.setElement(3, 6, 1);
		//tests to see if whoWon returns the correct integer, indicating which player won
		assertEquals(testBoard.whoWon(), 1);
	
	}
	
	@Test
	public void testCheckDiagonalWhoWon() {
		//sets the array equal to a horizontal win
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(5, 0, 1);
		testBoard.setElement(4, 1, 1);
		testBoard.setElement(3, 2, 1);
		testBoard.setElement(2, 3, 1);
		//tests to see if whoWon returns the correct integer, indicating which player won
		assertEquals(testBoard.whoWon(), 1);
	
	}
	
	@Test
	public void testCheckDiagonalWin() {
		//sets the array equal to a horizontal win
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(5, 0, 1);
		testBoard.setElement(4, 1, 1);
		testBoard.setElement(3, 2, 1);
		testBoard.setElement(2, 3, 1);
		//tests that the boolean returned from if there is a win is true
		assertEquals(testBoard.checkWin(), true);
	
	}
	
	@Test
	public void testCheckHorizontalWin() {
		//sets the array equal to a vertical win
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(0, 3, 1);
		testBoard.setElement(0, 4, 1);
		testBoard.setElement(0, 5, 1);
		testBoard.setElement(0, 6, 1);
		//tests that the boolean returned from if there is a win is true
		assertEquals(testBoard.checkWin(),true);
	
	}
	@Test
	public void testCheckVerticalWin() {
		//sets the array equal to a vertical win
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(0, 6, 1);
		testBoard.setElement(1, 6, 1);
		testBoard.setElement(2, 6, 1);
		testBoard.setElement(3, 6, 1);
		//tests that the boolean returned from if there is a win is true
		assertEquals(testBoard.checkWin(), true);
	
	}
	@Test
	public void testCheckNotAWin() {
		//checks to see if an incomplete game registers as win(it shouldn't)
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(0, 6, 1);
		testBoard.setElement(1, 6, 1);
		testBoard.setElement(2, 6, 1);
		//tests that the boolean returned from if there is not a win is false
		assertEquals(testBoard.checkWin(), false);
	
	}
	@Test
	public void testmakeMove() {
		Board testBoard = new Board(new JLabel());
		testBoard.setColumn(5);
		testBoard.makeMove();
		int[][] checkWith=testBoard.getBoard();
		//checking that when a move is made, the element of the array is set to 1
		assertEquals(checkWith[5][5], 1);
	
	}
	

	
	
	@Test
	public void testReset() {
		Board testBoard = new Board(new JLabel());
		testBoard.setElement(3,3,2);
		testBoard.reset();
		int[][] checkWith=testBoard.getBoard();
		//testing that resets the board, setting every element in the array equal to 0
		assertEquals(checkWith[3][3], 0);
	
	}
	@Test
	public void testUndo() {
		Board testBoard = new Board(new JLabel());
		testBoard.setColumn(5);
		testBoard.makeMove();
		testBoard.undo();
		int[][] checkWith=testBoard.getBoard();
		//after 1 move is undone, the board is empty
		assertEquals(checkWith[5][5], 0);
	
	}
	
	

}
