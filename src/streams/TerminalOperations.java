package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by elamurugan on 2019-03-27.
 */
public class TerminalOperations {
    public static void main(String[] args){
        List<Person> people = Arrays.asList(new Person("Surya",45,"M"),
                new Person("Ajith",48,"M"),
                new Person("Halena",35,"F"),
                new Person("Priya",23,"F"));
        System.out.println("All Match: "+people.stream()
                                 .allMatch(person -> person.getGender().equalsIgnoreCase("M")));
        System.out.println("Any Match: "+people.stream()
                                 .anyMatch(person -> person.getGender().equalsIgnoreCase("M")));
        System.out.println("None Match: "+people.stream()
                                 .noneMatch(person -> person.getGender().equalsIgnoreCase("M")));
        //version1 of collect
        List<String> collect = people.stream()
                                     .map(person -> person.getName())
                                     .collect(Collectors.toList());
        System.out.println(collect);
        //version 2 of collect
        TreeSet<Integer> collect1 = people.stream()
                .map(person -> person.getAge())
                .collect(Collectors.toCollection(TreeSet::new));
        TreeSet<Integer> collects = people.stream()
                .map(person -> person.getAge())
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect1);
        //version 3 of collect
        Function<Person,String> function = new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getGender();
            }
        };
        System.out.println("==================");
        Map<String, List<Person>> collect2 = people.stream().collect(Collectors.groupingBy(function));
        for(Map.Entry<String,List<Person>> entry: collect2.entrySet()){
            System.out.println(entry.getValue());
        }

        //version 4 of collect
        System.out.println(people.stream().map(person->person.getName()).collect(Collectors.joining(",")));

    }
}
