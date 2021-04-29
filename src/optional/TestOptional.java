package optional;

import streams.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestOptional {
    public static void main(String[] args){
        Optional<Person> optPerson = Optional.ofNullable(personSupplier().get());
        //Optional<Person> optPerson = Optional.ofNullable(getPerson());
        List<Person> people = getPersons();
        Optional<List<Person>> optPersonList = Optional.ofNullable(getPersons());
        System.out.println("Person : "+optPerson);
        System.out.println("PersonsList : "+optPersonList);
        System.out.println(optPerson.filter(person->person.getGender().equals("Male")));
//        Predicate childPredicate = new Predicate() {
//            @Override
//            public boolean test(Person p) {
//                return p.getGender().equals("Male");
//            }
//        };
//        Function f = new Function() {
//            @Override
//            public Object apply(List<Person> people) {
//                return people.stream().filter(p -> p.getGender().equals("Male"));
//            }
//        };
        System.out.println("OptionalList: Male List: "+(optPersonList.map(persons -> persons.stream().filter(p->p.getGender().equals("Male")).collect(Collectors.toList()))));
        Stream<Person> male = people.stream().filter(person -> person.getGender().equals("Male"));
        System.out.println(optPersonList.filter((persons) -> (persons.stream().map(Person::getGender).collect(Collectors.toList()).isEmpty())));

    }
    public static Person getPerson(){
        Person p = new Person("Ela",24,"Male", Arrays.asList("9999999991","9999999992","9999999993","9999999994"));
        return p;
    }
    public static Supplier<Person> personSupplier(){
       // return ()->new Person("Ela",24,"Male", Arrays.asList("9999999991","9999999992","9999999993","9999999994"));
        // -------------------or-------------------------------------
        Supplier s = new Supplier() {
            @Override
            public Object get() {
                return new Person("Ela",24,"Male", Arrays.asList("9999999991","9999999992","9999999993","9999999994"));
            }
        };
        System.out.println(s.get());
        return s;
    }
    public static List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ela",24,"Male", Arrays.asList("9999999991","9999999992","9999999993","9999999994")));
        persons.add(new Person("Ani",22,"Female", Arrays.asList("9999999995","9999999996","9999999997","9999999998")));
        persons.add(new Person("Sree",18,"Male", Arrays.asList("9999999999","9999999910","9999999911","9999999912")));
        persons.add(new Person("Hemant",26,"Male", Arrays.asList("9999999913","9999999914","9999999915","9999999916")));
        persons.add(new Person("Reshma",17,"Female", Arrays.asList("9999999917","9999999918","9999999919","9999999920")));
        return persons;
    }
}
