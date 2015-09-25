package overload;

public class TestFunctionalInterface {
	@FunctionalInterface
	private interface MyFunc{
		public String apply(int i, int j);
	}
	
	public void testMyFunc(MyFunc lambda){
		String result = lambda.apply(1, 1);
		System.out.println(result);
	}
	
	public static void main(String[] args){
		MyFunc lambda = (x, y) -> "Result" + (x+y);
		TestFunctionalInterface tf = new TestFunctionalInterface();
		tf.testMyFunc(lambda);
	}
}
