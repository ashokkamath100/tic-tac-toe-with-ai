package TicTacToe;

public class HumanPlayer 
{
	/**
	 * This method takes the location of 
	 * where the human player wants to 
	 * move and then adjust the 2d array 
	 * of the Board obj on which 
	 * the human is playing 
	 * @param loc The location where the human
	 * wants to place an O
	 * @param obj The Board obj on which the human is 
	 * playing tic tac toe 
	 */
	public void move(int loc, Board obj)
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
					if(convert == loc)
					{
						obj.getBoardArr()[i][j] = "O" ; 
					}
					
				}
				
			}
		}
		
	}

}
