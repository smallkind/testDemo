package com.smallkind.lambda;

/**
 * @author smallkind
 * @description
 * @create 2017-07-07-09:26
 */
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    public Dish(String name, boolean vegetarian, int calories, Type type) { this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (vegetarian != dish.vegetarian) return false;
        if (calories != dish.calories) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        return type == dish.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (vegetarian ? 1 : 0);
        result = 31 * result + calories;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public enum Type { MEAT, FISH, OTHER }
}
