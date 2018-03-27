package application.model;

public class Square {

	private boolean isHiddenPlayer;
	private boolean isHiddenAI;
	private boolean isRosette;
	
	public Square(){
		this.isHiddenPlayer=true;
		this.isHiddenAI=true;
		this.isRosette=false;
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
	
	
	
}
