package application.model;

public class GameBoard {
	
	
	/**
	 * I was thinking of setting up the board
	 * as a 2-d array then making the extra pieces null
	 * and handling them if a move function- Will
	 */
	Square[][] squares = new Square[8][3];
	Player player;
	Player AI;//AI may need its own class 
	Dice dice[];
	
	public GameBoard(Player player){
		this.player = player;
		
		
	}
	

	/**
	 * this method should set the board up and
	 * account for the extra squares as well as
	 * the ones that contain a rosette.
	 */
	public void setBoard(){
		
		for(int row=0; row<8; row++){
			for(int col=0; col < 3; col++){
				
					//set extra squares to null
					if((row == 4 || row == 5) && col != 1)
							this.squares[row][col] = null;
					
					//set the rosettes
					if((row == 0 || row == 2) && (col != 1))
						this.squares[row][col].setIsRosette();
					
					}
				}
			}
		
		
		public Square canMove(Square square){
			//todo: write method which determines if a player can move to a specific square
		
		return square;
	}
	
	
}
