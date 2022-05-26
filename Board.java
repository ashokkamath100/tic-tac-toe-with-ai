package TicTacToe;


import java.util.Scanner;



public class Board 
{
	private String[][] boardArr = {{"1","2","3"},
								{"4","5","6"},
								{"7","8","9"}} ; 
	
	
	
	 
	public Board()
	{
		
		
	}
	
	public String[][] getBoardArr()
	{
		return this.boardArr ; 
	}
	
	
	/**
	 * This method prints the board in its current form 
	 */
	public void print()
	{
		System.out.println(); 
		int rowBoost = 1 ; 
		for(int i = 0 ; i < this.boardArr.length ; i ++)
		{
			if(i > 0)
			{
				System.out.println();
				System.out.println("-----------------------------") ; 
				rowBoost += 2 ; 
			}
			
			for(int j = 0 ; j < this.boardArr[0].length ; j++)
			{
				if(j  > 0) 
				{
					System.out.print("    |") ; 
				}
				
				
				
				/*
				 * if(board[i][j] == null) { int location = i + j + rowBoost;
				 * System.out.print("    " + location) ; } else {
				 */
				System.out.print("    " + boardArr[i][j]) ; 
					
			
			}
		}
	}
	/**
	 * This method checks whether a move is valid 
	 * and does not go into boxes where
	 * there is already a move 
	 * @param loc the location on the board of the proposed move 
	 * @return boolean of whether the move is valid 
	 */
	public boolean checkValidMove(int loc)
	{
		boolean valid = false ; 
		for(int i = 0 ; i < this.boardArr.length ; i++)
		{
			for(int j = 0 ; j < this.boardArr[0].length ; j++)
			{
				if(boardArr[i][j].equals("O") || boardArr[i][j].equals("X"))
				{
					valid = false ; 
				}
				else
				{
					int convert = Integer.parseInt(boardArr[i][j])  ; 
					if(convert == loc)
					{
						valid = true ; 
						return valid ;
						
					}
				}
				
				
			}
		}
		return valid ; 
	}
	
	/**
	 * This method checks for a winning combination
	 * @return Boolean of whether there is a winning combo
	 */
	public boolean checkForWin()
	{
		boolean win = false ; 
		 
		//check horizontals
		if(boardArr[0][0] == "O" && boardArr[0][1] == "O" && boardArr[0][2] == "O" )
		{
			win = true ; 
			return win ; 
		} 
		else if(boardArr[1][0] == "O" && boardArr[1][1] == "O" && boardArr[1][2] == "O" )
		{
			win = true ; 
			return win ; 
		}
		else if(boardArr[2][0] == "O" && boardArr[2][1] == "O" && boardArr[2][2] == "O" )
		{
			win = true ; 
			return win ; 
		}
		else if(boardArr[0][0] == "X" && boardArr[0][1] == "X" && boardArr[0][2] == "X" )
		{
			win = true ; 
			return win ; 
		}
		else if(boardArr[1][0] == "X" && boardArr[1][1] == "X" && boardArr[1][2] == "X" )
		{
			win = true ; 
			return win ; 
		}
		else if(boardArr[2][0] == "X" && boardArr[2][1] == "X" && boardArr[2][2] == "X" )
		{
			win = true ; 
			return win ; 
		}
		//check verticals
		else if(boardArr[0][0] == "O" && boardArr[1][0] == "O" && boardArr[2][0] == "O" )
		{
			win = true ; 
			return win ; 
		}
		else if(boardArr[0][1] == "O" && boardArr[1][1] == "O" && boardArr[2][1] == "O" )
		{
			win = true ; 
			return win ; 
		}
		if(boardArr[0][2] == "O" && boardArr[1][2] == "O" && boardArr[2][2] == "O" )
		{
			win = true ; 
			return win ; 
		}
		else if(boardArr[0][0] == "X" && boardArr[1][0] == "X" && boardArr[2][0] == "X"  )
		{
			win = true ; 
			return win ; 
		}
		if(boardArr[0][1] == "X"  && boardArr[1][1] == "X"  && boardArr[2][1] == "X"  )
		{
			win = true ; 
			return win ; 
		}
		if(boardArr[0][2] == "X"  && boardArr[1][2] == "X"  && boardArr[2][2] == "X"  )
		{
			win = true ; 
			return win ; 
		}
		//check diagonals 
		if(boardArr[0][0] == "X" && boardArr[1][1] == "X" && boardArr[2][2] == "X"  )
		{
			win = true ; 
			return win ; 
		}
		if(boardArr[0][2] == "X" && boardArr[1][1] == "X" && boardArr[2][0] == "X"  )
		{
			win = true ; 
			return win ; 
		}
		if(boardArr[0][0] == "O" && boardArr[1][1] == "O" && boardArr[2][2] == "O"  )
		{
			win = true ; 
			return win ; 
		}
		if(boardArr[0][2] == "O" && boardArr[1][1] == "O" && boardArr[2][0] == "O"  )
		{
			win = true ; 
			return win ; 
		}
			
		return win ; 
	}
	
