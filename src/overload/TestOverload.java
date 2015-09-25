package overload;

import java.util.function.BinaryOperator;

/**
 * javac infers the most specific functional interface
 * @author qbormat
 */
public class TestOverload {
	private interface IntegerBiFunction extends BinaryOperator<Integer>{}
	private interface MyIntegerBiFunction extends IntegerBiFunction{}
	
	public void overloadedMethod(BinaryOperator<Integer> lambda){
		System.out.println("BinaryOperator");
		System.out.println(lambda.apply(1, 1));
	}
	public void overloadedMethod(IntegerBiFunction lambda){
		System.out.println("IntegerBiFunction");
		System.out.println(lambda.apply(1, 1));
	}
	public void overloadedMethod(MyIntegerBiFunction lambda){
		System.out.println("MyIntegerBiFunction");
		System.out.println(lambda.apply(1, 1));
	}
	
	public static void main(String[] args){
		TestOverload to = new TestOverload();
		to.overloadedMethod((x, y) -> x+y);
	}
}
