package com.test.v1;

public class Division extends OperacionAbs{

	Division(double x, double y){
		super(x,y);
	}
	
	@Override
	public double operar() {
		return x/y;
	}

}
