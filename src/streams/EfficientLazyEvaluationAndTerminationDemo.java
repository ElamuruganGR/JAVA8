package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EfficientLazyEvaluationAndTerminationDemo {

    public  static  void  main(String[] args) {
        List<Integer> values = Arrays.asList(12, 20, 35, 46, 55, 68, 75);
        int result = 0;
        for(Integer i:values){
            if(i%5==0){
                result = i*2;
                break;
            }
        }

        //print the double value of first occurence of the number divisible by 5
        System.out.println("print the double value of first occurence of the number divisible by 5");
        System.out.println("using Filter with Lambda-- "+values.stream()
                .filter(i -> i%5==0)
                .map(a -> a*2)
                .findFirst()
                .orElse(0));
        //The above stream : filters the whole values then multiply the filtered values by 2 then take the first value and return
        //Instead of this if the first occurence which is divisible by 5 is found out multiply it by 2 and return it like above java7 method



        //==========================Efficient Stream============================
        System.out.println("EfficientStream");
        System.out.println("Efficient Stream : "+values.stream()
                                                        .filter(EfficientLazyEvaluationAndTerminationDemo::isDivisible)
                                                        .map(EfficientLazyEvaluationAndTerminationDemo::mapDouble)
                                                        .findFirst()
                                                        .orElse(0));

    }
    public static boolean isDivisible(int i){
        System.out.println("Inside isDivisible");
        return i%5==0;
    }
    public static int mapDouble(int i){
        System.out.println("Inside mapDouble");
        return i*2;
    }
}
