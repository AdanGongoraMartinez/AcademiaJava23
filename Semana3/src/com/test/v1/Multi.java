package com.test.v1;

public class Multi extends OperacionAbs{

	Multi(double x, double y){
		super(x,y);
	}
	
	@Override
	public double operar() {
		return x*y;
	}

}
