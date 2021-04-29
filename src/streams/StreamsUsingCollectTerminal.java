package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by elamurugan on 2019-03-27.
 */
public class StreamsUsingCollectTerminal {

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

        nameList.stream().peek(s -> System.out.println("Before Filter: "+s))
                .filter(s->!s.equals("modi")).peek(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Peeked:"+s);
            }
        })
                .forEach(System.out::println);

        //--------------Using Map Function of Streams -------------------------
        System.out.println("Printing Objects");
        Function<String,Object> function = new Function<String, Object>() {

            @Override
            public Object apply(String s) {
                return new User(s);
            }
        };

        Consumer<Object> consumer = new Consumer<Object>() {

            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        //printing objects
        nameList.stream()
                .map(function)  //map(s->new User(s))  or map(User::new)
                .forEach(consumer);



        //Collecting Objects and Printing or using the collected objects for some other operations
        System.out.println("Using Collect function of Streams");
        List<Object> collect = nameList.stream()
                .map(function)
                .collect(Collectors.toList());
        System.out.println(collect);

    }
    static class User{
        private String name;
        private int age;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "[Name:"+name+" Age:"+age+"]";
        }
    }
}
