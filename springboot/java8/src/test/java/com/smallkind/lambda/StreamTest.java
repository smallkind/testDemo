package com.smallkind.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
    public void testStream1(){
        List<String> list = menu.stream()
                .filter(dish -> dish.getCalories() > 150)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream2(){
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
    public void testStream3(){
        List<Dish> list = menu.stream()
                .distinct()
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream4(){
        List<String> list = menu.stream()
                .filter(dish -> dish.getCalories() > 150)
                .map(Dish::getName)
                .limit(3)
                .skip(2)
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream5(){
        List<String> strings = Arrays.asList("hello","world");
        List<String> list = strings.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream6(){
        List<Integer> list = Arrays.asList(1,4,6);
        List<Integer> list1 = Arrays.asList(3,5);
        List<Integer[]> list2 = list.stream()
                .flatMap(integer -> list1.stream()
                .map(integer1 -> new Integer[]{integer,integer1}))
                .collect(toList());
        list2.forEach(System.out::println);
    }

    @Test
    public void testStream7(){
        if(menu.stream().anyMatch(Dish::isVegetarian)){
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
    public void testStream8(){
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
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );


}
