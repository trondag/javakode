package trondag.testPredicate;

import java.util.function.Predicate;

public class IntegerPrediactes {
    public static Predicate<Integer> positivIntPredicate = new Predicate<Integer>() {
        public boolean test(Integer i1){
            return i1 > 0;
        }
    };
}
