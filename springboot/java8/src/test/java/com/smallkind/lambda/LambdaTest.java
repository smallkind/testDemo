package com.smallkind.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author smallkind
 * @description
 * @create 2017-06-22-09:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LambdaTest {


    @Test
    public void testHiddenFiles(){
        System.out.println(Lambda.hiddenFiles("/Users/admin/Documents/").length);
    }

    @Test
    public void testHiddenFilesByJava8(){
        System.out.println(Lambda.hiddenFilesByJava8("/Users/admin/Documents/").length);
    }

    @Test
    public void testRun(){
      Lambda.process(()-> System.out.println("hello world!"));
    }

    @Test
    public void testprocessFile() throws IOException{
        String oneLine = Lambda.processFile((BufferedReader bufferedReader) -> bufferedReader.readLine());
        System.out.println(oneLine);
        String twoLine = Lambda.processFile((BufferedReader bufferedReader) -> bufferedReader.readLine() + "\n" + bufferedReader.readLine());
        System.out.println(twoLine);
    }

    @Test
    public void testPredicate(){
        List<String> noEmptyList = Lambda.filter(Arrays.asList(new String[]{"a","b","c","","","d"}),
                (String s) -> !s.isEmpty());
        System.out.println(noEmptyList.size());
    }

    @Test
    public void testConsumer(){
        Lambda.forEach(Arrays.asList(new String[]{"a","b","c","","","d"}),
                (String s) -> System.out.println(s));
    }

    @Test
    public void testFunction(){
        List<Integer> list = Lambda.map(Arrays.asList(new String[]{"a","b","c","","","d"}),
                (String s) -> s.length());
        Lambda.forEach(list,
                (Integer i) -> System.out.println(i));

        /** 函数复合 等价于g(f(x)) result:4 **/
        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> g = x -> x * 2;
        Function<Integer,Integer> h = f.andThen(g);
        System.out.println(h.apply(1));

        /** 函数复合 等价于f(g(x)) result:3 **/
        Function<Integer,Integer> f1 = x -> x + 1;
        Function<Integer,Integer> g1 = x -> x * 2;
        Function<Integer,Integer> h1 = f1.compose(g1);
        System.out.println(h1.apply(1));

    }

    @Test
    public void testList(){
        List<Apple> list = Arrays.asList(
                new Apple(80,"green"),
                new Apple(80,"red"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "blue"),
                new Apple(140, "block"),
                new Apple(190, "write"),
                new Apple(120,"red"));
        list.sort(comparing(Apple::getWeight));
        list.forEach(System.out::println);
        list.sort(comparing(Apple::getWeight).reversed());
        list.forEach(System.out::println);
        List<Integer> list1 = list.stream()
                .filter(apple -> apple != null && apple.getWeight() != 0 )
                .map(Apple::getWeight)
                .distinct()
                .collect(toList());
        System.out.println("集合的大小为：" + list1.size());
        for(Integer integer : list1){
            System.out.println(integer);
        }
        List<String> list2 = list.stream()
                .filter(apple -> apple != null && apple.getWeight() != 0 )
                .map((a) -> String.valueOf(a.getWeight()))
                .distinct()
                .collect(toList());
        System.out.println("集合的大小为：" + list1.size());
        for(String string : list2){
            System.out.println(string);
        }
    }

    /**
     * 特殊的void兼容规则：如果一个Lambda的主体是一个表达式，它就和一个返回void的函数描述符兼容
     */
    @Test
    public void testVoid(){
        List<String> list = Arrays.asList(new String[]{"a","b","c","","","d"});
        Predicate<String> p = s -> list.add("aaaa");
        Consumer<String> c = s -> list.add("bbbb");
        System.out.println(p);
        System.out.println(c);
    }

    @Test
    public void testSort(){
        List<String> list = Arrays.asList(new String[]{"a","b","D","X","Y","c"});
        list.sort(String::compareToIgnoreCase);
        list.forEach(System.out::println);
    }

    @Test
    public void testNew(){
        Supplier<Apple> supplier = Apple::new;
        System.out.println(supplier.get());
        Function<Integer,Apple> function = Apple::new;
        System.out.println(function.apply(110));
        BiFunction<Integer,String,Apple> biFunction = Apple::new;
        System.out.println(biFunction.apply(120,"red"));
    }

    @Test
    public void testListToMap(){
        List<Apple> list = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(140, "block"),
                new Apple(190, "write"));
        Map<String,Apple> map = list.stream()
                .collect(Collectors.toMap(apple -> String.valueOf(apple.getWeight()),apple -> apple));
        map.forEach((s, s2) -> System.out.println(s + " " + s2));
    }

    @Test
    public void testFlatMap(){
        List<A> list = Arrays.asList(
                new A("80","90"),
                new A("80","90"),
                new A("150", "160"),
                new A("120", "130"),
                new A("110", "150"),
                new A("", null));
        List<Integer> list1 = list.stream()
                .flatMap(a ->
                        Stream.of(a.getA(),a.getB()).filter(StringUtils::isNotEmpty).map(Integer::valueOf)
                ).distinct()
                .collect(Collectors.toList());
        list1.forEach(System.out::println);
    }

}
