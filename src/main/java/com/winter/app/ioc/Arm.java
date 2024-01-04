package com.winter.app.ioc;

public abstract class Arm {
	
	private String direction;
	
	
	
	public String getDirection() {
		return direction;
	}



	public void setDirection(String direction) {
		this.direction = direction;
	}



	public abstract void act();

}
