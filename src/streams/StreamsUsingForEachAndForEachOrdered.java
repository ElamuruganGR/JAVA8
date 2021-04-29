package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by elamurugan on 2019-03-27.
 */
public class StreamsUsingForEachAndForEachOrdered {

    public static void main(String[] args){
        List<String> nameList = Arrays.asList("osama","modi","suresh","Annie");
        //==============================WithoutLambda===================================
        System.out.println("---------WithoutLambda---------");
        for(String name : nameList){
            if(!name.equals("modi")){
                System.out.println(name);
            }
        }

        //==============================WithLambda======================================
        System.out.println("---------WithLambda---------");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return !s.equals("modi");
            }
        };
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        System.out.println("----Sequential,ForEach function of Streams----");
        nameList.stream()
                .filter(predicate)
                .forEach(consumer);

        System.out.println("----Sequential,ForEachOrdered function of Streams----");
        nameList.stream()
                .filter(predicate)
                .forEachOrdered(consumer);

        System.out.println("----Parallel,ForEach function of Streams----");
        nameList.parallelStream()
                .filter(predicate)
                .forEach(consumer);

        System.out.println("----Parallel,ForEachOrdered function of Streams----");
        nameList.parallelStream()
                .filter(predicate)
                .forEachOrdered(consumer);
    }
}
