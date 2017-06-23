package com.smallkind.lambda;

import java.io.File;
import java.io.FileFilter;

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

}
