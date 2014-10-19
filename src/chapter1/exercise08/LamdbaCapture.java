package chapter1.exercise08;

import java.util.ArrayList;
import java.util.List;

public class LamdbaCapture {
    public static void main(String[] args) {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();

        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        
        /*
         * The under codes could not be compiled, because variable i is not final variable.
        for (int i = 0; i < names.length; i++) {
            runners.add(() -> System.out.println(names[i]));
        }
        */
        
    }
}
