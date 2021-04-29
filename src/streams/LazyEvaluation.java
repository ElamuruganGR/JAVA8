package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluation {

    public static void main(String[] args){
        List<Integer> values = new ArrayList<>();
        for(int i=1;i<100;i++){
            values.add(i);
        }
        Stream<Integer> stream = values.stream().filter(i -> {
            System.out.println("hi");
            return true;
        });

        values.stream().filter(i -> {
            System.out.println("hi");
            return true;
        }).findFirst().orElse(0);
        System.out.println(stream);
    }
}
