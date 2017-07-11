package com.smallkind.lambda;

/**
 * @author smallkind
 * @description
 * @create 2017-07-11-09:43
 */
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (year != that.year) return false;
        if (value != that.value) return false;
        return trader != null ? trader.equals(that.trader) : that.trader == null;
    }

    @Override
    public int hashCode() {
        int result = trader != null ? trader.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
