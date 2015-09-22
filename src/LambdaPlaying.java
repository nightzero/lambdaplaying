import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class LambdaPlaying {
	
	@FunctionalInterface
	public interface MyFunctionalInterface {
		public void myFunc(String x);
		default void bla2(){}
		static void xyz(){}
	}
	
	public void testReduce(){
		int count = Stream.of(1,2,3,4).reduce(0, (acc, element) -> acc + element);
		System.out.println(count);
		
		Optional<Integer> count2 = Stream.of(1,2,3,4,5).reduce((acc, element) -> acc + element);
		count2.ifPresent((Integer i) -> System.out.println(i));
		//Can be written as
		count2.ifPresent(i -> System.out.println(i));
		//The following is syntactic sugar for the above
		count2.ifPresent(System.out::println);
	}
	
	public void testSupplier(){
		this.passParamToSupplier(() -> "Hello: " + getParam());
	}
	
	private void passParamToSupplier(Supplier<String> expr) {
		//If the next line is commented out, getParam() is not called.
		System.out.println(expr.get());
	}
	private String getParam(){
		System.out.println("Laizy eval...");
		return "Nisse";
	}
	
	public void testMyFunctionalInterface(MyFunctionalInterface k){
		k.myFunc("Hej");
	}

	public static void main(String[] args) {
		LambdaPlaying play = new LambdaPlaying();
		play.testSupplier();
	}
}
