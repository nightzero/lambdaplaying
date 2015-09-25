package overload;

import java.util.function.Predicate;


/**
 * javac infers the most specific functional interface
 * @author qbormat
 */
public class TestOverloadPredicate {
	//This cannot be inferred. One solution is to extend predicate as below.
//	private interface IntPredicate {
//		public boolean test(int value);
//	}
	private interface IntPredicate extends Predicate<Integer> {
		public boolean test(int value);
	}
	
	public void overloadedMethod(Predicate<Integer> predicate){
		System.out.println("Predicate<Integer>");
	}
	
	public void overloadedMethod(IntPredicate predicate){
		System.out.println("IntPredicate");
	}
	
	public static void main(String[] args){
		TestOverloadPredicate to = new TestOverloadPredicate();
		// The compiler cannot infer the interface as it's not possible to find the most specific.
		//to.overloadedMethod((x) -> x > 0 ? true: false);
		to.overloadedMethod((x) -> x > 0 ? true: false);
	}
}
