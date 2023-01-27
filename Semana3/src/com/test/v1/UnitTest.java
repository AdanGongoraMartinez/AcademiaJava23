package com.test.v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest {

	@Test
	void testDouble() {
		double d = 5.0;
		assertEquals(d, 5.0);
	}
	
	@Test
	void testClassSuma() {
		double d1 = 3.0;
		double d2 = 5.0;
		
		Operación op = new Suma(3,5);
		
		assertEquals(d1+d2,op.operar());
	}
	
	@Test
	void testClassResta() {
		double d1 = 3.0;
		double d2 = 5.0;
		
		Operación op = new Resta(3,5);
		
		assertEquals(d1-d2,op.operar());
	}
	
	@Test
	void testClassMulti() {
		double d1 = 3.0;
		double d2 = 5.0;
		
		Operación op = new Multi(3,5);
		
		assertEquals(d1*d2,op.operar());
	}
	
	@Test
	void testClassDivision() {
		double d1 = 3.0;
		double d2 = 5.0;
		
		Operación op = new Division(3,5);
		
		assertEquals(d1/d2,op.operar());
	}
}
