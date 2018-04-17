package application.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class TestBoard {
	
	
	/**
	 * I was thinking of setting up the board
	 * as a 2-d array then making the extra pieces null
	 * and handling them if a move function- Will
	 */
	Square[][] squares = new Square[8][3];
	//Square[] squares = new Square[20];
	HashMap<String, Square> map = new HashMap();
	Player player;
	Player AI;//AI may need its own class 
	Dice dice[];
	Square current;
	
	
	
	public TestBoard(Player player){
		this.player = player;
		this.current=squares[0][0];
		
		squares[0][0]= new Square(0,0);
		squares[0][1]= new Square(0,0);
		squares[0][2]= new Square(0,1);
		squares[1][0]= new Square(0,2);
		squares[1][1]= new Square(1,0);
		squares[1][2]= new Square(1,1);
		squares[2][0]= new Square(1,2);
		squares[2][1]= new Square(2,0);
		squares[2][2]= new Square(2,1);
		squares[3][0]= new Square(2,2);
		squares[3][1]= new Square(3,0);
		squares[3][2]= new Square(3,1);
		squares[4][0]= new Square(3,2);
		squares[4][1]= new Square(4,0);
		squares[4][2]= new Square(4,1);
		squares[5][0]= new Square(4,2);
		squares[5][1] = new Square(5,0);
		squares[5][2] = new Square(5,1);
		squares[6][0] = new Square(5,2);
		squares[6][1] = new Square(6,0);
		squares[6][2] = new Square(6,1);
		squares[7][0] = new Square(7,0);
		squares[7][1] = new Square(7,1);
		squares[7][2] = new Square(7,2);
		squares[8][0] = new Square(8,0);
		squares[8][1] = new Square(8,1);
		squares[8][2] = new Square(8,2);
		map.put("zeroButton", squares[0][0]);
		map.put("oneButton", squares[0][1]);
		map.put("twoButton", squares[0][2]);
		map.put("threeButton", squares[1][0]);
		map.put("fourButton", squares[1][1]);
		map.put("fiveButton", squares[1][2]);
		map.put("sixButton", squares[2][0]);
		map.put("sevenButton", squares[2][1]);
		map.put("eightButton", squares[2][2]);
		map.put("nineButton", squares[3][0]);
		map.put("tenButton", squares[3][1]);
		map.put("eleventButton", squares[3][2]);
		map.put("tweleveButton", squares[4][0]);
		map.put("thirteenButton", squares[4][1]);
		
		this.setBoard();
	}
	

	/**
	 * Calculates the possible moves based on a
	 * dice roll. If the player does not already occupy this position
	 * and the coordinates reference a valid square, then the
	 * Sqaure will be added to an arraylist
	 * @param current (Square)
	 * @return list (Square)
	 */
	public ArrayList<Square> getPossibleMove(Square current, int roll){
		int row=current.getRow();
		int col=current.getCol();
		//int roll=Dice.rollDice();
		int rollCounter=roll;
		
		ArrayList<Square> list = new ArrayList<Square>();
		
		for(int i=0; i<roll; i++){
				if(squares[row+rollCounter][col+i] != null 
						&& squares[row+rollCounter][col+i].getIsHiddenPlayer()){
							list.add(squares[row+rollCounter][col+i]);
			}
		
		}
		
		if(squares[row][col+roll] != null 
				&& squares[row][col+roll].getIsHiddenPlayer()){
			
			list.add(squares[row][col+roll]);
		}
		
		
		return list;
	}
	
	
	
	/**
	 * 
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
		
		/**
		 * method should return a String representation of
		 * the button that it corresponds to in the Hashmap
		 * @param square
		 * @return
		 */
		public String getButton(Square square){
			Set<Entry<String,Square>> nameSet = map.entrySet();
			
			for(Entry<String, Square> intry:nameSet){
				if(intry.getValue() == square){
					return intry.getKey();
				}
			}
			
			
			return null;
			
		}
		
		
		
		public Square getCurrent(){
			return this.current;
		}
		
}
