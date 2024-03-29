import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodReferenceLearn {

    public static void main(String[] args) {
//        boundMethodReference();
//        unboubdMethodReference();
//        staticMethodReference();
        constructoMethodReference();
    }

    private static void constructoMethodReference() {
        Function<Integer, List<String>> getListN = size -> new ArrayList<>(size);
        Function<Integer, List<String>> getListCR = ArrayList::new;

        List<String> list1 = getListN.apply(2);
        list1.add("Luis");
        List<String> list2 = getListCR.apply(3);
        list2.add("Dayana");
        list1.forEach(System.out::println);
        list2.forEach(System.out::println);

    }

    private static void staticMethodReference() {

        // It's considered an unboundMethodReference, but the difference is this use a static method of a class
        Consumer<List<Integer>> orderN = list -> Collections.sort(list);
        Consumer<List<Integer>> orderSR = Collections::sort;

        List<Integer> numbers1 = Arrays.asList(5,9,3,1,6,8);
        orderN.accept(numbers1);
        numbers1.forEach(System.out::println);

        List<Integer> numbers2 = Arrays.asList(15,1,5,2,9);
        orderSR.accept(numbers2);
        numbers2.forEach(System.out::println);

    }

    private static void unboubdMethodReference() {
        // It's coming object, then use a method of the class of that object
        Function<String, String> upperCaseN = str -> str.toUpperCase();
        Function<String, String> upperCaseUR = String::toUpperCase;
        System.out.println("Normal reference (Function): "+ upperCaseN.apply("Briceño"));
        System.out.println("Undound reference (Function): "+ upperCaseUR.apply("Bonilla"));

        BiFunction<String, String, String> concatN = (str1, str2) -> str1.concat(str2);
        BiFunction<String, String, String> concatUR = String::concat;
        System.out.println("Normal reference (BiFunction): "+ concatN.apply("Briceño", " Hidalgo"));
        System.out.println("Undound reference (BiFunction): "+ concatUR.apply("Bonilla", " Mosquera"));
    }

    private static void boundMethodReference() {
        // Over an instance or object, get a method with the result expected
        String name = "Luis Briceño";

        Supplier<String> lowerN = () -> name.toLowerCase();
        Supplier<String> lowerBR = name::toLowerCase;
        System.out.println("Normal reference (suppier): " + lowerN.get());
        System.out.println("Bound reference (suppier): " + lowerBR.get());

        Predicate<String> startWithN = (fragment) -> name.startsWith(fragment);
        Predicate<String> startWithBR = name::startsWith;
        System.out.println("Normal reference (predicate): " + startWithN.test("Lu"));
        System.out.println("Bound reference (predicate): " + startWithBR.test("Br"));


    }

}
