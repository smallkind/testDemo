package com.smallkind.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void testListIsEmpty(){
      process(()-> System.out.println("hello world!"));
    }

    public static void process(Runnable r){
        r.run();
    }

    /** 如何利用函数表达式传递Lambda start **/
    @FunctionalInterface
    interface BufferedReaderProcessor{
        String proccess(BufferedReader bufferedReader) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException{
        //Java7带资源的try语句，不需要显示的关闭资源
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\admin\\Desktop\\aa.txt"))) {
            return bufferedReaderProcessor.proccess(bufferedReader);
        }
    }

    @Test
    public void testprocessFile() throws IOException{
        String oneLine = processFile((BufferedReader bufferedReader) -> bufferedReader.readLine());
        System.out.println(oneLine);
        String twoLine = processFile((BufferedReader bufferedReader) -> bufferedReader.readLine() + "\n" + bufferedReader.readLine());
        System.out.println(twoLine);
    }
    /** 如何利用函数表达式传递Lambda end **/

}
