package com.smallkind.lambda;

import java.io.*;

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
}
