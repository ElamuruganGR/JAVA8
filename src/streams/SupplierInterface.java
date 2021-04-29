package streams;

import java.util.function.Supplier;

/**
 * Created by elamurugan on 2019-03-27.
 */
public class SupplierInterface {
    public static void main(String[] args){
        Supplier<Person> supplier = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person("John",31);
            }
        };
        Supplier<Person> supplier1 = ()->new Person("Regina",30);
        Supplier<Person> supplier2 = Person::new;
        System.out.println("Supplier");
        printUser(supplier);
        System.out.println("Supplier1");
        printUser(supplier1);
        System.out.println("Supplier2");
        printUser(supplier2);

    }
    public static void printUser(Supplier supplier){
        System.out.println(supplier.get());
    }
}
