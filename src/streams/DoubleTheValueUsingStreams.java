package streams;

import optional.TestOptional;

import java.time.*;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DoubleTheValueUsingStreams {

    public  static void main(String[] args){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        /*int result =0;
        for(int i : values){
            result = result + i*2;
        }
        System.out.println(result);*/
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*2;
            }
        };
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };
        long result = values.stream().map(function).reduce(0,binaryOperator);
        Optional<Integer> reduce = values.stream().map(val -> val*2).reduce((a,b)->a-b);
        //TestOptional<Integer> result2 = values.stream().map(i->i*2).reduce((i1, i2)->i1+i2);
        //System.out.println("Result2:"+result2);
        System.out.println(result);

        System.out.println(values.stream().map(i -> i*2).reduce(0,(a,b) -> a+b));
                    //-----------or---------
        System.out.println(values.stream().map(i -> i*2).reduce(0,(a,b) -> Integer.sum(a,b)));
                    //-----------or----------
        System.out.println(values.stream().map(i -> i*2).reduce(0,Integer::sum));

        System.out.println("-----------------AGE-------------------------");
        LocalDate birthday = LocalDate.of(1996, Month.MAY, 05);
        LocalDate today = LocalDate.now();
        Period p = Period.between(birthday,today);
        System.out.printf("Your Age is %d Years, %d Months, %d Days", p.getYears(),p.getMonths(),p.getDays());

        //-----------------------------------------------------------------------------------------

        ZoneId id = ZoneId.of("America/Los.angeles");
        ZonedDateTime zdt = ZonedDateTime.now(id);
        System.out.println("ZonedDate:"+zdt.toString());
        System.out.println("\nEnter Year:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("The year is :"+scanner.next());


    }
}
