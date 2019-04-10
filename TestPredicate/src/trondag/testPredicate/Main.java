package trondag.testPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static trondag.testPredicate.IntegerPrediactes.positivIntPredicate;

public class Main {

    public static void main(String[] args) {
        List<Integer> tall = Arrays.asList(-1, 4, 35, -43, -98, 54, 3, -9, 5, 8, -11);
        List<Integer> filtrerteTall = getFilterenNumber(tall, positivIntPredicate);
        filtrerteTall.forEach(System.out::println);
    }

    public static List<Integer> getFilterenNumber(List<Integer> tall, Predicate<Integer> integerPredicate) {
        List<Integer> filtrerteTall = new ArrayList<Integer>();
        for (Integer i : tall){
            if (integerPredicate.test(i)){
                filtrerteTall.add(i);
            }
        }
        return filtrerteTall;
    }
}
