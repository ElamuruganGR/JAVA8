package workout;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WorkOut {

    public static void main(String[] args) {
//        System.out.println("Workout");
        String s = "Hello, How are you? Hello Welcome";
        int size = s.split("Hello").length;
        Map<String, Integer> map = new HashMap();
        map.put("Hello", size-1);



    }
}
