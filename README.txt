=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: 25976349
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. I used 2D Arrays to store the Connect4 board. If the slot is empty, the array stores a 0.
  	If it was Player 1's move, then the array stores a 1 in that spot, and if it was 
  	Player 2's move, the array stores a 2 in that spot. This allows one to easily reset the board, 
  	by setting all the elements in the array to 0 (through iteration via nested for loops).  Boards
  	are an appropriate use of 2D arrays because the state of the game is stored in a row and column,
  	which perfectly matches the format of the 2D array. 

  2. I used Collections, specifically, a LinkedList, to store the moves that players make. 
  	The List stores Objects of type Coordinate that have an (x,y) or (column, row) notation.
  	The LinkedList was useful because I could easily delete an element of the list in order
  	to undo the move using the "remove" functionality of a LinkedList. Every time a move was made, 
  	a new Coordinate was added to the list. 

  3. I used File I/O in order to store the state of the game if the player hits "Save." The state of the 
  	2D array is saved in a file and when the game is re-opened the state is translated into the array of the 
  	current board, loading the previous game. By clicking "Load", the user can reload the state of the previous
  	game if the board was reset or even if the game was exited. This is an appropriate demonstration for File IO
  	because it is very useful to have the saving component of a game. 

  4. The testable component of this game tests the game state after every method is executed. I tested all the 
  methods in the Board and Coordinate classes that handled array manipulation in order to gauge the functionality
  of my program. I tested to see if the board was returned, if booleans were true and false when it was player 1 
  and player 2's turn, respectively, if a win or move was registered and updated accordingly in the array. Being able to 
  test all these methods is very useful because it alludes to the overall efficiency and limits of the game, as well as
  letting me know of bugs in the code.   


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  
  The Coordinate class shows that the Coordinate Object has an X and a Y. The LinkedList of moves consist of objects of type 
  Coordinate. 
  
  The Board class is similar to the GameCourt class of Mushroom of Doom, and outlines the 2D array that stores
  the board of the game. There is a list of moves that is manipulated every time one makes a move, using the makeMove method;
  either a Coordinate is added to the list, or (using undo) removed from the list. Various other methods in the class deal with 
  the boolean fields initialized, asserting if the game has begun, when instructions are to be shown, and also to flip the state
  of a player's turn. The most lengthy and important method is the checkWin method, which checks to see if a player has won every 
  time a move is made. Overall, the purpose of the Board class to identify the state of the board and assert if a player has won. 
  
  The Setup class creates the labels, buttons, and frames that I use for the setup of the game. It is the heart of the Java Swing
  implementation of this project. Every time a button is clicked, a new Action Listener allows one to create an Action Performed method 
  method that denotes what the operation is performed on the board, such as undo, reset, or save. Another important function of this
  class is that other buttons are set to visible or invisible when certain other buttons are displayed, ensuring that the control
  panel is appropriate for the page that is being displayed- the Welcome page should not display the column buttons, and likewise, the 
  game page should not display the "Start" button. 


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  
  It was difficult to have the Undo method only remove the last move, so that the player cannot undo the other player's moves. 
  Additionally it was difficult to have a label that kept track of the current game state, because this meant that I had to involve 
  a timer in the game. 


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  
  My design is effective and comprehensive. The three different classes, Coordinate, Board, and Setup, each work to identify the 
  position of a slot, update and check for game state, and create the interface that the players interact with, respectively. 
  The private state encapsulation in this game is good because most of the fields and variables I have created are private and 
  are accessed through "get" methods. Also, I made several of the methods, such as setElement, showInstructions, getBoard, and flipState,
   protected so that users cannot access them. 
   I would refactor the whoWon method, if I had a chance; this method adds many more lines of
  code than necessary; this method returns the integer value of the winner of the game, and really all I had to do was incorporate 
  this into the checkWin boolean method, by setting a variable equal to the element of board-0,1, or 2. However, when I was initially
  structuring my code, it make sense to create an additional method to detect and return this.  
  I would refactor the the Jlabel that keeps track of the current player's turn; when the board is reset,the label does not update to show
  that it is Player 1's turn, but, depending if the last turn was Player 2, will still display that it is Player 2's turn. 
  



========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  
  I used stackOverflow in order to find out how to use the BufferedImage to upload my own files as the background. 
  I referred to a Minimax video of Connect4 in order to formulate my winning strategy. 
