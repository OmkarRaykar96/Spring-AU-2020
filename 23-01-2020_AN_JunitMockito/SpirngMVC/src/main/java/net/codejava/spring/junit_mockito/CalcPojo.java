package net.codejava.spring.junit_mockito;

public class CalcPojo {
	private CalcInterface calcService;

	public void setCalculatorService(CalcInterface calcService) {
		this.calcService = calcService;
	}

	public int multiply(int var1, int var2) {
		return calcService.multiply(var1, var2);
	}

	public int divide(int var1, int var2) {
		return calcService.divide(var1, var2);
	}

	public int add(int var1, int var2) {
		return calcService.add(var1, var2);
	}

	public int subtract(int var1, int var2) {
		return calcService.subtract(var1, var2);
	}

}