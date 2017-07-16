package com.smallkind.java8.lambda;

/**
 * @author smallkind
 * @description
 * @create 2017-07-04-08:56
 */
public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(){

    }

    public Apple(int weight){
        this.weight = weight;
    }

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
