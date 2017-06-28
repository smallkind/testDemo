package com.smallkind.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;

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


}
