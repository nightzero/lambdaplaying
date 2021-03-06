import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;


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
	
	public void testOptional(){
		Optional<String> a = Optional.of("a");
		Assert.assertTrue(a.isPresent());
		System.out.println(a.get());
		Optional<String> b = Optional.empty();
		System.out.println(b.orElse("c"));
		Optional<String> c = Optional.empty();
		System.out.println(b.orElseGet(()-> "d"));
	}

	public void testPartition(){
		Stream<String> strings = Stream.of("Aqwe", "qwe", "Aasd", "asd");
		Map<Boolean, List<String>> result = strings.collect(Collectors.partitioningBy(s -> s.startsWith("A")));
		List<String> trueList = result.get(new Boolean(true));
		List<String> falseList = result.get(new Boolean(false));
		trueList.forEach((v) -> System.out.println(v));
		System.out.println("----------------");
		falseList.forEach((v) -> System.out.println(v));
	}
	
	public static void main(String[] args) {
		LambdaPlaying play = new LambdaPlaying();
		play.testPartition();
	}
}
