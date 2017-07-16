package com.smallkind.java8.lambda;

/**
 * @author smallkind
 * @description
 * @create 2017-07-07-09:27
 */
public class StringUtils {

    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }

    public static boolean isEmpty(String s){
        if(s == null)
            return true;
        if(s.trim().equals(""))
            return true;
        return false;
    }
}
