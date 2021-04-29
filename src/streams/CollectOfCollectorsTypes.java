package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by elamurugan on 2019-03-27.
 */
public class CollectOfCollectorsTypes {

    public static void main(String[] args){
        List<Person> people = Arrays.asList(new Person("Surya",45),
                                            new Person("Ajith",48),
                                            new Person("Vijay",48),
                                            new Person("PowerStar",40));
        //Accumulates name into a list
        Function<Person, String > function = new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getName();
            }
        };
        people.stream().collect(Collectors.mapping(Person::getName , Collectors.toList()));
        people.stream().map(function).collect(Collectors.toList());
    }
}
