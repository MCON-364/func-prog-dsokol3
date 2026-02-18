package edu.touro.las.mcon364.func_prog.exercises;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Functional Interface Practice
 *
 * In this assignment you will:
 *  - Create and return different functional interfaces
 *  - Apply them
 *  - Practice chaining where appropriate
 *
 * IMPORTANT:
 *  - Use lambdas
 *  - Do NOT use anonymous classes
 */
public class FunctionalInterfaceExercises {

    // =========================================================
    // PART 1 — SUPPLIERS
    // =========================================================

    /**
     * 1) Create a Supplier that returns the current year.
     *
     * Hint:
     * You can get the current date using:
     *     LocalDate.now()
     *
     * Then extract the year using:
     *     getYear()
     *
     * Example (not the solution):
     *
     */
    public static Supplier<Integer> currentYearSupplier() {
        Supplier<String> dateSupplier = () -> LocalDate.now().getYear()+"";
        return () -> Integer.parseInt(dateSupplier.get());

    }

    /**
     * 2) Create a Supplier that generates a random number
     * between 1 and 100.
     */
    public static Supplier<Integer> randomScoreSupplier() {
        Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random()*100);
        return randomNumberSupplier;
    }

    // =========================================================
    // PART 2 — PREDICATES
    // =========================================================

    /**
     * 3) Create a Predicate that checks whether
     * a string is all uppercase.
     */
    public static Predicate<String> isAllUpperCase() {
        Predicate<String> isAllUpperCase = s -> s.equals(s.toUpperCase());
        return isAllUpperCase;
    }

    /**
     * 4) Create a Predicate that checks whether
     * a number is positive AND divisible by 5.
     *
     * Hint: consider chaining.
     */
    public static Predicate<Integer> positiveAndDivisibleByFive() {
        return num -> (num % 2 == 0 && num % 5 == 0);
    }

    // =========================================================
    // PART 3 — FUNCTIONS
    // =========================================================

    /**
     * 5) Create a Function that converts
     * a temperature in Celsius to Fahrenheit.
     *
     * Formula: F = C * 9/5 + 32
     */
    public static Function<Double, Double> celsiusToFahrenheit() {
        return c -> c * 9/5 + 32;
    }

    /**
     * 6) Create a Function that takes a String
     * and returns the number of vowels in it.
     *
     * Bonus: Make it case-insensitive.
     */
    public static Function<String, Integer> countVowels() {
        String vowels = "aeiou";

        Function<String, Integer> countFunction = s -> {
            int count = 0;
            s = s.toLowerCase();

            for (char c : s.toCharArray()) {
                if (vowels.indexOf(c) != -1) {
                    count++;
                }
            }
            return count;
        };

        return countFunction;
    }

    // =========================================================
    // PART 4 — CONSUMERS
    // =========================================================

    /**
     * 7) Create a Consumer that prints a value
     * surrounded by "***"
     *
     * Example output:
     * *** Hello ***
     */
    public static Consumer<String> starPrinter() {
        Consumer<String> starPrinter = s -> System.out.println("*** " + s + " ***");
        return null;
    }

    /**
     * 8) Create a Consumer that prints the square
     * of an integer.
     */
    public static Consumer<Integer> printSquare() {
        Consumer<Integer> squarePrinter = num -> System.out.println(num * num);
        return null;
    }

    // =========================================================
    // PART 5 — APPLYING FUNCTIONAL INTERFACES
    // =========================================================

    /**
     * 9) Apply:
     *  - A Predicate
     *  - A Function
     *  - A Consumer
     *
     * Process the list as follows:
     *  - Keep only strings longer than 3 characters
     *  - Convert them to lowercase
     *  - Print them
     */
    public static void processStrings(List<String> values) {
        Predicate<String> isLongerThan3 = s -> s.length() > 3;
        Function<String, String> toLowerCase = s -> s.toLowerCase();
        Consumer<String> print = s -> System.out.println(s);


    }

    /**
     * 10) Apply:
     *  - A Supplier
     *  - A Predicate
     *  - A Consumer
     *
     * Generate 5 random scores.
     * Print only those above 70.
     */
    public static void generateAndFilterScores() {
        Supplier<Integer> randomScoreSupplier = randomScoreSupplier();
        Predicate<Integer> above70 = num -> num > 70;
        Consumer<Integer> print = num -> System.out.println(num);
    }
}
