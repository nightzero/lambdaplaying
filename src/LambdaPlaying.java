import java.util.Optional;
import java.util.stream.Stream;


public class LambdaPlaying {
	
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

	public static void main(String[] args) {
		LambdaPlaying play = new LambdaPlaying();
		play.testReduce();
	}

}
