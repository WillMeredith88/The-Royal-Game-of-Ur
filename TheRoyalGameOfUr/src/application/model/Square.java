package application.model;

public class Square {

	private boolean isHiddenPlayer;
	private boolean isHiddenAI;
	private boolean isRosette;
	private int row;
	private int col;
	
	public Square(int row, int col){
		this.isHiddenPlayer=true;
		this.isHiddenAI=true;
		this.isRosette=false;
		this.row=row;
		this.col=col;
	}
	
	public void setIsRosette(){
		this.isRosette = true;
	}
	
	public boolean getIsHiddenPlayer(){
		return this.isHiddenPlayer;
	}
	
	
	public boolean getIsHiddenAI(){
		return this.isHiddenAI;
	}
	
	public void revealPlayer(){
		this.isHiddenPlayer = false;
	}
	
	public void revealAI(){
		this.isHiddenAI = false;
	}
	
	
	public boolean getIsRosette(){
		return this.isRosette;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	
	
}
