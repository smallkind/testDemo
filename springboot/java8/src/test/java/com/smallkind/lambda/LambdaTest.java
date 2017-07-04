package com.smallkind.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    }

    @Test
    public void testList(){
        List<Apple> list = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(120, "blue"),
                new Apple(140, "block"),
                new Apple(190, "write"),
                new Apple(120,"red"),
                null);
        List<Integer> list1 = list.stream()
                .filter(apple -> apple != null && apple.getWeight() != 0 )
                .map(Apple::getWeight)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("集合的大小为：" + list1.size());
        for(Integer integer : list1){
            System.out.println(integer);
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

}
