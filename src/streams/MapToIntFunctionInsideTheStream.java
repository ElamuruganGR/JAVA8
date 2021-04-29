package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by elamurugan on 2019-03-27.
 */
public class MapToIntFunctionInsideTheStream {
    public static void main(String[] args)
    {
        List<Person> people = Arrays.asList(new Person("Surya",45),
                new Person("Ajith",48),
                new Person("Vijay",48),
                new Person("PowerStar",40));
       /* Function<Person,Integer> function = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        };*/

        System.out.println(people.stream()
              .mapToInt(Person::getAge)
              .sum());
        Function<Person,Integer> function = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        };
        Stream<Integer> integerStream = people.stream().map(person -> person.getAge());
        System.out.println(integerStream);

    }
}
