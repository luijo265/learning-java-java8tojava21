import functional.Evaluate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalLearn {
    public static void main(String[] args) {

        // Evaluando predicates
//        evaluatePredicate();

        // Evaluando BiPredicate
//        evaluateBiPredicate();

//        evaluateSupplier();

//        consumerAndBiConsumer();

        functionAndBiFunction();

    }

    private static void functionAndBiFunction() {

        Function<String, Integer> sizeWord = str -> str.length();
        BiFunction<String, String, String> concatWords = (str1, str2) -> str1.concat(" ").concat(str2);

        System.out.println(sizeWord.apply("Luis"));
        System.out.println(concatWords.apply("Dayana", "Bonilla"));

    }


    private static void consumerAndBiConsumer() {

        System.out.println("Example Consumer");
        Consumer<String> printCity = (city) -> System.out.println(city);
        List<String> cities = new ArrayList<>();
        cities.add("Caracas");
        cities.add("Cali");
        cities.forEach(printCity);

        System.out.println("\nExample BiConsumer");
        Map<String, String> capitals = new HashMap<>();
        BiConsumer<String, String> mapCapitals = (state, capital) -> capitals.put(state, capital);
        mapCapitals.accept("Valle del cauca", "Cali");
        mapCapitals.accept("Distrito Capital", "Caracas");
        BiConsumer<String, String> printCapitals = (state, capital) -> System.out.println(state+" :"+capital);
        capitals.forEach(printCapitals);

    }

    public static void evaluateSupplier(){
        Supplier<LocalTime> getTime = () -> LocalTime.now();
        System.out.println("This is the time: "+ getTime.get());
    }

    public static void evaluateBiPredicate(){
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 5));
    }

    public static void evaluatePredicate(){
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: "+lambda.isNegative(-1));
        System.out.println("Evaluate: "+lambda.isNegative(1));

        int x = 4;
        System.out.println("Is "+x+" even? "+check(x, n -> n % 2 == 0));
        x = 7;
        System.out.println("Is "+x+" even? "+check(x, n -> n % 2 == 0));

    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}