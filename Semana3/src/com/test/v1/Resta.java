package com.test.v1;

public class Resta extends OperacionAbs{

	Resta(double x, double y){
		super(x,y);
	}
	
	@Override
	public double operar() {
		return x-y;
	}

}
