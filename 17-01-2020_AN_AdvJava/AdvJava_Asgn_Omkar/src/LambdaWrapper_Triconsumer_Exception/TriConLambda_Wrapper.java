package LambdaWrapper_Triconsumer_Exception;

import java.util.Scanner;

public class TriConLambda_Wrapper {
	
	private <T, U, V> void apply(TriCon<T, U, V> triConsumer, T t, U u, V v) {
		triConsumer.apply(t, u, v);
	}
	
	static <T, U, V,  E extends Exception> TriCon<T, U, V> triConsumerWrapper(TriCon<T, U, V> triConsumer, Class<E> exceptionClass) {
		return (t, u, v) -> {
			try {
				triConsumer.apply(t, u, v);
			} catch (Exception e) {
				try {
	                E exception = exceptionClass.cast(e);
	                System.out.println("Exception: " + exception.getMessage());
	                System.out.println();
	            } catch (ClassCastException exc) {
	                throw new RuntimeException(exc);
	            }
			}
		};
	}
	
	public static void main(String args[]) {
		
		TriConLambda_Wrapper TriconsumerLambda = new TriConLambda_Wrapper();
		Scanner sc=new Scanner(System.in);
		
		TriCon<Integer, Integer, Integer> operation = triConsumerWrapper((Integer a, Integer b, Integer c) -> {
			int ans = (a+b)/c;
			
			System.out.println("Result of the operation is: "+ans);
		}, ArithmeticException.class);
		
		System.out.println("Lambda Triconsume & Lambda Wrapper");
		System.out.println("Operation -> (Nom_1 + Nom_2)/Denom");
		
		System.out.println("Enter 1st Nominator: ");
		int a=sc.nextInt();
		
		System.out.println("Enter 2nd Nominator: ");
		int b=sc.nextInt();
		
		System.out.println("Enter denominator: ");
		int c=sc.nextInt();
		
		TriconsumerLambda.apply(operation, a, b, c);
		sc.close();
	}
}