	/**
	 * This method resets the board to its
	 * original empty state 
	 */
	public void reset()
	{
		int rowBoost = 1 ; 
		for(int i = 0 ; i < boardArr.length ; i++)
		{
			if(i > 0 )
			{
				rowBoost += 2 ; 
			}
			for(int j = 0 ; j < boardArr[0].length ; j++)
			{
				int newNum = i + j + rowBoost ; 
				boardArr[i][j] = String.valueOf(newNum) ; 
			}
		}
		
	}
	
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in) ; 
		
		int x = 0 ; 
		int gameCount = 0 ; 
		//these should be reset every time it runs, not at the end of each game (W or L)
		Board game = new Board() ; 
		HumanPlayer hp = new HumanPlayer() ;
		ComputerPlayer cp = new ComputerPlayer() ; 
		
		do 
		{
			if(gameCount == 0 )
			{
				System.out.println("Let's play tic tac toe!");
			}
			boolean win = false ; 
			while(win == false )
			{
				game.print() ; 
				System.out.println(); 
				System.out.println(); 
				
				int playerMove = 0 ; 
				
				boolean validMove = false ; 
				while(validMove == false)
				{
					System.out.println("Where would you like to place your O?") ; 
					playerMove = scan.nextInt() ; 
					//check if move is valid 
					validMove = game.checkValidMove(playerMove) ; 
					if(validMove == false)
					{
						System.out.println("Not a valid move. Try again.") ; 
					}
				}
				//after move is known to be valid, then board needs to be adjusted
				//use humanPlayer move
				
				//store board prior to move 
				Board storage = new Board()  ;
				for(int i = 0 ; i < storage.boardArr.length ; i++)
				{
					for(int j = 0 ; j < storage.boardArr[0].length ; j++)
					{
						storage.boardArr[i][j] = game.boardArr[i][j] ; 
					}
				}
				hp.move(playerMove, game);
				//check for win based on human move
				if( game.checkForWin())
				{
					game.print() ; 
					System.out.println(); 
					System.out.println("You won! Nice job!") ; 
					cp.add(storage) ; //add board of before the winning move so cp can learn
					game.reset();  
					break ; 
				}
				//if no win, then computer plays 
				boolean validMove1 = false ; 
				boolean lossMove = true ; //we want this to be false before moving
				int rand = 0 ; 
				while(validMove1 == false || lossMove == true)
				{
					rand = (int) (Math.random() * 10) ; 
					validMove1 = game.checkValidMove(rand) ; 
					if(validMove1)
					{
						lossMove = cp.checkLosingMove(rand, game) ; 
					}
				}	
				cp.move(rand, game) ; 
				if( game.checkForWin())
				{
					game.print(); 
					System.out.println(); 
					System.out.println("You lost!") ; 
					game.reset();  
					break ; 
				}
			}
			System.out.println();
			System.out.println("Do you want to play again? \n1. Yes!\n2. No!") ; 
			x = scan.nextInt() ; 
		}while(x != 2) ; 
	}
}

