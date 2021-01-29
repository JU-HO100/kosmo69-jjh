package com.di;

public class Sonata {
	String carColor = null;
	int speed = 0;
	int wheelNum= 0;
	public Sonata() {}
	public Sonata(int speed) {
		this.speed = speed;
	}
	public Sonata(String carColor, int speed) {
		this.carColor = carColor;
		this.speed = speed;
	}
	public Sonata(String carColor, int speed, int wheelNum) {
		this.carColor = carColor;
		this.speed = speed;
		this.wheelNum = wheelNum;
	}
	@Override
	public String toString() {
		return "그녀의 자동차는 " + this.carColor
		+ " 이고, 현재 속도는 " +this.speed
		+ " 바퀴 수는"+this.wheelNum;
	}
		
}
