package com.vergez.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	public int somme(int a, int b) {
		return a + b;
	}

	@Test
	void testSommeReturnSumOfTwoNumbersOfTypeInt(){
		int a = 2;
		int b = 3;
		assertEquals(5, somme(a, b));
	}

	@Test
	void testDivision(){
		double a = 5;
		double b = 2;
		assertEquals(2.5, division(a,b));
	}

	@Test
	void testDivisionIfAequalZeroAndBDifferentZero(){
		double a = 0;
        double b = 2;
        assertEquals(0.0, division(a,b));
	}

	@Test
	void testDivisionIfADifferentZeroAndBequalZero(){
		double a = 2;
        double b = 0;
		ArithmeticException e =
		assertThrows(ArithmeticException.class, ()->{
			division(a,b);
		});

		assertEquals("impossible division", e.getMessage());
	}

	private Double division(double a, double b){
		if (b==0) {
			throw new ArithmeticException("impossible division");
		}
		return a/b;
	}
}
