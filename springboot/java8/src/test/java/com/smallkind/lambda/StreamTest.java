package com.smallkind.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * @author smallkind
 * @description
 * @create 2017-07-07-09:43
 */
public class StreamTest {

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    @Test
    public void testStream1() {
        List<String> list = menu.stream()
                .filter(dish -> dish.getCalories() > 150)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream2() {
        List<String> list = menu.stream()
                .filter(dish -> {
                    System.out.println("filter:" + dish.getName());
                    return dish.getCalories() > 150;
                })
                .map(dish -> {
                    System.out.println("map:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(list);
    }

    @Test
    public void testStream3() {
        List<Dish> list = menu.stream()
                .distinct()
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream4() {
        List<String> list = menu.stream()
                .filter(dish -> dish.getCalories() > 150)
                .map(Dish::getName)
                .limit(3)
                .skip(2)
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream5() {
        List<String> strings = Arrays.asList("hello", "world");
        List<String> list = strings.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream6() {
        List<Integer> list = Arrays.asList(1, 4, 6);
        List<Integer> list1 = Arrays.asList(3, 5);
        List<Integer[]> list2 = list.stream()
                .flatMap(integer -> list1.stream()
                        .map(integer1 -> new Integer[]{integer, integer1}))
                .collect(toList());
        list2.forEach(System.out::println);
    }

    @Test
    public void testStream7() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);

        boolean isHealthy1 = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy1);

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();
        System.out.println(firstSquareDivisibleByThree);
    }

    @Test
    public void testStream8() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("The sum is " + sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("The product is " + product);

        Optional<Integer> sum1 = numbers.stream().reduce((a, b) -> (a + b));
        System.out.println(sum1);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("The max is " + max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("The min is " + min);
    }

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );


    @Test
    public void testStream9() {
        List<Transaction> list = transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        list.forEach(System.out::println);

        List<String> cities = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        cities.forEach(System.out::println);

        List<Trader> traders = transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        traders.forEach(System.out::println);

        String traderStr = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println(traderStr);

        transactions
                .stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Optional<Integer> highestValue = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue);

        Optional<Integer> minValue = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(minValue);
    }

    @Test
    public void testStream10() {
        int calories = menu
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);

        OptionalInt maxCalories = menu
                .stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(-1);
        System.out.println(max);

        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        IntStream evenNumbers1 = IntStream.range(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNumbers1.count());

        java.util.stream.Stream<int[]> pythagoreanTriples = IntStream
                .rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream
                        .rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        java.util.stream.Stream<double[]> pythagoreanTriples2;
        pythagoreanTriples2 = IntStream
                .rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                );
        pythagoreanTriples2.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }

    @Test
    public void testStream11() {
        java.util.stream.Stream
                .iterate(0, integer -> integer + 2)
                .limit(10)
                .forEach(System.out::println);

        java.util.stream.Stream
                .iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(20)
                .forEach(ints -> System.out.println(ints[0] + " " + ints[1]));

        java.util.stream.Stream
                .iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .map(ints -> ints[0])
                .limit(20)
                .forEach(System.out::println);

        java.util.stream.Stream
                .generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void testStream12() {
        Map<Integer, List<Transaction>> currencyListMap = transactions
                .stream()
                .collect(groupingBy(Transaction::getYear));
        currencyListMap.forEach((integer, transactions1) -> System.out.println(integer + " " + transactions1.toString()));

        long count = menu.stream().collect(counting());
        long count1 = menu.stream().count();
        System.out.println(count + " " + count1);

        Optional<Dish> dish = menu
                .stream()
                .collect(minBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(dish.toString());

        Optional<Dish> dish1 = menu
                .stream()
                .collect(maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(dish1.toString());

        int caloriesSum = menu
                .stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println(caloriesSum);

        double average = menu
                .stream()
                .collect(averagingDouble(Dish::getCalories));
        System.out.println(average);

        IntSummaryStatistics intSummaryStatistics = menu
                .stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);
    }

    @Test
    public void testStream13(){
        List<Apple> list = Arrays.asList(
                new Apple(80,"green"),
                new Apple(80,"red"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "blue"),
                new Apple(140, "block"),
                new Apple(190, "write"),
                new Apple(120,"red"));

        List<Apple> apples = list
                .stream()
                .map(apple -> {
                    if(apple.getColor().equals("red")) {
                        apple.setWeight(100);
                    }
                    return apple;
                })
                .collect(toList());
        apples.forEach(System.out::println);
    }

    @Test
    public void testStream14(){
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);

        int totalCalories = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(mostCalorieDish);
    }

}
