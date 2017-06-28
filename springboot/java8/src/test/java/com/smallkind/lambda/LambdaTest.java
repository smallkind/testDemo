package com.smallkind.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileReader;
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
        System.out.println(Lambda.hiddenFiles("/Users/zhouxiang/Documents/").length);
    }

    @Test
    public void testHiddenFilesByJava8(){
        System.out.println(Lambda.hiddenFilesByJava8("/Users/zhouxiang/Documents/").length);
    }

    @Test
    public void testListIsEmpty(){
      process(()-> System.out.println("hello world!"));
    }

    public static void process(Runnable r){
        r.run();
    }

    @Test
    public void testTry(){
        //Java7带资源的try语句，不需要显示的关闭资源
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\test\\测试.pdf"))) {
            bufferedReader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
