package com.smallkind.lambda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author smallkind
 * @description
 * @create 2017-06-22-09:18
 */
public class Lambda {

    /**
     * 获取隐藏文件
     * @param filePath
     * @return
     */
    public static File[] hiddenFiles(String filePath){
        File[] files = new File(filePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        return files;
    }

    public static File[] hiddenFilesByJava8(String filePath){
        return new File(filePath).listFiles(File::isHidden);
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
    /** 如何利用函数表达式传递Lambda end **/

    /**
     * Predicate 接受泛型T，返回Boolean
     * boolean test(T t)
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> results = new ArrayList<>();
        for(T t : list){
            if(predicate.test(t)){
                results.add(t);
            }
        }
        return results;
    }

    /**
     * Consumer 接受泛型T，返回void
     * void accept(T t)
     * @param list
     * @param consumer
     * @param <T>
     */
    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        for(T t : list){
            consumer.accept(t);
        }
    }

    /**
     * Function 接受泛型T，返回泛型R
     * R apply(T t)
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> results = new ArrayList<>();
        for(T t : list){
            results.add(function.apply(t));
        }
        return results;
    }

}
