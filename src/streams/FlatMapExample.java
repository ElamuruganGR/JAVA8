package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args){
        List<Person> people = Arrays.asList(new Person("Reddy",25,"M",Arrays.asList("1","2")),
                new Person("Sharan",27,"M",Arrays.asList("3","4","5")),
                new Person("Chitra",28,"F",Arrays.asList("6")),
                new Person("Surbhi",235,"F",Arrays.asList("7","8")));

        for(Person p : people){
            for(String phoneNumber : p.getPhoneNumbers()){
                if(phoneNumber.equalsIgnoreCase("5")){
                    System.out.println(phoneNumber);
                }
            }
        }

        Function<Person,List<String>> function = new Function<Person, List<String>>() {
            @Override
            public List<String> apply(Person person) {
                return person.getPhoneNumbers();
            }
        };
        people.stream()
                .map(person -> person.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("5")))
                .findAny().ifPresent(System.out::println);


    }
}
