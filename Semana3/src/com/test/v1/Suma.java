package com.test.v1;

public class Suma extends OperacionAbs{

	Suma(double x, double y){
		super(x,y);
	}
	
	@Override
	public double operar() {
		return x+y;
	}

}
