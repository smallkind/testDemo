package com.smallkind.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                .collect(Collectors.toList());
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
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testStream3(){
        List<Dish> list = menu.stream()
                .distinct()
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void testStream4(){
        List<String> list = menu.stream()
                .filter(dish -> dish.getCalories() > 150)
                .map(Dish::getName)
                .limit(3)
                .skip(2)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
