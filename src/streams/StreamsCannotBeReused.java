package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsCannotBeReused {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            values.add(i);
        }
        Stream<Integer> stream = values.stream();
        stream.forEach(System.out::println);//work
        stream.forEach(System.out::println);//Exception
    }
}
