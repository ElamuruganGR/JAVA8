package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class StreamsDemo {

	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(1,2,3,4,5,6);
		
		/*================================================================*/
		
		//------------Without Lambda-----------------------------------------
		System.out.println("------ConsumerInterface without Lambda-------");
		Consumer<Integer> consumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);	
			}			
		};
		values.forEach(consumer);
		
		//-------------with lambda-------------------------------------------
		System.out.println("------ConsumerInterface with Lambda-------");
		Consumer<Integer> consumer1 = t -> System.out.println(t);
		values.forEach(consumer1);
					//--------or-------
		/*values.forEach(i -> System.out.println(i));*/
		
		/*===================================================================*/

		//values.forEach(i -> doubleIt(i));
				//-------------or----------
		System.out.println("------MethodReferrence-------");
		values.forEach(StreamsDemo::doubleIt);
		
		/*====================================================================*/
		System.out.println("------Streams-------");
		values.stream().forEach(i -> System.out.println(i));
		
	}

	public static void doubleIt(int i){
		System.out.println(i*2);
	}

}
