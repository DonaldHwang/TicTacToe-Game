/**
   A class playing a game of TicTacToe
*/
package ttt_source_code;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
  public Tool player;
  public Tool computer;
  public Tool person;
  
  public Board board;
  private TicTacToeAgent agent;

  public TicTacToe (int agentIQ) {
    showStartHint();
    randomFirstPlayer();  
  
    board = new Board();
    agent = agentCreator( agentIQ);
  }
  
  public TicTacToe () {
    this( 100);
  }

  public void play () {
    board.show();
  
    boolean gameOver = false;
    while (!gameOver) {
       Move move = getAMove();
       board.handleMove( move, player);
  
       board.show();
  
       if (board.isGameWon() || board.isFull())
          gameOver = true;
       else 
          player = oppositePlayer();
    }
  
    showGameResult();
  }
  
  private TicTacToeAgent agentCreator (int iQ) {
    TicTacToeAgent agent;
    switch (iQ) {
      case 0   :  agent = new RandomAgent( board); break;
      case 100 :  agent = new AIAssistance( board, computer, person); break;
      default  :  agent = new WisdomAgent( board, computer, person, iQ); break;
    }
    return agent;
  }

  private void showStartHint() {
    System.out.println( HINT_MESSAGE);
  }

  private void randomFirstPlayer () {
    if (generator.nextBoolean()) {
      person   = Tool.X; 
      computer = Tool.O;
    } else {
      person   = Tool.O; 
      computer = Tool.X;
    }
    player = Tool.X;
  }
  
  public Tool oppositePlayer () {
    return (player == computer) ? person : computer;
  }
  
  public void showGameResult () {
    if (board.isGameWon())
      System.out.println( player==person ? "You won!" : "I won!" );
    else if (board.isFull())
      System.out.println( "We tied!" );
    else
      System.out.println( "Something went wrong!" );
    System.out.println( board.getMoves());
  }
  
  // Creates a move, either a random generated move or as input from the user
  public Move getAMove () { //change to public by donald
    Move move = null;
  
    if (player == computer) {
       System.out.println( "It is my move.  I am " + player );
       move = agent.nextMove();
    } else {
       System.out.println( "It is your move.  You are " + player );
       move = getAValidMoveFromPerson();
    }
    return move;
  }
  
  //÷ÿ–¥getAMove
  public Move getAMove2 (int row, int column) {
	    Move move = null;
	  
	    if (player == computer) {
	       System.out.println( "It is my move.  I am " + player );
	       move = agent.nextMove();
	    } else {
	       System.out.println( "It is your move.  You are " + player );
	       move = getAValidMoveFromPerson2(row, column);
	    }
	    return move;
	  }
  
  private Move getAValidMoveFromPerson () {
    Move move = null;
    while (true) {
      try {
        System.out.print( "Enter a row and column on one line: " );
        move = new Move( in.nextInt(), in.nextInt() );
        // Generates an exception if can't make a move from r and c
      
        if (board.isValid( move )) return move;
      
        System.out.println( "Invalid move. Try again!" );
      } catch (Exception e) {
        System.out.println( "Input error. Try again!" );
      }
    }
  }
  
  
  public Move getAValidMoveFromPerson2 (int row, int column) {
	    Move move = null;
	    while (true) {
	      try {
	        move = new Move( row, column );
	        // Generates an exception if can't make a move from r and c
	      
	        if (board.isValid( move )) return move;
	      
	        System.out.println( "Invalid move. Try again!" );
	      } catch (Exception e) {
	        System.out.println( "Input error. Try again!" );
	      }
	    }
	  }
  
  public Tool getPerson() {
	return person;
}


private static Scanner in = new Scanner( System.in );
  private static Random generator = new Random();
  
  private static final String HINT_MESSAGE = "\n" +
    "************************************************\n" +
    "Let's play Tic Tac Toe!\n" +
    "When asked for a move, enter location you want.\n" +
    "Enter the row first and then the column, both on the same line.\n" +
    "The row and column must in the range 1 .. 3\n" +
    "************************************************\n" ;
}
