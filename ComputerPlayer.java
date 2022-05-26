package TicTacToe;

public class ComputerPlayer 
{
	
	private static String[][][] lossCombos = new String[30][3][3] ;
	private int currentLossComCt = 0 ; 
	/**
	 * Adjusts matrix of board object param according
	 * to the position that was passed
	 * @param rand A random number received from
	 * main method after being checked for validity
	 * @param obj Board object for which the move is being
	 * made upon 
	 */
	public void move(int rand, Board obj)
	{
		
		for(int i = 0 ; i < obj.getBoardArr().length ; i++)
		{
			for(int j = 0 ; j < obj.getBoardArr()[0].length ; j++)
			{
				
				if(obj.getBoardArr()[i][j].equals("O") || 
						obj.getBoardArr()[i][j].equals("X"))
				{
					
				}
				else 
				{
					int convert = Integer.valueOf(obj.getBoardArr()[i][j])  ; 
					if(convert == rand)
					{
						obj.getBoardArr()[i][j] = "X" ; 
					}
					
				}
				
			}
		}
	}
	/**
	 * This method adds the 2d array of 
	 * the Board object passed
	 * to it to ComputerPlayer's arrayList of loss
	 * combinations, making a deep copy of that 2d array
	 * also adjusting the current count
	 * of size for the loss combo array 
	 * @param obj
	 */
	public void add(Board obj)
	{
		
		
		for(int i = 0 ; i < lossCombos[0].length ; i++)
		{
			for(int j = 0 ; j < lossCombos[0][0].length ; j++)
			{
				lossCombos[currentLossComCt][i][j] = obj.getBoardArr()[i][j] ; 
				//System.out.println("Hello" ) ; 
			}
		}
		currentLossComCt++ ; 
	}
				

	//if changing the board according to the move results 
	//return false if the move is not a losing move 
	//assume it is a losing move 
	//all we have to do is adjust the board according to input loc
	//then see whether the board matches any past losing combos
	
	/**
	 * This method checks whether a move 
	 * the computer has the option of making is a 
	 * losing move by going through the arrayList of past
	 * loss combos 
	 * @param loc The move the computer is considering 
	 * @param obj The Board object on which the move is being considered
	 * @return boolean of whether the move 
	 * is a losing move
	 */
	public boolean checkLosingMove(int loc, Board obj)
	{
		String[][] copyWMove = new String[3][3] ; 
  		
		//create 2d array representing the board obj 
		//after the move has been made
		//if the 2d array does not match 
		//the past loss combos stored in the loss combos array,
		//then losing move can be made false 
		for(int i = 0 ; i < obj.getBoardArr().length ; i++)
		{
			for(int j = 0 ; j < obj.getBoardArr()[0].length ; j++)
			{
				if(obj.getBoardArr()[i][j].equals("O") || 
						obj.getBoardArr()[i][j].equals("X"))
				{
					copyWMove[i][j] = obj.getBoardArr()[i][j] ;
				}
				else
				{
					
					int convert = Integer.valueOf(obj.getBoardArr()[i][j])  ; 
					if(convert == loc)
					{
						copyWMove[i][j] = "X" ; 
					}
					else
					{
						copyWMove[i][j] = obj.getBoardArr()[i][j] ;
					}
				}
				
			}
		}
		//System.out.println("Move after it has been made in CP Class") ; 
		for(int i = 0 ; i < copyWMove.length ; i++)
		{
			//System.out.println(); 
			for(int j = 0 ; j < copyWMove[0].length ; j++)
			{
				//System.out.print(copyWMove[i][j]) ; 
			}
		}
		
		//check to see if it matches past loss combos 
		//iterate through loss combo array 
		//System.out.println(); 
		//System.out.println("Losing Combos from past games") ; 
		for(int k = 0 ; k < currentLossComCt ; k++)
		{
			//System.out.println(); 
			for(int i = 0 ; i < lossCombos[0].length ; i++)
			{
				//System.out.println(); 
				for(int j = 0 ; j < lossCombos[0][0].length ; j++)
				{
					//System.out.println("Combo" + k) ; 
					//System.out.print(lossCombos[k][i][j]) ; 
				}
			}
		}
			
		boolean losingMove = false ; 
		//check for matches in the array of losing combos 
		for(int i = 0 ; i < currentLossComCt ; i++)
		{
			boolean match = true  ; //match is reset to true at each new array in lossCombos
			for(int j = 0 ; j < lossCombos[0].length ; j++)
			{
				for(int k = 0 ; k < lossCombos[0][0].length ; k++)
				{
					if( !(copyWMove[j][k].equals(lossCombos[i][j][k])))
					{
						match = false ; 
						break ; 
					}
					if(j == 2 && k == 2 && match == true)
					{
						losingMove = true ; 
						return losingMove ; 
						
					}
				}
			}
		}
		//System.out.println(); 
		//System.out.println(losingMove) ; 
		return losingMove ; 
	}

}
